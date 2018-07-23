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


export const IUserApi = new OpaqueToken('IUserApi');

export interface IUserApi {


    /**
     * Delete user by specific id
     * 
     * @param c 
     * @param body 
     */
    deleteUser<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T>;
    /**
     * Logout session
     * 
     */
    doCompleteSignOut(): Observable<string>;
    /**
     * Service to do Login with a ECAS User
     * 
     * @param c 
     */
    ecasChangePassword<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Service to do Login with a ECAS User
     * 
     * @param c 
     */
    ecasLogin<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Service to do Login with a ECAS User
     * 
     * @param c 
     */
    ecasLogout<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T>;
    /**
     * Get user by specific id
     * 
     * @param c 
     * @param userId 
     */
    getUserById<T extends models.UserDTO>(userId: number, c?: ClassType<T>): Observable<T>;
    /**
     * Service to resend email with a link to activate account
     * 
     * @param c 
     * @param body 
     */
    resendEmail<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T>;
    /**
     * Update new language for user
     * 
     * @param c 
     * @param body 
     */
    updateLanguage<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T>;
    /**
     * Update user details
     * 
     * @param c 
     * @param body 
     */
    updateUserDetails<T extends models.ResponseDTO>(body?: models.UserDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class UserApi implements IUserApi {
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
     * Delete user by specific id
     * 
     * @param c
     * @param body 
     */
    deleteUser<T extends models.ResponseDTO>(body?: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.deleteUserWithHttpInfo(body)
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
     * Logout session
     * 
     */
    public doCompleteSignOut(): Observable<string> {
        return this.doCompleteSignOutWithHttpInfo()
            .map((response: Response) => {
                if (response.status === 204) {
                    return undefined;
                } else {
                    return response.json();
                }
            });
    }




    /**
     * Service to do Login with a ECAS User
     * 
     * @param c
     */
    ecasChangePassword<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.ecasChangePasswordWithHttpInfo()
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
     * Service to do Login with a ECAS User
     * 
     * @param c
     */
    ecasLogin<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.ecasLoginWithHttpInfo()
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
     * Service to do Login with a ECAS User
     * 
     * @param c
     */
    ecasLogout<T extends models.ResponseDTO>(c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.ecasLogoutWithHttpInfo()
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
     * Get user by specific id
     * 
     * @param c
     * @param userId 
     */
    getUserById<T extends models.UserDTO>(userId: number, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.getUserByIdWithHttpInfo(userId)
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
     * Service to resend email with a link to activate account
     * 
     * @param c
     * @param body 
     */
    resendEmail<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.resendEmailWithHttpInfo(body)
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
     * Update new language for user
     * 
     * @param c
     * @param body 
     */
    updateLanguage<T extends models.ResponseDTO>(body?: string, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateLanguageWithHttpInfo(body)
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
     * Update user details
     * 
     * @param c
     * @param body 
     */
    updateUserDetails<T extends models.ResponseDTO>(body?: models.UserDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.updateUserDetailsWithHttpInfo(body)
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
     * Delete user by specific id
     * 
     * @param body 
     */
    private deleteUserWithHttpInfo(body?: number ): Observable<Response> {
        const path = this.basePath + `/user`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Delete,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/user".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Logout session
     * 
     */
    private doCompleteSignOutWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/user/logout`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/user/logout".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Service to do Login with a ECAS User
     * 
     */
    private ecasChangePasswordWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/user/ecasChangePassword`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/user/ecasChangePassword".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Service to do Login with a ECAS User
     * 
     */
    private ecasLoginWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/user/ecaslogin`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/user/ecaslogin".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Service to do Login with a ECAS User
     * 
     */
    private ecasLogoutWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/user/ecaslogout`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            search: queryParameters,
            responseType: "/user/ecaslogout".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Get user by specific id
     * 
     * @param userId 
     */
    private getUserByIdWithHttpInfo(userId: number ): Observable<Response> {
        const path = this.basePath + `/user/${userId}`;
//        .replace('{' + 'userId' + '}', String(userId));  
// not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
// (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)

        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userId' is not null or undefined
        if (userId === null || userId === undefined) {
            throw new Error('Required parameter userId was null or undefined when calling getUserById.');
        }




        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Get,
            headers: headers,
            search: queryParameters,
            responseType: "/user/${userId}".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Service to resend email with a link to activate account
     * 
     * @param body 
     */
    private resendEmailWithHttpInfo(body?: string ): Observable<Response> {
        const path = this.basePath + `/user/resendEmail`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/user/resendEmail".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update new language for user
     * 
     * @param body 
     */
    private updateLanguageWithHttpInfo(body?: string ): Observable<Response> {
        const path = this.basePath + `/user/updateLanguage`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Post,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/user/updateLanguage".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

    /**
     * Update user details
     * 
     * @param body 
     */
    private updateUserDetailsWithHttpInfo(body?: models.UserDTO ): Observable<Response> {
        const path = this.basePath + `/user`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845


        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Put,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: "/user".indexOf('Excel') == -1 ? ResponseContentType.Json : ResponseContentType.Blob
        });

        return this.http.request(path, requestOptions);
    }

}
