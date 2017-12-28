package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.registration.GroupedRegistration;

import javax.persistence.*;

@Entity
public class GroupedRegistration {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "municipality")
    private String municipality;

    @Column(name = "applicants")
    private int applicants;

    @Column(name = "posts")
    private int posts;

    @Column(name = "status")
    private int status;

    public GroupedRegistration() {
    }

    public GroupedRegistration(Integer id, String country, String municipality, int applicants, int posts, int status) {
        this.id = id;
        this.country = country;
        this.municipality = municipality;
        this.applicants = applicants;
        this.posts = posts;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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