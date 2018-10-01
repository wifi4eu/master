package wifi4eu.wifi4eu.common.dto.model;


public class ApplicationAuthorizedPersonDTO {
    Integer id;
    Integer applicationId;
    Integer authorized_person;

    public ApplicationAuthorizedPersonDTO() {
    }

    public ApplicationAuthorizedPersonDTO(Integer id, Integer applicationId, Integer authorized_person) {
        this.id = id;
        this.applicationId = applicationId;
        this.authorized_person = authorized_person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getAuthorized_person() {
        return authorized_person;
    }

    public void setAuthorized_person(Integer authorized_person) {
        this.authorized_person = authorized_person;
    }
}
