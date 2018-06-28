package wifi4eu.wifi4eu.service.supplier;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.security.UsersDetailsByTokenCustom;
import wifi4eu.wifi4eu.service.user.UserService;

@Service("publicSupplierService")
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    UserService userService;

    private final Logger _log = LogManager.getLogger(SupplierService.class);


    public SupplierDTO getSupplierByUserId(int userId) {
        return supplierMapper.toDTO(supplierRepository.findByUserId(userId));
    }
}