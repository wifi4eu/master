import { Directive, Component, OnInit, ViewEncapsulation, ViewChild, ElementRef  } from '@angular/core';
import { NutsDTOBase, NutsApi, SupplierApi, ResponseDTO } from '../shared/swagger';
import { DatePipe } from '@angular/common';
import { trigger, transition, style, animate, query, stagger, group, state } from '@angular/animations';
import { DataGrid, Paginator } from 'primeng/primeng';

@Component({
  selector: 'app-list-suppliers',
  templateUrl: './list-suppliers.component.html',
  styleUrls: ['./list-suppliers.component.scss'],
  providers: [NutsApi, SupplierApi],
  encapsulation: ViewEncapsulation.None,
  animations: [
    trigger('opacityTransition', [
      state('*', style({opacity: 1})),
      state('void', style({opacity: 0})),
      transition('* => void', [
        style({opacity: 1}),
        animate('0.2s linear', style({opacity: 0}))
      ]),
      transition('void => *', [
        style({opacity: 0}),
        animate('0.2s linear', style({opacity: 1}))
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

  itemsPerPageSelector = [10, 20, 50, 100];
  totalItems: any = 0;
  page: any = 0;
  itemsPerPage: any = this.itemsPerPageSelector[1];
  pageLinks: any;
  searching: boolean = false;  

  hidePaginator: boolean = true;

  @ViewChild("gridSuppliers") gridSuppliers: DataGrid;
  @ViewChild("paginator") paginator: Paginator;

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
      }
    );
  }

  selectCountry(country){
    this.searched = false;
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
    this.searching = true;
    this.loadPage();
  }

  loadPage() {
    if(this.country && this.region){
      if(this.region.id != 0){
        this.supplierApi.getSuppliersRegisteredByRegion(this.region.id, this.page, this.itemsPerPage).subscribe((response: ResponseDTO) => {
          console.log("Region id is: " + this.region.id);
          this.suppliers = response.data['suppliers'];
          this.dateCached = this.transformDate(response.data['dateCached']);
          this.regionNameSearched = this.region.label;
          this.fillPaginator(response);
        }); 
      }else{
        this.supplierApi.getSuppliersRegisteredByCountry(this.country.countryCode, this.page, this.itemsPerPage).subscribe((response: ResponseDTO) => {

          console.log("Country code is: " + this.country.countryCode);
          console.log("Region id is: " + this.region.id);
          console.log("This page is " + this.page);
          console.log("This itemsPerPage is " + this.itemsPerPage);
          console.log(response.data);
          this.suppliers = response.data['suppliers'];
          this.dateCached = this.transformDate(response.data['dateCached']);
          this.regionNameSearched = this.country.label;        
          this.fillPaginator(response);
        }); 
      }
    }
  }

  private transformDate(dateArg: Date): string{
    let datePipe = new DatePipe('default').transform(dateArg, 'dd/MM/yyyy');
    return datePipe;
  }

  fillPaginator(response) {
    this.totalItems = response.xtotalCount;
    this.pageLinks = Math.ceil(this.totalItems / this.itemsPerPage);
    this.paginator.rows = this.itemsPerPage;
    this.paginator.pageLinkSize = this.pageLinks;
    this.paginator.totalRecords = this.totalItems;
    this.searching = false;
    this.searched = true;
  }

  paginate(event) {
    this.itemsPerPage = event.rows;
    this.page = event.page;
    this.loadPage();
  }

}
