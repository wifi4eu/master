package wifi4eu.wifi4eu.abac.integration.eris.model;


import eu.europa.ec.research.fp.model.service_fault.v1.BusinessFaultInfoType;

public class ErisServerException extends ErisException {

    private static final long serialVersionUID = 2956357512957388760L;
    
    public ErisServerException(Throwable exception){
    	super(exception);
    }
    
    public ErisServerException(BusinessFaultInfoType faultInfo) {
        super(faultInfo);
    }


}
