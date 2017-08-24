export class SupplierDetails {
    public newPassword: string;
    public repeatNewPassword: string; // TODO - This should not be an attribute
    public currentPassword: string;
    public name: string;
    public surname: string;
    public email: string;
    public phone: string;
    public company: string;
    public address:string;
    public vat:string;
    public bic:string;
    public logo:string;
    public country: string;
    public municipality:string;

    public constructor() {
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
    }
}
