import { Component } from '@angular/core';
import { Router } from "@angular/router";

@Component({selector: 'not-found-component', templateUrl: 'not-found.component.html'})
export class NotFoundComponent {

    constructor(private router: Router){
    }

    goToHome(){
        this.router.navigateByUrl('/home');
    }
}