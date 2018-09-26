package wifi4eu.wifi4eu.util;

import com.microsoft.applicationinsights.core.dependencies.apachecommons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.entity.application.ApplicantListItem;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;
import wifi4eu.wifi4eu.mapper.application.ApplicantListItemMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;
import wifi4eu.wifi4eu.repository.application.ApplicantListItemRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.io.File;
import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
public class ExcelExportGeneratorAsync implements Runnable  {

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    private AdminActionsRepository adminActionsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ApplicantListItemMapper applicantListItemMapper;

    @Autowired
    ApplicantListItemRepository applicantListItemRepository;

    @Autowired
    AzureBlobConnector azureBlobConnector;

    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");

    private UserDTO userConnected;
    private Integer callId;

    private String country;
    private Class dataClass;

    public ExcelExportGeneratorAsync(Integer callId, String country, UserDTO userDTO, Class dataClass) {
        this.country = country;
        this.callId = callId;
        this.dataClass = dataClass;
        this.userConnected = userDTO;
    }

    @Override
    public void run() {
        AdminActions adminActions = null;
        try {


            if (dataClass == BeneficiaryListItem.class || dataClass == BeneficiaryListItemDTO.class) {
                adminActions = adminActionsRepository.findOneByAction("export_beneficiaries");
            } else if (dataClass == ApplicantListItem.class || dataClass == ApplicantListItemDTO.class) {
                adminActions = adminActionsRepository.findOneByAction("export_municipality_applications");

                if(Validator.isNull(adminActions)){
                    adminActions = new AdminActions();
                    adminActions.setAction("export_municipality_applications");
                    adminActions.setStartDate(new Date());
                    adminActions.setRunning(true);
                    adminActions.setUser(userMapper.toEntity(userConnected));
                    adminActions = adminActionsRepository.save(adminActions);
                }
                else{
                    if(adminActions.isRunning()){
                        throw new AppException("Send notifications is already running");
                    }
                    adminActions.setStartDate(new Date());
                    adminActions.setRunning(true);
                    adminActions.setEndDate(null);
                    adminActions.setUser(userMapper.toEntity(userConnected));
                    adminActions = adminActionsRepository.save(adminActions);
                }

                PagingSortingDTO pagingSortingData = new PagingSortingDTO(0,
                        municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country), "lauId", 1);

                List<ApplicantListItemDTO> applicants = applicantListItemMapper.toDTOList(
                        applicantListItemRepository.findDgconnApplicantsListContainingNameOrderByLauIdAsc(
                                callId, country, null, pagingSortingData.getOffset(), pagingSortingData.getCount()));

                ExcelExportGenerator excelExportGenerator = new ExcelExportGenerator(applicants, ApplicantListItemDTO.class);
                byte[] bytes = excelExportGenerator.exportExcelFile("applicants").toByteArray();

                FileUtils.writeByteArrayToFile(new File(TMP_DIR.concat("excel_file_"+userConnected.getId()+".xlsx")), bytes);

                adminActions.setRunning(false);
                adminActions.setEndDate(new Date());
                adminActionsRepository.save(adminActions);
            }
        }
        catch (Exception e) {
            if (dataClass == BeneficiaryListItem.class || dataClass == BeneficiaryListItemDTO.class) {
                if(Validator.isNotNull(adminActions)){
                    adminActions.setAction("export_beneficiaries");
                    adminActions.setStartDate(null);
                    adminActions.setRunning(false);
                    adminActions.setEndDate(null);
                    adminActions.setUser(userMapper.toEntity(userConnected));
                    adminActionsRepository.save(adminActions);
                }
            } else if (dataClass == ApplicantListItem.class || dataClass == ApplicantListItemDTO.class) {
                if(Validator.isNotNull(adminActions)){
                    adminActions.setAction("export_municipality_applications");
                    adminActions.setStartDate(null);
                    adminActions.setRunning(false);
                    adminActions.setEndDate(null);
                    adminActions.setUser(userMapper.toEntity(userConnected));
                    adminActionsRepository.save(adminActions);
                }
            }

        }

    }






}
