webpackJsonp([2,4],{

/***/ 1174:
/***/ function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(518);


/***/ },

/***/ 429:
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
            template: __webpack_require__(884)
        }), 
        __metadata('design:paramtypes', [])
    ], MapComponent);
    return MapComponent;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/map.component.js.map

/***/ },

/***/ 430:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__activation_details_model__ = __webpack_require__(654);
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
    function ActivationComponent() {
        this.activationDetails = new __WEBPACK_IMPORTED_MODULE_1__activation_details_model__["a" /* ActivationDetails */]();
        this.activationEmailMatches = false;
    }
    ActivationComponent.prototype.actiavtionEmailMatches = function () {
        if (this.activationDetails.psswd === this.activationDetails.newPsswd) {
            return true;
        }
        else {
            return false;
        }
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('activationDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__activation_details_model__["a" /* ActivationDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__activation_details_model__["a" /* ActivationDetails */]) === 'function' && _a) || Object)
    ], ActivationComponent.prototype, "activationDetails", void 0);
    ActivationComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__(885) }), 
        __metadata('design:paramtypes', [])
    ], ActivationComponent);
    return ActivationComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/activation.component.js.map

/***/ },

/***/ 431:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__(77);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(142);
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

/***/ 432:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__user_details_module__ = __webpack_require__(659);
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
        this.userDetails = new __WEBPACK_IMPORTED_MODULE_1__user_details_module__["a" /* UserDetails */]();
        this.displayConfirmingData = false;
    }
    HomeComponent.prototype.onSubmit = function () {
        var that = this;
        this.displayConfirmingData = true;
        setTimeout(function () {
            that.displayConfirmingData = false;
        }, 2000);
    };
    __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('userDetails'), 
        __metadata('design:type', (typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__user_details_module__["a" /* UserDetails */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1__user_details_module__["a" /* UserDetails */]) === 'function' && _a) || Object)
    ], HomeComponent.prototype, "userDetails", void 0);
    HomeComponent = __decorate([
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'app-home', template: __webpack_require__(887) }), 
        __metadata('design:paramtypes', [])
    ], HomeComponent);
    return HomeComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/home.component.js.map

/***/ },

/***/ 433:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__ = __webpack_require__(428);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__(294);
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
            template: __webpack_require__(888)
        }), 
        __metadata('design:paramtypes', [])
    ], AppSearchInputComponent);
    return AppSearchInputComponent;
    var _a;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/app-search-input.component.js.map

/***/ },

/***/ 517:
/***/ function(module, exports, __webpack_require__) {

var map = {
	"app/+registration/registration.module": [
		1176,
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
webpackAsyncContext.id = 517;


/***/ },

/***/ 518:
/***/ function(module, exports, __webpack_require__) {

"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__polyfills_ts__ = __webpack_require__(662);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__(607);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__(661);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_app_module__ = __webpack_require__(657);





if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_2__angular_core__["enableProdMode"])();
}
__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_4__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/main.js.map

/***/ },

/***/ 523:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__(77);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_http_interceptor__ = __webpack_require__(649);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(142);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__ = __webpack_require__(426);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__ = __webpack_require__(428);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__ = __webpack_require__(881);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_primeng_primeng__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__components_index__ = __webpack_require__(660);
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

/***/ 654:
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

/***/ 655:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__(30);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__home_home_component__ = __webpack_require__(432);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__map_map_component__ = __webpack_require__(429);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__activation_activation_component__ = __webpack_require__(430);
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
                        component: __WEBPACK_IMPORTED_MODULE_3__map_map_component__["a" /* MapComponent */]
                    }, {
                        path: 'activation',
                        component: __WEBPACK_IMPORTED_MODULE_4__activation_activation_component__["a" /* ActivationComponent */]
                    }, {
                        path: 'registration',
                        loadChildren: 'app/+registration/registration.module#RegistrationModule'
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

/***/ 656:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__ = __webpack_require__(136);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(142);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__core_core_service__ = __webpack_require__(431);
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
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'app-root', template: __webpack_require__(886), styles: [__webpack_require__(883)] }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["d" /* TranslateService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["d" /* TranslateService */]) === 'function' && _a) || Object, (typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__core_core_service__["a" /* CoreService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_3__core_core_service__["a" /* CoreService */]) === 'function' && _b) || Object, (typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */] !== 'undefined' && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UxService */]) === 'function' && _c) || Object])
    ], AppComponent);
    return AppComponent;
    var _a, _b, _c;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/app.component.js.map

/***/ },

/***/ 657:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__(127);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__(17);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__(77);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__ = __webpack_require__(136);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__(142);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__core_core_module__ = __webpack_require__(658);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__core_core_service__ = __webpack_require__(431);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__app_component__ = __webpack_require__(656);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__app_routing_module__ = __webpack_require__(655);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__home_home_component__ = __webpack_require__(432);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__map_map_component__ = __webpack_require__(429);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__activation_activation_component__ = __webpack_require__(430);
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
                __WEBPACK_IMPORTED_MODULE_11__map_map_component__["a" /* MapComponent */],
                __WEBPACK_IMPORTED_MODULE_12__activation_activation_component__["a" /* ActivationComponent */]
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

/***/ 658:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__(523);
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

/***/ 659:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return UserDetails; });
var UserDetails = (function () {
    function UserDetails() {
    }
    return UserDetails;
}());
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/user-details.module.js.map

/***/ },

/***/ 660:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__layout_app_search_input_app_search_input_component__ = __webpack_require__(433);
/* unused harmony reexport AppSearchInputComponent */
/* harmony export (binding) */ __webpack_require__.d(exports, "a", function() { return APP_DIRECTIVES; });


var APP_DIRECTIVES = [
    __WEBPACK_IMPORTED_MODULE_0__layout_app_search_input_app_search_input_component__["a" /* AppSearchInputComponent */]
];
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/index.js.map

/***/ },

/***/ 661:
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

/***/ 662:
/***/ function(module, exports, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__ = __webpack_require__(676);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__ = __webpack_require__(669);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__ = __webpack_require__(665);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__ = __webpack_require__(671);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__ = __webpack_require__(670);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__ = __webpack_require__(668);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__ = __webpack_require__(667);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__ = __webpack_require__(675);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__ = __webpack_require__(664);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__ = __webpack_require__(663);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__ = __webpack_require__(673);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__ = __webpack_require__(666);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__ = __webpack_require__(674);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__ = __webpack_require__(672);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__ = __webpack_require__(677);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__ = __webpack_require__(1173);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__);
















//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-web/src/main/angular/src/polyfills.js.map

/***/ },

/***/ 883:
/***/ function(module, exports) {

module.exports = ""

/***/ },

/***/ 884:
/***/ function(module, exports) {

module.exports = "<div id=\"map\"></div>"

/***/ },

/***/ 885:
/***/ function(module, exports) {

module.exports = "\n<div class=\"clearfix\"></div>\n\n<form (ngSubmit)=\"onSubmit()\" #activationForm=\"ngForm\">\n        <div class=\"form-group ui-g\">\n        <div class=\"ui-g-3\"></div>\n        <div class=\"ui-g-6\">\n            <div class=\"form-group\">\n                <p class=\"h2 h2-title\">Enter your e-mail address and security code</p>\n                <p class=\"text-align-center\">Please enter the information we sent to your e-mail address.</p>\n                <label for=\"email\"></label>\n                <input type=\"email\" [(ngModel)]=\"activationDetails.email\" class=\"form-control\" name=\"email\" ngcontrol=\"email\"\n                        #email=\"ngModel\" required>\n                <div [hidden]=\"email.valid || email.pristine\" class=\"alert alert-danger\">Email is required</div>\n\n                <label for=\"code\"></label>\n                <input type=\"password\" [(ngModel)]=\"activationDetails.code\" class=\"form-control\" name=\"email\" ngcontrol=\"code\"\n                       #code=\"ngModel\" minlength=\"8\" required>\n                <div [hidden]=\"code.valid || code.pristine\" class=\"alert alert-danger\">Code is required</div>\n                <p class=\"smallLetter\">Please enter the 8-digit security code we sent to your e-mail adress</p>\n\n\n                <p class=\"h2 h2-title center\">Select a new password</p>\n                <p class=\"text-align-center\">Please, select a password of 8 characters minimum, case sensitive and 1 digit.</p>\n\n                <label for=\"psswd\"></label>\n                <input type=\"password\" [(ngModel)]=\"activationDetails.psswd\" class=\"form-control\" name=\"psswd\" ngcontrol=\"psswd\"\n                       #psswd=\"ngModel\" minlength=\"8\" required>\n                <div [hidden]=\"psswd.valid || psswd.pristine\" class=\"alert alert-danger\">Password is required</div>\n\n                <label for=\"newPsswd\"></label>\n                <input type=\"password\" [(ngModel)]=\"activationDetails.newPsswd\" class=\"form-control\" name=\"newPsswd\" ngcontrol=\"newPsswd\"\n                       #newPsswd=\"ngModel\" minlength=\"8\" required>\n                <div [hidden]=\"newPsswd.valid || newPsswd.pristine\" class=\"alert alert-danger\">New password is required</div>\n\n            </div>\n        </div>\n        <div class=\"ui-g-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn\">Cancel</button>\n        </div>\n        <div class=\"ui-g-2\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary\" [disabled]=\"!activationForm.form.valid || !actiavtionEmailMatches()\">Confirm</button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>\n\n"

/***/ },

/***/ 886:
/***/ function(module, exports) {

module.exports = "<ux-layout-app uxTrackScroll>\n\n  <uxLayoutAppMainContainer>\n\n    <ux-layout-app-main>\n\n      <uxLayoutAppMainHeaderContainer>\n        <ux-layout-header appFullName=\"Wifi4EU Free Wifi for Europeans\" appShortName=\"App\" [userInfos]=\"userInfos\"></ux-layout-header>\n      </uxLayoutAppMainHeaderContainer>\n\n      <uxLayoutAppMainNavBarContainer>\n        <ux-layout-nav-bar>\n          <ux-layout-nav-bar-top-menu [links]=\"menuLinks\"></ux-layout-nav-bar-top-menu>\n          <ux-layout-nav-bar-actions>\n            <ux-layout-nav-bar-action-item iconClass=\"fa-info-circle\">\n              <ul>\n                <li><a>About</a></li>\n                <li><a>Contact</a></li>\n              </ul>\n              <ul>\n                <li><a>Legal notice</a></li>\n                <li><a>...</a></li>\n              </ul>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-search\" contentClass=\"search-bar\" isHiddenMobile=\"true\">\n              <app-search-input></app-search-input>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-bell\" tagCount=\"{{notifications.length}}\">\n              <ux-layout-nav-bar-action-item-notifications [notifications]=\"notifications\"></ux-layout-nav-bar-action-item-notifications>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-cog\" contentClass=\"auto-width\">\n              <ux-layout-nav-bar-action-item-settings></ux-layout-nav-bar-action-item-settings>\n            </ux-layout-nav-bar-action-item>\n\n            <ux-layout-nav-bar-action-item iconClass=\"fa-bars\" itemClass=\"app-menu\" isOverlayPanel=\"true\" userInfos=\"NAME Firstname\"\n              [links]=\"menuLinks\"></ux-layout-nav-bar-action-item>\n          </ux-layout-nav-bar-actions>\n        </ux-layout-nav-bar>\n      </uxLayoutAppMainNavBarContainer>\n\n      <uxLayoutAppMainContentContainer>\n        <router-outlet></router-outlet>\n      </uxLayoutAppMainContentContainer>\n\n      <uxLayoutAppMainFooterContainer>\n        <ux-layout-footer isCompact=\"true\">\n          Problems with your registration? Please click here to <strong><a href=\"#\">contact the Help-Desk</a></strong>.\n        </ux-layout-footer>\n      </uxLayoutAppMainFooterContainer>\n\n    </ux-layout-app-main>\n\n  </uxLayoutAppMainContainer>\n\n</ux-layout-app>"

/***/ },

/***/ 887:
/***/ function(module, exports) {

module.exports = "<!--<form (ngSubmit)=\"onSubmit()\" #loginForm=\"ngForm\">-->\n    <!--<div class=\"form-group ui-g\">-->\n        <!--<div class=\"ui-g-3\"></div>-->\n        <!--<div class=\"ui-g-6\">-->\n            <!--<div class=\"form-group\">-->\n                <!--<label for=\"email\">Email</label>-->\n                <!--<input type=\"email\" [(ngModel)]=\"userDetails.email\"-->\n                       <!--class=\"form-control\"-->\n                       <!--name=\"email\" ngcontrol=\"email\"-->\n                       <!--#email=\"ngModel\" required>-->\n                <!--<div [hidden]=\"email.valid || email.pristine\"-->\n                     <!--class=\"alert alert-danger\">Email is-->\n                    <!--required-->\n                <!--</div>-->\n            <!--</div>-->\n        <!--</div>-->\n        <!--<div class=\"ui-g-3\"></div>-->\n    <!--</div>-->\n    <!--<div class=\"form-group ui-g\">-->\n        <!--<div class=\"ui-g-3\"></div>-->\n        <!--<div class=\"ui-g-6\">-->\n            <!--<div class=\"form-group\">-->\n                <!--<label for=\"password\">Password</label>-->\n                <!--<input type=\"password\" [(ngModel)]=\"userDetails.password\"-->\n                       <!--class=\"form-control\"-->\n                       <!--name=\"password\" ngcontrol=\"password\"-->\n                       <!--#password=\"ngModel\" required>-->\n                <!--<div [hidden]=\"password.valid || password.pristine\"-->\n                     <!--class=\"alert alert-danger\">Password is-->\n                    <!--required-->\n                <!--</div>-->\n            <!--</div>-->\n        <!--</div>-->\n        <!--<div class=\"ui-g-3\"></div>-->\n    <!--</div>-->\n    <!--<div class=\"form-group ui-g\">-->\n        <!--<div class=\"ui-g-4\"></div>-->\n        <!--<div class=\"ui-g-4\" style=\"text-align: center !important\">-->\n            <!--<button type=\"submit\" class=\"btn btn-primary\" [disabled]=\"!loginForm.form.valid\">Login</button>-->\n        <!--</div>-->\n        <!--<div class=\"ui-g-4\"></div>-->\n    <!--</div>-->\n<!--</form>-->\n<!--<p-dialog [(visible)]=\"displayConfirmingData\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\"-->\n          <!--[draggable]=\"false\" [closable]=\"false\" [closeOnEscape]=\"false\">-->\n    <!--<p class=\"ModalLoaderDots\"><span>.</span><span>.</span><span>.</span></p>-->\n    <!--<h1 class=\"Modalh1Confirmation\">Confirming Data, please wait...</h1>-->\n    <!--<p class=\"ModalpConfirmation\">Your registration to Wifi4EU is in the process of being submitted.<br>Please don't-->\n        <!--close this window.</p>-->\n<!--</p-dialog>-->\n\n\n\n<!--LUCIA-->\n\n<div class=\"clearfix\"></div>\n\n    <div class=\"first\">\n        <img id=\"first-background\" src=\"assets/images/group-6.png\" alt=\"\">\n        <div class=\"container-fluid header-fluid\">\n\n            <div class=\"contenedor row\">\n                <div class=\"col-xl-12\">\n                    <img id=\"img-wifi\" src=\"assets/images/group.png\" alt=\"\">\n                </div>\n            </div>\n        </div>\n    </div>\n    <div class=\"container-fluid\">\n        <div class=\"contenedor row\">\n            <div class=\"col-xl-6 margin-top\">\n\n                <h2 class=\"title-home\">FREE Wi-Fi FOR EUROPEANS</h2>\n                <p class=\"subtitle-home\">The European Commission wishes to promote free Wi-Fi connectivity for citizens and visitors in public spaces such as parks, squares, public building, libraries, health centres, and museums everywhere in Europe through WiFi4EU.</p>\n                <p class=\"normal-text\">The initial budget of the WiFi4EU scheme is EUR 120 million between 2017-2019. It will support the installation of state-of-the-art Wi-Fi equipment in the centres of community life.</p>\n            </div>\n            <div class=\"col-xl-6 margin-top-right\">\n                <p class=\"subtitle-bold-italic\">“Everyone benefiting from connectivity means that it should not matter where you live or how much you earn.  So we propose today to equip every European village and every city with free wireless internet ac­cess around the main centres of public life by 2020.”</p>\n                <p class=\"subtitle-italic\">Jean-Claude JUNCKER<br>\n                State of the Union speech, September 2016</p>\n                <div id=\"img-europeans\">\n                    <img src=\"assets/images/copy-2.png\" alt=\"\">\n                </div>\n            </div>\n       </div>\n    </div>\n    <div class=\"container-fluid second\">\n        <div class=\"row contenedor\">\n            <div class=\"col-xl-6\">\n                <h1 class=\"benefit\">WHO WILL BENEFIT?</h1>\n                <h2 class=\"europeans\">All Europeans</h2>\n                <p class=\"europeans-text\">The WiFi4EU scheme will be disbursed in a geographically balanced manner, so that high-speed connections can benefit both residents and visitors of thousands of local communities across the EU. At least 6,000 to 8,000 local communities Up to 40-50 million connections per day</p>\n                <div id=\"img-scnd\">\n                    <img src=\"assets/images/copy-3.png\" alt=\"\">\n                </div>\n            </div>\n            <div class=\"col-xl-6\">\n                <h2 class=\"entities\">Entities with a public mission</h2>\n                <p class=\"entities-text\"> The WiFi4EU scheme will be open to entities with a public mission – typically local municipalities, libraries, health centres, etc. It will fund the equipment and installation costs (internet access points), while the local entity will pay for the connectivity (internet subscription) and maintenance in good order of the equipment. The local authorities will be encouraged to develop and promote their own digital services in areas such as e-government, e-health and e-tourism.</p>\n                <a class=\"btn btn-primary video-button\" href=\"https://youtu.be/FvaJIPg0Pxw\" target=\"_blank\">Whatch Video</a>\n\n            </div>\n        </div>\n    </div>\n    <div class=\"container-fluid mayor\">\n        <div class=\"row contenedor\">\n            <div class=\"col-xl-6\">\n                <h2 class=\"apply\">HOW TO APPLY FOR WiFi4EU</h2>\n                <p class=\"apply-text\">The WiFi4EU scheme will be delivered through simple and non-bureaucratic procedures such as online applications, payments by vouchers and light-touch monitoring requirements.</p>\n            </div>\n            <div class=\"col-xl-6\">\n                <p class=\"apply-text\">As soon as the WiFi4EU scheme is approved by the European Parliament and Council of Ministers (expected in 2017), the first call for projects will be launched. The projects will be selected on a first-come, first-serve basis. Projects applying to the scheme should propose to equip areas where a public or a private Wi-Fi offering similar characteristics does not already exist.</p>\n\n            </div>\n        </div>\n        <div class=\"row\">\n            <div class=\"col-xl-2\"></div>\n            <div class=\"col-xl-8\">\n                <div class=\"col-xl-6\">\n                    <img class=\"mayor-img\" src=\"assets/images/account-balance-material-icons-regular.png\">\n                    <p class=\"mayor-title\">I'm a Mayor</p>\n                    <p class=\"represent\">or I represent a municipality</p>\n                    <a class=\"btn btn-primary video-button center-block video-button\" href=\"#/registration\" >Register now</a>\n                </div>\n                <div class=\"col-xl-6\">\n                    <img class=\"supplier-img\" src=\"assets/images/group-4.png\">\n                    <p class=\"supplier\">I'm a supplier</p>\n                    <a class=\"btn btn-primary video-button center-block video-button\" href=\"#\" target=\"_blank\">Register now</a>\n\n                </div>\n            </div>\n            <div class=\"col-xl-2\"></div>\n        </div>\n    </div>\n    <div class=\"container-fluid third\">\n        <div class=\"row contenedor\">\n\n        </div>\n    </div>\n    <div class=\"content azul container-fluid\">\n        <div class=\"row contenedor\">\n            <div class=\"col-xl-12\">\n                <h2 class=\"information\">NEED MORE INFORMATION?</h2>\n                <p class=\"text-information\">Please visit following links form more information about the project</p>\n            </div>\n        </div>\n        <div class=\"row contenedor\">\n            <div class=\"col-xl-6\">\n                <p class=\"white-links\"><a target=\"_blank\" href=\"https://ec.europa.eu/digital-single-market/en/news/factsheet-wifi4eu\">Factsheet on WiFi4EU</a></p>\n                <p class=\"white-links\"><a target=\"_blank\" href=\"http://europa.eu/rapid/press-release_IP-16-4261_en.htm\">Strategy on Connectivity for a European Gigabit Society</a></p>\n            </div>\n            <div class=\"col-xl-6\">\n                <p class=\"white-links\"><a target=\"_blank\" href=\"https://ec.europa.eu/digital-single-market/en/news/proposed-regulation-promotion-internet-connectivity-local-communities-and-public-spaces-wifi4eu\">Proposed Regulation on the promotion of Internet connectivity in local communities and public spaces (WiFi4EU)</a></p>\n                <p class=\"white-links\"><a target=\"_blank\" href=\"https://ec.europa.eu/digital-single-market/events/cf/b-day-going-giga/document.cfm?doc_id=36544\">“Bringing it all together in WiFi4EU” - presentation from the B-DAY: Going Giga, 15 Nov 2016</a></p>\n            </div>\n        </div>\n    </div>\n    <div class=\"content footer-landing\">\n        <p>Last Update 0/01/2017  |  <a href=\"#\">Top</a></p>\n    </div>\n"

/***/ },

/***/ 888:
/***/ function(module, exports) {

module.exports = "<div class=\"row\">\n    <div class=\"search-input\">\n        <ux-search-input [suggestionsService]=\"suggestionsService\" (search)=\"onSearch($event)\"></ux-search-input>\n    </div>\n    <div class=\"search-button\">\n        <button type=\"button\" class=\"btn btn-secondary btn-block\" (click)=\"onSearchButtonClick()\">\n            <span class=\"fa fa-search\"></span>\n        </button>            \n    </div>\n</div>"

/***/ }

},[1174]);
//# sourceMappingURL=main.bundle.map