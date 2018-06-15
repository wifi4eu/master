package edcchelpdesk;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.annotation.FunctionName;
import com.microsoft.azure.serverless.functions.annotation.TimerTrigger;
import edcchelpdesk.dto.Response;
import edcchelpdesk.dto.Token;
import edcchelpdesk.getrequest.Constants;
import edcchelpdesk.getrequest.Request;
import edcchelpdesk.getrequest.utils.CoreProcess;
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

    @FunctionName("edccTimer")
    public String run(
            @TimerTrigger(name = "edccTimerInfo", schedule = "0 0 9,17 * * MON-FRI")
//            @TimerTrigger(name = "edccTimerInfo", schedule = "*/10 * * * * *")
            String timerInfo,
            final ExecutionContext executionContext) {

        executionContext.getLogger().info("Timer trigger input: " + timerInfo);
        return CoreProcess.exec(timerInfo);

    }
}
