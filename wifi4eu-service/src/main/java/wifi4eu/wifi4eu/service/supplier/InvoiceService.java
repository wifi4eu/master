package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.InvoiceDTO;
import wifi4eu.wifi4eu.mapper.supplier.InvoiceMapper;
import wifi4eu.wifi4eu.repository.supplier.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {

    Logger _log = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceMapper invoiceMapper;


    public List<InvoiceDTO> getAllInvoices() {
        return invoiceMapper.toDTOList(Lists.newArrayList(invoiceRepository.findAll()));
    }

    public InvoiceDTO getInvoiceById(Long invoiceId) {
        return invoiceMapper.toDTO(invoiceRepository.findOne(invoiceId));
    }

    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        return invoiceMapper.toDTO(invoiceRepository.save(invoiceMapper.toEntity(invoiceDTO)));
    }

}
