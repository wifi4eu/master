import {Component, EventEmitter, Output, Input} from '@angular/core';
import {Observable} from 'rxjs/Rx';

@Component({selector: 'timer-component', templateUrl: 'timer.component.html'})
export class TimerComponent {
    @Output() timerEvent = new EventEmitter<any>();
    private currentTimestamp: number;
    @Input('expirationTimestamp') expirationTimestamp: number;
    private days: number;
    private hours: number;
    private minutes: number;
    private seconds: number;

    ngOnInit() {
        this.currentTimestamp = new Date().getTime();
        let subscription = Observable.interval(500).map((x) => {
        }).subscribe((x) => {
            this.currentTimestamp = new Date().getTime();
            this.toEpoch(this.expirationTimestamp - this.currentTimestamp);
            if (this.checkIfFinished(this.expirationTimestamp - this.currentTimestamp)) {
                subscription.unsubscribe();
            }
        });
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
            return true;
        }
        return false;
    }
}