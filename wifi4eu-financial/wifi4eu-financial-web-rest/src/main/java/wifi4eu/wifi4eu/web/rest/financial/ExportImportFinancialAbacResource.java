package wifi4eu.wifi4eu.web.rest.financial;

import cec.budg.soatube.client.async.JmsProducerLocal;
import cec.budg.soatube.client.sync.SoatubeWSClientLocal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.exportImport.ExportImportFinancialAbacService;
import wifi4eu.wifi4eu.service.security.UserService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/exportImport", description = "Export and import registration data")
@RequestMapping("exportImport")
public class ExportImportFinancialAbacResource {
    @Autowired
    private UserService userService;
    @Autowired
    private ExportImportFinancialAbacService exportImportWifi4euFinancialAbacService;
    private final Logger _log = LoggerFactory.getLogger(ExportImportFinancialAbacResource.class);
    private SoatubeWSClientLocal soaTubeWSClient;
    private JmsProducerLocal jmsProducer;


    public ExportImportFinancialAbacResource() throws NamingException {
        InitialContext ic = new InitialContext();
        jmsProducer = (JmsProducerLocal)ic.lookup("java:global/wifi4eu/wifi4eu-financial-web/JmsProducer");
        soaTubeWSClient = (SoatubeWSClientLocal)ic.lookup("java:global/wifi4eu/wifi4eu-financial-web/SoatubeWSClient");

    }

    @ApiOperation(value = "Import Legal Entity File")
    @RequestMapping(value = "/importLegalEntityF", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
        public ResponseDTO importLegalEntityF(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
        try {
            _log.info("importLegalEntityF");
            JSONArray jsonArray = new JSONArray(jsonStringFile);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                exportImportWifi4euFinancialAbacService.importLegalEntityF(jmsProducer, object.toString());
            }
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on operation.", ade);
            }
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Import Budgetary Commitment")
    @RequestMapping(value = "/importBudgetaryCommitment", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO importBudgetaryCommitment(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
        try {
            _log.info("importBudgetaryCommitment");
            JSONArray jsonArray = new JSONArray(jsonStringFile);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                exportImportWifi4euFinancialAbacService.importBudgetaryCommitment(jmsProducer, object.toString());
            }
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on operation.", ade);
            }
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Export LEF and BC Validates")
    @RequestMapping(value = "/exportLegalEntityFBCValidate", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO exportLegalEntityFBCValidate(final HttpServletResponse response) {
        _log.info("exportLegalEntityFBCValidate");
        return exportImportWifi4euFinancialAbacService.exportLegalEntityFBCValidate();
    }

}