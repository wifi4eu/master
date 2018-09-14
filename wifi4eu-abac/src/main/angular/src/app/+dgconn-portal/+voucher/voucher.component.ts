import {Component, Input, EventEmitter, OnInit, Output} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {Http} from "@angular/http";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {TranslateService} from "ng2-translate/ng2-translate";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {DgconnApi} from "../../shared/swagger/api/DgconnApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {ResponseDTO} from "../../shared/swagger/model/ResponseDTO";
import {Observable} from 'rxjs/Rx';

declare var esri: any;
export var countryInformation: any;

@Component({
    templateUrl: 'voucher.component.html',
    providers: [LauApi, NutsApi, DgconnApi]
})

export class DgConnVoucherComponent {

    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTOBase;
    @Input('nutsDTO') nutsDTO: NutsDTOBase;
    @Input('lausDTO') lausDTO: NutsDTOBase;

    @Output() onNext = new EventEmitter<number>();

    private nutsSuggestions: NutsDTOBase[];
    private lausSuggestions: LauDTOBase[];

    private map: any;
    private externalCountriesData: any;
    private mapTableData;

    private totalCountries: number;
    private totalRequests: number;

    constructor(private http: Http, private lauApi: LauApi, private nutsApi: NutsApi, private dgconnApi: DgconnApi, private uxService: UxService, private translate: TranslateService) {
        this.mapTableData = [];
        this.totalCountries = 0;
        this.totalRequests = 0;
        this.loadMapInformation();
    }

    loadMapInformation() {
        this.loadMap();
        this.dgconnApi.getCountriesVoucherInfo().subscribe(
            (data: ResponseDTO) => {
                countryInformation = JSON.parse(data.data);
                for (var property in countryInformation) {
                    this.mapTableData.push(countryInformation[property]);
                    this.totalRequests += countryInformation[property]["requests"];
                }
                this.totalCountries = this.mapTableData.length;
                this.loadMap();
                this.totalCountries = this.mapTableData.length;
            }
        );
    }

    loadMap() {
        window.onload = function () {
            var bounds = new esri.geometry.Extent({
                "xmin": -6767978.981609231,
                "ymin": 2591986.6022099443,
                "xmax": 8559731.130780501,
                "ymax": 11154688.85635359,
                "spatialReference": {"wkid": 102100}
            });
            var map = new esri.Map("map", {extent: bounds, logo: false});

            var zoomTo = function (level) {
                var zoomLevels = {
                    0: 11205991,
                    1: 10507430,
                    2: 5253710,
                    3: 2626850,
                    4: 656710
                }
                this.map.setScale(zoomLevels[level]);
            };

            var templateCustomContent = function (value) {
                let outputString = "Municipalities: %m <br /> Requests: %r <br /> Assigned Vouchers: %a";
                if (value && value.attributes && value.attributes.NUTS_ID && countryInformation[value.attributes.NUTS_ID]) {
                    outputString = outputString.replace("%m", countryInformation[value.attributes.NUTS_ID].municipalities);
                    outputString = outputString.replace("%r", countryInformation[value.attributes.NUTS_ID].requests);
                    outputString = outputString.replace("%a", countryInformation[value.attributes.NUTS_ID].awarded);
                } else {
                    outputString = "Data not available";
                }
                return outputString;
            };

            //Definition of layers to add to the map.
            var flCountries = new esri.layers.FeatureLayer("https://services2.arcgis.com/aptrPtSBUDThgWRD/ArcGIS/rest/services/WIFI4EU/FeatureServer/4", {
                id: "europe-countries",
                infoTemplate: new esri.InfoTemplate("${NAME_LATN}", templateCustomContent),
                outFields: ["NAME_LATN", "NUTS_ID"],
                maxScale: 10507436
            });
            map.addLayers([flCountries]);
        }
    }

    onKeyUp(event) {
        // Check if key pressed is a ascii printable letter
        if (event.keyCode > 64 && event.keyCode < 91) {
            if (typeof this.nutsDTO === "string") {
                //let name: string = this.nutsDTO;
                let nuts = this.nutsSuggestions;
                for (let i = 0; i < nuts.length; i++) {
                    let nut = nuts[i];
                    //if (nut.name.toLowerCase().indexOf(name.toLowerCase()) == 0) {
                        //this.nutsDTO = nut;
                    //}
                }
            }
        }
    }

    filterNuts(event) {
        this.nutsApi.findNutsByLevel(0).subscribe(
            nuts => {
                this.nutsSuggestions = this.filterCountries(event.query, nuts)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get nuts, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get nuts', error);
            }
        );
    }

    filterCountries(query, nuts: NutsDTOBase[]) {
        let filteredNuts: NutsDTOBase[] = [];
        for (let i = 0; i < nuts.length; i++) {
            let nut = nuts[i];
            //nut.name = nut.name.toLowerCase();
            //if (nut.name.indexOf(query.toLowerCase()) == 0) {
                //nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                filteredNuts.push(nut);
            //}
        }
        return filteredNuts;
    }

    simulateDistribution() {
        this.dgconnApi.distribute().subscribe(
            response => {
                this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'Simulation of voucher distribution successful'
                });
            }, error => console.log(error)
        );
    }
}