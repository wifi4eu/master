package edcchelpdesk;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.HttpRequestMessage;
import com.microsoft.azure.serverless.functions.HttpResponseMessage;
import com.microsoft.azure.serverless.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.serverless.functions.annotation.FunctionName;
import com.microsoft.azure.serverless.functions.annotation.HttpTrigger;
import edcchelpdesk.dto.Response;
import edcchelpdesk.dto.Token;
import edcchelpdesk.getrequest.Constants;
import edcchelpdesk.getrequest.Request;
import edcchelpdesk.getrequest.utils.RequestUtils;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/edcc". Two ways to invoke it using "curl" command in bash:
     *    curl {your host}/api/edcc
     *    Example - curl http://localhost:7071/api/edcc
     *    Documentation: https://docs.microsoft.com/en-us/azure/azure-functions/functions-create-first-java-maven
     */
    @FunctionName("edcc")
    public HttpResponseMessage<String> run(
            @HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        context.getLogger().info("Java HTTP trigger processed a request.");

        try {
            Request requester = new Request();
            final Token token = (Token) requester.send(Constants.URL_GET_TOKEN, Constants.POST, RequestUtils.generateHeaders(), Token.class);
            System.out.println(token);
            Response response = (Response) requester.send(Constants.URL_CALL_EDCC+token.getAccess_token(), Constants.GET, RequestUtils.generateHeaders(), Response.class);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
            return request.createResponse(500, "Error getting token");
        }


        return request.createResponse(200, "Process successfully");
    }
}
