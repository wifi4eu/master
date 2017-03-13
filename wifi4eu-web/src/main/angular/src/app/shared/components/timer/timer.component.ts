import {Component, EventEmitter, Output} from '@angular/core';
//import {TimerService} from "./timer.service";
import {Observable} from 'rxjs/Rx';
import {CallDTO, CallDTOBase} from '../../../shared/swagger/model/CallDTO';
import {CallApi} from '../../../shared/swagger/api/CallApi';

@Component({selector: 'timer-component', templateUrl: 'timer.component.html', providers: [CallApi]})
export class TimerComponent {
    @Output() timerEvent = new EventEmitter<any>();
    private currentTimestamp: number;
    private expirationTimestamp: number;
    private days: number;
    private hours: number;
    private minutes: number;
    private seconds: number;

    constructor(private callApi: CallApi) {
        this.currentTimestamp = new Date().getTime();
        callApi.allCalls().subscribe(
            (publications: CallDTOBase[]) => {
                this.expirationTimestamp = Number(publications[0].startDate);
                Observable.interval(500).map((x) => {
                    this.currentTimestamp = new Date().getTime();
                }).subscribe((x) => {
                    this.toEpoch(this.expirationTimestamp - this.currentTimestamp);
                    this.checkIfFinished(this.expirationTimestamp - this.currentTimestamp);
                });
            },
            error => console.log(error)
        );
    }

    toEpoch(timestamp: number) {
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
        }
    }
}