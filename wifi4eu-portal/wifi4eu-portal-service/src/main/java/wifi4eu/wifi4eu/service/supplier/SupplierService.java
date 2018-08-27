package wifi4eu.wifi4eu.service.supplier;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierUserDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.InvitationContactStatus;
import wifi4eu.wifi4eu.common.enums.SupplierContactStatus;
import wifi4eu.wifi4eu.common.enums.SupplierUserStatus;
import wifi4eu.wifi4eu.common.enums.SupplierUserType;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.common.utils.SupplierValidator;
import wifi4eu.wifi4eu.common.utils.UserValidator;
import wifi4eu.wifi4eu.entity.invitationContacts.InvitationContact;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierListItemMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierUserMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.invitationContacts.InvitationContactRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierListItemRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierUserRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.RegistrationUtils;

@Service("portalSupplierService")
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierListItemMapper supplierListItemMapper;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierListItemRepository supplierListItemRepository;

    @Autowired
    SuppliedRegionMapper suppliedRegionMapper;

    @Autowired
    SuppliedRegionRepository suppliedRegionRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MailService mailService;

    @Autowired
    SupplierUserRepository supplierUserRepository;

    @Autowired
    SupplierUserMapper supplierUserMapper;

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    InvitationContactRepository invitationContactRepository;

    @Autowired
    RegistrationUtils registrationUtils;

    private final Logger _log = LogManager.getLogger(SupplierService.class);

    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(int supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

    @Transactional
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) throws Exception {
        SupplierDTO finalSupplier = new SupplierDTO();
        finalSupplier.setName(supplierDTO.getName());
        finalSupplier.setAddress(supplierDTO.getAddress());
        finalSupplier.setVat(supplierDTO.getVat());
        finalSupplier.setBic(supplierDTO.getBic());
        finalSupplier.setAccountNumber(supplierDTO.getAccountNumber());
        if (supplierDTO.getWebsite() != null) {
            if (!supplierDTO.getWebsite().trim().isEmpty()) {
                finalSupplier.setWebsite(supplierDTO.getWebsite());
            } else {
                finalSupplier.setWebsite(null);
            }
        } else {
            finalSupplier.setWebsite(null);
        }
        if (supplierDTO.getLogo() != null) {
            byte[] logoByteArray = Base64.getMimeDecoder().decode(LegalFilesService.getBase64Data(supplierDTO.getLogo()));
            String logoMimeType = LegalFilesService.getMimeType(supplierDTO.getLogo());
            if (logoByteArray.length > 2560000) {
                throw new Exception("File size cannot bet greater than 2.5 MB.");
            } else if (!logoMimeType.equals("image/png") && !logoMimeType.equals("image/jpg") && !logoMimeType.equals("image/jpeg")) {
                throw new Exception("File must have a valid extension.");
            } else {
                finalSupplier.setLogo(supplierDTO.getLogo());
            }
        }
        finalSupplier.setContactEmail(supplierDTO.getContactEmail());
        List<SuppliedRegionDTO> originalRegions = supplierDTO.getSuppliedRegions();
        List<SuppliedRegionDTO> correctRegions = new ArrayList<>();
        finalSupplier.setSuppliedRegions(null);
        finalSupplier = supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(finalSupplier)));
        for (SuppliedRegionDTO region : originalRegions) {
            region.setSupplierId(finalSupplier.getId());
            correctRegions.add(region);
        }
        finalSupplier.setSuppliedRegions(correctRegions);
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(finalSupplier)));
    }


    @Transactional
    public List<UserDTO> updateContactDetails(SupplierDTO supplierDTO) throws Exception {
//        UserDTO userDTO = new UserDTO();
//        UserContext userContext = UserHolder.getUser();
        List<UserDTO> userDBOList = userMapper.toDTOList(userRepository.findUsersBySupplierId(supplierDTO.getId()));
        for (UserDTO user : userDBOList) {
            for (UserDTO userSupplier : supplierDTO.getUsers()) {
                if (userSupplier.getId() == user.getId()) {
                    user.setName(userSupplier.getName());
                    user.setSurname(userSupplier.getSurname());
                    user.setPhone_number(userSupplier.getPhone_number());
                    user.setPhone_prefix(userSupplier.getPhone_prefix());
                    UserValidator.validateUserContact(user);
                    break;
                }
            }

        }
        userRepository.save(userMapper.toEntityList(userDBOList));
        return userDBOList;

    }

    @Transactional
    public SupplierDTO updateSupplierDetails(SupplierDTO supplierDTO, String name, String address, String accountNumber, String website, String logo) throws Exception {
        supplierDTO.setName(name);
        supplierDTO.setAddress(address);
//        supplierDTO.setVat(vat);
//        supplierDTO.setBic(bic);
        supplierDTO.setAccountNumber(accountNumber);
        if (website != null) {
            supplierDTO.setWebsite(website);
        } else {
            supplierDTO.setWebsite(null);
        }
        if (logo != null) {
            byte[] logoByteArray = Base64.getMimeDecoder().decode(LegalFilesService.getBase64Data(logo));
            String logoMimeType = LegalFilesService.getMimeType(logo);
            if (logoByteArray.length > 2560000) {
                throw new Exception("File size cannot bet greater than 2.5 MB.");
            } else if (!logoMimeType.equals("image/png") && !logoMimeType.equals("image/jpg") && !logoMimeType.equals("image/jpeg")) {
                throw new Exception("File must have a valid extension.");
            } else {
                supplierDTO.setLogo(logo);
            }
        } else {
            supplierDTO.setLogo(null);
        }
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    @Transactional
    public SupplierDTO deleteSupplier(int supplierId) {
        //TODO: change to a soft delete
        SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRepository.findOne(supplierId));
        if (supplierDTO != null) {
            supplierUserRepository.deleteBySupplierId((long) supplierId);
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
        UserContext userContext = UserHolder.getUser();
        userDTO = userService.getUserByUserContext(userContext);

        if (supplierDTO.getUsers() != null && supplierDTO.getUsers().size() > 1 || userDTO == null) {
            throw new Exception("Incorrect contact parameters: more users than expected");
        }

        for (UserDTO userSupplier : supplierDTO.getUsers()) {
            if (userSupplier.getId() == userDTO.getId()) {
                userDTO.setName(userSupplier.getName());
                userDTO.setSurname(userSupplier.getSurname());
                userDTO.setEmail(userSupplier.getEmail());
                userDTO.setPhone_number(userSupplier.getPhone_number());
                userDTO.setPhone_prefix(userSupplier.getPhone_prefix());
                userDTO.setCreateDate(new Date().getTime());
                userDTO.setType(1);
                userDTO.setVerified(false);
                userDTO.setLang(supplierDTO.getLang());
                userDTO.setPhone_number(supplierDTO.getContactNumber());
                userDTO.setPhone_prefix(supplierDTO.getContactPrefix());
                userDTO.setEmail(supplierDTO.getContactEmail());
                if (userDTO.getEcasEmail() == null || userDTO.getEcasEmail().isEmpty()) {
                    userDTO.setEcasEmail(supplierDTO.getContactEmail());
                }
                break;
            }
        }
        userDTO = userService.saveUserChanges(userDTO);
        supplierDTO = createSupplier(supplierDTO);

        createSupplierUser(supplierDTO.getId(), userDTO.getId(), userDTO.getEmail(), true);
        userService.sendSupplierRegistrationEmail(userDTO);
        return supplierDTO;

    }

    public SupplierDTO getSupplierByUserId(int userId) {
        return supplierMapper.toDTO(supplierRepository.getByUserId(userId));
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
        return supplierMapper.toDTOList(supplierRepository.findSimilarSuppliers(supplierId));
    }

    @Transactional
    public boolean requestLegalDocuments(int supplierId) {
        SupplierDTO supplier = getSupplierById(supplierId);
        if (supplier != null) {
            UserDTO user = userService.getUserById(getUserIdFromSupplier(supplierId));
            if (user != null) {
                Locale locale = new Locale(UserConstants.DEFAULT_LANG);
                if (user.getLang() != null) {
                    locale = new Locale(user.getLang());
                }
                
                String additionalInfoUrl = userService.getBaseUrl() + "supplier-portal/additional-info";
                MailData mailData = MailHelper.buildMailRequestSupportingDocumentsForRegistration(
                		user.getEcasEmail(), MailService.FROM_ADDRESS, additionalInfoUrl, locale);
                mailService.sendMail(mailData, false);
                
                return true;
            }
        }
        return false;
    }

    @Transactional
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) throws Exception {
        SupplierDTO supplierDBO = getSupplierById(supplierDTO.getId());
        supplierDBO.setName(supplierDTO.getName());
        supplierDBO.setAddress(supplierDTO.getAddress());
        supplierDBO.setVat(supplierDTO.getVat());
        supplierDBO.setWebsite(supplierDTO.getWebsite());
        supplierDBO.setLogo(supplierDTO.getLogo());
        supplierDBO.setSuppliedRegions(updateSuppliedRegions(supplierDBO.getSuppliedRegions(), supplierDTO.getSuppliedRegions()));
        SupplierValidator.validateSupplierUpdate(supplierDBO);
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDBO)));
    }

    @Transactional
    public List<SuppliedRegionDTO> updateSuppliedRegions(SupplierDTO supplierDTO) {
        List<SuppliedRegionDTO> newRegions = supplierDTO.getSuppliedRegions();
        SupplierDTO supplierDBO = getSupplierById(supplierDTO.getId());
        if (supplierDBO != null) {
            return updateSuppliedRegions(supplierDBO.getSuppliedRegions(), newRegions);
        } else {
            return null;
        }
    }

    @Transactional
    public List<SuppliedRegionDTO> updateSuppliedRegions(List<SuppliedRegionDTO> originalRegions, List<SuppliedRegionDTO> newRegions) {
        List<SuppliedRegionDTO> finalRegions = new ArrayList<>();
        for (SuppliedRegionDTO newRegion : newRegions) {
            boolean regionInList = false;
            for (SuppliedRegionDTO originalRegion : originalRegions) {
                if (originalRegion.getRegionId().getId() == newRegion.getRegionId().getId()) {
                    finalRegions.add(originalRegion);
                    regionInList = true;
                    break;
                }
            }
            if (!regionInList) {
                finalRegions.add(newRegion);
            }
        }
        for (SuppliedRegionDTO originalRegion : originalRegions) {
            boolean regionInList = false;
            for (SuppliedRegionDTO newRegion : newRegions) {
                if (newRegion.getRegionId().getId() == originalRegion.getRegionId().getId()) {
                    regionInList = true;
                    break;
                }
            }
            if (!regionInList) {
                suppliedRegionRepository.delete(suppliedRegionMapper.toEntity(originalRegion));
            }
        }
        return finalRegions;
    }

    @Transactional
    public SupplierDTO invalidateSupplier(SupplierDTO supplierDTO) throws Exception {
        supplierDTO.setStatus(1);
        supplierDTO = updateSupplier(supplierDTO);
        UserDTO user = userService.getUserById(getUserIdFromSupplier(supplierDTO.getId()));
        if (user != null) {
            Locale locale = new Locale(UserConstants.DEFAULT_LANG);
            if (user.getLang() != null) {
                locale = new Locale(user.getLang());
            }
            String company = supplierDTO.getName(); 
            
            MailData mailData = MailHelper.buildMailInvalidRegistration(
            		user.getEcasEmail(), MailService.FROM_ADDRESS, company, locale);
            mailService.sendMail(mailData, false);
        }
        return supplierDTO;
    }

    public List<SupplierListItemDTO> findDgconnSuppliersList(String name, int page, int count, String orderField, int orderType) {

        Direction direction;
        if (orderType == -1) {
            direction = Direction.DESC;
        } else {
            direction = Direction.ASC;
        }

        if (name == null || name.trim().isEmpty()) {
            name = "";
        }
        List<SupplierListItemDTO> suppliers;

        switch (orderField) {
            case "website":
                if (direction.equals(Direction.ASC)) {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByWebsiteAsc(name, page * count, count));
                } else {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByWebsiteDesc(name, page * count, count));
                }
                break;
            case "vat":
                if (direction.equals(Direction.ASC)) {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByVatAsc(name, page * count, count));
                } else {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByVatDesc(name, page * count, count));
                }

                break;
            case "status":
                if (direction.equals(Direction.ASC)) {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByStatusAsc(name, page * count, count));
                } else {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByStatusDesc(name, page * count, count));
                }

                break;
            case "name":
            default:
                if (direction.equals(Direction.ASC)) {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByNameAsc(name, page * count, count));
                } else {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByNameDesc(name, page * count, count));
                }
                break;

        }
        return suppliers;
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

    public SupplierUserDTO createSupplierUser(int supplierId, Integer userId, String userEmail, boolean isMain) {
        SupplierUserDTO supplierUserDTO = new SupplierUserDTO();
        supplierUserDTO.setEmail(userEmail);
        supplierUserDTO.setCreationDate(new Date());
        supplierUserDTO.setSupplierId(supplierId);


        if (isMain) {
            supplierUserDTO.setStatus(SupplierUserStatus.ALREADY_REGISTERED.getStatus());
            supplierUserDTO.setMain(SupplierUserType.MAIN.getType());

        } else {
            supplierUserDTO.setStatus(SupplierUserStatus.NOT_REGISTERED.getStatus());
            supplierUserDTO.setMain(SupplierUserType.INVITED.getType());
        }

        if (userId != null) {
            supplierUserDTO.setUserId(userId);
        }

        return supplierUserMapper.toDTO(supplierUserRepository.save(supplierUserMapper.toEntity(supplierUserDTO)));
    }

    public SupplierUserDTO getSupplierUserBySupplierIdAndEmail(int supplierId, String userEmail) {
        return supplierUserMapper.toDTO(supplierUserRepository.findFirstSupplierUserBySupplierIdAndEmail(supplierId, userEmail));
    }

    public SupplierUserDTO registerSupplierUser(SupplierUserDTO supplierUserDTO) {
        supplierUserDTO.setStatus(SupplierUserStatus.ALREADY_REGISTERED.getStatus());

        return supplierUserMapper.toDTO(supplierUserRepository.save(supplierUserMapper.toEntity(supplierUserDTO)));
    }

    public boolean createdLessThan24HBefore(SupplierUserDTO supplierUserDTO) {
        long timePassed = new Date().getTime() - supplierUserDTO.getCreationDate().getTime();
        return timePassed < 24 * 60 * 60 * 1000;
    }

    public int countSupplierUsersByEmail(String email) {
        return supplierUserRepository.countByEmail(email);
    }

    public int getUserIdFromSupplier(int supplierId) {
        return supplierUserRepository.findUserIdBySupplierId(supplierId);
    }

    public List<SupplierUserDTO> findByEmail(String email) {
        return supplierUserMapper.toDTOList(supplierUserRepository.findByEmail(email));
    }

    public List<SupplierUserDTO> registerSupplierUserIfApplies(List<SupplierUserDTO> supplierUserDTOList) {
        List<SupplierUserDTO> supplierUserDTOToUpdate = new ArrayList<>();

        for (SupplierUserDTO supplierUserDTO : supplierUserDTOList) {

            if (SupplierUserStatus.NOT_REGISTERED.getStatus() == supplierUserDTO.getStatus()
                    && createdLessThan24HBefore(supplierUserDTO)) {

                supplierUserDTO.setStatus(SupplierUserStatus.ALREADY_REGISTERED.getStatus());
                supplierUserDTOToUpdate.add(supplierUserDTO);
            }
        }

        Iterator<SupplierUser> supplierUserIterator = supplierUserRepository.save(supplierUserMapper.toEntityList(supplierUserDTOToUpdate)).iterator();
        supplierUserDTOToUpdate.clear();

        SupplierUser supplierUser;

        while (supplierUserIterator.hasNext()) {
            supplierUser = supplierUserIterator.next();
            supplierUserDTOToUpdate.add(supplierUserMapper.toDTO(supplierUser));
        }

        return supplierUserDTOToUpdate;
    }

    public boolean sendEmailToContacts(String newUserEmail, Integer supplierId) throws Exception {
        Locale locale = new Locale(UserConstants.DEFAULT_LANG);

        UserContext userContext = UserHolder.getUser();
        UserDTO user = userService.getUserByUserContext(userContext);

        if (getSupplierByUserId(user.getId()) == null) {
            throw new Exception("User data is not correct.");

        } else if (!checkHasNoRegistrations(newUserEmail)) {
            throw new Exception("This email has related registrations.");

        } else if (!checkContactHasNotBeenAddedBefore(newUserEmail, supplierId)) {
            throw new Exception("This contact has been added to this supplier before.");

        } else { // ALL OK
            String urlSent = userService.getEcasUrl() + "/cas/eim/external/register.cgi?email=" + newUserEmail.trim();

            // TODO maybe is not the correct mail data, 
            // originally was recovering message from 'sendNewUserSupplier' tag without replacing all the values
            MailData mailData = MailHelper.buildMailNewUserSupplier(
            		newUserEmail.trim(), MailService.FROM_ADDRESS, 
            		"", "", urlSent, "",  locale);
            mailService.sendMail(mailData, false);

            return true;
        }
    }

    private boolean checkHasNoRegistrations(String userEmail) {
        return registrationUsersRepository.findByContactEmail(userEmail).isEmpty();
    }

    private boolean checkContactHasNotBeenAddedBefore(String userEmail, Integer supplierId) {
        return supplierUserRepository.findByEmailAndSupplierId(userEmail, supplierId).isEmpty();
    }

    public SupplierUserDTO deactivateSupplierContact(Integer userId) throws Exception {
        List<SupplierUser> supplierUsers = supplierUserRepository.findByUserId(userId);
        SupplierUser supplierUserToSave = null;
        for (SupplierUser supplierUser : supplierUsers) {
            if (supplierUser.getUserId().equals(userId)) {
                supplierUser.setStatus(SupplierUserStatus.DEACTIVATED.getStatus());
                supplierUserToSave = supplierUser;
                break;
            }
        }
        if (supplierUserToSave == null) {
            throw new Exception("Incorrect userId");
        } else {
            supplierUserRepository.save(supplierUserToSave);
            UserDTO contactDeactivated = userService.getUserById(userId);
            contactDeactivated.setType(SupplierContactStatus.DEACTIVATED.getStatus());
            userService.saveUserChanges(contactDeactivated);
        }

        return supplierUserMapper.toDTO(supplierUserToSave);
    }

    public ResponseDTO invitateContactSupplier(UserDTO userConnected, int supplierId, String newContactEmail){
        ResponseDTO responseDTO = new ResponseDTO();
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new supplier contact - START");
        if (Validator.isNotNull(supplierId) && Validator.isNotNull(newContactEmail) && !newContactEmail.isEmpty()){
            if (Validator.isNull(invitationContactRepository.findByEmailInvitedAndIdUserRequestNotIn(newContactEmail,userConnected.getId())) && registrationUtils.enableInvitateContactByUserIdRequested(newContactEmail)){
                InvitationContact invitationContact = invitationContactRepository.findByEmailInvitedAndIdUserRequest(newContactEmail,userConnected.getId());
                Date today = new Date();
                if (Validator.isNull(invitationContact)){
                    invitationContact = new InvitationContact();
                    invitationContact.setEmailInvited(newContactEmail);
                    invitationContact.setIdSupplier(supplierId);
                    invitationContact.setIdUserRequest(userConnected.getId());
                    invitationContact.setType((int) Constant.ROLE_SUPPLIER);
                    invitationContact.setStatus(InvitationContactStatus.PENDING.getValue());
                    invitationContact.setCreateDate(today);
                } else if (invitationContact.getIdSupplier().intValue() != supplierId){
                    _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new supplier contact - This user has already been invitated. Please, try another user email");
                    responseDTO.setSuccess(false);
                    responseDTO.setData("This user has already been invitated. Please, try another user email");
                    responseDTO.setError(new ErrorDTO(400, "shared.profile.addContact.exists"));
                    return responseDTO;
                }

                invitationContact.setLastModified(today);
                Locale locale = userConnected.getLang() == null ? new Locale(UserConstants.DEFAULT_LANG) : new Locale(userConnected.getLang());
                String supplierName = getSupplierById(supplierId).getName();
                String userName = userConnected.getName() + ' ' + userConnected.getSurname();
                String additionalInfoUrl = userService.getEcasUrl() + "/cas/eim/external/register.cgi?email=";
                
                MailData mailData = MailHelper.buildMailNewUserSupplier(
                		newContactEmail, MailService.FROM_ADDRESS, 
                		userName, supplierName, additionalInfoUrl, newContactEmail, locale);
                mailService.sendMail(mailData, false);
                
                invitationContactRepository.save(invitationContact);
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - Successfully");
                responseDTO.setSuccess(true);
                responseDTO.setData("shared.email.sent");
            } else {
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new municipality contact - This user has already been invitated. Please, try another user email");
                responseDTO.setSuccess(false);
                responseDTO.setData("This user has already been invitated. Please, try another user email");
                responseDTO.setError(new ErrorDTO(400, "shared.profile.addContact.exists"));
            }
        } else {
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new supplier contact - Some fields are null or empty. Please, complete all the fields");
            responseDTO.setSuccess(false);
            responseDTO.setData("Some fields are null or empty. Please, complete all the fields");
            responseDTO.setError(new ErrorDTO(400, "shared.profile.addContact.emptyOrNull"));
        }
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Adding new supplier contact - END");
        return responseDTO;
    }
}