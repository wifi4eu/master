package wifi4eu.wifi4eu.common.dto.rest;

/**
 * DTO with the error code {@literal 500}.
 */
public class ServerErrorDTO extends ErrorDTO {

    /**
     * Creates a DTO with the error code {@literal 500}.
     */
    public ServerErrorDTO(String message) {
        super(500, message);
    }

}
