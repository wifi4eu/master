import { NgModule, Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpRequest, HttpEvent } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { UxAllModule } from '@eui/ux-commons';
import { Observable } from 'rxjs/Observable';
import { deserialize, classToPlain } from 'class-transformer';
import { ResponseDTO } from './model/ResponseDTO';
import { ClassType } from './model/ClassType';
import { MonitoringRowDTO } from './model/MonitoringRowDTO';
import { CountryDTO } from './model/CountryDTO';

@NgModule({
    imports: [
        UxAllModule,
        TranslateModule
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

    importLegalEntity(file?: File): Observable<HttpEvent<any>> {
        return this.importFile('legalEntity/import', file);
    }

    importBudgetaryCommitment(file?: File): Observable<HttpEvent<any>> {
      return this.importFile('budgetaryCommitment/import', file);
    }

    importLegalCommitment(file?: File): Observable<HttpEvent<any>> {
      return this.importFile('legalCommitment/import', file);
    }
<<<<<<< HEAD

=======
  
    getCountries(): Observable<CountryDTO[]> {
        let path = this.basePath + 'monitor/countries';      
        return this.httpClient.get<CountryDTO[]>(path);
    }
  
>>>>>>> f8c472e1e02e5c98f830ee424fe7c81be06aeb2d
    getMonitoringData(): Observable<MonitoringRowDTO[]> {
        let path = this.basePath + 'monitor/data';
        return this.httpClient.get<MonitoringRowDTO[]>(path);
    }

    private importFile(endpoint?: string, file?: File): Observable<HttpEvent<any>> {
        let formData = new FormData();
        formData.append('file', file);
        let params = new HttpParams();
        const options = {
          params: params,
          reportProgress: true,
        };
        const req = new HttpRequest('POST', this.basePath + endpoint, formData, options);
        return this.httpClient.request(req);
    }
}
