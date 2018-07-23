// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports

import { serialize, deserialize, deserializeArray, plainToClass, classToPlain } from 'class-transformer';
import { Inject, Injectable, Optional, OpaqueToken } from '@angular/core';
import { Http, Headers, URLSearchParams, RequestMethod, RequestOptions, RequestOptionsArgs, Response, ResponseContentType } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import * as models from '../model/models';
import { BASE_PATH } from '../variables';
import { Configuration } from '../configuration';
import { ClassType } from '../classType';
import { ResponseDTO } from "../model/ResponseDTO";

export const IExportImportApi = new OpaqueToken('IExportImportApi');

export interface IExportImportApi{
  importLegalEntityF<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T>;
  importBudgetaryCommitment<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T>;
}

@Injectable()
export class ExportImportApi implements IExportImportApi {
  
    protected basePath = '/';
    public defaultHeaders: Headers = new Headers();
    public configuration: Configuration = new Configuration();

    constructor(protected http: Http, @Optional() @Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration){
        this.basePath=document.querySelector("html head base").getAttribute("href");
        if (configuration) {
            this.configuration = configuration;
        }
    }

    importLegalEntityF<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
      // noinspection TypeScriptValidateTypes
      return this.importWithHttpInfo("legalEntity/import", body).map((response: Response) => {
        if (response.status === 204) {
            return undefined;
        } else if (c) {
            return deserialize(c, response.text());
        } else {
            return response.json();
        }
      });
    }
  
    importBudgetaryCommitment<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
      // noinspection TypeScriptValidateTypes
      return this.importWithHttpInfo("budgetaryCommitment/import", body).map((response: Response) => {
        if (response.status === 204) {
            return undefined;
        } else if (c) {
            return deserialize(c, response.text());
        } else {
            return response.json();
        }
      });
    }
  
    importLegalCommitment<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
      // noinspection TypeScriptValidateTypes
      return this.importWithHttpInfo("legalCommitment/import", body).map((response: Response) => {
        if (response.status === 204) {
            return undefined;
        } else if (c) {
            return deserialize(c, response.text());
        } else {
            return response.json();
        }
      });
    }
  
    importWithHttpInfo(endpoint?:string, body?: string): Observable<Response> {
      
        const path = this.basePath + endpoint;
        
        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON());
        headers.set('Content-Type', 'text/plain');

        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : classToPlain(body),
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }
}
