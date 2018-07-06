package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.SupplierValidator;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierListItemMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierListItemRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.MailService;

import java.text.MessageFormat;
import java.util.*;

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
    MailService mailService;

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
        finalSupplier.setUserId(supplierDTO.getUserId());
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
        finalSupplier.setContactName(supplierDTO.getContactName());
        finalSupplier.setContactSurname(supplierDTO.getContactSurname());
        finalSupplier.setContactEmail(supplierDTO.getContactEmail());
        finalSupplier.setContactPhonePrefix(supplierDTO.getContactPhonePrefix());
        finalSupplier.setContactPhoneNumber(supplierDTO.getContactPhoneNumber());
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
    public SupplierDTO updateContactDetails(SupplierDTO supplierDTO, String contactName, String contactSurname, String contactPhonePrefix, String contactPhoneNumber) {
        supplierDTO.setContactName(contactName);
        supplierDTO.setContactSurname(contactSurname);
        supplierDTO.setContactPhonePrefix(contactPhonePrefix);
        supplierDTO.setContactPhoneNumber(contactPhoneNumber);
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    @Transactional
    public SupplierDTO updateSupplierDetails(SupplierDTO supplierDTO, String name, String address, String vat, String bic, String accountNumber, String website, String logo) throws Exception {
        supplierDTO.setName(name);
        supplierDTO.setAddress(address);
        supplierDTO.setVat(vat);
        supplierDTO.setBic(bic);
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
        return supplierMapper.toDTOList(supplierRepository.findSimilarSuppliers(supplierId));
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
        for (SuppliedRegionDTO newRegion : newRegions) {
            if (!originalRegions.contains(newRegion)) {
                suppliedRegionRepository.save(suppliedRegionMapper.toEntity(newRegion));
            }
        }
        for (SuppliedRegionDTO originalRegion : originalRegions) {
            if (!newRegions.contains(originalRegion)) {
                suppliedRegionRepository.delete(suppliedRegionMapper.toEntity(originalRegion));
            }
        }
        return newRegions;
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
}