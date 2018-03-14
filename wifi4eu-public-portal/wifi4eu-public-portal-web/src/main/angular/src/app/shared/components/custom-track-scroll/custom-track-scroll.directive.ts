import { Directive, AfterViewInit } from "@angular/core";

@Directive({ 
    selector: '[customUxTrackScroll]', 
    host: {'(window:scroll)': 'track($event)'} 
}) 

export class CustomUxTrackScrollDirective implements AfterViewInit { 

    heightAppHeader: number;

    ngAfterViewInit() {
      var appHeader = document.getElementById("app-header");
      this.heightAppHeader = appHeader.clientHeight;
    }

    track($event: Event) {
        let scrollTop = Math.max(window.pageYOffset, document.body.scrollTop);
        let app = document.getElementById("app-wrapper");
        if(scrollTop > this.heightAppHeader){
          app.classList.add("shrink-header-active");
        }
        else{
          app.classList.remove("shrink-header-active");
        }
    } 
}
