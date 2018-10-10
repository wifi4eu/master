package wifi4eu.wifi4eu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.voucher.VoucherAssignment;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherAssignmentRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherSimulationRepository;
import wifi4eu.wifi4eu.service.admin.AdminActionsService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@PropertySource("classpath:env.properties")
@EnableScheduling
@Controller
public class ScheduledTasks {
	
    private static final Logger _log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Value("${rabbitmq.host}")
    private String rabbitMQHost;

    @Value("${rabbitmq.username}")
    private String rabbitUsername;

    @Value("${rabbitmq.password}")
    private String rabbitPassword;

    @Autowired
    private VoucherAssignmentRepository voucherAssignmentRepository;

    @Autowired
    private VoucherSimulationRepository voucherSimulationRepository;

    @Autowired
    private GrantAgreementRepository grantAgreementRepository;

    @Autowired
    private RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    private GrantAgreementUtils grantAgreementUtils;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private AzureBlobConnector azureBlobConnector;

    @Autowired
    private AdminActionsService adminActionsService;

    @Scheduled(cron = "0 0 4 * * *", zone = "Europe/Madrid")
    public void sendMessageNotSigned() {
        _log.debug("SCHEDULED TASK: Reminder email for users who haven't signed after 7 or 14 days before the notification date - START");
        ArrayList<VoucherAssignment.VoucherAssignmentGetIdAndNotificationDate> voucherAssignment = voucherAssignmentRepository.findByNotifiedDateNotNull();
        LocalDate localCurrentDate = dateUtils.getLocalTimeFromDate(new Date());
        LocalDate notifiedDate;
        for (int i = 0; i < voucherAssignment.size(); i++) {
            notifiedDate = dateUtils.getLocalTimeFromDate(new Date(voucherAssignment.get(i).getNotifiedDate()));
            long days = ChronoUnit.DAYS.between(localCurrentDate, notifiedDate);
            if (days == -7 || days == -14) {
                ArrayList<Integer> applicationIds = null;
                applicationIds = voucherSimulationRepository.findApplicationIdsFromVoucherAssignmentAndSelectionStatus(voucherAssignment.get(i).getId());
                if (applicationIds != null) {
                    for (int j = 0; j < applicationIds.size(); j++) {
                        if (grantAgreementRepository.countByApplicationId(applicationIds.get(j)) <= 0) {
                            String emailUser = registrationUsersRepository.findContactEmailFromApplicationId(applicationIds.get(j));
                            Integer userId = registrationUsersRepository.findUserIdFromApplicationId(applicationIds.get(j));
                            grantAgreementUtils.sendEmailSignPdfNotified(userId, emailUser, days);
                        }
                    }
                }
            }
        }

        _log.debug("SCHEDULED TASK: Reminder email for users who haven't signed after 7 or 14 days before the notification date - FINISH");
    }

    @Scheduled(cron = "0 0 23 * * ?", zone = "Europe/Madrid")
    public void cleanExportExcels() {
        _log.debug("SCHEDULED TASK: Clean export excels from azure blob storage every day at 23pm - START");
        List<AdminActionsDTO> adminActions = adminActionsService.getByActionsByName("export_municipality_applications");
        for (AdminActionsDTO adminActionDTO: adminActions) {
            if (!adminActionDTO.isRunning()) {
                if (Validator.isNotNull(adminActionDTO.getData()) && !adminActionDTO.getData().isEmpty()) {
                    boolean deleted = azureBlobConnector.deleteExportExcel(adminActionDTO.getData());
                    if (deleted) {
                        adminActionDTO.setData(null);
                        adminActionsService.updateAdminAction(adminActionDTO);
                    }
                }
            }
        }
        _log.debug("SCHEDULED TASK: Clean export excels from azure blob storage every day at 23pm - FINISH");
    }

}
