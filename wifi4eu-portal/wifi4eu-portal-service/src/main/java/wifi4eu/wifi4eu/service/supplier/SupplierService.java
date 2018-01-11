package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
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
    ThreadService threadService;

    @Autowired
    UserThreadsService userThreadsService;

    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(int supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

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
        userDTO = userService.saveUserChanges(userDTO);
        userService.sendActivateAccountMail(userDTO);
        supplierDTO.setUserId(userDTO.getId());
        supplierDTO = createSupplier(supplierDTO);
        checkDuplicateSuppliers(supplierDTO);
        return supplierDTO;
    }

    private void checkDuplicateSuppliers(SupplierDTO supplierDTO) {
        List<SupplierDTO> suppliers = supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findByVat(supplierDTO.getVat())));
        if (!suppliers.isEmpty()) {
            for (SupplierDTO supplier : suppliers) {
                if (supplier.getId() != supplierDTO.getId()) {
                    ThreadDTO thread = threadService.getThreadByTypeAndReason(2, supplierDTO.getVat());
                    if (thread == null) {
                        thread = new ThreadDTO();
                        thread.setTitle("VAT: " +  supplierDTO.getVat());
                        thread.setType(2);
                        thread.setReason(supplierDTO.getVat());
                        thread = threadService.createThread(thread);
                    }
                    UserThreadsDTO specificSupplierUserThreads = userThreadsService.getByUserIdAndThreadId(supplier.getUserId(), thread.getId());
                    if (specificSupplierUserThreads == null) {
                        specificSupplierUserThreads = new UserThreadsDTO();
                        specificSupplierUserThreads.setUserId(supplier.getUserId());
                        specificSupplierUserThreads.setThreadId(thread.getId());
                        userThreadsService.createUserThreads(specificSupplierUserThreads);
                    }
                    UserThreadsDTO originalSupplierUserThreads = userThreadsService.getByUserIdAndThreadId(supplierDTO.getUserId(), thread.getId());
                    if (originalSupplierUserThreads == null) {
                        originalSupplierUserThreads = new UserThreadsDTO();
                        originalSupplierUserThreads.setUserId(supplierDTO.getUserId());
                        originalSupplierUserThreads.setThreadId(thread.getId());
                        userThreadsService.createUserThreads(originalSupplierUserThreads);
                    }
                }
            }
        }
        suppliers = supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findByAccountNumber(supplierDTO.getAccountNumber())));
        if (!suppliers.isEmpty()) {
            for (SupplierDTO supplier : suppliers) {
                if (supplier.getId() != supplierDTO.getId()) {
                    ThreadDTO thread = threadService.getThreadByTypeAndReason(3, supplierDTO.getAccountNumber());
                    if (thread == null) {
                        thread = new ThreadDTO();
                        thread.setTitle("IBAN: " +  supplierDTO.getAccountNumber());
                        thread.setType(3);
                        thread.setReason(supplierDTO.getAccountNumber());
                        thread = threadService.createThread(thread);
                    }
                    UserThreadsDTO specificSupplierUserThreads = userThreadsService.getByUserIdAndThreadId(supplier.getUserId(), thread.getId());
                    if (specificSupplierUserThreads == null) {
                        specificSupplierUserThreads = new UserThreadsDTO();
                        specificSupplierUserThreads.setUserId(supplier.getUserId());
                        specificSupplierUserThreads.setThreadId(thread.getId());
                        userThreadsService.createUserThreads(specificSupplierUserThreads);
                    }
                    UserThreadsDTO originalSupplierUserThreads = userThreadsService.getByUserIdAndThreadId(supplierDTO.getUserId(), thread.getId());
                    if (originalSupplierUserThreads == null) {
                        originalSupplierUserThreads = new UserThreadsDTO();
                        originalSupplierUserThreads.setUserId(supplierDTO.getUserId());
                        originalSupplierUserThreads.setThreadId(thread.getId());
                        userThreadsService.createUserThreads(originalSupplierUserThreads);
                    }
                }
            }
        }
    }

    public SupplierDTO getSupplierByUserId(int userId) {
        return supplierMapper.toDTO(supplierRepository.findByUserId(userId));
    }

    public List<SuppliedRegionDTO> getSuppliedRegionsGroupedByRegionId() {
        return suppliedRegionMapper.toDTOList(Lists.newArrayList(suppliedRegionRepository.findSuppliedRegionsGroupedByRegionId()));
    }
}