package wifi4eu.wifi4eu.service.location;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import eu.europa.ec.jagate.financiallegalentity.JaGateServiceBean;
import eu.europa.ec.jagate.financiallegalentity.model.LegalEntityJagate;
import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicBodyAccountGroupType;
import eu.europa.ec.research.fp.model.code_ref.v3.CodeRefType;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.mapper.location.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.location.MunicipalityRepository;

@Service
public class MunicipalityService {

    private final static Logger _log = Logger.getLogger(MunicipalityService.class);

    @Autowired
    MunicipalityRepository repository;

    @Autowired
    MunicipalityMapper mapper;
    
    JaGateServiceBean jaGateService;
    
    @PostConstruct
    public void init() throws Exception {
    	InitialContext ic = new InitialContext();
    	jaGateService = (JaGateServiceBean)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/JaGateServiceBean");
    }


    public List<MunicipalityDTO> list() {
        return mapper.toDTOList(Lists.newArrayList(repository.findAll()));
    }

    public MunicipalityDTO get(Long id) {
        return mapper.toDTO(repository.findOne(id));
    }
    
    public MunicipalityDTO getByJagateKey(String jagateKey) {
        return mapper.toDTO(repository.findByJagateKey(jagateKey));
    }


    public MunicipalityDTO createOrUpdate(MunicipalityDTO dto) throws Exception {
        LegalEntityJagate legalEntityJagate = new LegalEntityJagate();
        legalEntityJagate.setOfficialName(dto.getName());
        legalEntityJagate.setCity("BXL"); // @TODO
        legalEntityJagate.setStreet(dto.getAddress());
        legalEntityJagate.setPostalCode(dto.getPostalCode());
        legalEntityJagate.setRegistrationAuthority("UNKNOWN"); // @TODO 
        legalEntityJagate.setLegistrationDate(new Date());
        legalEntityJagate.setLegalRegNumber("00279102"); // @TODO 

        CodeRefType beCountry = new CodeRefType(); // @TODO: fetch from CCM2
        beCountry.setAbbreviation("CZ");
        beCountry.setDescription("Czech Republic");
        beCountry.setId("20000872");

        CodeRefType abacLegalForm = new CodeRefType(); // @TODO: fetch from CCM2
        abacLegalForm.setId("31044341");
        abacLegalForm.setAbbreviation("CZ_UNK");
        abacLegalForm.setDescription("UNKNOWN");

        CodeRefType languageFr = new CodeRefType(); // @TODO: fetch from CCM2
        languageFr.setId("20001134");
        languageFr.setAbbreviation("cs");
        languageFr.setDescription("Czech");


        legalEntityJagate.setOfficialLanguage(languageFr);
        legalEntityJagate.setCountry(beCountry);
        legalEntityJagate.setAbacLegalForm(abacLegalForm);
        legalEntityJagate.setAccountGroupType(PublicBodyAccountGroupType.OTHER_PUBLIC_BODIES);

        String jagateKey= jaGateService.requestFelCreation(legalEntityJagate);

        if (jagateKey != null) {
        	dto.setJagateKey(jagateKey);
        }
    	
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Transactional
    public MunicipalityDTO delete(Long id) {
        MunicipalityDTO dto = mapper.toDTO(repository.findOne(id));
        repository.delete(id);
        return dto;
    }

}
