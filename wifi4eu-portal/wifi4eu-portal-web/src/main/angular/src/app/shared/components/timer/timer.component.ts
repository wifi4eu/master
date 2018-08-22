import { Component, EventEmitter, Output, Input } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { Http } from '@angular/http';
import { SharedService } from '../../shared.service';
import { CallApi } from "../../swagger/api/CallApi";

@Component({ selector: 'timer-component', templateUrl: 'timer.component.html' , styleUrls: ['timer.component.scss'], providers: [CallApi]})
export class TimerComponent {
    @Output() timerEvent = new EventEmitter<any>();
    private currentTimestamp: number;
    @Input('expirationTimestamp') expirationTimestamp: number;
    private days: number;
    private hours: number;
    private minutes: number;
    private seconds: number;
    @Input('baseURLApi') baseURLApi : string;
    private timeGate: string = "/time";
    private urlTime: string = "https://wifi4eu-dev-queue.everincloud.com";

    constructor(private http: Http, private sharedService: SharedService, private callApi: CallApi) {
    }

    ngOnInit() {
        //we get the time from server ONCE
        this.getTime();

        //every second we change the timer
        let subscription = Observable.interval(1000).map((x) => { }).subscribe((x) => {
            this.currentTimestamp += 1000;
            this.toEpoch(this.expirationTimestamp - this.currentTimestamp);
            if (this.checkIfFinished(this.expirationTimestamp - this.currentTimestamp)) {
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
        // let url = this.baseURLApi + this.timeGate;
        let url = this.urlTime + this.timeGate;
        this.http.get(url).subscribe(
            response => {
                if (response.status == 200 && !isNaN(parseInt(response.text()))) {
                    this.currentTimestamp = +response.text();
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
}