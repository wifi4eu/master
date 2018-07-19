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


export const IMunicipalityApi = new OpaqueToken('IMunicipalityApi');

export interface IMunicipalityApi {


    /**
     * create Municipality
     * 
     * @param c 
     * @param body 
     */
    createOrUpdate<T extends models.ResponseDTO>(body?: models.MunicipalityDTO, c?: ClassType<T>): Observable<T>;
    /**
     * delete Municipality
     * 
     * @param c 
     * @param body 
     */
    deleteMunicipality<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get Municipality by id
     * 
     * @param c 
     * @param id 
     */
    get<T extends models.MunicipalityDTO>(id: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get Municipality by jagate key
     * 
     * @param c 
     * @param jagateKey 
     */
    getByJagateKey<T extends models.MunicipalityDTO>(jagateKey: string, c?: ClassType<T>): Observable<T>;
    /**
     * Get all the municipalities
     * 
     * @param c 
     */
    list<T extends models.MunicipalityDTO>(c?: ClassType<T>): Observable<T[]>;

}

@Injectable()
export class MunicipalityApi implements IMunicipalityApi {
    protected basePath = '/';
    public defaultHeaders: Headers = new Headers();
    public configuration: Configuration = new Configuration();

    constructor(protected http: Http, @Optional() @Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        this.basePath=document.querySelector("html head base").getAttribute("href");
        if (configuration) {
            this.configuration = configuration;
        }
    }



    /**
     * create Municipality
     * 
     * @param c
     * @param body 
     */
    createOrUpdate<T extends models.ResponseDTO>(body?: models.MunicipalityDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createOrUpdateWithHttpInfo(body)
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
     * delete Municipality
     * 
     * @param c
     * @param body 
     */
    deleteMunicipality<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.deleteMunicipalityWithHttpInfo(body)
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
     * Get Municipality by id
     * 
     * @param c
     * @param id 
     */
    get<T extends models.MunicipalityDTO>(id: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getWithHttpInfo(id)
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
     * Get Municipality by jagate key
     * 
     * @param c
     * @param jagateKey 
     */
    getByJagateKey<T extends models.MunicipalityDTO>(jagateKey: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getByJagateKeyWithHttpInfo(jagateKey)
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
     * Get all the municipalities
     * 
     * @param c
     */
    list<T extends models.MunicipalityDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.listWithHttpInfo()
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
     * create Municipality
     * 
     * @param body 
     */
    private createOrUpdateWithHttpInfo(body?: models.MunicipalityDTO ): Observable<Response> {
        const path = this.basePath + `/municipality`;


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
     * delete Municipality
     * 
     * @param body 
     */
    private deleteMunicipalityWithHttpInfo(body?: number ): Observable<Response> {
        const path = this.basePath + `/municipality`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Delete,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get Municipality by id
     * 
     * @param id 
     */
    private getWithHttpInfo(id: number ): Observable<Response> {
        const path = this.basePath + `/municipality/${id}`;
//        .replace('{' + 'id' + '}', String(id));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'id' is not null or undefined
        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling get.');
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
     * Get Municipality by jagate key
     * 
     * @param jagateKey 
     */
    private getByJagateKeyWithHttpInfo(jagateKey: string ): Observable<Response> {
        const path = this.basePath + `/municipality/jagate/${jagateKey}`;
//        .replace('{' + 'jagateKey' + '}', String(jagateKey));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'jagateKey' is not null or undefined
        if (jagateKey === null || jagateKey === undefined) {
            throw new Error('Required parameter jagateKey was null or undefined when calling getByJagateKey.');
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
     * Get all the municipalities
     * 
     */
    private listWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/municipality`;


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

}
