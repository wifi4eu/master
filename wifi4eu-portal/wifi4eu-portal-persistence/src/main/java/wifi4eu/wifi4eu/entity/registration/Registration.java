package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @Column(name = "role")
    private String role;

    @Column(name = "_status")
    private int status;

    @Column(name = "legal_file1_size")
    private Long legalFile1Size;

    @Column(name = "legal_file1_mime")
    private String legalFile1Mime;

    @Column(name = "legal_file2_size")
    private Long legalFile2Size;

    @Column(name = "legal_file2_mime")
    private String legalFile2Mime;

    @Column(name = "legal_file3_size")
    private Long legalFile3Size;

    @Column(name = "legal_file3_mime")
    private String legalFile3Mime;

    @Column(name = "legal_file4_size")
    private Long legalFile4Size;

    @Column(name = "legal_file4_mime")
    private String legalFile4Mime;

    /*@Basic(fetch=FetchType.LAZY)
    @Column(name = "legal_file1")
    private String legalFile1;*/

    /*@Basic(fetch=FetchType.LAZY)
    @Column(name = "legal_file2")
    private String legalFile2;*/

    /*@Basic(fetch=FetchType.LAZY)
    @Column(name = "legal_file3")
    private String legalFile3;*/

    /*@Basic(fetch=FetchType.LAZY)
    @Column(name = "legal_file4")
    private String legalFile4;*/

    @Column(name = "ip_registration")
    private String ipRegistration;

    @Column(name = "association_name")
    private String associationName;

    @Column(name = "organisation_id")
    private int organisationId;

    @Column(name = "upload_time")
    private Long uploadTime;

    @Column(name = "allFiles_flag")
    private int allFilesFlag;

    @Column(name = "mail_counter")
    private int mailCounter;


    public Registration() {
    }

    public Registration(User user, Municipality municipality, String role, int status, String legalFile1, String legalFile2, String legalFile3, String legalFile4, String ipRegistration, String associationName, int organisationId, Long uploadTime, int allFilesFlag, int mailCounter) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        /*this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.legalFile3 = legalFile3;
        this.legalFile4 = legalFile4;*/
        this.ipRegistration = ipRegistration;
        this.associationName = associationName;
        this.organisationId = organisationId;
        this.uploadTime = uploadTime;
        this.allFilesFlag = allFilesFlag;
        this.mailCounter = mailCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public int getStatus() {
        return status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getLegalFile1Size() {
        return legalFile1Size;
    }

    public void setLegalFile1Size(Long legalFile1Size) {
        this.legalFile1Size = legalFile1Size;
    }

    public String getLegalFile1Mime() {
        return legalFile1Mime;
    }

    public void setLegalFile1Mime(String legalFile1Mime) {
        this.legalFile1Mime = legalFile1Mime;
    }

    public Long getLegalFile2Size() {
        return legalFile2Size;
    }

    public void setLegalFile2Size(Long legalFile2Size) {
        this.legalFile2Size = legalFile2Size;
    }

    public String getLegalFile2Mime() {
        return legalFile2Mime;
    }

    public void setLegalFile2Mime(String legalFile2Mime) {
        this.legalFile2Mime = legalFile2Mime;
    }

    public Long getLegalFile3Size() {
        return legalFile3Size;
    }

    public void setLegalFile3Size(Long legalFile3Size) {
        this.legalFile3Size = legalFile3Size;
    }

    public String getLegalFile3Mime() {
        return legalFile3Mime;
    }

    public void setLegalFile3Mime(String legalFile3Mime) {
        this.legalFile3Mime = legalFile3Mime;
    }

    public Long getLegalFile4Size() {
        return legalFile4Size;
    }

    public void setLegalFile4Size(Long legalFile4Size) {
        this.legalFile4Size = legalFile4Size;
    }

    public String getLegalFile4Mime() {
        return legalFile4Mime;
    }

    public void setLegalFile4Mime(String legalFile4Mime) {
        this.legalFile4Mime = legalFile4Mime;
    }

    /*public String getLegalFile1() {
        return legalFile1;
    }

    public void setLegalFile1(String legalFile1) {
        this.legalFile1 = legalFile1;
    }

    public String getLegalFile2() {
        return legalFile2;
    }

    public void setLegalFile2(String legalFile2) {
        this.legalFile2 = legalFile2;
    }

    public String getLegalFile3() {
        return legalFile3;
    }

    public void setLegalFile3(String legalFile3) {
        this.legalFile3 = legalFile3;
    }

    public String getLegalFile4() {
        return legalFile4;
    }

    public void setLegalFile4(String legalFile4) {
        this.legalFile4 = legalFile4;
    }*/

    public String getIpRegistration() {
        return ipRegistration;
    }

    public void setIpRegistration(String ipRegistration) {
        this.ipRegistration = ipRegistration;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getAllFilesFlag() {
        return allFilesFlag;
    }

    public void setAllFilesFlag(int allFilesFlag) {
        this.allFilesFlag = allFilesFlag;
    }

    public int getMailCounter() {
        return mailCounter;
    }

    public void setMailCounter(int mailCounter) {
        this.mailCounter = mailCounter;
    }
}