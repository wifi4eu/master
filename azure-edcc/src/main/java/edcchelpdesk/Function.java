package edcchelpdesk;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.annotation.FunctionName;
import com.microsoft.azure.serverless.functions.annotation.TimerTrigger;
import edcchelpdesk.dto.Response;
import edcchelpdesk.dto.Token;
import edcchelpdesk.getrequest.Constants;
import edcchelpdesk.getrequest.Request;
import edcchelpdesk.getrequest.utils.RequestUtils;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/edcc". Two ways to invoke it using "curl" command in bash:
     *    curl {your host}/api/edcc
     *    Example - curl http://localhost:7071/api/edcc
     *    Example - curl https://azure-edcc-20180612164351176.azurewebsites.net/api/edcc
     *    Documentation: https://docs.microsoft.com/en-us/azure/azure-functions/functions-create-first-java-maven
     */
//    @FunctionName("Timer")
////    @QueueOutput(name = "myQueueItem", queueName = "walkthrough", connection = "AzureWebJobsStorage")
//    public String functionHandler(@TimerTrigger(name = "timerInfo", schedule = "0 0 9,17 * * MON-FRI") String timerInfo, final ExecutionContext executionContext) {
//        executionContext.getLogger().info("Timer trigger input: " + timerInfo);
//        return "From timer: \"" + timerInfo + "\"";
//    }


    @FunctionName("edccTimer")
    public String run(
//            @TimerTrigger(name = "edccTimerInfo", schedule = "0 0 9,17 * * MON-FRI")
            @TimerTrigger(name = "edccTimerInfo", schedule = "*/10 * * * * *")
            String timerInfo,
            final ExecutionContext executionContext) {
//            HttpRequestMessage<Optional<String>> request,
//            final ExecutionContext context) {

        executionContext.getLogger().info("Timer trigger input: " + timerInfo);
        StringBuilder returnInfo = new StringBuilder("Timer trigger executed ");

        try {
            Request requester = new Request();
            final Token token = (Token) requester.send(Constants.URL_GET_TOKEN, Constants.POST, RequestUtils.generateHeaders(), Token.class);
            System.out.println("Token created successfully : " + token);
            Response response = (Response) requester.send(Constants.URL_CALL_EDCC+token.getAccess_token(), Constants.GET, RequestUtils.generateHeaders(), Response.class);
            System.out.println("Response get successfully : " + response);
            returnInfo.append("successfully at ");
        } catch (Exception e) {
            e.printStackTrace();
            returnInfo.append("wrongly at ");
        } finally {
            returnInfo.append(timerInfo);
        }

        return returnInfo.toString();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return request.createResponse(400, "Please pass a name on the query string or in the request body");
        } else {
            return request.createResponse(200, "Hello, " + name);
        }
*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
