package wifi4eu.wifi4eu.entity.application;

import javax.persistence.*;


@Entity
@Table(name = "authorized_person_application")
public class ApplicationAuthorizedPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @Column(name = "authorized_person")
    private int authorizedPerson;

    public ApplicationAuthorizedPerson() {
    }

    public ApplicationAuthorizedPerson(Integer id, Application application, int authorizedPerson) {
        this.id = id;
        this.application = application;
        this.authorizedPerson = authorizedPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public int getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(int authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }
}
