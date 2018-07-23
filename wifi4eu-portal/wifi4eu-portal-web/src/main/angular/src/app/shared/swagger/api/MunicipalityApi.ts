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
     * Get municipalities by specific lau id
     * 
     * @param c 
     * @param lauId 
     */
    getMunicipalitiesByLauId<T extends models.MunicipalityDTO>(lauId: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get municipality by specific id
     * 
     * @param c 
     * @param municipalityId 
     */
    getMunicipalityById<T extends models.MunicipalityDTO>(municipalityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get municipality by specific id for thread
     * 
     * @param c 
     * @param municipalityId 
     */
    getMunicipalityThreadById<T extends models.MunicipalityDTO>(municipalityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get municipality by specific id
     * 
     * @param c 
     * @param municipalityId 
     */
    getUsersMunicipalityById<T extends models.ResponseDTO>(municipalityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Update municipality details
     * 
     * @param c 
     * @param body 
     */
    updateMunicipalityDetails<T extends models.ResponseDTO>(body?: models.MunicipalityDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class MunicipalityApi implements IMunicipalityApi {
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
     * Get municipalities by specific lau id
     * 
     * @param c
     * @param lauId 
     */
    getMunicipalitiesByLauId<T extends models.MunicipalityDTO>(lauId: number, c?: ClassType<T>): Observable<T[]> {

        return this.getMunicipalitiesByLauIdWithHttpInfo(lauId)
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
     * Get municipality by specific id
     * 
     * @param c
     * @param municipalityId 
     */
    getMunicipalityById<T extends models.MunicipalityDTO>(municipalityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getMunicipalityByIdWithHttpInfo(municipalityId)
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
     * Get municipality by specific id for thread
     * 
     * @param c
     * @param municipalityId 
     */
    getMunicipalityThreadById<T extends models.MunicipalityDTO>(municipalityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getMunicipalityThreadByIdWithHttpInfo(municipalityId)
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
     * Get municipality by specific id
     * 
     * @param c
     * @param municipalityId 
     */
    getUsersMunicipalityById<T extends models.ResponseDTO>(municipalityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getUsersMunicipalityByIdWithHttpInfo(municipalityId)
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
     * Update municipality details
     * 
     * @param c
     * @param body 
     */
    updateMunicipalityDetails<T extends models.ResponseDTO>(body?: models.MunicipalityDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateMunicipalityDetailsWithHttpInfo(body)
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
     * Get municipalities by specific lau id
     * 
     * @param lauId 
     */
    private getMunicipalitiesByLauIdWithHttpInfo(lauId: number ): Observable<Response> {
        const path = this.basePath + `/municipality/lauId/${lauId}`;
//        .replace('{' + 'lauId' + '}', String(lauId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'lauId' is not null or undefined
        if (lauId === null || lauId === undefined) {
            throw new Error('Required parameter lauId was null or undefined when calling getMunicipalitiesByLauId.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/municipality/lauId/${lauId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get municipality by specific id
     * 
     * @param municipalityId 
     */
    private getMunicipalityByIdWithHttpInfo(municipalityId: number ): Observable<Response> {
        const path = this.basePath + `/municipality/${municipalityId}`;
//        .replace('{' + 'municipalityId' + '}', String(municipalityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'municipalityId' is not null or undefined
        if (municipalityId === null || municipalityId === undefined) {
            throw new Error('Required parameter municipalityId was null or undefined when calling getMunicipalityById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/municipality/${municipalityId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get municipality by specific id for thread
     * 
     * @param municipalityId 
     */
    private getMunicipalityThreadByIdWithHttpInfo(municipalityId: number ): Observable<Response> {
        const path = this.basePath + `/municipality/thread/${municipalityId}`;
//        .replace('{' + 'municipalityId' + '}', String(municipalityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'municipalityId' is not null or undefined
        if (municipalityId === null || municipalityId === undefined) {
            throw new Error('Required parameter municipalityId was null or undefined when calling getMunicipalityThreadById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/municipality/thread/${municipalityId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get municipality by specific id
     * 
     * @param municipalityId 
     */
    private getUsersMunicipalityByIdWithHttpInfo(municipalityId: number ): Observable<Response> {
        const path = this.basePath + `/municipality/usersMunicipality/${municipalityId}`;
//        .replace('{' + 'municipalityId' + '}', String(municipalityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'municipalityId' is not null or undefined
        if (municipalityId === null || municipalityId === undefined) {
            throw new Error('Required parameter municipalityId was null or undefined when calling getUsersMunicipalityById.');
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/municipality/usersMunicipality/${municipalityId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update municipality details
     * 
     * @param body 
     */
    private updateMunicipalityDetailsWithHttpInfo(body?: models.MunicipalityDTO ): Observable<Response> {
        const path = this.basePath + `/municipality`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/municipality".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
