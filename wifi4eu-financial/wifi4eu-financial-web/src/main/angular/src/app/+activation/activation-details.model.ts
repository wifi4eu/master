export class ActivationDetails {
    public token: string;
    public password: string;
    public confirmPassword: string;

    public constructor(token?: string, password?: string, confirmPassword?: string) {
        this.token = token;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}