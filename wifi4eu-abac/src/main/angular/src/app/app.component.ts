import {Component} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private importUrl: string;
  private exportUrl: string;
  private exportEnabled: boolean;
  private jsonFile: File;


  constructor(private http: Http) {
    this.importUrl = 'api/importJson';
    this.exportUrl = 'api/exportJson';
    this.exportEnabled = true;
  }

  exportJson() {
    this.http.get(this.exportUrl).subscribe(
      response => {
        let abacResponse = JSON.parse(response['_body']);
        if (abacResponse['success'] & abacResponse!['success']) {

          let blob = new Blob([abacResponse['data']], {type: 'application/json'});
          FileSaver.saveAs(blob, 'export.json');
        }
        window.alert(JSON.stringify(abacResponse));
      }, error => {
        console.log(error);
        window.alert('Something went wrong');
      }
    );

  }

  onFileSelection(event) {
    this.exportEnabled = false;
    if (event && event.target && event.target.files && event.target.files.length == 1) {
      this.jsonFile = event.target.files['0'];
      let reader = new FileReader();

      reader.onload = (e) => {
        this.http.post(this.importUrl, reader.result).subscribe(
          response => {
            // let abacResponse = JSON.parse(response['_body']);
            // if (abacResponse['success']) {
            this.exportEnabled = true;
            console.log("OK!");
            console.log("Response: ", response);
            console.log(typeof response);
            // }
            // window.alert(abacResponse['message']);
          }, error => {
            console.log(error);
            window.alert('Something went wrong');
            console.log("Crash 2");
          }
        );
      };
      reader.readAsText(this.jsonFile);
    }
  }
}



