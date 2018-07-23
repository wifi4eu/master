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


export const IInstallationsiteApi = new OpaqueToken('IInstallationsiteApi');

export interface IInstallationsiteApi {


    /**
     * Edit Installation Site
     * 
     * @param c 
     * @param body 
     */
    editInstallationSiteDTO<T extends models.ResponseDTO>(body?: models.InstallationSite, c?: ClassType<T>): Observable<T>;
    /**
     * Get installation site details
     * 
     * @param c 
     * @param id 
     */
    getInstallationSite<T extends models.ResponseDTO>(id: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get all installation sites by beneficiary
     * 
     * @param c 
     * @param body 
     */
    getInstallationSiteListByBeneficiary<T extends models.ResponseDTO>(body?: any, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class InstallationsiteApi implements IInstallationsiteApi {
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
     * Edit Installation Site
     * 
     * @param c
     * @param body 
     */
    editInstallationSiteDTO<T extends models.ResponseDTO>(body?: models.InstallationSite, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.editInstallationSiteDTOWithHttpInfo(body)
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
     * Get installation site details
     * 
     * @param c
     * @param id 
     */
    getInstallationSite<T extends models.ResponseDTO>(id: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getInstallationSiteWithHttpInfo(id)
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
     * Get all installation sites by beneficiary
     * 
     * @param c
     * @param body 
     */
    getInstallationSiteListByBeneficiary<T extends models.ResponseDTO>(body?: any, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getInstallationSiteListByBeneficiaryWithHttpInfo(body)
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
     * Edit Installation Site
     * 
     * @param body 
     */
    private editInstallationSiteDTOWithHttpInfo(body?: models.InstallationSite ): Observable<Response> {
        const path = this.basePath + `/installation-site/edit`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/installation-site/edit".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get installation site details
     * 
     * @param id 
     */
    private getInstallationSiteWithHttpInfo(id: number ): Observable<Response> {
        const path = this.basePath + `/installation-site/view/${id}`;
//        .replace('{' + 'id' + '}', String(id));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'id' is not null or undefined
        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling getInstallationSite.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/installation-site/view/${id}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get all installation sites by beneficiary
     * 
     * @param body 
     */
    private getInstallationSiteListByBeneficiaryWithHttpInfo(body?: any ): Observable<Response> {
        const path = this.basePath + `/installation-site/list`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/installation-site/list".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
