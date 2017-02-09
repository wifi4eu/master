webpackJsonp([0,4],{

/***/ 1169:
/***/ function(module, exports, __webpack_require__) {

"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__(521);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__registration_routing_module__ = __webpack_require__(1178);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__registration_component__ = __webpack_require__(1172);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__entity_entity_component__ = __webpack_require__(1176);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__beneficiary_beneficiary_component__ = __webpack_require__(1174);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__review_review_component__ = __webpack_require__(1179);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__success_registration_component__ = __webpack_require__(1173);
/* harmony export (binding) */ __webpack_require__.d(exports, "RegistrationModule", function() { return RegistrationModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var RegistrationModule = (function () {
    function RegistrationModule() {
    }
    RegistrationModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */], __WEBPACK_IMPORTED_MODULE_2__registration_routing_module__["a" /* RegistrationRoutingModule */]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_3__registration_component__["a" /* RegistrationComponent */], __WEBPACK_IMPORTED_MODULE_4__entity_entity_component__["a" /* EntityComponent */], __WEBPACK_IMPORTED_MODULE_5__beneficiary_beneficiary_component__["a" /* BeneficiaryComponent */], __WEBPACK_IMPORTED_MODULE_6__review_review_component__["a" /* ReviewComponent */], __WEBPACK_IMPORTED_MODULE_7__success_registration_component__["a" /* SuccessRegistrationComponent */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_3__registration_component__["a" /* RegistrationComponent */]]
        }), 
        __metadata('design:paramtypes', [])
    ], RegistrationModule);
    return RegistrationModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/registration.module.js.map

/***/ },

/***/ 1170:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return BeneficiaryDetails; });
var BeneficiaryDetails = (function () {
    function BeneficiaryDetails() {
        this.representativeSelected = false;
    }
    return BeneficiaryDetails;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/beneficiary-details.model.js.map

/***/ },

/***/ 1171:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return EntityDetails; });
var EntityDetails = (function () {
    function EntityDetails() {
    }
    return EntityDetails;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/entity-details.model.js.map

/***/ },

/***/ 1172:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__ = __webpack_require__(1171);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__ = __webpack_require__(1170);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return RegistrationComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var RegistrationComponent = (function () {
    function RegistrationComponent() {
        console.log("Constructor");
        this.entityDetails = new __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__["a" /* EntityDetails */]();
        this.beneficiaryDetails = new __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */]();
        this.completedSteps = [false, false, false];
        this.activeSteps = [false, false, false];
        this.currentStep = 1;
        this.completed = [false, false, false];
        this.active = [true, false, false];
    }
    RegistrationComponent.prototype.onNext = function (step) {
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
        console.log("Completed", this.completed);
        console.log("Active", this.active);
    };
    RegistrationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__(1182) }), 
        __metadata('design:paramtypes', [])
    ], RegistrationComponent);
    return RegistrationComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/registration.component.js.map

/***/ },

/***/ 1173:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return SuccessRegistrationComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SuccessRegistrationComponent = (function () {
    function SuccessRegistrationComponent() {
    }
    SuccessRegistrationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__(1183) }), 
        __metadata('design:paramtypes', [])
    ], SuccessRegistrationComponent);
    return SuccessRegistrationComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/success.registration.component.js.map

/***/ },

/***/ 1174:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__beneficiary_details_model__ = __webpack_require__(1170);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return BeneficiaryComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var BeneficiaryComponent = (function () {
    function BeneficiaryComponent() {
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.wrongDetails = [];
    }
    BeneficiaryComponent.prototype.nextStep = function (step) {
        this.onNext.emit(step);
    };
    BeneficiaryComponent.prototype.checkMayorDetails = function () {
        if (this.beneficiaryDetails.treatment == null || this.beneficiaryDetails.treatment == "") {
            this.wrongDetails.push("treatment");
            console.log("treatment is empty!");
        }
        if (this.beneficiaryDetails.name == null || this.beneficiaryDetails.name == "") {
            this.wrongDetails.push("name");
            console.log("name is empty!");
        }
        if (this.beneficiaryDetails.surname == null || this.beneficiaryDetails.surname == "") {
            this.wrongDetails.push("surname");
            console.log("surname is empty!");
        }
        if (this.beneficiaryDetails.email == null || this.beneficiaryDetails.email == "") {
            this.wrongDetails.push("email");
            console.log("email is empty!");
        }
        if (this.beneficiaryDetails.confirmEmail == null || this.beneficiaryDetails.confirmEmail == "") {
            this.wrongDetails.push("confirmEmail");
            console.log("confirmEmail is empty!");
        }
    };
    BeneficiaryComponent.prototype.checkRepresentativeDetails = function () {
        if (this.beneficiaryDetails.treatmentRepresentative == null || this.beneficiaryDetails.treatmentRepresentative == "") {
            this.wrongDetails.push("treatmentRepresentative");
            console.log("treatmentRepresentative is empty!");
        }
        if (this.beneficiaryDetails.nameRepresentative == null || this.beneficiaryDetails.nameRepresentative == "") {
            this.wrongDetails.push("nameRepresentative");
            console.log("nameRepresentative is empty!");
        }
        if (this.beneficiaryDetails.surnameRepresentative == null || this.beneficiaryDetails.surnameRepresentative == "") {
            this.wrongDetails.push("surnameRepresentative");
            console.log("surnameRepresentative is empty!");
        }
        if (this.beneficiaryDetails.roleRepresentative == null || this.beneficiaryDetails.roleRepresentative == "") {
            this.wrongDetails.push("roleRepresentative");
            console.log("roleRepresentative is empty!");
        }
        if (this.beneficiaryDetails.emailRepresentative == null || this.beneficiaryDetails.emailRepresentative == "") {
            this.wrongDetails.push("emailRepresentative");
            console.log("emailRepresentative is empty!");
        }
        if (this.beneficiaryDetails.confirmEmailRepresentative == null || this.beneficiaryDetails.confirmEmailRepresentative == "") {
            this.wrongDetails.push("confirmEmailRepresentative");
            console.log("confirmEmailRepresentative is empty!");
        }
    };
    BeneficiaryComponent.prototype.checkIfWrong = function (detail) {
        if (this.wrongDetails.indexOf(detail) > -1) {
            return true;
        }
        else {
            return false;
        }
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('beneficiaryDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__beneficiary_details_model__["a" /* BeneficiaryDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__beneficiary_details_model__["a" /* BeneficiaryDetails */]) === 'function' && _a) || Object)
    ], BeneficiaryComponent.prototype, "beneficiaryDetails", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('completedSteps'), 
        __metadata('design:type', Array)
    ], BeneficiaryComponent.prototype, "completedSteps", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('activeSteps'), 
        __metadata('design:type', Array)
    ], BeneficiaryComponent.prototype, "activeSteps", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('currentStep'), 
        __metadata('design:type', Number)
    ], BeneficiaryComponent.prototype, "currentStep", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], BeneficiaryComponent.prototype, "onNext", void 0);
    BeneficiaryComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'beneficiary-component',
            template: __webpack_require__(1180),
            styles: [".wrong-detail { box-shadow: 0px 0px 2px 1px red; }"]
        }), 
        __metadata('design:paramtypes', [])
    ], BeneficiaryComponent);
    return BeneficiaryComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/beneficiary.component.js.map

/***/ },

/***/ 1175:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return CountryList; });
var CountryList = (function () {
    function CountryList() {
        this.countryList = [
            {
                "name": "Austria",
                "code": "AT"
            }, {
                "name": "Belgium",
                "code": "BE"
            }, {
                "name": "Bulgaria",
                "code": "BG"
            }, {
                "name": "Cyprus",
                "code": "CY"
            }, {
                "name": "Czech Republic",
                "code": "CZ"
            }, {
                "name": "Denmark",
                "code": "DK"
            }, {
                "name": "Estonia",
                "code": "EE"
            }, {
                "name": "Finland",
                "code": "FI"
            }, {
                "name": "France",
                "code": "FR"
            }, {
                "name": "Germany",
                "code": "DE"
            }, {
                "name": "Greece",
                "code": "GR"
            }, {
                "name": "Hungary",
                "code": "HU"
            }, {
                "name": "Iceland",
                "code": "IS"
            }, {
                "name": "Ireland",
                "code": "IE"
            }, {
                "name": "Italy",
                "code": "IT"
            }, {
                "name": "Lithuania",
                "code": "LT"
            }, {
                "name": "Luxembourg",
                "code": "LU"
            }, {
                "name": "Malta",
                "code": "MT"
            }, {
                "name": "Netherlands",
                "code": "NL"
            }, {
                "name": "Norway",
                "code": "NO"
            }, {
                "name": "Poland",
                "code": "PL"
            }, {
                "name": "Portugal",
                "code": "PT"
            }, {
                "name": "Romania",
                "code": "RO"
            }, {
                "name": "Slovakia",
                "code": "SK"
            }, {
                "name": "Slovenia",
                "code": "SI"
            }, {
                "name": "Spain",
                "code": "ES"
            }, {
                "name": "Sweden",
                "code": "SE"
            }, {
                "name": "Switzerland",
                "code": "CH"
            }, {
                "name": "Turkey",
                "code": "TR"
            }, {
                "name": "United Kingdom",
                "code": "UK"
            }
        ];
    }
    CountryList.prototype.getAll = function () {
        return this.countryList;
    };
    return CountryList;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/country-list.model.js.map

/***/ },

/***/ 1176:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(77);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__entity_service__ = __webpack_require__(1177);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__country_list_model__ = __webpack_require__(1175);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__entity_details_model__ = __webpack_require__(1171);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return EntityComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var EntityComponent = (function () {
    function EntityComponent(entityService, http) {
        this.entityService = entityService;
        this.http = http;
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    EntityComponent.prototype.nextStep = function (step) {
        this.onNext.emit(step);
    };
    EntityComponent.prototype.filterCountry = function (event) {
        var query = event.query;
        var countryList = new __WEBPACK_IMPORTED_MODULE_3__country_list_model__["a" /* CountryList */]();
        this.countrySuggestions = this.filterCountries(query, countryList.getAll());
        // TODO - In a real application, make a request to a remote url with the query
        // and return results, for demo we get it at client side.
        /*
        this
          .entityService
          .getCountries()
          .subscribe(countries => {
            console.log(countries);
            this.suggestions = this.filterCountries(query, countries);
          });
        */
    };
    EntityComponent.prototype.filterCountries = function (query, countries) {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        var filtered = [];
        for (var i = 0; i < countries.length; i++) {
            var country = countries[i];
            if (country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                filtered.push(country);
            }
        }
        return filtered;
    };
    EntityComponent.prototype.getMunicipalities = function (query) {
        var that = this;
        if (this.country != null) {
            this.entityService.getMunicipalities(this.country.code).subscribe(function (res) {
                that.municipalities = res;
                if (that.municipalities != null) {
                    that.municipalitySuggestions = that.filterMunicipalities(query, res);
                    ;
                }
            });
        }
    };
    EntityComponent.prototype.filterMunicipality = function (event) {
        var query = event.query;
        /*    this.http.get('lau.json').map(function(res:Response){
                  municipalityList = res.data;
                });
        
            this.municipalitySuggestions = this.filterMunicipalities(query, municipalityList);*/
        // TODO - In a real application, make a request to a remote url with the query
        // and return results, for demo we get it at client side.
        this.getMunicipalities(query);
    };
    EntityComponent.prototype.filterMunicipalities = function (query, municipalities) {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        var filtered = [];
        for (var i = 0; i < municipalities.length; i++) {
            var municipality = municipalities[i];
            if (municipality.NAME_1 != null) {
                if (municipality.NAME_1.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                    filtered.push(municipality);
                }
            }
        }
        return filtered;
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('entityDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4__entity_details_model__["a" /* EntityDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_4__entity_details_model__["a" /* EntityDetails */]) === 'function' && _a) || Object)
    ], EntityComponent.prototype, "entityDetails", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('completedSteps'), 
        __metadata('design:type', Array)
    ], EntityComponent.prototype, "completedSteps", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('activeSteps'), 
        __metadata('design:type', Array)
    ], EntityComponent.prototype, "activeSteps", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('currentStep'), 
        __metadata('design:type', Number)
    ], EntityComponent.prototype, "currentStep", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], EntityComponent.prototype, "onNext", void 0);
    EntityComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'entity-component', template: __webpack_require__(1181), providers: [__WEBPACK_IMPORTED_MODULE_2__entity_service__["a" /* EntityService */]] }), 
        __metadata('design:paramtypes', [(typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__entity_service__["a" /* EntityService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__entity_service__["a" /* EntityService */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _c) || Object])
    ], EntityComponent);
    return EntityComponent;
    var _a, _b, _c;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/entity.component.js.map

/***/ },

/***/ 1177:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(77);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(142);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return EntityService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var EntityService = (function () {
    function EntityService(http, uxService) {
        this.http = http;
        this.uxService = uxService;
    }
    EntityService.prototype.getMunicipalities = function (countryCode) {
        // TODO - Should call our internal REST API.
        return this
            .http
            .get(countryCode + '.json')
            .map(function (response) {
            return response.json();
        })
            .catch(this.uxService.handleError);
    };
    EntityService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _b) || Object])
    ], EntityService);
    return EntityService;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/entity.service.js.map

/***/ },

/***/ 1178:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__registration_component__ = __webpack_require__(1172);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__success_registration_component__ = __webpack_require__(1173);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return RegistrationRoutingModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var RegistrationRoutingModule = (function () {
    function RegistrationRoutingModule() {
    }
    RegistrationRoutingModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forChild([
                    {
                        path: '',
                        component: __WEBPACK_IMPORTED_MODULE_2__registration_component__["a" /* RegistrationComponent */],
                    },
                    {
                        path: 'success',
                        component: __WEBPACK_IMPORTED_MODULE_3__success_registration_component__["a" /* SuccessRegistrationComponent */],
                    }
                ])],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
        }), 
        __metadata('design:paramtypes', [])
    ], RegistrationRoutingModule);
    return RegistrationRoutingModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/registration-routing.module.js.map

/***/ },

/***/ 1179:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__ = __webpack_require__(1171);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__ = __webpack_require__(1170);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return ReviewComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ReviewComponent = (function () {
    function ReviewComponent() {
    }
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('entityDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__["a" /* EntityDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__["a" /* EntityDetails */]) === 'function' && _a) || Object)
    ], ReviewComponent.prototype, "entityDetails", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('beneficiaryDetails'), 
        __metadata('design:type', (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */]) === 'function' && _b) || Object)
    ], ReviewComponent.prototype, "beneficiaryDetails", void 0);
    ReviewComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'review-component', template: __webpack_require__(1184) }), 
        __metadata('design:paramtypes', [])
    ], ReviewComponent);
    return ReviewComponent;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/review.component.js.map

/***/ },

/***/ 1180:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <div id=\"component-title\">\n            <h3>{{ 'registration.beneficiary.title' | translate }}</h3>\n        </div>\n    </div>\n</div>\n<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <div id=\"component-subtitle\">\n            <h6>{{ 'registration.step2.instructions' | translate }}</h6>\n        </div>\n    </div>\n</div>\n<form>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-3 center\" style=\"text-align: center !important\">\n            <label><input type=\"radio\" name=\"mayor_or_representative\"\n                          [(ngModel)]=\"beneficiaryDetails.representativeSelected\" [value]=\"false\"> {{ 'immayor.option' |\n                translate}}</label>\n        </div>\n        <div class=\"ui-g-3 center\" style=\"text-align: center !important\">\n            <label><input type=\"radio\" name=\"mayor_or_representative\"\n                          [(ngModel)]=\"beneficiaryDetails.representativeSelected\" [value]=\"true\"> {{\n                'imrepresentative.option' | translate}}</label>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <!--\n      THIS PART BELOW IS ALWAYS DISPLAYED.\n    -->\n    <div>\n        <div class=\"ui-g\">\n            <div class=\"ui-g-7 center\" style=\"text-align: center !important\">\n                <hr>\n            </div>\n        </div>\n        <div class=\"ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <h3>{{ 'mayordetails.title' | translate }}</h3>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-3\">\n                <label for=\"treatment\">{{ 'treatment.label' | translate }}</label>\n                <select class=\"form-control\" name=\"treatment\" id=\"treatment\" [(ngModel)]=\"beneficiaryDetails.treatment\"\n                        required>\n                    <option value=\"mr\">{{ 'treatment.option1' | translate }}</option>\n                    <option value=\"ms\">{{ 'treatment.option2' | translate }}</option>\n                </select>\n            </div>\n            <div class=\"ui-g-1\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"name\">{{ 'name.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"name\" id=\"name\" [(ngModel)]=\"beneficiaryDetails.name\"\n                       required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"surname\">{{ 'surname.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"surname\" id=\"surname\"\n                       [(ngModel)]=\"beneficiaryDetails.surname\" required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"email\">{{ 'email.label' | translate }}</label>\n                <input class=\"form-control\" type=\"email\" name=\"email\" id=\"email\" [(ngModel)]=\"beneficiaryDetails.email\"\n                       required>\n                <label for=\"email\" class=\"field-desc\" style=\"margin-top: 10px;color: gray;\">{{ 'email.fielddesc' |\n                    translate }}</label>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"confirmemail\">{{ 'confirmemail.label' | translate }}</label>\n                <input class=\"form-control\" type=\"email\" name=\"confirmemail\" id=\"confirmemail\"\n                       [(ngModel)]=\"beneficiaryDetails.confirmEmail\" required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    <!--\n      THIS PART BELOW IS DISPLAYED ONLY IF YOU SELECT \"I'm a Mayor representative\".\n    -->\n    <!--\n    <div [ngClass]=\"{'hidden': !beneficiaryDetails.representativeSelected}\">\n        <div class=\"ui-g\">\n            <div class=\"ui-g-7 center\" style=\"text-align: center !important\">\n                <hr>\n            </div>\n        </div>\n        <div class=\"ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <h3>{{ 'representativedetails.title' | translate }}</h3>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-1\">\n                <label for=\"treatment_representative\">{{ 'treatment.label' | translate }}</label>\n                <select class=\"form-control\" name=\"treatment_representative\" id=\"treatment_representative\"\n                        [(ngModel)]=\"beneficiaryDetails.treatmentRepresentative\"\n                        required>\n                    <option value=\"mr\">{{ 'treatment.option1' | translate }}</option>\n                    <option value=\"ms\">{{ 'treatment.option2' | translate }}</option>\n                </select>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"name_representative\">{{ 'name.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"name_representative\" id=\"name_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.nameRepresentative\"\n                       required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"surname_representative\">{{ 'surname.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"surname_representative\" id=\"surname_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.surnameRepresentative\"\n                       required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"role_municipality\">{{ 'role.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"role_municipality\" id=\"role_municipality\"\n                       [(ngModel)]=\"beneficiaryDetails.roleRepresentative\"\n                       required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"email_representative\">{{ 'email.label' | translate }}</label>\n                <input class=\"form-control\" type=\"email\" name=\"email-representative\" id=\"email_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.emailRepresentative\"\n                       required>\n                <label for=\"email_representative\" class=\"field-desc\" style=\"margin-top: 10px;color: gray;\">{{\n                    'email.fielddesc' | translate }}</label>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"confirmemail_representative\">{{ 'confirmemail.label' | translate }}</label>\n                <input class=\"form-control\" type=\"email\" name=\"confirmemail_representative\"\n                       id=\"confirmemail_representative\" [(ngModel)]=\"beneficiaryDetails.confirmEmailRepresentative\"\n                       required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    -->\n    <!--\n      THIS PART BELOW DISPLAYS THE 'Back' AND 'Next' BUTTONS, WHICH ARE ALWAYS SHOWN.\n    -->\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button class=\"btn\">{{ 'back.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button class=\"btn btn-primary\" (click)=\"nextStep(2)\">{{ 'next.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>"

/***/ },

/***/ 1181:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-3\"></div>\n    <div class=\"ui-g-6\" style=\"text-align: center !important\">\n        <div id=\"component-title\">\n            <h3>{{ 'registration.entity.title' | translate }}</h3>\n        </div>\n    </div>\n    <div class=\"ui-g-3\"></div>\n</div>\n<div class=\"ui-g\">\n    <div class=\"ui-g-3\"></div>\n    <div class=\"ui-g-6\" style=\"text-align: center !important\">\n        <div id=\"component-subtitle\">\n            <h6>{{ 'registration.step1.instructions' | translate }}</h6>\n        </div>\n    </div>\n    <div class=\"ui-g-3\"></div>\n</div>\n<form>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <label for=\"country\">{{ 'country.label' | translate }}</label>\n            <p-autoComplete [(ngModel)]=\"country\" [suggestions]=\"countrySuggestions\"\n                            (completeMethod)=\"filterCountry($event)\" field=\"name\"\n                            [size]=\"30\" [minLength]=\"1\" class=\"form-control ng-pristine ng-valid ng-touched\"\n                            name=\"country\" id=\"country\" ngcontrol=\"country\" required>\n            </p-autoComplete>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <label for=\"municipality\">{{ 'municipality.label' | translate }}</label>\n            <p-autoComplete [(ngModel)]=\"municipality\" [suggestions]=\"municipalitySuggestions\"\n                            (completeMethod)=\"filterMunicipality($event)\"\n                            field=\"NAME_1\" [size]=\"30\" [minLength]=\"1\"\n                            class=\"form-control ng-pristine ng-valid ng-touched\" name=\"municipality\" id=\"municipality\"\n                            ngcontrol=\"municipality\" required>\n            </p-autoComplete>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-5\">\n            <label for=\"address\">{{ 'address.label' | translate }}</label>\n            <input class=\"form-control ng-pristine ng-valid ng-touched\" name=\"address\" id=\"address\" ngcontrol=\"address\"\n                   type=\"text\" [(ngModel)]=\"entityDetails.address\" required>\n        </div>\n        <div class=\"ui-g-1\">\n            <label for=\"number\">{{ 'number.label' | translate }}</label>\n            <input class=\"form-control ng-pristine ng-valid ng-touched\" name=\"number\" id=\"number\" ngcontrol=\"number\"\n                   type=\"text\" [(ngModel)]=\"entityDetails.number\" required>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <label for=\"postalCode\">{{ 'postal-code.label' | translate }}</label>\n            <input class=\"form-control ng-pristine ng-valid ng-touched\" name=\"postalCode\" id=\"postalCode\"\n                   ngcontrol=\"postalCode\" type=\"text\" [(ngModel)]=\"entityDetails.postalCode\"\n                   required>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button class=\"btn\">{{ 'back.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button class=\"btn btn-primary\" (click)=\"nextStep(1)\">{{ 'next.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>"

/***/ },

/***/ 1182:
/***/ function(module, exports) {

module.exports = "<ux-wizard-steps [isCustomContent]=\"true\">\n    <ux-wizard-step label=\"{{ 'registration.entity.title' | translate }}\" [isCompleted]=\"completed[0]\"\n                    [isActive]=\"active[0]\">\n        <uxWizardStepCustomContent>\n            <entity-component [entityDetails]=\"entityDetails\" [currentStep]=\"currentStep\"\n                              [completedSteps]=\"completedSteps\" [activeSteps]=\"activeSteps\"\n                              (onNext)=\"onNext($event)\"></entity-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'registration.beneficiary.title' | translate }}\" [isCompleted]=\"completed[1]\"\n                    [isActive]=\"active[1]\">\n        <uxWizardStepCustomContent>\n            <beneficiary-component [beneficiaryDetails]=\"beneficiaryDetails\" [currentStep]=\"currentStep\"\n                                   [completedSteps]=\"completedSteps\"\n                                   [activeSteps]=\"activeSteps\" (onNext)=\"onNext($event)\"></beneficiary-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'registration.review.title' | translate }}\" [isCompleted]=\"completed[2]\"\n                    [isActive]=\"active[2]\">\n        <uxWizardStepCustomContent>\n            <review-component [entityDetails]=\"entityDetails\"\n                              [beneficiaryDetails]=\"beneficiaryDetails\" (onNext)=\"onNext($event)\"></review-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n</ux-wizard-steps>"

/***/ },

/***/ 1183:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n  <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n    <i class=\"ion-checkmark-circled fa-2x\" data-pack=\"default\" data-tags=\"complete, finished, success, on\"></i>\n    <h2>{{ 'submitregistration.success.title' | translate }}</h2>\n    <br>\n    <p>{{ 'submitregistration.success.text.part1' | translate }}<br>{{ 'submitregistration.success.text.part2' | translate }}</p>\n    <p>{{ 'submitregistration.success.resendconfirm.part1' | translate }} <u><b>{{ 'submitregistration.success.resendconfirm.part2' | translate }}</b></u></p>\n    <br>\n    <button class=\"btn btn-primary\">{{ 'backtohome.button' | translate }}</button>\n  </div>\n</div>"

/***/ },

/***/ 1184:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <div id=\"component-title\">\n            <h3>{{ 'registration.review.title' | translate }}</h3>\n        </div>\n    </div>\n</div>\n<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <div id=\"component-subtitle\">\n            <h6>{{ 'registration.step3.instructions' | translate }}</h6>\n        </div>\n    </div>\n</div>\n<div class=\"ui-g\">\n    <div class=\"ui-g-7 center\" style=\"text-align: center !important\">\n        <div id=\"representantive_details\" [ngClass]=\"{'hidden': !beneficiaryDetails.representativeSelected}\">\n            <hr>\n            <span class=\"ui-g-3\">\n                <div><img src=\"https://www.amzaffiliatebootcamp.com/wp-content/uploads/2016/09/unknown.gif\"\n                          style=\"max-width: 100%;\"></div>\n                <div>{{ 'imrepresentative.option' | translate }}</div>\n            </span>\n            <span class=\"ui-g-9\" style=\"text-align: left;\">\n                <h3 class=\"ui-g-11\">{{ 'representativedetails.title' | translate }}</h3>\n                <a href=\"\" class=\"ui-g-1\">{{ 'edit.button' | translate }} <span\n                        class=\"glyphicon glyphicon-pencil\"></span></a>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'treatment.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.treatmentRepresentative}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'name.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.nameRepresentative}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'surname.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.surnameRepresentative}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'role.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.roleRepresentative}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'email.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.emailRepresentative}}</b></span>\n                </div>\n            </span>\n        </div>\n        <div id=\"mayor_details\">\n            <hr>\n            <span class=\"ui-g-3\"></span>\n            <span class=\"ui-g-9\" style=\"text-align: left;\">\n                <h3 class=\"ui-g-11\">{{ 'mayordetails.title' | translate }}</h3>\n                <a href=\"\" class=\"ui-g-1\">{{ 'edit.button' | translate }} <span\n                        class=\"glyphicon glyphicon-pencil\"></span></a>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'treatment.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.treatment}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'name.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.name}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'surname.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.surname}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'email.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{beneficiaryDetails.email}}</b></span>\n                </div>\n            </span>\n        </div>\n        <div id=\"entity_details\">\n            <hr>\n            <span class=\"ui-g-3\"></span>\n            <span class=\"ui-g-9\" style=\"text-align: left;\">\n                <h3 class=\"ui-g-11\">{{ 'legalentity.label' | translate }}</h3>\n                <a href=\"\" class=\"ui-g-1\">{{ 'edit.button' | translate }} <span\n                        class=\"glyphicon glyphicon-pencil\"></span></a>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'country.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{entityDetails.country}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'street.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{entityDetails.address}}, {{entityDetails.number}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'postal-code.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{entityDetails.postalCode}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'city.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>{{entityDetails.municipality}}</b></span>\n                </div>\n                <div>\n                  <span class=\"ui-g-5\">{{ 'province.label' | translate }}</span>\n                  <span class=\"ui-g-7\"><b>Barcelona</b></span>\n                </div>\n            </span>\n        </div>\n        <div id=\"confirm_checkboxes\">\n            <hr>\n            <div class=\"ui-g-12 checkbox\" style=\"text-align: left;\">\n                <span class=\"ui-g-3\"></span>\n                <label class=\"ui-g-6\" for=\"check_1\"><input type=\"checkbox\" id=\"check_1\"> {{\n                    'preview.registration.check1' | translate }}</label>\n                <span class=\"ui-g-3\"></span>\n            </div>\n            <div class=\"ui-g-12\" style=\"text-align: left;\">\n                <span class=\"ui-g-3\"></span>\n                <label class=\"ui-g-6\" for=\"check_2\"><input type=\"checkbox\" id=\"check_2\"> {{\n                    'preview.registration.check2' | translate }}</label>\n                <span class=\"ui-g-3\"></span>\n            </div>\n            <div class=\"ui-g-12\" style=\"text-align: left;\">\n                <span class=\"ui-g-3\"></span>\n                <label class=\"ui-g-6\" for=\"check_3\"><input type=\"checkbox\" id=\"check_3\"> {{\n                    'preview.registration.check3' | translate }}</label>\n                <span class=\"ui-g-3\"></span>\n            </div>\n        </div>\n    </div>\n</div>\n<div class=\"form-group ui-g\">\n    <div class=\"ui-g-4\"></div>\n    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n        <button class=\"btn\">{{ 'cancel.button' | translate }}</button>\n    </div>\n    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n        <button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#confirmingModal\">{{\n            'submitregistration.button' | translate }}\n        </button>\n    </div>\n    <div class=\"ui-g-4\"></div>\n</div>\n<div id=\"confirmingModal\" class=\"modal fade\" role=\"dialog\">\n    <div class=\"modal-content\">\n        <div class=\"modal-body\">\n            <h3>Confirming Data, please wait...</h3>\n            <p>Your registration to Wifi4EU is in the process of being submitted.<br>Please don't close this window.</p>\n        </div>\n    </div>\n</div>"

/***/ }

});
//# sourceMappingURL=0.bundle.map