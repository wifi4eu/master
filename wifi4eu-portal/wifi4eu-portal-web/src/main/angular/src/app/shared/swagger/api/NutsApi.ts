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


export const INutsApi = new OpaqueToken('INutsApi');

export interface INutsApi {


    /**
     * Get all nuts
     * 
     * @param c 
     */
    allNuts<T extends models.NutsDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * get nuts by code
     * 
     * @param c 
     * @param code 
     */
    getNutsByCode<T extends models.NutsDTO>(code: string, c?: ClassType<T>): Observable<T>;
    /**
     * Get all nuts from a specific countryCode
     * 
     * @param c 
     * @param countryCode 
     */
    getNutsByCountryCode<T extends models.NutsDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get all nuts from a specific countryCode and level order by Label Asc
     * 
     * @param c 
     * @param countryCode 
     * @param level 
     */
    getNutsByCountryCodeAndLevelOrderByLabelAsc<T extends models.NutsDTO>(countryCode: string, level: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * get nuts by specific id
     * 
     * @param c 
     * @param nutsId 
     */
    getNutsById<T extends models.NutsDTO>(nutsId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get all nuts from a specific level
     * 
     * @param c 
     * @param level 
     */
    getNutsByLevel<T extends models.NutsDTO>(level: number, c?: ClassType<T>): Observable<T[]>;

}

@Injectable()
export class NutsApi implements INutsApi {
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
     * Get all nuts
     * 
     * @param c
     */
    allNuts<T extends models.NutsDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allNutsWithHttpInfo()
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
     * get nuts by code
     * 
     * @param c
     * @param code 
     */
    getNutsByCode<T extends models.NutsDTO>(code: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getNutsByCodeWithHttpInfo(code)
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
     * Get all nuts from a specific countryCode
     * 
     * @param c
     * @param countryCode 
     */
    getNutsByCountryCode<T extends models.NutsDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]> {

        return this.getNutsByCountryCodeWithHttpInfo(countryCode)
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
     * Get all nuts from a specific countryCode and level order by Label Asc
     * 
     * @param c
     * @param countryCode 
     * @param level 
     */
    getNutsByCountryCodeAndLevelOrderByLabelAsc<T extends models.NutsDTO>(countryCode: string, level: number, c?: ClassType<T>): Observable<T[]> {

        return this.getNutsByCountryCodeAndLevelOrderByLabelAscWithHttpInfo(countryCode, level)
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
     * get nuts by specific id
     * 
     * @param c
     * @param nutsId 
     */
    getNutsById<T extends models.NutsDTO>(nutsId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getNutsByIdWithHttpInfo(nutsId)
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
     * Get all nuts from a specific level
     * 
     * @param c
     * @param level 
     */
    getNutsByLevel<T extends models.NutsDTO>(level: number, c?: ClassType<T>): Observable<T[]> {

        return this.getNutsByLevelWithHttpInfo(level)
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
     * Get all nuts
     * 
     */
    private allNutsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/nuts`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/nuts".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * get nuts by code
     * 
     * @param code 
     */
    private getNutsByCodeWithHttpInfo(code: string ): Observable<Response> {
        const path = this.basePath + `/nuts/code/${code}`;
//        .replace('{' + 'code' + '}', String(code));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'code' is not null or undefined
        if (code === null || code === undefined) {
            throw new Error('Required parameter code was null or undefined when calling getNutsByCode.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/nuts/code/${code}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get all nuts from a specific countryCode
     * 
     * @param countryCode 
     */
    private getNutsByCountryCodeWithHttpInfo(countryCode: string ): Observable<Response> {
        const path = this.basePath + `/nuts/countryCode/${countryCode}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling getNutsByCountryCode.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/nuts/countryCode/${countryCode}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get all nuts from a specific countryCode and level order by Label Asc
     * 
     * @param countryCode 
     * @param level 
     */
    private getNutsByCountryCodeAndLevelOrderByLabelAscWithHttpInfo(countryCode: string,  level: number ): Observable<Response> {
        const path = this.basePath + `/nuts/countryCode/${countryCode}/level/${level}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'level' + '}', String(level));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling getNutsByCountryCodeAndLevelOrderByLabelAsc.');
        }
        // verify required parameter 'level' is not null or undefined
        if (level === null || level === undefined) {
            throw new Error('Required parameter level was null or undefined when calling getNutsByCountryCodeAndLevelOrderByLabelAsc.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/nuts/countryCode/${countryCode}/level/${level}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * get nuts by specific id
     * 
     * @param nutsId 
     */
    private getNutsByIdWithHttpInfo(nutsId: number ): Observable<Response> {
        const path = this.basePath + `/nuts/${nutsId}`;
//        .replace('{' + 'nutsId' + '}', String(nutsId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'nutsId' is not null or undefined
        if (nutsId === null || nutsId === undefined) {
            throw new Error('Required parameter nutsId was null or undefined when calling getNutsById.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/nuts/${nutsId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get all nuts from a specific level
     * 
     * @param level 
     */
    private getNutsByLevelWithHttpInfo(level: number ): Observable<Response> {
        const path = this.basePath + `/nuts/level/${level}`;
//        .replace('{' + 'level' + '}', String(level));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'level' is not null or undefined
        if (level === null || level === undefined) {
            throw new Error('Required parameter level was null or undefined when calling getNutsByLevel.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/nuts/level/${level}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
