package wifi4eu.wifi4eu.service.exportImport;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.mapper.exportImport.*;
import wifi4eu.wifi4eu.repository.exportImport.*;
import wifi4eu.wifi4eu.common.dto.model.GlobalCommitmentDTO;
import java.util.List;


@Service
public class GlobalCommitmentsService {
    @Autowired
    ExportImportRegistrationDataMapper exportImportRegistrationDataMapper;

    @Autowired
    ExportImportRegistrationDataRepository exportImportRegistrationDataRepository;

    @Autowired
    GlobalCommitmentMapper globalCommitmentMapper;

    @Autowired
    GlobalCommitmentRepository globalCommitmentRepository;


    private final Logger _log = LoggerFactory.getLogger(wifi4eu.wifi4eu.service.exportImport.ExportImportWifi4euAbacService.class);

    public List<GlobalCommitmentDTO> findGlobalCommitments(){
        _log.info("exportRegistrationData");
        return globalCommitmentMapper.toDTOList(Lists.newArrayList(globalCommitmentRepository.findAll()));

    }
//    @Cacheable(value = "portalGetNutsByLevel")
//    public List<NutsDTO> getNutsByLevel(Integer level) {
//        return nutsMapper.toDTOList(Lists.newArrayList(nutsRepository.findByLevel(level)));
//    }

}

