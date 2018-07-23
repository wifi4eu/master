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


export const IRegistrationApi = new OpaqueToken('IRegistrationApi');

export interface IRegistrationApi {


    /**
     * Confirm or request revision of installation report
     * 
     * @param c 
     * @param body 
     */
    confirmOrRejectInstallationReport<T extends models.ResponseDTO>(body?: any, c?: ClassType<T>): Observable<T>;
    /**
     * Delete legal documents
     * 
     * @param c 
     * @param body 
     */
    deleteRegistrationDocuments<T extends models.ResponseDTO>(body?: models.RegistrationDTO, c?: ClassType<T>): Observable<T>;
    /**
     * getLegalFile
     * 
     * @param c 
     */
    getLegalFile<T extends models.LegalFileCorrectionReasonDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Get registration by specific userThread id
     * 
     * @param c 
     * @param registrationId 
     * @param fileType 
     */
    getLegalFilesByFileType<T extends models.ResponseDTO>(registrationId: number, fileType: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get legal files by registration id
     * 
     * @param c 
     * @param registrationId 
     * @param date 
     */
    getLegalFilesByRegistrationId<T extends models.LegalFileCorrectionReasonDTO>(registrationId: number, date: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Get registration by specific id
     * 
     * @param c 
     * @param registrationId 
     */
    getRegistrationById<T extends models.RegistrationDTO>(registrationId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get registrations by specific municipality id
     * 
     * @param c 
     * @param municipalityId 
     */
    getRegistrationByMunicipalityId<T extends models.RegistrationDTO>(municipalityId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get registration by specific userThread id
     * 
     * @param c 
     * @param userThreadId 
     */
    getRegistrationByUserThreadId<T extends models.RegistrationDTO>(userThreadId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Get registrations by specific user id
     * 
     * @param c 
     * @param userId 
     * @param date 
     */
    getRegistrationsByUserId<T extends models.RegistrationDTO>(userId: number, date: number, c?: ClassType<T>): Observable<T[]>;
    /**
     * Create registration
     * 
     * @param c 
     * @param body 
     */
    invalidateRegistration<T extends models.ResponseDTO>(body?: models.RegistrationDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Create/update a legal file
     * 
     * @param c 
     * @param body 
     */
    saveLegalFile<T extends models.ResponseDTO>(body?: models.LegalFileCorrectionReasonDTO, c?: ClassType<T>): Observable<T>;
    /**
     * Update legal documents
     * 
     * @param c 
     * @param body 
     */
    updateRegistrationDocuments<T extends models.ResponseDTO>(body?: models.RegistrationDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class RegistrationApi implements IRegistrationApi {
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
     * Confirm or request revision of installation report
     * 
     * @param c
     * @param body 
     */
    confirmOrRejectInstallationReport<T extends models.ResponseDTO>(body?: any, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.confirmOrRejectInstallationReportWithHttpInfo(body)
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
     * Delete legal documents
     * 
     * @param c
     * @param body 
     */
    deleteRegistrationDocuments<T extends models.ResponseDTO>(body?: models.RegistrationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.deleteRegistrationDocumentsWithHttpInfo(body)
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
     * getLegalFile
     * 
     * @param c
     */
    getLegalFile<T extends models.LegalFileCorrectionReasonDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLegalFileWithHttpInfo()
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
     * Get registration by specific userThread id
     * 
     * @param c
     * @param registrationId 
     * @param fileType 
     */
    getLegalFilesByFileType<T extends models.ResponseDTO>(registrationId: number, fileType: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getLegalFilesByFileTypeWithHttpInfo(registrationId, fileType)
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
     * Get legal files by registration id
     * 
     * @param c
     * @param registrationId 
     * @param date 
     */
    getLegalFilesByRegistrationId<T extends models.LegalFileCorrectionReasonDTO>(registrationId: number, date: number, c?: ClassType<T>): Observable<T[]> {

        return this.getLegalFilesByRegistrationIdWithHttpInfo(registrationId, date)
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
     * Get registration by specific id
     * 
     * @param c
     * @param registrationId 
     */
    getRegistrationById<T extends models.RegistrationDTO>(registrationId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getRegistrationByIdWithHttpInfo(registrationId)
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
     * Get registrations by specific municipality id
     * 
     * @param c
     * @param municipalityId 
     */
    getRegistrationByMunicipalityId<T extends models.RegistrationDTO>(municipalityId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getRegistrationByMunicipalityIdWithHttpInfo(municipalityId)
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
     * Get registration by specific userThread id
     * 
     * @param c
     * @param userThreadId 
     */
    getRegistrationByUserThreadId<T extends models.RegistrationDTO>(userThreadId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getRegistrationByUserThreadIdWithHttpInfo(userThreadId)
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
     * Get registrations by specific user id
     * 
     * @param c
     * @param userId 
     * @param date 
     */
    getRegistrationsByUserId<T extends models.RegistrationDTO>(userId: number, date: number, c?: ClassType<T>): Observable<T[]> {

        return this.getRegistrationsByUserIdWithHttpInfo(userId, date)
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
     * Create registration
     * 
     * @param c
     * @param body 
     */
    invalidateRegistration<T extends models.ResponseDTO>(body?: models.RegistrationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.invalidateRegistrationWithHttpInfo(body)
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
     * Create/update a legal file
     * 
     * @param c
     * @param body 
     */
    saveLegalFile<T extends models.ResponseDTO>(body?: models.LegalFileCorrectionReasonDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.saveLegalFileWithHttpInfo(body)
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
     * Update legal documents
     * 
     * @param c
     * @param body 
     */
    updateRegistrationDocuments<T extends models.ResponseDTO>(body?: models.RegistrationDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateRegistrationDocumentsWithHttpInfo(body)
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
     * Confirm or request revision of installation report
     * 
     * @param body 
     */
    private confirmOrRejectInstallationReportWithHttpInfo(body?: any ): Observable<Response> {
        const path = this.basePath + `/registration/confirmOrRejectReport`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/registration/confirmOrRejectReport".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Delete legal documents
     * 
     * @param body 
     */
    private deleteRegistrationDocumentsWithHttpInfo(body?: models.RegistrationDTO ): Observable<Response> {
        const path = this.basePath + `/registration/deleteDocuments`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/registration/deleteDocuments".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * getLegalFile
     * 
     */
    private getLegalFileWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/registration/getLegalFile`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/getLegalFile".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get registration by specific userThread id
     * 
     * @param registrationId 
     * @param fileType 
     */
    private getLegalFilesByFileTypeWithHttpInfo(registrationId: number,  fileType: number ): Observable<Response> {
        const path = this.basePath + `/registration/registrations/${registrationId}/${fileType}`;
//        .replace('{' + 'registrationId' + '}', String(registrationId)) 
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'fileType' + '}', String(fileType));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'registrationId' is not null or undefined
        if (registrationId === null || registrationId === undefined) {
            throw new Error('Required parameter registrationId was null or undefined when calling getLegalFilesByFileType.');
        }
        // verify required parameter 'fileType' is not null or undefined
        if (fileType === null || fileType === undefined) {
            throw new Error('Required parameter fileType was null or undefined when calling getLegalFilesByFileType.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/registrations/${registrationId}/${fileType}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get legal files by registration id
     * 
     * @param registrationId 
     * @param date 
     */
    private getLegalFilesByRegistrationIdWithHttpInfo(registrationId: number,  date: number ): Observable<Response> {
        const path = this.basePath + `/registration/getLegalFiles/${registrationId}`;
//        .replace('{' + 'registrationId' + '}', String(registrationId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'registrationId' is not null or undefined
        if (registrationId === null || registrationId === undefined) {
            throw new Error('Required parameter registrationId was null or undefined when calling getLegalFilesByRegistrationId.');
        }
        // verify required parameter 'date' is not null or undefined
        if (date === null || date === undefined) {
            throw new Error('Required parameter date was null or undefined when calling getLegalFilesByRegistrationId.');
        }
        if (date !== undefined) {
            queryParameters.set('date', <any>date);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/getLegalFiles/${registrationId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get registration by specific id
     * 
     * @param registrationId 
     */
    private getRegistrationByIdWithHttpInfo(registrationId: number ): Observable<Response> {
        const path = this.basePath + `/registration/${registrationId}`;
//        .replace('{' + 'registrationId' + '}', String(registrationId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'registrationId' is not null or undefined
        if (registrationId === null || registrationId === undefined) {
            throw new Error('Required parameter registrationId was null or undefined when calling getRegistrationById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/${registrationId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get registrations by specific municipality id
     * 
     * @param municipalityId 
     */
    private getRegistrationByMunicipalityIdWithHttpInfo(municipalityId: number ): Observable<Response> {
        const path = this.basePath + `/registration/municipality/${municipalityId}`;
//        .replace('{' + 'municipalityId' + '}', String(municipalityId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'municipalityId' is not null or undefined
        if (municipalityId === null || municipalityId === undefined) {
            throw new Error('Required parameter municipalityId was null or undefined when calling getRegistrationByMunicipalityId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/municipality/${municipalityId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get registration by specific userThread id
     * 
     * @param userThreadId 
     */
    private getRegistrationByUserThreadIdWithHttpInfo(userThreadId: number ): Observable<Response> {
        const path = this.basePath + `/registration/userThread/${userThreadId}`;
//        .replace('{' + 'userThreadId' + '}', String(userThreadId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userThreadId' is not null or undefined
        if (userThreadId === null || userThreadId === undefined) {
            throw new Error('Required parameter userThreadId was null or undefined when calling getRegistrationByUserThreadId.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/userThread/${userThreadId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get registrations by specific user id
     * 
     * @param userId 
     * @param date 
     */
    private getRegistrationsByUserIdWithHttpInfo(userId: number,  date: number ): Observable<Response> {
        const path = this.basePath + `/registration/user/${userId}`;
//        .replace('{' + 'userId' + '}', String(userId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userId' is not null or undefined
        if (userId === null || userId === undefined) {
            throw new Error('Required parameter userId was null or undefined when calling getRegistrationsByUserId.');
        }
        // verify required parameter 'date' is not null or undefined
        if (date === null || date === undefined) {
            throw new Error('Required parameter date was null or undefined when calling getRegistrationsByUserId.');
        }
        if (date !== undefined) {
            queryParameters.set('date', <any>date);
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/registration/user/${userId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Create registration
     * 
     * @param body 
     */
    private invalidateRegistrationWithHttpInfo(body?: models.RegistrationDTO ): Observable<Response> {
        const path = this.basePath + `/registration`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/registration".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Create/update a legal file
     * 
     * @param body 
     */
    private saveLegalFileWithHttpInfo(body?: models.LegalFileCorrectionReasonDTO ): Observable<Response> {
        const path = this.basePath + `/registration/saveLegalFile`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/registration/saveLegalFile".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update legal documents
     * 
     * @param body 
     */
    private updateRegistrationDocumentsWithHttpInfo(body?: models.RegistrationDTO ): Observable<Response> {
        const path = this.basePath + `/registration/updateDocuments`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/registration/updateDocuments".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
