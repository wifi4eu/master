import {Injectable} from '@angular/core';
import {Subject} from "rxjs";

@Injectable()
export class SharedService {

    private emitChangeSource = new Subject<any>();

    changeEmitted = this.emitChangeSource.asObservable();
    logoutEmitted = this.emitChangeSource.asObservable();

    constructor() {
    }

    emitChange() {
        this.emitChangeSource.next();
    }

    login() {
    }

    logout() {
        this.emitChangeSource.next();
    }
}