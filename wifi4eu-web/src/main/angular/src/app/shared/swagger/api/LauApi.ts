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


export const ILauApi = new OpaqueToken('ILauApi');

export interface ILauApi {


    /**
     * create LAU
     * 
     * @param c 
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.LauDTO, c?: ClassType<T>): Observable<T>;
    /**
     * get Lau by Country Code i.e: ES
     * 
     * @param c 
     * @param countryCode 
     */
    findLauByCountryCode<T extends models.LauDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * get Lau by LAU2 i.e: 08019
     * 
     * @param c 
     * @param lau2 
     */
    findLauByLau2<T extends models.LauDTO>(lau2: string, c?: ClassType<T>): Observable<T>;
    /**
     * get Lau by NUTS3 i.e: ES513
     * 
     * @param c 
     * @param nuts3 
     */
    findLauByNuts3<T extends models.LauDTO>(nuts3: string, c?: ClassType<T>): Observable<T[]>;

}

@Injectable()
export class LauApi implements ILauApi {
    protected basePath = 'http://localhost:8080/wifi4eu/api';
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
     * create LAU
     * 
     * @param c
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.LauDTO, c?: ClassType<T>): Observable<T> {
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
     * get Lau by Country Code i.e: ES
     * 
     * @param c
     * @param countryCode 
     */
    findLauByCountryCode<T extends models.LauDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]> {

        return this.findLauByCountryCodeWithHttpInfo(countryCode)
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
     * get Lau by LAU2 i.e: 08019
     * 
     * @param c
     * @param lau2 
     */
    findLauByLau2<T extends models.LauDTO>(lau2: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findLauByLau2WithHttpInfo(lau2)
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
     * get Lau by NUTS3 i.e: ES513
     * 
     * @param c
     * @param nuts3 
     */
    findLauByNuts3<T extends models.LauDTO>(nuts3: string, c?: ClassType<T>): Observable<T[]> {

        return this.findLauByNuts3WithHttpInfo(nuts3)
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
     * create LAU
     * 
     * @param body 
     */
    private createWithHttpInfo(body?: models.LauDTO ): Observable<Response> {
        const path = this.basePath + `/lau`;


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
     * get Lau by Country Code i.e: ES
     * 
     * @param countryCode 
     */
    private findLauByCountryCodeWithHttpInfo(countryCode: string ): Observable<Response> {
        const path = this.basePath + `/lau/${countryCode}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling findLauByCountryCode.');
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
     * get Lau by LAU2 i.e: 08019
     * 
     * @param lau2 
     */
    private findLauByLau2WithHttpInfo(lau2: string ): Observable<Response> {
        const path = this.basePath + `/lau/lau2/${lau2}`;
//        .replace('{' + 'lau2' + '}', String(lau2));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'lau2' is not null or undefined
        if (lau2 === null || lau2 === undefined) {
            throw new Error('Required parameter lau2 was null or undefined when calling findLauByLau2.');
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
     * get Lau by NUTS3 i.e: ES513
     * 
     * @param nuts3 
     */
    private findLauByNuts3WithHttpInfo(nuts3: string ): Observable<Response> {
        const path = this.basePath + `/lau/nuts3/${nuts3}`;
//        .replace('{' + 'nuts3' + '}', String(nuts3));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'nuts3' is not null or undefined
        if (nuts3 === null || nuts3 === undefined) {
            throw new Error('Required parameter nuts3 was null or undefined when calling findLauByNuts3.');
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
