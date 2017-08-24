webpackJsonp(["supplier-registration.module"],{

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step1/supplier-registration-step1.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"center\">\n        <p class=\"beneficiaryTitle labelModal\">{{ 'step1.supplier' | translate }}</p>\n        <p>{{ 'company.info' | translate }}</p>\n\n        <form (ngSubmit)=\"onSubmit(1)\" #registrationForm=\"ngForm\">\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"name\">{{ 'company.name' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\" id=\"name\" name=\"name\"\n                               placeholder=\"Everis\" [(ngModel)]=\"supplierDTO.name\" #name=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"name.valid || name.pristine\">\n                            Company is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"address\">{{ 'legal.address' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\" id=\"address\" name=\"address\"\n                               placeholder=\"Diagonal, 605, 08022, Barcelona\" [(ngModel)]=\"supplierDTO.address\"\n                               #address=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"address.valid || address.pristine\">\n                            Address is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"vat\">{{ 'vat.label' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\" id=\"vat\" name=\"vat\"\n                               placeholder=\"000000000\" [(ngModel)]=\"supplierDTO.vat\" #vat=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"vat.valid || vat.pristine\">\n                            VAT number is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"bic\">{{ 'bic.label' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\" id=\"bic\" name=\"bic\"\n                               placeholder=\"000000000000\" [(ngModel)]=\"supplierDTO.bic\" #bic=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"bic.valid || bic.pristine\">BIC is required</div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"accountNumber\">{{ 'bank.account' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\" id=\"accountNumber\" name=\"accountNumber\"\n                               placeholder=\"000000000000000000\" [(ngModel)]=\"supplierDTO.accountNumber\" #accountNumber=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"accountNumber.valid || accountNumber.pristine\">\n                            Bank account is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"website\">{{ 'company.web' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\" id=\"website\" name=\"website\" [pattern]=\"webPattern\"\n                               placeholder=\"http://everis.com\" [(ngModel)]=\"supplierDTO.website\" #website=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"website.valid || website.pristine\">\n                            Company Web is required\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"uploadBtn\">{{ 'company.logo' | translate }}</label>\n                        <br>\n                        <div class=\"ui-g-12 left\">\n                            <div class=\"fileUpload btn btn-primary\">\n                                <span>{{ 'upload.logo' | translate }}</span>\n                                <input #logoInput id=\"uploadBtn\" type=\"file\" class=\"upload\" (change)=\"onSelect($event)\" accept=\"image/*\" />\n                            </div>\n                        </div>\n                        <br>\n                        <div *ngIf=\"isLogoUploaded\" class=\"ui-g-12\" style=\"border: 1px solid #D5D5D5; background: #ffffff;\">\n                            <img *ngIf=\"isLogoUploaded\" [src]=\"logoUrl.result\" class=\"ui-g-3\">\n                            <span class=\"ui-g-1\"></span>\n                            <span class=\"ui-g-4\">{{logoFile.name}}<br>{{logoFile.size}} KB\n                            </span>\n                            <span class=\"ui-g-1\"></span>\n                            <button type=\"button\" class=\"ui-g-3 btn btn-primary\" (click)=\"clearLogoFile()\">Clear</button>\n                        </div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                    <a href=\"#/home\"><button type=\"button\" class=\"btn btn-primary cancel-button\">{{ 'cancel.button' | translate }}</button></a>\n                </div>\n                <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                    <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!registrationForm.form.valid\">\n                        {{ 'confirm.button' | translate }}\n                    </button>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n        </form>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step1/supplier-registration-step1.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierRegistrationComponentStep1; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__ = __webpack_require__("../../../../rxjs/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SupplierRegistrationComponentStep1 = (function () {
    function SupplierRegistrationComponentStep1() {
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onLogoSubmit = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.webPattern = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\/\/([wW][wW][wW]\\.)?))[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
    }
    SupplierRegistrationComponentStep1.prototype.ngOnInit = function () {
        if (this.logoFile) {
            this.isLogoUploaded = true;
            this.logoUrl.readAsDataURL(this.logoFile);
        }
    };
    SupplierRegistrationComponentStep1.prototype.onSubmit = function (step) {
        this.onNext.emit(step);
    };
    SupplierRegistrationComponentStep1.prototype.onSelect = function (event) {
        var _this = this;
        this.isLogoUploaded = false;
        if (event.target && event.target.files && event.target.files.length > 0) {
            this.onLogoSubmit.emit(event.target.files["0"]);
            this.logoUrl.readAsDataURL(event.target.files["0"]);
            this.logoFile = event.target.files["0"];
            var subscription_1 = __WEBPACK_IMPORTED_MODULE_2_rxjs_Rx__["Observable"].interval(500).map(function (x) {
            }).subscribe(function (x) {
                if (_this.logoUrl.result != "") {
                    _this.isLogoUploaded = true;
                    subscription_1.unsubscribe();
                }
            });
        }
        else {
            this.clearLogoFile();
        }
    };
    SupplierRegistrationComponentStep1.prototype.clearLogoFile = function () {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.onLogoSubmit.emit(null);
        this.logoFile = null;
    };
    return SupplierRegistrationComponentStep1;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('supplierDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]) === "function" && _a || Object)
], SupplierRegistrationComponentStep1.prototype, "supplierDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", Object)
], SupplierRegistrationComponentStep1.prototype, "onNext", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", Object)
], SupplierRegistrationComponentStep1.prototype, "onLogoSubmit", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('logoFile'),
    __metadata("design:type", Object)
], SupplierRegistrationComponentStep1.prototype, "logoFile", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])('logoInput'),
    __metadata("design:type", Object)
], SupplierRegistrationComponentStep1.prototype, "logoInput", void 0);
SupplierRegistrationComponentStep1 = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'supplier-registration-step1-component',
        template: __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step1/supplier-registration-step1.component.html")
    })
], SupplierRegistrationComponentStep1);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration-step1.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step2/supplier-registration-step2.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"center\">\n        <p class=\"beneficiaryTitle labelModal\">{{ 'step2.supplier' | translate }}</p>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-lg-1\"></div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-5 marginSelect\">\n            <!-- select countries -->\n            <p-multiSelect [options]=\"allCountries\" [(ngModel)]=\"nuts0\" (onChange)=\"checkIfRegionsSelected()\">\n            </p-multiSelect>\n        </div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-5 white\">\n            <!-- select country to display communes -->\n            <p-tabView *ngIf=\"allCountries.length > 0\">\n                <p-tabPanel *ngFor=\"let country of nuts0;\" [header]=\"country.name\">\n                    <div class=\"ui-g\">\n                        <p-multiSelect [options]=\"allRegions[country.name]\" [(ngModel)]=\"nuts3[country.name]\" (onChange)=\"checkIfRegionsSelected()\">\n                        </p-multiSelect>\n                    </div>\n                </p-tabPanel>\n            </p-tabView>\n        </div>\n        <div class=\"ui-lg-1\"></div>\n    </div>\n    <div id=\"navigation-buttons\" class=\"form-group ui-g\">\n        <div class=\"ui-lg-3\"></div>\n        <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn btn-primary cancel-button\" (click)=\"stepBack(1)\">\n                {{ 'back.button' | translate }}\n            </button>\n        </div>\n        <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary publish-button\" (click)=\"onSubmit(2)\" [disabled]=\"!regionsSelected\">\n                {{ 'next.button' | translate }}\n            </button>\n        </div>\n        <div class=\"ui-lg-3\"></div>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step2/supplier-registration-step2.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierRegistrationComponentStep2; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SupplierRegistrationComponentStep2 = (function () {
    function SupplierRegistrationComponentStep2(nutsApi) {
        this.nutsApi = nutsApi;
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onBack = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    SupplierRegistrationComponentStep2.prototype.ngOnInit = function () {
        var _this = this;
        if (!this.allCountries) {
            this.nutsApi.findNutsByLevel(0).subscribe(function (countries) {
                for (var _i = 0, countries_1 = countries; _i < countries_1.length; _i++) {
                    var country = countries_1[_i];
                    var selectCountry = {
                        label: ' ' + country.name,
                        value: country
                    };
                    _this.allCountries.push(selectCountry);
                }
                _this.checkIfRegionsSelected();
            });
        }
        else {
            this.checkIfRegionsSelected();
        }
    };
    SupplierRegistrationComponentStep2.prototype.checkIfRegionsSelected = function () {
        this.regionsSelected = false;
        for (var _i = 0, _a = this.allCountries; _i < _a.length; _i++) {
            var country = _a[_i];
            var countryFound = false;
            for (var _b = 0, _c = this.nuts0; _b < _c.length; _b++) {
                var selectedCountry = _c[_b];
                if (selectedCountry.countryCode == country.value.countryCode) {
                    if (this.nuts3[country.value.name].length > 0) {
                        this.regionsSelected = true;
                    }
                    countryFound = true;
                }
            }
            if (!countryFound) {
                this.nuts3[country.value.name] = [];
            }
        }
    };
    SupplierRegistrationComponentStep2.prototype.onSubmit = function (step) {
        this.onNext.emit(step);
    };
    SupplierRegistrationComponentStep2.prototype.stepBack = function (step) {
        this.onBack.emit(step);
    };
    return SupplierRegistrationComponentStep2;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('supplierDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]) === "function" && _a || Object)
], SupplierRegistrationComponentStep2.prototype, "supplierDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('nuts0'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep2.prototype, "nuts0", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('nuts3'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep2.prototype, "nuts3", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _b || Object)
], SupplierRegistrationComponentStep2.prototype, "onNext", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _c || Object)
], SupplierRegistrationComponentStep2.prototype, "onBack", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('allCountries'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep2.prototype, "allCountries", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('allRegions'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep2.prototype, "allRegions", void 0);
SupplierRegistrationComponentStep2 = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'supplier-registration-step2-component',
        template: __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step2/supplier-registration-step2.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__["a" /* NutsApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _d || Object])
], SupplierRegistrationComponentStep2);

var _a, _b, _c, _d;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration-step2.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step3/supplier-registration-step3.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"center\">\n        <p class=\"beneficiaryTitle labelModal\">{{ 'step3.supplier' | translate }}</p>\n        <p>{{ 'contact.description' | translate }}</p>\n\n        <form (ngSubmit)=\"onSubmit(3)\" #registrationForm=\"ngForm\">\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"contactName\">{{ 'name.label' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\"\n                               id=\"contactName\" name=\"contactName\" placeholder=\"{{ 'name.place' | translate }}\"\n                               [(ngModel)]=\"supplierDTO.contactName\" #contactName=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"contactName.valid || contactName.pristine\">\n                            Name is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"contactSurname\">{{ 'surname.label' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\"\n                               id=\"contactSurname\" name=\"contactSurname\" placeholder=\"{{ 'surname.place' | translate }}\"\n                               [(ngModel)]=\"supplierDTO.contactSurname\" #contactSurname=\"ngModel\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"contactSurname.valid || contactSurname.pristine\">\n                            Surname is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-3\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"contactPhonePrefix\">{{ 'prefix.number' | translate\n                            }}</label>\n                        <input class=\"form-control paddingInput\" type=\"text\"\n                               id=\"contactPhonePrefix\" name=\"contactPhonePrefix\"\n                               placeholder=\"{{ 'prefix.place' | translate }}\" pattern=\"(\\+|00)[0-9]{2,3}\"\n                               [(ngModel)]=\"supplierDTO.contactPhonePrefix\" #contactPhonePrefix=\"ngModel\" required>\n                        <div class=\"alert alert-danger\"\n                             [hidden]=\"contactPhonePrefix.valid || contactPhonePrefix.pristine\">\n                            Prefix is required\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-3\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"contactPhoneNumber\">{{ 'phone.number' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"number\"\n                               id=\"contactPhoneNumber\" name=\"contactPhoneNumber\"\n                               placeholder=\"{{ 'phone.place' | translate }}\" step=\"1\" min=\"1\"\n                               [(ngModel)]=\"supplierDTO.contactPhoneNumber\" #contactPhoneNumber=\"ngModel\" required>\n                        <div class=\"alert alert-danger\"\n                             [hidden]=\"contactPhoneNumber.valid || contactPhoneNumber.pristine\">\n                            Phone is required\n                        </div>\n\n                    </div>\n\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"contactEmail\">{{ 'email.label' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"email\"\n                               id=\"contactEmail\" name=\"contactEmail\" placeholder=\"{{ 'email.place' | translate }}\"\n                               [(ngModel)]=\"supplierDTO.contactEmail\" #contactEmail=\"ngModel\"\n                               (keyup)=\"checkIfEmailMatches()\" [pattern]=\"emailPattern\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"contactEmail.valid || contactEmail.pristine\">\n                            Valid email information is required\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <div class=\"form-group\">\n                        <label class=\"label floatLeft\" for=\"confirmEmail\">{{ 'confirmemail.label' | translate }}</label>\n                        <input class=\"form-control paddingInput\" type=\"email\"\n                               id=\"confirmEmail\" name=\"confirmEmail\" placeholder=\"{{ 'email.place' | translate }}\"\n                               [(ngModel)]=\"confirmEmailField\" #confirmEmail=\"ngModel\"\n                               (keyup)=\"checkIfEmailMatches()\" [pattern]=\"emailPattern\" required>\n                        <div class=\"alert alert-danger\" [hidden]=\"confirmEmail.valid || confirmEmail.pristine\">\n                            Valid email information is required\n                        </div>\n                        <div [hidden]=\"emailMatches || confirmEmail.pristine\" class=\"alert alert-info\">\n                            The email information must match\n                        </div>\n                        <div class=\"ui-lg-3\"></div>\n                    </div>\n                </div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                    <button type=\"button\" class=\"btn btn-primary cancel-button\" (click)=\"stepBack(2)\">{{ 'back.button' |\n                        translate }}\n                    </button>\n                </div>\n                <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                    <button type=\"submit\" class=\"btn btn-primary publish-button\"\n                            [disabled]=\"!registrationForm.form.valid || !emailMatches\">\n                        {{ 'confirm.button' | translate }}\n                    </button>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n        </form>\n    </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step3/supplier-registration-step3.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierRegistrationComponentStep3; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var SupplierRegistrationComponentStep3 = (function () {
    function SupplierRegistrationComponentStep3() {
        this.emailPattern = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onBack = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    SupplierRegistrationComponentStep3.prototype.onSubmit = function (step) {
        this.onNext.emit(step);
    };
    SupplierRegistrationComponentStep3.prototype.stepBack = function (step) {
        this.onBack.emit(step);
    };
    SupplierRegistrationComponentStep3.prototype.checkIfEmailMatches = function () {
        this.emailMatches = false;
        if (this.supplierDTO.contactEmail === this.confirmEmailField) {
            this.emailMatches = true;
        }
    };
    SupplierRegistrationComponentStep3.prototype.keyPressPrefix = function (event) {
        var pattern = /[0-9\+]/;
        var inputChar = String.fromCharCode(event.charCode);
        if (!pattern.test(inputChar)) {
            event.preventDefault();
        }
    };
    return SupplierRegistrationComponentStep3;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('supplierDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]) === "function" && _a || Object)
], SupplierRegistrationComponentStep3.prototype, "supplierDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('selection'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep3.prototype, "selection", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _b || Object)
], SupplierRegistrationComponentStep3.prototype, "onNext", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _c || Object)
], SupplierRegistrationComponentStep3.prototype, "onBack", void 0);
SupplierRegistrationComponentStep3 = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'supplier-registration-step3-component',
        template: __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step3/supplier-registration-step3.component.html")
    }),
    __metadata("design:paramtypes", [])
], SupplierRegistrationComponentStep3);

var _a, _b, _c;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration-step3.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step4/supplier-registration-step4.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"center\">\n        <p class=\"beneficiaryTitle labelModal\">{{ 'step4.supplier' | translate }}</p>\n        <p>{{ 'contact.description' | translate }}</p>\n    </div>\n\n    <hr class=\"beneficiaryHr marginHr\">\n\n    <div class=\"ui-g\">\n        <div class=\"ui-g-11 ui-md-11 ui-lg-11\">\n            <p class=\"beneficiaryMayor\">{{ 'contact.person' | translate }}</p>\n        </div>\n        <div class=\"ui-g-1 ui-md-1 ui-lg-1\">\n            <a (click)=\"editStep(3)\">\n                <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i> {{ 'edit.button' | translate }}\n            </a>\n        </div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'name.label' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.contactName}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'surname.label' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.contactSurname}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'phone.number' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.contactPhonePrefix}} {{supplierDTO.contactPhoneNumber}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'email.modal' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.contactEmail}}</b></div>\n    </div>\n\n    <hr class=\"beneficiaryHr marginHr\">\n\n    <div class=\"ui-g\">\n        <div class=\"ui-g-11 ui-md-11 ui-lg-11\">\n            <p class=\"beneficiaryMayor\">{{ 'company.details' | translate }}</p>\n        </div>\n        <div class=\"ui-g-1 ui-md-1 ui-lg-1\">\n            <a (click)=\"editStep(1)\">\n                <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i> {{ 'edit.button' | translate }}\n            </a>\n        </div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'company.name' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.name}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'legal.address' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.address}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'vat.label' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.vat}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'bic.label' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.bic}}</b></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'bank.account' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><b>{{supplierDTO.accountNumber}}</b></div>\n    </div>\n    <div class=\"ui-g\" *ngIf=\"logoUrl\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-3\">{{ 'logo.label' | translate }}</div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-7\"><img src=\"{{logoUrl.result}}\" alt=\"logo\" height=\"60\"></div>\n    </div>\n\n    <hr class=\"beneficiaryHr marginHr\">\n\n    <div class=\"ui-g\">\n        <div class=\"ui-g-10 ui-md-10 ui-lg-11\">\n            <p class=\"beneficiaryMayor\">{{ 'entity.support' | translate }}</p>\n        </div>\n        <div class=\"ui-g-1 ui-md-1 ui-lg-1\">\n            <a (click)=\"editStep(2)\">\n                <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i> {{ 'edit.button' | translate }}\n            </a>\n        </div>\n        <div class=\"ui-g-1 ui-md-1\"></div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12 ui-md-12 ui-lg-12\">\n            <p-tabView *ngIf=\"nuts0.length > 0\">\n                <p-tabPanel *ngFor=\"let country of nuts0;\" [header]=\"country.name\">\n                    <div class=\"ui-g\">\n                        <p-dataTable [value]=\"nuts3[country.name]\" [paginator]=\"true\" [rows]=\"10\" [rowsPerPageOptions]=\"[10,20,30,40,50]\">\n                            <p-column field=\"name\" [sortable]=\"true\"></p-column>\n                        </p-dataTable>\n                    </div>\n                </p-tabPanel>\n            </p-tabView>\n        </div>\n    </div>\n\n    <hr class=\"beneficiaryHr marginHr\">\n\n    <div class=\"clearfix\"></div>\n\n    <div class=\"ui-g\" style=\"text-align: left;\">\n        <span class=\"ui-lg-1\"></span>\n        <div class=\"ui-g-10 ui-md-10 ui-lg-10\">\n            <label class=\"ui-g-12 ui-md-12 ui-lg-12\" for=\"check_1\"><input type=\"checkbox\" id=\"check_1\" [(ngModel)]=\"legalChecks[0]\"> \n                {{ 'eu.requirements' | translate }}\n            </label>\n        </div>\n        <div class=\"ui-lg-1\"></div>\n    </div>\n    <div class=\"ui-g\" style=\"text-align: left;\">\n        <span class=\"ui-lg-1\"></span>\n        <div class=\"ui-g-10 ui-md-10 ui-lg-10\">\n            <label class=\"ui-g-12 ui-md-12 ui-lg-12\" for=\"check_2\"><input type=\"checkbox\" id=\"check_2\" [(ngModel)]=\"legalChecks[1]\"> \n                {{ 'submit.application' | translate }}\n            </label>\n        </div>\n\n        <div class=\"ui-lg-1\"></div>\n    </div>\n\n    <div>\n        <div class=\"ui-g\">\n            <div class=\"ui-lg-4 ui-md-4\"></div>\n            <div class=\"ui-g-12 ui-md-4 ui-lg-4\">\n                <ng2-google-recaptcha class=\"ui-g-6 marginCaptcha\" siteKey=\"6LfUthYUAAAAAHdHO9HpCUyptQdYGXXQIFx9Y8zu\" (onCaptchaComplete)=\"onCaptchaComplete($event)\"></ng2-google-recaptcha>\n            </div>\n            <div class=\"ui-lg-4 ui-md-4\"></div>\n        </div>\n    </div>\n\n\n    <div class=\" ui-g\">\n        <div class=\"ui-lg-3\"></div>\n        <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\" btn-primary cancel-button\">{{ 'cancel.button' | translate }}\n            </button>\n        </div>\n        <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn  btn-primary publish-button\" (click)=\"openModal()\" [disabled]=\"!legalChecks[0] || !legalChecks[1] || !successCaptcha\">\n                {{ 'confirm.button' | translate}}\n            </button>\n        </div>\n        <div class=\"ui-lg-3\"></div>\n    </div>\n\n\n</div>\n<!--MODAL-->\n\n<p-dialog [(visible)]=\"display\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"true\">\n    <p class=\"beneficiaryMayor\">{{ 'requirements.head' | translate }}</p>\n\n    <p class=\"requirementSubitle\">Requirement 1</p>\n    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur hendrerit lacinia volutpat. Praesent rhoncus\n        suscipit aliquet. Ut quis turpis sit amet nibh eleifend lacinia. Aliquam varius blandit luctus. Vestibulum id\n        dolor molestie, bibendum nisl quis, mollis risus. Quisque ullamcorper odio ante, tristique cursus arcu dignissim\n        ac. </p>\n    <p class=\"requirementSubitle\">Requirement 2</p>\n    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur hendrerit lacinia volutpat. Praesent rhoncus\n        suscipit aliquet. Ut quis turpis sit amet nibh eleifend lacinia. Aliquam varius blandit luctus. Vestibulum id\n        dolor molestie, bibendum nisl quis, mollis risus. Quisque ullamcorper odio ante, tristique cursus arcu dignissim\n        ac. </p>\n    <p class=\"requirementSubitle\">Requirement 3</p>\n    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur hendrerit lacinia volutpat. Praesent rhoncus\n        suscipit aliquet. Ut quis turpis sit amet nibh eleifend lacinia. Aliquam varius blandit luctus. Vestibulum id\n        dolor molestie, bibendum nisl quis, mollis risus. Quisque ullamcorper odio ante, tristique cursus arcu dignissim\n        ac. </p>\n    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n        <button type=\"submit\" class=\"btn btn-primary publish-button\" (click)=\"onSubmit()\">{{ 'confirm.button' | translate }}</button>\n    </div>\n</p-dialog>"

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/+supplier-registration-step4/supplier-registration-step4.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierRegistrationComponentStep4; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var SupplierRegistrationComponentStep4 = (function () {
    function SupplierRegistrationComponentStep4(supplierApi, uxService) {
        this.supplierApi = supplierApi;
        this.uxService = uxService;
        this.logoUrl = new FileReader();
        this.legalChecks = [false, false];
        this.successCaptcha = false;
        this.display = false;
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onBack = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.gotoStep = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onSuccess = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onFailure = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    SupplierRegistrationComponentStep4.prototype.ngOnInit = function () {
        if (this.logoFile) {
            this.logoUrl.readAsDataURL(this.logoFile);
        }
    };
    SupplierRegistrationComponentStep4.prototype.openModal = function () {
        this.display = true;
    };
    SupplierRegistrationComponentStep4.prototype.onCaptchaComplete = function (response) {
        this.successCaptcha = response.success;
    };
    SupplierRegistrationComponentStep4.prototype.onSubmit = function () {
        var _this = this;
        this.supplierDTO.legalCheck1 = this.legalChecks[0];
        this.supplierDTO.legalCheck2 = this.legalChecks[1];
        this.supplierDTO.nutsIds = '';
        for (var i = 0; i < this.nuts0.length; i++) {
            if (i < (this.nuts0.length - 1)) {
                this.supplierDTO.nutsIds += this.nuts0[i].countryCode.toString() + ',';
            }
            else {
                this.supplierDTO.nutsIds += this.nuts0[i].countryCode.toString() + ';';
            }
        }
        for (var _i = 0, _a = this.nuts0; _i < _a.length; _i++) {
            var country = _a[_i];
            for (var i = 0; i < this.nuts3[country.name].length; i++) {
                this.supplierDTO.nutsIds += this.nuts3[country.name][i].code.toString();
                if (i < (this.nuts3[country.name].length - 1)) {
                    this.supplierDTO.nutsIds += ',';
                }
            }
        }
        this.supplierApi.createSupplier(this.supplierDTO).subscribe(function (data) {
            if (data['success'] != true) {
                _this.onFailure.emit(true);
                return;
            }
            _this.onSuccess.emit(true);
        }, function (error) {
            _this.onFailure.emit(true);
        });
    };
    SupplierRegistrationComponentStep4.prototype.editStep = function (step) {
        this.gotoStep.emit(step);
    };
    return SupplierRegistrationComponentStep4;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('supplierDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]) === "function" && _a || Object)
], SupplierRegistrationComponentStep4.prototype, "supplierDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('selection'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep4.prototype, "selection", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _b || Object)
], SupplierRegistrationComponentStep4.prototype, "onNext", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _c || Object)
], SupplierRegistrationComponentStep4.prototype, "onBack", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _d || Object)
], SupplierRegistrationComponentStep4.prototype, "gotoStep", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _e || Object)
], SupplierRegistrationComponentStep4.prototype, "onSuccess", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _f || Object)
], SupplierRegistrationComponentStep4.prototype, "onFailure", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('nuts0'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep4.prototype, "nuts0", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('nuts3'),
    __metadata("design:type", Array)
], SupplierRegistrationComponentStep4.prototype, "nuts3", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('logoFile'),
    __metadata("design:type", Object)
], SupplierRegistrationComponentStep4.prototype, "logoFile", void 0);
SupplierRegistrationComponentStep4 = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'supplier-registration-step4-component',
        template: __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step4/supplier-registration-step4.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _g || Object, typeof (_h = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _h || Object])
], SupplierRegistrationComponentStep4);

var _a, _b, _c, _d, _e, _f, _g, _h;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration-step4.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/supplier-registration-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierRegistrationRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__supplier_registration_component__ = __webpack_require__("../../../../../src/app/+supplier-registration/supplier-registration.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var SupplierRegistrationRoutingModule = (function () {
    function SupplierRegistrationRoutingModule() {
    }
    return SupplierRegistrationRoutingModule;
}());
SupplierRegistrationRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forChild([
                {
                    path: '',
                    component: __WEBPACK_IMPORTED_MODULE_2__supplier_registration_component__["a" /* SupplierRegistrationComponent */],
                }
            ])],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
    })
], SupplierRegistrationRoutingModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/supplier-registration.component.html":
/***/ (function(module, exports) {

module.exports = "<ux-wizard-steps [isCustomContent]=\"true\" *ngIf=\"!successRegistration && !failureRegistration\">\n    <ux-wizard-step label=\"{{ 'step1.supplier' | translate }}\"\n                    [isCompleted]=\"completed[0]\"\n                    [isActive]=\"active[0]\">\n        <uxWizardStepCustomContent>\n            <supplier-registration-step1-component *ngIf=\"active[0]\"\n                                                   [supplierDTO]=\"supplierDTO\"\n                                                   [logoFile]=\"logoFile\"\n                                                   (onNext)=\"onNext($event)\"\n                                                   (onBack)=\"onBack($event)\"\n                                                   (onLogoSubmit)=\"onLogoSubmit($event)\">\n            </supplier-registration-step1-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'step2.supplier' | translate }}\"\n                    [isCompleted]=\"completed[1]\"\n                    [isActive]=\"active[1]\">\n        <uxWizardStepCustomContent>\n            <supplier-registration-step2-component *ngIf=\"active[1]\"\n                                                   [supplierDTO]=\"supplierDTO\"\n                                                   [nuts0]=\"nuts0\"\n                                                   [nuts3]=\"nuts3\"\n                                                   [allCountries]=\"allCountries\"\n                                                   [allRegions]=\"allRegions\"\n                                                   (onNext)=\"onNext($event)\"\n                                                   (onBack)=\"onBack($event)\">\n            </supplier-registration-step2-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'step3.supplier' | translate }}\"\n                    [isCompleted]=\"completed[2]\"\n                    [isActive]=\"active[2]\">\n        <uxWizardStepCustomContent>\n            <supplier-registration-step3-component *ngIf=\"active[2]\"\n                                                   [supplierDTO]=\"supplierDTO\"\n                                                   [selection]=\"selection\"\n                                                   (onNext)=\"onNext($event)\"\n                                                   (onBack)=\"onBack($event)\">\n            </supplier-registration-step3-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n    <ux-wizard-step label=\"{{ 'step4.supplier' | translate }}\"\n                    [isCompleted]=\"completed[3]\"\n                    [isActive]=\"active[3]\">\n        <uxWizardStepCustomContent>\n            <supplier-registration-step4-component *ngIf=\"active[3]\"\n                                                   [supplierDTO]=\"supplierDTO\"\n                                                   [nuts0]=\"nuts0\"\n                                                   [nuts3]=\"nuts3\"\n                                                   [selection]=\"selection\"\n                                                   [logoFile]=\"logoFile\"\n                                                   (onNext)=\"onNext($event)\"\n                                                   (gotoStep)=\"gotoStep($event)\"\n                                                   (onSuccess)=\"onSuccess($event)\"\n                                                   (onFailure)=\"onFailure($event)\">\n            </supplier-registration-step4-component>\n        </uxWizardStepCustomContent>\n    </ux-wizard-step>\n</ux-wizard-steps>\n\n<success-component *ngIf=\"successRegistration\"></success-component>\n<failure-component *ngIf=\"failureRegistration\"></failure-component>\n<helpdesk-form-component portal=\"Supplier\"></helpdesk-form-component>"

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/supplier-registration.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierRegistrationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SupplierRegistrationComponent = (function () {
    function SupplierRegistrationComponent(nutsApi) {
        var _this = this;
        this.nutsApi = nutsApi;
        this.supplierDTO = new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]();
        this.supplierDTO.nutsIds = '';
        this.selection = [true, false];
        this.completed = [false, false, false, false];
        this.active = [true, false, false, false];
        this.successRegistration = false;
        this.failureRegistration = false;
        this.nuts0 = [];
        this.nuts3 = [];
        this.allCountries = [];
        this.allRegions = [];
        this.nutsApi.findNutsByLevel(0).subscribe(function (countries) {
            var _loop_1 = function (country) {
                var selectCountry = {
                    label: ' ' + country.name,
                    value: country
                };
                _this.allCountries.push(selectCountry);
                if (!_this.nuts3[country.name]) {
                    _this.nuts3[country.name] = [];
                }
                _this.allRegions[country.name] = [];
                _this.nutsApi.findCountryRegions(country.countryCode).subscribe(function (regions) {
                    for (var _i = 0, regions_1 = regions; _i < regions_1.length; _i++) {
                        var region = regions_1[_i];
                        var selectRegion = {
                            label: ' ' + region.name,
                            value: region
                        };
                        _this.allRegions[country.name].push(selectRegion);
                    }
                });
            };
            for (var _i = 0, countries_1 = countries; _i < countries_1.length; _i++) {
                var country = countries_1[_i];
                _loop_1(country);
            }
        });
    }
    SupplierRegistrationComponent.prototype.onNext = function (step) {
        this.completed[step - 1] = true;
        this.active[step - 1] = false;
        this.active[step] = true;
    };
    SupplierRegistrationComponent.prototype.gotoStep = function (step) {
        switch (step) {
            case 1:
                this.completed = [false, false, false, false];
                this.active = [true, false, false, false];
                break;
            case 2:
                this.completed = [true, false, false, false];
                this.active = [false, true, false, false];
                break;
            case 3:
                this.completed = [true, true, false, false];
                this.active = [false, false, true, false];
                break;
            case 4:
                this.completed = [true, true, true, false];
                this.active = [false, false, false, true];
                break;
        }
    };
    SupplierRegistrationComponent.prototype.onBack = function (step) {
        this.completed[step - 1] = false;
        this.active[step - 1] = true;
        this.active[step] = false;
    };
    SupplierRegistrationComponent.prototype.onSuccess = function (value) {
        this.successRegistration = value;
    };
    SupplierRegistrationComponent.prototype.onFailure = function (value) {
        this.failureRegistration = value;
    };
    SupplierRegistrationComponent.prototype.onLogoSubmit = function (event) {
        var _this = this;
        if (event) {
            this.logoFile = event;
            var reader_1 = new FileReader();
            reader_1.onload = function (e) {
                _this.supplierDTO.logo = reader_1.result;
            };
            reader_1.readAsDataURL(event);
        }
        else {
            this.logoFile = null;
        }
    };
    return SupplierRegistrationComponent;
}());
SupplierRegistrationComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+supplier-registration/supplier-registration.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__["a" /* NutsApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _a || Object])
], SupplierRegistrationComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration.component.js.map

/***/ }),

/***/ "../../../../../src/app/+supplier-registration/supplier-registration.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SupplierRegistrationModule", function() { return SupplierRegistrationModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng2_google_recaptcha__ = __webpack_require__("../../../../ng2-google-recaptcha/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__supplier_registration_component__ = __webpack_require__("../../../../../src/app/+supplier-registration/supplier-registration.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__supplier_registration_step1_supplier_registration_step1_component__ = __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step1/supplier-registration-step1.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__supplier_registration_step2_supplier_registration_step2_component__ = __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step2/supplier-registration-step2.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__supplier_registration_step3_supplier_registration_step3_component__ = __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step3/supplier-registration-step3.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__supplier_registration_step4_supplier_registration_step4_component__ = __webpack_require__("../../../../../src/app/+supplier-registration/+supplier-registration-step4/supplier-registration-step4.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__supplier_registration_routing_module__ = __webpack_require__("../../../../../src/app/+supplier-registration/supplier-registration-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_primeng_primeng__ = __webpack_require__("../../../../primeng/primeng.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_primeng_primeng___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_primeng_primeng__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










var SupplierRegistrationModule = (function () {
    function SupplierRegistrationModule() {
    }
    return SupplierRegistrationModule;
}());
SupplierRegistrationModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */], __WEBPACK_IMPORTED_MODULE_8__supplier_registration_routing_module__["a" /* SupplierRegistrationRoutingModule */], __WEBPACK_IMPORTED_MODULE_2_ng2_google_recaptcha__["a" /* Ng2GoogleRecaptchaModule */], __WEBPACK_IMPORTED_MODULE_9_primeng_primeng__["FileUploadModule"]
        ],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_3__supplier_registration_component__["a" /* SupplierRegistrationComponent */], __WEBPACK_IMPORTED_MODULE_4__supplier_registration_step1_supplier_registration_step1_component__["a" /* SupplierRegistrationComponentStep1 */], __WEBPACK_IMPORTED_MODULE_5__supplier_registration_step2_supplier_registration_step2_component__["a" /* SupplierRegistrationComponentStep2 */], __WEBPACK_IMPORTED_MODULE_6__supplier_registration_step3_supplier_registration_step3_component__["a" /* SupplierRegistrationComponentStep3 */], __WEBPACK_IMPORTED_MODULE_7__supplier_registration_step4_supplier_registration_step4_component__["a" /* SupplierRegistrationComponentStep4 */]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_3__supplier_registration_component__["a" /* SupplierRegistrationComponent */]]
    })
], SupplierRegistrationModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/supplier-registration.module.js.map

/***/ })

});
//# sourceMappingURL=supplier-registration.module.chunk.js.map