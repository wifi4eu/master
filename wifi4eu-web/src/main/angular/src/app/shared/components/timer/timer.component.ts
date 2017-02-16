import {Component, EventEmitter, Output} from '@angular/core';
import {TimerService} from "./timer.service";
import {Observable} from 'rxjs/Rx';
//import enumerate = Reflect.enumerate;

@Component({selector: 'timer-component', templateUrl: 'timer.component.html', providers: [TimerService]})
export class TimerComponent {
    @Output() timerEnd = new EventEmitter<any>();
    //private currentDate: Date;
    //private expirationDate: Date;
    private currentTimestamp: number;
    private expirationTimestamp: number;
    private days: number;
    private hours: number;
    private minutes: number;
    private seconds: number;

    /*
     constructor(private timerService: TimerService) {
     this.currentTimestamp = new Date().getTime();
     Observable.interval(1000).map((x) => {
     this.timerService.getExpirationDateTime2().subscribe(expirationTimestamp => {
     this.expirationTimestamp = expirationTimestamp;
     });
     }).subscribe((x) => {
     console.log("expirationTimestamp", this.expirationTimestamp);
     console.log("currentTimestamp", this.currentTimestamp);
     this.toEpoch(this.expirationTimestamp - this.currentTimestamp);
     this.checkIfFinished(this.expirationTimestamp - this.currentTimestamp);
     });
     }
     */

    constructor(private timerService: TimerService) {
        this.currentTimestamp = new Date().getTime();
        this.expirationTimestamp = (timerService.getExpirationDateTime());
        Observable.interval(500).map((x) => {
            this.currentTimestamp = new Date().getTime();
        }).subscribe((x) => {
            this.toEpoch(this.expirationTimestamp - this.currentTimestamp);
            this.checkIfFinished(this.expirationTimestamp - this.currentTimestamp);
        });
    }

    toEpoch(ms: number) {
        ms = ms / 1000;
        this.seconds = Math.floor(ms % 60);
        ms = ms / 60;
        this.minutes = Math.floor(ms % 60);
        ms = ms / 60;
        this.hours = Math.floor(ms % 24);
        this.days = Math.floor(ms / 24);
    }

    checkIfFinished(remaining: number) {
        if (remaining <= 0) {
            this.timerEnd.emit();
        }
    }
}