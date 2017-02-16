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


export const IDefaultApi = new OpaqueToken('IDefaultApi');

export interface IDefaultApi {


    /**
     * create Beneficiary
     * 
     * @param c 
     * @param body 
     */
    create<T extends >(body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<{}>;
    /**
     * get all nuts
     * 
     */
    findAllNuts(): Observable<string>;
    /**
     * get Lau by Country Code i.e: ES
     * 
     * @param c 
     * @param countryCode 
     */
    findLauByCountryCode<T extends models.LauDTO>(countryCode: string, c?: ClassType<T>): Observable<T[]>;
    /**
     * get all nuts from level X
     * 
     * @param c 
     * @param level 
     */
    findNutsByLevel<T extends models.NutsDTO>(level: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * User details resource
     * 
     * @param c 
     */
    getIdentity<T extends models.UserContext>(c?: ClassType<T>): Observable<T>;
    /**
     * get legal Entity information
     * 
     * @param c 
     * @param legalEntityId 
     */
    getLegalEntity<T extends models.LegalEntityDTO>(legalEntityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Test resource for Swagger implementation
     * 
     */
    getSomething(): Observable<string>;
    /**
     * get legal Entity information
     * 
     * @param body 
     */
    login(body?: models.UserDTO ): Observable<string>;

}

@Injectable()
export class DefaultApi implements IDefaultApi {
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
     * create Beneficiary
     * 
     * @param c
     * @param body 
     */
    create<T extends >(body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<{}> {
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
     * get all nuts
     * 
     */
    public findAllNuts(): Observable<string> {
        return this.findAllNutsWithHttpInfo()
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
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
     * get all nuts from level X
     * 
     * @param c
     * @param level 
     */
    findNutsByLevel<T extends models.NutsDTO>(level: number, c?: ClassType<T>): Observable<T[]> {

        return this.findNutsByLevelWithHttpInfo(level)
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
     * User details resource
     * 
     * @param c
     */
    getIdentity<T extends models.UserContext>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getIdentityWithHttpInfo()
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
     * get legal Entity information
     * 
     * @param c
     * @param legalEntityId 
     */
    getLegalEntity<T extends models.LegalEntityDTO>(legalEntityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLegalEntityWithHttpInfo(legalEntityId)
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
     * Test resource for Swagger implementation
     * 
     */
    public getSomething(): Observable<string> {
        return this.getSomethingWithHttpInfo()
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * get legal Entity information
     * 
     * @param body 
     */
    public login(body?: models.UserDTO ): Observable<string> {
        return this.loginWithHttpInfo(body)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * create Beneficiary
     * 
     * @param body 
     */
    private createWithHttpInfo(body?: models.BeneficiaryDTO ): Observable<Response> {
        const path = this.basePath + `/beneficiary`;


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
     * get all nuts
     * 
     */
    private findAllNutsWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/nuts`;


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
     * get all nuts from level X
     * 
     * @param level 
     */
    private findNutsByLevelWithHttpInfo(level: number ): Observable<Response> {
        const path = this.basePath + `/nuts/${level}`;
//        .replace('{' + 'level' + '}', String(level));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'level' is not null or undefined
        if (level === null || level === undefined) {
            throw new Error('Required parameter level was null or undefined when calling findNutsByLevel.');
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
     * User details resource
     * 
     */
    private getIdentityWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/user-details`;


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
     * get legal Entity information
     * 
     * @param legalEntityId 
     */
    private getLegalEntityWithHttpInfo(legalEntityId: number ): Observable<Response> {
        const path = this.basePath + `/beneficiary/${legalEntityId}`;
//        .replace('{' + 'legalEntityId' + '}', String(legalEntityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'legalEntityId' is not null or undefined
        if (legalEntityId === null || legalEntityId === undefined) {
            throw new Error('Required parameter legalEntityId was null or undefined when calling getLegalEntity.');
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
     * Test resource for Swagger implementation
     * 
     */
    private getSomethingWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/test`;


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
     * get legal Entity information
     * 
     * @param body 
     */
    private loginWithHttpInfo(body?: models.UserDTO ): Observable<Response> {
        const path = this.basePath + `/user/login`;


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

}
