package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.HelpdeskIssueValidator;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.rest.constants.HelpdeskConstants;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/helpdesk/issues", description = "Helpdesk issues REST API services")
@RequestMapping("helpdesk/issues")
public class HelpdeskIssueResource {

    @Autowired
    private HelpdeskService helpdeskService;

    @Autowired
    private UserService userService;

    @Autowired
    NutsService nutsService;

    Logger _log = LogManager.getLogger(CallResource.class);

    UserContext userContext;
    UserDTO userConnected;

    @ApiOperation(value = "Get all the helpdesk issues")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HelpdeskIssueDTO> allHelpdeskIssues(HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting all the helpdesk issues");
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade){
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'allHelpdeskIssues' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e){
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'allHelpdeskIssues' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return helpdeskService.getAllHelpdeskIssues();
    }

    @ApiOperation(value = "Get helpdesk issue by specific id")
    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HelpdeskIssueDTO getHelpdeskIssueById(@PathVariable("issueId") final Integer issueId, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting helpdesk issue by id " + issueId);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issue cannot been retrieved", e.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }

        return helpdeskService.getHelpdeskIssueById(issueId);
    }

    @ApiOperation(value = "Create helpdesk issue")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskIssue(@RequestBody final HelpdeskIssueDTO helpdeskIssueDTO, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating helpdesk issue");
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (!userDTO.getEcasEmail().equals(helpdeskIssueDTO.getFromEmail())) {
                throw new AccessDeniedException("Invalid access");
            }
            List<NutsDTO> nuts = nutsService.getNutsByLevel(0);
            HelpdeskIssueValidator.validateHelpdeskIssue(helpdeskIssueDTO, nuts);

            helpdeskIssueDTO.setCreateDate(new Date().getTime());
            helpdeskIssueDTO.setStatus(0);

            HelpdeskIssueDTO resHelpdeskIssue = helpdeskService.createHelpdeskIssue(helpdeskIssueDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issue created successfully");
            return new ResponseDTO(true, resHelpdeskIssue, null);
        }catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to create the helpdesk issue", ade.getMessage());
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issue cannot been created", e.getMessage());
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    /*
    @ApiOperation(value = "Delete helpdesk by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteHelpdeskIssue(@RequestBody final Integer issueId, HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteHelpdeskIssue: " + issueId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if(userDTO.getType() != 5){
                response.sendError(HttpStatus.NOT_FOUND.value());
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            HelpdeskIssueDTO resHelpdeskIssue = helpdeskService.deleteHelpdeskIssue(issueId);
            return new ResponseDTO(true, resHelpdeskIssue, null);
        }
        catch (AccessDeniedException ade) {
          if (_log.isErrorEnabled()) {
            _log.error("Access denied on 'deleteHelpdeskIssue' operation.", ade);
        }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception e) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteHelpdeskIssue' operation.", e);
            }
        }
        return new ResponseDTO(false, null, null);
    }
    */

    @ApiOperation(value = "Send issue to helpdesk")
    @RequestMapping(value = "/create")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseDTO createHelpdeskIssues() {

        _log.info("scheduleHelpdeskIssues");

        boolean isSuccessOperation = true;
        Map<String, Boolean> allResults = new HashMap<>();
        List<HelpdeskIssueDTO> helpdeskIssueDTOS = helpdeskService.getAllHelpdeskIssueNoSubmited();

        for (HelpdeskIssueDTO helpdeskIssue : helpdeskIssueDTOS) {

            try {
                HelpdeskTicketDTO helpdeskTicketDTO = new HelpdeskTicketDTO();

                helpdeskTicketDTO.setEmailAdress(helpdeskIssue.getFromEmail());
                helpdeskTicketDTO.setEmailAdressconf(helpdeskTicketDTO.getEmailAdress());
                helpdeskTicketDTO.setUuid(HelpdeskConstants.UUID_WIFI + helpdeskIssue.getId());

                UserDTO userDTO = userService.getUserByEcasEmail(helpdeskIssue.getFromEmail());


                if (userDTO != null) {
                    helpdeskTicketDTO.setFirstname(userDTO.getName());
                    helpdeskTicketDTO.setLastname(userDTO.getSurname());

                    helpdeskTicketDTO.setTxtsubjext(helpdeskIssue.getTopic());
                    helpdeskTicketDTO.setQuestion(helpdeskIssue.getSummary());

                    boolean result = executePost(helpdeskTicketDTO.toString());
                    allResults.put(helpdeskTicketDTO.getUuid(), result);
                    isSuccessOperation = isSuccessOperation && result;

                    if (result) {
                        helpdeskIssue.setTicket(true);
                        helpdeskService.createHelpdeskIssue(helpdeskIssue);
                    } else {
                        isSuccessOperation = false;
                        _log.error("result that not containt proper text, the " + helpdeskTicketDTO.getUuid() + " helpdesk issue fails");
                    }
                } else {
                    isSuccessOperation = false;
                    _log.error("scheduleHelpdeskIssues can't retrieve the user for heldesk issue with Id " + helpdeskIssue.getId());
                }


            } catch (Exception e) {
                isSuccessOperation = false;
                _log.error("scheduleHelpdeskIssues the helpdesk issue with Id " + helpdeskIssue.getId() + " can't be processed", e);
            }
        }

        return new ResponseDTO(isSuccessOperation, allResults, null);
    }

    @SuppressWarnings("Duplicates")
    private boolean executePost(String urlParameters) {
        try {
            HttpClient httpClient = getHttpClient();
            if (httpClient != null) {
                HttpPost postRequest = new HttpPost(HelpdeskConstants.HELPDESK_URL);
                postRequest.addHeader(HelpdeskConstants.CONTENT_TYPE, HelpdeskConstants.CONTENT_TYPE_VALUE);
                postRequest.addHeader(HelpdeskConstants.CONNECTION, HelpdeskConstants.CONNECTION_VALUE);
                postRequest.addHeader(HelpdeskConstants.CONTENT_LANGUAGE, HelpdeskConstants.CONTENT_LANGUAGE_VALUE);
                postRequest.addHeader(HelpdeskConstants.ACCEPT, HelpdeskConstants.ACCEPT_VALUE);
                postRequest.addHeader(HelpdeskConstants.REFERER, HelpdeskConstants.REFERER_VALUE);
                postRequest.addHeader(HelpdeskConstants.ORIGIN, HelpdeskConstants.ORIGIN_VALUE);
                postRequest.addHeader(HelpdeskConstants.HOST, HelpdeskConstants.HOST_VALUE);

                postRequest.setEntity(new StringEntity(urlParameters, HelpdeskConstants.CHARSET_UTF8));
                //Avoid send messages to EDCC || For production ¡¡Remove this!!
                //return true;
                // Only for production, this allows send messages to EDCC
                HttpResponse httpResponse = httpClient.execute(postRequest, new BasicHttpContext());
                if (httpResponse != null) {
                    if (httpResponse.getHeaders(HelpdeskConstants.LOCATION).length > 0) {
                        return true;
                    }
                }

            }
        } catch (Exception e) {
            _log.error(e.getMessage());
        }

        return false;
    }

    @SuppressWarnings("Duplicates")
    private HttpClient getHttpClient() throws Exception {

        HttpClient httpClient = null;
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] x509Certificate, String hostname) throws CertificateException {
                return true;
            }
        });

        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(builder.build());
        httpClientBuilder = httpClientBuilder.setSSLSocketFactory(sslSocketFactory);
        httpClient = httpClientBuilder.build();

        return httpClient;
    }
}