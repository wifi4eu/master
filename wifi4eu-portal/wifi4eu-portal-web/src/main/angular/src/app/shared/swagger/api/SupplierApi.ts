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


export const ISupplierApi = new OpaqueToken('ISupplierApi');

export interface ISupplierApi {


    /**
     * findDgconnSuppliersList
     * 
     * @param c 
     * @param page 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnSuppliersList<T extends models.ResponseDTO>(page: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T>;
    /**
     * findDgconnSuppliersListSearchingName
     * 
     * @param c 
     * @param name 
     * @param page 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnSuppliersListSearchingName<T extends models.ResponseDTO>(name: string, page: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get suppliers that have the same VAT and/or Account Number as the specific supplier
     * 
     * @param c 
     * @param supplierId 
     */
    findSimilarSuppliers<T extends models.SupplierDTO>(supplierId: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get supplier by specific id
     * 
     * @param c 
     * @param supplierId 
     */
    getSupplierById<T extends models.SupplierDTO>(supplierId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get supplier by specific user id
     * 
     * @param c 
     * @param userId 
     */
    getSupplierByUserId<T extends models.SupplierDTO>(userId: number, c?: ClassType<T>): Observable<T>;
    /**
     * getSupplierListItemDTO
     * 
     * @param c 
     */
    getSupplierListItemDTO<T extends models.SupplierListItemDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Get suppliers registered by country
     * 
     * @param c 
     * @param countryCode 
     * @param page 
     * @param size 
     */
    getSuppliersRegisteredByCountry<T extends models.ResponseDTO>(countryCode: string, page: number, size: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get suppliers registered by region
     * 
     * @param c 
     * @param regionId 
     * @param page 
     * @param size 
     */
    getSuppliersRegisteredByRegion<T extends models.ResponseDTO>(regionId: number, page: number, size: number, c?: ClassType<T>): Observable<T>;
    /**
     * Invalidate supplier
     * 
     * @param c 
     * @param body 
     */
    invalidateSupplier<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Request legal documents
     * 
     * @param c 
     * @param supplierId 
     */
    requestLegalDocuments<T extends models.ResponseDTO>(supplierId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Submit supplier registration
     * 
     * @param c 
     * @param body 
     */
    submitSupplierRegistration<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T>;
    /**
     * update Contact Details
     * 
     * @param c 
     * @param body 
     */
    updateContactDetails<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Update supplier
     * 
     * @param c 
     * @param body 
     */
    updateSupplier<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T>;
    /**
     * update Supplier Details
     * 
     * @param c 
     * @param body 
     */
    updateSupplierDetails<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class SupplierApi implements ISupplierApi {
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
     * findDgconnSuppliersList
     * 
     * @param c
     * @param page 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnSuppliersList<T extends models.ResponseDTO>(page: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findDgconnSuppliersListWithHttpInfo(page, count, orderField, orderType)
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
     * findDgconnSuppliersListSearchingName
     * 
     * @param c
     * @param name 
     * @param page 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    findDgconnSuppliersListSearchingName<T extends models.ResponseDTO>(name: string, page: number, count: number, orderField: string, orderType: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findDgconnSuppliersListSearchingNameWithHttpInfo(name, page, count, orderField, orderType)
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
     * Get suppliers that have the same VAT and/or Account Number as the specific supplier
     * 
     * @param c
     * @param supplierId 
     */
    findSimilarSuppliers<T extends models.SupplierDTO>(supplierId: number, c?: ClassType<T>): Observable<T[]> {

        return this.findSimilarSuppliersWithHttpInfo(supplierId)
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
     * Get supplier by specific id
     * 
     * @param c
     * @param supplierId 
     */
    getSupplierById<T extends models.SupplierDTO>(supplierId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSupplierByIdWithHttpInfo(supplierId)
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
     * Get supplier by specific user id
     * 
     * @param c
     * @param userId 
     */
    getSupplierByUserId<T extends models.SupplierDTO>(userId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSupplierByUserIdWithHttpInfo(userId)
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
     * getSupplierListItemDTO
     * 
     * @param c
     */
    getSupplierListItemDTO<T extends models.SupplierListItemDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSupplierListItemDTOWithHttpInfo()
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
     * Get suppliers registered by country
     * 
     * @param c
     * @param countryCode 
     * @param page 
     * @param size 
     */
    getSuppliersRegisteredByCountry<T extends models.ResponseDTO>(countryCode: string, page: number, size: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSuppliersRegisteredByCountryWithHttpInfo(countryCode, page, size)
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
     * Get suppliers registered by region
     * 
     * @param c
     * @param regionId 
     * @param page 
     * @param size 
     */
    getSuppliersRegisteredByRegion<T extends models.ResponseDTO>(regionId: number, page: number, size: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getSuppliersRegisteredByRegionWithHttpInfo(regionId, page, size)
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
     * Invalidate supplier
     * 
     * @param c
     * @param body 
     */
    invalidateSupplier<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.invalidateSupplierWithHttpInfo(body)
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
     * Request legal documents
     * 
     * @param c
     * @param supplierId 
     */
    requestLegalDocuments<T extends models.ResponseDTO>(supplierId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.requestLegalDocumentsWithHttpInfo(supplierId)
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
     * Submit supplier registration
     * 
     * @param c
     * @param body 
     */
    submitSupplierRegistration<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.submitSupplierRegistrationWithHttpInfo(body)
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
     * update Contact Details
     * 
     * @param c
     * @param body 
     */
    updateContactDetails<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateContactDetailsWithHttpInfo(body)
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
     * Update supplier
     * 
     * @param c
     * @param body 
     */
    updateSupplier<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateSupplierWithHttpInfo(body)
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
     * update Supplier Details
     * 
     * @param c
     * @param body 
     */
    updateSupplierDetails<T extends models.ResponseDTO>(body?: models.SupplierDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateSupplierDetailsWithHttpInfo(body)
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
     * findDgconnSuppliersList
     * 
     * @param page 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    private findDgconnSuppliersListWithHttpInfo(page: number,  count: number,  orderField: string,  orderType: number ): Observable<Response> {
        const path = this.basePath + `/supplier/findDgconnSuppliersList`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'page' is not null or undefined
        if (page === null || page === undefined) {
            throw new Error('Required parameter page was null or undefined when calling findDgconnSuppliersList.');
        }
        // verify required parameter 'count' is not null or undefined
        if (count === null || count === undefined) {
            throw new Error('Required parameter count was null or undefined when calling findDgconnSuppliersList.');
        }
        // verify required parameter 'orderField' is not null or undefined
        if (orderField === null || orderField === undefined) {
            throw new Error('Required parameter orderField was null or undefined when calling findDgconnSuppliersList.');
        }
        // verify required parameter 'orderType' is not null or undefined
        if (orderType === null || orderType === undefined) {
            throw new Error('Required parameter orderType was null or undefined when calling findDgconnSuppliersList.');
        }
        if (page !== undefined) {
            queryParameters.set('page', <any>page);
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
            responseType: "/supplier/findDgconnSuppliersList".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * findDgconnSuppliersListSearchingName
     * 
     * @param name 
     * @param page 
     * @param count 
     * @param orderField 
     * @param orderType 
     */
    private findDgconnSuppliersListSearchingNameWithHttpInfo(name: string,  page: number,  count: number,  orderField: string,  orderType: number ): Observable<Response> {
        const path = this.basePath + `/supplier/findDgconnSuppliersListSearchingName`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'name' is not null or undefined
        if (name === null || name === undefined) {
            throw new Error('Required parameter name was null or undefined when calling findDgconnSuppliersListSearchingName.');
        }
        // verify required parameter 'page' is not null or undefined
        if (page === null || page === undefined) {
            throw new Error('Required parameter page was null or undefined when calling findDgconnSuppliersListSearchingName.');
        }
        // verify required parameter 'count' is not null or undefined
        if (count === null || count === undefined) {
            throw new Error('Required parameter count was null or undefined when calling findDgconnSuppliersListSearchingName.');
        }
        // verify required parameter 'orderField' is not null or undefined
        if (orderField === null || orderField === undefined) {
            throw new Error('Required parameter orderField was null or undefined when calling findDgconnSuppliersListSearchingName.');
        }
        // verify required parameter 'orderType' is not null or undefined
        if (orderType === null || orderType === undefined) {
            throw new Error('Required parameter orderType was null or undefined when calling findDgconnSuppliersListSearchingName.');
        }
        if (name !== undefined) {
            queryParameters.set('name', <any>name);
        }
        if (page !== undefined) {
            queryParameters.set('page', <any>page);
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
            responseType: "/supplier/findDgconnSuppliersListSearchingName".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get suppliers that have the same VAT and/or Account Number as the specific supplier
     * 
     * @param supplierId 
     */
    private findSimilarSuppliersWithHttpInfo(supplierId: number ): Observable<Response> {
        const path = this.basePath + `/supplier/similarSuppliers/${supplierId}`;
//        .replace('{' + 'supplierId' + '}', String(supplierId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'supplierId' is not null or undefined
        if (supplierId === null || supplierId === undefined) {
            throw new Error('Required parameter supplierId was null or undefined when calling findSimilarSuppliers.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/similarSuppliers/${supplierId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get supplier by specific id
     * 
     * @param supplierId 
     */
    private getSupplierByIdWithHttpInfo(supplierId: number ): Observable<Response> {
        const path = this.basePath + `/supplier/${supplierId}`;
//        .replace('{' + 'supplierId' + '}', String(supplierId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'supplierId' is not null or undefined
        if (supplierId === null || supplierId === undefined) {
            throw new Error('Required parameter supplierId was null or undefined when calling getSupplierById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/${supplierId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get supplier by specific user id
     * 
     * @param userId 
     */
    private getSupplierByUserIdWithHttpInfo(userId: number ): Observable<Response> {
        const path = this.basePath + `/supplier/user/${userId}`;
//        .replace('{' + 'userId' + '}', String(userId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userId' is not null or undefined
        if (userId === null || userId === undefined) {
            throw new Error('Required parameter userId was null or undefined when calling getSupplierByUserId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/user/${userId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * getSupplierListItemDTO
     * 
     */
    private getSupplierListItemDTOWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/supplier/getSupplierListItemDTO`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/getSupplierListItemDTO".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get suppliers registered by country
     * 
     * @param countryCode 
     * @param page 
     * @param size 
     */
    private getSuppliersRegisteredByCountryWithHttpInfo(countryCode: string,  page: number,  size: number ): Observable<Response> {
        const path = this.basePath + `/supplier/all/country/${countryCode}`;
//        .replace('{' + 'countryCode' + '}', String(countryCode));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling getSuppliersRegisteredByCountry.');
        }
        // verify required parameter 'page' is not null or undefined
        if (page === null || page === undefined) {
            throw new Error('Required parameter page was null or undefined when calling getSuppliersRegisteredByCountry.');
        }
        // verify required parameter 'size' is not null or undefined
        if (size === null || size === undefined) {
            throw new Error('Required parameter size was null or undefined when calling getSuppliersRegisteredByCountry.');
        }
        if (page !== undefined) {
            queryParameters.set('page', <any>page);
        }
        if (size !== undefined) {
            queryParameters.set('size', <any>size);
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/all/country/${countryCode}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get suppliers registered by region
     * 
     * @param regionId 
     * @param page 
     * @param size 
     */
    private getSuppliersRegisteredByRegionWithHttpInfo(regionId: number,  page: number,  size: number ): Observable<Response> {
        const path = this.basePath + `/supplier/all/region/${regionId}`;
//        .replace('{' + 'regionId' + '}', String(regionId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'regionId' is not null or undefined
        if (regionId === null || regionId === undefined) {
            throw new Error('Required parameter regionId was null or undefined when calling getSuppliersRegisteredByRegion.');
        }
        // verify required parameter 'page' is not null or undefined
        if (page === null || page === undefined) {
            throw new Error('Required parameter page was null or undefined when calling getSuppliersRegisteredByRegion.');
        }
        // verify required parameter 'size' is not null or undefined
        if (size === null || size === undefined) {
            throw new Error('Required parameter size was null or undefined when calling getSuppliersRegisteredByRegion.');
        }
        if (page !== undefined) {
            queryParameters.set('page', <any>page);
        }
        if (size !== undefined) {
            queryParameters.set('size', <any>size);
        }
        headers.set('X-API', 'public');




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/all/region/${regionId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Invalidate supplier
     * 
     * @param body 
     */
    private invalidateSupplierWithHttpInfo(body?: models.SupplierDTO ): Observable<Response> {
        const path = this.basePath + `/supplier/invalidate`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/supplier/invalidate".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Request legal documents
     * 
     * @param supplierId 
     */
    private requestLegalDocumentsWithHttpInfo(supplierId: number ): Observable<Response> {
        const path = this.basePath + `/supplier/requestLegalDocuments/${supplierId}`;
//        .replace('{' + 'supplierId' + '}', String(supplierId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'supplierId' is not null or undefined
        if (supplierId === null || supplierId === undefined) {
            throw new Error('Required parameter supplierId was null or undefined when calling requestLegalDocuments.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/supplier/requestLegalDocuments/${supplierId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Submit supplier registration
     * 
     * @param body 
     */
    private submitSupplierRegistrationWithHttpInfo(body?: models.SupplierDTO ): Observable<Response> {
        const path = this.basePath + `/supplier/submitRegistration`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/supplier/submitRegistration".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * update Contact Details
     * 
     * @param body 
     */
    private updateContactDetailsWithHttpInfo(body?: models.SupplierDTO ): Observable<Response> {
        const path = this.basePath + `/supplier/update/contactDetails`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/supplier/update/contactDetails".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update supplier
     * 
     * @param body 
     */
    private updateSupplierWithHttpInfo(body?: models.SupplierDTO ): Observable<Response> {
        const path = this.basePath + `/supplier`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/supplier".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * update Supplier Details
     * 
     * @param body 
     */
    private updateSupplierDetailsWithHttpInfo(body?: models.SupplierDTO ): Observable<Response> {
        const path = this.basePath + `/supplier/update/supplierDetails`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/supplier/update/supplierDetails".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
