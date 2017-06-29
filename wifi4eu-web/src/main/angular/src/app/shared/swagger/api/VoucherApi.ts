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


export const IVoucherApi = new OpaqueToken('IVoucherApi');

export interface IVoucherApi {


    /**
     * create Voucher request
     * 
     * @param c 
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.VoucherDTO, c?: ClassType<T>): Observable<T>;
    /**
     * get all vouchers for a specific call
     * 
     * @param c 
     * @param callId 
     */
    findByCallId<T extends models.VoucherDTO>(callId: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * get all vouchers by voucherId
     * 
     * @param c 
     * @param voucherId 
     */
    findByVoucherId<T extends models.VoucherDTO>(voucherId: number, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class VoucherApi implements IVoucherApi {
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
     * create Voucher request
     * 
     * @param c
     * @param body 
     */
    create<T extends models.ResponseDTO>(body?: models.VoucherDTO, c?: ClassType<T>): Observable<T> {
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
     * get all vouchers for a specific call
     * 
     * @param c
     * @param callId 
     */
    findByCallId<T extends models.VoucherDTO>(callId: number, c?: ClassType<T>): Observable<T[]> {

        return this.findByCallIdWithHttpInfo(callId)
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
     * get all vouchers by voucherId
     * 
     * @param c
     * @param voucherId 
     */
    findByVoucherId<T extends models.VoucherDTO>(voucherId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.findByVoucherIdWithHttpInfo(voucherId)
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
     * create Voucher request
     * 
     * @param body 
     */
    private createWithHttpInfo(body?: models.VoucherDTO ): Observable<Response> {
        const path = this.basePath + `/voucher`;


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
     * get all vouchers for a specific call
     * 
     * @param callId 
     */
    private findByCallIdWithHttpInfo(callId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/call/${callId}`;
//        .replace('{' + 'callId' + '}', String(callId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling findByCallId.');
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
     * get all vouchers by voucherId
     * 
     * @param voucherId 
     */
    private findByVoucherIdWithHttpInfo(voucherId: number ): Observable<Response> {
        const path = this.basePath + `/voucher/${voucherId}`;
//        .replace('{' + 'voucherId' + '}', String(voucherId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'voucherId' is not null or undefined
        if (voucherId === null || voucherId === undefined) {
            throw new Error('Required parameter voucherId was null or undefined when calling findByVoucherId.');
        }







        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

}
