package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
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

    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(int supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

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
            List<SupplierDTO> suppliersVat = getSuppliersByVat(originalSupplier.getAccountNumber());
            if (!suppliersVat.isEmpty()) {
                for (SupplierDTO supp : suppliersVat) {
                    if (supp.getId() != originalSupplier.getId()) {
                        similarSuppliers.add(supp);
                    }
                }
            }
            List<SupplierDTO> suppliersIban = getSuppliersByAccountNumber(originalSupplier.getAccountNumber());
            if (!suppliersIban.isEmpty()) {
                for (SupplierDTO supp : suppliersIban) {
                    if (supp.getId() != originalSupplier.getId()) {
                        similarSuppliers.add(supp);
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
        supplierDTO.setStatus(0);
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

    @Cacheable(value = "portalGetListSuppliersByRegion")
    public List<String> getSuppliersByRegion(int regionId){
        Set<String> supplierNames = new HashSet<>();
        for (SuppliedRegionDTO suppliedRegion: suppliedRegionMapper.toDTOList(Lists.newArrayList(suppliedRegionRepository.findByRegionId(regionId)))) {
            SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRepository.findOne(suppliedRegion.getSupplierId()));
            if(!supplierNames.contains(supplierDTO.getName())){
                supplierNames.add(supplierDTO.getName());
            }
        }
        return new ArrayList<>(supplierNames);
    }

    @Cacheable(value = "portalGetListSuppliersByCountry")
    public SuppliersCacheDTO getSuppliersByCountry(String countryCode){
        Set<String> supplierNames = new HashSet<>();
        List<NutsDTO> regions = nutsService.getNutsByCountryCodeAndLevelOrderByLabelAsc(countryCode,3);
        for(NutsDTO nutsDTO: regions){
            supplierNames.addAll(getSuppliersByRegion(nutsDTO.getId()));
        }
        return new SuppliersCacheDTO(new ArrayList<>(supplierNames), new Date());
    }
}