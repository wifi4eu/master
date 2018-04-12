import { Component, OnInit } from '@angular/core';
import { NutsApi, NutsDTOBase, MunicipalityDTOBase, MunicipalityApi, ResponseDTO } from 'app/shared/swagger';
import { ViewEncapsulation } from '@angular/core';
import { MunicipalityCacheDTO, MunicipalityCacheDTOBase } from 'app/shared/swagger/model/MunicipalityCacheDTO';

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
  
  constructor(private nutsApi: NutsApi, private municipalityApi: MunicipalityApi) {
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
