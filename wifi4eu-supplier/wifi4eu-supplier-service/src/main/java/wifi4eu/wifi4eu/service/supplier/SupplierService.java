package wifi4eu.wifi4eu.service.supplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

@Service("publicSupplierService")
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierRepository supplierRepository;

    public SupplierDTO getSupplierByUserId(int userId) {
        return supplierMapper.toDTO(supplierRepository.findByUserId(userId));
    }
}