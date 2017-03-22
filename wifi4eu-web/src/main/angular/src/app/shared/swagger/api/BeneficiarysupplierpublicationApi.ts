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


export const IBeneficiarysupplierpublicationApi = new OpaqueToken('IBeneficiarysupplierpublicationApi');

export interface IBeneficiarysupplierpublicationApi {


    /**
     * Get all the beneficiarysupplierpublication
     * 
     * @param c 
     */
    allBeneficiarySupplierPublications<T extends models.BeneficiarySupplierPublicationDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * create beneficiarySupplierPublication
     * 
     * @param c 
     * @param body 
     */
    createBeneficiarySupplierPublication<T extends models.ResponseDTO>(body?: models.BeneficiarySupplierPublicationDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Get beneficiarysupplierpublication by benSupplierPublicationId
     * 
     * @param c 
     * @param benSupplierPublicationId 
     */
    getBeneficiarySupplierPublicationById<T extends models.BeneficiarySupplierPublicationDTO>(benSupplierPublicationId: number, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class BeneficiarysupplierpublicationApi implements IBeneficiarysupplierpublicationApi {
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
     * Get all the beneficiarysupplierpublication
     * 
     * @param c
     */
    allBeneficiarySupplierPublications<T extends models.BeneficiarySupplierPublicationDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allBeneficiarySupplierPublicationsWithHttpInfo()
                .map((response: Response) => {
                    if (response.status === 204) {
                        return undefined;
                    } else if (c) {
                        return deserializeArray(c, response.text());
                    } else {
                        return response.json();
                    }
                });
        }




    /**
     * create beneficiarySupplierPublication
     * 
     * @param c
     * @param body 
     */
    createBeneficiarySupplierPublication<T extends models.ResponseDTO>(body?: models.BeneficiarySupplierPublicationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createBeneficiarySupplierPublicationWithHttpInfo(body)
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
     * Get beneficiarysupplierpublication by benSupplierPublicationId
     * 
     * @param c
     * @param benSupplierPublicationId 
     */
    getBeneficiarySupplierPublicationById<T extends models.BeneficiarySupplierPublicationDTO>(benSupplierPublicationId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getBeneficiarySupplierPublicationByIdWithHttpInfo(benSupplierPublicationId)
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
     * Get all the beneficiarysupplierpublication
     * 
     */
    private allBeneficiarySupplierPublicationsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/beneficiarysupplierpublication`;


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
     * create beneficiarySupplierPublication
     * 
     * @param body 
     */
    private createBeneficiarySupplierPublicationWithHttpInfo(body?: models.BeneficiarySupplierPublicationDTO ): Observable<Response> {
        const path = this.basePath + `/beneficiarysupplierpublication`;


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
     * Get beneficiarysupplierpublication by benSupplierPublicationId
     * 
     * @param benSupplierPublicationId 
     */
    private getBeneficiarySupplierPublicationByIdWithHttpInfo(benSupplierPublicationId: number ): Observable<Response> {
        const path = this.basePath + `/beneficiarysupplierpublication/${benSupplierPublicationId}`;
//        .replace('{' + 'benSupplierPublicationId' + '}', String(benSupplierPublicationId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'benSupplierPublicationId' is not null or undefined
        if (benSupplierPublicationId === null || benSupplierPublicationId === undefined) {
            throw new Error('Required parameter benSupplierPublicationId was null or undefined when calling getBeneficiarySupplierPublicationById.');
        }







        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

}
