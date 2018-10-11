package wifi4eu.wifi4eu.common.dto.model;

import wifi4eu.wifi4eu.common.Constant;

public class HelpdeskTicketDTO {

	private String form_tools_form_id;
	private String uuid = "_5qd9hpabh";

    private String lang = Constant.PREF_LANG_DEFAULT;
    private String browser = Constant.BROWSER;
    private String gender = Constant.GENDER_DEFAULT;
    private String firstname = Constant.FIRSTNAME_DEFAULT;
    private String lastname = Constant.LASTNAME_DEFAULT;
    private String emailAdress = Constant.EMAIL_DEFAULT;
    private String emailAdressconf = emailAdress;
    private String nationality = Constant.NATIONALITY_DEFAULT;
    private String resid_country = nationality;
    private String econom_categ = Constant.ECOM_CATEG_DEFAULT;
    private String pref_lg = Constant.PREF_LANG_DEFAULT;
    private String pref_lg2 = pref_lg;
    private String txtsubjext = "";
    private String question = "";

    private final String agreemail = "Agreed";
    private final String agreement = "Agreed";
    private final String submit = "Submit";

    public HelpdeskTicketDTO() {
    }

    public HelpdeskTicketDTO(String lang, String browser, String gender, String firstname, String lastname, String emailAdress, String emailAdressconf, String nationality, String resid_country, String econom_categ, String pref_lg, String pref_lg2, String txtsubjext, String question) {
        this.lang = lang;
        this.browser = browser;
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAdress = emailAdress;
        this.emailAdressconf = emailAdressconf;
        this.nationality = nationality;
        this.resid_country = resid_country;
        this.econom_categ = econom_categ;
        this.pref_lg = pref_lg;
        this.pref_lg2 = pref_lg2;
        this.txtsubjext = txtsubjext;
        this.question = question;
    }

	public void setForm_tools_form_id(String form_tools_form_id) {
		this.form_tools_form_id = form_tools_form_id;
	}

	public String getForm_tools_form_id() {
        return form_tools_form_id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getEmailAdressconf() {
        return emailAdressconf;
    }

    public void setEmailAdressconf(String emailAdressconf) {
        this.emailAdressconf = emailAdressconf;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getResid_country() {
        return resid_country;
    }

    public void setResid_country(String resid_country) {
        this.resid_country = resid_country;
    }

    public String getEconom_categ() {
        return econom_categ;
    }

    public void setEconom_categ(String econom_categ) {
        this.econom_categ = econom_categ;
    }

    public String getPref_lg() {
        return pref_lg;
    }

    public void setPref_lg(String pref_lg) {
        this.pref_lg = pref_lg;
    }

    public String getPref_lg2() {
        return pref_lg2;
    }

    public void setPref_lg2(String pref_lg2) {
        this.pref_lg2 = pref_lg2;
    }

    public String getTxtsubjext() {
        return txtsubjext;
    }

    public void setTxtsubjext(String txtsubjext) {
        this.txtsubjext = txtsubjext;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "form_tools_form_id=" + form_tools_form_id +
                "&uuid=" + uuid +
                "&lang=" + lang +
                "&browser=" + browser +
                "&gender=" + gender +
                "&firstname=" + firstname +
                "&lastname=" + lastname +
                "&emailAdress=" + emailAdress +
                "&emailAdressconf=" + emailAdressconf +
                "&nationality=" + nationality +
                "&resid_country=" + resid_country +
                "&econom_categ=" + econom_categ +
                "&pref_lg=" + pref_lg +
                "&pref_lg2=" + pref_lg2 +
                "&txtsubjext=" + txtsubjext +
                "&question=" + question +
                "&agreemail=" + agreemail +
                "&agreement=" + agreement +
                "&submit=" + submit;
    }
}
