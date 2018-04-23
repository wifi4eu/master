export class InstallationSite {
    number: number;
    name: string;
    domainName: string;

    constructor(number: number, name: string, domainName: string) {
        this.number = number;
        this.name = name;
        this.domainName = domainName;
    }
}
