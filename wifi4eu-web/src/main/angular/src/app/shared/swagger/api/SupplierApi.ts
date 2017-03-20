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


export const ISupplierApi = new OpaqueToken('ISupplierApi');

export interface ISupplierApi {


    /**
     * Get all the suppliers
     * 
     * @param c 
     */
    allSuppliers<T extends models.SupplierDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * create supplier
     * 
     * @param c 
     * @param body 
     */
    createSupplier<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Get supplier by supplierId
     * 
     * @param c 
     * @param supplierId 
     */
    getSupplier<T extends models.SupplierDTO>(supplierId: number, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class SupplierApi implements ISupplierApi {
    protected basePath = 'http://localhost:7001/wifi4eu/api';
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
     * Get all the suppliers
     * 
     * @param c
     */
    allSuppliers<T extends models.SupplierDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allSuppliersWithHttpInfo()
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
     * create supplier
     * 
     * @param c
     * @param body 
     */
    createSupplier<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createSupplierWithHttpInfo(body)
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
     * Get supplier by supplierId
     * 
     * @param c
     * @param supplierId 
     */
    getSupplier<T extends models.SupplierDTO>(supplierId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSupplierWithHttpInfo(supplierId)
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
     * Get all the suppliers
     * 
     */
    private allSuppliersWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/supplier`;


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
     * create supplier
     * 
     * @param body 
     */
    private createSupplierWithHttpInfo(body?: models.SupplierDTO ): Observable<Response> {
        const path = this.basePath + `/supplier`;


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
     * Get supplier by supplierId
     * 
     * @param supplierId 
     */
    private getSupplierWithHttpInfo(supplierId: number ): Observable<Response> {
        const path = this.basePath + `/supplier/${supplierId}`;
//        .replace('{' + 'supplierId' + '}', String(supplierId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'supplierId' is not null or undefined
        if (supplierId === null || supplierId === undefined) {
            throw new Error('Required parameter supplierId was null or undefined when calling getSupplierById.');
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
