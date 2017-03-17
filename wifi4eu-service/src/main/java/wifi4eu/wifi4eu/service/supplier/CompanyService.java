package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.CompanyDTO;
import wifi4eu.wifi4eu.mapper.supplier.CompanyMapper;
import wifi4eu.wifi4eu.repository.supplier.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    Logger _log = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyMapper companyMapper;


    public List<CompanyDTO> getAllCompanies() {
        return companyMapper.toDTOList(Lists.newArrayList(companyRepository.findAll()));
    }

    public CompanyDTO getCompany(Long companyId) {
        return companyMapper.toDTO(companyRepository.findOne(companyId));
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        return companyMapper.toDTO(companyRepository.save(companyMapper.toEntity(companyDTO)));
    }

}
