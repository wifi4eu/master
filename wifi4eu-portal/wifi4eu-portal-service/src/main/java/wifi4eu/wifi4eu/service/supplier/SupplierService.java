package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.SupplierValidator;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import wifi4eu.wifi4eu.repository.supplier.SupplierNotificationEmailRepository;
import wifi4eu.wifi4eu.entity.supplier.SupplierNotificationEmail;

import java.text.MessageFormat;
import java.util.*;

@Service("portalSupplierService")
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SuppliedRegionMapper suppliedRegionMapper;

    @Autowired
    SuppliedRegionRepository suppliedRegionRepository;

    @Autowired
    UserService userService;

    @Autowired
    NutsService nutsService;

    @Autowired
    ThreadService threadService;

    @Autowired
    UserThreadsService userThreadsService;

    @Autowired
    MailService mailService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    CallService callService;

    @Autowired
    ApplicationService applicationService;
    
    @Autowired
    SupplierNotificationEmailRepository supplierNotificationEmailRepository;

    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(int supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

    public SupplierDTO getSupplierDetailsById(int supplierId) {
        SupplierDTO supplierDetails = supplierMapper.toDTO(supplierRepository.findOne(supplierId)); 
        supplierDetails.setAccountNumber(null);
        supplierDetails.setBic(null);
        supplierDetails.setLang(null);
        supplierDetails.setLegalFile1(null);
        supplierDetails.setLegalFile2(null);
        return supplierDetails;  
    }

    @Transactional
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
        if (userDTO != null) {
            if (supplierDTO.getId() == 0) {
                Integer supplierId = supplierDTO.getId();
                List<SuppliedRegionDTO> originalRegions = supplierDTO.getSuppliedRegions();
                List<SuppliedRegionDTO> correctRegions = new ArrayList<>();
                supplierDTO.setSuppliedRegions(null);
                supplierDTO = supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
                supplierId = supplierDTO.getId();

                for (SuppliedRegionDTO region : originalRegions) {
                    region.setSupplierId(supplierId);
                    correctRegions.add(region);
                }
                supplierDTO.setSuppliedRegions(correctRegions);
                return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));

            } else {
                return null;
            }
        }
        return null;
    }


    @Transactional
    public SupplierDTO updateContactDetails(SupplierDTO supplierDTO, String contactName, String contactSurname, String contactPhonePrefix, String contactPhoneNumber) {
        supplierDTO.setContactName(contactName);
        supplierDTO.setContactSurname(contactSurname);
        supplierDTO.setContactPhonePrefix(contactPhonePrefix);
        supplierDTO.setContactPhoneNumber(contactPhoneNumber);

        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    @Transactional
    public SupplierDTO updateSupplierDetails(SupplierDTO supplierDTO, String name, String address, String vat, String bic, String logo) {
      supplierDTO.setName(name);
      supplierDTO.setAddress(address);
      supplierDTO.setVat(vat);
      supplierDTO.setBic(bic);
      supplierDTO.setLogo(logo);
      return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    /* OLD ONE
        @Transactional
        public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
            if (supplierDTO.getSuppliedRegions().isEmpty()) {
                return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
            } else {
                Integer supplierId = supplierDTO.getId();
                List<SuppliedRegionDTO> originalRegions = supplierDTO.getSuppliedRegions();
                List<SuppliedRegionDTO> correctRegions = new ArrayList<>();
                if (supplierId == 0) {
                    supplierDTO.setSuppliedRegions(null);
                    supplierDTO = supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
                    supplierId = supplierDTO.getId();
                }
                for (SuppliedRegionDTO region : originalRegions) {
                    region.setSupplierId(supplierId);
                    correctRegions.add(region);
                }
                supplierDTO.setSuppliedRegions(correctRegions);
                return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
            }
        }
    */
    
    @Transactional
    public SupplierDTO deleteSupplier(int supplierId) {
        //TODO: change to a soft delete
        SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRepository.findOne(supplierId));
        if (supplierDTO != null) {
            supplierRepository.delete(supplierMapper.toEntity(supplierDTO));
            return supplierDTO;
        } else {
            return null;
        }
    }

    public List<SuppliedRegionDTO> getAllSuppliedRegions() {
        return suppliedRegionMapper.toDTOList(Lists.newArrayList(suppliedRegionRepository.findAll()));
    }

    @Transactional
    public SupplierDTO submitSupplierRegistration(SupplierDTO supplierDTO) throws Exception {

        UserDTO userDTO;

        SupplierValidator.validateSupplier(supplierDTO);

        UserContext userContext = UserHolder.getUser();

        if (userContext != null) {
            // with ECAS
            userDTO = userService.getUserByUserContext(userContext);
        } else {
            // without ECAS (only testing purpose)
            userDTO = new UserDTO();
            String password = "12345678";
            userDTO.setPassword(password);
        }

        userDTO.setName(supplierDTO.getContactName());
        userDTO.setSurname(supplierDTO.getContactSurname());
        userDTO.setEmail(supplierDTO.getContactEmail());
        userDTO.setCreateDate(new Date().getTime());
        userDTO.setType(1);
        userDTO.setVerified(false);
        userDTO.setLang(supplierDTO.getLang());
        userDTO = userService.saveUserChanges(userDTO);
        userService.sendActivateAccountMail(userDTO);
        supplierDTO.setUserId(userDTO.getId());
        supplierDTO = createSupplier(supplierDTO);
        return supplierDTO;
    }

    public SupplierDTO getSupplierByUserId(int userId) {
        return supplierMapper.toDTO(supplierRepository.findByUserId(userId));
    }

    public List<SupplierDTO> getSuppliersByVat(String vat) {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findByVat(vat)));
    }

    public List<SupplierDTO> getSuppliersByAccountNumber(String accountNumber) {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findByAccountNumber(accountNumber)));
    }

    @Cacheable(value = "portalGetSuppliedRegionsCountGroupedByRegionId")
    public List<Object> getSuppliedRegionsCountGroupedByRegionId() {
        return Lists.newArrayList(suppliedRegionRepository.findSuppliedRegionsCountGroupedByRegionId());
    }

    public List<SupplierDTO> findSimilarSuppliers(int supplierId) {
        List<SupplierDTO> similarSuppliers = new ArrayList<>();
        SupplierDTO originalSupplier = getSupplierById(supplierId);
        if (originalSupplier != null) {
            List<SupplierDTO> suppliersVat = getSuppliersByVat(originalSupplier.getVat());
            for (SupplierDTO suppVat : suppliersVat) {
                if (suppVat.getId() != originalSupplier.getId()) {
                    similarSuppliers.add(suppVat);
                }
            }
            List<SupplierDTO> suppliersIban = getSuppliersByAccountNumber(originalSupplier.getAccountNumber());
            for (SupplierDTO suppIban : suppliersIban) {
                if (suppIban.getId() != originalSupplier.getId()) {
                    boolean alreadyAddedd = false;
                    for (SupplierDTO suppVat : suppliersVat) {
                        if (suppVat.getId() == suppIban.getId()) {
                            alreadyAddedd = true;
                        }
                    }
                    if (!alreadyAddedd) {
                        similarSuppliers.add(suppIban);
                    }
                }
            }
        }
        return similarSuppliers;
    }

    @Transactional
    public boolean requestLegalDocuments(int supplierId) {
        SupplierDTO supplier = getSupplierById(supplierId);
        if (supplier != null) {
            UserDTO user = userService.getUserById(supplier.getUserId());
            if (user != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
                String subject = bundle.getString("mail.dgConn.requestDocuments.subject");
                String msgBody = bundle.getString("mail.dgConn.requestDocuments.body");
                String additionalInfoUrl = userService.getBaseUrl() + "supplier-portal/additional-info";
                msgBody = MessageFormat.format(msgBody, additionalInfoUrl);
                if (!userService.isLocalHost()) {
                    mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
                }
                return true;
            }
        }
        return false;
    }

    @Transactional
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    @Transactional
    public SupplierDTO invalidateSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setStatus(1);
        supplierDTO = updateSupplier(supplierDTO);
        UserDTO user = userService.getUserById(supplierDTO.getUserId());
        if (user != null) {
            Locale locale = new Locale(UserConstants.DEFAULT_LANG);
            if (user.getLang() != null) {
                locale = new Locale(user.getLang());
            }
            ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
            String subject = bundle.getString("mail.dgConn.invalidateSupplier.subject");
            String msgBody = bundle.getString("mail.dgConn.invalidateSupplier.body");
            if (!userService.isLocalHost()) {
                mailService.sendEmail(user.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
            }
        }
        return supplierDTO;
    }

    public List<SupplierListItemDTO> findDgconnSuppliersList(String name, int page, int count, String orderField, int orderType) {
        List<SupplierListItemDTO> suppliersList = new ArrayList<>();
        Direction direction;
        if (orderType == -1) {
            direction = Direction.DESC;
        } else {
            direction = Direction.ASC;
        }
        List<SupplierDTO> suppliers;
        if (name != null) {
            if (!name.trim().isEmpty()) {
                suppliers = supplierMapper.toDTOList(supplierRepository.findByNameContainingIgnoreCase(new PageRequest(page, count, direction, orderField), name).getContent());
            } else {
                suppliers = supplierMapper.toDTOList(supplierRepository.findAll(new PageRequest(page, count, direction, orderField)).getContent());
            }
        } else {
            suppliers = supplierMapper.toDTOList(supplierRepository.findAll(new PageRequest(page, count, direction, orderField)).getContent());
        }
        for (SupplierDTO supplier : suppliers) {
            SupplierListItemDTO supplierItem = new SupplierListItemDTO(supplier.getId(), supplier.getName(), supplier.getWebsite(), supplier.getVat(), supplier.getAccountNumber(), supplier.getStatus());
            List<SupplierDTO> similarSuppliers = findSimilarSuppliers(supplierItem.getId());
            int numberRegistrations = 0;
            if (supplierItem.getStatus() != 1) {
                numberRegistrations = 1;
            }
            for (SupplierDTO similarSupplier : similarSuppliers) {
                if (similarSupplier.getStatus() != 1) {
                    numberRegistrations++;
                }
            }
            supplierItem.setNumberRegistrations(numberRegistrations);
            suppliersList.add(supplierItem);
        }
        return suppliersList;
    }

    public Long getCountAllSuppliers() {
        return supplierRepository.count();
    }

    public Long getCountAllSuppliersContainingName(String name) {
        return supplierRepository.countByNameContainingIgnoreCase(name);
    }

    public Page<String> getSuppliersByRegionOrCountry(String countryCode, int regionId, Pageable pageable) {
        if (regionId == 0) {
            return supplierRepository.findSuppliersByCountryCode(countryCode, pageable);
        }
        return supplierRepository.findSuppliersByRegion(regionId, pageable);
    }

    // Get all suppliers that supply a specific region
    public List<SupplierDTO> getSuppliersListByRegionId(int regionId) {
        List<SuppliedRegionDTO> suppliedRegions = suppliedRegionMapper.toDTOList(Lists.newArrayList(suppliedRegionRepository.findByRegionId(regionId)));
        List<SupplierDTO> suppliers = new ArrayList<>();
        for (SuppliedRegionDTO suppliedRegion : suppliedRegions) {
            SupplierDTO supplier = getSupplierById(suppliedRegion.getSupplierId());
            suppliers.add(supplier);
        }
        return suppliers;
    }

    // Get all validated suppliers that supply a specific region
    public List<SupplierDTO> getValidatedSuppliersListByRegionId(int regionId) {
        List<SupplierDTO> suppliers = supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.getValidatedSuppliersListByRegionId(regionId)));
        return suppliers;
    }

    // Send email to notify supplier that a beneficiary has selected him
    public void notifySelectedSupplier(int municipalityId) throws Exception {
        SupplierNotificationEmail notification = supplierNotificationEmailRepository.findSupplierNotificationEmailDetailsByMunicipalityId(municipalityId);
        if (notification != null) {
            Locale locale = new Locale(UserConstants.DEFAULT_LANG);
            if (notification.getUserLang() != null) {
                locale = new Locale(notification.getUserLang());
            }
            ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
            String fromAddress = MailService.FROM_ADDRESS;
            String subject = bundle.getString("mail.notifySelectedSupplier.subject");
            String msgBody = bundle.getString("mail.notifySelectedSupplier.body");
            msgBody = MessageFormat.format(msgBody, notification.getMunicipalityName(), notification.getMunicipalityCountry() );
            mailService.sendEmail(notification.getSupplierEmail(), fromAddress, subject, msgBody);
        } else {
            throw new Exception("Notification doesn't exist.");
        }
    }

    // Send email to notify supplier that a beneficiary has rejected him
    public void notifyRejectedSupplier(int municipalityId) throws Exception {
        SupplierNotificationEmail notification = supplierNotificationEmailRepository.findSupplierNotificationEmailDetailsByMunicipalityId(municipalityId);
        if (notification != null) {
            Locale locale = new Locale(UserConstants.DEFAULT_LANG);
            if (notification.getUserLang() != null) {
                locale = new Locale(notification.getUserLang());
            }
            ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
            String fromAddress = MailService.FROM_ADDRESS;
            String subject = bundle.getString("mail.notifyRejectedSupplier.subject");
            String msgBody = bundle.getString("mail.notifyRejectedSupplier.body");
            msgBody = MessageFormat.format(msgBody, notification.getMunicipalityName(), notification.getMunicipalityCountry() );
            mailService.sendEmail(notification.getSupplierEmail(), fromAddress, subject, msgBody);
        } else {
            throw new Exception("Notification doesn't exist.");
        }
        // Update timestamps
        RegistrationDTO registration = registrationService.getRegistrationById(notification.getRegistrationId());
        registration.setIsSubmission(null);
        registration.setIsRejection(new Date().getTime());
        registration.setIsConfirmation(null);
        registrationService.saveRegistration(registration);

        // Delete installation report --> TO BE COMPLETED
    }
}