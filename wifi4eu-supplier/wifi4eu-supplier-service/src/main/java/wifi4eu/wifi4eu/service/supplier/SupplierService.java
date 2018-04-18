package wifi4eu.wifi4eu.service.supplier;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

import java.util.List;

@Service("publicSupplierService")
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SuppliedRegionMapper suppliedRegionMapper;

    @Autowired
    SuppliedRegionRepository suppliedRegionRepository;

    public SupplierDTO getSupplierByUserId(int userId) {
        return supplierMapper.toDTO(supplierRepository.findByUserId(userId));
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
}