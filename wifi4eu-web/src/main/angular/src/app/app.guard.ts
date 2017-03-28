import {Injectable} from '@angular/core';
import {Router, CanActivate} from '@angular/router';
//import { UserService } from './user.service';

@Injectable()
export class AppGuard implements CanActivate {
    constructor() {
    }

    canActivate() {
        //return this.user.isLoggedIn();
        return true;
    }
}