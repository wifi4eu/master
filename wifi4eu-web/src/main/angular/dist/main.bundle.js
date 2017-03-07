webpackJsonp([2,4],{

/***/ 1221:
/***/ function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(530);


/***/ },

/***/ 437:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_models_user_details_model__ = __webpack_require__(537);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_services_user_service__ = __webpack_require__(538);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return LoginComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LoginComponent = (function () {
    function LoginComponent(userService, uxService) {
        this.userService = userService;
        this.uxService = uxService;
        this.displayConfirmingData = false;
        this.userDetails = new __WEBPACK_IMPORTED_MODULE_2__shared_models_user_details_model__["a" /* UserDetails */]();
    }
    LoginComponent.prototype.onSubmit = function () {
        var _this = this;
        this.displayConfirmingData = true;
        this.userService.getUser(this.userDetails).subscribe(function (data) {
            _this.displayConfirmingData = false;
            if (data == "error") {
                _this.uxService.growl({
                    severity: 'error',
                    summary: 'ERROR',
                    detail: 'Could not login, with these user password'
                });
                console.log('ERROR: Could not login, with these user password');
            }
            else if (data == "success") {
                _this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'Login success'
                });
                console.log('SUCCESS: Login success');
            }
        }, function (error) {
            _this.displayConfirmingData = false;
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get countries, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get countries', error);
        });
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('userDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__shared_models_user_details_model__["a" /* UserDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__shared_models_user_details_model__["a" /* UserDetails */]) === 'function' && _a) || Object)
    ], LoginComponent.prototype, "userDetails", void 0);
    LoginComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'login-component',
            template: __webpack_require__(927),
            providers: [__WEBPACK_IMPORTED_MODULE_3__shared_services_user_service__["a" /* UserService */]]
        }), 
        __metadata('design:paramtypes', [(typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_services_user_service__["a" /* UserService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__shared_services_user_service__["a" /* UserService */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _c) || Object])
    ], LoginComponent);
    return LoginComponent;
    var _a, _b, _c;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/login.component.js.map

/***/ },

/***/ 438:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return MapComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var MapComponent = (function () {
    function MapComponent() {
    }
    MapComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'map-component',
            template: __webpack_require__(928)
        }), 
        __metadata('design:paramtypes', [])
    ], MapComponent);
    return MapComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/map.component.js.map

/***/ },

/***/ 439:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return VoucherComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var VoucherComponent = (function () {
    function VoucherComponent() {
        this.voucherCompetitionState = 0;
    }
    VoucherComponent.prototype.beginCompetition = function () {
        this.voucherCompetitionState = 1;
    };
    VoucherComponent.prototype.applyForVoucher = function () {
        this.voucherCompetitionState = 2;
    };
    VoucherComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            template: __webpack_require__(929),
        }), 
        __metadata('design:paramtypes', [])
    ], VoucherComponent);
    return VoucherComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/voucher.component.js.map

/***/ },

/***/ 440:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__activation_details_model__ = __webpack_require__(670);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__activation_service__ = __webpack_require__(671);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return ActivationComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ActivationComponent = (function () {
    function ActivationComponent(activationService, uxService) {
        this.activationService = activationService;
        this.uxService = uxService;
        this.activationDetails = new __WEBPACK_IMPORTED_MODULE_1__activation_details_model__["a" /* ActivationDetails */]();
    }
    ActivationComponent.prototype.checkPassword = function () {
        return this.activationDetails.newPassword === this.activationDetails.repeatNewPassword;
    };
    ActivationComponent.prototype.onSubmit = function () {
        var _this = this;
        this.activationService.addNewPassword(this.activationDetails).subscribe(function (data) {
            console.log(data);
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get countries, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get countries', error);
        });
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('activationDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__activation_details_model__["a" /* ActivationDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__activation_details_model__["a" /* ActivationDetails */]) === 'function' && _a) || Object)
    ], ActivationComponent.prototype, "activationDetails", void 0);
    ActivationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__(930), providers: [__WEBPACK_IMPORTED_MODULE_2__activation_service__["a" /* ActivationService */], __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]] }), 
        __metadata('design:paramtypes', [(typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__activation_service__["a" /* ActivationService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__activation_service__["a" /* ActivationService */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _c) || Object])
    ], ActivationComponent);
    return ActivationComponent;
    var _a, _b, _c;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/activation.component.js.map

/***/ },

/***/ 441:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(47);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return CoreService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var CoreService = (function () {
    function CoreService(http, uxService) {
        this.http = http;
        this.uxService = uxService;
    }
    CoreService.prototype.getUserDetails = function () {
        return this.http.get('api/user-details').map(function (response) { return response.json(); }).catch(this.uxService.handleError);
    };
    CoreService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _b) || Object])
    ], CoreService);
    return CoreService;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/core.service.js.map

/***/ },

/***/ 442:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return HomeComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HomeComponent = (function () {
    function HomeComponent() {
    }
    HomeComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'app-home', template: __webpack_require__(932) }), 
        __metadata('design:paramtypes', [])
    ], HomeComponent);
    return HomeComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/home.component.js.map

/***/ },

/***/ 443:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__ = __webpack_require__(436);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__(200);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return AppSearchInputComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppSearchInputComponent = (function () {
    function AppSearchInputComponent() {
        this.suggestionsService = {
            getSuggestions: function (query) {
                return new __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"](function (observer) {
                    observer.next(['suggestion 1', 'suggestion 2', 'suggestion 3']);
                    observer.complete();
                });
            }
        };
    }
    AppSearchInputComponent.prototype.onSearch = function (query) {
        alert('Now searching for: ' + query);
    };
    AppSearchInputComponent.prototype.onSearchButtonClick = function () {
        this.searchInput.startSearch();
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"]), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"]) === 'function' && _a) || Object)
    ], AppSearchInputComponent.prototype, "searchInput", void 0);
    AppSearchInputComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-search-input',
            template: __webpack_require__(933)
        }), 
        __metadata('design:paramtypes', [])
    ], AppSearchInputComponent);
    return AppSearchInputComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/app-search-input.component.js.map

/***/ },

/***/ 529:
/***/ function(module, exports, __webpack_require__) {

var map = {
	"app/+registration/registration.module": [
		1223,
		0
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return __webpack_require__.e(ids[1]).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
module.exports = webpackAsyncContext;
webpackAsyncContext.id = 529;


/***/ },

/***/ 530:
/***/ function(module, exports, __webpack_require__) {

"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__polyfills_ts__ = __webpack_require__(681);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__(623);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__(680);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_app_module__ = __webpack_require__(674);





if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_2__angular_core__["enableProdMode"])();
}
__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_4__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/main.js.map

/***/ },

/***/ 535:
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

/***/ 536:
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

/***/ 537:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__entity_entity_details_model__ = __webpack_require__(536);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__beneficiary_beneficiary_details_model__ = __webpack_require__(535);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return UserDetails; });


var UserDetails = (function () {
    function UserDetails() {
        this.entity = new __WEBPACK_IMPORTED_MODULE_0__entity_entity_details_model__["a" /* EntityDetails */]();
        this.beneficiary = new __WEBPACK_IMPORTED_MODULE_1__beneficiary_beneficiary_details_model__["a" /* BeneficiaryDetails */]();
    }
    return UserDetails;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/user-details.model.js.map

/***/ },

/***/ 538:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(47);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_crypto_js__ = __webpack_require__(835);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_crypto_js___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_crypto_js__);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return UserService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var UserService = (function () {
    function UserService(http, uxService) {
        this.http = http;
        this.uxService = uxService;
        this.addBeneficiaryUrl = 'api/beneficiary';
        this.loginUrl = 'api/user/login';
    }
    UserService.prototype.extractData = function (response) {
        var body = response.json();
        return body.data || body.error || {};
    };
    UserService.prototype.addBeneficiary = function (beneficiary) {
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["Headers"]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["RequestOptions"]({ headers: headers });
        console.log(beneficiary);
        return this.http.post(this.addBeneficiaryUrl, beneficiary, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    };
    UserService.prototype.getUser = function (user) {
        var email512 = __WEBPACK_IMPORTED_MODULE_3_crypto_js__["SHA512"](user.beneficiary.email);
        var password512 = __WEBPACK_IMPORTED_MODULE_3_crypto_js__["SHA512"](user.beneficiary.password);
        var token = __WEBPACK_IMPORTED_MODULE_3_crypto_js__["SHA512"](email512 + password512 + 'Wifi4EU').toString();
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["Headers"]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["RequestOptions"]({ headers: headers });
        return this.http.post(this.loginUrl, {
            "email": user.beneficiary.email,
            "password": user.beneficiary.password,
        }, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    };
    UserService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _b) || Object])
    ], UserService);
    return UserService;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/user.service.js.map

/***/ },

/***/ 539:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(32);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__(47);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_http_interceptor__ = __webpack_require__(665);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__ = __webpack_require__(434);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__ = __webpack_require__(436);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__ = __webpack_require__(924);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_primeng_primeng__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__components_index__ = __webpack_require__(676);
/* unused harmony export httpFactory */
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return SharedModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};









function httpFactory(backend, defaultOptions) {
    return new __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_http_interceptor__["UxHttp"](backend, defaultOptions);
}
var SharedModule = (function () {
    function SharedModule() {
    }
    SharedModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"],
                __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["b" /* UxModule */],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["CheckboxModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["GrowlModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["BlockUIModule"],
                __WEBPACK_IMPORTED_MODULE_2__angular_http__["HttpModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["AutoCompleteModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["DialogModule"]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UX_DIRECTIVES */], __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxLanguageSelectorComponent */], __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"], __WEBPACK_IMPORTED_MODULE_8__components_index__["a" /* APP_DIRECTIVES */]
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UX_DIRECTIVES */],
                __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxLanguageSelectorComponent */],
                __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"],
                __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["b" /* UxModule */],
                __WEBPACK_IMPORTED_MODULE_8__components_index__["a" /* APP_DIRECTIVES */],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["CheckboxModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["GrowlModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["BlockUIModule"],
                __WEBPACK_IMPORTED_MODULE_2__angular_http__["HttpModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["AutoCompleteModule"],
                __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["DialogModule"]
            ],
            providers: [
                {
                    provide: __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"],
                    useFactory: httpFactory,
                    deps: [__WEBPACK_IMPORTED_MODULE_2__angular_http__["XHRBackend"], __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]]
                }
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], SharedModule);
    return SharedModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/shared.module.js.map

/***/ },

/***/ 670:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return ActivationDetails; });
var ActivationDetails = (function () {
    function ActivationDetails() {
    }
    return ActivationDetails;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/activation-details.model.js.map

/***/ },

/***/ 671:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(47);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return ActivationService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ActivationService = (function () {
    function ActivationService(http, uxService) {
        this.http = http;
        this.uxService = uxService;
        this.activationUrl = '/api/activation';
    }
    ActivationService.prototype.extractData = function (response) {
        var body = response.json();
        return body.data || {};
    };
    ActivationService.prototype.addNewPassword = function (body) {
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["Headers"]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["RequestOptions"]({ headers: headers });
        return this.http.post(this.activationUrl, body, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    };
    ActivationService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _b) || Object])
    ], ActivationService);
    return ActivationService;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/activation.service.js.map

/***/ },

/***/ 672:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(32);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__home_home_component__ = __webpack_require__(442);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__voucher_voucher_component__ = __webpack_require__(439);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__map_map_component__ = __webpack_require__(438);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__activation_activation_component__ = __webpack_require__(440);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__login_login_component__ = __webpack_require__(437);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return AppRoutingModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forRoot([
                    {
                        path: '',
                        redirectTo: 'home',
                        pathMatch: 'full'
                    }, {
                        path: 'index.jsp',
                        redirectTo: 'home'
                    }, {
                        path: 'home',
                        component: __WEBPACK_IMPORTED_MODULE_2__home_home_component__["a" /* HomeComponent */]
                    }, {
                        path: 'map',
                        component: __WEBPACK_IMPORTED_MODULE_4__map_map_component__["a" /* MapComponent */]
                    }, {
                        path: 'activation',
                        component: __WEBPACK_IMPORTED_MODULE_5__activation_activation_component__["a" /* ActivationComponent */]
                    }, {
                        path: 'login',
                        component: __WEBPACK_IMPORTED_MODULE_6__login_login_component__["a" /* LoginComponent */]
                    }, {
                        path: 'registration',
                        loadChildren: 'app/+registration/registration.module#RegistrationModule'
                    }, {
                        path: 'registration',
                        loadChildren: 'app/+registration/registration.module#RegistrationModule'
                    }, {
                        path: 'voucher',
                        component: __WEBPACK_IMPORTED_MODULE_3__voucher_voucher_component__["a" /* VoucherComponent */]
                    }
                ], { useHash: true })],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
        }), 
        __metadata('design:paramtypes', [])
    ], AppRoutingModule);
    return AppRoutingModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/app-routing.module.js.map

/***/ },

/***/ 673:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__ = __webpack_require__(142);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__core_core_service__ = __webpack_require__(441);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return AppComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AppComponent = (function () {
    function AppComponent(translateService, coreService, uxService) {
        this.coreService = coreService;
        this.uxService = uxService;
        this.menuLinks = [];
        this.notifications = [];
        this.userInfos = '';
        translateService.setDefaultLang('en');
        translateService.use('en');
        this.menuLinks = [new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxLayoutLink */]({
                label: 'Wifi4EU',
                children: [
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxLayoutLink */]({ label: 'Free Wi-Fi for Europeans', url: 'home' }),
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxLayoutLink */]({ label: 'Who will benefit', url: 'home' }),
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxLayoutLink */]({ label: 'How to apply', url: 'home' }),
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxLayoutLink */]({ label: 'More information', url: 'home' })
                ]
            })];
    }
    AppComponent.prototype.ngOnInit = function () {
        /*this
         .coreService
         .getUserDetails()
         .subscribe((userDetails : any) => {
         let userName = userDetails.domainUsername;
         let department = userDetails.departmentNumber;
         let buffer : string[] = [userDetails.firstName, userDetails.lastName];
         if (userName != null) {
         buffer.push('(' + userName + ')');
         }
         if (department != null) {
         buffer.push(department);
         }
         this.userInfos = buffer.join(' ');

         }, error => {
         this
         .uxService
         .growl({severity: 'warn', summary: 'WARNING', detail: 'Could not get user details, ignore this when NG is working in offline mode'});
         console.log('WARNING : Could not get user details, ignore this when NG is working in offline ' +
         'mode');
         this.userInfos = 'Name Firstname';
         });*/
    };
    AppComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'app-root', template: __webpack_require__(931), styles: [__webpack_require__(926)] }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["d" /* TranslateService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["d" /* TranslateService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__core_core_service__["a" /* CoreService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__core_core_service__["a" /* CoreService */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _c) || Object])
    ], AppComponent);
    return AppComponent;
    var _a, _b, _c;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/app.component.js.map

/***/ },

/***/ 674:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(133);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(18);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(47);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__ = __webpack_require__(142);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__core_core_module__ = __webpack_require__(675);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__core_core_service__ = __webpack_require__(441);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__app_component__ = __webpack_require__(673);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__app_routing_module__ = __webpack_require__(672);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__home_home_component__ = __webpack_require__(442);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__voucher_voucher_component__ = __webpack_require__(439);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__shared_components_timeline_timeline_component__ = __webpack_require__(677);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__shared_components_timer_timer_component__ = __webpack_require__(678);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__map_map_component__ = __webpack_require__(438);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__activation_activation_component__ = __webpack_require__(440);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__login_login_component__ = __webpack_require__(437);
/* unused harmony export translateFactory */
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return AppModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

















function translateFactory(http) {
    return new __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__["a" /* TranslateStaticLoader */](http, './assets/i18n', '.json');
}
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_8__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_10__home_home_component__["a" /* HomeComponent */],
                __WEBPACK_IMPORTED_MODULE_11__voucher_voucher_component__["a" /* VoucherComponent */],
                __WEBPACK_IMPORTED_MODULE_12__shared_components_timeline_timeline_component__["a" /* TimelineComponent */],
                __WEBPACK_IMPORTED_MODULE_13__shared_components_timer_timer_component__["a" /* TimerComponent */],
                __WEBPACK_IMPORTED_MODULE_14__map_map_component__["a" /* MapComponent */],
                __WEBPACK_IMPORTED_MODULE_15__activation_activation_component__["a" /* ActivationComponent */],
                __WEBPACK_IMPORTED_MODULE_16__login_login_component__["a" /* LoginComponent */]
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_12__shared_components_timeline_timeline_component__["a" /* TimelineComponent */],
                __WEBPACK_IMPORTED_MODULE_13__shared_components_timer_timer_component__["a" /* TimerComponent */],
                __WEBPACK_IMPORTED_MODULE_14__map_map_component__["a" /* MapComponent */],
                __WEBPACK_IMPORTED_MODULE_15__activation_activation_component__["a" /* ActivationComponent */],
                __WEBPACK_IMPORTED_MODULE_16__login_login_component__["a" /* LoginComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_6__core_core_module__["a" /* CoreModule */],
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["BrowserModule"],
                __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__["b" /* TranslateModule */].forRoot({
                    provide: __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__["c" /* TranslateLoader */],
                    useFactory: translateFactory,
                    deps: [__WEBPACK_IMPORTED_MODULE_3__angular_http__["Http"]]
                }),
                __WEBPACK_IMPORTED_MODULE_9__app_routing_module__["a" /* AppRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["FormsModule"]
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */],
                __WEBPACK_IMPORTED_MODULE_7__core_core_service__["a" /* CoreService */]
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_8__app_component__["a" /* AppComponent */]]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/app.module.js.map

/***/ },

/***/ 675:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__(539);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return CoreModule; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var CoreModule = (function () {
    function CoreModule() {
    }
    CoreModule = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */]],
            declarations: [],
            exports: [
                __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */]
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], CoreModule);
    return CoreModule;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/core.module.js.map

/***/ },

/***/ 676:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__layout_app_search_input_app_search_input_component__ = __webpack_require__(443);
/* unused harmony reexport AppSearchInputComponent */
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return APP_DIRECTIVES; });


var APP_DIRECTIVES = [
    __WEBPACK_IMPORTED_MODULE_0__layout_app_search_input_app_search_input_component__["a" /* AppSearchInputComponent */]
];
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/index.js.map

/***/ },

/***/ 677:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return TimelineComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var TimelineComponent = (function () {
    function TimelineComponent() {
    }
    TimelineComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'timeline-component', template: __webpack_require__(934) }), 
        __metadata('design:paramtypes', [])
    ], TimelineComponent);
    return TimelineComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/timeline.component.js.map

/***/ },

/***/ 678:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__timer_service__ = __webpack_require__(679);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__(200);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return TimerComponent; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TimerComponent = (function () {
    function TimerComponent(timerService) {
        var _this = this;
        this.timerService = timerService;
        this.timerEvent = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.currentTimestamp = new Date().getTime();
        this.expirationTimestamp = timerService.getExpirationDateTime();
        __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].interval(500).map(function (x) {
            _this.currentTimestamp = new Date().getTime();
        }).subscribe(function (x) {
            _this.toEpoch(_this.expirationTimestamp - _this.currentTimestamp);
            _this.checkIfFinished(_this.expirationTimestamp - _this.currentTimestamp);
        });
    }
    TimerComponent.prototype.toEpoch = function (timestamp) {
        timestamp /= 1000;
        this.seconds = Math.floor(timestamp % 60);
        timestamp /= 60;
        this.minutes = Math.floor(timestamp % 60);
        timestamp /= 60;
        this.hours = Math.floor(timestamp % 24);
        this.days = Math.floor(timestamp / 24);
    };
    TimerComponent.prototype.checkIfFinished = function (remaining) {
        if (remaining <= 0) {
            this.timerEvent.emit();
        }
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(), 
        __metadata('design:type', Object)
    ], TimerComponent.prototype, "timerEvent", void 0);
    TimerComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'timer-component', template: __webpack_require__(935), providers: [__WEBPACK_IMPORTED_MODULE_1__timer_service__["a" /* TimerService */]] }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__timer_service__["a" /* TimerService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__timer_service__["a" /* TimerService */]) === 'function' && _a) || Object])
    ], TimerComponent);
    return TimerComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/timer.component.js.map

/***/ },

/***/ 679:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(47);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(57);
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return TimerService; });
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TimerService = (function () {
    function TimerService(http, uxService) {
        this.http = http;
        this.uxService = uxService;
        this.voucherUrl = '/api/timer/voucher';
    }
    TimerService.prototype.getExpirationDateTime = function () {
        // TODO - Should call our internal REST API.
        return new Date(2017, 1, 17, 9, 30, 0, 250).getTime();
    };
    TimerService.prototype.getExpirationDateTime2 = function () {
        // TODO - Should call our internal REST API.
        return this.http.get(this.voucherUrl).map(function (response) {
            return response.json();
        }).catch(this.uxService.handleError);
    };
    TimerService = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _b) || Object])
    ], TimerService);
    return TimerService;
    var _a, _b;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/timer.service.js.map

/***/ },

/***/ 680:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.
var environment = {
    production: false
};
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/environment.js.map

/***/ },

/***/ 681:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__ = __webpack_require__(695);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__ = __webpack_require__(688);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__ = __webpack_require__(684);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__ = __webpack_require__(690);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__ = __webpack_require__(689);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__ = __webpack_require__(687);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__ = __webpack_require__(686);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__ = __webpack_require__(694);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__ = __webpack_require__(683);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__ = __webpack_require__(682);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__ = __webpack_require__(692);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__ = __webpack_require__(685);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__ = __webpack_require__(693);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__ = __webpack_require__(691);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__ = __webpack_require__(696);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__ = __webpack_require__(1220);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__);
















//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/polyfills.js.map

/***/ },

/***/ 926:
/***/ function(module, exports) {

module.exports = ""

/***/ },

/***/ 927:
/***/ function(module, exports) {

module.exports = "<form (ngSubmit)=\"onSubmit()\" #loginForm=\"ngForm\">\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <label for=\"email\">Email</label>\n                <input type=\"email\" [(ngModel)]=\"userDetails.beneficiary.email\"\n                       class=\"form-control\"\n                       name=\"email\" ngcontrol=\"email\"\n                       #email=\"ngModel\" required>\n                <div [hidden]=\"email.valid || email.pristine\"\n                     class=\"alert alert-danger\">Email is\n                    required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <label for=\"password\">Password</label>\n                <input type=\"password\"\n                       [(ngModel)]=\"userDetails.beneficiary.password\"\n                       class=\"form-control\"\n                       name=\"password\" ngcontrol=\"password\"\n                       #password=\"ngModel\" required>\n                <div [hidden]=\"password.valid || password.pristine\"\n                     class=\"alert alert-danger\">Password is\n                    required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-4\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary\"\n                    [disabled]=\"!loginForm.form.valid\">Login\n            </button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>\n<p-dialog [(visible)]=\"displayConfirmingData\" [modal]=\"true\" [responsive]=\"true\"\n          [resizable]=\"false\"\n          [draggable]=\"false\" [closable]=\"false\" [closeOnEscape]=\"false\">\n    <p class=\"ModalLoaderDots\"><span>.</span><span>.</span><span>.</span></p>\n    <h1 class=\"Modalh1Confirmation\">Confirming Data, please wait...</h1>\n    <p class=\"ModalpConfirmation\">Your registration to Wifi4EU is in the process\n        of being submitted.<br>Please don't\n        close this window.</p>\n</p-dialog>"

/***/ },

/***/ 928:
/***/ function(module, exports) {

module.exports = "<div id=\"map\"></div>"

/***/ },

/***/ 929:
/***/ function(module, exports) {

module.exports = "<timeline-component></timeline-component>\n<div [ngSwitch]=\"voucherCompetitionState\">\n    <!-- no competition active, display timer -->\n    <div *ngSwitchCase=\"0\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-success\">{{ 'voucher.statusmessage2' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.timeleft.title' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.timeleft.subtitle' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <timer-component *ngIf=\"!competitionOpen\" (timerEvent)=\"beginCompetition()\"></timer-component>\n        </div>\n    </div>\n    <!-- competition Open, display apply button -->\n    <div *ngSwitchCase=\"1\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-info\">{{ 'voucher.statusmessage4' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.apply.title' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.apply.subtitle' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br><br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" (click)=\"applyForVoucher()\">{{ 'voucher.applyforvoucher' |\n                translate}}\n            </button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n    <!-- user has applied for voucher -->\n    <div *ngSwitchCase=\"2\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-success\">{{ 'voucher.statusmessage5' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.alreadyapplied' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br><br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" disabled>{{ 'voucher.applyforvoucher' | translate}}</button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n    <!-- user rejected -->\n    <div *ngSwitchCase=\"3\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-danger\">{{ 'voucher.statusmessage3' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.rejectedtitle' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.rejected.reason1' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br><br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <span class=\"ui-g-4\">{{ 'voucher.tryagain' | translate}}</span>\n            <span class=\"ui-g-4\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" routerLink=\"/home\" routerLinkActive=\"active\">{{ 'voucher.backhome' |\n                translate}}\n            </button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n</div>"

/***/ },

/***/ 930:
/***/ function(module, exports) {

module.exports = "\n<div class=\"clearfix\"></div>\n\n<form (ngSubmit)=\"onSubmit()\" #activationForm=\"ngForm\">\n        <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <p class=\"h2 h2-title\">{{ 'activate.account' | translate }}</p>\n                <p class=\"text-align-center\">{{ 'email.information' | translate }}</p>\n                <label for=\"email\">{{ 'email.label' | translate }}</label>\n                <input type=\"email\" [(ngModel)]=\"activationDetails.email\"  class=\"form-control\" name=\"email\" ngcontrol=\"email\"\n                        #email=\"ngModel\" required>\n                <div [hidden]=\"email.valid || email.pristine\" class=\"alert alert-danger\" >{{ 'email.required' | translate }}</div>\n\n                <label for=\"code\">{{ 'code.label' | translate }}</label>\n                <input type=\"text\" [(ngModel)]=\"activationDetails.code\" class=\"form-control\" name=\"code\" ngcontrol=\"code\"\n                       #code=\"ngModel\"  minlength=\"8\" maxlength=\"8\" required>\n                <div [hidden]=\"code.valid || code.pristine\" class=\"alert alert-danger\">{{ 'code.required' | translate }}</div>\n                <p class=\"smallLetter\">{{ 'code.digits' | translate }}</p>\n\n\n                <p class=\"h2 h2-title center\">{{ 'select.newPassword' | translate }}</p>\n                <p class=\"text-align-center\">{{ 'select.password' | translate }}</p>\n\n                <label for=\"newPassword\">{{ 'password.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"activationDetails.newPassword\" class=\"form-control\" name=\"newPassword\" ngcontrol=\"newPassword\"\n                       #newPassword=\"ngModel\" minlength=\"8\" (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"newPassword.valid || newPassword.pristine\" class=\"alert alert-danger\">{{ 'password.required' | translate }}</div>\n\n                <label for=\"repeatNewPassword\">{{ 'confirmNewPassword.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"activationDetails.repeatNewPassword\" class=\"form-control\" name=\"repeatNewPassword\" ngcontrol=\"repeatNewPassword\"\n                       #repeatNewPassword=\"ngModel\" minlength=\"8\" (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"repeatNewPassword.valid || repeatNewPassword.pristine\" class=\"alert alert-danger\">{{ 'newPassword.required' | translate }}</div>\n\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn\">{{ 'cancel.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary\" [disabled]=\"!activationForm.form.valid || !checkPassword()\">{{ 'confirm.button' | translate }}</button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>\n\n"

/***/ },

/***/ 931:
/***/ function(module, exports) {

module.exports = "<ux-layout-app uxTrackScroll>\n\n  <uxLayoutAppMainContainer>\n\n    <ux-layout-app-main>\n\n      <uxLayoutAppMainHeaderContainer>\n        <ux-layout-header appFullName=\"Wifi4EU Free Wifi for Europeans\" appShortName=\"App\" [userInfos]=\"userInfos\"></ux-layout-header>\n      </uxLayoutAppMainHeaderContainer>\n\n      <uxLayoutAppMainNavBarContainer>\n        <ux-layout-nav-bar>\n          <ux-layout-nav-bar-top-menu [links]=\"menuLinks\"></ux-layout-nav-bar-top-menu>\n          <ux-layout-nav-bar-actions>\n            <ux-layout-nav-bar-action-item iconClass=\"fa-info-circle\">\n              <ul>\n                <li><a>About</a></li>\n                <li><a>Contact</a></li>\n              </ul>\n              <ul>\n                <li><a>Legal notice</a></li>\n                <li><a>...</a></li>\n              </ul>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-search\" contentClass=\"search-bar\" isHiddenMobile=\"true\">\n              <app-search-input></app-search-input>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-bell\" tagCount=\"{{notifications.length}}\">\n              <ux-layout-nav-bar-action-item-notifications [notifications]=\"notifications\"></ux-layout-nav-bar-action-item-notifications>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-cog\" contentClass=\"auto-width\">\n              <ux-layout-nav-bar-action-item-settings></ux-layout-nav-bar-action-item-settings>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-bars\" itemClass=\"app-menu\" isOverlayPanel=\"true\" userInfos=\"NAME Firstname\"\n              [links]=\"menuLinks\"></ux-layout-nav-bar-action-item>\n          </ux-layout-nav-bar-actions>\n        </ux-layout-nav-bar>\n      </uxLayoutAppMainNavBarContainer>\n\n      <uxLayoutAppMainContentContainer>\n        <router-outlet></router-outlet>\n      </uxLayoutAppMainContentContainer>\n\n      <uxLayoutAppMainFooterContainer>\n        <ux-layout-footer isCompact=\"true\">\n          Problems with your registration? Please click here to <strong><a href=\"#\">contact the Help-Desk</a></strong>.\n        </ux-layout-footer>\n      </uxLayoutAppMainFooterContainer>\n\n    </ux-layout-app-main>\n\n  </uxLayoutAppMainContainer>\n\n</ux-layout-app>"

/***/ },

/***/ 932:
/***/ function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n\n<div class=\"first\">\n    <img id=\"first-background\" src=\"assets/images/group-6.png\" alt=\"\">\n    <div class=\"container-fluid header-fluid\">\n\n        <div class=\"contenedor row\">\n            <div class=\"col-xl-12\">\n                <img id=\"img-wifi\" src=\"assets/images/group.png\" alt=\"\">\n            </div>\n        </div>\n    </div>\n</div>\n<div class=\"container-fluid\">\n    <div class=\"contenedor row\">\n        <div class=\"col-xl-6 margin-top\">\n\n            <h2 class=\"title-home\">{{ 'home.part1.title' | translate }}</h2>\n            <p class=\"subtitle-home\">{{ 'home.part1.text1' | translate }}</p>\n            <p class=\"normal-text\">{{ 'home.part1.text2' | translate }}</p>\n        </div>\n        <div class=\"col-xl-6 margin-top-right\">\n            <p class=\"subtitle-bold-italic\"> {{ 'home.part1.text3' | translate\n                }}</p>\n            <p class=\"subtitle-italic\">{{ 'home.part1.author' | translate }}<br>\n                {{ 'home.part1.date' | translate }}</p>\n            <div id=\"img-europeans\">\n                <img src=\"assets/images/copy-2.png\" alt=\"\">\n            </div>\n        </div>\n    </div>\n</div>\n<div class=\"container-fluid second\">\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-6\">\n            <h1 class=\"benefit\">{{ 'home.part2.title' | translate }}</h1>\n            <h2 class=\"europeans\">{{ 'home.part2.subtitle1' | translate }}</h2>\n            <p class=\"europeans-text\">{{ 'home.part2.text1' | translate }}</p>\n            <div id=\"img-scnd\">\n                <img src=\"assets/images/copy-3.png\" alt=\"\">\n            </div>\n        </div>\n        <div class=\"col-xl-6\">\n            <h2 class=\"entities\">{{ 'home.part2.subtitle2' | translate }}</h2>\n            <p class=\"entities-text\">{{ 'home.part2.text2' | translate }}</p>\n            <a class=\"btn btn-primary video-button\"\n               href=\"https://youtu.be/FvaJIPg0Pxw\" target=\"_blank\">{{\n                'home.whatch.video' | translate }}</a>\n\n        </div>\n    </div>\n</div>\n<div class=\"container-fluid mayor\">\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-6\">\n            <h2 class=\"apply\">{{ 'home.part3.title' | translate }} </h2>\n            <p class=\"apply-text\">{{ 'home.part3.text1' | translate }}</p>\n        </div>\n        <div class=\"col-xl-6\">\n            <p class=\"apply-text\">{{ 'home.part3.text2' | translate }}</p>\n\n        </div>\n    </div>\n    <div class=\"row\">\n        <div class=\"col-xl-2\"></div>\n        <div class=\"col-xl-8\">\n            <div class=\"col-xl-6\">\n                <img class=\"mayor-img\"\n                     src=\"assets/images/account-balance-material-icons-regular.png\">\n                <p class=\"mayor-title\">{{ 'home.part3.title2' | translate }}</p>\n                <p class=\"represent\">{{ 'home.part3.subtitle' | translate }}</p>\n                <a class=\"btn btn-primary video-button center-block video-button\"\n                   href=\"#/registration\">{{ 'home.register' | translate }}</a>\n            </div>\n            <div class=\"col-xl-6\">\n                <img class=\"supplier-img\" src=\"assets/images/group-4.png\">\n                <p class=\"supplier\">{{ 'home.part3.title3' | translate }}</p>\n                <a class=\"btn btn-primary video-button center-block video-button\"\n                   href=\"#\" target=\"_blank\">{{ 'home.register' | translate\n                    }}</a>\n\n            </div>\n        </div>\n        <div class=\"col-xl-2\"></div>\n    </div>\n</div>\n<div class=\"container-fluid third\">\n    <div class=\"row contenedor\">\n\n    </div>\n</div>\n<div class=\"content azul container-fluid\">\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-12\">\n            <h2 class=\"information\">{{ 'home.part4.title1' | translate }}</h2>\n            <p class=\"text-information\">{{ 'home.part4.subtitle' | translate\n                }}</p>\n        </div>\n    </div>\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-6\">\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"https://ec.europa.eu/digital-single-market/en/news/factsheet-wifi4eu\">{{\n                'home.part4.link1' | translate }}</a></p>\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"http://europa.eu/rapid/press-release_IP-16-4261_en.htm\">{{\n                'home.part4.link2' | translate }}</a></p>\n        </div>\n        <div class=\"col-xl-6\">\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"https://ec.europa.eu/digital-single-market/en/news/proposed-regulation-promotion-internet-connectivity-local-communities-and-public-spaces-wifi4eu\">{{\n                'home.part4.link3' | translate }}</a></p>\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"https://ec.europa.eu/digital-single-market/events/cf/b-day-going-giga/document.cfm?doc_id=36544\">{{\n                'home.part4.link4' | translate }}</a></p>\n        </div>\n    </div>\n</div>\n<div class=\"content footer-landing\">\n    <p>{{ 'home.footer.update' | translate }}<a href=\"#\">{{ 'home.footer.top' |\n        translate }}</a></p>\n</div>\n"

/***/ },

/***/ 933:
/***/ function(module, exports) {

module.exports = "<div class=\"row\">\n    <div class=\"search-input\">\n        <ux-search-input [suggestionsService]=\"suggestionsService\" (search)=\"onSearch($event)\"></ux-search-input>\n    </div>\n    <div class=\"search-button\">\n        <button type=\"button\" class=\"btn btn-secondary btn-block\" (click)=\"onSearchButtonClick()\">\n            <span class=\"fa fa-search\"></span>\n        </button>            \n    </div>\n</div>"

/***/ },

/***/ 934:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g-12 center\" style=\"border: 1px solid;background-color: white;\">\n    <span class=\"ui-g-3\">Timeline</span>\n    <span class=\"ui-g-6\"></span>\n    <span class=\"ui-g-3\">Expand</span>\n</div>"

/***/ },

/***/ 935:
/***/ function(module, exports) {

module.exports = "<div class=\"ui-g-12 center\">\n    <div class=\"ui-g-12 center\">\n        <span class=\"ui-g-4\"></span>\n        <span class=\"ui-g-4\" style=\"background: #fbfbfb;box-shadow: 0px 1px 2px #888888;\">\n            <div class=\"ui-g-12 center\">\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{days}}</span>\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{hours}}</span>\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{minutes}}</span>\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{seconds}}</span>\n            </div>\n            <div class=\"ui-g-12 center\">\n                <span class=\"ui-g-3\">{{ 'voucher.days' | translate}}</span>\n                <span class=\"ui-g-3\">{{ 'voucher.hours' | translate}}</span>\n                <span class=\"ui-g-3\">{{ 'voucher.minutes' | translate}}</span>\n                <span class=\"ui-g-3\">{{ 'voucher.seconds' | translate}}</span>\n            </div>\n        </span>\n        <span class=\"ui-g-4\"></span>\n    </div>\n</div>"

/***/ }

},[1221]);
//# sourceMappingURL=main.bundle.map