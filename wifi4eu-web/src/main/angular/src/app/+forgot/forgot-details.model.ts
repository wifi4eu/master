export class ForgotDetails {
    public email: string;
    public token: string;
    public password: string;
    public confirmPassword: string;

    public constructor(email?: string, token?: string, password?: string, confirmPassword?: string) {
        this.email = email;
        this.token = token;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}