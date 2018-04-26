export class SearchParameters {
    page: number;
    delta: number;
    order: string;
    id_beneficiary: number;
    id_installationSite : number;
    fieldOrder: string;

    constructor() {
        this.page = 0;
        this.delta = 5;
        this.fieldOrder = "id";
        this.order = "asc";
    }
}
