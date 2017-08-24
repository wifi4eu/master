webpackJsonp(["supplier-portal.module"],{

/***/ "../../../../../src/app/+supplier-portal/installation/supplier-installation.component.html":
/***/ (function(module, exports) {

module.exports = "<timeline-component></timeline-component>\n<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"marginTop\">\n        <a class=\"edit\" routerLink=\"/supplier-portal\" routerLinkActive=\"active\"><i class=\"fa fa-arrow-left\" aria-hidden=\"true\"></i> \n            {{ 'municipalities.list' | translate }}</a>\n        <div class=\"marginTopCountdown\">\n            <p class=\"subtitle-home\">{{municipalityName}}</p>\n            <p class=\"edit\"><i class=\"fa fa-info-circle\" aria-hidden=\"true\"></i> {{ 'about.municipality' | translate }}\n            </p>\n        </div>\n    </div>\n    <div class=\"subTitleCountdown\">\n        <p>{{ 'bidding.countdown' | translate }}</p>\n    </div>\n    <div class=\"ui-g-12 whiteNoInline\">\n        <p>{{ 'nip.countdown' | translate }}:<strong> {{installation.nip}}</strong></p>\n        <p>{{ 'outdoor.access' | translate }}:<strong> {{outdoorCount}}</strong></p>\n        <p>{{ 'indoor.access' | translate }}:<strong> {{indoorCount}}</strong></p>\n    </div>\n\n    <div class=\"clearfix\"></div>\n    <div class=\"subTitleCountdown\">\n        <p>{{ 'invoicing.label' | translate }}</p>\n        <div class=\"descriptionCountdown\">\n            <p>{{ 'invoicing.installed' | translate }}</p>\n        </div>\n    </div>\n    <div class=\"marginTop countdownTable\">\n        <p-dataTable [value]=\"installation.accessPoints\" [(selection)]=\"selectedAccesPoints\" [rows]=\"10\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[10,20,50,100]\">\n            <p-column field=\"name\" header=\"{{ 'accesPoint.name' | translate }}\" [sortable]=\"false\"></p-column>\n            <p-column field=\"serialNumber\" header=\"{{ 'sn.countdown' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column field=\"productName\" header=\"{{ 'product.number' | translate }}\" [sortable]=\"false\"></p-column>\n            <p-column field=\"modelNumber\" header=\"{{ 'product.model' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column header=\"{{ 'suppPortal.outIndoor' | translate }}\">\n                <template pTemplate=\"body\" let-ap=\"rowData\">\n                   <span *ngIf=\"ap.indoor\">Indoor</span>\n                   <span *ngIf=\"!ap.indoor\">Outdoor</span>\n                </template>\n            </p-column>\n        </p-dataTable>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-6\" style=\"text-align: center !important\">\n            <button (click)=\"addNewElement()\" class=\"btn btn-primary publish-button supplier-portalButton\">\n                {{ 'button.addInstallationInfo' | translate }}\n            </button>\n        </div>\n        <div class=\"ui-g-6\"></div>\n    </div>\n</div>\n\n\n<!--MODAL Displayed -->\n<p-dialog [(visible)]=\"displayModal\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"true\" (onAfterHide)=\"closeModal()\">\n    <h2 style=\"font-weight: bold;color: #254872; margin-bottom: 10px; text-align:center\">{{ 'button.addInstallationInfo' | translate }}</h2>\n        <form (ngSubmit)=\"onSubmit()\" #installationForm=\"ngForm\">\n            <div class=\"ui-g\">\n                <div class=\"ui-g-12\" style=\"padding-bottom:0.2em !important;\">\n                    <div class=\"form-group\">\n                        <div class=\"ui-g\">\n                            <div class=\"ui-g-1\"></div>\n                            <div class=\"ui-g-6\">\n                                <div class=\"form-group\">\n                                    <label class=\"labelModal left\" for=\"accessPoint\">{{ 'access.point' | translate }}</label>\n                                    <input type=\"text\" [(ngModel)]=\"newAccessPoint.name\" class=\"form-control beneficiaryProfileI\"\n                                        name=\"name\" ngcontrol=\"name\" #name=\"ngModel\" maxlength=\"250\" required>\n                                </div>\n                            </div>\n                            <div class=\"ui-g-1\"></div>\n                        </div>\n                        <div class=\"ui-g\">\n                            <div class=\"ui-g-1\"></div>\n                            <div class=\"ui-g-6\">\n                                <div class=\"form-group\">\n                                    <label class=\"labelModal left\" for=\"serialNumber\">{{ 'sn.countdown' | translate }}</label>\n                                    <input type=\"text\" [(ngModel)]=\"newAccessPoint.serialNumber\" class=\"form-control beneficiaryProfileI\"\n                                        name=\"serialNumber\" ngcontrol=\"serialNumber\" #serialNumber=\"ngModel\" maxlength=\"250\" required>\n                                </div>\n                            </div>\n                            <div class=\"ui-g-1\"></div>\n                        </div>\n                        <div class=\"ui-g\">\n                            <div class=\"ui-g-1\"></div>\n                            <div class=\"ui-g-6\">\n                                <div class=\"form-group\">\n                                    <label class=\"labelModal left\" for=\"productName\">{{ 'product.number' | translate\n                                        }}</label>\n                                    <input type=\"text\" [(ngModel)]=\"newAccessPoint.productName\" class=\"form-control beneficiaryProfileI\"\n                                        name=\"productName\" ngcontrol=\"productName\" #productName=\"ngModel\" maxlength=\"250\" required>\n                                </div>\n                            </div>\n                            <div class=\"ui-g-1\"></div>\n                        </div>\n                        <div class=\"ui-g\">\n                            <div class=\"ui-g-1\"></div>\n                            <div class=\"ui-g-6\">\n                                <div class=\"form-group\">\n                                    <label class=\"labelModal left\" for=\"modelNumber\">{{ 'product.model' | translate\n                                        }}</label>\n                                    <input type=\"text\" [(ngModel)]=\"newAccessPoint.modelNumber\" class=\"form-control beneficiaryProfileI\"\n                                        name=\"modelNumber\" ngcontrol=\"modelNumber\" #modelNumber=\"ngModel\" maxlength=\"250\" required>\n                                </div>\n                            </div>\n                            <div class=\"ui-g-1\"></div>\n                        </div>\n                        <div class=\"ui-g\">\n                            <div class=\"ui-g-1\"></div>\n                            <div class=\"ui-g-6\">\n                                <div class=\"form-group\">\n                                    <label class=\"labelModal left\" for=\"outIndoor\">{{ 'suppPortal.outIndoor' | translate }}</label>\n                                    <select class=\"form-control\" name=\"outIndoor\" id=\"treatment\" [(ngModel)]=\"newAccessPoint.indoor\" required>\n                                        <option value=\"false\">{{ 'suppPortal.outdoor' | translate }}</option>\n                                        <option value=\"true\">{{ 'suppPortal.indoor' | translate }}</option>\n                                    </select>\n                                </div>\n                            </div>\n                            <div class=\"ui-g-1\"></div>\n                        </div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-3\"></div>\n                <div class=\"ui-g-6\" style=\"text-align: center !important\">\n                    <button type=\"button\" (click)=\"closeModal()\" class=\"btn btn-primary publish-button\">\n                        {{ 'cancel.button' | translate }}\n                    </button>\n                    <button type=\"button\" (click)=\"createInstallation()\" class=\"btn btn-primary publish-button\" [disabled]=\"!installationForm.form.valid\">\n                        {{ 'change' | translate }}\n                    </button>\n                </div>\n                <div class=\"ui-g-3\"></div>\n            </div>\n        </form>\n</p-dialog>\n"

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/installation/supplier-installation.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierInstallationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_InstallationDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/InstallationDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_LauApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/LauApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_AccessPointDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/AccessPointDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var SupplierInstallationComponent = (function () {
    function SupplierInstallationComponent(localStorage, supplierApi, lauApi, route) {
        var _this = this;
        this.localStorage = localStorage;
        this.supplierApi = supplierApi;
        this.lauApi = lauApi;
        this.route = route;
        this.municipalityName = '';
        this.route.params.subscribe(function (params) { return _this.installationId = params['id']; });
        this.installation = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_InstallationDTO__["a" /* InstallationDTOBase */]();
        this.newAccessPoint = new __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_AccessPointDTO__["a" /* AccessPointDTOBase */]();
        this.newAccessPoint.installationId = this.installationId;
        this.outdoorCount = 0;
        this.indoorCount = 0;
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.supplierApi.getInstallationById(this.installationId).subscribe(function (installation) {
            if (installation != null) {
                _this.installation = installation;
                for (var i = 0; i < _this.installation.accessPoints.length; i++) {
                    if (_this.installation.accessPoints[i].indoor) {
                        _this.indoorCount++;
                    }
                    else {
                        _this.outdoorCount++;
                    }
                }
                _this.supplierApi.getLegalEntityByInstallationId(_this.installationId).subscribe(function (municipality) {
                    _this.lauApi.findLauByLau2AndCountryCode(municipality.municipalityCode, municipality.countryCode).subscribe(function (lau) {
                        _this.municipalityName = lau.name1;
                    });
                });
            }
        }, function (error) {
            console.log(error);
        });
    }
    SupplierInstallationComponent.prototype.addNewElement = function () {
        this.displayModal = true;
    };
    SupplierInstallationComponent.prototype.closeModal = function () {
        this.displayModal = false;
        this.newAccessPoint = new __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_AccessPointDTO__["a" /* AccessPointDTOBase */]();
        this.newAccessPoint.installationId = this.installationId;
    };
    SupplierInstallationComponent.prototype.createInstallation = function () {
        var _this = this;
        this.supplierApi.createAccessPoint(this.newAccessPoint).subscribe(function (response) {
            _this.installation.accessPoints.push(response.data);
            _this.displayModal = false;
            _this.newAccessPoint = new __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_AccessPointDTO__["a" /* AccessPointDTOBase */]();
            _this.newAccessPoint.installationId = _this.installationId;
            if (response.data.indoor) {
                _this.indoorCount++;
            }
            else {
                _this.outdoorCount++;
            }
        }, function (error) {
            console.log(error);
        });
    };
    return SupplierInstallationComponent;
}());
SupplierInstallationComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+supplier-portal/installation/supplier-installation.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */], __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_LauApi__["a" /* LauApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_LauApi__["a" /* LauApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_LauApi__["a" /* LauApi */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__angular_router__["ActivatedRoute"]) === "function" && _d || Object])
], SupplierInstallationComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-installation.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/municipalities/supplier-municipalities.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <p class=\"Modalh1Confirmation\">{{ 'municipalities.list' | translate }}</p>\n    <p class=\"ModalpConfirmation\">{{ 'check.municipalities' | translate }}</p>\n    <form action=\"\">\n        <div class=\"ui-g-12 white\">\n            <div class=\"ui-g-10\">\n                <p>{{ 'filtermunicipalities.label' | translate }}:</p><input type=\"text\" [(ngModel)]=\"filterInput\" name=\"filterInput\">\n            </div>\n            <div class=\"ui-g-2\">\n                <button (click)=\"filterSearch()\" class=\"btn btn-primary\">{{ 'search.button' | translate }}</button>\n            </div>\n        </div>\n\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g-5 \">\n                <p class=\"subTitleCountdown\">{{ 'municipalities.awarded' | translate }}</p>\n                <div class=\"whiteNoMargin\">\n                    <p-dataTable [value]=\"awardedMunicipalities\" *ngIf=\"!filtering\">\n                        <p-column field=\"municipalityName\" header=\"{{ 'municipality.label' | translate }}\" [sortable]=\"false\"></p-column>\n                        <p-column field=\"countryName\" header=\"{{ 'country.label' | translate }}\" [sortable]=\"false\"></p-column>\n                    </p-dataTable>\n                    <p-dataTable [value]=\"filteredAwardedMunicipalities\" *ngIf=\"filtering\">\n                        <p-column field=\"municipalityName\" header=\"{{ 'municipality.label' | translate }}\" [sortable]=\"false\"></p-column>\n                        <p-column field=\"countryName\" header=\"{{ 'country.label' | translate }}\" [sortable]=\"false\"></p-column>\n                    </p-dataTable>\n                </div>\n            </div>\n            <div class=\"ui-g-2\"></div>\n            <div class=\"ui-g-5\">\n                <p class=\"subTitleCountdown\">{{ 'municipalities.selected' | translate }}</p>\n                <div class=\"whiteNoMargin\">\n                    <p-dataTable [value]=\"selectedMeMunicipalities\" *ngIf=\"!filtering\">\n                        <p-column field=\"municipalityName\" header=\"{{ 'municipality.label' | translate }}\" [sortable]=\"false\"></p-column>\n                        <p-column field=\"countryName\" header=\"{{ 'country.label' | translate }}\" [sortable]=\"false\"></p-column>\n                        <p-column field=\"installationId\" header=\"{{ 'access.point' | translate }}\">\n                            <template pTemplate=\"body\" let-rowData=\"rowData\">\n                                <button type=\"button\" class=\"btn\" [routerLink]=\"['/supplier-portal/installation', rowData.installationId]\" routerLinkActive=\"active\" style=\"background: none; padding: 0;\">\n                                    <i class=\"fa fa-2x fa-eye\" style=\"font-size: 20px;\"></i> {{ 'view' | translate }}\n                                </button>\n                            </template>\n                        </p-column>\n                    </p-dataTable>\n                    <p-dataTable [value]=\"filteredSelectedMeMunicipalities\" *ngIf=\"filtering\">\n                        <p-column field=\"municipalityName\" header=\"{{ 'municipality.label' | translate }}\" [sortable]=\"false\"></p-column>\n                        <p-column field=\"countryName\" header=\"{{ 'country.label' | translate }}\" [sortable]=\"false\"></p-column>\n                        <p-column field=\"installationId\" header=\"{{ 'access.point' | translate }}\">\n                            <template pTemplate=\"body\" let-rowData=\"rowData\">\n                                <button type=\"button\" class=\"btn\" [routerLink]=\"['/supplier-portal/installation', rowData.installationId]\" routerLinkActive=\"active\" style=\"background: none; padding: 0;\">\n                                    <i class=\"fa fa-2x fa-eye\" style=\"font-size: 20px;\"></i> {{ 'view' | translate }}\n                                </button>\n                            </template>\n                        </p-column>\n                    </p-dataTable>\n                </div>\n            </div>\n        </div>\n    </form>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/municipalities/supplier-municipalities.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierMunicipalitiesComponent; });
/* unused harmony export AwardedMunicipality */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_BeneficiaryApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/CallApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_DgconnApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/DgconnApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_LauApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/LauApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var SupplierMunicipalitiesComponent = (function () {
    function SupplierMunicipalitiesComponent(localStorage, supplierApi, beneficiaryApi, callApi, nutsApi, lauApi, dgconnApi) {
        this.localStorage = localStorage;
        this.supplierApi = supplierApi;
        this.beneficiaryApi = beneficiaryApi;
        this.callApi = callApi;
        this.nutsApi = nutsApi;
        this.lauApi = lauApi;
        this.dgconnApi = dgconnApi;
        this.filterInput = '';
        this.filtering = false;
        this.awardedMunicipalities = [];
        this.filteredAwardedMunicipalities = [];
        this.selectedMeMunicipalities = [];
        this.filteredAwardedMunicipalities = [];
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }
    SupplierMunicipalitiesComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (this.user != null) {
            this.beneficiaryApi.getAwardedMunicipalities().subscribe(function (municipalities) {
                var _loop_1 = function (i) {
                    var municipality = municipalities[i];
                    var awardedMunicipality = new AwardedMunicipality();
                    _this.lauApi.findLauByLau2AndCountryCode(municipality.municipalityCode, municipality.countryCode).subscribe(function (lau) {
                        awardedMunicipality.setMunicipalityName(lau.name1);
                        _this.nutsApi.findNutsByCode(municipality.countryCode).subscribe(function (nut) {
                            nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1).toLowerCase();
                            awardedMunicipality.setCountryName(nut.name);
                            _this.awardedMunicipalities.push(awardedMunicipality);
                        });
                    });
                };
                for (var i = 0; i < municipalities.length; i++) {
                    _loop_1(i);
                }
            });
            this.callApi.allCalls().subscribe(function (calls) {
                var currentCall = calls[0];
                _this.supplierApi.getSelectedMeBySupplierId(_this.user.userTypeId).subscribe(function (municipalities) {
                    var _loop_2 = function (i) {
                        var municipality = municipalities[i];
                        _this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(municipality.legalEntityId, currentCall.callId).subscribe(function (installation) {
                            var selectedMunicipality = new AwardedMunicipality();
                            selectedMunicipality.setInstallationId(installation.benPubSubId);
                            _this.lauApi.findLauByLau2AndCountryCode(municipality.municipalityCode, municipality.countryCode).subscribe(function (lau) {
                                selectedMunicipality.setMunicipalityName(lau.name1);
                                _this.nutsApi.findNutsByCode(municipality.countryCode).subscribe(function (nut) {
                                    nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1).toLowerCase();
                                    selectedMunicipality.setCountryName(nut.name);
                                    _this.selectedMeMunicipalities.push(selectedMunicipality);
                                });
                            });
                        });
                    };
                    for (var i = 0; i < municipalities.length; i++) {
                        _loop_2(i);
                    }
                });
            });
        }
    };
    SupplierMunicipalitiesComponent.prototype.filterSearch = function () {
        this.filteredAwardedMunicipalities = [];
        this.filteredSelectedMeMunicipalities = [];
        if (this.filterInput != null && this.filterInput != '') {
            this.filtering = true;
            for (var i = 0; i < this.awardedMunicipalities.length; i++) {
                if (this.awardedMunicipalities[i].getCountryName().toLowerCase().includes(this.filterInput.toLowerCase()) ||
                    this.awardedMunicipalities[i].getMunicipalityName().toLowerCase().includes(this.filterInput.toLowerCase())) {
                    this.filteredAwardedMunicipalities.push(this.awardedMunicipalities[i]);
                }
            }
            for (var i = 0; i < this.selectedMeMunicipalities.length; i++) {
                if (this.selectedMeMunicipalities[i].getCountryName().toLowerCase().includes(this.filterInput.toLowerCase()) ||
                    this.selectedMeMunicipalities[i].getMunicipalityName().toLowerCase().includes(this.filterInput.toLowerCase())) {
                    this.filteredSelectedMeMunicipalities.push(this.selectedMeMunicipalities[i]);
                }
            }
        }
        else {
            this.filtering = false;
        }
    };
    return SupplierMunicipalitiesComponent;
}());
SupplierMunicipalitiesComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'supplier-municipalities-component', template: __webpack_require__("../../../../../src/app/+supplier-portal/municipalities/supplier-municipalities.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_SupplierApi__["a" /* SupplierApi */], __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */], __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__["a" /* CallApi */], __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_NutsApi__["a" /* NutsApi */], __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_LauApi__["a" /* LauApi */], __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_DgconnApi__["a" /* DgconnApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__["a" /* CallApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__["a" /* CallApi */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_LauApi__["a" /* LauApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_LauApi__["a" /* LauApi */]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_DgconnApi__["a" /* DgconnApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_DgconnApi__["a" /* DgconnApi */]) === "function" && _g || Object])
], SupplierMunicipalitiesComponent);

var AwardedMunicipality = (function () {
    function AwardedMunicipality() {
    }
    AwardedMunicipality.prototype.getMunicipalityName = function () {
        return this.municipalityName;
    };
    AwardedMunicipality.prototype.setMunicipalityName = function (value) {
        this.municipalityName = value;
    };
    AwardedMunicipality.prototype.getCountryName = function () {
        return this.countryName;
    };
    AwardedMunicipality.prototype.setCountryName = function (value) {
        this.countryName = value;
    };
    AwardedMunicipality.prototype.getInstallationId = function () {
        return this.installationId;
    };
    AwardedMunicipality.prototype.setInstallationId = function (value) {
        this.installationId = value;
    };
    return AwardedMunicipality;
}());

var _a, _b, _c, _d, _e, _f, _g;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-municipalities.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/profile/profile.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container font\">\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12\">\n            <p class=\"beneficiaryTitle\">{{ 'company.name' | translate }}</p>\n        </div>\n    </div>\n\n\n    <div class=\"ui-g-6\">\n        <hr class=\"beneficiaryHr\">\n        <div class=\"ui-g\">\n            <div class=\"ui-g-12\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-10\">\n                        <p class=\"beneficiaryMayor\">{{ 'contact.person' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-2\">\n                        <a (click)=\"displayContactModal()\" class=\"edit\">\n                            <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i> {{ 'edit.button' | translate }}\n                        </a>\n                    </div>\n                </div>\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-4\">\n                        <p>{{ 'name.label' | translate }}</p>\n                        <p>{{ 'surname.label' | translate }}</p>\n                        <p>{{ 'phone.number' | translate }}</p>\n                        <p>{{ 'email.label' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-8\">\n                        <p class=\"profileData\">{{supplierData.contactName}}</p>\n                        <p class=\"profileData\">{{supplierData.contactSurname}}</p>\n                        <p class=\"profileData\">\n                            {{supplierData.contactPhonePrefix}} {{supplierData.contactPhoneNumber}}\n                        </p>\n                        <p class=\"profileData\">{{supplierData.contactEmail}}</p>\n                    </div>\n                </div>\n                <hr class=\"beneficiaryHr\">\n            </div>\n\n            <div class=\"ui-g-12\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-10\">\n                        <p class=\"beneficiaryMayor\">{{ 'company.details' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-2\">\n                        <a (click)=\"displayCompanyModal()\">\n                            <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i> {{ 'edit.button' | translate }}\n                        </a>\n                    </div>\n                </div>\n\n\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-4\">\n                        <p>{{ 'company.name' | translate }}</p>\n                        <p>{{ 'legal.address' | translate }}</p>\n                        <p>{{ 'vat.label' | translate }}</p>\n                        <p>{{ 'bic.label' | translate }}</p>\n                        <p>{{ 'logo.label' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-8\">\n                        <p class=\"profileData\">{{supplierData.name}}</p>\n                        <p class=\"profileData\">{{supplierData.address}}</p>\n                        <p class=\"profileData\">{{supplierData.vat}}</p>\n                        <p class=\"profileData\">{{supplierData.bic}}</p>\n                        <p class=\"profileData\"><img [src]=\"supplierData.logo\" height=\"50\"></p>\n                    </div>\n                </div>\n                <hr class=\"beneficiaryHr\">\n            </div>\n            <div class=\"ui-g-12\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-10\">\n                        <p class=\"beneficiaryMayor\">{{ 'legalentity.label' | translate }}</p>\n                    </div>\n                </div>\n\n\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-4\">\n                        <p>{{ 'country.label' | translate }}</p>\n                        <p>{{ 'municipality.label' | translate }}</p>\n\n                    </div>\n                    <div class=\"ui-g-8\">\n                        <p class=\"profileData\">\n                            <ng-container *ngFor=\"let country of countriesList; let i = index\">\n                                <b *ngIf=\"i == 0\">{{country}}</b><b *ngIf=\"i > 0\">, {{country}}</b>\n                            </ng-container>\n                        </p>\n                        <p class=\"profileData\">\n                            <ng-container *ngFor=\"let province of provincesList; let i = index\">\n                                <b *ngIf=\"i == 0\">{{province}}</b><b *ngIf=\"i > 0\">, {{province}}</b>\n                            </ng-container>\n                        </p>\n\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g\">\n                <div class=\"ui-g-4\"></div>\n                <div class=\"ui-g-8 button-content\">\n                    <p>{{ 'beneficiaryProfile.text' | translate }}</p>\n                    <div style=\"text-align: center !important\">\n                        <button type=\"button\" (click)=\"openModal()\" class=\"btn btn-primary changePassword\">\n                            {{'beneficiaryProfile.password' | translate }}\n                        </button>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n<!--MODALS BELOW-->\n<div class=\"container font\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"display\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\"\n              [closable]=\"false\" [closeOnEscape]=\"false\">\n        <button type=\"button\" (click)=\"closeModal()\" class=\"closeButton\">X</button>\n        <p class=\"beneficiaryMayorModal\">{{'beneficiaryProfile.password' | translate }}</p>\n        <form (ngSubmit)=\"changePassword()\" #profileForm=\"ngForm\">\n            <div class=\"form-group profileDialog\">\n                <label class=\"labelModal\" for=\"currentPassword\">{{ 'currentPassword.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"supplierDetails.currentPassword\" class=\"form-control beneficiaryProfileI\"\n                       name=\"currentPassword\" ngcontrol=\"currentPassword\" #currentPassword=\"ngModel\" required>\n                <div [hidden]=\"currentPassword.valid || currentPassword.pristine\" class=\"alert alert-danger\">\n                    {{ 'password.required' | translate }}\n                </div>\n                <a class=\"forgotPassword\" routerLink=\"/forgot\">Forgot password?</a><br>\n                <label class=\"labelModal\" for=\"newPassword\">{{ 'password.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"supplierDetails.newPassword\" class=\"form-control beneficiaryProfileI\"\n                       name=\"newPassword\" ngcontrol=\"newPassword\" #newPassword=\"ngModel\" (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"newPassword.valid || newPassword.pristine\" class=\"alert alert-danger\">\n                    {{ 'password.required' | translate }}\n                </div>\n                <label class=\"labelModal\" for=\"repeatNewPassword\">{{ 'confirmNewPassword.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"supplierDetails.repeatNewPassword\" class=\"form-control beneficiaryProfileI\"\n                       name=\"repeatNewPassword\" ngcontrol=\"repeatNewPassword\" #repeatNewPassword=\"ngModel\" (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"repeatNewPassword.valid || repeatNewPassword.pristine\" class=\"alert alert-danger\">\n                    {{'newPassword.required' | translate }}\n                </div>\n                <div class=\"form-group\">\n                    <div style=\"text-align: center !important\">\n                        <button type=\"button\" class=\"btn btn-primary changePasswordModal\" (click)=\"closeModal()\">\n                            {{ 'cancel.button' | translate }}\n                        </button>\n                        <button type=\"submit\" class=\"btn btn-primary changePasswordModal\" [disabled]=\"!profileForm.form.valid || !checkPassword()\">\n                            {{ 'change' | translate }}\n                        </button>\n                    </div>\n                </div>\n            </div>\n        </form>\n    </p-dialog>\n</div>\n\n\n<div class=\"container font\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"displayCompany\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\"\n              [closable]=\"false\" [closeOnEscape]=\"false\">\n        <button type=\"button\" (click)=\"closeModal()\" class=\"closeButton\">X</button>\n        <p class=\"beneficiaryMayor center\">{{ 'company.details' | translate }}</p>\n        <form (ngSubmit)=\"onSubmit()\" #profileFormCompany=\"ngForm\">\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"name\">{{ 'company.name' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.name\" class=\"form-control\"\n                               name=\"name\" ngcontrol=\"name\" #name=\"ngModel\" required>\n                        <div [hidden]=\"name.valid || name.pristine\" class=\"alert alert-danger\">\n                            {{'company.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"address\">{{ 'legal.address' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.address\" class=\"form-control\"\n                               name=\"address\" ngcontrol=\"address\" #address=\"ngModel\" required>\n                        <div [hidden]=\"address.valid || address.pristine\" class=\"alert alert-danger\">\n                            {{'address.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"vat\">{{ 'vat.label' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.vat\" class=\"form-control\"\n                               name=\"vat\" ngcontrol=\"vat\" #vat=\"ngModel\" required>\n                        <div [hidden]=\"vat.valid || vat.pristine\" class=\"alert alert-danger\">\n                            {{'vat.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"bic\">{{ 'bic.label' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.bic\" class=\"form-control\"\n                               name=\"bic\" ngcontrol=\"bic\" #bic=\"ngModel\" required>\n                        <div [hidden]=\"bic.valid || bic.pristine\" class=\"alert alert-danger\">\n                            {{'bic.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"binaryLogo\">{{ 'logo.label' | translate }}</label>\n                        <br>\n                        <br>\n                        <div class=\"ui-g-12\" style=\"border: 1px solid #D5D5D5; background: #ffffff;\">\n                            <div *ngIf=\"supplierData.logo\" class=\"ui-g-5\">\n                                <h3><b>Current logo</b></h3><br>\n                                <img [src]=\"supplierData.logo\" height=\"75\"\n                                     style=\"max-width: 100%; border: 1px solid; box-shadow: 0px 0px 5px black;\">\n                            </div>\n                            <h2 *ngIf=\"!supplierData.logo\" class=\"ui-g-4\">No logo uploaded</h2>\n                            <div class=\"ui-g-2\"></div>\n                            <div class=\"ui-g-5\">\n                                <h3 *ngIf=\"isLogoUploaded\"><b>New logo</b></h3><br>\n                                <img *ngIf=\"isLogoUploaded\" height=\"75\" [src]=\"logoUrl.result\"\n                                     style=\"max-width: 100%; border: 1px solid; box-shadow: 0px 0px 5px black;\">\n                            </div>\n                            <div class=\"ui-g-12 center\">\n                                <br>\n                                <input #logoInput type=\"file\" (change)=\"onSelect($event)\" accept=\"image/*\">\n                            </div>\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group\">\n                <div style=\"text-align: center !important\">\n                    <button type=\"button\" class=\"btn btn-primary changePasswordModalNoTop\" (click)=\"closeModal()\">\n                        {{ 'cancel.button' | translate }}\n                    </button>\n                    <button type=\"button\" class=\"btn btn-primary changePasswordModalNoTop\"\n                            [disabled]=\"!profileFormCompany.form.valid\" (click)=\"saveSupplierChanges()\">\n                        {{ 'change' | translate }}\n                    </button>\n                </div>\n            </div>\n        </form>\n    </p-dialog>\n</div>\n\n<div class=\"container font\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"displayContact\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\"\n              [closable]=\"false\" [closeOnEscape]=\"false\">\n        <button type=\"button\" (click)=\"closeModal()\" class=\"closeButton\">X</button>\n        <p class=\"beneficiaryMayor center\">{{ 'contact.person' | translate }}</p>\n        <form (ngSubmit)=\"onSubmit()\" #profileFormContact=\"ngForm\">\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"contactName\">{{ 'name.label' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.contactName\" class=\"form-control\"\n                               name=\"contactName\" ngcontrol=\"contactName\" #contactName=\"ngModel\" required>\n                        <div [hidden]=\"contactName.valid || contactName.pristine\" class=\"alert alert-danger\">\n                            {{ 'name.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"contactSurname\">{{ 'surname.label' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.contactSurname\" class=\"form-control\"\n                               name=\"contactSurname\" ngcontrol=\"contactSurname\" #contactSurname=\"ngModel\" required>\n                        <div [hidden]=\"contactSurname.valid || contactSurname.pristine\" class=\"alert alert-danger\">\n                            {{ 'surname.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\" style=\"padding:0.5em 0\">\n                    <div class=\"form-group\">\n                        <div class=\"ui-g-5\">\n                            <label for=\"contactPhonePrefix\">{{ 'prefix.number' | translate }}</label>\n                            <input type=\"text\" [(ngModel)]=\"selectedSupplierData.contactPhonePrefix\" class=\"form-control\"\n                                name=\"contactPhonePrefix\" ngcontrol=\"contactPhonePrefix\" #contactPhonePrefix=\"ngModel\" required>\n                            <div [hidden]=\"contactPhonePrefix.valid || contactPhonePrefix.pristine\" class=\"alert alert-danger\">\n                                {{ 'phone.required' | translate }}\n                            </div>\n                        </div>\n                        <div class=\"ui-g-5\">\n                            <label for=\"contactPhoneNumber\">{{ 'phone.number' | translate }}</label>\n                            <input type=\"text\" [(ngModel)]=\"selectedSupplierData.contactPhoneNumber\" class=\"form-control\"\n                                name=\"contactPhoneNumber\" ngcontrol=\"contactPhoneNumber\" #contactPhoneNumber=\"ngModel\" required>\n                            <div [hidden]=\"contactPhoneNumber.valid || contactPhoneNumber.pristine\" class=\"alert alert-danger\">\n                                {{ 'phone.required' | translate }}\n                            </div>\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"email\">{{ 'email.label' | translate }}</label>\n                        <input type=\"text\" [(ngModel)]=\"selectedSupplierData.contactEmail\" class=\"form-control\"\n                               name=\"email\" ngcontrol=\"email\" #email=\"ngModel\" required disabled>\n                        <div [hidden]=\"email.valid || email.pristine\" class=\"alert alert-danger\">\n                            {{ 'email.required' | translate }}\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group\">\n                <div style=\"text-align: center !important\">\n                    <button type=\"button\" class=\"btn btn-primary changePasswordModalNoTop\" (click)=\"closeModal()\">\n                        {{ 'cancel.button' | translate }}\n                    </button>\n                    <button type=\"button\" class=\"btn btn-primary changePasswordModalNoTop\"\n                            [disabled]=\"!profileFormContact.form.valid\" (click)=\"saveSupplierChanges()\">\n                        {{ 'change' | translate }}\n                    </button>\n                </div>\n            </div>\n        </form>\n    </p-dialog>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/profile/profile.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierProfileComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_models_supplier_details_model__ = __webpack_require__("../../../../../src/app/shared/models/supplier-details.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_LauApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/LauApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_LauDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/LauDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/NutsDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__shared_swagger_api_UserApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/UserApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_Rx__ = __webpack_require__("../../../../rxjs/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_rxjs_Rx__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};












var SupplierProfileComponent = (function () {
    function SupplierProfileComponent(localStorage, supplierApi, lauApi, nutsApi, uxService, userApi) {
        this.localStorage = localStorage;
        this.supplierApi = supplierApi;
        this.lauApi = lauApi;
        this.nutsApi = nutsApi;
        this.uxService = uxService;
        this.userApi = userApi;
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.supplierDetails = new __WEBPACK_IMPORTED_MODULE_1__shared_models_supplier_details_model__["a" /* SupplierDetails */]();
        this.display = false;
        this.displayContact = false;
        this.displayCompany = false;
        this.displayLegal = false;
        this.supplierData = new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]();
        this.nutsCountry = new __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__["a" /* NutsDTOBase */]();
        this.lauMunicipality = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_LauDTO__["a" /* LauDTOBase */]();
        this.selectedSupplierData = new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]();
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.selectedCountries = [];
        this.selectedProvinces = [];
        this.allCountries = [];
        this.countries = [];
        this.provinces = [];
        this.countriesList = [];
        this.provincesList = [];
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }
    SupplierProfileComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.userTypeId).subscribe(function (response) {
                _this.supplierData = response;
                var partNuts = _this.supplierData.nutsIds.split(",");
                for (var i = 0; i < partNuts.length; i++) {
                    _this.nutsApi.findNutsByCode(partNuts[i]).subscribe(function (nuts) {
                        if (nuts.level == 0) {
                            _this.countries.push(nuts);
                            var countryName = nuts.name.toLowerCase();
                            countryName = countryName.charAt(0).toUpperCase() + countryName.slice(1);
                            _this.countriesList.push(countryName);
                        }
                        else if (nuts.level == 3) {
                            _this.provinces.push(nuts);
                            _this.provincesList.push(nuts.name);
                        }
                    });
                }
            }, function (error) {
                console.log(error);
            });
        }
    };
    SupplierProfileComponent.prototype.openModal = function () {
        this.display = true;
    };
    SupplierProfileComponent.prototype.displayContactModal = function () {
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayContact = true;
    };
    SupplierProfileComponent.prototype.displayCompanyModal = function () {
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayCompany = true;
    };
    SupplierProfileComponent.prototype.displayLegalModal = function () {
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayLegal = true;
        console.log(this.selectedCountries);
        console.log(this.allCountries);
        this.checkCountries();
    };
    SupplierProfileComponent.prototype.checkCountries = function () {
        var _this = this;
        this.nutsApi.findNutsByLevel(0).subscribe(function (nuts) {
            var _loop_1 = function (nut) {
                var selectedItem = {
                    label: ' ' + nut.name,
                    value: nut
                };
                _this.allCountries.push(selectedItem);
                if (_this.countries.some(function (e) { return e.name == nut.name; })) {
                    _this.selectedCountries.push(selectedItem.value);
                }
            };
            for (var _i = 0, nuts_1 = nuts; _i < nuts_1.length; _i++) {
                var nut = nuts_1[_i];
                _loop_1(nut);
            }
        });
    };
    SupplierProfileComponent.prototype.closeModal = function () {
        this.display = false;
        this.displayLegal = false;
        this.displayCompany = false;
        this.displayContact = false;
        this.clearLogoFile();
        this.nutsCountry = this.nutsModalInitial;
        this.lauMunicipality = this.lausModalInitial;
        this.selectedSupplierData = Object.assign({}, this.supplierData);
    };
    SupplierProfileComponent.prototype.checkPassword = function () {
        return this.supplierDetails.newPassword === this.supplierDetails.repeatNewPassword;
    };
    SupplierProfileComponent.prototype.saveSupplierChanges = function () {
        var _this = this;
        if (this.isLogoUploaded) {
            this.selectedSupplierData.logo = this.logoUrl.result;
        }
        this.supplierApi.saveSupplier(this.selectedSupplierData).subscribe(function (savedSupplier) {
            _this.supplierData = savedSupplier.data;
            _this.display = false;
            _this.displayLegal = false;
            _this.displayCompany = false;
            _this.displayContact = false;
            _this.clearLogoFile();
        }, function (error) {
            console.log(error);
        });
    };
    SupplierProfileComponent.prototype.onSelect = function (event) {
        var _this = this;
        this.isLogoUploaded = false;
        if (event.target && event.target.files && event.target.files.length > 0) {
            this.logoUrl.readAsDataURL(event.target.files["0"]);
            this.logoFile = event.target.files["0"];
            var subscription_1 = __WEBPACK_IMPORTED_MODULE_11_rxjs_Rx__["Observable"].interval(500).map(function (x) {
            }).subscribe(function (x) {
                if (_this.logoUrl.result != "") {
                    _this.isLogoUploaded = true;
                    subscription_1.unsubscribe();
                }
            });
        }
    };
    SupplierProfileComponent.prototype.clearLogoFile = function () {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.logoFile = null;
    };
    SupplierProfileComponent.prototype.onMultiSelectChange = function (event) {
        var _this = this;
        if (event.value.length > 0) {
            var country_1 = event.value[event.value.length - 1];
            if (this.selectedCountries.length > 0) {
                this.selectedCountries.splice(0, this.selectedCountries.length);
            }
            for (var _i = 0, _a = event.value; _i < _a.length; _i++) {
                var country_2 = _a[_i];
                this.selectedCountries.push(country_2);
            }
            this.nutsApi.findNutsByLevel(3).subscribe(function (nuts) {
                _this.provinces[country_1.name.toUpperCase()] = [];
                for (var _i = 0, nuts_2 = nuts; _i < nuts_2.length; _i++) {
                    var nut = nuts_2[_i];
                    if (country_1.countryCode === nut.countryCode) {
                        _this.provinces[country_1.name.toUpperCase()].push(nut);
                    }
                }
            });
        }
    };
    SupplierProfileComponent.prototype.updateNutsAndLau = function () {
        this.selectedSupplierData.nutsIds = "";
        this.selectedSupplierData.nutsIds += this.nutsCountry.countryCode;
        this.selectedSupplierData.nutsIds += "," + this.lauMunicipality.lau2;
    };
    SupplierProfileComponent.prototype.emptyPasswordModal = function () {
        this.supplierDetails.currentPassword = "";
        this.supplierDetails.newPassword = "";
        this.supplierDetails.repeatNewPassword = "";
    };
    SupplierProfileComponent.prototype.changePassword = function () {
        var _this = this;
        var passwords = '{"currentPassword" : "' + this.supplierDetails.currentPassword + '", "newPassword" : "' + this.supplierDetails.newPassword + '"}';
        this.userApi.changePassword(this.user.userId, passwords).subscribe(function (response) {
            if (response.success == true) {
                _this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'Password changed succesfully!'
                });
                _this.user = response.data;
                _this.closeModal();
            }
            else {
                _this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: response.data
                });
                _this.emptyPasswordModal();
            }
        }, function (error) {
            console.log(error);
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Contact your administrator'
            });
        });
    };
    return SupplierProfileComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])('logoInput'),
    __metadata("design:type", Object)
], SupplierProfileComponent.prototype, "logoInput", void 0);
SupplierProfileComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+supplier-portal/profile/profile.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */], __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_LauApi__["a" /* LauApi */], __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_NutsApi__["a" /* NutsApi */], __WEBPACK_IMPORTED_MODULE_10__shared_swagger_api_UserApi__["a" /* UserApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_LauApi__["a" /* LauApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_LauApi__["a" /* LauApi */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_9__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_9__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_10__shared_swagger_api_UserApi__["a" /* UserApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_10__shared_swagger_api_UserApi__["a" /* UserApi */]) === "function" && _f || Object])
], SupplierProfileComponent);

var _a, _b, _c, _d, _e, _f;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/profile.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/supplier-portal-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierPortalRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__supplier_portal_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/supplier-portal.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__installation_supplier_installation_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/installation/supplier-installation.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__profile_profile_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/profile/profile.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var SupplierPortalRoutingModule = (function () {
    function SupplierPortalRoutingModule() {
    }
    return SupplierPortalRoutingModule;
}());
SupplierPortalRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forChild([
                {
                    path: '',
                    component: __WEBPACK_IMPORTED_MODULE_2__supplier_portal_component__["a" /* SupplierPortalComponent */],
                }, {
                    path: 'installation/:id',
                    component: __WEBPACK_IMPORTED_MODULE_3__installation_supplier_installation_component__["a" /* SupplierInstallationComponent */],
                }, {
                    path: 'profile',
                    component: __WEBPACK_IMPORTED_MODULE_4__profile_profile_component__["a" /* SupplierProfileComponent */],
                }
            ])],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
    })
], SupplierPortalRoutingModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-portal-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/supplier-portal.component.html":
/***/ (function(module, exports) {

module.exports = "<timeline-component></timeline-component>\n<div [ngSwitch]=\"voucherCompetitionState\">\n    <!-- no competition created, display warning -->\n    <div *ngSwitchCase=\"0\">\n        <div class=\"ui-g-12\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-info\">{{ 'voucher.noCompetitionPart1' | translate}}<b>{{\n                'voucher.noCompetitionPart2' | translate}}</b></ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"center\">\n            <img src=\"assets/images/notification.png\" alt=\"\">\n        </div>\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g-4\"></div>\n            <div class=\"ui-g-4\">\n                <p class=\"labelModal\">{{ 'voucher.emailNotification' | translate}}</p>\n            </div>\n            <div class=\"ui-g-4\"></div>\n        </div>\n\n        <hr class=\"beneficiaryHr\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.whats.next' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.steps' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/apply.png\" alt=\"\">\n                <p><span class=\"dotSteps\">1.</span> {{ 'voucher.supplierStep1' | translate}}</p>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/supplier.png\" alt=\"\">\n                <p><span class=\"dotSteps\">2.</span> {{ 'voucher.supplierStep2' | translate}}</p>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/notificationVoucher.png\" alt=\"\">\n                <p><span class=\"dotSteps\">3.</span> {{ 'voucher.supplierStep3' | translate}}</p>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    <!-- no competition active, display timer -->\n    <div *ngSwitchCase=\"1\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.timeleft.title' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.timeleft.subtitle' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <timer-component (timerEvent)=\"checkIfSelected()\"\n                             [expirationTimestamp]=\"currentCall.startDate\"></timer-component>\n        </div>\n\n        <hr class=\"beneficiaryHr\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.whats.next' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.steps' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/apply.png\" alt=\"\">\n                <p><span class=\"dotSteps\">1.</span> {{ 'voucher.supplierStep1' | translate}}</p>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/supplier.png\" alt=\"\">\n                <p><span class=\"dotSteps\">2.</span> {{ 'voucher.supplierStep2' | translate}}</p>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/notificationVoucher.png\" alt=\"\">\n                <p><span class=\"dotSteps\">3.</span> {{ 'voucher.supplierStep3' | translate}}</p>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    <!-- competition Open, display info -->\n    <div *ngSwitchCase=\"2\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-info\">{{ 'voucher.statusmessage4' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.competition' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.competition.desc' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n\n        <hr class=\"beneficiaryHr\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.whats.next' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.steps' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/apply.png\" alt=\"\">\n                <p><span class=\"dotSteps\">1.</span> {{ 'voucher.supplierStep1' | translate}}</p>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/supplier.png\" alt=\"\">\n                <p><span class=\"dotSteps\">2.</span> {{ 'voucher.supplierStep2' | translate}}</p>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"assets/images/notificationVoucher.png\" alt=\"\">\n                <p><span class=\"dotSteps\">3.</span> {{ 'voucher.supplierStep3' | translate}}</p>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    <!-- Someone has selected you as their supplier, display  -->\n    <supplier-municipalities-component *ngSwitchCase=\"3\"></supplier-municipalities-component>\n    <!-- a problem occurred -->\n    <div *ngSwitchCase=\"-1\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-danger\">{{errorCause | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" routerLink=\"/home\" routerLinkActive=\"active\">\n                {{ 'voucher.backhome' | translate}}\n            </button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/supplier-portal.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierPortalComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_CallDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/CallDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/CallApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var SupplierPortalComponent = (function () {
    function SupplierPortalComponent(localStorage, supplierApi, callApi) {
        this.localStorage = localStorage;
        this.supplierApi = supplierApi;
        this.callApi = callApi;
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_CallDTO__["a" /* CallDTOBase */]();
        this.supplierInfo = new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]();
        this.municipalitiesThatSelectedMe = [];
    }
    SupplierPortalComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.userTypeId).subscribe(function (supplier) {
                _this.supplierInfo = supplier;
                _this.checkForCalls();
            }, function (error) {
                console.log(error);
                _this.supplierInfo = null;
                _this.voucherCompetitionState = -1;
                _this.errorCause = "supplierportal.suppliernotfound";
            });
        }
    };
    SupplierPortalComponent.prototype.checkForCalls = function () {
        var _this = this;
        this.callApi.allCalls().subscribe(function (calls) {
            _this.currentCall = calls[0];
            if (_this.currentCall != null) {
                // First, check if the call has already began
                if ((_this.currentCall.startDate - new Date().getTime()) <= 0) {
                    _this.checkIfSelected();
                }
                else {
                    // The competition hasn't started, display the timer
                    _this.voucherCompetitionState = 1;
                }
            }
            else {
                // Display "no competition active" message
                _this.voucherCompetitionState = 0;
            }
        }, function (error) {
            console.log(error);
            _this.currentCall = null;
            _this.voucherCompetitionState = 0;
        });
    };
    SupplierPortalComponent.prototype.checkIfSelected = function () {
        var _this = this;
        this.supplierApi.getSelectedMeBySupplierId(this.user.userTypeId).subscribe(function (entities) {
            if (entities.length > 0) {
                _this.municipalitiesThatSelectedMe = entities;
                // Display the 'municipalities' screen
                _this.voucherCompetitionState = 3;
            }
            else {
                _this.voucherCompetitionState = 2;
            }
        }, function (error) {
            console.log(error);
            _this.supplierInfo = null;
            _this.voucherCompetitionState = -1;
            _this.errorCause = "supplierportal.couldntgetselectedmunicipalities";
        });
    };
    return SupplierPortalComponent;
}());
SupplierPortalComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+supplier-portal/supplier-portal.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */], __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */]) === "function" && _c || Object])
], SupplierPortalComponent);

var _a, _b, _c;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-portal.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-portal/supplier-portal.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SupplierPortalModule", function() { return SupplierPortalModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__supplier_portal_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/supplier-portal.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__installation_supplier_installation_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/installation/supplier-installation.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__municipalities_supplier_municipalities_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/municipalities/supplier-municipalities.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__profile_profile_component__ = __webpack_require__("../../../../../src/app/+supplier-portal/profile/profile.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__supplier_portal_routing_module__ = __webpack_require__("../../../../../src/app/+supplier-portal/supplier-portal-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__ = __webpack_require__("../../../../primeng/primeng.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_primeng_primeng__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var SupplierPortalModule = (function () {
    function SupplierPortalModule() {
    }
    return SupplierPortalModule;
}());
SupplierPortalModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */],
            __WEBPACK_IMPORTED_MODULE_6__supplier_portal_routing_module__["a" /* SupplierPortalRoutingModule */],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["FileUploadModule"]
        ],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__supplier_portal_component__["a" /* SupplierPortalComponent */],
            __WEBPACK_IMPORTED_MODULE_3__installation_supplier_installation_component__["a" /* SupplierInstallationComponent */],
            __WEBPACK_IMPORTED_MODULE_4__municipalities_supplier_municipalities_component__["a" /* SupplierMunicipalitiesComponent */],
            __WEBPACK_IMPORTED_MODULE_5__profile_profile_component__["a" /* SupplierProfileComponent */]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_2__supplier_portal_component__["a" /* SupplierPortalComponent */]]
    })
], SupplierPortalModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-portal.module.js.map

/***/ }),

/***/ "../../../../../src/app/shared/models/supplier-details.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierDetails; });
var SupplierDetails = (function () {
    function SupplierDetails() {
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
    }
    return SupplierDetails;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-details.model.js.map

/***/ })

});
//# sourceMappingURL=supplier-portal.module.chunk.js.map