package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;

import java.util.List;

/**
 * Created by rfguri on 27/03/2017.
 */
@Service
public class SupplierService {

    private final static org.apache.log4j.Logger _log = org.apache.log4j.Logger.getLogger(SupplierService.class);

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierMapper supplierMapper;


    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(Long supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

}
