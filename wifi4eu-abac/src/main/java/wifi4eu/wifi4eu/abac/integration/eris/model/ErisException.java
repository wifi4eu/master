package wifi4eu.wifi4eu.abac.integration.eris.model;


import eu.europa.ec.research.fp.model.service_fault.v1.BusinessFaultInfoType;

public class ErisException extends Exception {

    private static final long serialVersionUID = 4769579794379651357L;

    private BusinessFaultInfoType faultInfo;

    public ErisException(Throwable cause){
    	super(cause);
    }
    
    public ErisException(BusinessFaultInfoType faultInfo) {
        this.faultInfo = faultInfo;
    }

    public BusinessFaultInfoType getFaultInfo() {
        return faultInfo;
    }

}
