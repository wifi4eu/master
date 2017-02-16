webpackJsonp([0,4],{

/***/ 1176:
/***/ function(module, exports, __webpack_require__) {

"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__(523);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__registration_routing_module__ = __webpack_require__(1185);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__registration_component__ = __webpack_require__(1179);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__entity_entity_component__ = __webpack_require__(1183);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__beneficiary_beneficiary_component__ = __webpack_require__(1182);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__review_review_component__ = __webpack_require__(1181);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__success_registration_component__ = __webpack_require__(1180);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__review_success_component__ = __webpack_require__(1187);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__review_failure_component__ = __webpack_require__(1186);
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
                __WEBPACK_IMPORTED_MODULE_3__registration_component__["a" /* RegistrationComponent */], __WEBPACK_IMPORTED_MODULE_4__entity_entity_component__["a" /* EntityComponent */], __WEBPACK_IMPORTED_MODULE_5__beneficiary_beneficiary_component__["a" /* BeneficiaryComponent */], __WEBPACK_IMPORTED_MODULE_6__review_review_component__["a" /* ReviewComponent */], __WEBPACK_IMPORTED_MODULE_7__success_registration_component__["a" /* SuccessRegistrationComponent */], __WEBPACK_IMPORTED_MODULE_8__review_success_component__["a" /* SuccessComponent */], __WEBPACK_IMPORTED_MODULE_9__review_failure_component__["a" /* FailureComponent */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_3__registration_component__["a" /* RegistrationComponent */]]
        }), 
        __metadata('design:paramtypes', [])
    ], RegistrationModule);
    return RegistrationModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/registration.module.js.map

/***/ },

/***/ 1177:
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

/***/ 1178:
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

/***/ 1179:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__ = __webpack_require__(1178);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__ = __webpack_require__(1177);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__review_review_component__ = __webpack_require__(1181);
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
        this.successRegistration = false;
        this.failureRegistration = false;
        console.log("Constructor");
        this.entityDetails = new __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__["a" /* EntityDetails */]();
        this.beneficiaryDetails = new __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */]();
        this.completed = [false, false, false];
        this.active = [true, false, false];
    }
    RegistrationComponent.prototype.onNext = function (step) {
        // The review child component must check the country and municipality objects to display them correctly.
        this.childReview.checkObjects();
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
        console.log("Completed", this.completed);
        console.log("Active", this.active);
    };
    RegistrationComponent.prototype.gotoStep = function (step) {
        switch (step) {
            case 1:
                this.completed = [false, false, false];
                this.active = [true, false, false];
                break;
            case 2:
                this.completed = [true, false, false];
                this.active = [false, true, false];
                break;
            case 3:
                this.completed = [true, true, false];
                this.active = [false, false, true];
                break;
        }
    };
    RegistrationComponent.prototype.onBack = function (step) {
        this.completed[step - 1] = false;
        this.active[step - 1] = true;
        this.active[step] = false;
        console.log("Completed", this.completed);
        console.log("Active", this.active);
    };
    RegistrationComponent.prototype.onSuccess = function (value) {
        this.successRegistration = value;
    };
    RegistrationComponent.prototype.onFailure = function (value) {
        this.failureRegistration = value;
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_3__review_review_component__["a" /* ReviewComponent */]), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__review_review_component__["a" /* ReviewComponent */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__review_review_component__["a" /* ReviewComponent */]) === 'function' && _a) || Object)
    ], RegistrationComponent.prototype, "childReview", void 0);
    RegistrationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__(1190) }), 
        __metadata('design:paramtypes', [])
    ], RegistrationComponent);
    return RegistrationComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/registration.component.js.map

/***/ },

/***/ 1180:
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
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__(1191) }), 
        __metadata('design:paramtypes', [])
    ], SuccessRegistrationComponent);
    return SuccessRegistrationComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/success.registration.component.js.map

/***/ },

/***/ 1181:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__ = __webpack_require__(1178);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__ = __webpack_require__(1177);
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
        this.gotoStep = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onSuccess = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onFailure = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.displayConfirmingData = false;
        this.confirmingData = true;
        this.checkboxes = [false, false, false];
    }
    ReviewComponent.prototype.submitRegistration = function () {
        var that = this;
        this.displayConfirmingData = true;
        setTimeout(function () {
            that.displayConfirmingData = false;
            that.onSuccess.emit(true);
        }, 2000);
    };
    ReviewComponent.prototype.editStep = function (step) {
        this.gotoStep.emit(step);
    };
    ReviewComponent.prototype.checkObjects = function () {
        this.countryField = this.entityDetails.country;
        this.municipalityField = this.entityDetails.municipality;
        if (typeof this.entityDetails.country != "string") {
            this.countryField = this.entityDetails.country.name;
            this.municipalityField = this.entityDetails.municipality.NAME_1;
        }
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('entityDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__["a" /* EntityDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__entity_entity_details_model__["a" /* EntityDetails */]) === 'function' && _a) || Object)
    ], ReviewComponent.prototype, "entityDetails", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('beneficiaryDetails'), 
        __metadata('design:type', (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */]) === 'function' && _b) || Object)
    ], ReviewComponent.prototype, "beneficiaryDetails", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], ReviewComponent.prototype, "gotoStep", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], ReviewComponent.prototype, "onSuccess", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], ReviewComponent.prototype, "onFailure", void 0);
    ReviewComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'review-component', template: __webpack_require__(1193) }), 
        __metadata('design:paramtypes', [])
    ], ReviewComponent);
    return ReviewComponent;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/review.component.js.map

/***/ },

/***/ 1182:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__beneficiary_details_model__ = __webpack_require__(1177);
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
        this.mayorEmailMatches = false;
        this.representativeEmailMatches = false;
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onBack = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    BeneficiaryComponent.prototype.onSubmit = function (step) {
        this.onNext.emit(step);
    };
    BeneficiaryComponent.prototype.stepBack = function (step) {
        this.onBack.emit(step);
    };
    BeneficiaryComponent.prototype.checkIfMayorEmailMatches = function () {
        if (this.beneficiaryDetails.email === this.beneficiaryDetails.confirmEmail) {
            this.mayorEmailMatches = true;
        }
        else {
            this.mayorEmailMatches = false;
        }
    };
    BeneficiaryComponent.prototype.checkIfRepresentativeEmailMatches = function () {
        if (this.beneficiaryDetails.emailRepresentative === this.beneficiaryDetails.confirmEmailRepresentative) {
            this.representativeEmailMatches = true;
        }
        else {
            this.representativeEmailMatches = false;
        }
    };
    BeneficiaryComponent.prototype.allEmailsMatch = function () {
        if (this.beneficiaryDetails.representativeSelected && !this.representativeEmailMatches) {
            return false;
        }
        if (!this.mayorEmailMatches) {
            return false;
        }
        return true;
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('beneficiaryDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__beneficiary_details_model__["a" /* BeneficiaryDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__beneficiary_details_model__["a" /* BeneficiaryDetails */]) === 'function' && _a) || Object)
    ], BeneficiaryComponent.prototype, "beneficiaryDetails", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], BeneficiaryComponent.prototype, "onNext", void 0);
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], BeneficiaryComponent.prototype, "onBack", void 0);
    BeneficiaryComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'beneficiary-component', template: __webpack_require__(1188)
        }), 
        __metadata('design:paramtypes', [])
    ], BeneficiaryComponent);
    return BeneficiaryComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/beneficiary.component.js.map

/***/ },

/***/ 1183:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(77);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(142);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__entity_service__ = __webpack_require__(1184);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__entity_details_model__ = __webpack_require__(1178);
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
    function EntityComponent(http, entityService, uxService) {
        this.http = http;
        this.entityService = entityService;
        this.uxService = uxService;
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    EntityComponent.prototype.checkCountry = function () {
        if (typeof this.entityDetails.country === "string") {
            var countryName = this.entityDetails.country;
            var countries = this.countries;
            for (var i in countries) {
                if (countries[i].name.toLowerCase() == countryName.toLowerCase()) {
                    this.entityDetails.country = countries[i];
                    break;
                }
            }
        }
    };
    EntityComponent.prototype.onSubmit = function (step) {
        this.onNext.emit(step);
    };
    EntityComponent.prototype.filterCountry = function (event) {
        var _this = this;
        // TODO - In a real application, make a request to a remote url with the query
        // and return results, for demo we get it at client side.
        this.entityService.getCountries().subscribe(function (countries) {
            _this.countries = countries;
            _this.countrySuggestions = _this.filterCountries(event.query, countries);
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get countries, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get countries');
        });
        /*this.entityService
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
    EntityComponent.prototype.filterMunicipality = function (event) {
        // TODO - In a real application, make a request to a remote url with the query
        // and return filtered results, for demo we filter at client side.
        var query = event.query;
        this.getMunicipalities(query);
        /*this.http.get('lau.json').map(function(res:Response){
         municipalityList = res.data;
         });*/
    };
    EntityComponent.prototype.getMunicipalities = function (query) {
        var _this = this;
        if (this.entityDetails.country != null) {
            this.entityService.getMunicipalities(this.entityDetails.country.code).subscribe(function (municipalities) {
                if (municipalities != null) {
                    _this.municipalitySuggestions = _this.filterMunicipalities(query, municipalities);
                }
            });
        }
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
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], EntityComponent.prototype, "onNext", void 0);
    EntityComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'entity-component',
            template: __webpack_require__(1189),
            providers: [__WEBPACK_IMPORTED_MODULE_3__entity_service__["a" /* EntityService */]]
        }), 
        __metadata('design:paramtypes', [(typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__entity_service__["a" /* EntityService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__entity_service__["a" /* EntityService */]) === 'function' && _c) || Object, (typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _d) || Object])
    ], EntityComponent);
    return EntityComponent;
    var _a, _b, _c, _d;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/entity.component.js.map

/***/ },

/***/ 1184:
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
    EntityService.prototype.getCountries = function () {
        // TODO - Should call our internal REST API.
        return this.http.get('/api/countries').map(function (response) {
            return response.json();
        }).catch(this.uxService.handleError);
    };
    EntityService.prototype.getMunicipalities = function (countryCode) {
        // TODO - Should call our internal REST API.
        return this.http.get('/api/countries/' + countryCode + '/municipalities').map(function (response) {
            return response.json();
        }).catch(this.uxService.handleError);
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

/***/ 1185:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__registration_component__ = __webpack_require__(1179);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__success_registration_component__ = __webpack_require__(1180);
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

/***/ 1186:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return FailureComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var FailureComponent = (function () {
    function FailureComponent() {
    }
    FailureComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'failure-component', template: __webpack_require__(1192) }), 
        __metadata('design:paramtypes', [])
    ], FailureComponent);
    return FailureComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/failure.component.js.map

/***/ },

/***/ 1187:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return SuccessComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var SuccessComponent = (function () {
    function SuccessComponent() {
    }
    SuccessComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'success-component', template: __webpack_require__(1194) }), 
        __metadata('design:paramtypes', [])
    ], SuccessComponent);
    return SuccessComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/success.component.js.map

/***/ },

/***/ 1188:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <div id=\"component-title\">\n            <h3>{{ 'registration.beneficiary.title' | translate }}</h3>\n        </div>\n    </div>\n</div>\n<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <div id=\"component-subtitle\">\n            <h6>{{ 'registration.step2.instructions' | translate }}</h6>\n        </div>\n    </div>\n</div>\n<form (ngSubmit)=\"onSubmit(2)\" #entityForm=\"ngForm\">\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-3 center\" style=\"text-align: center !important\">\n            <label>\n                <input type=\"radio\" name=\"mayor_or_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.representativeSelected\"\n                       [value]=\"false\"> {{ 'immayor.option' |\n                translate}}\n            </label>\n        </div>\n        <div class=\"ui-g-3 center\" style=\"text-align: center !important\">\n            <label><input type=\"radio\" name=\"mayor_or_representative\"\n                          [(ngModel)]=\"beneficiaryDetails.representativeSelected\"\n                          [value]=\"true\"> {{\n                'imrepresentative.option' | translate}}</label>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <!--\n      THIS PART BELOW IS ALWAYS DISPLAYED.\n    -->\n    <div>\n        <div class=\"ui-g\">\n            <div class=\"ui-g-7 center\" style=\"text-align: center !important\">\n                <hr>\n            </div>\n        </div>\n        <div class=\"ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <h3>{{ 'mayordetails.title' | translate }}</h3>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-3\">\n                <label for=\"treatment\">{{ 'treatment.label' | translate\n                    }}</label>\n                <select class=\"form-control\" name=\"treatment\" id=\"treatment\"\n                        [(ngModel)]=\"beneficiaryDetails.treatment\"\n                        required>\n                    <option value=\"mr\">{{ 'treatment.option1' | translate }}\n                    </option>\n                    <option value=\"ms\">{{ 'treatment.option2' | translate }}\n                    </option>\n                </select>\n            </div>\n            <div class=\"ui-g-1\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"name\">{{ 'name.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"name\" id=\"name\"\n                       [(ngModel)]=\"beneficiaryDetails.name\"\n                       required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"surname\">{{ 'surname.label' | translate }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"surname\"\n                       id=\"surname\"\n                       [(ngModel)]=\"beneficiaryDetails.surname\" required>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"email\">{{ 'email.label' | translate }}</label>\n                <input class=\"form-control\" type=\"email\" name=\"email\" id=\"email\"\n                       [(ngModel)]=\"beneficiaryDetails.email\"\n                       (keyup)=\"checkIfMayorEmailMatches()\" required>\n                <label for=\"email\" class=\"field-desc\"\n                       style=\"margin-top: 10px;color: gray;\">{{\n                    'email.fielddesc' |\n                    translate }}</label>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"confirmemail\">{{ 'confirmemail.label' | translate\n                    }}</label>\n                <input class=\"form-control\" type=\"email\" name=\"confirmemail\"\n                       id=\"confirmemail\" ngcontrol=\"confirmemail\"\n                       #confirmemail=\"ngModel\"\n                       [(ngModel)]=\"beneficiaryDetails.confirmEmail\" (keyup)=\"checkIfMayorEmailMatches()\" required>\n                <div [hidden]=\"mayorEmailMatches || confirmemail.pristine\"\n                     class=\"alert alert-info\">The email\n                    information must\n                    match\n                </div>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    <!--\n      THIS PART BELOW IS DISPLAYED ONLY IF YOU SELECT \"I'm a Mayor representative\".\n    -->\n    <div [ngClass]=\"{'hidden': !beneficiaryDetails.representativeSelected}\">\n        <div class=\"ui-g\">\n            <div class=\"ui-g-7 center\" style=\"text-align: center !important\">\n                <hr>\n            </div>\n        </div>\n        <div class=\"ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <h3>{{ 'representativedetails.title' | translate }}</h3>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-1\">\n                <label for=\"treatment_representative\">{{ 'treatment.label' |\n                    translate }}</label>\n                <select class=\"form-control\" name=\"treatment_representative\"\n                        id=\"treatment_representative\"\n                        [(ngModel)]=\"beneficiaryDetails.treatmentRepresentative\"\n                        [required]=\"beneficiaryDetails.representativeSelected\">\n                    <option value=\"mr\">{{ 'treatment.option1' | translate }}\n                    </option>\n                    <option value=\"ms\">{{ 'treatment.option2' | translate }}\n                    </option>\n                </select>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"name_representative\">{{ 'name.label' | translate\n                    }}</label>\n                <input class=\"form-control\" type=\"text\"\n                       name=\"name_representative\" id=\"name_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.nameRepresentative\"\n                       [required]=\"beneficiaryDetails.representativeSelected\">\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"surname_representative\">{{ 'surname.label' |\n                    translate }}</label>\n                <input class=\"form-control\" type=\"text\"\n                       name=\"surname_representative\" id=\"surname_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.surnameRepresentative\"\n                       [required]=\"beneficiaryDetails.representativeSelected\">\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"role_municipality\">{{ 'role.label' | translate\n                    }}</label>\n                <input class=\"form-control\" type=\"text\" name=\"role_municipality\"\n                       id=\"role_municipality\"\n                       [(ngModel)]=\"beneficiaryDetails.roleRepresentative\"\n                       [required]=\"beneficiaryDetails.representativeSelected\">\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"email_representative\">{{ 'email.label' | translate\n                    }}</label>\n                <input class=\"form-control\" type=\"email\"\n                       name=\"email-representative\" id=\"email_representative\"\n                       [(ngModel)]=\"beneficiaryDetails.emailRepresentative\"\n                       (keyup)=\"checkIfRepresentativeEmailMatches()\"\n                       [required]=\"beneficiaryDetails.representativeSelected\">\n                <label for=\"email_representative\" class=\"field-desc\"\n                       style=\"margin-top: 10px;color: gray;\">{{\n                    'email.fielddesc' | translate }}</label>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-g-3\"></div>\n            <div class=\"ui-g-6\">\n                <label for=\"confirmemail_representative\">{{ 'confirmemail.label'\n                    | translate }}</label>\n                <input class=\"form-control\" type=\"email\"\n                       name=\"confirmemail_representative\"\n                       id=\"confirmemail_representative\" ngcontrol=\"confirmemail_representative\"\n                       #confirmemail_representative=\"ngModel\"\n                       [(ngModel)]=\"beneficiaryDetails.confirmEmailRepresentative\"\n                       (keyup)=\"checkIfRepresentativeEmailMatches()\"\n                       [required]=\"beneficiaryDetails.representativeSelected\">\n                <div [hidden]=\"representativeEmailMatches || confirmemail_representative.pristine\"\n                     class=\"alert alert-info\">The email\n                    information must\n                    match\n                </div>\n            </div>\n            <div class=\"ui-g-3\"></div>\n        </div>\n    </div>\n    <!--\n      THIS PART BELOW DISPLAYS THE 'Back' AND 'Next' BUTTONS, WHICH ARE ALWAYS SHOWN.\n    -->\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn\" (click)=\"stepBack(1)\">{{ 'back.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary\"\n                    [disabled]=\"!entityForm.form.valid || !allEmailsMatch()\">{{\n                'next.button' |\n                translate }}\n            </button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>"

/***/ },

/***/ 1189:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-3\"></div>\n    <div class=\"ui-g-6\" style=\"text-align: center !important\">\n        <div id=\"component-title\">\n            <h3>{{ 'registration.entity.title' | translate }}</h3>\n        </div>\n    </div>\n    <div class=\"ui-g-3\"></div>\n</div>\n<div class=\"ui-g\">\n    <div class=\"ui-g-3\"></div>\n    <div class=\"ui-g-6\" style=\"text-align: center !important\">\n        <div id=\"component-subtitle\">\n            <h6>{{ 'registration.step1.instructions' | translate }}</h6>\n        </div>\n    </div>\n    <div class=\"ui-g-3\"></div>\n</div>\n<form (ngSubmit)=\"onSubmit(1)\" #entityForm=\"ngForm\">\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <label for=\"country\">{{ 'country.label' | translate }}</label>\n                <p-autoComplete [(ngModel)]=\"entityDetails.country\"\n                                [suggestions]=\"countrySuggestions\"\n                                (completeMethod)=\"filterCountry($event)\"\n                                field=\"name\"\n                                [size]=\"30\" [minLength]=\"1\" class=\"form-control\"\n                                name=\"country\" ngcontrol=\"country\"\n                                #country=\"ngModel\" required>\n                </p-autoComplete>\n                <div [hidden]=\"country.valid || country.pristine\"\n                     class=\"alert alert-danger\">Country is required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <label for=\"municipality\">{{ 'municipality.label' | translate\n                    }}</label>\n                <p-autoComplete [(ngModel)]=\"entityDetails.municipality\"\n                                [suggestions]=\"municipalitySuggestions\"\n                                (completeMethod)=\"filterMunicipality($event)\"\n                                field=\"NAME_1\"\n                                [size]=\"30\" [minLength]=\"1\" class=\"form-control\"\n                                name=\"municipality\" ngcontrol=\"municipality\"\n                                #municipality=\"ngModel\"\n                                (keydown)=\"checkCountry()\" required>\n                </p-autoComplete>\n                <div [hidden]=\"municipality.valid || municipality.pristine\"\n                     class=\"alert alert-danger\">Municipality is\n                    required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-5\">\n            <div class=\"form-group\">\n                <label for=\"address\">{{ 'address.label' | translate }}</label>\n                <input type=\"text\" [(ngModel)]=\"entityDetails.address\"\n                       class=\"form-control\"\n                       name=\"address\" ngcontrol=\"address\" #address=\"ngModel\"\n                       required>\n                <div [hidden]=\"address.valid || address.pristine\"\n                     class=\"alert alert-danger\">Address is required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-1\">\n            <div class=\"form-group\">\n                <label for=\"number\">{{ 'number.label' | translate }}</label>\n                <input type=\"number\" min=\"1\" [(ngModel)]=\"entityDetails.number\"\n                       class=\"form-control\"\n                       name=\"number\" ngcontrol=\"number\" #number=\"ngModel\"\n                       required>\n                <div [hidden]=\"number.valid || number.pristine\"\n                     class=\"alert alert-danger\">Address is required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <label for=\"postalCode\">{{ 'postal-code.label' | translate\n                    }}</label>\n                <input type=\"text\" [(ngModel)]=\"entityDetails.postalCode\"\n                       class=\"form-control\"\n                       name=\"postalCode\" ngcontrol=\"postalCode\"\n                       #postalCode=\"ngModel\" required>\n                <div [hidden]=\"postalCode.valid || postalCode.pristine\"\n                     class=\"alert alert-danger\">Postal code is\n                    required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn\">{{ 'back.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary\"\n                    [disabled]=\"!entityForm.form.valid\">{{ 'next.button' |\n                translate }}\n            </button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>\n"

/***/ },

/***/ 1190:
/***/ function(module, exports) {

module.exports = "<ux-wizard-steps [isCustomContent]=\"true\" *ngIf=\"!successRegistration && !failureRegistration\">\n    <ux-wizard-step label=\"{{ 'registration.entity.title' | translate }}\"\n                    [isCompleted]=\"completed[0]\"\n                    [isActive]=\"active[0]\">\n        <uxWizardStepCustomContent>\n            <entity-component [entityDetails]=\"entityDetails\"\n                              (onNext)=\"onNext($event)\"\n                              (onBack)=\"onBack($event)\"></entity-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'registration.beneficiary.title' | translate }}\"\n                    [isCompleted]=\"completed[1]\"\n                    [isActive]=\"active[1]\">\n        <uxWizardStepCustomContent>\n            <beneficiary-component [beneficiaryDetails]=\"beneficiaryDetails\"\n                                   (onNext)=\"onNext($event)\"\n                                   (onBack)=\"onBack($event)\"></beneficiary-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'registration.review.title' | translate }}\"\n                    [isCompleted]=\"completed[2]\"\n                    [isActive]=\"active[2]\">\n        <uxWizardStepCustomContent>\n            <review-component [entityDetails]=\"entityDetails\"\n                              [beneficiaryDetails]=\"beneficiaryDetails\"\n                              (onNext)=\"onNext($event)\"\n                              (gotoStep)=\"gotoStep($event)\" (onSuccess)=\"onSuccess($event)\"\n                              (onFailure)=\"onFailure($event)\"></review-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n</ux-wizard-steps>\n<success-component\n        *ngIf=\"successRegistration\"></success-component>\n<failure-component *ngIf=\"failureRegistration\"></failure-component>\n<failure-component *ngIf=\"failureRegistration\"></failure-component>\n"

/***/ },

/***/ 1191:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n  <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n    <i class=\"ion-checkmark-circled fa-2x\" data-pack=\"default\" data-tags=\"complete, finished, success, on\"></i>\n    <h2>{{ 'submitregistration.success.title' | translate }}</h2>\n    <br>\n    <p>{{ 'submitregistration.success.text.part1' | translate }}<br>{{ 'submitregistration.success.text.part2' | translate }}</p>\n    <p>{{ 'submitregistration.success.resendconfirm.part1' | translate }} <u><b>{{ 'submitregistration.success.resendconfirm.part2' | translate }}</b></u></p>\n    <br>\n    <button class=\"btn btn-primary\">{{ 'backtohome.button' | translate }}</button>\n  </div>\n</div>"

/***/ },

/***/ 1192:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <i class=\"zmdi zmdi-close-circle fa-3x\"></i><br>\n        <h2>Failure title!</h2>\n        <br>\n        <p>{{ 'submitregistration.success.text.part1' | translate }}<br>{{ 'submitregistration.success.text.part2' |\n            translate }}</p>\n        <p>{{ 'submitregistration.success.resendconfirm.part1' | translate }} <u><b>{{\n            'submitregistration.success.resendconfirm.part2' | translate }}</b></u></p>\n        <br>\n        <button class=\"btn btn-primary\">{{ 'backtohome.button' | translate }}</button>\n    </div>\n\n</div>"

/***/ },

/***/ 1193:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g-1\"></div>\n<div class=\"ui-g-10 center\">\n    <div class=\"ui-g-12 center\">\n        <div id=\"component-title\">\n            <h3>{{ 'registration.review.title' | translate }}</h3>\n        </div>\n    </div>\n    <div class=\"ui-g-12 center\">\n        <div id=\"component-subtitle\">\n            <h6>{{ 'registration.step3.instructions' | translate }}</h6>\n        </div>\n    </div>\n    <div class=\"ui-g-12 center\">\n        <div id=\"representantive_details\" class=\"ui-g-12\"\n             [ngClass]=\"{'hidden': !beneficiaryDetails.representativeSelected}\">\n            <hr>\n            <span class=\"ui-g-1\"></span>\n            <span class=\"ui-g-10\" style=\"text-align: left;\">\n                    <h3 class=\"ui-g-11\">{{ 'representativedetails.title' | translate }}</h3>\n                    <a class=\"ui-g-1\" (click)=\"editStep(2)\">{{ 'edit.button' | translate }} <span\n                            class=\"glyphicon glyphicon-pencil\"></span></a>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'treatment.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.treatmentRepresentative}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'name.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.nameRepresentative}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'surname.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.surnameRepresentative}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'role.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.roleRepresentative}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'email.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.emailRepresentative}}</b></span>\n                    </div>\n                </span>\n            <span class=\"ui-g-1\"></span>\n        </div>\n        <div id=\"mayor_details\" class=\"ui-g-12\">\n            <hr>\n            <span class=\"ui-g-1\"></span>\n            <span class=\"ui-g-10\" style=\"text-align: left;\">\n                    <h3 class=\"ui-g-11\">{{ 'mayordetails.title' | translate }}</h3>\n                    <a class=\"ui-g-1\" (click)=\"editStep(2)\">{{ 'edit.button' | translate }} <span\n                            class=\"glyphicon glyphicon-pencil\"></span></a>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'treatment.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.treatment}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'name.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.name}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'surname.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.surname}}</b></span>\n                    </div>\n                    <div>\n                      <span class=\"ui-g-4\">{{ 'email.label' | translate }}</span>\n                      <span class=\"ui-g-8\"><b>{{beneficiaryDetails.email}}</b></span>\n                    </div>\n                </span>\n            <span class=\"ui-g-1\"></span>\n        </div>\n        <div id=\"entity_details\" class=\"ui-g-12\">\n            <hr>\n            <span class=\"ui-g-1\"></span>\n            <span class=\"ui-g-10\" style=\"text-align: left;\">\n                <h3 class=\"ui-g-11\">{{ 'legalentity.label' | translate }}</h3>\n                <a class=\"ui-g-1\" (click)=\"editStep(1)\">{{ 'edit.button' | translate }} <span\n                        class=\"glyphicon glyphicon-pencil\"></span></a>\n                <div>\n                    <span class=\"ui-g-4\">{{ 'country.label' | translate }}</span>\n                    <span class=\"ui-g-8\"><b>{{countryField}}</b></span>\n                </div>\n                <div>\n                    <span class=\"ui-g-4\">{{ 'municipality.label' | translate }}</span>\n                    <span class=\"ui-g-8\"><b>{{municipalityField}}</b></span>\n                </div>\n                <div>\n                    <span class=\"ui-g-4\">{{ 'address.label' | translate }}</span>\n                    <span class=\"ui-g-8\"><b>{{entityDetails.address}}</b></span>\n                </div>\n                <div>\n                    <span class=\"ui-g-4\">{{ 'number.label' | translate }}</span>\n                    <span class=\"ui-g-8\"><b>{{entityDetails.number}}</b></span>\n                </div>\n                <div>\n                    <span class=\"ui-g-4\">{{ 'postal-code.label' | translate }}</span>\n                    <span class=\"ui-g-8\"><b>{{entityDetails.postalCode}}</b></span>\n                </div>\n            </span>\n            <span class=\"ui-g-1\"></span>\n        </div>\n        <div id=\"confirm_checkboxes\" class=\"ui-g-12\">\n            <hr>\n            <div class=\"ui-g-12 checkbox\" style=\"text-align: left;\">\n                <span class=\"ui-g-3\"></span>\n                <label class=\"ui-g-6\" for=\"check_1\"><input type=\"checkbox\" id=\"check_1\" [(ngModel)]=\"checkboxes[0]\"> {{\n                    'preview.registration.check1' | translate }}</label>\n                <span class=\"ui-g-3\"></span>\n            </div>\n            <div class=\"ui-g-12\" style=\"text-align: left;\">\n                <span class=\"ui-g-3\"></span>\n                <label class=\"ui-g-6\" for=\"check_2\"><input type=\"checkbox\" id=\"check_2\" [(ngModel)]=\"checkboxes[1]\"> {{\n                    'preview.registration.check2' | translate }}</label>\n                <span class=\"ui-g-3\"></span>\n            </div>\n            <div class=\"ui-g-12\" style=\"text-align: left;\">\n                <span class=\"ui-g-3\"></span>\n                <label class=\"ui-g-6\" for=\"check_3\"><input type=\"checkbox\" id=\"check_3\" [(ngModel)]=\"checkboxes[2]\"> {{\n                    'preview.registration.check3' | translate }}</label>\n                <span class=\"ui-g-3\"></span>\n            </div>\n        </div>\n        <div class=\"form-group ui-g-12\">\n            <div class=\"ui-g-4\"></div>\n            <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                <button class=\"btn\">{{ 'cancel.button' | translate }}</button>\n            </div>\n            <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                <button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#confirmingModal\"\n                        (click)=\"submitRegistration()\" [disabled]=\"!checkboxes[0] || !checkboxes[1] || !checkboxes[2]\">\n                    {{'submitregistration.button' | translate }}\n                </button>\n            </div>\n            <div class=\"ui-g-4\"></div>\n        </div>\n    </div>\n</div>\n<div class=\"ui-g-1\"></div>\n<p-dialog [(visible)]=\"displayConfirmingData\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\"\n          [draggable]=\"false\" [closable]=\"false\" [closeOnEscape]=\"false\">\n    <p class=\"ModalLoaderDots\"><span>.</span><span>.</span><span>.</span></p>\n    <h1 class=\"Modalh1Confirmation\">Confirming Data, please wait...</h1>\n    <p class=\"ModalpConfirmation\">Your registration to Wifi4EU is in the process of being submitted.<br>Please don't\n        close this window.</p>\n</p-dialog>\n\n"

/***/ },

/***/ 1194:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <i class=\"zmdi zmdi-check-circle fa-3x\"></i><br>\n        <h2>{{ 'submitregistration.success.title' | translate }}</h2>\n        <br>\n        <p>{{ 'submitregistration.success.text.part1' | translate }}<br>{{ 'submitregistration.success.text.part2' |\n            translate }}</p>\n        <p>{{ 'submitregistration.success.resendconfirm.part1' | translate }} <u><b>{{\n            'submitregistration.success.resendconfirm.part2' | translate }}</b></u></p>\n        <br>\n        <button class=\"btn btn-primary\">{{ 'backtohome.button' | translate }}</button>\n    </div>\n</div>"

/***/ }

});
//# sourceMappingURL=0.bundle.map