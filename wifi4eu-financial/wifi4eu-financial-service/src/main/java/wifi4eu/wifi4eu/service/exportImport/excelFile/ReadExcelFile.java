package wifi4eu.wifi4eu.service.exportImport.excelFile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import wifi4eu.wifi4eu.common.dto.model.ExportImportLEFDTO;
import wifi4eu.wifi4eu.mapper.exportImport.ExportImportLEFMapper;
import wifi4eu.wifi4eu.repository.exportImport.ExportImportLEFRepository;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;


public class ReadExcelFile {

    public ExportImportLEFMapper exportImportLEFMapper;
    public ExportImportLEFRepository exportImportLEFRepository;

    public ReadExcelFile(){}

    public ReadExcelFile(ExportImportLEFRepository exportImportLEFRepository, ExportImportLEFMapper exportImportLEFMapper) {
        this.exportImportLEFMapper = exportImportLEFMapper;
        this.exportImportLEFRepository = exportImportLEFRepository;
    }

    public void readExcelFile(){
        JFileChooser fc = new JFileChooser();
        int response = fc.showOpenDialog(null);
        File fil=null;
        if (response == JFileChooser.APPROVE_OPTION) {
            fil = fc.getSelectedFile();
        }

        String message="<v3:LegalEntityCreateRequest xmlns:v3=\"http://www.ec.europa.eu/budg/abac/legal_entity/v3\" xmlns:rep=\"http://www.ec.europa.eu/budg/report\">\n" +
                "<v2:MessageHeader xmlns:v2=\"http://www.ec.europa.eu/budg/abac/kernel/v2\"/>\n" +
                "<v3:PrivateLawBody>\n" +
                "<v3:AccountGroupCode>LE05</v3:AccountGroupCode>\n" +
                "<v3:DuplicateCheckBypassFlag>false</v3:DuplicateCheckBypassFlag>\n" +
                "<v3:LanguageCode>EN</v3:LanguageCode>\n" +
                "<v3:LocalKey>AGM0200268</v3:LocalKey>\n" +
                "<v3:OfficialName>OFFIC NAA</v3:OfficialName>\n" +
                "<v3:OfficialAddress>\n" +
                "<v3:City>FD</v3:City>\n" +
                "<v3:CountryCode>IN</v3:CountryCode>\n" +
                "<v3:StreetNr>FDF</v3:StreetNr>\n" +
                "<v3:County>FD</v3:County>\n" +
                "</v3:OfficialAddress>\n" +
                "<v3:ResponsibleOrganisation>\n" +
                "<v2:Name xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">PMO.5</v2:Name>\n" +
                "<v2:TypeCode xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">UNT</v2:TypeCode>\n" +
                "</v3:ResponsibleOrganisation>\n" +
                "<v3:AresDocument>\n" +
                "<v2:OfficialDocument xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">true</v2:OfficialDocument>\n" +
                "<v2:Reference xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">Ares(2018)16362</v2:Reference>\n" +
                "</v3:AresDocument>\n" +
                "<v3:BudgetCompanyCode>BG32</v3:BudgetCompanyCode>\n" +
                "<v3:LocalSystemCode>AGM</v3:LocalSystemCode>\n" +
                "<v3:ResponsibleUser>\n" +
                "<v2:UserId xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">HAMEEMO</v2:UserId>\n" +
                "</v3:ResponsibleUser>\n" +
                "<v3:BankAccountLink>\n" +
                "<v3:BankAccountLocalKey>0002783079</v3:BankAccountLocalKey>\n" +
                "<v3:StatusCode>VALID</v3:StatusCode>\n" +
                "</v3:BankAccountLink>\n" +
                "<v3:Acronym>DFDF</v3:Acronym>\n" +
                "<v3:BusinessName>BUSINESS</v3:BusinessName>\n" +
                "<v3:LegalFormCode>LBG</v3:LegalFormCode>\n" +
                "<v3:MainRegistrationInfo>\n" +
                "<v3:RegistrationAuthority/>\n" +
                "<v3:RegistrationIso2CountryCode>IN</v3:RegistrationIso2CountryCode>\n" +
                "<v3:RegistrationNumber>CHE016101052</v3:RegistrationNumber>\n" +
                "</v3:MainRegistrationInfo>\n" +
                "</v3:PrivateLawBody>\n" +
                "<v3:Visa>\n" +
                "<v2:ActionCode xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">AC</v2:ActionCode>\n" +
                "<v2:ActionDate xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">2018-02-21T16:06:56.815+01:00</v2:ActionDate>\n" +
                "<v2:AgentId xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">HAMEEMO</v2:AgentId>\n" +
                "<v2:WorkflowCenterCode xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">THIRD PARTY (0100001)</v2:WorkflowCenterCode>\n" +
                "<v2:WorkflowOrganisationName xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">PMO</v2:WorkflowOrganisationName>\n" +
                "</v3:Visa>\n" +
                "</v3:LegalEntityCreateRequest>\n";
        //HashMap<String,String> retHashMap = ((Budg_soa_webUI)UI.getCurrent()).getJmsProducer().sendMessage(msgCall.getMessageCorrelation());
        //HashMap<String,String> retHashMap = ((Budg_soa_webUI)UI.getCurrent()).getJmsProducer().sendMessage(msgCall.getMessageCorrelation());

        /*try (FileInputStream file = new FileInputStream(fil)) {
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            XSSFSheet sheet = worbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            int count=0;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if(count>0) {
                      ExportImportLEFDTO eI=new ExportImportLEFDTO();
                      eI.setId(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      eI.setEuRank(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      eI.setCountryRank(Integer.parseInt(row.getCell(1).getStringCellValue()));
                      eI.setCountryName(row.getCell(2).getStringCellValue());
                      eI.setMunicipalityName(row.getCell(3).getStringCellValue());
                      eI.setIssue(row.getCell(4).getStringCellValue());
                      eI.setNumberOfRegistrations(Integer.parseInt(row.getCell(5).getStringCellValue()));
                      eI.setAbacReference(row.getCell(6).getStringCellValue());
                      eI.setAbacStandarName(row.getCell(7).getStringCellValue());
                      eI.setMunicipality(Integer.parseInt(row.getCell(0).getStringCellValue()));
                      //exportImportLEFRepository.save(exportImportLEFMapper.toEntity(eI));
                      //HashMap<String,String> retHashMap = ((Budg_soa_webUI)UI.getCurrent()).getJmsProducer().sendMessage(msgCall.getMessageCorrelation());
                }
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }*/
    }
}
