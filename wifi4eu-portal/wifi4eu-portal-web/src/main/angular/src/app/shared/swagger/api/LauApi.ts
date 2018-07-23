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
     * Get lau by countryCode and lau2
     * 
     * @param c 
     * @param countryCode 
     * @param lau2 
     */
    getLauByCountryCodeAndLau2<T extends models.LauDTO>(countryCode: string, lau2: string, c?: ClassType<T>): Observable<T>;
    /**
     * Get lau by specific id
     * 
     * @param c 
     * @param lauId 
     */
    getLauById<T extends models.LauDTO>(lauId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get laus by countryCode
     * 
     * @param c 
     * @param countryCode 
     */
    getLausByCountryCode<T extends models.LauDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get laus by countryCode that start with name1, ignoring case
     * 
     * @param c 
     * @param countryCode 
     * @param name1 
     */
    getLausByCountryCodeAndName1ContainingIgnoreCase<T extends models.LauDTO>(countryCode: string, name1: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get laus by nuts3
     * 
     * @param c 
     * @param nuts3 
     */
    getLausByNuts3<T extends models.LauDTO>(nuts3: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * Update Lau Physical Address
     * 
     * @param c 
     * @param body 
     */
    updatePhysicalAddress<T extends models.ResponseDTO>(body?: models.LauDTO, c?: ClassType<T>): Observable<T>;

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
     * Get lau by countryCode and lau2
     * 
     * @param c
     * @param countryCode 
     * @param lau2 
     */
    getLauByCountryCodeAndLau2<T extends models.LauDTO>(countryCode: string, lau2: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLauByCountryCodeAndLau2WithHttpInfo(countryCode, lau2)
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
     * Get lau by specific id
     * 
     * @param c
     * @param lauId 
     */
    getLauById<T extends models.LauDTO>(lauId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLauByIdWithHttpInfo(lauId)
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
     * Get laus by countryCode
     * 
     * @param c
     * @param countryCode 
     */
    getLausByCountryCode<T extends models.LauDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]> {

        return this.getLausByCountryCodeWithHttpInfo(countryCode)
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
     * Get laus by countryCode that start with name1, ignoring case
     * 
     * @param c
     * @param countryCode 
     * @param name1 
     */
    getLausByCountryCodeAndName1ContainingIgnoreCase<T extends models.LauDTO>(countryCode: string, name1: string, c?: ClassType<T>): Observable<T[]> {

        return this.getLausByCountryCodeAndName1ContainingIgnoreCaseWithHttpInfo(countryCode, name1)
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
     * Get laus by nuts3
     * 
     * @param c
     * @param nuts3 
     */
    getLausByNuts3<T extends models.LauDTO>(nuts3: string, c?: ClassType<T>): Observable<T[]> {

        return this.getLausByNuts3WithHttpInfo(nuts3)
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
     * Update Lau Physical Address
     * 
     * @param c
     * @param body 
     */
    updatePhysicalAddress<T extends models.ResponseDTO>(body?: models.LauDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updatePhysicalAddressWithHttpInfo(body)
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
     * Get lau by countryCode and lau2
     * 
     * @param countryCode 
     * @param lau2 
     */
    private getLauByCountryCodeAndLau2WithHttpInfo(countryCode: string,  lau2: string ): Observable<Response> {
        const path = this.basePath + `/lau/countryCode/${countryCode}/lau2/${lau2}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'lau2' + '}', String(lau2));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling getLauByCountryCodeAndLau2.');
        }
        // verify required parameter 'lau2' is not null or undefined
        if (lau2 === null || lau2 === undefined) {
            throw new Error('Required parameter lau2 was null or undefined when calling getLauByCountryCodeAndLau2.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/lau/countryCode/${countryCode}/lau2/${lau2}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get lau by specific id
     * 
     * @param lauId 
     */
    private getLauByIdWithHttpInfo(lauId: number ): Observable<Response> {
        const path = this.basePath + `/lau/${lauId}`;
//        .replace('{' + 'lauId' + '}', String(lauId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'lauId' is not null or undefined
        if (lauId === null || lauId === undefined) {
            throw new Error('Required parameter lauId was null or undefined when calling getLauById.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/lau/${lauId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get laus by countryCode
     * 
     * @param countryCode 
     */
    private getLausByCountryCodeWithHttpInfo(countryCode: string ): Observable<Response> {
        const path = this.basePath + `/lau/countryCode/${countryCode}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling getLausByCountryCode.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/lau/countryCode/${countryCode}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get laus by countryCode that start with name1, ignoring case
     * 
     * @param countryCode 
     * @param name1 
     */
    private getLausByCountryCodeAndName1ContainingIgnoreCaseWithHttpInfo(countryCode: string,  name1: string ): Observable<Response> {
        const path = this.basePath + `/lau/countryCode/${countryCode}/name/${name1}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'name1' + '}', String(name1));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling getLausByCountryCodeAndName1ContainingIgnoreCase.');
        }
        // verify required parameter 'name1' is not null or undefined
        if (name1 === null || name1 === undefined) {
            throw new Error('Required parameter name1 was null or undefined when calling getLausByCountryCodeAndName1ContainingIgnoreCase.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/lau/countryCode/${countryCode}/name/${name1}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get laus by nuts3
     * 
     * @param nuts3 
     */
    private getLausByNuts3WithHttpInfo(nuts3: string ): Observable<Response> {
        const path = this.basePath + `/lau/nuts3/${nuts3}`;
//        .replace('{' + 'nuts3' + '}', String(nuts3));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'nuts3' is not null or undefined
        if (nuts3 === null || nuts3 === undefined) {
            throw new Error('Required parameter nuts3 was null or undefined when calling getLausByNuts3.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/lau/nuts3/${nuts3}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update Lau Physical Address
     * 
     * @param body 
     */
    private updatePhysicalAddressWithHttpInfo(body?: models.LauDTO ): Observable<Response> {
        const path = this.basePath + `/lau/physicaladdress`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/lau/physicaladdress".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
