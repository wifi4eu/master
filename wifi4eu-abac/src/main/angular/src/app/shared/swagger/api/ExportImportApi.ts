// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports

import {serialize, deserialize, deserializeArray, plainToClass, classToPlain} from 'class-transformer';
import {Inject, Injectable, Optional, OpaqueToken} from '@angular/core';
import {
  Http,
  Headers,
  URLSearchParams,
  RequestMethod,
  RequestOptions,
  RequestOptionsArgs,
  Response,
  ResponseContentType
} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import * as models from '../model/models';
import {BASE_PATH} from '../variables';
import {Configuration} from '../configuration';
import {ClassType} from '../classType';
import { ResponseDTO } from "../model/ResponseDTO";


export const IExportImportApi = new OpaqueToken('IExportImportApi');

export interface IExportImportApi {


    /**
     * Export LEF and BC Validates
     * 
     * @param c 
     */
    exportLegalEntityFBCValidate<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Import Budgetary Commitment
     * 
     * @param c 
     * @param body 
     */
    importBudgetaryCommitment<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T>;
    /**
     * Import Legal Entity File
     * 
     * @param c 
     * @param body 
     */
    importLegalEntityF<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class ExportImportApi implements IExportImportApi {
    protected basePath = 'http://localhost:7001/wifi4eu-financial/api';
    public defaultHeaders: Headers = new Headers();
    public configuration: Configuration = new Configuration();

    constructor(protected http: Http,
                @Optional() @Inject(BASE_PATH) basePath: string,
                @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }



    /**
     * Export LEF and BC Validates
     * 
     * @param c
     */
    exportLegalEntityFBCValidate<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.exportLegalEntityFBCValidateWithHttpInfo()
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Import Budgetary Commitment
     * 
     * @param c
     * @param body 
     */
    importBudgetaryCommitment<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.importBudgetaryCommitmentWithHttpInfo(body)
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * Import Legal Entity File
     * 
     * @param c
     * @param body 
     */
    importLegalEntityF<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.importLegalEntityFWithHttpInfo(body)
                .map((response: Response) => {
                  
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserialize(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }



    /**
     * Export LEF and BC Validates
     * 
     */
    private exportLegalEntityFBCValidateWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/exportImport/exportLegalEntityFBCValidate`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Import Budgetary Commitment
     * 
     * @param body 
     */
    private importBudgetaryCommitmentWithHttpInfo(body?: string ): Observable<Response> {
        const path = this.basePath + `/exportImport/importBudgetaryCommitment`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Import Legal Entity File
     * 
     * @param body 
     */
    private importLegalEntityFWithHttpInfo(body?: string ): Observable<Response> {
        
        const path = this.basePath + `/svc/upload/LEF`;

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'text/plain');

        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

}
