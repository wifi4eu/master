package wifi4eu.wifi4eu.service.beneficiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryFinalListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.ApplicationStatus;
import wifi4eu.wifi4eu.common.mapper.beneficiary.BeneficiaryFinalListItemMapper;
import wifi4eu.wifi4eu.common.mapper.beneficiary.BeneficiaryListItemMapper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;
import wifi4eu.wifi4eu.repository.application.ApplicationRepository;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryFinalListItemRepository;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryListItemRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.ExcelExportGenerator;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryListItemMapper beneficiaryListItemMapper;

    @Autowired
    private BeneficiaryListItemRepository beneficiaryListItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private BeneficiaryFinalListItemRepository beneficiaryFinalListItemRepository;

    @Autowired
    private BeneficiaryFinalListItemMapper beneficiaryFinalListItemMapper;

    private static final Logger _log = LoggerFactory.getLogger(BeneficiaryService.class);

    public List<BeneficiaryListItemDTO> findDgconnBeneficiaresList(String name, int offset, int count, String orderField, int orderType) throws Exception {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        List<BeneficiaryListItemDTO> beneficiariesList;
        switch (orderField) {
            case "name":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByNameDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByNameDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByNameAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByNameAsc(offset, count));
                }
                break;
            case "countryCode":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCountryCodeDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCountryCodeDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCountryCodeAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCountryCodeAsc(offset, count));
                }
                break;
            case "counter":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCounterDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCounterDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByCounterAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByCounterAsc(offset, count));
                }
                break;
            case "status":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByStatusDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByStatusDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByStatusAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByStatusAsc(offset, count));
                }
                break;
            case "mediation":
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByMediationDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByMediationDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByMediationAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByMediationAsc(offset, count));
                }
                break;
            default:
                if (orderType == -1) {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdDesc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdDesc(offset, count));
                } else {
                    if (name != null) {
                        if (name.trim().length() > 0) {
                            beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdAsc(name, offset, count));
                            break;
                        }
                    }
                    beneficiariesList = beneficiaryListItemMapper.toDTOList(beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdAsc(offset, count));
                }
                break;
        }
        for (int i = 0; i < beneficiariesList.size(); i++) {
            BeneficiaryListItemDTO beneficiary = beneficiariesList.get(i);
            if (beneficiary.getCounter() == 1) {
                List<RegistrationDTO> registrations = registrationService.getRegistrationsByLauId(beneficiary.getLauId());
                for (RegistrationDTO registration : registrations) {
                    if (registration != null) {
                        // beneficiary.setIssueStatus(registrationService.getRegistrationIssue(registration));
                    }
                }
            } else {
                beneficiary.setIssueStatus(0);
            }
            beneficiariesList.set(i, beneficiary);
        }
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Beneficiaries retrieved correctly");
        return beneficiariesList;
    }

    public Integer getCountDistinctMunicipalities() {
        return municipalityService.getCountDistinctMunicipalities();
    }

    public Integer getCountDistinctMunicipalitiesContainingName(String name) {
        return municipalityService.getCountDistinctMunicipalitiesContainingName(name);
    }

    public String exportCSVDGConnBeneficiariesList() {
        int totalCount = getCountDistinctMunicipalities();
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdAsc(0, pageSize);
        return generateCSVBeneficiaries(beneficiaries, true);
    }

    public String exportCSVDGConnBeneficiariesListSearchingName(String name) {
        int totalCount = getCountDistinctMunicipalitiesContainingName(name);
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdAsc(name, 0, pageSize);
        return generateCSVBeneficiaries(beneficiaries, true);
    }

    public byte[] exportExcelDGConnBeneficiariesList() {
        int totalCount = getCountDistinctMunicipalities();
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListOrderByLauIdAsc(0, pageSize);
        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(beneficiaries, BeneficiaryListItem.class);
        return excelExportGenerator.exportExcelFile("beneficiaries").toByteArray();
    }

    public byte[] exportExcelDGConnBeneficiariesListContainingName(String name) {
        int totalCount = getCountDistinctMunicipalitiesContainingName(name);
        int pageSize = totalCount;
        List<BeneficiaryListItem> beneficiaries = beneficiaryListItemRepository.findDgconnBeneficiaresListContainingNameOrderByLauIdAsc(name, 0, pageSize);
        ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(beneficiaries, BeneficiaryListItem.class);
        return excelExportGenerator.exportExcelFile("beneficiaries").toByteArray();
    }

    private String generateCSVBeneficiaries(List<BeneficiaryListItem> beneficiaryListItems, boolean columnHeaders) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        StringBuilder sb = new StringBuilder();
        if (columnHeaders) {
            sb.append("Name,LauID,CountryCode,NumberRegistrations,Status,Mediation,IssueStatus,");
            sb.append("\n");
        }
        for (BeneficiaryListItem beneficiaryListItem : beneficiaryListItems) {
            sb.append(beneficiaryListItem.getName());
            sb.append(",");
            sb.append(beneficiaryListItem.getLauId());
            sb.append(",");
            sb.append(beneficiaryListItem.getCountryCode());
            sb.append(",");
            if (beneficiaryListItem.getStatus()) {
                sb.append("Applied");
            } else {
                sb.append("Registered");
            }
            sb.append(",");
            if (beneficiaryListItem.getMediation()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append(",");
            sb.append(beneficiaryListItem.getIssueStatus());
            sb.append(",");
            sb.append("\n");
            _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Beneficiary " + beneficiaryListItem.getName() + " added to the list");
        }
        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - CSV generated");
        return sb.toString();
    }

    public ResponseDTO findBeneficiariesFromFinalList(Integer callId, String countryCode, String municipality, Integer page, Integer sizePage, String field, String sortDirection){
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Finding beneficiary list");
        if(municipality.equalsIgnoreCase("%")){
            municipality = "";
        }
        List<BeneficiaryFinalListItemDTO> beneficiaryFinalListItemDTOList;
        field = field.toLowerCase();
        switch (field){

            case "name":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByNameASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByNameDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            case "countrycode":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByCountryASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByCountryDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            case "registrationid":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByRegistrationIdASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByRegistrationIdDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            case "verifiedtosign":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByVerifiedToSignASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByVerifiedToSignDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            case "datesignature":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByDateSignatureASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByDateSignatureDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            case "datecountersignature":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByDateCounterSignatureASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByDateCounterSignatureDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            case "status":
                if(sortDirection.equalsIgnoreCase("asc")){
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByStatusASC(callId, countryCode, municipality, page, sizePage));
                } else {
                    beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalListOrderByStatusDESC(callId, countryCode, municipality, page, sizePage));
                }
                break;

            default:
                beneficiaryFinalListItemDTOList = beneficiaryFinalListItemMapper.toDTOList(beneficiaryFinalListItemRepository.findBeneficiariesFromFinalList(callId));
                break;
        }

        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setXTotalCount(beneficiaryFinalListItemRepository.countBeneficiariesFromFinalList(callId));
        response.setData(beneficiaryFinalListItemDTOList);
        return response;
    }

    public ResponseDTO cancelBeneficiaryFromRegistrationId(int registrationId, String reason, int callId){
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Cancel beneficiary with a reason");
        ResponseDTO responseDTO = new ResponseDTO();
        Application application = applicationRepository.findByRegistrationIdAndCallId(registrationId, callId);
        if (application != null && reason.trim().length() > 0){
            application.setStatus(ApplicationStatus.CANCELLED.getValue());
            application.setCanceledReason(reason);
            applicationRepository.save(application);
            responseDTO.setSuccess(true);
            responseDTO.setData("CANCELING BENEFICIARY BY REGISTRATION ID - "+registrationId+" - "+reason);
        } else {
            responseDTO.setSuccess(false);
            responseDTO.setData("Error on requirements");
            _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Error cancelling beneficiary");
        }
        return responseDTO;
    }

}