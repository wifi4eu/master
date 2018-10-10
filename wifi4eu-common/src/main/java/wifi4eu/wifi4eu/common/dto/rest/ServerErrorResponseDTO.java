package wifi4eu.wifi4eu.common.dto.rest;

/**
 * DTO for returning a Server Error.
 */
public class ServerErrorResponseDTO extends ResponseDTO {

    public ServerErrorResponseDTO(String message) {
        super(false, new ServerErrorDTO(message));
    }
}
