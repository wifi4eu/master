package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class ContactPersonDTO implements Serializable {
    private Long contactId;
    private String name;
    private String surname;
    private String phone;
    private String email;

    public ContactPersonDTO() {
    }

    public ContactPersonDTO(Long contactId, String name, String surname, String phone, String email) {
        this.contactId = contactId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}