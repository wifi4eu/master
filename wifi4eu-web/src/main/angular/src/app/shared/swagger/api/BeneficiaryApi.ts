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


export const IBeneficiaryApi = new OpaqueToken('IBeneficiaryApi');

export interface IBeneficiaryApi {


    /**
     * create Beneficiary
     * 
     * @param c 
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<T>;
    /**
     * get legal Entity information
     * 
     * @param c 
     * @param legalEntityId 
     */
    getLegalEntity<T extends models.LegalEntityDTO>(legalEntityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Update beneficiary information
     * 
     * @param c 
     * @param beneficiaryId 
     * @param body 
     */
    update<T extends models.ResponseDTO>(beneficiaryId: number, body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class BeneficiaryApi implements IBeneficiaryApi {
    protected basePath = 'http://wifi4eu.everisdigitalchannels.com:7001/wifi4eu/api';
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
     * create Beneficiary
     * 
     * @param c
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createWithHttpInfo(body)
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
     * get legal Entity information
     * 
     * @param c
     * @param legalEntityId 
     */
    getLegalEntity<T extends models.LegalEntityDTO>(legalEntityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLegalEntityWithHttpInfo(legalEntityId)
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
     * Update beneficiary information
     * 
     * @param c
     * @param beneficiaryId 
     * @param body 
     */
    update<T extends models.ResponseDTO>(beneficiaryId: number, body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateWithHttpInfo(beneficiaryId, body)
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
     * create Beneficiary
     * 
     * @param body 
     */
    private createWithHttpInfo(body?: models.BeneficiaryDTO ): Observable<Response> {
        const path = this.basePath + `/beneficiary`;


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
     * get legal Entity information
     * 
     * @param legalEntityId 
     */
    private getLegalEntityWithHttpInfo(legalEntityId: number ): Observable<Response> {
        const path = this.basePath + `/beneficiary/${legalEntityId}`;
//        .replace('{' + 'legalEntityId' + '}', String(legalEntityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'legalEntityId' is not null or undefined
        if (legalEntityId === null || legalEntityId === undefined) {
            throw new Error('Required parameter legalEntityId was null or undefined when calling getLegalEntity.');
        }







        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update beneficiary information
     * 
     * @param beneficiaryId 
     * @param body 
     */
    private updateWithHttpInfo(beneficiaryId: number,  body?: models.BeneficiaryDTO ): Observable<Response> {
        const path = this.basePath + `/beneficiary/${beneficiaryId}`;
//        .replace('{' + 'beneficiaryId' + '}', String(beneficiaryId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'beneficiaryId' is not null or undefined
        if (beneficiaryId === null || beneficiaryId === undefined) {
            throw new Error('Required parameter beneficiaryId was null or undefined when calling update.');
        }





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

}
