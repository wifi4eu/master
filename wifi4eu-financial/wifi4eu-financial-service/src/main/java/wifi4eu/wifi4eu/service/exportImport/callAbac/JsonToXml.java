package wifi4eu.wifi4eu.service.exportImport.callAbac;


import java.io.BufferedWriter;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.Reader;
        import java.nio.charset.Charset;
        import org.json.JSONException;//http://bit.ly/12O4D2w

public class JsonToXml
{
    private static String InputPath = "./large.json";
    private static String OutputPath = "./output.xml";

    public String jsonToXml(String json) throws FileNotFoundException, IOException, JSONException {
    //public static void main(String[] args) throws FileNotFoundException, IOException, JSONException {
        //Read JSON File
        //String json = readFile(InputPath);//Read File
//         json="{\"v3:LegalEntityCreateRequest\": {\n" +
//                "    \"v2:MessageHeader\": {\"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/kernel/v2\"},\n" +
//                "    \"xmlns:rep\": \"http://www.ec.europa.eu/budg/report\",\n" +
//                "    \"v3:PrivateLawBody\": {\n" +
//                "        \"v3:BankAccountLink\": {\n" +
//                "            \"v3:BankAccountLocalKey\": \"0002783079\",\n" +
//                "            \"v3:StatusCode\": \"VALID\"\n" +
//                "        },\n" +
//                "        \"v3:LocalKey\": \"AGM0200268\",\n" +
//                "        \"v3:MainRegistrationInfo\": {\n" +
//                "            \"v3:RegistrationIso2CountryCode\": \"IN\",\n" +
//                "            \"v3:RegistrationAuthority\": \"\",\n" +
//                "            \"v3:RegistrationNumber\": \"CHE016101052\"\n" +
//                "        },\n" +
//                "        \"v3:DuplicateCheckBypassFlag\": false,\n" +
//                "        \"v3:LocalSystemCode\": \"AGM\",\n" +
//                "        \"v3:BudgetCompanyCode\": \"BG32\",\n" +
//                "        \"v3:AccountGroupCode\": \"LE05\",\n" +
//                "        \"v3:ResponsibleUser\": {\"v2:UserId\": {\n" +
//                "            \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "            \"content\": \"HAMEEMO\"\n" +
//                "        }},\n" +
//                "        \"v3:ResponsibleOrganisation\": {\n" +
//                "            \"v2:TypeCode\": {\n" +
//                "                \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "                \"content\": \"UNT\"\n" +
//                "            },\n" +
//                "            \"v2:Name\": {\n" +
//                "                \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "                \"content\": \"PMO.5\"\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"v3:LanguageCode\": \"EN\",\n" +
//                "        \"v3:OfficialName\": \"OFFIC NAA\",\n" +
//                "        \"v3:AresDocument\": {\n" +
//                "            \"v2:Reference\": {\n" +
//                "                \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "                \"content\": \"Ares(2018)16362\"\n" +
//                "            },\n" +
//                "            \"v2:OfficialDocument\": {\n" +
//                "                \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "                \"content\": true\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"v3:OfficialAddress\": {\n" +
//                "            \"v3:CountryCode\": \"IN\",\n" +
//                "            \"v3:StreetNr\": \"FDF\",\n" +
//                "            \"v3:City\": \"FD\",\n" +
//                "            \"v3:County\": \"FD\"\n" +
//                "        },\n" +
//                "        \"v3:BusinessName\": \"BUSINESS\",\n" +
//                "        \"v3:Acronym\": \"DFDF\",\n" +
//                "        \"v3:LegalFormCode\": \"LBG\"\n" +
//                "    },\n" +
//                "    \"xmlns:v3\": \"http://www.ec.europa.eu/budg/abac/legal_entity/v3\",\n" +
//                "    \"v3:Visa\": {\n" +
//                "        \"v2:ActionDate\": {\n" +
//                "            \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "            \"content\": \"2018-02-21T16:06:56.815+01:00\"\n" +
//                "        },\n" +
//                "        \"v2:ActionCode\": {\n" +
//                "            \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "            \"content\": \"AC\"\n" +
//                "        },\n" +
//                "        \"v2:WorkflowOrganisationName\": {\n" +
//                "            \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "            \"content\": \"PMO\"\n" +
//                "        },\n" +
//                "        \"v2:AgentId\": {\n" +
//                "            \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "            \"content\": \"HAMEEMO\"\n" +
//                "        },\n" +
//                "        \"v2:WorkflowCenterCode\": {\n" +
//                "            \"xmlns:v2\": \"http://www.ec.europa.eu/budg/abac/associated_object/v2\",\n" +
//                "            \"content\": \"THIRD PARTY (0100001)\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}}";

         json="{\"v1:BudgetaryCommitmentLevel2CreateRequest\": {\n" +
                "    \"v1:BudgetaryCommitmentLevel2\": {\n" +
                "        \"v1:BeneficiaryCountryIso2Code\": \"FI\",\n" +
                "        \"v1:ClassCode\": \"FP\",\n" +
                "        \"v1:ContractorReferences\": {\"v11:PrimaryContractorReference\": {\n" +
                "            \"v11:StatusCode\": \"ACTIVE\",\n" +
                "            \"xmlns:v11\": \"http://www.ec.europa.eu/budg/abac/contractor_reference/v1\",\n" +
                "            \"v11:LegalEntityLocalKey\": 6000005308,\n" +
                "            \"v11:LocalSystemCode\": \"AGV\",\n" +
                "            \"v11:BankAccountLocalKey\": \"0002113983\"\n" +
                "        }},\n" +
                "        \"v1:LocalSystemCode\": \"AGV\",\n" +
                "        \"v1:UserReference\": \"PAIEMENT FEAGA 2018 FINLAND\",\n" +
                "        \"v1:FinancialRegulationGroupCode\": \"FR2012\",\n" +
                "        \"v1:BudgetCompanyCode\": \"BG32\",\n" +
                "        \"v1:CurrentBudgetYear\": \"B2018\",\n" +
                "        \"v1:ImplementedByCode\": \"MS\",\n" +
                "        \"v1:CommitmentPositions\": {\"v1:BudgetaryCommitmentLevel2Position\": {\n" +
                "            \"v1:EntryInCurrencyAmount\": 0,\n" +
                "            \"v1:AppropriationLocalKey\": \"BGUE-B2018-05.999999-C1-AGRI\",\n" +
                "            \"v1:DgName\": \"AGRI\",\n" +
                "            \"v1:PolicyAreaCode\": \"AGRI\",\n" +
                "            \"v1:CarryForwardFlag\": true,\n" +
                "            \"v1:ExpenseTypeCode\": \"AUT\",\n" +
                "            \"v1:DocumentDetailNumber\": 1,\n" +
                "            \"v1:AccountReference\": \"PAIEMENT FEAGA\",\n" +
                "            \"v1:ProgramCode\": \"AGR_GLOB\",\n" +
                "            \"v1:AssociatedCountries\": {\"v11:AssociatedCountry\": {\n" +
                "                \"xmlns:v11\": \"http://www.ec.europa.eu/budg/abac/associated_country/v1\",\n" +
                "                \"v11:CountryCode\": \"FI\",\n" +
                "                \"v11:Percentage\": 100\n" +
                "            }}\n" +
                "        }},\n" +
                "        \"v1:ResponsibleOrganisation\": {\n" +
                "            \"v11:Name\": {\n" +
                "                \"xmlns:v11\": \"http://www.ec.europa.eu/budg/abac/organisation/v1\",\n" +
                "                \"content\": \"AGRI.R.4\"\n" +
                "            },\n" +
                "            \"v11:TypeCode\": {\n" +
                "                \"xmlns:v11\": \"http://www.ec.europa.eu/budg/abac/organisation/v1\",\n" +
                "                \"content\": \"UNT\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"v1:BudgetManagementTypeCode\": \"SM\",\n" +
                "        \"v1:CurrencyIso3Code\": \"EUR\",\n" +
                "        \"v1:LocalKey\": \"AGV12018FIPAU\",\n" +
                "        \"v1:FdiDelimiterCode\": \"EA\",\n" +
                "        \"v1:AresDocuments\": {\"v11:AresDocument\": {\n" +
                "            \"v11:Description\": \"T103 Declaration FI 2017/11\",\n" +
                "            \"xmlns:v11\": \"http://www.ec.europa.eu/budg/abac/ares_document/v1\",\n" +
                "            \"v11:Reference\": \"Ares(2012)12345\",\n" +
                "            \"v11:OfficialDocument\": true\n" +
                "        }},\n" +
                "        \"v1:ExpenditureCategoryCode\": \"FGA\",\n" +
                "        \"v1:ProposedFdiDate\": \"2019-01-31+01:00\",\n" +
                "        \"v1:LegalJustificationCode\": \"BF\",\n" +
                "        \"v1:PaymentClassCode\": \"MUL\"\n" +
                "    },\n" +
                "    \"xmlns:rep\": \"http://www.ec.europa.eu/budg/report\",\n" +
                "    \"v11:MessageHeader\": {\"v11:AgentId\": \"DUMONFA\"},\n" +
                "    \"xmlns:v1\": \"http://www.ec.europa.eu/budg/abac/budgetary_commitment_level2/v1\"\n" +
                "}}";



        //Convert JSON to XML
        //String xml = convert(json, "root");//State name of root element tag
        org.json.JSONObject jsonFileObject = new org.json.JSONObject(json);
        String xml=org.json.XML.toString(jsonFileObject);
        System.out.println(xml);

//        //Write XML File
//        writeFile(OutputPath, xml);
        return xml;
    }

    public static String convert(String json, String root) throws JSONException
    {
        org.json.JSONObject jsonFileObject = new org.json.JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">"
                + org.json.XML.toString(jsonFileObject) + "</"+root+">";
        return xml;
    }

    public static String readFile(String filepath) throws FileNotFoundException, IOException
    {

        StringBuilder sb = new StringBuilder();
        InputStream in = new FileInputStream(InputPath);
        Charset encoding = Charset.defaultCharset();

        Reader reader = new InputStreamReader(in, encoding);

        int r = 0;
        while ((r = reader.read()) != -1)//Note! use read() rather than readLine()
        //Can process much larger files with read()
        {
            char ch = (char) r;
            sb.append(ch);
        }

        in.close();
        reader.close();

        return sb.toString();
    }

    public static void writeFile(String filepath, String output) throws FileNotFoundException, IOException
    {
        FileWriter ofstream = new FileWriter(filepath);
        try (BufferedWriter out = new BufferedWriter(ofstream)) {
            out.write(output);
        }
    }

}
