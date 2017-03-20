package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;
import wifi4eu.wifi4eu.mapper.supplier.InstallationMapper;
import wifi4eu.wifi4eu.repository.supplier.InstallationRepository;

import java.util.List;

@Service
public class InstallationService {

    Logger _log = LoggerFactory.getLogger(InstallationService.class);

    @Autowired
    InstallationRepository installationRepository;

    @Autowired
    InstallationMapper installationMapper;


    public List<InstallationDTO> getAllInstallations() {
        return installationMapper.toDTOList(Lists.newArrayList(installationRepository.findAll()));
    }

    public InstallationDTO getInstallationById(Long installationId) {
        return installationMapper.toDTO(installationRepository.findOne(installationId));
    }

    public InstallationDTO createInstallation(InstallationDTO installationDTO) {
        return installationMapper.toDTO(installationRepository.save(installationMapper.toEntity(installationDTO)));
    }

}
