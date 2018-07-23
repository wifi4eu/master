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


export const IBeneficiaryApi = new OpaqueToken('IBeneficiaryApi');

export interface IBeneficiaryApi {


    /**
     * Edit Beneficiary
     * 
     * @param c 
     * @param body 
     */
    editBeneficiaryDisplayedListDTO<T extends models.ResponseDTO>(body?: models.BeneficiaryDisplayedListDTO, c?: ClassType<T>): Observable<T>;
    /**
     * exportCSVDGConnBeneficiariesList
     * 
     * @param c 
     */
    exportCSVDGConnBeneficiariesList<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * exportCSVDGConnBeneficiariesListSearchingName
     * 
     * @param c 
     * @param name 
     */
    exportCSVDGConnBeneficiariesListSearchingName<T extends models.ResponseDTO>(name: string, c?: ClassType<T>): Observable<T>;
    /**
     * exportExcelDGConnBeneficiariesList
     * 
     */
    exportExcelDGConnBeneficiariesList(): Observable<Array<string>>;
    /**
     * exportExcelDGConnBeneficiariesListSearchingName
     * 
     * @param name 
     */
    exportExcelDGConnBeneficiariesListSearchingName(name: string ): Observable<Array<string>>;
    /**
     * findDgconnBeneficiaresList
     * 
     * @param c 
     * @param offset 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnBeneficiaresList<T extends models.ResponseDTO>(offset: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T>;
    /**
     * findDgconnBeneficiaresListSearchingName
     * 
     * @param c 
     * @param name 
     * @param offset 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnBeneficiaresListSearchingName<T extends models.ResponseDTO>(name: string, offset: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get all beneficiaries
     * 
     * @param c 
     */
    getBeneficiariesList<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * getBeneficiaryListItem
     * 
     * @param c 
     */
    getBeneficiaryListItem<T extends models.BeneficiaryListItemDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Submit beneficiary registration
     * 
     * @param c 
     * @param body 
     */
    submitBeneficiaryRegistration<T extends models.ResponseDTO>(body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class BeneficiaryApi implements IBeneficiaryApi {
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
     * Edit Beneficiary
     * 
     * @param c
     * @param body 
     */
    editBeneficiaryDisplayedListDTO<T extends models.ResponseDTO>(body?: models.BeneficiaryDisplayedListDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.editBeneficiaryDisplayedListDTOWithHttpInfo(body)
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
     * exportCSVDGConnBeneficiariesList
     * 
     * @param c
     */
    exportCSVDGConnBeneficiariesList<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.exportCSVDGConnBeneficiariesListWithHttpInfo()
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
     * exportCSVDGConnBeneficiariesListSearchingName
     * 
     * @param c
     * @param name 
     */
    exportCSVDGConnBeneficiariesListSearchingName<T extends models.ResponseDTO>(name: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.exportCSVDGConnBeneficiariesListSearchingNameWithHttpInfo(name)
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
     * exportExcelDGConnBeneficiariesList
     * 
     */
    public exportExcelDGConnBeneficiariesList(): Observable<Array<string>> {
        return this.exportExcelDGConnBeneficiariesListWithHttpInfo()
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }



    /**
     * exportExcelDGConnBeneficiariesListSearchingName
     * 
     * @param name 
     */
    public exportExcelDGConnBeneficiariesListSearchingName(name: string ): Observable<Array<string>> {
        return this.exportExcelDGConnBeneficiariesListSearchingNameWithHttpInfo(name)
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }




    /**
     * findDgconnBeneficiaresList
     * 
     * @param c
     * @param offset 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnBeneficiaresList<T extends models.ResponseDTO>(offset: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findDgconnBeneficiaresListWithHttpInfo(offset, count, orderField, orderType)
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
     * findDgconnBeneficiaresListSearchingName
     * 
     * @param c
     * @param name 
     * @param offset 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnBeneficiaresListSearchingName<T extends models.ResponseDTO>(name: string, offset: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findDgconnBeneficiaresListSearchingNameWithHttpInfo(name, offset, count, orderField, orderType)
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
     * Get all beneficiaries
     * 
     * @param c
     */
    getBeneficiariesList<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getBeneficiariesListWithHttpInfo()
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
     * getBeneficiaryListItem
     * 
     * @param c
     */
    getBeneficiaryListItem<T extends models.BeneficiaryListItemDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getBeneficiaryListItemWithHttpInfo()
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
     * Submit beneficiary registration
     * 
     * @param c
     * @param body 
     */
    submitBeneficiaryRegistration<T extends models.ResponseDTO>(body?: models.BeneficiaryDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.submitBeneficiaryRegistrationWithHttpInfo(body)
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
     * Edit Beneficiary
     * 
     * @param body 
     */
    private editBeneficiaryDisplayedListDTOWithHttpInfo(body?: models.BeneficiaryDisplayedListDTO ): Observable<Response> {
        const path = this.basePath + `/beneficiary/edit`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/beneficiary/edit".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * exportCSVDGConnBeneficiariesList
     * 
     */
    private exportCSVDGConnBeneficiariesListWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/beneficiary/exportCSVDGConnBeneficiariesList`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/exportCSVDGConnBeneficiariesList".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * exportCSVDGConnBeneficiariesListSearchingName
     * 
     * @param name 
     */
    private exportCSVDGConnBeneficiariesListSearchingNameWithHttpInfo(name: string ): Observable<Response> {
        const path = this.basePath + `/beneficiary/exportCSVDGConnBeneficiariesListSearchingName`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'name' is not null or undefined
        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling exportCSVDGConnBeneficiariesListSearchingName.');
        }
        if (name !== undefined) {
            queryParameters.set('name', <any>name);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/exportCSVDGConnBeneficiariesListSearchingName".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * exportExcelDGConnBeneficiariesList
     * 
     */
    private exportExcelDGConnBeneficiariesListWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/beneficiary/exportExcelDGConnBeneficiariesList`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/exportExcelDGConnBeneficiariesList".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * exportExcelDGConnBeneficiariesListSearchingName
     * 
     * @param name 
     */
    private exportExcelDGConnBeneficiariesListSearchingNameWithHttpInfo(name: string ): Observable<Response> {
        const path = this.basePath + `/beneficiary/exportExcelDGConnBeneficiariesListSearchingName`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'name' is not null or undefined
        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling exportExcelDGConnBeneficiariesListSearchingName.');
        }
        if (name !== undefined) {
            queryParameters.set('name', <any>name);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/exportExcelDGConnBeneficiariesListSearchingName".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * findDgconnBeneficiaresList
     * 
     * @param offset 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    private findDgconnBeneficiaresListWithHttpInfo(offset: number,  count: number,  orderField: string,  orderType: number ): Observable<Response> {
        const path = this.basePath + `/beneficiary/findDgconnBeneficiaresList`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'offset' is not null or undefined
        if (offset === null || offset === undefined) {
            throw new Error('Required parameter offset was null or undefined when calling findDgconnBeneficiaresList.');
        }
        // verify required parameter 'count' is not null or undefined
        if (count === null || count === undefined) {
            throw new Error('Required parameter count was null or undefined when calling findDgconnBeneficiaresList.');
        }
        // verify required parameter 'orderField' is not null or undefined
        if (orderField === null || orderField === undefined) {
            throw new Error('Required parameter orderField was null or undefined when calling findDgconnBeneficiaresList.');
        }
        // verify required parameter 'orderType' is not null or undefined
        if (orderType === null || orderType === undefined) {
            throw new Error('Required parameter orderType was null or undefined when calling findDgconnBeneficiaresList.');
        }
        if (offset !== undefined) {
            queryParameters.set('offset', <any>offset);
        }
        if (count !== undefined) {
            queryParameters.set('count', <any>count);
        }
        if (orderField !== undefined) {
            queryParameters.set('orderField', <any>orderField);
        }
        if (orderType !== undefined) {
            queryParameters.set('orderType', <any>orderType);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/findDgconnBeneficiaresList".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * findDgconnBeneficiaresListSearchingName
     * 
     * @param name 
     * @param offset 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    private findDgconnBeneficiaresListSearchingNameWithHttpInfo(name: string,  offset: number,  count: number,  orderField: string,  orderType: number ): Observable<Response> {
        const path = this.basePath + `/beneficiary/findDgconnBeneficiaresListSearchingName`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'name' is not null or undefined
        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling findDgconnBeneficiaresListSearchingName.');
        }
        // verify required parameter 'offset' is not null or undefined
        if (offset === null || offset === undefined) {
            throw new Error('Required parameter offset was null or undefined when calling findDgconnBeneficiaresListSearchingName.');
        }
        // verify required parameter 'count' is not null or undefined
        if (count === null || count === undefined) {
            throw new Error('Required parameter count was null or undefined when calling findDgconnBeneficiaresListSearchingName.');
        }
        // verify required parameter 'orderField' is not null or undefined
        if (orderField === null || orderField === undefined) {
            throw new Error('Required parameter orderField was null or undefined when calling findDgconnBeneficiaresListSearchingName.');
        }
        // verify required parameter 'orderType' is not null or undefined
        if (orderType === null || orderType === undefined) {
            throw new Error('Required parameter orderType was null or undefined when calling findDgconnBeneficiaresListSearchingName.');
        }
        if (name !== undefined) {
            queryParameters.set('name', <any>name);
        }
        if (offset !== undefined) {
            queryParameters.set('offset', <any>offset);
        }
        if (count !== undefined) {
            queryParameters.set('count', <any>count);
        }
        if (orderField !== undefined) {
            queryParameters.set('orderField', <any>orderField);
        }
        if (orderType !== undefined) {
            queryParameters.set('orderType', <any>orderType);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/findDgconnBeneficiaresListSearchingName".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get all beneficiaries
     * 
     */
    private getBeneficiariesListWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/beneficiary/beneficiaries-list`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/beneficiaries-list".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * getBeneficiaryListItem
     * 
     */
    private getBeneficiaryListItemWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/beneficiary/getBeneficiaryListItem`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/beneficiary/getBeneficiaryListItem".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Submit beneficiary registration
     * 
     * @param body 
     */
    private submitBeneficiaryRegistrationWithHttpInfo(body?: models.BeneficiaryDTO ): Observable<Response> {
        const path = this.basePath + `/beneficiary/submit`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/beneficiary/submit".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
