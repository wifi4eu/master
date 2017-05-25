import {Component} from "@angular/core";
import {DgconnApi} from "../../shared/swagger/api/DgconnApi";
import {ResponseDTO} from "../../shared/swagger/model/ResponseDTO";

declare var esri : any;
export var countryInformation : any;

@Component({
    selector: 'map-component',
    templateUrl: 'map.component.html',
    providers: [DgconnApi]
})
export class MapComponent {
    private map : any;
    private externalCountriesData : any;
    private tableData;

    constructor(private dgconnApi: DgconnApi) {
        //console.log("Constructor");
        //console.log(Object.keys(esri));
        this.loadMapInformation();
        this.tableData = [];
    }

    loadMapInformation() {
      this.dgconnApi.getCountriesVoucherInfo().subscribe(
        (data: ResponseDTO) => {
          countryInformation = JSON.parse(data.data);
          for (var property in countryInformation) {
            this.tableData.push(countryInformation[property]);
          }
          this.loadMap();
        }
      );
  }


  loadMap() {
    window.onload = function () {
      //Bounds and map definition
      //console.log(Object.keys(esri));
      var bounds = new esri.geometry.Extent({"xmin":-6767978.981609231,"ymin":2591986.6022099443,"xmax":8559731.130780501,"ymax":11154688.85635359,"spatialReference":{"wkid":102100}});
      var map = new esri.Map("map", {extent: bounds, logo: false});

      var zoomTo = function(level){
        var zoomLevels = {
          0 : 11205991,
          1 : 10507430,
          2 : 5253710,
          3 : 2626850,
          4 : 656710
        }
        this.map.setScale(zoomLevels[level]);
      };

      var templateCustomContent = function(value) {
        var outputString = "Municipalites: %m <br /> Requests: %r <br /> Awarded: %a";
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
        outFields: ["NAME_LATN","NUTS_ID"],
        maxScale: 10507436
      });
          
      map.addLayers([flCountries]);
     }
  }
}