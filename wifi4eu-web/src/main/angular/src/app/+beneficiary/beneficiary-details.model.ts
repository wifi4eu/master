export class BeneficiaryDetails {
    public treatment : string;
    public name : string;
    public surname : string;
    public email : string;
    public confirmEmail : string;
    public representativeSelected : boolean;
    public treatmentRepresentative : string;
    public nameRepresentative : string;
    public surnameRepresentative : string;
    public roleRepresentative : string;
    public emailRepresentative : string;
    public confirmEmailRepresentative : string;

    public constructor() {
        this.representativeSelected = false;
    }
}