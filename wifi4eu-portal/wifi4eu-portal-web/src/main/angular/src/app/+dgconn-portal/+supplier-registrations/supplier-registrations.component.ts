import { Component } from "@angular/core";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { OnInit } from "@angular/core";

import 'rxjs/add/operator/map';

import { UserDTOBase } from "../../shared/swagger/model/models";

@Component({
  templateUrl: 'supplier-registrations.component.html', providers: [UserApi, SupplierApi]
})

export class DgConnSupplierRegistrationsComponent implements OnInit {

  private users: any[];

  private customUserSupplierArray: any[] = [];
  private userSupplierArray: any[] = [];

  inputSearch = "";

  constructor(
    private userApi: UserApi,
    private supplierApi: SupplierApi
  ) {
    this.userApi.getUsersByType(1).subscribe(
      users => {
        users.map((user: UserDTOBase) => {
          let customUserSupply = {
            'user': user,
            'supplier': {}
          }
          this.supplierApi.getSupplierByUserId(user.id).subscribe(
            supplier => {
              customUserSupply.supplier = supplier;
              this.customUserSupplierArray.push(customUserSupply);
              
            },
            error => {
              console.log(error);
            }
          );
        });

      },
      error => {
        console.log(error);
      }
    );
    this.userSupplierArray = this.customUserSupplierArray;
  }

  ngOnInit() {

  }

  filterData(stringSearch: string) {
    if(stringSearch.length > 0){
      let customUserSupplierArray2 = this.customUserSupplierArray.map(each => {
        if(each.supplier.name == stringSearch){
          return each;
        }
      }).filter(element => {return element !== undefined});
      this.customUserSupplierArray = [...customUserSupplierArray2]
    }
    else{
      this.customUserSupplierArray = [...this.userSupplierArray];
    }
    
  }

}