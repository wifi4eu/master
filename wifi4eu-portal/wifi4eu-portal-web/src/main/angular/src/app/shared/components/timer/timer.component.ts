import { Component, EventEmitter, Output, Input } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { SharedService } from '../../shared.service';
import { CallApi } from "../../swagger/api/CallApi";
import { environment } from 'environments/environment';

@Component({ selector: 'timer-component', templateUrl: 'timer.component.html', styleUrls: ['timer.component.scss'], providers: [CallApi] })
export class TimerComponent {
    @Output() timerEvent = new EventEmitter<any>();
    private initialTime: number;
    private initialPerformanceTime: number;
    @Input('expirationTimestamp') expirationTimestamp: number;
    private days: number;
    private hours: number;
    private minutes: number;
    private seconds: number;
    @Input('baseURLApi') baseURLApi: string;
    private timeGate: string = environment.applyVoucherUrl + "/time";
    private queryParameter: string = "?time=" + new Date().getTime();

    constructor(private http: Http, private sharedService: SharedService, private callApi: CallApi) {
    }

    ngOnInit() {
        //we get the time from server ONCE
        this.getTime();

        let subscription = Observable.interval(300).map((x) => { }).subscribe((x) => {
            /**
             * initialTime: Contains the time (in ms - Epoch Time) from the queue.
             * initialPerformanceTime: Contains the instant of time, relative to the initialization of the web app, when we retrieved the time to the server
             */
            let currentTimestamp = this.initialTime + (performance.now() - this.initialPerformanceTime);
            this.toEpoch(this.expirationTimestamp - currentTimestamp);
            if (this.checkIfFinished(this.expirationTimestamp - currentTimestamp)) {
                subscription.unsubscribe();
            }
        });
    }

    toEpoch(timestamp) {
        //timer is always set by this.expirationTimestamp - this.currentTimestamp
        //updates front when time has changed
        timestamp /= 1000;
        this.seconds = Math.floor(timestamp % 60);
        timestamp /= 60;
        this.minutes = Math.floor(timestamp % 60);
        timestamp /= 60;
        this.hours = Math.floor(timestamp % 24);
        this.days = Math.floor(timestamp / 24);
    }

    checkIfFinished(remaining: number) {
        if (remaining <= 0) {
            this.timerEvent.emit();
            return true;
        }
        return false;
    }

    private getTime() {
        let url = this.timeGate + this.queryParameter;
        this.http.get(url).subscribe(
            response => {
                if (response.status == 200 && !isNaN(parseInt(response.text()))) {
                    this.initialTime = +response.text();
                    /** We keep the instant when the time from the server is retrieved
                     * because performance.now() returns the number of ms since the beginning
                     * of the document lifetime, so it let us to substract the difference
                     * from when the date was retrieved and the initialization of the angular app.
                     */
                    this.initialPerformanceTime = performance.now();
                } else {
                    this.handleTimeError();
                }
            }, error => {
                this.handleTimeError();
            });
        // temporary endpoint
        /*this.callApi.getTime().subscribe(
            (date: any) => {
                this.currentTimestamp = date;
            }
        );*/
    }

    private handleTimeError() {
        this.sharedService.growlTranslation(
            "An error occurred while trying to retrieve the data from the server. Please, try again later.",
            "shared.error.api.generic",
            "error"
        )
    }

    public validCountDown(value) {
        return !Number.isNaN(value) && typeof value === "number";
    }
}