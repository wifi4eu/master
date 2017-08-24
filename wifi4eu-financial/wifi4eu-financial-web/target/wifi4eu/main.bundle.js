webpackJsonp(["main"],{

/***/ "../../../../../src lazy recursive":
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"app/+beneficiary-portal/beneficiary-portal.module": [
		"../../../../../src/app/+beneficiary-portal/beneficiary-portal.module.ts",
		"beneficiary-portal.module",
		"common"
	],
	"app/+beneficiary-registration/registration.module": [
		"../../../../../src/app/+beneficiary-registration/registration.module.ts",
		"registration.module",
		"common"
	],
	"app/+dgconn-portal/+statistics/statistics.module": [
		"../../../../../src/app/+dgconn-portal/+statistics/statistics.module.ts",
		"statistics.module",
		"common"
	],
	"app/+dgconn-portal/dgconnportal.module": [
		"../../../../../src/app/+dgconn-portal/dgconnportal.module.ts",
		"dgconnportal.module",
		"common"
	],
	"app/+supplier-portal/supplier-portal.module": [
		"../../../../../src/app/+supplier-portal/supplier-portal.module.ts",
		"supplier-portal.module",
		"common"
	],
	"app/+supplier-registration/supplier-registration.module": [
		"../../../../../src/app/+supplier-registration/supplier-registration.module.ts",
		"supplier-registration.module",
		"common"
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return Promise.all(ids.slice(1).map(__webpack_require__.e)).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
module.exports = webpackAsyncContext;
webpackAsyncContext.id = "../../../../../src lazy recursive";

/***/ }),

/***/ "../../../../../src/app/+abac/abac.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ui-g\">\n\t<div class=\"ui-lg-3\"></div>\n\t<div class=\"ui-lg-6 abac--container\">\n\t\t<h1>Abac</h1>\n\t\t<div class=\"abac--exporter\">\n\t\t\t<p>Export Publications appliers information.\n\t\t\t\t<i class=\"fa fa-check\" aria-hidden=\"true\" *ngIf=\"isExportSuccessful && showExportIcon\"></i>\n\t\t\t\t<i class=\"fa fa-times\" aria-hidden=\"true\" *ngIf=\"!isExportSuccessful && showExportIcon\"></i>\n\t\t\t\t<i class=\"fa fa-spinner\" aria-hidden=\"true\" *ngIf=\"isExportLoading\"></i>\n\t\t\t</p>\n\t\t\t<button class=\"btn btn-primary\" (click)=\"onExportButton()\">\n\t\t\t\tExport\n            </button>\n\t\t\t<p *ngIf=\"exportErrorMessage\"><span class=\"error--message\">Error:</span> {{ exportErrorMessage }}</p>\n\t\t</div>\n\t\t<div class=\"abac--validator\">\n\t\t\t<p>Import Abac validations results\n\t\t\t\t<i class=\"fa fa-check\" aria-hidden=\"true\" *ngIf=\"isImportSuccessful && showImportIcon\"></i>\n\t\t\t\t<i class=\"fa fa-times\" aria-hidden=\"true\" *ngIf=\"!isImportSuccessful && showImportIcon\"></i>\n\t\t\t\t<i class=\"fa fa-spinner\" aria-hidden=\"true\" *ngIf=\"isImportLoading\"></i>\n\t\t\t</p>\n\t\t\t<input type=\"file\" id=\"abacValidationFile\" (change)=\"onFileSelection($event)\" accept=\".json,application/json\">\n\t\t\t<p *ngIf=\"importErrorMessage\"><span class=\"error--message\">Error:</span> {{ importErrorMessage }}</p>\n\t\t</div>\n\t</div>\n\t<div class=\"ui-lg-3\"></div>\n</div>\n<div class=\"ui-g\">\n\t<div class=\"ui-lg-2\"></div>\n\t<div class=\"ui-lg-8 abac--table\">\n\t\t<h1>Publication appliers</h1>\n\t\t<div class=\"abac--table--container\">\n\t\t\t<div class=\"publication--selector\">\n\t\t\t\t<select (change)=\"onPublicationChange($event.target.value)\">\n\t\t\t\t\t<option>-- Select publication</option>\n\t\t\t\t\t<option *ngFor=\"let pub of publications; let i = index\" value=\"{{ pub.key }}\">\n\t\t\t\t\t\t{{ pub.value }}\n\t\t\t\t\t</option>\n\t\t\t\t</select>\n\t\t\t</div>\n\t\t\t<p-dataTable [value]=\"tableAppliers\" *ngIf=\"tableAppliers\">\n\t\t\t\t<p-column field=\"beneficiaryName\" header=\"{{ 'beneficiary.label' | translate }}\" [sortable]=\"false\"></p-column>\n\t\t\t\t<p-column field=\"supplierName\" header=\"{{ 'supplier.label' | translate }}\" [sortable]=\"false\">\n\t\t\t\t\t<template pTemplate=\"body\" let-applier=\"rowData\">\n\t\t\t\t\t\t<span *ngIf=\"applier.supplierName\">\n\t\t\t\t\t\t\t{{applier.supplierName}}\n\t\t\t\t\t\t</span>\n\t\t\t\t\t\t<span *ngIf=\"!applier.supplierName\">\n\t\t\t\t\t\t\t<b><i>Not selected</i></b>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</template>\n\t\t\t\t</p-column>\n\t\t\t\t<p-column field=\"isBudgedCommited\" header=\"{{ 'isBudgedCommited.label' | translate }}\" [sortable]=\"false\"></p-column>\n\t\t\t\t<p-column field=\"isBudgedLinked\" header=\"{{ 'isBudgedLinked.label' | translate }}\" [sortable]=\"false\"></p-column>\n\t\t\t\t<p-column field=\"isAwarded\" header=\"{{ 'isAwarded.label' | translate }}\" [sortable]=\"false\"></p-column>\n\t\t\t\t<p-column field=\"lastAbacMessage\" header=\"{{ 'lastAbacMessage.label' | translate }}\" [sortable]=\"false\"></p-column>\n\t\t\t\t<p-column field=\"abacStatus\" header=\"{{ 'abacStatus.label' | translate }}\" [sortable]=\"false\">\n\t\t\t\t\t<template pTemplate=\"body\" let-applier=\"rowData\">\n\t\t\t\t\t\t<span *ngIf=\"applier.abacStatus\">\n\t\t\t\t\t\t\t<div class=\"green-abacStatus\"></div> <b class=\"info-abacStatus\">READY</b>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t\t<span *ngIf=\"!applier.abacStatus\">\n\t\t\t\t\t\t\t<div class=\"red-abacStatus\"></div> <b class=\"info-abacStatus\">NOT READY</b>\n\t\t\t\t\t\t</span>\n\t\t\t\t\t</template>\n\t\t\t\t</p-column>\n\t\t\t</p-dataTable>\n\t\t</div>\n\t</div>\n\t<div class=\"ui-lg-2\"></div>\n</div>\n\n"

/***/ }),

/***/ "../../../../../src/app/+abac/abac.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AbacComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_AbacApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/AbacApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_CallApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/CallApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_file_saver__ = __webpack_require__("../../../../file-saver/FileSaver.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_file_saver___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_file_saver__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AbacComponent = (function () {
    function AbacComponent(abacApi, callApi) {
        this.abacApi = abacApi;
        this.callApi = callApi;
        this.isExportSuccessful = false;
        this.isImportSuccessful = false;
        this.showExportIcon = false;
        this.showImportIcon = false;
        this.isExportLoading = false;
        this.isImportLoading = false;
        this.publications = [];
    }
    AbacComponent.prototype.ngOnInit = function () {
        this.getAllPublications();
    };
    AbacComponent.prototype.getAllPublications = function () {
        var _this = this;
        this.callApi.allCalls().subscribe(function (data) {
            for (var i = 0; i < data.length; i++) {
                _this.publications.push({
                    key: data[i].callId,
                    value: data[i].event
                });
            }
        }, function (error) {
            console.log("Failed to present current publications");
        });
    };
    AbacComponent.prototype.onExportButton = function () {
        var _this = this;
        this.isExportLoading = true;
        this.isExportSuccessful = false;
        this.showExportIcon = false;
        this.exportErrorMessage = "";
        this.abacApi.exportAbacInformation().subscribe(function (data) {
            if (data['success']) {
                var blob = new Blob([data['data']], { type: 'application/json' });
                __WEBPACK_IMPORTED_MODULE_3_file_saver__["saveAs"](blob, "abacExportInformation.json");
                _this.isExportLoading = false;
                _this.isExportSuccessful = true;
                _this.showExportIcon = true;
            }
            else {
                _this.exportErrorMessage = data['error']['errorMessage'];
                _this.isExportLoading = false;
                _this.isExportSuccessful = false;
                _this.showExportIcon = true;
            }
        }, function (error) {
            _this.isExportLoading = false;
            _this.isExportSuccessful = false;
            _this.showExportIcon = true;
            console.log("Could not export. Contact your administrator");
        });
    };
    AbacComponent.prototype.onPublicationChange = function (selectedKey) {
        var _this = this;
        this.abacApi.getPublicationAppliersInfo(selectedKey).subscribe(function (data) {
            console.log(data);
            if (data && data['success']) {
                _this.tableAppliers = JSON.parse(data['data']);
                console.log(_this.tableAppliers);
            }
        }, function (error) {
            console.log("Error. Contact your administrator");
        });
    };
    AbacComponent.prototype.onFileSelection = function (event) {
        var _this = this;
        if (event && event.target && event.target.files && event.target.files.length == 1) {
            this.isImportLoading = true;
            this.isImportSuccessful = false;
            this.showImportIcon = false;
            this.importErrorMessage = "";
            var file = event.target.files["0"];
            var reader_1 = new FileReader();
            reader_1.onload = function (e) {
                _this.abacApi.importAbacInformation(reader_1.result).subscribe(function (data) {
                    if (data['success']) {
                        _this.isImportLoading = false;
                        _this.isImportSuccessful = true;
                        _this.showImportIcon = true;
                    }
                    else {
                        _this.importErrorMessage = data['error']['errorMessage'];
                        _this.isImportLoading = false;
                        _this.isImportSuccessful = false;
                        _this.showImportIcon = true;
                    }
                }, function (error) {
                    _this.isImportLoading = false;
                    _this.isImportSuccessful = false;
                    _this.showImportIcon = true;
                });
            };
            reader_1.readAsText(file);
        }
    };
    return AbacComponent;
}());
AbacComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+abac/abac.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_AbacApi__["a" /* AbacApi */], __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_CallApi__["a" /* CallApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_AbacApi__["a" /* AbacApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_AbacApi__["a" /* AbacApi */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_CallApi__["a" /* CallApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_CallApi__["a" /* CallApi */]) === "function" && _b || Object])
], AbacComponent);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/abac.component.js.map

/***/ }),

/***/ "../../../../../src/app/+activation/activation.component.html":
/***/ (function(module, exports) {

module.exports = "<form (ngSubmit)=\"onSubmit()\" #activatedForm=\"ngForm\">\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-lg-3\"></div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n            <div class=\"form-group\">\n\n                <p class=\"h2 h2-title center beneficiaryTitle \">{{ 'select.newPassword' | translate }}</p>\n                <p>{{ 'select.password' | translate }}</p>\n\n                <label for=\"password\" class=\"label floatLeft labelForgot\">{{ 'password.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"activationDTO.password\"\n                       id=\"password\" class=\"form-control paddingInput\" name=\"password\"\n                       ngcontrol=\"activationDTO.password\"\n                       #password=\"ngModel\" minlength=\"8\"\n                       (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"password.valid || password.pristine\" class=\"alert alert-danger\">\n                    {{ 'password.required' | translate }}\n                </div>\n\n                <label for=\"confirmPassword\" class=\"label floatLeft labelForgot\">\n                    {{ 'confirmNewPassword.label' | translate }}\n                </label>\n                <input type=\"password\"\n                       [(ngModel)]=\"repeatPassword\"\n                       id=\"confirmPassword\" class=\"form-control paddingInput\" name=\"confirmPassword\"\n                       ngcontrol=\"repeatPassword\"\n                       #confirmPassword=\"ngModel\" minlength=\"8\"\n                       (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"confirmPassword.valid || confirmPassword.pristine\" class=\"alert alert-danger\">\n                    {{ 'newPassword.required' |translate }}\n                </div>\n\n            </div>\n        </div>\n        <div class=\"ui-lg-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-lg-3\"></div>\n        <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn btn-primary cancel-button\">\n                {{ 'cancel.button' | translate }}\n            </button>\n        </div>\n        <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary publish-button\"\n                    [disabled]=\"!activatedForm.form.valid || !checkPassword()\">\n                {{ 'confirm.button' | translate }}\n            </button>\n        </div>\n        <div class=\"ui-lg-3\"></div>\n    </div>\n</form>"

/***/ }),

/***/ "../../../../../src/app/+activation/activation.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ActivationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_UserApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/UserApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_swagger_model_ActivateAccountDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/ActivateAccountDTO.ts");
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
    function ActivationComponent(userApi, uxService, route, router) {
        this.userApi = userApi;
        this.uxService = uxService;
        this.route = route;
        this.router = router;
        this.activationDTO = new __WEBPACK_IMPORTED_MODULE_4__shared_swagger_model_ActivateAccountDTO__["a" /* ActivateAccountDTOBase */]();
    }
    ActivationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.subscribe(function (params) { return _this.activationDTO.token = params['token']; });
    };
    ActivationComponent.prototype.checkPassword = function () {
        return this.activationDTO.password === this.repeatPassword;
    };
    ActivationComponent.prototype.onSubmit = function () {
        var _this = this;
        this.userApi.activateAccount(this.activationDTO).subscribe(function (data) {
            _this.uxService.growl({
                severity: 'success',
                summary: 'SUCCESS',
                detail: 'User activation success'
            });
            console.log('SUCCESS: User activation success');
            _this.router.navigateByUrl("/login");
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get activate account, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get activate account', error);
        });
    };
    return ActivationComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('activationDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4__shared_swagger_model_ActivateAccountDTO__["a" /* ActivateAccountDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__shared_swagger_model_ActivateAccountDTO__["a" /* ActivateAccountDTOBase */]) === "function" && _a || Object)
], ActivationComponent.prototype, "activationDTO", void 0);
ActivationComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+activation/activation.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_UserApi__["a" /* UserApi */]] }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_UserApi__["a" /* UserApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_UserApi__["a" /* UserApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["ActivatedRoute"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_2__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_router__["Router"]) === "function" && _e || Object])
], ActivationComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/activation.component.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-registration/+beneficiary-registration-step3/beneficiaryDTO.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryDTO; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__mayorDTO_model__ = __webpack_require__("../../../../../src/app/+beneficiary-registration/+beneficiary-registration-step3/mayorDTO.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__legalEntityDTO_model__ = __webpack_require__("../../../../../src/app/+beneficiary-registration/+beneficiary-registration-step3/legalEntityDTO.model.ts");
/**
 * Created by roger on 2/16/17.
 */


var BeneficiaryDTO = (function () {
    function BeneficiaryDTO() {
        this.mayorDTO = new __WEBPACK_IMPORTED_MODULE_0__mayorDTO_model__["a" /* MayorDTO */]();
        this.legalEntityDTO = new __WEBPACK_IMPORTED_MODULE_1__legalEntityDTO_model__["a" /* LegalEntityDTO */]();
    }
    return BeneficiaryDTO;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/beneficiaryDTO.model.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-registration/+beneficiary-registration-step3/legalEntityDTO.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LegalEntityDTO; });
var LegalEntityDTO = (function () {
    function LegalEntityDTO() {
    }
    return LegalEntityDTO;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/legalEntityDTO.model.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-registration/+beneficiary-registration-step3/mayorDTO.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MayorDTO; });
var MayorDTO = (function () {
    function MayorDTO() {
    }
    return MayorDTO;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/mayorDTO.model.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+map/map.component.html":
/***/ (function(module, exports) {

module.exports = "<div id=\"map\">\n</div>\n\n<div class=\"marginTopStats\"></div>\n<div class=\"row tableTitle\">\n    <div class=\"col-md-10\">\n        <h2 class=\"h2Table\">{{ 'report1.title' | translate }}</h2>\n    </div>\n    <div class=\"col-md-2\">\n        <a (click)=\"addNewElement()\" class=\"edit editTable\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i>{{'stats.downloadData' | translate }}</a>\n    </div>\n</div>\n<p-dataTable [value]=\"tableData\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n    <p-column field=\"name\" header=\"{{ 'memberState' | translate }}\" [sortable]=\"true\"></p-column>\n    <p-column field=\"municipalities\" header=\"{{ 'applications' | translate }}\" [sortable]=\"true\"></p-column>\n    <p-column field=\"requests\" header=\"{{ 'verifications' | translate }}\" [sortable]=\"true\"></p-column>\n    <p-column field=\"awarded\" header=\"{{ 'voucher.dashboard' | translate }}\" [sortable]=\"true\"></p-column>\n</p-dataTable>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+map/map.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export countryInformation */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MapComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_DgconnApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/DgconnApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var countryInformation;
var MapComponent = (function () {
    function MapComponent(dgconnApi) {
        this.dgconnApi = dgconnApi;
        //console.log("Constructor");
        //console.log(Object.keys(esri));
        this.loadMapInformation();
        this.tableData = [];
    }
    MapComponent.prototype.loadMapInformation = function () {
        var _this = this;
        this.dgconnApi.getCountriesVoucherInfo().subscribe(function (data) {
            countryInformation = JSON.parse(data.data);
            for (var property in countryInformation) {
                _this.tableData.push(countryInformation[property]);
            }
            _this.loadMap();
        });
    };
    MapComponent.prototype.loadMap = function () {
        window.onload = function () {
            //Bounds and map definition
            //console.log(Object.keys(esri));
            var bounds = new esri.geometry.Extent({ "xmin": -6767978.981609231, "ymin": 2591986.6022099443, "xmax": 8559731.130780501, "ymax": 11154688.85635359, "spatialReference": { "wkid": 102100 } });
            var map = new esri.Map("map", { extent: bounds, logo: false });
            var zoomTo = function (level) {
                var zoomLevels = {
                    0: 11205991,
                    1: 10507430,
                    2: 5253710,
                    3: 2626850,
                    4: 656710
                };
                this.map.setScale(zoomLevels[level]);
            };
            var templateCustomContent = function (value) {
                var outputString = "Municipalites: %m <br /> Requests: %r <br /> Awarded: %a";
                if (value && value.attributes && value.attributes.NUTS_ID && countryInformation[value.attributes.NUTS_ID]) {
                    outputString = outputString.replace("%m", countryInformation[value.attributes.NUTS_ID].municipalities);
                    outputString = outputString.replace("%r", countryInformation[value.attributes.NUTS_ID].requests);
                    outputString = outputString.replace("%a", countryInformation[value.attributes.NUTS_ID].awarded);
                }
                else {
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
        };
    };
    return MapComponent;
}());
MapComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'map-component',
        template: __webpack_require__("../../../../../src/app/+dgconn-portal/+map/map.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_DgconnApi__["a" /* DgconnApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_DgconnApi__["a" /* DgconnApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_DgconnApi__["a" /* DgconnApi */]) === "function" && _a || Object])
], MapComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/map.component.js.map

/***/ }),

/***/ "../../../../../src/app/+ecas/ecas.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ui-g center\">\n    <a href=\"https://webgate.ec.europa.eu/cas/login\">Ecas LINK</a>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+ecas/ecas.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EcasComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var EcasComponent = (function () {
    function EcasComponent() {
    }
    EcasComponent.prototype.ecas = function () {
    };
    return EcasComponent;
}());
EcasComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+ecas/ecas.component.html")
    })
], EcasComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/ecas.component.js.map

/***/ }),

/***/ "../../../../../src/app/+forgot/forgot-details.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ForgotDetails; });
var ForgotDetails = (function () {
    function ForgotDetails(email, token, password, confirmPassword) {
        this.email = email;
        this.token = token;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    return ForgotDetails;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/forgot-details.model.js.map

/***/ }),

/***/ "../../../../../src/app/+forgot/forgot.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n    <form *ngIf=\"!this.compareURls\" (ngSubmit)=\"onSendEmail()\" #emailForm=\"ngForm\">\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-lg-3\"></div>\n            <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                <div class=\"form-group\">\n\n                    <p class=\"h2 h2-title center beneficiaryTitle\">{{ 'forgot.title' | translate}}</p>\n                    <p class=\"text-align-center\">{{ 'email.forgot' | translate}}</p>\n\n                    <label for=\"email\" class=\"label floatLeft labelForgot\">{{ 'email.label' | translate }}</label>\n                    <input type=\"email\" [(ngModel)]=\"forgotDetails.email\" id=\"email\" class=\"form-control  paddingInput\" name=\"email\"\n                           ngcontrol=\"forgotDetails.email\" #email=\"ngModel\" pattern=\"^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,5})+$\" required>\n                    <div [hidden]=\"email.valid || email.pristine\" class=\"alert alert-danger\">{{ 'email.required' |translate }}</div>\n                </div>\n            </div>\n            <div class=\"ui-lg-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-lg-3\"></div>\n            <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                <button type=\"button\" class=\"btn btn-primary cancel-button\">{{ 'cancel.button' | translate }}</button>\n            </div>\n            <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!emailForm.form.valid\">\n                    {{ 'confirm.button' | translate }}\n                </button>\n            </div>\n            <div class=\"ui-lg-3\"></div>\n        </div>\n    </form>\n\n    <form *ngIf=\"this.compareURls\" (ngSubmit)=\"onNewPassword()\" #forgotForm=\"ngForm\">\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-lg-3\"></div>\n            <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                <div class=\"form-group\">\n                    <p class=\"h2 h2-title center\">{{ 'select.newPassword' | translate }}</p>\n                    <p class=\"text-align-center\">{{ 'select.password' | translate }}</p>\n                    <label for=\"password\" class=\"label floatLeft labelForgot\">{{ 'password.label' | translate }}</label>\n                    <input type=\"password\" [(ngModel)]=\"forgotDetails.password\"\n                           id=\"password\" class=\"form-control  paddingInput\" name=\"password\"\n                           ngcontrol=\"forgotDetails.password\"\n                           #password=\"ngModel\" minlength=\"8\"\n                           (keyup)=\"checkPassword()\" required>\n                    <div [hidden]=\"password.valid || password.pristine\" class=\"alert alert-danger\">{{ 'password.required' | translate }}</div>\n\n                    <label for=\"confirmPassword\" class=\"label floatLeft labelForgot\">{{ 'confirmNewPassword.label' | translate }}</label>\n                    <input type=\"password\" [(ngModel)]=\"forgotDetails.confirmPassword\" id=\"confirmPassword\" class=\"form-control paddingInput\" name=\"confirmPassword\"\n                           ngcontrol=\"forgotDetails.confirmPassword\" #confirmPassword=\"ngModel\" minlength=\"8\" (keyup)=\"checkPassword()\" required>\n                    <div [hidden]=\"confirmPassword.valid || confirmPassword.pristine\" class=\"alert alert-danger\">{{ 'newPassword.required' | translate }}</div>\n                </div>\n            </div>\n            <div class=\"ui-lg-3\"></div>\n        </div>\n        <div class=\"form-group ui-g\">\n            <div class=\"ui-lg-3\"></div>\n            <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                <button type=\"button\" class=\"btn btn-primary cancel-button\">{{ 'cancel.button' | translate }}</button>\n            </div>\n            <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!forgotForm.form.valid || !checkPassword()\">\n                    {{ 'confirm.button' | translate }}\n                </button>\n            </div>\n            <div class=\"ui-lg-3\"></div>\n        </div>\n    </form>\n\n</div>"

/***/ }),

/***/ "../../../../../src/app/+forgot/forgot.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ForgotComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__forgot_details_model__ = __webpack_require__("../../../../../src/app/+forgot/forgot-details.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_UserApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/UserApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var ForgotComponent = (function () {
    function ForgotComponent(uxService, route, router, userApi) {
        this.uxService = uxService;
        this.route = route;
        this.router = router;
        this.userApi = userApi;
    }
    ForgotComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.forgotDetails = new __WEBPACK_IMPORTED_MODULE_2__forgot_details_model__["a" /* ForgotDetails */]();
        this.route.params.subscribe(function (params) { return _this.forgotDetails.token = params['token']; });
        this.forgotUrl = window.location.href;
        this.compareURls = this.forgotUrl.includes("forgot;token=");
    };
    ForgotComponent.prototype.checkPassword = function () {
        return this.forgotDetails.password === this.forgotDetails.confirmPassword;
    };
    ForgotComponent.prototype.onSendEmail = function () {
        var _this = this;
        this.userApi.forgotPassword(this.forgotDetails.email).subscribe(function (data) {
            if (data['success']) {
                _this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'An email has been sent to your account with the instructions.'
                });
                console.log('SUCCESS: Forgot password success');
            }
            else {
                _this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'The email could not be sent. Please, try again later.'
                });
                console.log('ERROR: Could not sent the email. ');
            }
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not add new password, ignore this when NG is working in offline mode.'
            });
            console.log('WARNING: Could not add new password', error);
        });
    };
    ForgotComponent.prototype.onNewPassword = function () {
        var _this = this;
        this.userApi.activateAccount(this.forgotDetails).subscribe(function (data) {
            if (data['success']) {
                _this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'Password changed succesfully! Now you can login with your new password.'
                });
                console.log('SUCCESS: Change password success');
            }
            else {
                _this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'The password could not be changed. Please, try again later.'
                });
                console.log('ERROR: Could not change password. ');
            }
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not add new password, ignore this when NG is working in offline mode.'
            });
            console.log('WARNING: Could not add new password', error);
        });
    };
    return ForgotComponent;
}());
ForgotComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+forgot/forgot.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_UserApi__["a" /* UserApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__angular_router__["ActivatedRoute"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_router__["ActivatedRoute"]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__angular_router__["Router"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_UserApi__["a" /* UserApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_UserApi__["a" /* UserApi */]) === "function" && _d || Object])
], ForgotComponent);

var _a, _b, _c, _d;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/forgot.component.js.map

/***/ }),

/***/ "../../../../../src/app/+helpdesk/helpdesk.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n    <div class=\"ui-widget-header\" style=\"padding:5px 10px; margin-top: 15px;\">\n        <p><a class=\"downloadData\" (click)=\"helpdeskTable.exportCSV()\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i> {{'voucher.downloadData' | translate}}</a></p>\n    </div>\n    <p-dataTable #helpdeskTable [value]=\"issues\" [(selection)]=\"selectedIssues\" [rows]=\"10\" [paginator]=\"true\"\n                 [pageLinks]=\"3\" [rowsPerPageOptions]=\"[10,20,50,100]\" [globalFilter]=\"gb\">\n        <p-column [style]=\"{'width':'38px'}\" selectionMode=\"multiple\"></p-column>\n        <p-column field=\"portal\" header=\"{{ 'portal' | translate }}\" [sortable]=\"true\"></p-column>\n        <p-column field=\"topic\" header=\"{{ 'topic' | translate }}\" [sortable]=\"false\"></p-column>\n        <p-column field=\"memberState\" header=\"{{ 'memberState' | translate }}\" [sortable]=\"false\"></p-column>\n        <p-column field=\"date\" header=\"{{ 'dateandtime' | translate }}\" [sortable]=\"true\">\n            <template pTemplate=\"body\" let-issue=\"rowData\">\n                <span>{{issue.date | date: 'dd/MM/yyyy HH:mm'}}</span>\n            </template>\n        </p-column>\n        <p-column field=\"assignedTo\" header=\"{{ 'assignedTo' | translate }}\" [sortable]=\"true\"></p-column>\n        <p-column field=\"status\" header=\"{{ 'status' | translate }}\" [sortable]=\"true\"></p-column>\n        <p-column header=\"{{ 'details' | translate }}\">\n            <template pTemplate=\"body\" let-issue=\"rowData\" let-rowIndex=\"rowIndex\">\n                <button type=\"button\" class=\"btn\" style=\"background: none; padding: 0;\"\n                        (click)=\"viewIssueDetails(issue, rowIndex)\">\n                    <i class=\"fa fa-2x fa-eye\" style=\"font-size: 20px;\"></i> {{ 'view' | translate }}\n                </button>\n            </template>\n        </p-column>\n    </p-dataTable>\n    <div class=\"right\">\n        <button type=\"submit\" class=\"btn btn-primary cancel-button\" (click)=\"resolveIssues()\">{{ 'resolve' | translate }}</button>\n    </div>\n    <br>\n</div>\n    <!--MODAL Displayed -->\n    <p-dialog class=\"modalScroll\" [(visible)]=\"display\" [modal]=\"true\" [draggable]=\"false\" [closable]=\"false\" [responsive]=\"true\"\n              [closeOnEscape]=\"false\">\n        <button type=\"button\" class=\"closeButton\" (click)=\"cancel()\">X</button>\n        <h2 class=\"beneficiaryTitle labelModal supplier\">{{ 'issueDetails' | translate }}</h2>\n        <div   class=\"ui-g-12\" style=\"background: #F5F5F5;border: 1px solid #C1C1C1; margin-bottom: 20px\">\n            <div>\n                <span class=\"label floatLeft ui-g-12\">{{ 'assignedTo' | translate }}:\n                    <select [(ngModel)]=\"issueSelected.assignedTo\" name=\"assignedTo\">\n                        <option [selected]=\"issueSelected.assignedTo == 'Member State'\">Member State</option>\n                        <option [selected]=\"issueSelected.assignedTo == 'DG Connect'\">DG Connect</option>\n                    </select>\n                </span>\n            </div>\n            <div style=\"padding-bottom: 0;\">\n                <span class=\"label floatLeft ui-g-6\">{{ 'from' | translate }}: <b>{{issueSelected.from}}</b></span>\n                <span class=\"label floatLeft ui-g-6\">{{ 'memberState' | translate }}: <b>{{issueSelected.memberState}}</b></span>\n            </div>\n            <div style=\"padding-top: 0; padding-bottom: 0;\">\n                <span class=\"label floatLeft ui-g-6\">{{ 'topic' | translate }}: <b>{{issueSelected.topic}}</b></span>\n                <span class=\"label floatLeft ui-g-6\">{{ 'dateandtime' | translate }}: <b>{{issueSelected.date | date: 'dd/MM/yyyy HH:mm'}}</b></span>\n            </div>\n            <div style=\"padding-top: 0;\">\n                <span class=\"label floatLeft ui-g-6\">{{ 'portal' | translate }}: <b>{{issueSelected.portal}}</b></span>\n                <span class=\"label floatLeft ui-g-6\"></span>\n            </div>\n            <div class=\"form-group\">\n                <label class=\"label floatLeft ui-g-12\" for=\"issueSummary\" style=\"margin: 0;\">{{ 'issueSummary' | translate\n                    }}:</label>\n                <textarea id=\"issueSummary\" class=\"ui-g-12\" disabled [(ngModel)]=\"issueSelected.issueSummary\">{{issueSelected.issueSummary}}</textarea>\n            </div>\n            <!--<div class=\"form-group\">-->\n            <!--<label class=\"ui-g-12\" for=\"memberStateComments\" style=\"margin: 0;\">{{ 'memberStateComments' |-->\n            <!--translate}}:</label>-->\n            <!--<div *ngFor=\"let comment of issueSelected.comments; let i = index\">-->\n            <!--<textarea class=\"ui-g-12\" disabled [(ngModel)]=\"issueSelected.comments[i].comment\">{{comment.comment}}</textarea>-->\n            <!--</div>-->\n            <!--</div>-->\n        </div>\n        <h2 class=\"beneficiaryTitle labelModal supplier\">{{ 'comments' | translate }}</h2>\n        <div class=\"ui-g-12\" style=\"background: #F5F5F5;border: 1px solid #C1C1C1;\">\n            <div class=\"form-group ui-g-12\" *ngFor=\"let comment of issueSelected.comments; let i = index\">\n                <!--<label class=\"ui-g-12\" for=\"dgConnectComments\" style=\"margin: 0;\">{{ 'dgConnectComments' | translate }}:</label>-->\n                <div style=\"padding-bottom: 0;\">\n                    <span class=\"label floatLeft ui-g-12\">{{ 'by' | translate }}: <b>{{comment.type}}</b></span>\n                </div>\n                <div style=\"padding-bottom: 0;\">\n                    <span class=\"label floatLeft ui-g-12\">{{ 'dateandtime' | translate }}: <b>{{comment.commentDate}}</b></span>\n                </div>\n                <textarea class=\"label floatLeft ui-g-12\" disabled>{{comment.comment}}</textarea>\n                <br><br>\n            </div>\n        </div>\n        <div class=\"ui-g-12\" style=\"margin-top: 20px;\">\n            <span>\n                <button type=\"button\" class=\"btn cancel-button\"\n                        (click)=\"cancel()\">{{ 'cancel.button' | translate }}</button>\n            </span>\n            <span style=\"float: right;\">\n                <button type=\"button\" class=\"btn btn-primary publish-button\" (click)=\"setAsResolved()\" style=\"margin-right: 15px;\">{{ 'setAsResolved' | translate }}</button>\n                <button type=\"button\" class=\"btn btn-primary cancel-button\" (click)=\"keepAsPending()\">{{ 'keepAsPending' | translate }}</button>\n            </span>\n        </div>\n    </p-dialog>\n"

/***/ }),

/***/ "../../../../../src/app/+helpdesk/helpdesk.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HelpdeskComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_HelpdeskDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/HelpdeskDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_HelpdeskApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/HelpdeskApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var HelpdeskComponent = (function () {
    function HelpdeskComponent(helpdeskApi) {
        var _this = this;
        this.helpdeskApi = helpdeskApi;
        this.helpdeskApi.allHelpdeskIssues().subscribe(function (issues) { return _this.issues = issues; });
        this.issueSelected = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_HelpdeskDTO__["a" /* HelpdeskDTOBase */]();
        this.display = false;
    }
    HelpdeskComponent.prototype.viewIssueDetails = function (issue, rowIndex) {
        var _this = this;
        this.helpdeskApi.allHelpdeskIssues().subscribe(function (issues) { return _this.issues = issues; });
        this.helpdeskApi.getHelpdeskIssue(this.issues[rowIndex].issueId).subscribe(function (helpdeskIssue) { return _this.issueSelected = helpdeskIssue; });
        var makeIssueSelectedCopy = this.issues.slice(0, this.issues.length);
        this.display = true;
    };
    HelpdeskComponent.prototype.resolveIssues = function () {
        var _this = this;
        for (var i = 0; i < this.selectedIssues.length; i++) {
            this.selectedIssues[i].status = "Resolved";
            this.helpdeskApi.createHelpdeskIssue(this.selectedIssues[i]).subscribe();
        }
        this.helpdeskApi.allHelpdeskIssues().subscribe(function (issues) { return _this.issues = issues; });
    };
    HelpdeskComponent.prototype.setAsResolved = function () {
        var _this = this;
        this.display = false;
        this.issueSelected.status = "Resolved";
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(function (data) {
            _this.helpdeskApi.allHelpdeskIssues().subscribe(function (issues) { return _this.issues = issues; });
        }, function (error) {
            console.log(error);
        });
        this.issueSelected = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_HelpdeskDTO__["a" /* HelpdeskDTOBase */]();
    };
    HelpdeskComponent.prototype.keepAsPending = function () {
        var _this = this;
        this.display = false;
        this.issueSelected.status = "Pending";
        this.helpdeskApi.createHelpdeskIssue(this.issueSelected).subscribe(function (data) {
            _this.helpdeskApi.allHelpdeskIssues().subscribe(function (issues) { return _this.issues = issues; });
        }, function (error) {
            console.log(error);
        });
        this.issueSelected = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_HelpdeskDTO__["a" /* HelpdeskDTOBase */]();
    };
    HelpdeskComponent.prototype.cancel = function () {
        var _this = this;
        this.display = false;
        this.issueSelected = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_HelpdeskDTO__["a" /* HelpdeskDTOBase */]();
        this.helpdeskApi.allHelpdeskIssues().subscribe(function (issues) { return _this.issues = issues; });
    };
    return HelpdeskComponent;
}());
HelpdeskComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+helpdesk/helpdesk.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_HelpdeskApi__["a" /* HelpdeskApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_HelpdeskApi__["a" /* HelpdeskApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_api_HelpdeskApi__["a" /* HelpdeskApi */]) === "function" && _a || Object])
], HelpdeskComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/helpdesk.component.js.map

/***/ }),

/***/ "../../../../../src/app/+login/login.component.html":
/***/ (function(module, exports) {

module.exports = "<form (ngSubmit)=\"onSubmit()\" #loginForm=\"ngForm\">\n\n    <h3 class=\"center beneficiaryTitle labelModal\">{{ 'login.title' | translate }}</h3>\n\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-lg-3\"></div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n            <div class=\"form-group\">\n                <label for=\"email\">Email</label>\n                <input type=\"email\" [(ngModel)]=\"userDTO.email\"\n                       class=\"form-control\"\n                       name=\"email\" ngcontrol=\"email\"\n                       #email=\"ngModel\" required>\n                <div [hidden]=\"email.valid || email.pristine\"\n                     class=\"alert alert-danger\">Email is\n                    required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-lg-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-lg-3\"></div>\n        <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n            <div class=\"form-group\">\n                <label class=\"label\" for=\"password\">Password</label>\n                <input type=\"password\"\n                       [(ngModel)]=\"userDTO.password\"\n                       class=\"form-control\"\n                       name=\"password\" ngcontrol=\"password\"\n                       #password=\"ngModel\" required>\n                <div [hidden]=\"password.valid || password.pristine\"\n                     class=\"alert alert-danger\">Password is\n                    required\n                </div>\n            </div>\n        </div>\n        <div class=\"ui-lg-3\"></div>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-4\" style=\"text-align: center !important\">\n            <button type=\"submit\" class=\"btn btn-primary publish-button\"\n                    [disabled]=\"!loginForm.form.valid\">Login\n            </button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</form>\n<p-dialog [(visible)]=\"displayConfirmingData\" [modal]=\"true\" [responsive]=\"true\"\n          [resizable]=\"false\"\n          [draggable]=\"false\" [closable]=\"false\" [closeOnEscape]=\"false\">\n    <p class=\"ModalLoaderDots\"><span>.</span><span>.</span><span>.</span></p>\n    <h1 class=\"Modalh1Confirmation\">Confirming Data, please wait...</h1>\n    <p class=\"ModalpConfirmation\">Your registration to Wifi4EU is in the process\n        of being submitted.<br>Please don't\n        close this window.</p>\n</p-dialog>"

/***/ }),

/***/ "../../../../../src/app/+login/login.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__ = __webpack_require__("../../../../ng2-translate/ng2-translate.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_model_UserDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/UserDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_UserApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/UserApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__shared_shared_service__ = __webpack_require__("../../../../../src/app/shared/shared.service.ts");
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
    function LoginComponent(userApi, uxService, router, localStorage, sharedService, translate) {
        this.userApi = userApi;
        this.uxService = uxService;
        this.router = router;
        this.localStorage = localStorage;
        this.sharedService = sharedService;
        this.translate = translate;
        this.displayConfirmingData = false;
        this.userDTO = new __WEBPACK_IMPORTED_MODULE_3__shared_swagger_model_UserDTO__["a" /* UserDTOBase */]();
    }
    LoginComponent.prototype.onSubmit = function () {
        var _this = this;
        this.displayConfirmingData = true;
        this.userApi.login(this.userDTO).subscribe(function (response) {
            _this.displayConfirmingData = false;
            if (response['success']) {
                var user = response['data'];
                _this.localStorage.set('user', JSON.stringify(user));
                _this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'Login success'
                });
                _this.sharedService.emitChange();
                switch (user.userType) {
                    case 1:
                        _this.router.navigateByUrl("supplier-portal");
                        break;
                    case 2:
                    case 3:
                        _this.router.navigateByUrl("beneficiary-portal");
                        break;
                    case 5:
                        _this.router.navigateByUrl("dgconn-portal");
                        break;
                    default:
                        _this.router.navigateByUrl("home");
                        break;
                }
            }
            else {
                var detailTranslation_1 = 'Could not login, with these user and password';
                _this.translate.get('loging.error.wrongpassword').subscribe(function (res) {
                    detailTranslation_1 = res;
                });
                _this.uxService.growl({
                    severity: 'error',
                    summary: 'ERROR',
                    detail: detailTranslation_1
                });
                console.log('ERROR: Could not login, with these user password');
            }
        }, function (error) {
            _this.displayConfirmingData = false;
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not login, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not login', error);
        });
    };
    return LoginComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]) === "function" && _a || Object)
], LoginComponent.prototype, "onUpdateHeader", void 0);
LoginComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'login-component',
        template: __webpack_require__("../../../../../src/app/+login/login.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_UserApi__["a" /* UserApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_UserApi__["a" /* UserApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_UserApi__["a" /* UserApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__angular_router__["Router"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__["LocalStorageService"]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_7__shared_shared_service__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__shared_shared_service__["a" /* SharedService */]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["c" /* TranslateService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["c" /* TranslateService */]) === "function" && _g || Object])
], LoginComponent);

var _a, _b, _c, _d, _e, _f, _g;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/login.component.js.map

/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__home_home_component__ = __webpack_require__("../../../../../src/app/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__activation_activation_component__ = __webpack_require__("../../../../../src/app/+activation/activation.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__login_login_component__ = __webpack_require__("../../../../../src/app/+login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__forgot_forgot_component__ = __webpack_require__("../../../../../src/app/+forgot/forgot.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__helpdesk_helpdesk_component__ = __webpack_require__("../../../../../src/app/+helpdesk/helpdesk.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__not_found_not_found_component__ = __webpack_require__("../../../../../src/app/not-found/not-found.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__app_guard__ = __webpack_require__("../../../../../src/app/app.guard.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__abac_abac_component__ = __webpack_require__("../../../../../src/app/+abac/abac.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__ecas_ecas_component__ = __webpack_require__("../../../../../src/app/+ecas/ecas.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    return AppRoutingModule;
}());
AppRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
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
                    path: 'activation',
                    component: __WEBPACK_IMPORTED_MODULE_3__activation_activation_component__["a" /* ActivationComponent */]
                }, {
                    path: 'login',
                    component: __WEBPACK_IMPORTED_MODULE_4__login_login_component__["a" /* LoginComponent */]
                }, {
                    path: 'forgot',
                    component: __WEBPACK_IMPORTED_MODULE_5__forgot_forgot_component__["a" /* ForgotComponent */]
                }, {
                    path: 'registration',
                    loadChildren: 'app/+beneficiary-registration/registration.module#RegistrationModule'
                }, {
                    path: 'beneficiary-portal',
                    loadChildren: 'app/+beneficiary-portal/beneficiary-portal.module#BeneficiaryPortalModule',
                    canActivate: [__WEBPACK_IMPORTED_MODULE_8__app_guard__["a" /* AppGuard */]]
                }, {
                    path: 'helpdesk',
                    component: __WEBPACK_IMPORTED_MODULE_6__helpdesk_helpdesk_component__["a" /* HelpdeskComponent */],
                    canActivate: [__WEBPACK_IMPORTED_MODULE_8__app_guard__["a" /* AppGuard */]]
                }, {
                    path: 'dgconn-portal',
                    loadChildren: 'app/+dgconn-portal/dgconnportal.module#DgConnPortalModule',
                    canActivate: [__WEBPACK_IMPORTED_MODULE_8__app_guard__["a" /* AppGuard */]]
                }, {
                    path: 'supplier-registration',
                    loadChildren: 'app/+supplier-registration/supplier-registration.module#SupplierRegistrationModule'
                }, {
                    path: 'supplier-portal',
                    loadChildren: 'app/+supplier-portal/supplier-portal.module#SupplierPortalModule',
                    canActivate: [__WEBPACK_IMPORTED_MODULE_8__app_guard__["a" /* AppGuard */]]
                }, {
                    path: 'abac',
                    component: __WEBPACK_IMPORTED_MODULE_9__abac_abac_component__["a" /* AbacComponent */]
                }, {
                    path: 'ecas',
                    component: __WEBPACK_IMPORTED_MODULE_10__ecas_ecas_component__["a" /* EcasComponent */]
                }, {
                    path: 'notfound',
                    component: __WEBPACK_IMPORTED_MODULE_7__not_found_not_found_component__["a" /* NotFoundComponent */]
                }, {
                    path: '**',
                    redirectTo: 'notfound'
                }
            ], { useHash: true })],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
    })
], AppRoutingModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/app-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<ux-layout-app uxTrackScroll>\n    <uxLayoutAppMainContainer>\n        <ux-layout-app-main>\n            <uxLayoutAppMainHeaderContainer>\n                <ux-layout-header appFullName=\"Wifi4EU Free Wifi for Europeans\" appShortName=\"App\"\n                                  [userInfos]=\"userInfos\" [isCustomRightContent]=\"true\">\n                    <uxLayoutHeaderRightContent>\n                        <ux-language-selector [selectedLanguage]=\"selectedLanguage\" (languageChanged)=\"onLanguageChanged($event)\"></ux-language-selector>\n                        <div class=\"profile-wrapper\" isCompact=\"false\">\n                            <div class=\"left-panel\">\n                                <div *ngIf=\"user\" class=\"user-infos\">\n                                    <span class=\"wellcomeHeader\">Logged in as <a [routerLink]=\"profileUrl\"><strong\n                                            class=\"color-primary\">{{user.email}}</strong></a></span>\n                                    <button (click)=\"onLogout()\" class=\"headerButton\">Logout</button>\n                                </div>\n                                <div *ngIf=\"!user\" class=\"user-infos\">\n                                    <strong class=\"color-primary\">\n                                    </strong>\n                                    <button class=\"headerButton\" routerLink=\"/login\" routerLinkActive=\"active\">\n                                        Login\n                                    </button>\n                                </div>\n                            </div>\n                        </div>\n                    </uxLayoutHeaderRightContent>\n                </ux-layout-header>\n            </uxLayoutAppMainHeaderContainer>\n            <uxLayoutAppMainNavBarContainer>\n                <ux-layout-nav-bar>\n                    <ux-layout-nav-bar-top-menu homeUrl=\"home\" [links]=\"menuLinks\"></ux-layout-nav-bar-top-menu>\n                    <ux-layout-nav-bar-actions>\n                        <div *ngIf=\"user\">\n                            <ux-layout-nav-bar-action-item iconClass=\"fa-bars\" itemClass=\"app-menu\"\n                                                           isOverlayPanel=\"true\"\n                                                           userInfos=\"Logged in as {{user.email}}\"\n                                                           [links]=\"menuLinks\">\n                            </ux-layout-nav-bar-action-item>\n                        </div>\n                        <div *ngIf=\"!user\">\n                            <div class=\"clearfix\"></div>\n                            <ux-layout-nav-bar-action-item iconClass=\"fa-bars\" itemClass=\"app-menu\"\n                                                           isOverlayPanel=\"true\"\n                                                           [links]=\"menuLinks\"\n                                                           userInfos=\"Login\">\n                                Log out\n                            </ux-layout-nav-bar-action-item>\n                        </div>\n                    </ux-layout-nav-bar-actions>\n                </ux-layout-nav-bar>\n            </uxLayoutAppMainNavBarContainer>\n            <uxLayoutAppMainContentContainer>\n                <router-outlet></router-outlet>\n            </uxLayoutAppMainContentContainer>\n            <uxLayoutAppMainFooterContainer>\n                <ux-layout-footer isCompact=\"true\">\n                    {{ 'home.footer.update' | translate }}<a href=\"#\">{{ 'home.footer.top' | translate }}</a>\n                </ux-layout-footer>\n            </uxLayoutAppMainFooterContainer>\n        </ux-layout-app-main>\n    </uxLayoutAppMainContainer>\n</ux-layout-app>"

/***/ }),

/***/ "../../../../../src/app/app.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__ = __webpack_require__("../../../../ng2-translate/ng2-translate.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__core_core_service__ = __webpack_require__("../../../../../src/app/core/core.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-language-selector/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__shared_shared_service__ = __webpack_require__("../../../../../src/app/shared/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
var AppComponent = (function () {
    function AppComponent(router, translateService, coreService, uxService, localStorage, sharedService) {
        var _this = this;
        this.router = router;
        this.translateService = translateService;
        this.coreService = coreService;
        this.uxService = uxService;
        this.localStorage = localStorage;
        this.sharedService = sharedService;
        this.selectedLanguage = __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxEuLanguages */].languagesByCode['en'];
        translateService.setDefaultLang('en');
        var language = this.localStorage.get('lang');
        if (language) {
            this.translateService.use(language.toString());
            this.uxService.activeLanguage = __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxEuLanguages */].languagesByCode[language.toString()];
            this.selectedLanguage = __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxEuLanguages */].languagesByCode[language.toString()];
        }
        else {
            translateService.use('en');
            this.uxService.activeLanguage = __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxEuLanguages */].languagesByCode['en'];
            this.selectedLanguage = __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["a" /* UxEuLanguages */].languagesByCode['en'];
        }
        this.profileUrl = "";
        this.menuLinks = [new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Wifi4EU',
                children: [
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({ label: 'Free Wi-Fi for Europeans', url: 'home' }),
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({ label: 'Registration', url: 'registration' }),
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({ label: 'Beneficiary Portal', url: 'beneficiary-portal' }),
                    new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({ label: 'DGConnect Portal', url: 'dgconn-portal' })
                ]
            })];
        this.visibility = [false, false, false, false, false];
        this.children = [];
        this.initChildren();
        this.updateHeader();
        this.sharedService.changeEmitted.subscribe(function () { return _this.updateHeader(); });
    }
    AppComponent.prototype.updateHeader = function () {
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            switch (this.user.userType) {
                case 1:
                    this.profileUrl = "/supplier-portal/profile";
                    break;
                case 2:
                    this.profileUrl = "/beneficiary-portal/profile";
                    break;
                case 5:
                    this.profileUrl = "/dgconn-portal";
                    break;
                default:
                    break;
            }
        }
        for (var i_1 = 0; i_1 < this.visibility.length; i_1++)
            this.visibility[i_1] = false;
        var i = (this.user) ? this.user.userType : 0;
        this.menuLinks = [new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Wifi4EU',
                children: this.children[i]
            })];
    };
    AppComponent.prototype.onLanguageChanged = function (language) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
    };
    AppComponent.prototype.onLogout = function () {
        this.localStorage.remove('user');
        this.updateHeader();
        this.router.navigateByUrl("login");
    };
    AppComponent.prototype.initChildren = function () {
        this.children[0] = [
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Beneficiary Registration',
                url: 'registration'
            }),
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Supplier Registration',
                url: '/supplier-registration'
            })
        ];
        this.children[1] = [
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Supplier Registration',
                url: '/supplier-registration'
            }),
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Supplier Portal',
                url: '/supplier-portal'
            })
        ];
        this.children[2] = [
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Beneficiary Registration',
                url: '/registration'
            }),
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
            })
        ];
        this.children[3] = [
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Beneficiary Registration',
                url: '/registration'
            }),
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
            })
        ];
        this.children[4] = [
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'Member State Portal',
                url: '#'
            })
        ];
        this.children[5] = [
            new __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["c" /* UxLayoutLink */]({
                label: 'DGConnect Portal',
                url: 'dgconn-portal'
            })
        ];
    };
    return AppComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["b" /* UxLanguage */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_language_selector__["b" /* UxLanguage */]) === "function" && _a || Object)
], AppComponent.prototype, "selectedLanguage", void 0);
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'app-root', template: __webpack_require__("../../../../../src/app/app.component.html"), styles: [__webpack_require__("../../../../../src/app/app.component.scss")] }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_7__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__angular_router__["Router"]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["c" /* TranslateService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1_ng2_translate_ng2_translate__["c" /* TranslateService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_3__core_core_service__["a" /* CoreService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__core_core_service__["a" /* CoreService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_5_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5_angular_2_local_storage__["LocalStorageService"]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_6__shared_shared_service__["a" /* SharedService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__shared_shared_service__["a" /* SharedService */]) === "function" && _g || Object])
], AppComponent);

var _a, _b, _c, _d, _e, _f, _g;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.guard.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppGuard; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_angular_2_local_storage__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AppGuard = (function () {
    function AppGuard(localStorage, router) {
        this.localStorage = localStorage;
        this.router = router;
    }
    AppGuard.prototype.canActivate = function (route) {
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        var allow = false;
        switch (route.url[0].path) {
            case "map":
                allow = this.canActivateDgConn();
                break;
            case "beneficiary-portal":
                allow = this.canActivateBeneficiary();
                break;
            case "helpdesk":
                allow = this.canActivateMemberState() || this.canActivateDgConn();
                break;
            case "dgconn-portal":
                allow = this.canActivateDgConn();
                break;
            case "supplier-portal":
                allow = this.canActivateSupplier();
                break;
        }
        if (allow == false) {
            this.router.navigateByUrl("notfound");
        }
        return allow;
    };
    AppGuard.prototype.canActivateBeneficiary = function () {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 2 || this.user.userType == 3) ? true : false;
    };
    AppGuard.prototype.canActivateSupplier = function () {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 1) ? true : false;
    };
    AppGuard.prototype.canActivateMemberState = function () {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 4) ? true : false;
    };
    AppGuard.prototype.canActivateDgConn = function () {
        if (this.user === null) {
            return false;
        }
        return (this.user.userType == 5) ? true : false;
    };
    return AppGuard;
}());
AppGuard = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__angular_router__["Router"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_router__["Router"]) === "function" && _b || Object])
], AppGuard);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/app.guard.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export translateFactory */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__ = __webpack_require__("../../../../ng2-translate/ng2-translate.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__core_core_module__ = __webpack_require__("../../../../../src/app/core/core.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__core_core_service__ = __webpack_require__("../../../../../src/app/core/core.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__home_home_component__ = __webpack_require__("../../../../../src/app/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__dgconn_portal_map_map_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+map/map.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__activation_activation_component__ = __webpack_require__("../../../../../src/app/+activation/activation.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__login_login_component__ = __webpack_require__("../../../../../src/app/+login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__forgot_forgot_component__ = __webpack_require__("../../../../../src/app/+forgot/forgot.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_ng2_bs3_modal_ng2_bs3_modal__ = __webpack_require__("../../../../ng2-bs3-modal/ng2-bs3-modal.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_ng2_bs3_modal_ng2_bs3_modal___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_15_ng2_bs3_modal_ng2_bs3_modal__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__helpdesk_helpdesk_component__ = __webpack_require__("../../../../../src/app/+helpdesk/helpdesk.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__not_found_not_found_component__ = __webpack_require__("../../../../../src/app/not-found/not-found.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__app_guard__ = __webpack_require__("../../../../../src/app/app.guard.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_19_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__shared_shared_service__ = __webpack_require__("../../../../../src/app/shared/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_21__abac_abac_component__ = __webpack_require__("../../../../../src/app/+abac/abac.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_22__ecas_ecas_component__ = __webpack_require__("../../../../../src/app/+ecas/ecas.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23_ng2_charts__ = __webpack_require__("../../../../ng2-charts/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_23_ng2_charts___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_23_ng2_charts__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
///<reference path="+activation/activation.component.ts"/>
























function translateFactory(http) {
    return new __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__["d" /* TranslateStaticLoader */](http, './assets/i18n', '.json');
}
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_8__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_10__home_home_component__["a" /* HomeComponent */],
            __WEBPACK_IMPORTED_MODULE_11__dgconn_portal_map_map_component__["a" /* MapComponent */],
            __WEBPACK_IMPORTED_MODULE_12__activation_activation_component__["a" /* ActivationComponent */],
            __WEBPACK_IMPORTED_MODULE_13__login_login_component__["a" /* LoginComponent */],
            __WEBPACK_IMPORTED_MODULE_14__forgot_forgot_component__["a" /* ForgotComponent */],
            __WEBPACK_IMPORTED_MODULE_16__helpdesk_helpdesk_component__["a" /* HelpdeskComponent */],
            __WEBPACK_IMPORTED_MODULE_21__abac_abac_component__["a" /* AbacComponent */],
            __WEBPACK_IMPORTED_MODULE_22__ecas_ecas_component__["a" /* EcasComponent */],
            __WEBPACK_IMPORTED_MODULE_17__not_found_not_found_component__["a" /* NotFoundComponent */]
        ],
        exports: [
            __WEBPACK_IMPORTED_MODULE_11__dgconn_portal_map_map_component__["a" /* MapComponent */],
            __WEBPACK_IMPORTED_MODULE_12__activation_activation_component__["a" /* ActivationComponent */],
            __WEBPACK_IMPORTED_MODULE_13__login_login_component__["a" /* LoginComponent */],
            __WEBPACK_IMPORTED_MODULE_14__forgot_forgot_component__["a" /* ForgotComponent */],
            __WEBPACK_IMPORTED_MODULE_16__helpdesk_helpdesk_component__["a" /* HelpdeskComponent */],
            __WEBPACK_IMPORTED_MODULE_21__abac_abac_component__["a" /* AbacComponent */],
            __WEBPACK_IMPORTED_MODULE_22__ecas_ecas_component__["a" /* EcasComponent */],
            __WEBPACK_IMPORTED_MODULE_17__not_found_not_found_component__["a" /* NotFoundComponent */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_6__core_core_module__["a" /* CoreModule */],
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["BrowserModule"],
            __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__["b" /* TranslateModule */].forRoot({
                provide: __WEBPACK_IMPORTED_MODULE_4_ng2_translate_ng2_translate__["a" /* TranslateLoader */],
                useFactory: translateFactory,
                deps: [__WEBPACK_IMPORTED_MODULE_3__angular_http__["Http"]]
            }),
            __WEBPACK_IMPORTED_MODULE_9__app_routing_module__["a" /* AppRoutingModule */],
            __WEBPACK_IMPORTED_MODULE_2__angular_forms__["FormsModule"],
            __WEBPACK_IMPORTED_MODULE_15_ng2_bs3_modal_ng2_bs3_modal__["Ng2Bs3ModalModule"],
            __WEBPACK_IMPORTED_MODULE_19_angular_2_local_storage__["LocalStorageModule"].withConfig({
                prefix: 'wifi4eu',
                storageType: 'localStorage'
            }),
            __WEBPACK_IMPORTED_MODULE_23_ng2_charts__["ChartsModule"]
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */],
            __WEBPACK_IMPORTED_MODULE_7__core_core_service__["a" /* CoreService */],
            __WEBPACK_IMPORTED_MODULE_18__app_guard__["a" /* AppGuard */],
            __WEBPACK_IMPORTED_MODULE_20__shared_shared_service__["a" /* SharedService */]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_8__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/app.module.js.map

/***/ }),

/***/ "../../../../../src/app/core/core.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CoreModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var CoreModule = (function () {
    function CoreModule() {
    }
    return CoreModule;
}());
CoreModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */]],
        declarations: [],
        exports: [
            __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */]
        ]
    })
], CoreModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/core.module.js.map

/***/ }),

/***/ "../../../../../src/app/core/core.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CoreService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
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
    return CoreService;
}());
CoreService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _b || Object])
], CoreService);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/core.service.js.map

/***/ }),

/***/ "../../../../../src/app/home/home.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n\n<div class=\"first\">\n    <img id=\"first-background\" src=\"assets/images/group-6.png\" alt=\"\">\n    <div class=\"container-fluid header-fluid\">\n\n        <div class=\"contenedor row\">\n            <div class=\"col-xl-12\">\n                <img id=\"img-wifi\" src=\"assets/images/group.png\" alt=\"\">\n            </div>\n        </div>\n    </div>\n</div>\n<div class=\"container-fluid\">\n    <div class=\"contenedor row\">\n        <div class=\"col-xl-6 margin-top\">\n\n            <h2 class=\"title-home\">{{ 'home.part1.title' | translate }}</h2>\n            <p class=\"subtitle-home\">{{ 'home.part1.text1' | translate }}</p>\n            <p class=\"normal-text\">{{ 'home.part1.text2' | translate }}</p>\n        </div>\n        <div class=\"col-xl-6 margin-top-right\">\n            <p class=\"subtitle-bold-italic\"> {{ 'home.part1.text3' | translate\n                }}</p>\n            <p class=\"subtitle-italic\">{{ 'home.part1.author' | translate }}<br>\n                {{ 'home.part1.date' | translate }}</p>\n            <div id=\"img-europeans\">\n                <img src=\"assets/images/copy-2.png\" alt=\"\">\n            </div>\n        </div>\n    </div>\n</div>\n<div class=\"container-fluid second\">\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-6\">\n            <h1 class=\"benefit\">{{ 'home.part2.title' | translate }}</h1>\n            <h2 class=\"europeans\">{{ 'home.part2.subtitle1' | translate }}</h2>\n            <p class=\"europeans-text\">{{ 'home.part2.text1' | translate }}</p>\n            <div id=\"img-scnd\">\n                <img src=\"assets/images/copy-3.png\" alt=\"\">\n            </div>\n        </div>\n        <div class=\"col-xl-6\">\n            <h2 class=\"entities\">{{ 'home.part2.subtitle2' | translate }}</h2>\n            <p class=\"entities-text\">{{ 'home.part2.text2' | translate }}</p>\n            <a class=\"btn btn-primary video-button\"\n               href=\"https://youtu.be/FvaJIPg0Pxw\" target=\"_blank\">{{\n                'home.whatch.video' | translate }}</a>\n\n        </div>\n    </div>\n</div>\n<div class=\"container-fluid mayor\">\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-6\">\n            <h2 class=\"apply\">{{ 'home.part3.title' | translate }} </h2>\n            <p class=\"apply-text\">{{ 'home.part3.text1' | translate }}</p>\n        </div>\n        <div class=\"col-xl-6\">\n            <p class=\"apply-text\">{{ 'home.part3.text2' | translate }}</p>\n\n        </div>\n    </div>\n    <div class=\"row\">\n        <div class=\"col-xl-2\"></div>\n        <div class=\"col-xl-8\">\n            <div class=\"col-xl-6\">\n                <img class=\"mayor-img\"\n                     src=\"assets/images/account-balance-material-icons-regular.png\">\n                <p class=\"mayor-title\">{{ 'home.part3.title2' | translate }}</p>\n                <p class=\"represent\">{{ 'home.part3.subtitle' | translate }}</p>\n                <a class=\"btn btn-primary video-button center-block video-button\"\n                   href=\"#/registration\">{{ 'home.register' | translate }}</a>\n            </div>\n            <div class=\"col-xl-6\">\n                <img class=\"supplier-img\" src=\"assets/images/group-4.png\">\n                <p class=\"supplier\">{{ 'home.part3.title3' | translate }}</p>\n                <a class=\"btn btn-primary video-button center-block video-button\"\n                   href=\"#/supplier-registration\">{{ 'home.register' | translate\n                    }}</a>\n\n            </div>\n        </div>\n        <div class=\"col-xl-2\"></div>\n    </div>\n</div>\n<div class=\"container-fluid third\">\n    <div class=\"row contenedor\">\n\n    </div>\n</div>\n<div class=\"content azul container-fluid\">\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-12\">\n            <h2 class=\"information\">{{ 'home.part4.title1' | translate }}</h2>\n            <p class=\"text-information\">{{ 'home.part4.subtitle' | translate\n                }}</p>\n        </div>\n    </div>\n    <div class=\"row contenedor\">\n        <div class=\"col-xl-6\">\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"https://ec.europa.eu/digital-single-market/en/news/factsheet-wifi4eu\">{{\n                'home.part4.link1' | translate }}</a></p>\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"http://europa.eu/rapid/press-release_IP-16-4261_en.htm\">{{\n                'home.part4.link2' | translate }}</a></p>\n        </div>\n        <div class=\"col-xl-6\">\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"https://ec.europa.eu/digital-single-market/en/news/proposed-regulation-promotion-internet-connectivity-local-communities-and-public-spaces-wifi4eu\">{{\n                'home.part4.link3' | translate }}</a></p>\n            <p class=\"white-links\"><a target=\"_blank\"\n                                      href=\"https://ec.europa.eu/digital-single-market/events/cf/b-day-going-giga/document.cfm?doc_id=36544\">{{\n                'home.part4.link4' | translate }}</a></p>\n        </div>\n    </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/home/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var HomeComponent = (function () {
    function HomeComponent() {
    }
    return HomeComponent;
}());
HomeComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'app-home', template: __webpack_require__("../../../../../src/app/home/home.component.html") })
], HomeComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/home.component.js.map

/***/ }),

/***/ "../../../../../src/app/not-found/not-found.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <i class=\"zmdi zmdi-close-circle fa-3x\"></i><br>\n        <h2>Page not Found - ERROR 404</h2>\n        <p>The URL you've written doesn't seem to exist. Make sure you've typed it correctly and try again.</p>\n        <br><br>\n        <button class=\"btn btn-primary\" routerLink=\"/home\" routerLinkActive=\"active\">{{ 'backtohome.button' | translate }}</button>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/not-found/not-found.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NotFoundComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var NotFoundComponent = (function () {
    function NotFoundComponent() {
    }
    return NotFoundComponent;
}());
NotFoundComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'not-found-component', template: __webpack_require__("../../../../../src/app/not-found/not-found.component.html") })
], NotFoundComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/not-found.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/failure/failure.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <i class=\"zmdi zmdi-close-circle fa-3x\"></i><br>\n        <h2>{{ 'submitregistration.failure.title' | translate }}</h2>\n        <br>\n        <p>{{ 'submitregistration.failure.text.part1' | translate }}</p>\n        <br>\n        <button class=\"btn btn-primary\" routerLink=\"/home\" routerLinkActive=\"active\">{{ 'backtohome.button' |\n            translate}}\n        </button>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/shared/components/failure/failure.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FailureComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var FailureComponent = (function () {
    function FailureComponent() {
    }
    return FailureComponent;
}());
FailureComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'failure-component', template: __webpack_require__("../../../../../src/app/shared/components/failure/failure.component.html") })
], FailureComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/failure.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/helpdesk-form/helpdesk-form.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <p class=\"center\">\n        {{ 'helpdeskform.clickhere.label1' | translate }} <a (click)=\"expanded = true\">{{ 'helpdeskform.clickhere.label2' | translate }}</a>\n    </p>\n    <br>\n    <br>\n    <div id=\"helpdesk-form\" *ngIf=\"expanded\">\n\n        <hr class=\"center\" style=\"padding-bottom: 2em; margin-top: 2em !important;\">\n\n        <form *ngIf=\"!success\" (ngSubmit)=\"sendIssue()\" #issueForm=\"ngForm\">\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <label for=\"topic\" class=\"label floatLeft\">{{ 'helpdeskform.selectproblemtype' | translate }}</label>\n                    <select class=\"form-control\" name=\"topic\" id=\"topic\" [(ngModel)]=\"helpdeskIssue.topic\" required>\n                        <option value=\"Login\">{{ 'helpdeskform.problemtype.option1' | translate }}</option>\n                        <option value=\"Registration\">{{ 'helpdeskform.problemtype.option2' | translate }}</option>\n                        <option value=\"Password\">{{ 'helpdeskform.problemtype.option3' | translate }}</option>\n                        <option value=\"Other\">{{ 'helpdeskform.problemtype.option4' | translate }}</option>\n                    </select>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <label for=\"problem_desc\" class=\"label floatLeft\">{{ 'helpdeskform.describeproblem' | translate }}</label><br/>\n                    <textarea id=\"problem_desc\" name=\"problem_desc\" class=\"form-control\"\n                              [(ngModel)]=\"helpdeskIssue.issueSummary\" required></textarea>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <label for=\"from\" class=\"label floatLeft\">{{ 'helpdeskform.youremail' | translate }}</label><br/>\n                    <input id=\"from\" type=\"email\" name=\"from\" #from=\"ngModel\" class=\"form-control\" [(ngModel)]=\"helpdeskIssue.from\" pattern=\"^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,5})+$\" required>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n            <div class=\"ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-12 ui-md-12 ui-lg-6\">\n                    <label for=\"problem_country\" class=\"label floatLeft\">{{ 'country.label' | translate }}</label>\n                    <select class=\"form-control\" name=\"problem_country\" id=\"problem_country\" [(ngModel)]=\"helpdeskIssue.memberState\" required>\n                        <option selected disabled>Select</option>\n                        <option *ngFor=\"let nut of nuts\" [value]=\"nut.name\">{{nut.name}}</option>\n                    </select>\n                </div>\n                <div class=\"ui-lg-3\"></div>\n            </div>\n\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-lg-3\"></div>\n                <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                    <button (click)=\"expanded = false\" class=\"right\" class=\"btn btn-primary publish-button\">{{ 'close.label' | translate }}</button>\n                </div>\n                <div class=\"ui-g-6 ui-md-6 ui-lg-3\" style=\"text-align: center !important\">\n                    <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!issueForm.form.valid\">{{ 'helpdeskform.sendmessage' | translate }}</button>\n                </div>\n\n                <div class=\"ui-lg-3\"></div>\n            </div>\n        </form>\n        <div *ngIf=\"success\">\n            <p class=\"center\"><b>{{ 'helpdeskform.success' | translate }}</b></p>\n        </div>\n        <div class=\"ui-g-1\"></div>\n    </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/shared/components/helpdesk-form/helpdesk-form.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HelpdeskFormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__swagger_api_HelpdeskApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/HelpdeskApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__swagger_model_HelpdeskDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/HelpdeskDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var HelpdeskFormComponent = (function () {
    function HelpdeskFormComponent(uxService, nutsApi, helpdeskApi) {
        var _this = this;
        this.uxService = uxService;
        this.nutsApi = nutsApi;
        this.helpdeskApi = helpdeskApi;
        this.helpdeskIssue = new __WEBPACK_IMPORTED_MODULE_3__swagger_model_HelpdeskDTO__["a" /* HelpdeskDTOBase */]();
        this.expanded = false;
        this.expanded = false;
        this.nutsApi.findNutsByLevel(0).subscribe(function (nuts) {
            _this.nuts = nuts;
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get nuts, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get nuts', error);
        });
    }
    HelpdeskFormComponent.prototype.sendIssue = function () {
        var _this = this;
        this.helpdeskIssue.portal = this.portal;
        this.helpdeskIssue.date = new Date();
        this.helpdeskIssue.assignedTo = "Member State";
        this.helpdeskIssue.status = "Pending";
        this.helpdeskApi.createHelpdeskIssue(this.helpdeskIssue).subscribe(function (issue) {
            if (issue.success) {
                _this.success = true;
            }
        }, function (error) {
            _this.uxService.growl({
                severity: 'error',
                summary: 'ERROR',
                detail: 'An error occurred when sending your issue. Please try again.'
            });
        });
    };
    return HelpdeskFormComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('portal'),
    __metadata("design:type", String)
], HelpdeskFormComponent.prototype, "portal", void 0);
HelpdeskFormComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'helpdesk-form-component', template: __webpack_require__("../../../../../src/app/shared/components/helpdesk-form/helpdesk-form.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_4__swagger_api_NutsApi__["a" /* NutsApi */], __WEBPACK_IMPORTED_MODULE_2__swagger_api_HelpdeskApi__["a" /* HelpdeskApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_4__swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__swagger_api_HelpdeskApi__["a" /* HelpdeskApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__swagger_api_HelpdeskApi__["a" /* HelpdeskApi */]) === "function" && _c || Object])
], HelpdeskFormComponent);

var _a, _b, _c;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/helpdesk-form.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/index.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return APP_DIRECTIVES; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__layout_app_search_input_app_search_input_component__ = __webpack_require__("../../../../../src/app/shared/components/layout/app-search-input/app-search-input.component.ts");
/* unused harmony reexport AppSearchInputComponent */


var APP_DIRECTIVES = [
    __WEBPACK_IMPORTED_MODULE_0__layout_app_search_input_app_search_input_component__["a" /* AppSearchInputComponent */]
];
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/index.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/layout/app-search-input/app-search-input.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n    <div class=\"search-input\">\n        <ux-search-input [suggestionsService]=\"suggestionsService\" (search)=\"onSearch($event)\"></ux-search-input>\n    </div>\n    <div class=\"search-button\">\n        <button type=\"button\" class=\"btn btn-secondary btn-block\" (click)=\"onSearchButtonClick()\">\n            <span class=\"fa fa-search\"></span>\n        </button>            \n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/shared/components/layout/app-search-input/app-search-input.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppSearchInputComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-search-input/index.ts");
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
    return AppSearchInputComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"]) === "function" && _a || Object)
], AppSearchInputComponent.prototype, "searchInput", void 0);
AppSearchInputComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'app-search-input',
        template: __webpack_require__("../../../../../src/app/shared/components/layout/app-search-input/app-search-input.component.html")
    })
], AppSearchInputComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/app-search-input.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/success/success.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ui-g\">\n    <div class=\"ui-g-12 center\" style=\"text-align: center !important\">\n        <i class=\"zmdi zmdi-check-circle fa-3x\"></i><br>\n        <h2>{{ 'submitregistration.success.title' | translate }}</h2>\n        <br>\n        <p>\n            {{ 'submitregistration.success.text.part1' | translate }}\n            <br>\n            {{ 'submitregistration.success.text.part2' | translate }}\n        </p>\n        <p>\n            {{ 'submitregistration.success.resendconfirm.part1' | translate }}\n            <a (click)=\"onClick()\">{{ 'submitregistration.success.resendconfirm.part2' | translate }}</a>\n        </p>\n        <br>\n        <button class=\"btn btn-primary\" routerLink=\"/home\" routerLinkActive=\"active\">{{ 'backtohome.button' | translate }} </button>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/shared/components/success/success.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SuccessComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__swagger_api_UserApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/UserApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__beneficiary_registration_beneficiary_registration_step3_beneficiaryDTO_model__ = __webpack_require__("../../../../../src/app/+beneficiary-registration/+beneficiary-registration-step3/beneficiaryDTO.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
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
    function SuccessComponent(uxService, userApi) {
        this.uxService = uxService;
        this.userApi = userApi;
    }
    SuccessComponent.prototype.onClick = function () {
        var _this = this;
        this.userApi.resendEmail(this.beneficiaryDTO).subscribe(function (data) {
            if (data['success']) {
                _this.uxService.growl({
                    severity: 'success',
                    summary: 'SUCCESS',
                    detail: 'Resend activation email success'
                });
                console.log('SUCCESS: Resend activation email success');
            }
            else {
                _this.uxService.growl({
                    severity: 'error',
                    summary: 'ERROR',
                    detail: 'Could not resend activation email'
                });
                console.log('ERROR: Could not resend activation email');
            }
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not resend activation email, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not resend activation email', error);
        });
    };
    return SuccessComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('beneficiaryDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__beneficiary_registration_beneficiary_registration_step3_beneficiaryDTO_model__["a" /* BeneficiaryDTO */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__beneficiary_registration_beneficiary_registration_step3_beneficiaryDTO_model__["a" /* BeneficiaryDTO */]) === "function" && _a || Object)
], SuccessComponent.prototype, "beneficiaryDTO", void 0);
SuccessComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'success-component', template: __webpack_require__("../../../../../src/app/shared/components/success/success.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__swagger_api_UserApi__["a" /* UserApi */]] }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__swagger_api_UserApi__["a" /* UserApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__swagger_api_UserApi__["a" /* UserApi */]) === "function" && _c || Object])
], SuccessComponent);

var _a, _b, _c;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/success.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/timeline/custom-timeline-accordion-box.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CustomTimelineAccordionBoxComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var CustomTimelineAccordionBoxComponent = (function (_super) {
    __extends(CustomTimelineAccordionBoxComponent, _super);
    function CustomTimelineAccordionBoxComponent() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.rightSide = false;
        return _this;
    }
    CustomTimelineAccordionBoxComponent.prototype.toggle = function () {
        _super.prototype.toggle.call(this);
        if (this.isExpanded) {
            this.label = "Hide timeline";
        }
        else {
            this.label = "Expand";
        }
    };
    CustomTimelineAccordionBoxComponent.prototype.getExpandHideClass = function () {
        if (this.isExpanded) {
            return "fa fa-2x fa-chevron-up";
        }
        else {
            return "fa fa-2x fa-chevron-down";
        }
    };
    return CustomTimelineAccordionBoxComponent;
}(__WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["b" /* UxAccordionBoxComponent */]));
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(),
    __metadata("design:type", Boolean)
], CustomTimelineAccordionBoxComponent.prototype, "rightSide", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(),
    __metadata("design:type", Boolean)
], CustomTimelineAccordionBoxComponent.prototype, "isExpanded", void 0);
CustomTimelineAccordionBoxComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'custom-timeline-accordion-box',
        template: "\n    <div *ngIf=!isExpanded class=\"box accordion-box\" [class.expanded]=\"isExpanded\" (click)=\"toggle()\">\n        <div class=\"header\">\n            <span class=\"title\" [style.padding]=\"rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'\"\n            [style.float]=\"rightSide ? 'right' : 'left'\">{{'expand.label' | translate}}\n            <i [class]=\"getExpandHideClass()\" style=\"font-size: 15px; margin-left: 3px;\"></i></span>\n        </div>\n        <div class=\"content\">\n            <ng-content></ng-content>\n        </div>\n    </div>\n    <div *ngIf=isExpanded class=\"box accordion-box\" [class.expanded]=\"isExpanded\" (click)=\"toggle()\">\n        <div class=\"header\">\n            <span class=\"title\" [style.padding]=\"rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'\"\n            [style.float]=\"rightSide ? 'right' : 'left'\">{{'hide.label' | translate}}\n            <i [class]=\"getExpandHideClass()\" style=\"font-size: 15px; margin-left: 3px;\"></i></span>\n        </div>\n        <div class=\"content\">\n            <ng-content></ng-content>\n        </div>\n    </div>\n  "
    })
], CustomTimelineAccordionBoxComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/custom-timeline-accordion-box.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/timeline/timeline.component.html":
/***/ (function(module, exports) {

module.exports = "<!-- Accordin Box style -->\n<ux-accordion-boxes>\n    <custom-timeline-accordion-box id=\"expandHideBox\" label=\"{{ 'expand.label' | translate}}\" [isExpanded]=\"false\"\n                                   [rightSide]=\"true\">\n        <ux-timeline-items id=\"timelineList\">\n            <ux-timeline-item *ngFor=\"let item of timelineItems\" [date]=\"item.date\" [label]=\"item.label\"\n                              [styleClass]=\"item.styleClass\"></ux-timeline-item>\n        </ux-timeline-items>\n    </custom-timeline-accordion-box>\n</ux-accordion-boxes>"

/***/ }),

/***/ "../../../../../src/app/shared/components/timeline/timeline.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export TimelineItem */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TimelineComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__swagger_api_TimelineApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/TimelineApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var TimelineItem = (function () {
    function TimelineItem() {
    }
    TimelineItem.prototype.getDate = function () {
        return this.date;
    };
    TimelineItem.prototype.setDate = function (value) {
        this.date = value;
    };
    TimelineItem.prototype.getLabel = function () {
        return this.label;
    };
    TimelineItem.prototype.setLabel = function (value) {
        this.label = value;
    };
    TimelineItem.prototype.getStyleClass = function () {
        return this.styleClass;
    };
    TimelineItem.prototype.setStyleClass = function (value) {
        this.styleClass = value;
    };
    return TimelineItem;
}());

var TimelineComponent = (function () {
    function TimelineComponent(timelineApi) {
        var _this = this;
        this.timelineApi = timelineApi;
        this.expandHideString = "Expand";
        this.expandHideClass = "fa fa-2x fa-angle-down";
        this.timelineVisible = false;
        this.timelineApi.allTimelines().subscribe(function (elements) {
            _this.timelineItems = [];
            for (var i = 0; i < elements.length; i++) {
                _this.timelineItems.push(_this.timelineDTOToTimelineItem(elements[i]));
            }
        }, function (error) { return console.log(error); });
    }
    TimelineComponent.prototype.displayTimeline = function () {
        this.timelineVisible = !this.timelineVisible;
        if (this.timelineVisible) {
            this.expandHideString = "Hide timeline";
            this.expandHideClass = "fa fa-2x fa-angle-up";
        }
        else {
            this.expandHideString = "Expand";
            this.expandHideClass = "fa fa-2x fa-angle-down";
        }
    };
    TimelineComponent.prototype.timelineDTOToTimelineItem = function (dto) {
        var item = new TimelineItem();
        item.setLabel(dto.event);
        var timelineDate = new Date(dto.startDate);
        item.setDate(timelineDate.getDate() + "/" + (timelineDate.getMonth() + 1) + "/" + timelineDate.getFullYear());
        var currentDate = new Date();
        if (currentDate.getTime() > dto.startDate && currentDate.getTime() < dto.endDate) {
            item.setStyleClass("primary");
        }
        else if (currentDate.getTime() > dto.startDate && currentDate.getTime() > dto.endDate) {
            item.setStyleClass("success");
        }
        else {
            item.setStyleClass("");
        }
        return item;
    };
    return TimelineComponent;
}());
TimelineComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'timeline-component', template: __webpack_require__("../../../../../src/app/shared/components/timeline/timeline.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__swagger_api_TimelineApi__["a" /* TimelineApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__swagger_api_TimelineApi__["a" /* TimelineApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__swagger_api_TimelineApi__["a" /* TimelineApi */]) === "function" && _a || Object])
], TimelineComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/timeline.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/components/timer/timer.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"ui-g-12 center\">\n    <div class=\"ui-g-12 center\">\n        <span class=\"ui-g-4\"></span>\n        <span class=\"ui-g-4\" style=\"background: #fbfbfb;box-shadow: 0px 1px 2px #888888;\">\n            <div class=\"ui-g-12 center\">\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{days}}</span>\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{hours}}</span>\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{minutes}}</span>\n                <span class=\"ui-g-3\" style=\"font-size: 150%;color: darkblue;\">{{seconds}}</span>\n            </div>\n            <div class=\"ui-g-12 center\">\n                <span class=\"ui-g-3\">{{ 'voucher.days' | translate}}</span>\n                <span class=\"ui-g-3\">{{ 'voucher.hours' | translate}}</span>\n                <span class=\"ui-g-3\">{{ 'voucher.minutes' | translate}}</span>\n                <span class=\"ui-g-3\">{{ 'voucher.seconds' | translate}}</span>\n            </div>\n        </span>\n        <span class=\"ui-g-4\"></span>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/shared/components/timer/timer.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TimerComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__ = __webpack_require__("../../../../rxjs/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__);
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
    function TimerComponent() {
        this.timerEvent = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    TimerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.currentTimestamp = new Date().getTime();
        var subscription = __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__["Observable"].interval(500).map(function (x) {
        }).subscribe(function (x) {
            _this.currentTimestamp = new Date().getTime();
            _this.toEpoch(_this.expirationTimestamp - _this.currentTimestamp);
            if (_this.checkIfFinished(_this.expirationTimestamp - _this.currentTimestamp)) {
                subscription.unsubscribe();
            }
        });
    };
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
            return true;
        }
        return false;
    };
    return TimerComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", Object)
], TimerComponent.prototype, "timerEvent", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('expirationTimestamp'),
    __metadata("design:type", Number)
], TimerComponent.prototype, "expirationTimestamp", void 0);
TimerComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'timer-component', template: __webpack_require__("../../../../../src/app/shared/components/timer/timer.component.html") })
], TimerComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/timer.component.js.map

/***/ }),

/***/ "../../../../../src/app/shared/shared.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export httpFactory */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SharedModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_http_interceptor__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-http-interceptor/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-language-selector/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-search-input/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__ = __webpack_require__("../../../../primeng/primeng.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_primeng_primeng___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_primeng_primeng__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__components_index__ = __webpack_require__("../../../../../src/app/shared/components/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__components_timeline_timeline_component__ = __webpack_require__("../../../../../src/app/shared/components/timeline/timeline.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__components_timeline_custom_timeline_accordion_box_component__ = __webpack_require__("../../../../../src/app/shared/components/timeline/custom-timeline-accordion-box.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_ng2_google_recaptcha__ = __webpack_require__("../../../../ng2-google-recaptcha/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__components_success_success_component__ = __webpack_require__("../../../../../src/app/shared/components/success/success.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__components_failure_failure_component__ = __webpack_require__("../../../../../src/app/shared/components/failure/failure.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__shared_components_helpdesk_form_helpdesk_form_component__ = __webpack_require__("../../../../../src/app/shared/components/helpdesk-form/helpdesk-form.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__shared_components_timer_timer_component__ = __webpack_require__("../../../../../src/app/shared/components/timer/timer.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















function httpFactory(backend, defaultOptions) {
    return new __WEBPACK_IMPORTED_MODULE_3__ec_digit_uxatec_eui_angular2_ux_http_interceptor__["UxHttp"](backend, defaultOptions);
}
var SharedModule = (function () {
    function SharedModule() {
    }
    return SharedModule;
}());
SharedModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"],
            __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxModule */],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["CheckboxModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["GrowlModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["BlockUIModule"],
            __WEBPACK_IMPORTED_MODULE_2__angular_http__["HttpModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["AutoCompleteModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["DialogModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["DataTableModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["CalendarModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["MultiSelectModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["TabMenuModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["TabViewModule"],
            __WEBPACK_IMPORTED_MODULE_11_ng2_google_recaptcha__["a" /* Ng2GoogleRecaptchaModule */]
        ],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UX_DIRECTIVES */],
            __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__["c" /* UxLanguageSelectorComponent */],
            __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"],
            __WEBPACK_IMPORTED_MODULE_9__components_timeline_timeline_component__["a" /* TimelineComponent */],
            __WEBPACK_IMPORTED_MODULE_10__components_timeline_custom_timeline_accordion_box_component__["a" /* CustomTimelineAccordionBoxComponent */],
            __WEBPACK_IMPORTED_MODULE_12__components_success_success_component__["a" /* SuccessComponent */],
            __WEBPACK_IMPORTED_MODULE_13__components_failure_failure_component__["a" /* FailureComponent */],
            __WEBPACK_IMPORTED_MODULE_14__shared_components_helpdesk_form_helpdesk_form_component__["a" /* HelpdeskFormComponent */],
            __WEBPACK_IMPORTED_MODULE_15__shared_components_timer_timer_component__["a" /* TimerComponent */],
            __WEBPACK_IMPORTED_MODULE_8__components_index__["a" /* APP_DIRECTIVES */]
        ],
        exports: [
            __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["a" /* UX_DIRECTIVES */],
            __WEBPACK_IMPORTED_MODULE_5__ec_digit_uxatec_eui_angular2_ux_language_selector__["c" /* UxLanguageSelectorComponent */],
            __WEBPACK_IMPORTED_MODULE_6__ec_digit_uxatec_eui_angular2_ux_search_input__["UxSearchInputComponent"],
            __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["d" /* UxModule */],
            __WEBPACK_IMPORTED_MODULE_8__components_index__["a" /* APP_DIRECTIVES */],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["CheckboxModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["GrowlModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["BlockUIModule"],
            __WEBPACK_IMPORTED_MODULE_2__angular_http__["HttpModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["AutoCompleteModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["DialogModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["DataTableModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["CalendarModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["MultiSelectModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["TabMenuModule"],
            __WEBPACK_IMPORTED_MODULE_7_primeng_primeng__["TabViewModule"],
            __WEBPACK_IMPORTED_MODULE_9__components_timeline_timeline_component__["a" /* TimelineComponent */],
            __WEBPACK_IMPORTED_MODULE_10__components_timeline_custom_timeline_accordion_box_component__["a" /* CustomTimelineAccordionBoxComponent */],
            __WEBPACK_IMPORTED_MODULE_12__components_success_success_component__["a" /* SuccessComponent */],
            __WEBPACK_IMPORTED_MODULE_13__components_failure_failure_component__["a" /* FailureComponent */],
            __WEBPACK_IMPORTED_MODULE_14__shared_components_helpdesk_form_helpdesk_form_component__["a" /* HelpdeskFormComponent */],
            __WEBPACK_IMPORTED_MODULE_15__shared_components_timer_timer_component__["a" /* TimerComponent */]
        ],
        providers: [
            {
                provide: __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"],
                useFactory: httpFactory,
                deps: [__WEBPACK_IMPORTED_MODULE_2__angular_http__["XHRBackend"], __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]]
            }
        ]
    })
], SharedModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/shared.module.js.map

/***/ }),

/***/ "../../../../../src/app/shared/shared.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SharedService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs__ = __webpack_require__("../../../../rxjs/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var SharedService = (function () {
    function SharedService() {
        this.emitChangeSource = new __WEBPACK_IMPORTED_MODULE_1_rxjs__["Subject"]();
        this.changeEmitted = this.emitChangeSource.asObservable();
    }
    SharedService.prototype.emitChange = function () {
        this.emitChangeSource.next();
    };
    return SharedService;
}());
SharedService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
    __metadata("design:paramtypes", [])
], SharedService);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/shared.service.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/AbacApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export IAbacApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AbacApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var IAbacApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('IAbacApi');
var AbacApi = (function () {
    function AbacApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * Export Suppliers and Beneficiaries information.
     *
     * @param c
     */
    AbacApi.prototype.exportAbacInformation = function (c) {
        // noinspection TypeScriptValidateTypes
        return this.exportAbacInformationWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Returns information about the state of the applications for a given Publication
     *
     * @param c
     * @param publicationId
     */
    AbacApi.prototype.getPublicationAppliersInfo = function (publicationId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getPublicationAppliersInfoWithHttpInfo(publicationId)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Imports ABAC information
     *
     * @param c
     * @param body
     */
    AbacApi.prototype.importAbacInformation = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.importAbacInformationWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Export Suppliers and Beneficiaries information.
     *
     */
    AbacApi.prototype.exportAbacInformationWithHttpInfo = function () {
        var path = this.basePath + "/abac/exportAbacInformation";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Returns information about the state of the applications for a given Publication
     *
     * @param publicationId
     */
    AbacApi.prototype.getPublicationAppliersInfoWithHttpInfo = function (publicationId) {
        var path = this.basePath + ("/abac/publications/" + publicationId);
        //        .replace('{' + 'publicationId' + '}', String(publicationId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'publicationId' is not null or undefined
        if (publicationId === null || publicationId === undefined) {
            throw new Error('Required parameter publicationId was null or undefined when calling getPublicationAppliersInfo.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Imports ABAC information
     *
     * @param body
     */
    AbacApi.prototype.importAbacInformationWithHttpInfo = function (body) {
        var path = this.basePath + "/abac/importAbacInformation";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return AbacApi;
}());
AbacApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], AbacApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/AbacApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/CallApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export ICallApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CallApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var ICallApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('ICallApi');
var CallApi = (function () {
    function CallApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * Get all the calls
     *
     * @param c
     */
    CallApi.prototype.allCalls = function (c) {
        return this.allCallsWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserializeArray"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * create call
     *
     * @param c
     * @param body
     */
    CallApi.prototype.createCall = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createCallWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * delete Call
     *
     * @param c
     * @param body
     */
    CallApi.prototype.deleteCall = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.deleteCallWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Get call by callId
     *
     * @param c
     * @param callId
     */
    CallApi.prototype.getCallById = function (callId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getCallByIdWithHttpInfo(callId)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Get all the calls
     *
     */
    CallApi.prototype.allCallsWithHttpInfo = function () {
        var path = this.basePath + "/call";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * create call
     *
     * @param body
     */
    CallApi.prototype.createCallWithHttpInfo = function (body) {
        var path = this.basePath + "/call";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * delete Call
     *
     * @param body
     */
    CallApi.prototype.deleteCallWithHttpInfo = function (body) {
        var path = this.basePath + "/call";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Delete,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Get call by callId
     *
     * @param callId
     */
    CallApi.prototype.getCallByIdWithHttpInfo = function (callId) {
        var path = this.basePath + ("/call/" + callId);
        //        .replace('{' + 'callId' + '}', String(callId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'callId' is not null or undefined
        if (callId === null || callId === undefined) {
            throw new Error('Required parameter callId was null or undefined when calling getCallById.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return CallApi;
}());
CallApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], CallApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/CallApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/DgconnApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export IDgconnApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgconnApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var IDgconnApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('IDgconnApi');
var DgconnApi = (function () {
    function DgconnApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * Distribute vouchers
     *
     * @param c
     */
    DgconnApi.prototype.distribute = function (c) {
        // noinspection TypeScriptValidateTypes
        return this.distributeWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Get countries voucher info
     *
     * @param c
     */
    DgconnApi.prototype.getCountriesVoucherInfo = function (c) {
        // noinspection TypeScriptValidateTypes
        return this.getCountriesVoucherInfoWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Distribute vouchers
     *
     */
    DgconnApi.prototype.distributeWithHttpInfo = function () {
        var path = this.basePath + "/dgconn/distribute";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Put,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Get countries voucher info
     *
     */
    DgconnApi.prototype.getCountriesVoucherInfoWithHttpInfo = function () {
        var path = this.basePath + "/dgconn/getCountriesVoucherInfo";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return DgconnApi;
}());
DgconnApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], DgconnApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/DgconnApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/HelpdeskApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export IHelpdeskApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HelpdeskApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var IHelpdeskApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('IHelpdeskApi');
var HelpdeskApi = (function () {
    function HelpdeskApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * Get all the helpdesk entries
     *
     * @param c
     */
    HelpdeskApi.prototype.allHelpdeskIssues = function (c) {
        return this.allHelpdeskIssuesWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserializeArray"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * create helpdesk comment
     *
     * @param c
     * @param body
     */
    HelpdeskApi.prototype.createHelpdeskComment = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createHelpdeskCommentWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * create helpdesk issue
     *
     * @param c
     * @param body
     */
    HelpdeskApi.prototype.createHelpdeskIssue = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createHelpdeskIssueWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Get helpdesk issue by issueId
     *
     * @param c
     * @param issueId
     */
    HelpdeskApi.prototype.getHelpdeskIssue = function (issueId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getHelpdeskIssueWithHttpInfo(issueId)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Get all the helpdesk entries
     *
     */
    HelpdeskApi.prototype.allHelpdeskIssuesWithHttpInfo = function () {
        var path = this.basePath + "/helpdesk";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * create helpdesk comment
     *
     * @param body
     */
    HelpdeskApi.prototype.createHelpdeskCommentWithHttpInfo = function (body) {
        var path = this.basePath + "/helpdesk/comment";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * create helpdesk issue
     *
     * @param body
     */
    HelpdeskApi.prototype.createHelpdeskIssueWithHttpInfo = function (body) {
        var path = this.basePath + "/helpdesk";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Get helpdesk issue by issueId
     *
     * @param issueId
     */
    HelpdeskApi.prototype.getHelpdeskIssueWithHttpInfo = function (issueId) {
        var path = this.basePath + ("/helpdesk/" + issueId);
        //        .replace('{' + 'issueId' + '}', String(issueId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'issueId' is not null or undefined
        if (issueId === null || issueId === undefined) {
            throw new Error('Required parameter issueId was null or undefined when calling getHelpdeskIssue.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return HelpdeskApi;
}());
HelpdeskApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], HelpdeskApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/HelpdeskApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/NutsApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export INutsApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NutsApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var INutsApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('INutsApi');
var NutsApi = (function () {
    function NutsApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * create Nuts
     *
     * @param c
     * @param body
     */
    NutsApi.prototype.create = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * get all nuts
     *
     * @param c
     */
    NutsApi.prototype.findAllNuts = function (c) {
        return this.findAllNutsWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserializeArray"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * get country regions
     *
     * @param c
     * @param countryCode
     */
    NutsApi.prototype.findCountryRegions = function (countryCode, c) {
        return this.findCountryRegionsWithHttpInfo(countryCode)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserializeArray"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * get nuts by code
     *
     * @param c
     * @param code
     */
    NutsApi.prototype.findNutsByCode = function (code, c) {
        // noinspection TypeScriptValidateTypes
        return this.findNutsByCodeWithHttpInfo(code)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * get all nuts from level X
     *
     * @param c
     * @param level
     */
    NutsApi.prototype.findNutsByLevel = function (level, c) {
        return this.findNutsByLevelWithHttpInfo(level)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserializeArray"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * create Nuts
     *
     * @param body
     */
    NutsApi.prototype.createWithHttpInfo = function (body) {
        var path = this.basePath + "/nuts";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * get all nuts
     *
     */
    NutsApi.prototype.findAllNutsWithHttpInfo = function () {
        var path = this.basePath + "/nuts";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * get country regions
     *
     * @param countryCode
     */
    NutsApi.prototype.findCountryRegionsWithHttpInfo = function (countryCode) {
        var path = this.basePath + ("/nuts/countryRegions/" + countryCode);
        //        .replace('{' + 'countryCode' + '}', String(countryCode));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling findCountryRegions.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * get nuts by code
     *
     * @param code
     */
    NutsApi.prototype.findNutsByCodeWithHttpInfo = function (code) {
        var path = this.basePath + ("/nuts/code/" + code);
        //        .replace('{' + 'code' + '}', String(code));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'code' is not null or undefined
        if (code === null || code === undefined) {
            throw new Error('Required parameter code was null or undefined when calling findNutsByCode.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * get all nuts from level X
     *
     * @param level
     */
    NutsApi.prototype.findNutsByLevelWithHttpInfo = function (level) {
        var path = this.basePath + ("/nuts/level/" + level);
        //        .replace('{' + 'level' + '}', String(level));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'level' is not null or undefined
        if (level === null || level === undefined) {
            throw new Error('Required parameter level was null or undefined when calling findNutsByLevel.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return NutsApi;
}());
NutsApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], NutsApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/NutsApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/TimelineApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export ITimelineApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TimelineApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var ITimelineApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('ITimelineApi');
var TimelineApi = (function () {
    function TimelineApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * Get all the timeline entries
     *
     * @param c
     */
    TimelineApi.prototype.allTimelines = function (c) {
        return this.allTimelinesWithHttpInfo()
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserializeArray"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * create Timeline
     *
     * @param c
     * @param body
     */
    TimelineApi.prototype.createTimeline = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createTimelineWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * delete Timeline
     *
     * @param c
     * @param body
     */
    TimelineApi.prototype.deleteTimeline = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.deleteTimelineWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Get all the timeline entries
     *
     */
    TimelineApi.prototype.allTimelinesWithHttpInfo = function () {
        var path = this.basePath + "/timeline";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * create Timeline
     *
     * @param body
     */
    TimelineApi.prototype.createTimelineWithHttpInfo = function (body) {
        var path = this.basePath + "/timeline";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * delete Timeline
     *
     * @param body
     */
    TimelineApi.prototype.deleteTimelineWithHttpInfo = function (body) {
        var path = this.basePath + "/timeline";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Delete,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return TimelineApi;
}());
TimelineApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], TimelineApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/TimelineApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/UserApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export IUserApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserApi; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__variables__ = __webpack_require__("../../../../../src/app/shared/swagger/variables.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__configuration__ = __webpack_require__("../../../../../src/app/shared/swagger/configuration.ts");
// tslint:disable:no-unused-variable member-ordering
// noinspection ES6UnusedImports
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};






var IUserApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('IUserApi');
var UserApi = (function () {
    function UserApi(http, basePath, configuration) {
        this.http = http;
        this.basePath = 'http://localhost:8080/wifi4eu/api';
        this.defaultHeaders = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"]();
        this.configuration = new __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]();
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
        }
    }
    /**
     * Activate account or reset password
     *
     * @param c
     * @param body
     */
    UserApi.prototype.activateAccount = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.activateAccountWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Service to change password of a user
     *
     * @param c
     * @param userId
     * @param body
     */
    UserApi.prototype.changePassword = function (userId, body, c) {
        // noinspection TypeScriptValidateTypes
        return this.changePasswordWithHttpInfo(userId, body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Send forgot password mail with a link to reset password
     *
     * @param c
     * @param body
     */
    UserApi.prototype.forgotPassword = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.forgotPasswordWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Service to do Login with a user email and SHA512 password
     *
     * @param c
     * @param body
     */
    UserApi.prototype.login = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.loginWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Service to logout
     *
     * @param c
     * @param body
     */
    UserApi.prototype.logout = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.logoutWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Service to refresh the Authentication token
     *
     * @param c
     * @param body
     */
    UserApi.prototype.refreshToken = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.refreshTokenWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Service to resend email with a link to activate account
     *
     * @param c
     * @param body
     */
    UserApi.prototype.resendEmail = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.resendEmailWithHttpInfo(body)
            .map(function (response) {
            if (response.status === 204) {
                return undefined;
            }
            else if (c) {
                return Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["deserialize"])(c, response.text());
            }
            else {
                return response.json();
            }
        });
    };
    /**
     * Activate account or reset password
     *
     * @param body
     */
    UserApi.prototype.activateAccountWithHttpInfo = function (body) {
        var path = this.basePath + "/user/activateaccount";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Service to change password of a user
     *
     * @param userId
     * @param body
     */
    UserApi.prototype.changePasswordWithHttpInfo = function (userId, body) {
        var path = this.basePath + ("/user/changePassword/" + userId);
        //        .replace('{' + 'userId' + '}', String(userId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'userId' is not null or undefined
        if (userId === null || userId === undefined) {
            throw new Error('Required parameter userId was null or undefined when calling changePassword.');
        }
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Send forgot password mail with a link to reset password
     *
     * @param body
     */
    UserApi.prototype.forgotPasswordWithHttpInfo = function (body) {
        var path = this.basePath + "/user/forgotpassword";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Service to do Login with a user email and SHA512 password
     *
     * @param body
     */
    UserApi.prototype.loginWithHttpInfo = function (body) {
        var path = this.basePath + "/user/login";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Service to logout
     *
     * @param body
     */
    UserApi.prototype.logoutWithHttpInfo = function (body) {
        var path = this.basePath + "/user/logout";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Service to refresh the Authentication token
     *
     * @param body
     */
    UserApi.prototype.refreshTokenWithHttpInfo = function (body) {
        var path = this.basePath + "/user/refresh";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Service to resend email with a link to activate account
     *
     * @param body
     */
    UserApi.prototype.resendEmailWithHttpInfo = function (body) {
        var path = this.basePath + "/user/resendemail";
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Post,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return UserApi;
}());
UserApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], UserApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/UserApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/configuration.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Configuration; });
var Configuration = (function () {
    function Configuration() {
    }
    return Configuration;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/configuration.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/AccessPointDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AccessPointDTOBase; });
/*default implementation one might extend from (or use as is) */
var AccessPointDTOBase = (function () {
    function AccessPointDTOBase() {
    }
    return AccessPointDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/AccessPointDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/ActivateAccountDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ActivateAccountDTOBase; });
/*default implementation one might extend from (or use as is) */
var ActivateAccountDTOBase = (function () {
    function ActivateAccountDTOBase() {
    }
    return ActivateAccountDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/ActivateAccountDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/BenPubSupDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export BenPubSupDTOBase */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

/*default implementation one might extend from (or use as is) */
var BenPubSupDTOBase = (function () {
    function BenPubSupDTOBase() {
    }
    return BenPubSupDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], BenPubSupDTOBase.prototype, "date", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/BenPubSupDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/BeneficiaryDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryDTOBase; });
/*default implementation one might extend from (or use as is) */
var BeneficiaryDTOBase = (function () {
    function BeneficiaryDTOBase() {
    }
    return BeneficiaryDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/BeneficiaryDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/CallDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CallDTOBase; });
/*default implementation one might extend from (or use as is) */
var CallDTOBase = (function () {
    function CallDTOBase() {
    }
    return CallDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/CallDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/ErrorDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export ErrorDTOBase */
/*default implementation one might extend from (or use as is) */
var ErrorDTOBase = (function () {
    function ErrorDTOBase() {
    }
    return ErrorDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/ErrorDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/HelpdeskCommentDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HelpdeskCommentDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

/*default implementation one might extend from (or use as is) */
var HelpdeskCommentDTOBase = (function () {
    function HelpdeskCommentDTOBase() {
    }
    return HelpdeskCommentDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], HelpdeskCommentDTOBase.prototype, "commentDate", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/HelpdeskCommentDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/HelpdeskDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HelpdeskDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__models__ = __webpack_require__("../../../../../src/app/shared/swagger/model/models.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/*default implementation one might extend from (or use as is) */
var HelpdeskDTOBase = (function () {
    function HelpdeskDTOBase() {
    }
    return HelpdeskDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], HelpdeskDTOBase.prototype, "date", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return __WEBPACK_IMPORTED_MODULE_0__models__["b" /* HelpdeskCommentDTOBase */]; }),
    __metadata("design:type", Array)
], HelpdeskDTOBase.prototype, "comments", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/HelpdeskDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/InstallationDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InstallationDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__models__ = __webpack_require__("../../../../../src/app/shared/swagger/model/models.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/*default implementation one might extend from (or use as is) */
var InstallationDTOBase = (function () {
    function InstallationDTOBase() {
    }
    return InstallationDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return __WEBPACK_IMPORTED_MODULE_0__models__["a" /* AccessPointDTOBase */]; }),
    __metadata("design:type", Array)
], InstallationDTOBase.prototype, "accessPoints", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/InstallationDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/LauDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LauDTOBase; });
/*default implementation one might extend from (or use as is) */
var LauDTOBase = (function () {
    function LauDTOBase() {
    }
    return LauDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/LauDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/LegalEntityDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LegalEntityDTOBase; });
/*default implementation one might extend from (or use as is) */
var LegalEntityDTOBase = (function () {
    function LegalEntityDTOBase() {
    }
    return LegalEntityDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/LegalEntityDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/MayorDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MayorDTOBase; });
/*default implementation one might extend from (or use as is) */
var MayorDTOBase = (function () {
    function MayorDTOBase() {
    }
    return MayorDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/MayorDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/NutsDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NutsDTOBase; });
/*default implementation one might extend from (or use as is) */
var NutsDTOBase = (function () {
    function NutsDTOBase() {
    }
    return NutsDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/NutsDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/RepresentativeDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RepresentativeDTOBase; });
/*default implementation one might extend from (or use as is) */
var RepresentativeDTOBase = (function () {
    function RepresentativeDTOBase() {
    }
    return RepresentativeDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/RepresentativeDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/ResponseDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export ResponseDTOBase */
/*default implementation one might extend from (or use as is) */
var ResponseDTOBase = (function () {
    function ResponseDTOBase() {
    }
    return ResponseDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/ResponseDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/RightDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RightDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__models__ = __webpack_require__("../../../../../src/app/shared/swagger/model/models.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/*default implementation one might extend from (or use as is) */
var RightDTOBase = (function () {
    function RightDTOBase() {
    }
    return RightDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return __WEBPACK_IMPORTED_MODULE_0__models__["d" /* RoleDTOBase */]; }),
    __metadata("design:type", Array)
], RightDTOBase.prototype, "roles", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/RightDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/RoleDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RoleDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__models__ = __webpack_require__("../../../../../src/app/shared/swagger/model/models.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/*default implementation one might extend from (or use as is) */
var RoleDTOBase = (function () {
    function RoleDTOBase() {
    }
    return RoleDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return __WEBPACK_IMPORTED_MODULE_0__models__["c" /* RightDTOBase */]; }),
    __metadata("design:type", Array)
], RoleDTOBase.prototype, "rights", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/RoleDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/SupplierDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

/*default implementation one might extend from (or use as is) */
var SupplierDTOBase = (function () {
    function SupplierDTOBase() {
    }
    return SupplierDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], SupplierDTOBase.prototype, "createDate", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/SupplierDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/TimelineDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TimelineDTOBase; });
/*default implementation one might extend from (or use as is) */
var TimelineDTOBase = (function () {
    function TimelineDTOBase() {
    }
    return TimelineDTOBase;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/TimelineDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/UserDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserDTOBase; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__models__ = __webpack_require__("../../../../../src/app/shared/swagger/model/models.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


/*default implementation one might extend from (or use as is) */
var UserDTOBase = (function () {
    function UserDTOBase() {
    }
    return UserDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], UserDTOBase.prototype, "createDate", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], UserDTOBase.prototype, "accessDate", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1_class_transformer__["Type"])(function () { return __WEBPACK_IMPORTED_MODULE_0__models__["d" /* RoleDTOBase */]; }),
    __metadata("design:type", Array)
], UserDTOBase.prototype, "roles", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/UserDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/VoucherDTO.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export VoucherDTOBase */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer__ = __webpack_require__("../../../../class-transformer/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_class_transformer___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_class_transformer__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

/*default implementation one might extend from (or use as is) */
var VoucherDTOBase = (function () {
    function VoucherDTOBase() {
    }
    return VoucherDTOBase;
}());

__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["Type"])(function () { return Date; }),
    __metadata("design:type", Object)
], VoucherDTOBase.prototype, "createDate", void 0);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/VoucherDTO.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/model/models.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__AccessPointDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/AccessPointDTO.ts");
/* harmony namespace reexport (by used) */ __webpack_require__.d(__webpack_exports__, "a", function() { return __WEBPACK_IMPORTED_MODULE_0__AccessPointDTO__["a"]; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ActivateAccountDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/ActivateAccountDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__BenPubSupDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/BenPubSupDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__BeneficiaryDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/BeneficiaryDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__CallDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/CallDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__ErrorDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/ErrorDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__HelpdeskCommentDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/HelpdeskCommentDTO.ts");
/* harmony namespace reexport (by used) */ __webpack_require__.d(__webpack_exports__, "b", function() { return __WEBPACK_IMPORTED_MODULE_6__HelpdeskCommentDTO__["a"]; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__HelpdeskDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/HelpdeskDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__InstallationDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/InstallationDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__LauDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/LauDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__LegalEntityDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/LegalEntityDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__MayorDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/MayorDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__NutsDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/NutsDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__RepresentativeDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/RepresentativeDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__ResponseDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/ResponseDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__RightDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/RightDTO.ts");
/* harmony namespace reexport (by used) */ __webpack_require__.d(__webpack_exports__, "c", function() { return __WEBPACK_IMPORTED_MODULE_15__RightDTO__["a"]; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__RoleDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/RoleDTO.ts");
/* harmony namespace reexport (by used) */ __webpack_require__.d(__webpack_exports__, "d", function() { return __WEBPACK_IMPORTED_MODULE_16__RoleDTO__["a"]; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_18__TimelineDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/TimelineDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_19__UserDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/UserDTO.ts");
/* unused harmony namespace reexport */
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_20__VoucherDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/VoucherDTO.ts");
/* unused harmony namespace reexport */





















//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/models.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/variables.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BASE_PATH; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");

var BASE_PATH = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["OpaqueToken"]('basePath');
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/variables.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__polyfills_ts__ = __webpack_require__("../../../../../src/polyfills.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");





if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_4__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/main.js.map

/***/ }),

/***/ "../../../../../src/polyfills.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__ = __webpack_require__("../../../../core-js/es6/symbol.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_core_js_es6_symbol__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__ = __webpack_require__("../../../../core-js/es6/object.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_core_js_es6_object___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_core_js_es6_object__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__ = __webpack_require__("../../../../core-js/es6/function.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_core_js_es6_function___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_core_js_es6_function__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__ = __webpack_require__("../../../../core-js/es6/parse-int.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_core_js_es6_parse_int__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__ = __webpack_require__("../../../../core-js/es6/parse-float.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_core_js_es6_parse_float__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__ = __webpack_require__("../../../../core-js/es6/number.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_core_js_es6_number___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_core_js_es6_number__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__ = __webpack_require__("../../../../core-js/es6/math.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_core_js_es6_math___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_core_js_es6_math__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__ = __webpack_require__("../../../../core-js/es6/string.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7_core_js_es6_string___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_7_core_js_es6_string__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__ = __webpack_require__("../../../../core-js/es6/date.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_core_js_es6_date___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_core_js_es6_date__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__ = __webpack_require__("../../../../core-js/es6/array.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_core_js_es6_array___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_core_js_es6_array__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__ = __webpack_require__("../../../../core-js/es6/regexp.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_core_js_es6_regexp__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__ = __webpack_require__("../../../../core-js/es6/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_core_js_es6_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_core_js_es6_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__ = __webpack_require__("../../../../core-js/es6/set.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_core_js_es6_set___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_12_core_js_es6_set__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__ = __webpack_require__("../../../../core-js/es6/reflect.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_13_core_js_es6_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__ = __webpack_require__("../../../../core-js/es7/reflect.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_14_core_js_es7_reflect__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__ = __webpack_require__("../../../../zone.js/dist/zone.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_15_zone_js_dist_zone__);
// This file includes polyfills needed by Angular and is loaded before
// the app. You can add your own extra polyfills to this file.
















//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/polyfills.js.map

/***/ }),

/***/ "../../../../moment/locale recursive ^\\.\\/.*$":
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"./af": "../../../../moment/locale/af.js",
	"./af.js": "../../../../moment/locale/af.js",
	"./ar": "../../../../moment/locale/ar.js",
	"./ar-dz": "../../../../moment/locale/ar-dz.js",
	"./ar-dz.js": "../../../../moment/locale/ar-dz.js",
	"./ar-kw": "../../../../moment/locale/ar-kw.js",
	"./ar-kw.js": "../../../../moment/locale/ar-kw.js",
	"./ar-ly": "../../../../moment/locale/ar-ly.js",
	"./ar-ly.js": "../../../../moment/locale/ar-ly.js",
	"./ar-ma": "../../../../moment/locale/ar-ma.js",
	"./ar-ma.js": "../../../../moment/locale/ar-ma.js",
	"./ar-sa": "../../../../moment/locale/ar-sa.js",
	"./ar-sa.js": "../../../../moment/locale/ar-sa.js",
	"./ar-tn": "../../../../moment/locale/ar-tn.js",
	"./ar-tn.js": "../../../../moment/locale/ar-tn.js",
	"./ar.js": "../../../../moment/locale/ar.js",
	"./az": "../../../../moment/locale/az.js",
	"./az.js": "../../../../moment/locale/az.js",
	"./be": "../../../../moment/locale/be.js",
	"./be.js": "../../../../moment/locale/be.js",
	"./bg": "../../../../moment/locale/bg.js",
	"./bg.js": "../../../../moment/locale/bg.js",
	"./bn": "../../../../moment/locale/bn.js",
	"./bn.js": "../../../../moment/locale/bn.js",
	"./bo": "../../../../moment/locale/bo.js",
	"./bo.js": "../../../../moment/locale/bo.js",
	"./br": "../../../../moment/locale/br.js",
	"./br.js": "../../../../moment/locale/br.js",
	"./bs": "../../../../moment/locale/bs.js",
	"./bs.js": "../../../../moment/locale/bs.js",
	"./ca": "../../../../moment/locale/ca.js",
	"./ca.js": "../../../../moment/locale/ca.js",
	"./cs": "../../../../moment/locale/cs.js",
	"./cs.js": "../../../../moment/locale/cs.js",
	"./cv": "../../../../moment/locale/cv.js",
	"./cv.js": "../../../../moment/locale/cv.js",
	"./cy": "../../../../moment/locale/cy.js",
	"./cy.js": "../../../../moment/locale/cy.js",
	"./da": "../../../../moment/locale/da.js",
	"./da.js": "../../../../moment/locale/da.js",
	"./de": "../../../../moment/locale/de.js",
	"./de-at": "../../../../moment/locale/de-at.js",
	"./de-at.js": "../../../../moment/locale/de-at.js",
	"./de-ch": "../../../../moment/locale/de-ch.js",
	"./de-ch.js": "../../../../moment/locale/de-ch.js",
	"./de.js": "../../../../moment/locale/de.js",
	"./dv": "../../../../moment/locale/dv.js",
	"./dv.js": "../../../../moment/locale/dv.js",
	"./el": "../../../../moment/locale/el.js",
	"./el.js": "../../../../moment/locale/el.js",
	"./en-au": "../../../../moment/locale/en-au.js",
	"./en-au.js": "../../../../moment/locale/en-au.js",
	"./en-ca": "../../../../moment/locale/en-ca.js",
	"./en-ca.js": "../../../../moment/locale/en-ca.js",
	"./en-gb": "../../../../moment/locale/en-gb.js",
	"./en-gb.js": "../../../../moment/locale/en-gb.js",
	"./en-ie": "../../../../moment/locale/en-ie.js",
	"./en-ie.js": "../../../../moment/locale/en-ie.js",
	"./en-nz": "../../../../moment/locale/en-nz.js",
	"./en-nz.js": "../../../../moment/locale/en-nz.js",
	"./eo": "../../../../moment/locale/eo.js",
	"./eo.js": "../../../../moment/locale/eo.js",
	"./es": "../../../../moment/locale/es.js",
	"./es-do": "../../../../moment/locale/es-do.js",
	"./es-do.js": "../../../../moment/locale/es-do.js",
	"./es.js": "../../../../moment/locale/es.js",
	"./et": "../../../../moment/locale/et.js",
	"./et.js": "../../../../moment/locale/et.js",
	"./eu": "../../../../moment/locale/eu.js",
	"./eu.js": "../../../../moment/locale/eu.js",
	"./fa": "../../../../moment/locale/fa.js",
	"./fa.js": "../../../../moment/locale/fa.js",
	"./fi": "../../../../moment/locale/fi.js",
	"./fi.js": "../../../../moment/locale/fi.js",
	"./fo": "../../../../moment/locale/fo.js",
	"./fo.js": "../../../../moment/locale/fo.js",
	"./fr": "../../../../moment/locale/fr.js",
	"./fr-ca": "../../../../moment/locale/fr-ca.js",
	"./fr-ca.js": "../../../../moment/locale/fr-ca.js",
	"./fr-ch": "../../../../moment/locale/fr-ch.js",
	"./fr-ch.js": "../../../../moment/locale/fr-ch.js",
	"./fr.js": "../../../../moment/locale/fr.js",
	"./fy": "../../../../moment/locale/fy.js",
	"./fy.js": "../../../../moment/locale/fy.js",
	"./gd": "../../../../moment/locale/gd.js",
	"./gd.js": "../../../../moment/locale/gd.js",
	"./gl": "../../../../moment/locale/gl.js",
	"./gl.js": "../../../../moment/locale/gl.js",
	"./gom-latn": "../../../../moment/locale/gom-latn.js",
	"./gom-latn.js": "../../../../moment/locale/gom-latn.js",
	"./he": "../../../../moment/locale/he.js",
	"./he.js": "../../../../moment/locale/he.js",
	"./hi": "../../../../moment/locale/hi.js",
	"./hi.js": "../../../../moment/locale/hi.js",
	"./hr": "../../../../moment/locale/hr.js",
	"./hr.js": "../../../../moment/locale/hr.js",
	"./hu": "../../../../moment/locale/hu.js",
	"./hu.js": "../../../../moment/locale/hu.js",
	"./hy-am": "../../../../moment/locale/hy-am.js",
	"./hy-am.js": "../../../../moment/locale/hy-am.js",
	"./id": "../../../../moment/locale/id.js",
	"./id.js": "../../../../moment/locale/id.js",
	"./is": "../../../../moment/locale/is.js",
	"./is.js": "../../../../moment/locale/is.js",
	"./it": "../../../../moment/locale/it.js",
	"./it.js": "../../../../moment/locale/it.js",
	"./ja": "../../../../moment/locale/ja.js",
	"./ja.js": "../../../../moment/locale/ja.js",
	"./jv": "../../../../moment/locale/jv.js",
	"./jv.js": "../../../../moment/locale/jv.js",
	"./ka": "../../../../moment/locale/ka.js",
	"./ka.js": "../../../../moment/locale/ka.js",
	"./kk": "../../../../moment/locale/kk.js",
	"./kk.js": "../../../../moment/locale/kk.js",
	"./km": "../../../../moment/locale/km.js",
	"./km.js": "../../../../moment/locale/km.js",
	"./kn": "../../../../moment/locale/kn.js",
	"./kn.js": "../../../../moment/locale/kn.js",
	"./ko": "../../../../moment/locale/ko.js",
	"./ko.js": "../../../../moment/locale/ko.js",
	"./ky": "../../../../moment/locale/ky.js",
	"./ky.js": "../../../../moment/locale/ky.js",
	"./lb": "../../../../moment/locale/lb.js",
	"./lb.js": "../../../../moment/locale/lb.js",
	"./lo": "../../../../moment/locale/lo.js",
	"./lo.js": "../../../../moment/locale/lo.js",
	"./lt": "../../../../moment/locale/lt.js",
	"./lt.js": "../../../../moment/locale/lt.js",
	"./lv": "../../../../moment/locale/lv.js",
	"./lv.js": "../../../../moment/locale/lv.js",
	"./me": "../../../../moment/locale/me.js",
	"./me.js": "../../../../moment/locale/me.js",
	"./mi": "../../../../moment/locale/mi.js",
	"./mi.js": "../../../../moment/locale/mi.js",
	"./mk": "../../../../moment/locale/mk.js",
	"./mk.js": "../../../../moment/locale/mk.js",
	"./ml": "../../../../moment/locale/ml.js",
	"./ml.js": "../../../../moment/locale/ml.js",
	"./mr": "../../../../moment/locale/mr.js",
	"./mr.js": "../../../../moment/locale/mr.js",
	"./ms": "../../../../moment/locale/ms.js",
	"./ms-my": "../../../../moment/locale/ms-my.js",
	"./ms-my.js": "../../../../moment/locale/ms-my.js",
	"./ms.js": "../../../../moment/locale/ms.js",
	"./my": "../../../../moment/locale/my.js",
	"./my.js": "../../../../moment/locale/my.js",
	"./nb": "../../../../moment/locale/nb.js",
	"./nb.js": "../../../../moment/locale/nb.js",
	"./ne": "../../../../moment/locale/ne.js",
	"./ne.js": "../../../../moment/locale/ne.js",
	"./nl": "../../../../moment/locale/nl.js",
	"./nl-be": "../../../../moment/locale/nl-be.js",
	"./nl-be.js": "../../../../moment/locale/nl-be.js",
	"./nl.js": "../../../../moment/locale/nl.js",
	"./nn": "../../../../moment/locale/nn.js",
	"./nn.js": "../../../../moment/locale/nn.js",
	"./pa-in": "../../../../moment/locale/pa-in.js",
	"./pa-in.js": "../../../../moment/locale/pa-in.js",
	"./pl": "../../../../moment/locale/pl.js",
	"./pl.js": "../../../../moment/locale/pl.js",
	"./pt": "../../../../moment/locale/pt.js",
	"./pt-br": "../../../../moment/locale/pt-br.js",
	"./pt-br.js": "../../../../moment/locale/pt-br.js",
	"./pt.js": "../../../../moment/locale/pt.js",
	"./ro": "../../../../moment/locale/ro.js",
	"./ro.js": "../../../../moment/locale/ro.js",
	"./ru": "../../../../moment/locale/ru.js",
	"./ru.js": "../../../../moment/locale/ru.js",
	"./sd": "../../../../moment/locale/sd.js",
	"./sd.js": "../../../../moment/locale/sd.js",
	"./se": "../../../../moment/locale/se.js",
	"./se.js": "../../../../moment/locale/se.js",
	"./si": "../../../../moment/locale/si.js",
	"./si.js": "../../../../moment/locale/si.js",
	"./sk": "../../../../moment/locale/sk.js",
	"./sk.js": "../../../../moment/locale/sk.js",
	"./sl": "../../../../moment/locale/sl.js",
	"./sl.js": "../../../../moment/locale/sl.js",
	"./sq": "../../../../moment/locale/sq.js",
	"./sq.js": "../../../../moment/locale/sq.js",
	"./sr": "../../../../moment/locale/sr.js",
	"./sr-cyrl": "../../../../moment/locale/sr-cyrl.js",
	"./sr-cyrl.js": "../../../../moment/locale/sr-cyrl.js",
	"./sr.js": "../../../../moment/locale/sr.js",
	"./ss": "../../../../moment/locale/ss.js",
	"./ss.js": "../../../../moment/locale/ss.js",
	"./sv": "../../../../moment/locale/sv.js",
	"./sv.js": "../../../../moment/locale/sv.js",
	"./sw": "../../../../moment/locale/sw.js",
	"./sw.js": "../../../../moment/locale/sw.js",
	"./ta": "../../../../moment/locale/ta.js",
	"./ta.js": "../../../../moment/locale/ta.js",
	"./te": "../../../../moment/locale/te.js",
	"./te.js": "../../../../moment/locale/te.js",
	"./tet": "../../../../moment/locale/tet.js",
	"./tet.js": "../../../../moment/locale/tet.js",
	"./th": "../../../../moment/locale/th.js",
	"./th.js": "../../../../moment/locale/th.js",
	"./tl-ph": "../../../../moment/locale/tl-ph.js",
	"./tl-ph.js": "../../../../moment/locale/tl-ph.js",
	"./tlh": "../../../../moment/locale/tlh.js",
	"./tlh.js": "../../../../moment/locale/tlh.js",
	"./tr": "../../../../moment/locale/tr.js",
	"./tr.js": "../../../../moment/locale/tr.js",
	"./tzl": "../../../../moment/locale/tzl.js",
	"./tzl.js": "../../../../moment/locale/tzl.js",
	"./tzm": "../../../../moment/locale/tzm.js",
	"./tzm-latn": "../../../../moment/locale/tzm-latn.js",
	"./tzm-latn.js": "../../../../moment/locale/tzm-latn.js",
	"./tzm.js": "../../../../moment/locale/tzm.js",
	"./uk": "../../../../moment/locale/uk.js",
	"./uk.js": "../../../../moment/locale/uk.js",
	"./ur": "../../../../moment/locale/ur.js",
	"./ur.js": "../../../../moment/locale/ur.js",
	"./uz": "../../../../moment/locale/uz.js",
	"./uz-latn": "../../../../moment/locale/uz-latn.js",
	"./uz-latn.js": "../../../../moment/locale/uz-latn.js",
	"./uz.js": "../../../../moment/locale/uz.js",
	"./vi": "../../../../moment/locale/vi.js",
	"./vi.js": "../../../../moment/locale/vi.js",
	"./x-pseudo": "../../../../moment/locale/x-pseudo.js",
	"./x-pseudo.js": "../../../../moment/locale/x-pseudo.js",
	"./yo": "../../../../moment/locale/yo.js",
	"./yo.js": "../../../../moment/locale/yo.js",
	"./zh-cn": "../../../../moment/locale/zh-cn.js",
	"./zh-cn.js": "../../../../moment/locale/zh-cn.js",
	"./zh-hk": "../../../../moment/locale/zh-hk.js",
	"./zh-hk.js": "../../../../moment/locale/zh-hk.js",
	"./zh-tw": "../../../../moment/locale/zh-tw.js",
	"./zh-tw.js": "../../../../moment/locale/zh-tw.js"
};
function webpackContext(req) {
	return __webpack_require__(webpackContextResolve(req));
};
function webpackContextResolve(req) {
	var id = map[req];
	if(!(id + 1)) // check for number or string
		throw new Error("Cannot find module '" + req + "'.");
	return id;
};
webpackContext.keys = function webpackContextKeys() {
	return Object.keys(map);
};
webpackContext.resolve = webpackContextResolve;
module.exports = webpackContext;
webpackContext.id = "../../../../moment/locale recursive ^\\.\\/.*$";

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map