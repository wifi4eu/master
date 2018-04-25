export class SearchParameters {
    page: number;
    delta: number;
    order: string;
    id_beneficiary: number;
    fieldOrder: string;

    constructor() {
        this.page = 0;
        this.delta = 5;
        this.fieldOrder = "name";
        this.order = "asc";
    }
}
