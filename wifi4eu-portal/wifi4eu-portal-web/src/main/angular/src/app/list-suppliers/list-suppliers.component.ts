import { Component, OnInit, ViewEncapsulation, ViewChild } from '@angular/core';
import { NutsDTOBase, NutsApi, SupplierApi, ResponseDTO } from '../shared/swagger';
import { SuppliersCacheDTO, SuppliersCacheDTOBase } from '../shared/swagger/model/SuppliersCacheDTO';
import { DatePipe } from '@angular/common';
import { trigger, transition, style, animate, query, stagger, group, state } from '@angular/animations';
import { DataGrid } from 'primeng/primeng';

@Component({
  selector: 'app-list-suppliers',
  templateUrl: './list-suppliers.component.html',
  styleUrls: ['./list-suppliers.component.scss'],
  providers: [NutsApi, SupplierApi],
  encapsulation: ViewEncapsulation.None,
  animations: [
    trigger('expandCollapse', [
      state('*', style({opacity: 1 , 'overflow-y': 'hidden'})),
      state('void', style({'overflow-y': 'hidden', opacity: 0})),
      transition('* => void', [
        style({height: '*', opacity: 1}),
        animate('0.4s cubic-bezier(.8, -0.6, 0.2, 1.5)', style({height: 0}))
      ]),
      transition('void => *', [
        style({height: 0, opacity: 0}),
        animate('0.4s cubic-bezier(.8, -0.6, 0.2, 1.5)', style({height: '*'})),
        animate('0.6s ease-in', style({opacity: 1}))
      ])
    ])
  ]
})
export class ListSuppliersComponent implements OnInit {

  countries: NutsDTOBase[] = [];
  regions: NutsDTOBase[] = [];
  country: NutsDTOBase = null;
  region: NutsDTOBase = null;
  suppliers: string[] = [];
  dateCached: string = null;
  searched: boolean = false;
  regionNameSearched: string = null;
  defaultRegion = new NutsDTOBase();
  originalSuppliers: string[] = [];

  @ViewChild("gridSuppliers") gridSuppliers: DataGrid;

  constructor(private nutsApi: NutsApi, private supplierApi: SupplierApi) {}

  ngOnInit() {
    this.nutsApi.getNutsByLevel(0).subscribe(
      (countries: NutsDTOBase[]) => {
        this.countries = countries;
        if(countries.length > 0){
          this.defaultRegion.code = "ALL";
          this.defaultRegion.label = "All";
          this.defaultRegion.id = 0;
          this.defaultRegion.countryCode = "ALL";
          this.regions.push(this.defaultRegion);
        }
      }, error => {
        console.log(error);
      }
    );
  }

  selectCountry(country){
    /* this.region = this.defaultRegion; */
    this.nutsApi.getNutsByCountryCodeAndLevelOrderByLabelAsc(country.code, 3).subscribe(
      (regions: NutsDTOBase[]) => {
        this.regions = [this.defaultRegion, ...regions];
      }
    );
  }

  selectRegion(region){
    this.region = region;
  }

  searchSuppliers(){
    this.searched = false;
    if(this.country && this.region){
      if(this.region.id != 0){
        this.supplierApi.getSuppliersRegisteredByRegion(this.region.id).subscribe((response: SuppliersCacheDTO) => {
          this.suppliers = response.suppliers;
          this.dateCached = this.transformDate(response.dateCached);
          this.originalSuppliers = this.suppliers;
          this.searched = true;
          this.regionNameSearched = this.region.label;
        });
        return;
      }
      this.supplierApi.getSuppliersRegisteredByCountry(this.country.countryCode).subscribe((response: SuppliersCacheDTO) => {
        this.suppliers = response.suppliers;
        this.dateCached = this.transformDate(response.dateCached);
        this.originalSuppliers = this.suppliers;
        this.searched = true;
        this.regionNameSearched = this.country.label;
      });
    } 
  }

  private transformDate(dateArg: Date): string{
    let datePipe = new DatePipe('default').transform(dateArg, 'dd/MM/yyyy');
    return datePipe;
  }

  private filterResults(event) {
    var results = this.originalSuppliers.filter((supplier) => { return supplier.toLowerCase().match(event.target.value.toLowerCase()) ? supplier : null; })
    this.suppliers = [...results];
  }

}
