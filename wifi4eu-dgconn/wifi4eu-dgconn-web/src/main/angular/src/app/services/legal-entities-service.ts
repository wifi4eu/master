import { Inject, Injectable, Optional } from '@angular/core';
import { Http } from '@angular/http';
import { BASE_PATH } from '../shared/swagger/variables';
import { Observable } from 'rxjs';
import { ResponseDTO } from '../shared/swagger/model/ResponseDTO';

@Injectable()
export class LegalEntitiesService {

    private basePath = 'http://localhost:8080/dashboard/api';

    constructor(private http: Http, @Optional() @Inject(BASE_PATH) basePath: string) {
        if (basePath) {
            this.basePath = basePath;
        }
    }

    importLef(fileData: FormData): Observable<ResponseDTO> {
        const path = this.basePath + `/exportImport/importLegalEntityFBCValidate`;

        return this.http.post(path, fileData).map(response => response.json());
    }

    importBudgetaryCommitment(fileData: FormData): Observable<ResponseDTO> {
        const path = this.basePath + `/exportImport/importBudgetaryCommitment`;

        return this.http.post(path, fileData).map(response => response.json());
    }

    importLegalCommitment(fileData: FormData): Observable<ResponseDTO> {
        const path = this.basePath + `/exportImport/importLegalCommitment`;

        return this.http.post(path, fileData).map(response => response.json());
    }

}