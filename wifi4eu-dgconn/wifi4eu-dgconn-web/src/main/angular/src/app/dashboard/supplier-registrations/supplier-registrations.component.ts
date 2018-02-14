import { Component } from "@angular/core";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { OnInit } from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
// import 'rxjs/add/operator/map';

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
              this.userSupplierArray.push(customUserSupply);
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
  }

  ngOnInit() {

  }

  filterData(stringSearch: string) {
    this.customUserSupplierArray = [...this.userSupplierArray];
    if(typeof stringSearch != "undefined" && stringSearch != ""){
      stringSearch = stringSearch.toLocaleLowerCase();
      let suppliers =  this.customUserSupplierArray.map(
        (supplierDTO) => {
          supplierDTO.supplier.name = supplierDTO.supplier.name || "";
          supplierDTO.supplier.address = supplierDTO.supplier.address || "";
          return supplierDTO;
        }
      ).filter(supplierF => { 
        return (supplierF.supplier.name.toLocaleLowerCase().match(stringSearch) || 
        supplierF.supplier.address.toLocaleLowerCase().match(stringSearch))
      });
      this.customUserSupplierArray = [...suppliers]
    }

  }

}