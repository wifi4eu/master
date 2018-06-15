package edcchelpdesk.getrequest.utils;

import edcchelpdesk.dto.Response;
import edcchelpdesk.dto.Token;
import edcchelpdesk.getrequest.Constants;
import edcchelpdesk.getrequest.Request;

public class CoreProcess {

    public static String exec(final String timerInfo) {
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
    }
}
