import { NgModule, Injectable } from '@angular/core';
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { UxAllModule } from '@eui/ux-commons';
import { Observable } from 'rxjs/Observable';
import { deserialize, classToPlain } from 'class-transformer';
import { ResponseDTO } from './model/ResponseDTO';
import { ClassType } from './model/ClassType';
import { MonitoringRowDTO } from './model/MonitoringRowDTO';

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
@Injectable()
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
  
    getMonitoringData(): Observable<MonitoringRowDTO[]> {
        let path = this.basePath + 'monitor/data';      
        return this.httpClient.get<MonitoringRowDTO[]>(path);
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
