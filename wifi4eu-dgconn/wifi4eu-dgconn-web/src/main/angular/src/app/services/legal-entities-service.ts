import { Inject, Injectable, Optional } from '@angular/core';
import { Headers, Http, RequestMethod, RequestOptions, RequestOptionsArgs, Response, ResponseContentType, URLSearchParams } from '@angular/http';
import { BASE_PATH } from '../shared/swagger/variables';
import { Observable } from 'rxjs';
import { ResponseDTO } from '../shared/swagger/model/ResponseDTO';

@Injectable()
export class LegalEntitiesService {

    // TODO: remove hardcoding
    private basePath = 'api';

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

    importDbBudgFinalList(fileData: FormData): Observable<ResponseDTO> {
        const path = this.basePath + `/exportImport/importDgBudgList`;

        return this.http.post(path, fileData).map(response => response.json());
    }

    exportLegalCommitment(): Observable<any> {
        const path = this.basePath + `/exportImport/exportLegalCommitment`;

        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: new Headers(),
            search: new URLSearchParams(),
            responseType: ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }
}