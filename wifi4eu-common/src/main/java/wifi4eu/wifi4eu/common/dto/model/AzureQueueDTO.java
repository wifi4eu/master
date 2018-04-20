package wifi4eu.wifi4eu.common.dto.model;

public class AzureQueueDTO {

    private String message;

    public AzureQueueDTO() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AzureQueueDTO(String aMessage) {

        this.message = aMessage;
    }


}
