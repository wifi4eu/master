package wifi4eu.wifi4eu.service.exportImport.file;

import cec.budg.soatube.client.async.JmsProducerLocal;
import cec.budg.soatube.client.util.BudgSOAException;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
import com.vaadin.ui.Table;
import com.vaadin.server.Page;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Notification;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import wifi4eu.wifi4eu.mapper.exportImport.ValidatedBCMapper;
import wifi4eu.wifi4eu.mapper.exportImport.ValidatedLEFMapper;
import wifi4eu.wifi4eu.repository.exportImport.ValidatedBCRepository;
import wifi4eu.wifi4eu.repository.exportImport.ValidatedLEFRepository;
import wifi4eu.wifi4eu.service.exportImport.messageCall.SoaMessageCall;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.swing.*;
import java.io.File;



public class CallAbac {

    private static Logger LOGGER = Logger.getLogger("budg.soa.logging");
//    public ExportImportLEFMapper exportImportLEFMapper;
//    public ExportImportLEFRepository exportImportLEFRepository;
//    private SoatubeWSClientLocal soaTubeWSClient;
//    private JmsProducerLocal jmsProducer;
    private BeanFieldGroup<SoaMessageCall> fieldGroup;
    private BeanItemContainer<SoaMessageCall> messageContainer;

    @Autowired
    ValidatedLEFMapper validatedLEFMapper;

    @Autowired
    ValidatedLEFRepository validatedLEFRepository;

    @Autowired
    ValidatedBCMapper validatedBCMapper;

    @Autowired
    ValidatedBCRepository validatedBCRepository;

    public CallAbac(){}

//    public CallAbac(ExportImportLEFRepository exportImportLEFRepository, ExportImportLEFMapper exportImportLEFMapper) {
//        this.exportImportLEFMapper = exportImportLEFMapper;
//        this.exportImportLEFRepository = exportImportLEFRepository;
//    }

    public void readImportFileLEF(JmsProducerLocal jmsProducer, String xml) throws NamingException, BudgSOAException, FieldGroup.CommitException {
//        JFileChooser fc = new JFileChooser();
//        int response = fc.showOpenDialog(null);
//        File fil=null;
//        if (response == JFileChooser.APPROVE_OPTION) {
//            fil = fc.getSelectedFile();
//        }
//        String message="";
//        if(fil.getName().equals("ExportBeneficiariInformation.csv")) {

        String message=xml;
//        String message = "<v3:LegalEntityCreateRequest xmlns:v3=\"http://www.ec.europa.eu/budg/abac/legal_entity/v3\" xmlns:rep=\"http://www.ec.europa.eu/budg/report\">\n" +
//                    "<v2:MessageHeader xmlns:v2=\"http://www.ec.europa.eu/budg/abac/kernel/v2\"/>\n" +
//                    "<v3:PrivateLawBody>\n" +
//                    "<v3:AccountGroupCode>LE05</v3:AccountGroupCode>\n" +
//                    "<v3:DuplicateCheckBypassFlag>false</v3:DuplicateCheckBypassFlag>\n" +
//                    "<v3:LanguageCode>EN</v3:LanguageCode>\n" +
//                    "<v3:LocalKey>AGM0200268</v3:LocalKey>\n" +
//                    "<v3:OfficialName>OFFIC NAA</v3:OfficialName>\n" +
//                    "<v3:OfficialAddress>\n" +
//                    "<v3:City>FD</v3:City>\n" +
//                    "<v3:CountryCode>IN</v3:CountryCode>\n" +
//                    "<v3:StreetNr>FDF</v3:StreetNr>\n" +
//                    "<v3:County>FD</v3:County>\n" +
//                    "</v3:OfficialAddress>\n" +
//                    "<v3:ResponsibleOrganisation>\n" +
//                    "<v2:Name xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">PMO.5</v2:Name>\n" +
//                    "<v2:TypeCode xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">UNT</v2:TypeCode>\n" +
//                    "</v3:ResponsibleOrganisation>\n" +
//                    "<v3:AresDocument>\n" +
//                    "<v2:OfficialDocument xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">true</v2:OfficialDocument>\n" +
//                    "<v2:Reference xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">Ares(2018)16362</v2:Reference>\n" +
//                    "</v3:AresDocument>\n" +
//                    "<v3:BudgetCompanyCode>BG32</v3:BudgetCompanyCode>\n" +
//                    "<v3:LocalSystemCode>AGM</v3:LocalSystemCode>\n" +
//                    "<v3:ResponsibleUser>\n" +
//                    "<v2:UserId xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">HAMEEMO</v2:UserId>\n" +
//                    "</v3:ResponsibleUser>\n" +
//                    "<v3:BankAccountLink>\n" +
//                    "<v3:BankAccountLocalKey>0002783079</v3:BankAccountLocalKey>\n" +
//                    "<v3:StatusCode>VALID</v3:StatusCode>\n" +
//                    "</v3:BankAccountLink>\n" +
//                    "<v3:Acronym>DFDF</v3:Acronym>\n" +
//                    "<v3:BusinessName>BUSINESS</v3:BusinessName>\n" +
//                    "<v3:LegalFormCode>LBG</v3:LegalFormCode>\n" +
//                    "<v3:MainRegistrationInfo>\n" +
//                    "<v3:RegistrationAuthority/>\n" +
//                    "<v3:RegistrationIso2CountryCode>IN</v3:RegistrationIso2CountryCode>\n" +
//                    "<v3:RegistrationNumber>CHE016101052</v3:RegistrationNumber>\n" +
//                    "</v3:MainRegistrationInfo>\n" +
//                    "</v3:PrivateLawBody>\n" +
//                    "<v3:Visa>\n" +
//                    "<v2:ActionCode xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">AC</v2:ActionCode>\n" +
//                    "<v2:ActionDate xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">2018-02-21T16:06:56.815+01:00</v2:ActionDate>\n" +
//                    "<v2:AgentId xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">HAMEEMO</v2:AgentId>\n" +
//                    "<v2:WorkflowCenterCode xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">THIRD PARTY (0100001)</v2:WorkflowCenterCode>\n" +
//                    "<v2:WorkflowOrganisationName xmlns:v2=\"http://www.ec.europa.eu/budg/abac/associated_object/v2\">PMO</v2:WorkflowOrganisationName>\n" +
//                    "</v3:Visa>\n" +
//                    "</v3:LegalEntityCreateRequest>\n";
//        }

        /*InitialContext ic = new InitialContext();
        jmsProducer = (JmsProducerLocal)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/JmsProducer");
        soaTubeWSClient = (SoatubeWSClientLocal)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/SoatubeWSClient");*/

        buildMessagesContainer();
        buildMessageInfoTable();

        fieldGroup = new BeanFieldGroup<SoaMessageCall>(SoaMessageCall.class);
        fieldGroup.setItemDataSource(new SoaMessageCall());
        fieldGroup.bindMemberFields(this);
        SoaMessageCall msgCall = fieldGroup.getItemDataSource().getBean();
        msgCall.setInvMethod("ASYNC");

        try{
            msgCall.setMessageCorrelation(message);
            fieldGroup.commit();
            LOGGER.info("Message Correlation="+msgCall.getMessageCorrelation());
            if(msgCall.getMessageCorrelation()!=null && msgCall.getMessageCorrelation().isEmpty() ){
                msgCall.setMessageCorrelation(UUID.randomUUID().toString());
            }

            //Assync Call
            HashMap<String,String> retHashMap = jmsProducer.sendMessage(message);

            msgCall.setDatabaseName(retHashMap.get("DB_NAME"));
            msgCall.setAppVersion(retHashMap.get("APP_VERSION"));
            msgCall.setSuccessfullInvocation(true);
            messageContainer.addBean(msgCall);
            fieldGroup.setItemDataSource(new SoaMessageCall());

            //Save th result


        }catch (Exception e) {
            LOGGER.error("Error",e);
            msgCall.setErrorMessage(e.getMessage());
            msgCall.setSuccessfullInvocation(false);
            messageContainer.addBean(msgCall);
            fieldGroup.setItemDataSource(new SoaMessageCall());
        }


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

    public void readImportFileBC(JmsProducerLocal jmsProducer, String xml) throws NamingException, BudgSOAException, FieldGroup.CommitException {
//        JFileChooser fc = new JFileChooser();
//        int response = fc.showOpenDialog(null);
//        File fil=null;
//        if (response == JFileChooser.APPROVE_OPTION) {
//            fil = fc.getSelectedFile();
//        }
//        String message="";
//        if(fil.getName().equals("ExportBudgetaryCommitment.csv")) {

        String message=xml;
//        String message = "<v11:AgentId>DUMONFA</v11:AgentId>\n" +
//                    "</v11:MessageHeader>\n" +
//                    "<v1:BudgetaryCommitmentLevel2>\n" +
//                    "<v1:BeneficiaryCountryIso2Code>FI</v1:BeneficiaryCountryIso2Code>\n" +
//                    "<v1:BudgetManagementTypeCode>SM</v1:BudgetManagementTypeCode>\n" +
//                    "<v1:ClassCode>FP</v1:ClassCode>\n" +
//                    "<v1:CurrencyIso3Code>EUR</v1:CurrencyIso3Code>\n" +
//                    "<v1:CurrentBudgetYear>B2018</v1:CurrentBudgetYear>\n" +
//                    "<v1:ExpenditureCategoryCode>FGA</v1:ExpenditureCategoryCode>\n" +
//                    "<v1:FdiDelimiterCode>EA</v1:FdiDelimiterCode>\n" +
//                    "<v1:FinancialRegulationGroupCode>FR2012</v1:FinancialRegulationGroupCode>\n" +
//                    "<v1:ImplementedByCode>MS</v1:ImplementedByCode>\n" +
//                    "<v1:LegalJustificationCode>BF</v1:LegalJustificationCode>\n" +
//                    "<v1:LocalKey>AGV12018FIPAU</v1:LocalKey>\n" +
//                    "<v1:PaymentClassCode>MUL</v1:PaymentClassCode>\n" +
//                    "<v1:ProposedFdiDate>2019-01-31+01:00</v1:ProposedFdiDate>\n" +
//                    "<v1:ResponsibleOrganisation>\n" +
//                    "<v11:Name xmlns:v11=\"http://www.ec.europa.eu/budg/abac/organisation/v1\">AGRI.R.4</v11:Name>\n" +
//                    "<v11:TypeCode xmlns:v11=\"http://www.ec.europa.eu/budg/abac/organisation/v1\">UNT</v11:TypeCode>\n" +
//                    "</v1:ResponsibleOrganisation>\n" +
//                    "<v1:UserReference>PAIEMENT FEAGA 2018 FINLAND</v1:UserReference>\n" +
//                    "<v1:AresDocuments>\n" +
//                    "<v11:AresDocument xmlns:v11=\"http://www.ec.europa.eu/budg/abac/ares_document/v1\">\n" +
//                    "<v11:Description>T103 Declaration FI 2017/11</v11:Description>\n" +
//                    "<v11:OfficialDocument>true</v11:OfficialDocument>\n" +
//                    "<v11:Reference>Ares(2012)12345</v11:Reference>\n" +
//                    "</v11:AresDocument>\n" +
//                    "</v1:AresDocuments>\n" +
//                    "<v1:BudgetCompanyCode>BG32</v1:BudgetCompanyCode>\n" +
//                    "<v1:ContractorReferences>\n" +
//                    "<v11:PrimaryContractorReference xmlns:v11=\"http://www.ec.europa.eu/budg/abac/contractor_reference/v1\">\n" +
//                    "<v11:LocalSystemCode>AGV</v11:LocalSystemCode>\n" +
//                    "<v11:StatusCode>ACTIVE</v11:StatusCode>\n" +
//                    "<v11:BankAccountLocalKey>0002113983</v11:BankAccountLocalKey>\n" +
//                    "<v11:LegalEntityLocalKey>6000005308</v11:LegalEntityLocalKey>\n" +
//                    "</v11:PrimaryContractorReference>\n" +
//                    "</v1:ContractorReferences>\n" +
//                    "<v1:LocalSystemCode>AGV</v1:LocalSystemCode>\n" +
//                    "<v1:CommitmentPositions>\n" +
//                    "<v1:BudgetaryCommitmentLevel2Position>\n" +
//                    "<v1:AccountReference>PAIEMENT FEAGA</v1:AccountReference>\n" +
//                    "<v1:AppropriationLocalKey>BGUE-B2018-05.999999-C1-AGRI</v1:AppropriationLocalKey>\n" +
//                    "<v1:CarryForwardFlag>true</v1:CarryForwardFlag>\n" +
//                    "<v1:DgName>AGRI</v1:DgName>\n" +
//                    "<v1:DocumentDetailNumber>1</v1:DocumentDetailNumber>\n" +
//                    "<v1:EntryInCurrencyAmount>0.00</v1:EntryInCurrencyAmount>\n" +
//                    "<v1:ExpenseTypeCode>AUT</v1:ExpenseTypeCode>\n" +
//                    "<v1:PolicyAreaCode>AGRI</v1:PolicyAreaCode>\n" +
//                    "<v1:ProgramCode>AGR_GLOB</v1:ProgramCode>\n" +
//                    "<v1:AssociatedCountries>\n" +
//                    "<v11:AssociatedCountry xmlns:v11=\"http://www.ec.europa.eu/budg/abac/associated_country/v1\">\n" +
//                    "<v11:CountryCode>FI</v11:CountryCode>\n" +
//                    "<v11:Percentage>100</v11:Percentage>\n" +
//                    "</v11:AssociatedCountry>\n" +
//                    "</v1:AssociatedCountries>\n" +
//                    "</v1:BudgetaryCommitmentLevel2Position>\n" +
//                    "</v1:CommitmentPositions>\n" +
//                    "</v1:BudgetaryCommitmentLevel2>\n" +
//                    "</v1:BudgetaryCommitmentLevel2CreateRequest>\n";
        //}

//        InitialContext ic = new InitialContext();
//        jmsProducer = (JmsProducerLocal)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/JmsProducer");
//        soaTubeWSClient = (SoatubeWSClientLocal)ic.lookup("java:global/wifi4eu-financial/wifi4eu-financial-web/SoatubeWSClient");

        buildMessagesContainer();
        buildMessageInfoTable();

        fieldGroup = new BeanFieldGroup<SoaMessageCall>(SoaMessageCall.class);
        fieldGroup.setItemDataSource(new SoaMessageCall());
        fieldGroup.bindMemberFields(this);
        SoaMessageCall msgCall = fieldGroup.getItemDataSource().getBean();
        msgCall.setInvMethod("ASYNC");

        try{
            msgCall.setMessageCorrelation(message);
            fieldGroup.commit();
            LOGGER.info("Message Correlation="+msgCall.getMessageCorrelation());
            if(msgCall.getMessageCorrelation()!=null && msgCall.getMessageCorrelation().isEmpty() ){
                msgCall.setMessageCorrelation(UUID.randomUUID().toString());
            }

            //Assync Call
            HashMap<String,String> retHashMap = jmsProducer.sendMessage(message);

            msgCall.setDatabaseName(retHashMap.get("DB_NAME"));
            msgCall.setAppVersion(retHashMap.get("APP_VERSION"));
            msgCall.setSuccessfullInvocation(true);
            messageContainer.addBean(msgCall);
            fieldGroup.setItemDataSource(new SoaMessageCall());

            //Save th result

        }catch (Exception e) {
            LOGGER.error("Error",e);
            msgCall.setErrorMessage(e.getMessage());
            msgCall.setSuccessfullInvocation(false);
            messageContainer.addBean(msgCall);
            fieldGroup.setItemDataSource(new SoaMessageCall());
        }


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

    private Table buildMessageInfoTable() {
        Table messageInfoTable = new Table();
        messageInfoTable.setWidth("100%");
        messageInfoTable.setContainerDataSource(messageContainer);
        messageInfoTable.setVisibleColumns("messageCorrelation", "status" , "invMethod" , "databaseName");
        messageInfoTable.setColumnHeaders( new String[] {" Correlation ID","Status", "Invocation method", " Database Name"} );
        messageInfoTable.setSelectable(true);
        messageInfoTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
            @Override
            public String getStyle( Table table , Object itemId, Object propertyId) {
                String styleName=null;

                if(propertyId!=null){
                    if(propertyId.equals("status")){
                        Item item = table.getItem(itemId);

                        boolean success= (Boolean) item.getItemProperty("successfullInvocation").getValue();
                        if(success){
                            return "success";
                        }
                        else{
                            return "failure";
                        }
                    }
                }
                return styleName;
            }
        });
        messageInfoTable.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                SoaMessageCall  soaMessageCall = ((SoaMessageCall)event.getProperty().getValue());
                if(soaMessageCall!=null && soaMessageCall.isSuccessfullInvocation()==false){
                    String errMsg=soaMessageCall.getErrorMessage()==null? "" : soaMessageCall.getErrorMessage();
                    Notification notif = new Notification("Response Error", errMsg, Notification.Type.ERROR_MESSAGE);
                    notif.show(Page.getCurrent());
                }
            }
        });
        return messageInfoTable;
    }

    private void buildMessagesContainer() {
        messageContainer = new BeanItemContainer<SoaMessageCall>(SoaMessageCall.class);
    }
}
