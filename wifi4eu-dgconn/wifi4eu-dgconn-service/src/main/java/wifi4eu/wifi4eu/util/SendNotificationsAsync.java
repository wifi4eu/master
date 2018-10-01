package wifi4eu.wifi4eu.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherAssignmentAuxiliarDTO;
import wifi4eu.wifi4eu.common.enums.SelectionStatus;
import wifi4eu.wifi4eu.common.enums.VoucherAssignmentStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.mapper.application.ApplicationMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.service.admin.AdminActionsService;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.voucher.VoucherService;

import javax.validation.Valid;

/**
 * Created by rgarcita on 11/02/2017.
 */
@Component
@Scope("prototype")
public class SendNotificationsAsync implements Runnable {

	@Autowired
	private CallService callService;

	@Autowired
	private UserService userService;

	@Autowired
	private VoucherService voucherService;

	@Autowired
	private VoucherAssignmentRepository voucherAssignmentRepository;

	@Autowired
	private ApplicationMapper applicationMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MailService mailService;

	@Autowired
    private AdminActionsRepository adminActionsRepository;

	public final static String FROM_ADDRESS = "no-reply@wifi4eu.eu";
	public final static String NO_ACTION = "NO ACTION LOGGED";

	private final Logger _log = LogManager.getLogger(SendNotificationsAsync.class);

	private UserDTO userConnected;

	private Integer callId;

	public SendNotificationsAsync(Integer callId, UserDTO userConnected) {
		this.userConnected = userConnected;
		this.callId = callId;
	}

    @Override
	public void run() {
	    AdminActions adminActions = null;
		try {

		    adminActions = adminActionsRepository.findOneByAction("voucher_send_notifications");
		    if(Validator.isNull(adminActions)){
		        adminActions = new AdminActions();
		        adminActions.setAction("voucher_send_notifications");
		        adminActions.setStartDate(new Date());
		        adminActions.setRunning(true);
		        adminActions.setUser(userMapper.toEntity(userConnected));
				adminActions = adminActionsRepository.save(adminActions);
            }
            else{
		    	if(adminActions.isRunning()){
                    throw new AppException("Send notifications is already running");
				}
                adminActions.setStartDate(new Date());
                adminActions.setRunning(true);
                adminActions.setEndDate(null);
                adminActions.setUser(userMapper.toEntity(userConnected));
                adminActions = adminActionsRepository.save(adminActions);
			}

			CallDTO callDTO = callService.getCallById(callId);
			if (Validator.isNull(callDTO)) {
				_log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Call does not exist with id "
						+ callId);
				throw new AppException("Call not found with id: " + callId);
			}
			long currentTime = new Date().getTime();
			if (!(callDTO.getStartDate() < currentTime && callDTO.getEndDate() < currentTime)) {
				_log.error("ECAS Username: " + userConnected.getEcasUsername()
						+ " - Beneficiaries are only to be notified if the call has been closed. CallId:" + callId);
				throw new AppException(
						"Beneficiaries are only to be notified if the call has been closed. CallId:" + callId);
			}
			List<ApplicationDTO> successfulApplicants;
			List<ApplicationDTO> reserveApplicants;
			List<ApplicationDTO> unsuccessfulApplicants = new ArrayList<>();
			VoucherAssignmentAuxiliarDTO finalVoucherAssignment = voucherService
					.getVoucherAssignmentByCallAndStatus(callId, VoucherAssignmentStatus.FREEZE_LIST.getValue());

			if (Validator.isNull(finalVoucherAssignment)) {
				throw new AppException(
						"Notification could not be sent because there's no freeze list for call with id : " + callId);
			}

			successfulApplicants = applicationMapper.toDTOList(
					applicationRepository.getApplicationsSelectedInVoucherAssignment(finalVoucherAssignment.getId(),
							SelectionStatus.SELECTED.getValue()));
			reserveApplicants = applicationMapper.toDTOList(
					applicationRepository.getApplicationsSelectedInVoucherAssignment(finalVoucherAssignment.getId(),
							SelectionStatus.RESERVE_LIST.getValue()));
			unsuccessfulApplicants.addAll(
					applicationMapper.toDTOList(applicationRepository.getApplicationsSelectedInVoucherAssignment(
							finalVoucherAssignment.getId(), SelectionStatus.REJECTED.getValue())));
			unsuccessfulApplicants.addAll(applicationMapper.toDTOList(applicationRepository
					.getApplicationsNotSelectedInVoucherAssignment(callDTO.getId(), finalVoucherAssignment.getId())));

			Locale locale = new Locale(UserConstants.DEFAULT_LANG);
			String subject;
			String msgBody;

			for (ApplicationDTO successfulApplicant : successfulApplicants) {
				RegistrationDTO registrationDTO = registrationService
						.getRegistrationById(successfulApplicant.getRegistrationId());

				if(Validator.isNotNull(registrationDTO)){
					UserDTO userDTO = userMapper
							.toDTO(userRepository.findMainUserFromRegistration(registrationDTO.getId()));

					if(Validator.isNotNull(userDTO)){
                        if (Validator.isNotNull(userDTO.getLang())) {
                            locale = new Locale(userDTO.getLang());
                        }

                        String additionalInfoUrl = userService.getBaseUrl() + "beneficiary-portal/my-voucher";
                        MailData mailData = MailHelper.buildMailVoucherApplySuccessful(
                            userDTO.getEmail(), MailService.FROM_ADDRESS, 
                            callDTO.getEvent(), additionalInfoUrl, registrationDTO.getMunicipalityId(), "send_notification", locale);
                        mailService.sendMail(mailData, true);

                    }
				}
				
			}
			_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sended to "
					+ successfulApplicants.size() + " successful applicants");

			for (ApplicationDTO reserveApplicant : reserveApplicants) {
				RegistrationDTO registrationDTO = registrationService
						.getRegistrationById(reserveApplicant.getRegistrationId());

				if(Validator.isNotNull(registrationDTO)){
					UserDTO userDTO = userMapper
							.toDTO(userRepository.findMainUserFromRegistration(registrationDTO.getId()));

                    if(Validator.isNotNull(userDTO)){
                        if (Validator.isNotNull(userDTO.getLang())) {
                            locale = new Locale(userDTO.getLang());
                        }
                        String additionalInfoUrl = userService.getBaseUrl();
                        MailData mailData = MailHelper.buildMailVoucherApplyReserved(
                            userDTO.getEmail(), MailService.FROM_ADDRESS, 
                            callDTO.getEvent(), additionalInfoUrl, registrationDTO.getMunicipalityId(), "send_notification", locale);
                        mailService.sendMail(mailData, true);
                    }
				}
			}
			_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sended to "
					+ reserveApplicants.size() + " reserve applicants");

			for (ApplicationDTO unsuccessfulApplicant : unsuccessfulApplicants) {
				RegistrationDTO registrationDTO = registrationService
						.getRegistrationById(unsuccessfulApplicant.getRegistrationId());

				if(Validator.isNotNull(registrationDTO)){
					UserDTO userDTO = userMapper
							.toDTO(userRepository.findMainUserFromRegistration(registrationDTO.getId()));

                    if(Validator.isNotNull(userDTO)) {
                        if (Validator.isNotNull(userDTO.getLang())) {
                            locale = new Locale(userDTO.getLang());
                        }
                        
                        boolean invalidSupportingDocuments = (unsuccessfulApplicant.getInvalidateReason() != null 
                            && !unsuccessfulApplicant.getInvalidateReason().isEmpty());

                        MailData mailData = MailHelper.buildMailVoucherApplyUnsuccessful(
                            userDTO.getEmail(), MailService.FROM_ADDRESS, 
                            callDTO.getEvent(), invalidSupportingDocuments, registrationDTO.getMunicipalityId(), "send_notification", locale);
                        mailService.sendMail(mailData, true);
                    }
				}
			}
			_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Email sended to "
					+ unsuccessfulApplicants.size() + " unsuccessful applicants");

			Date date = new Date();
			VoucherAssignment voucherAssignment = voucherAssignmentRepository
					.findByCallIdAndStatusEquals(callDTO.getId(), VoucherAssignmentStatus.FREEZE_LIST.getValue());
			voucherAssignment.setNotifiedDate(date.getTime());
			voucherAssignmentRepository.save(voucherAssignment);
			adminActions.setRunning(false);
			adminActions.setEndDate(date);
			adminActionsRepository.save(adminActions);
		} catch (FatalBeanException fbe){
            _log.error("It seems that Spring context is not available", fbe.getMessage());
		} catch (Exception ex) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot send the message",
					ex.getMessage());
            if(Validator.isNotNull(adminActions)){
                adminActions.setAction("voucher_send_notifications");
                adminActions.setStartDate(null);
                adminActions.setRunning(false);
                adminActions.setEndDate(null);
                adminActions.setUser(userMapper.toEntity(userConnected));
                adminActionsRepository.save(adminActions);
            }
		}
	}

}
