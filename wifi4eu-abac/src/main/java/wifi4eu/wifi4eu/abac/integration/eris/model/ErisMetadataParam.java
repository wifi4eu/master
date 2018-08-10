package wifi4eu.wifi4eu.abac.integration.eris.model;

import java.io.Serializable;

public class ErisMetadataParam implements Serializable {

    private static final long serialVersionUID = 8881127197838904140L;

    private String ccm2Code;

    private String abbreviation;

    private Serializable value;

    public ErisMetadataParam(String ccm2Code, String abbreviation, Serializable value) {
        this.ccm2Code = ccm2Code;
        this.abbreviation = abbreviation;
        this.value = value;
    }

    public String getCcm2Code() {
        return ccm2Code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Serializable getValue() {
        return value;
    }

}
