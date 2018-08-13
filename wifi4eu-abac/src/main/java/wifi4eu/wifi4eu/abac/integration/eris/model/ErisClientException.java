package wifi4eu.wifi4eu.abac.integration.eris.model;

import eu.europa.ec.research.fp.model.service_fault.v1.BusinessFaultInfoType;

public class ErisClientException extends ErisException {

    private static final long serialVersionUID = 4769579794379651357L;
    
    public ErisClientException(BusinessFaultInfoType faultInfo) {
        super(faultInfo);
    }

}
