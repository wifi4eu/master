import { Component, OnInit } from '@angular/core';
import { NutsApi, NutsDTOBase, MunicipalityApi } from 'app/shared/swagger';
import { ViewEncapsulation } from '@angular/core';
import { MunicipalityCacheDTOBase } from 'app/shared/swagger/model/MunicipalityCacheDTO';
import { TranslateService } from 'ng2-translate';
import { SharedService } from 'app/shared/shared.service';

@Component({
  selector: 'app-list-municipalities',
  templateUrl: './list-municipalities.component.html',
  styleUrls: ['./list-municipalities.component.scss'],
  providers: [NutsApi, MunicipalityApi],
  encapsulation: ViewEncapsulation.None
})
export class ListMunicipalitiesComponent implements OnInit {

  countries: NutsDTOBase[] = [];
  regions: NutsDTOBase[] = [];
  country: NutsDTOBase = null;
  region: NutsDTOBase = null;
  municipalities: string[] = [];
  dateCached: string = null;
  searched: boolean = false;
  regionNameSearched: string = null;
  defaultRegion = new NutsDTOBase();
  
  constructor(private nutsApi: NutsApi, private municipalityApi: MunicipalityApi, private translateService: TranslateService, private sharedService: SharedService) {
    this.defaultRegion.code = "ALL";
    this.defaultRegion.label = "All";
    this.defaultRegion.id = 0;
    this.defaultRegion.countryCode = "ALL";
    this.regions.push(this.defaultRegion);    
    this.nutsApi.getNutsByLevel(0).subscribe(
      (countries: NutsDTOBase[]) => {
        this.countries = countries;
      }, error => {
        console.log(error);
      }
    );
    this.translateDefaultRegionLabel();
    this.sharedService.languageEmitter.subscribe(() => this.translateDefaultRegionLabel());
  }

  translateDefaultRegionLabel() {
    this.translateService.get("shared.all").subscribe(
        (translation: string) => {
            if (translation) {
                this.defaultRegion.label = translation;
            }
        }
    );
  }

  ngOnInit() {
  }

  selectCountry(country){
    this.region = this.defaultRegion;
    this.nutsApi.getNutsByCountryCodeAndLevelOrderByLabelAsc(country.code, 3).subscribe(
      (regions: NutsDTOBase[]) => {
        this.regions = [this.defaultRegion, ...regions];
      }
    );
  }

  selectRegion(region){
    this.region = region;
  }

  searchMunicipalities(){
    if(this.country && this.region){
      if(this.region.id != 0){
        this.municipalityApi.getMunicipalitiesRegistered(this.region.code).subscribe(
          (municipalityCacheDTO: MunicipalityCacheDTOBase) => {
            this.municipalities = municipalityCacheDTO.municipalities;
            this.dateCached = municipalityCacheDTO.dateCached.toString();
            this.searched = true;
            this.regionNameSearched = this.region.label;
          }
        );
      }
      else {
        this.municipalityApi.getMunicipalitiesRegisteredByCountry(this.country.countryCode).subscribe(
          (municipalityCacheDTO: MunicipalityCacheDTOBase) => {
            this.municipalities = municipalityCacheDTO.municipalities;
            this.dateCached = municipalityCacheDTO.dateCached.toString();
            this.searched = true;
            this.regionNameSearched = this.country.label;
          });
      }
    }
  }

}
