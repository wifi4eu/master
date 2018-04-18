export class SearchParameters {
    page: number;
    delta: number;
    fieldOrder: string;
    order: string;

    constructor() {
        this.page = 0;
        this.delta = 5;
        this.fieldOrder = "name";
        this.order = "asc";
    }
}
