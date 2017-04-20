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


export const ITimelineApi = new OpaqueToken('ITimelineApi');

export interface ITimelineApi {


    /**
     * Get all the timeline entries
     * 
     * @param c 
     */
    allTimelines<T extends models.TimelineDTO>(c?: ClassType<T>): Observable<T[]>;
    /**
     * create Timeline
     * 
     * @param c 
     * @param body 
     */
    createTimeline<T extends models.ResponseDTO>(body?: models.TimelineDTO, c?: ClassType<T>): Observable<T>;
    /**
     * delete Timeline
     * 
     * @param c 
     * @param body 
     */
    deleteTimeline<T extends models.ResponseDTO>(body?: models.TimelineDTO, c?: ClassType<T>): Observable<T>;

}

@Injectable()
export class TimelineApi implements ITimelineApi {
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
     * Get all the timeline entries
     * 
     * @param c
     */
    allTimelines<T extends models.TimelineDTO>(c?: ClassType<T>): Observable<T[]> {

        return this.allTimelinesWithHttpInfo()
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
     * create Timeline
     * 
     * @param c
     * @param body 
     */
    createTimeline<T extends models.ResponseDTO>(body?: models.TimelineDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.createTimelineWithHttpInfo(body)
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
     * delete Timeline
     * 
     * @param c
     * @param body 
     */
    deleteTimeline<T extends models.ResponseDTO>(body?: models.TimelineDTO, c?: ClassType<T>): Observable<T> {
        // noinspection TypeScriptValidateTypes
        return this.deleteTimelineWithHttpInfo(body)
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
     * Get all the timeline entries
     * 
     */
    private allTimelinesWithHttpInfo(): Observable<Response> {
        const path = this.basePath + `/timeline`;


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
     * create Timeline
     * 
     * @param body 
     */
    private createTimelineWithHttpInfo(body?: models.TimelineDTO ): Observable<Response> {
        const path = this.basePath + `/timeline`;


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
     * delete Timeline
     * 
     * @param body 
     */
    private deleteTimelineWithHttpInfo(body?: models.TimelineDTO ): Observable<Response> {
        const path = this.basePath + `/timeline`;


        let queryParameters = new URLSearchParams();
        let headers = new Headers(this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845





        headers.set('Content-Type', 'application/json');


        let requestOptions: RequestOptionsArgs = new RequestOptions({
            method: RequestMethod.Delete,
            headers: headers,
            body: body == null ? '' : /*JSON.stringify*/classToPlain(body), // https://github.com/angular/angular/issues/10612
            search: queryParameters,
            responseType: ResponseContentType.Json
        });

        return this.http.request(path, requestOptions);
    }

}
