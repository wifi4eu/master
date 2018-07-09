import { Component, ViewChild } from "@angular/core";
import { SelectItem } from "primeng/primeng";
import { SharedService } from "../../../shared/shared.service";
import { NutsApi } from "../../../shared/swagger/api/NutsApi";
import { SupplierApi } from "../../../shared/swagger/api/SupplierApi";
import { NutsDTOBase } from "../../../shared/swagger/model/NutsDTO";
import { SuppliedRegionDTOBase } from "../../../shared/swagger/model/SuppliedRegionDTO";
import { SupplierDTOBase } from "../../../shared/swagger/model/SupplierDTO";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";

@Component({
    selector: 'supplier-edit-profile',
    templateUrl: 'edit-profile.component.html',
    styleUrls: ['edit-profile.component.scss'],
    providers: [SupplierApi, NutsApi]
})

export class SupplierEditProfileComponent {
    private user: UserDTOBase;
    private supplier: SupplierDTOBase;
    private websitePattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)?))?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,256}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    private countryOptions: SelectItem[] = [];
    private regionOptions: SelectItem[][] = [];
    private selectedCountries: NutsDTOBase[] = [];
    private selectedRegions: NutsDTOBase[][] = [];
    private allDataFetched: boolean = false;
    private geographicalScopeLoaded: boolean = false;
    private savingData: boolean = false;
    private logoUrl: FileReader = new FileReader();
    private logoFile: File;
    @ViewChild('logoInput') private logoInput: any;

    constructor(private sharedService: SharedService, private supplierApi: SupplierApi, private nutsApi: NutsApi) {
        let allow = true;
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.getSupplierData();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.getSupplierData();
            });
        }
    }

    private getSupplierData() {
        this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
            (supplier: SupplierDTOBase) => {
                if (supplier != null) {
                    this.supplier = supplier;
                    this.nutsApi.getNutsByLevel(0).subscribe(
                        (countries: NutsDTOBase[]) => {
                            for (let i = 0; i < countries.length; i++) {
                                let country = countries[i];
                                let countryName = country.label.substring(0, 1).toUpperCase() + country.label.substring(1, country.label.length).toLowerCase();
                                let countryOption = {
                                    label: countryName,
                                    value: country
                                };
                                this.countryOptions.push(countryOption);
                                this.regionOptions[country.label] = [];
                                this.nutsApi.getNutsByCountryCodeAndLevelOrderByLabelAsc(country.countryCode, 3).subscribe(
                                    (regions: NutsDTOBase[]) => {
                                        for (let j = 0; j < regions.length; j++) {
                                            let region = regions[j];
                                            let regionName = region.label;
                                            let regionOption = {
                                                label: regionName,
                                                value: region
                                            }
                                            this.regionOptions[country.label].push(regionOption);
                                            let countrySuppliedRegions = this.supplier.suppliedRegions.filter(suppliedRegion => suppliedRegion.regionId.id == region.id);
                                            if (countrySuppliedRegions.length > 0) {
                                                if (!this.selectedRegions[country.label]) {
                                                    this.selectedRegions[country.label] = [];
                                                    this.selectedCountries.push(country);
                                                }
                                                this.selectedRegions[country.label].push(region);
                                            }
                                            if (i == (countries.length - 1) && j == (regions.length - 1)) {
                                                this.geographicalScopeLoaded = true;
                                            }
                                        }
                                    }
                                );
                            }
                        }
                    );
                }
            }
        );
    }

    private changeLogo(event) {
        console.log(event);
    }

    private saveSupplierData() {
        this.supplier.suppliedRegions = [];
        for (let selectedCountry in this.selectedRegions) {
            for (let selectedRegion of this.selectedRegions[selectedCountry]) {
                let suppliedRegion = new SuppliedRegionDTOBase();
                suppliedRegion.regionId = selectedRegion;
                suppliedRegion.supplierId = this.supplier.id;
                this.supplier.suppliedRegions.push(suppliedRegion);
            }
        }
        this.supplierApi.updateSupplier(this.supplier).subscribe(
            (supplier: SupplierDTOBase) => {
                console.log('supplier', supplier);
                console.log('this.supplier', this.supplier);
            }
        );
    }
}