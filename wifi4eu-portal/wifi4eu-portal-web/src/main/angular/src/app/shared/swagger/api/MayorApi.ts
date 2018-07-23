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


export const IMayorApi = new OpaqueToken('IMayorApi');

export interface IMayorApi {


    /**
     * Get mayor by specific municipality id
     * 
     * @param c 
     * @param municipalityId 
     */
    getMayorByMunicipalityId<T extends models.MayorDTO>(municipalityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Update mayor details
     * 
     * @param c 
     * @param body 
     */
    updateMayorDetails<T extends models.ResponseDTO>(body?: models.MayorDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class MayorApi implements IMayorApi {
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
     * Get mayor by specific municipality id
     * 
     * @param c
     * @param municipalityId 
     */
    getMayorByMunicipalityId<T extends models.MayorDTO>(municipalityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getMayorByMunicipalityIdWithHttpInfo(municipalityId)
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
     * Update mayor details
     * 
     * @param c
     * @param body 
     */
    updateMayorDetails<T extends models.ResponseDTO>(body?: models.MayorDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateMayorDetailsWithHttpInfo(body)
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
     * Get mayor by specific municipality id
     * 
     * @param municipalityId 
     */
    private getMayorByMunicipalityIdWithHttpInfo(municipalityId: number ): Observable<Response> {
        const path = this.basePath + `/mayor/municipalityId/${municipalityId}`;
//        .replace('{' + 'municipalityId' + '}', String(municipalityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'municipalityId' is not null or undefined
        if (municipalityId === null || municipalityId === undefined) {
            throw new Error('Required parameter municipalityId was null or undefined when calling getMayorByMunicipalityId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/mayor/municipalityId/${municipalityId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update mayor details
     * 
     * @param body 
     */
    private updateMayorDetailsWithHttpInfo(body?: models.MayorDTO ): Observable<Response> {
        const path = this.basePath + `/mayor`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/mayor".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
