package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.registration.GroupedRegistration;

import javax.persistence.*;

@Entity
public class GroupedRegistration {
    @Column(name = "id")
    private int id;

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

    public GroupedRegistration(int id, String country, String municipality, int applicants, int posts, int status) {
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