export class SearchParameters {
    page: number;
    delta: number;
    fieldOrder: string;
    order: string;
    criteria: SearchFilters;

    constructor() {
        this.page = 0;
        this.delta = 5;
        this.fieldOrder = "name";
        this.order = "asc";
        this.criteria = new SearchFilters();
    }
}

export class SearchFilters {
    keywords: string;
    idSupplier : number;
    municipalitySelected : number;
}
