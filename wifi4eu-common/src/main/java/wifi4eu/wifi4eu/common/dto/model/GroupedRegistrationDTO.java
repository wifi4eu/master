package wifi4eu.wifi4eu.common.dto.model;

public class GroupedRegistrationDTO {
    private int id;
    private String country;
    private String municipality;
    private int applicants;
    private int posts;
    private int status;

    public GroupedRegistrationDTO() {
    }

    public GroupedRegistrationDTO(int id, String country, String municipality, int applicants, int posts, int status) {
        this.id = id;
        this.country = country;
        this.municipality = municipality;
        this.applicants = applicants;
        this.posts = posts;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getMunicipality() {
        return municipality;
    }

    public int getApplicants() {
        return applicants;
    }

    public int getPosts() {
        return posts;
    }

    public int getStatus() {
        return status;
    }
}