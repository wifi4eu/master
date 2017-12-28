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

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getApplicants() {
        return applicants;
    }

    public void setApplicants(int applicants) {
        this.applicants = applicants;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}