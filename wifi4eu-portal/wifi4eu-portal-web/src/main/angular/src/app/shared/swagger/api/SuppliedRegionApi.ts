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


export const ISuppliedRegionApi = new OpaqueToken('ISuppliedRegionApi');

export interface ISuppliedRegionApi {


    /**
     * Get all the suppliedRegions grouped by regions
     * 
     * @param c 
     */
    getSuppliedRegionsCountGroupedByRegionId<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class SuppliedRegionApi implements ISuppliedRegionApi {
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
     * Get all the suppliedRegions grouped by regions
     * 
     * @param c
     */
    getSuppliedRegionsCountGroupedByRegionId<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSuppliedRegionsCountGroupedByRegionIdWithHttpInfo()
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
     * Get all the suppliedRegions grouped by regions
     * 
     */
    private getSuppliedRegionsCountGroupedByRegionIdWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/suppliedRegion`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/suppliedRegion".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
