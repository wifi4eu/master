import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { UxAllModule } from '@eui/ux-commons';
import { ResponseDTO } from './model/ResponseDTO';
import { ClassType } from './model/classType';
import { Observable } from 'rxjs/Observable';
import { deserialize, classToPlain } from 'class-transformer';

@NgModule({
    imports: [
        UxAllModule,
        TranslateModule,
        HttpClientModule
    ],
    declarations: [
    ],
    exports: [
        UxAllModule,
        TranslateModule,
    ]
})
export class ApiModule {

    protected basePath = '/';

    constructor(protected httpClient: HttpClient){
        this.basePath = document.querySelector('html head base').getAttribute('href');
    }

    importLegalEntity(body?: string): Observable<ResponseDTO> {
        return this.importFile('legalEntity/import', body);
    }
  
    importBudgetaryCommitment(body?: string): Observable<ResponseDTO> {
      return this.importFile('budgetaryCommitment/import', body);
    }
  
    importLegalCommitment(body?: string): Observable<ResponseDTO> {
      return this.importFile('legalCommitment/import', body);
    }
  
    private importFile(endpoint?: string, body?: string): Observable<ResponseDTO> {
        let path = this.basePath + endpoint;
        let headers = new HttpHeaders();
        headers.set('Content-Type', 'text/plain');
        return this.httpClient.post<ResponseDTO>(path, body, {
            headers: headers
        });
    }
}
