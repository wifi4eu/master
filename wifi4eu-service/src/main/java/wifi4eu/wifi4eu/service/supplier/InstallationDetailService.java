package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.InstallationDetailDTO;
import wifi4eu.wifi4eu.mapper.supplier.InstallationDetailMapper;
import wifi4eu.wifi4eu.repository.supplier.InstallationDetailRepository;

import java.util.List;

@Service
public class InstallationDetailService {

    Logger _log = LoggerFactory.getLogger(InstallationDetailService.class);

    @Autowired
    InstallationDetailRepository installationDetailRepository;

    @Autowired
    InstallationDetailMapper installationDetailMapper;


    public List<InstallationDetailDTO> getAllInstallationDetails() {
        return installationDetailMapper.toDTOList(Lists.newArrayList(installationDetailRepository.findAll()));
    }

    public InstallationDetailDTO getInstallationDetailById(Long installationDetailId) {
        return installationDetailMapper.toDTO(installationDetailRepository.findOne(installationDetailId));
    }

    public InstallationDetailDTO createInstallationDetail(InstallationDetailDTO installationDetailDTO) {
        return installationDetailMapper.toDTO(installationDetailRepository.save(installationDetailMapper.toEntity(installationDetailDTO)));
    }

}
