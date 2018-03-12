import { Directive } from "@angular/core";

@Directive({ 
    selector: '[customUxTrackScroll]', 
    host: {'(window:scroll)': 'track($event)'} 
}) 

export class CustomUxTrackScrollDirective { 
    
    track($event: Event) {
        let scrollTop = Math.max(window.pageYOffset, document.body.scrollTop);
        let app = document.getElementById("app-wrapper");
        var navbar = document.getElementById("nav-bar");
        var appHeader = document.getElementById("app-header");

        if(scrollTop > navbar.clientHeight + appHeader.clientHeight){
          app.classList.add("shrink-header-active");
        }
        else{
          app.classList.remove("shrink-header-active");
        }
    } 
}
