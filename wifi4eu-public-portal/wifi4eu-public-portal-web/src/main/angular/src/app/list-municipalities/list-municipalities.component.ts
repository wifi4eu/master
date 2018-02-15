import { Component, OnInit } from '@angular/core';
import { NutsApi, NutsDTOBase, MunicipalityDTOBase, MunicipalityApi, ResponseDTO } from 'app/shared/swagger';
import { ViewEncapsulation } from '@angular/core';
import { MunicipalityCacheDTO, MunicipalityCacheDTOBase } from 'app/shared/swagger/model/MunicipalityCacheDTO';
import { DatePipe } from '@angular/common';

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
  country: NutsDTOBase;
  region: NutsDTOBase;
  municipalities: MunicipalityDTOBase[] = [];
  dateCached: string = null;

  constructor(private nutsApi: NutsApi, private municipalityApi: MunicipalityApi) {
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
    this.nutsApi.getNutsByCountryCodeAndLevelOrderByLabelAsc(country.code, 3).subscribe(
      (regions: NutsDTOBase[]) => {
        this.regions = regions;
      }
    );
  }

  selectRegion(region){
    this.region = region;
  }

  searchMunicipalities(){
    if(this.country && this.region){
      this.municipalityApi.getMunicipalitiesRegistered(this.region.code).subscribe(
        (municipalityCacheDTO: MunicipalityCacheDTOBase) => {
          this.municipalities = municipalityCacheDTO.municipalityDTOList;
          let date = new Date(municipalityCacheDTO.dateCached);
          let datePipe = new DatePipe('default').transform(date, 'dd/MM/yyyy');
          this.dateCached = datePipe;
        }
      );
    }
  }

}
