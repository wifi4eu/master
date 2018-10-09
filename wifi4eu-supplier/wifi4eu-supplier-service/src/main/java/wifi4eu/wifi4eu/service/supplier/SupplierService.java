package wifi4eu.wifi4eu.service.supplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

@Service("publicSupplierService")
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierRepository supplierRepository;

    public SupplierDTO getSupplierByUserId(int userId) {
        //we only use this method to verify if the user has permissions.
        //So we don't need to log this.
        return supplierMapper.toDTO(supplierRepository.findByUserId(userId));
    }

    public Integer getSupplierMainUserId(SupplierDTO supplier) {
        return supplierRepository.findMainSupplierByUserId(supplier.getId());
    }
}