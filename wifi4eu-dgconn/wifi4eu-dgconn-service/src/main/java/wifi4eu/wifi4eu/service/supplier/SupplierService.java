package wifi4eu.wifi4eu.service.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.mail.MailData;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.mail.MailHelper;
import wifi4eu.wifi4eu.common.mapper.supplier.SupplierListItemMapper;
import wifi4eu.wifi4eu.common.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.common.service.mail.MailService;
import wifi4eu.wifi4eu.repository.supplier.SupplierListItemRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierUserRepository;
import wifi4eu.wifi4eu.service.user.UserConstants;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.List;
import java.util.Locale;

@Service("portalSupplierService")
public class SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierListItemMapper supplierListItemMapper;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierListItemRepository supplierListItemRepository;

    @Autowired
    private SupplierUserRepository supplierUserRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    public SupplierDTO getSupplierById(int supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

    public ResponseDTO findSimilarSuppliersPaged(int supplierId, int offset, int size) {
        List<SupplierDTO> suppliers = supplierMapper.toDTOList(supplierRepository.findSimilarSuppliersPaged(supplierId, offset, size));
        Integer countQuery = supplierRepository.countSimilarSuppliersPaged(supplierId);
        ResponseDTO response = new ResponseDTO();
        response.setXTotalCount(countQuery);
        response.setData(suppliers);
        return response;
    }

    @Transactional
    public boolean requestLegalDocuments(int supplierId) {
        SupplierDTO supplier = getSupplierById(supplierId);
        if (supplier != null) {
            UserDTO user = userService.getUserById(getUserIdFromSupplier(supplier.getId()));
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
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    @Transactional
    public SupplierDTO invalidateSupplier(SupplierDTO supplierDTO) {
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
            case "numberRegistrations":
                if (direction.equals(Direction.ASC)) {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByNumberRegistrationsAsc(name, page * count, count));
                } else {
                    suppliers = supplierListItemMapper.toDTOList(supplierListItemRepository.findSupplierListItemsOrderByNumberRegistrationsDesc(name, page * count, count));
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

    public int getUserIdFromSupplier(int supplierId) {
        return supplierUserRepository.findUserIdBySupplierId(supplierId);
    }

}