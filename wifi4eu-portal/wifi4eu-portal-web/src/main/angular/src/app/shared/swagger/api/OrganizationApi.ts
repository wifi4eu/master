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


export const IOrganizationApi = new OpaqueToken('IOrganizationApi');

export interface IOrganizationApi {


    /**
     * Get all the organizations
     * 
     * @param c 
     */
    allOrganizations<T extends models.OrganizationDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * Get organization by specific id
     * 
     * @param c 
     * @param organizationId 
     */
    getOrganizationById<T extends models.OrganizationDTO>(organizationId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get organizations by specific country
     * 
     * @param c 
     * @param country 
     */
    getOrganizationsByCountry<T extends models.OrganizationDTO>(country: string, c?: ClassType<T>): Observable<T[]>;

}

@Injectable()
export class OrganizationApi implements IOrganizationApi {
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
     * Get all the organizations
     * 
     * @param c
     */
    allOrganizations<T extends models.OrganizationDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allOrganizationsWithHttpInfo()
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
     * Get organization by specific id
     * 
     * @param c
     * @param organizationId 
     */
    getOrganizationById<T extends models.OrganizationDTO>(organizationId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getOrganizationByIdWithHttpInfo(organizationId)
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
     * Get organizations by specific country
     * 
     * @param c
     * @param country 
     */
    getOrganizationsByCountry<T extends models.OrganizationDTO>(country: string, c?: ClassType<T>): Observable<T[]> {

        return this.getOrganizationsByCountryWithHttpInfo(country)
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
     * Get all the organizations
     * 
     */
    private allOrganizationsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/organization`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/organization".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get organization by specific id
     * 
     * @param organizationId 
     */
    private getOrganizationByIdWithHttpInfo(organizationId: number ): Observable<Response> {
        const path = this.basePath + `/organization/${organizationId}`;
//        .replace('{' + 'organizationId' + '}', String(organizationId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'organizationId' is not null or undefined
        if (organizationId === null || organizationId === undefined) {
            throw new Error('Required parameter organizationId was null or undefined when calling getOrganizationById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/organization/${organizationId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get organizations by specific country
     * 
     * @param country 
     */
    private getOrganizationsByCountryWithHttpInfo(country: string ): Observable<Response> {
        const path = this.basePath + `/organization/country/${country}`;
//        .replace('{' + 'country' + '}', String(country));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'country' is not null or undefined
        if (country === null || country === undefined) {
            throw new Error('Required parameter country was null or undefined when calling getOrganizationsByCountry.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/organization/country/${country}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
