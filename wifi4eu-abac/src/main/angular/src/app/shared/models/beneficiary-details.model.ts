export class BeneficiaryDetails {
    public treatment: string;
    public name: string;
    public surname: string;
    public email: string;
    public password: string;
    public confirmEmail: string; // TODO - This should not be an attribute
    // TODO - Representative need to be treated as an object instance
    public representativeSelected: boolean;
    public treatmentRepresentative: string;
    public nameRepresentative: string;
    public surnameRepresentative: string;
    public roleRepresentative: string;
    public emailRepresentative: string;
    public confirmEmailRepresentative: string;
    public newPassword: string;
    public repeatNewPassword: string; // TODO - This should not be an attribute
    public currentPassword: string;

    public constructor() {
        this.representativeSelected = false;
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
        this.emailRepresentative = '';

    }
}