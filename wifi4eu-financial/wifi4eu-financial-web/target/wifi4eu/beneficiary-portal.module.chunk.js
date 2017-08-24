webpackJsonp(["beneficiary-portal.module"],{

/***/ "../../../../../src/app/+beneficiary-portal/+profile/profile.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container font\">\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12\">\n            <p class=\"beneficiaryTitle\">{{ 'profile.title' | translate }}</p>\n        </div>\n    </div>\n\n    <div class=\"ui-g-6\">\n        <hr class=\"beneficiaryHr\">\n        <div class=\"ui-g\">\n            <div class=\"ui-g-12\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-10\">\n                        <p class=\"beneficiaryMayor\">{{ 'mayor.details' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-2\">\n                        <a (click)=\"mayorEdit()\" class=\"edit\">{{ 'edit.button' | translate }} <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></a>\n                    </div>\n                </div>\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-4\">\n                        <p>{{ 'treatment.label' | translate }}</p>\n                        <p>{{ 'name.label' | translate }}</p>\n                        <p>{{ 'surname.label' | translate }}</p>\n                        <p>{{ 'email.label' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-8\">\n                        <p class=\"profileData\" *ngIf=\"beneficiary.mayorDTO.treatment == 'mr'\">{{ 'treatment.option1' |\n                            translate }}</p>\n                        <p class=\"profileData\" *ngIf=\"beneficiary.mayorDTO.treatment == 'ms'\">{{ 'treatment.option2' |\n                            translate }}</p>\n                        <p class=\"profileData\">{{beneficiary.mayorDTO.name}}</p>\n                        <p class=\"profileData\">{{beneficiary.mayorDTO.surname}}</p>\n                        <p class=\"profileData\">{{beneficiary.mayorDTO.email}}</p>\n                    </div>\n                </div>\n                <hr class=\"beneficiaryHr\">\n            </div>\n\n            <div class=\"ui-g-12\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-10\">\n                        <p class=\"beneficiaryMayor\">{{ 'legalentity.label' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-2\">\n                        <a (click)=\"legalEntityEdit()\">{{ 'edit.button' | translate }} <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></a>\n                    </div>\n                </div>\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-4\">\n                        <p>{{ 'country.label' | translate }}</p>\n                        <p>{{ 'municipality.label' | translate }}</p>\n                        <p>{{ 'address.label' | translate }}</p>\n                        <p>{{ 'postal-code.label' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-8\">\n                        <p class=\"profileData\">{{countryNuts.name}}</p>\n                        <p class=\"profileData\">{{municipalityLau.name1}}</p>\n                        <p class=\"profileData\">{{beneficiary.legalEntityDTO.address}},\n                            {{beneficiary.legalEntityDTO.addressNum}}</p>\n                        <p class=\"profileData\">{{beneficiary.legalEntityDTO.postalCode}}</p>\n                    </div>\n                </div>\n                <hr class=\"beneficiaryHr\">\n            </div>\n\n            <div class=\"ui-g-12\" *ngIf=\"beneficiary.represented\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-10\">\n                        <p class=\"beneficiaryMayor\">{{ 'representativedetails.title' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-2\">\n                        <a (click)=\"representativeEdit()\">{{ 'edit.button' | translate }} <i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></a>\n                    </div>\n                </div>\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-4\">\n                        <p>{{ 'treatment.label' | translate }}</p>\n                        <p>{{ 'name.label' | translate }}</p>\n                        <p>{{ 'role.label' | translate }}</p>\n                        <p>{{ 'surname.label' | translate }}</p>\n                        <p>{{ 'email.label' | translate }}</p>\n                    </div>\n                    <div class=\"ui-g-8\">\n                        <p class=\"profileData\" *ngIf=\"beneficiary.representativeDTO.treatment == 'mr'\">{{ 'treatment.option1' | translate }}</p>\n                        <p class=\"profileData\" *ngIf=\"beneficiary.representativeDTO.treatment == 'ms'\">{{ 'treatment.option2' | translate }}</p>\n                        <p class=\"profileData\">{{beneficiary.representativeDTO.name}}</p>\n                        <p class=\"profileData\">{{beneficiary.representativeDTO.municipalityRole}}</p>\n                        <p class=\"profileData\">{{beneficiary.representativeDTO.surname}}</p>\n                        <p class=\"profileData\">{{beneficiary.representativeDTO.email}}</p>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g\">\n                <div class=\"ui-g-4\"></div>\n                <div class=\"ui-g-8 button-content\">\n                    <p>{{ 'beneficiaryProfile.text' | translate }}</p>\n                    <div style=\"text-align: center !important\">\n                        <button type=\"button\" (click)=\"changingPassword()\" class=\"btn btn-primary changePassword\">\n                            {{'beneficiaryProfile.password' | translate }}\n                        </button>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n<!--MODALS BELOW-->\n<div class=\"container font\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"displayPassword\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"true\" (onAfterHide)=\"emptyModal()\">\n        <p class=\"beneficiaryMayorModal\">{{'beneficiaryProfile.password' | translate }}</p>\n        <form (ngSubmit)=\"changePassword()\" #profileForm=\"ngForm\">\n            <div class=\"form-group profileDialog\">\n                <label class=\"labelModal\" for=\"currentPassword\">{{ 'currentPassword.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"beneficiaryDetails.currentPassword\"\n                       class=\"form-control beneficiaryProfileI\"\n                       name=\"currentPassword\" ngcontrol=\"currentPassword\" #currentPassword=\"ngModel\" required>\n                <div [hidden]=\"currentPassword.valid || currentPassword.pristine\" class=\"alert alert-danger\">\n                    {{ 'password.required' | translate }}\n                </div>\n                <a class=\"forgotPassword\" routerLink=\"/forgot\">Forgot password?</a><br>\n                <label class=\"labelModal\" for=\"newPassword\">{{ 'password.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"beneficiaryDetails.newPassword\"\n                       class=\"form-control beneficiaryProfileI\"\n                       name=\"newPassword\" ngcontrol=\"newPassword\" #newPassword=\"ngModel\" (keyup)=\"checkPassword()\"\n                       required>\n                <div [hidden]=\"newPassword.valid || newPassword.pristine\" class=\"alert alert-danger\">\n                    {{ 'password.required' | translate }}\n                </div>\n                <label class=\"labelModal\" for=\"repeatNewPassword\">{{ 'confirmNewPassword.label' | translate }}</label>\n                <input type=\"password\" [(ngModel)]=\"beneficiaryDetails.repeatNewPassword\"\n                       class=\"form-control beneficiaryProfileI\"\n                       name=\"repeatNewPassword\" ngcontrol=\"repeatNewPassword\" #repeatNewPassword=\"ngModel\"\n                       (keyup)=\"checkPassword()\" required>\n                <div [hidden]=\"repeatNewPassword.valid || repeatNewPassword.pristine\" class=\"alert alert-danger\">\n                    {{'newPassword.required' | translate }}\n                </div>\n                <div class=\"form-group\">\n                    <div style=\"text-align: center !important\">\n                        <button type=\"button\" class=\"btn btn-primary changePasswordModal\" (click)=\"closeModal()\">\n                            {{ 'cancel.button' | translate }}\n                        </button>\n                        <button type=\"submit\" class=\"btn btn-primary changePasswordModal\"\n                                [disabled]=\"!profileForm.form.valid || !checkPassword()\">\n                            {{ 'change' | translate }}\n                        </button>\n                    </div>\n                </div>\n            </div>\n        </form>\n    </p-dialog>\n</div>\n\n\n<div class=\"container font\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"displayLegal\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"true\">\n        <form (ngSubmit)=\"updateLegalEntity()\" #editLegalEntityForm=\"ngForm\">\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"country\">{{ 'country.label' | translate }}</label>\n                        <input type=\"text\" id=\"country\" class=\"form-control\" name=\"country\" ngcontrol=\"country\"\n                               #country=\"ngModel\" [(ngModel)]=\"countryNuts.name\" required disabled>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"municipality\">{{ 'municipality.label' | translate }}</label>\n                        <input type=\"text\" id=\"municipality\" class=\"form-control\" name=\"municipality\" ngcontrol=\"municipality\"\n                               #municipality=\"ngModel\" [(ngModel)]=\"municipalityLau.name1\" required disabled>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-7\">\n                    <div class=\"form-group\">\n                        <label for=\"address\">{{ 'address.label' | translate }}</label>\n                        <input type=\"text\" id=\"address\" class=\"form-control\" name=\"address\" ngcontrol=\"address\"\n                               #address=\"ngModel\" [(ngModel)]=\"beneficiaryModal.legalEntityDTO.address\" required>\n                        <div [hidden]=\"address.valid || address.pristine\" class=\"alert alert-danger\">\n                            Address is required\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-3\">\n                    <div class=\"form-group\">\n                        <label for=\"addressNum\">{{ 'number.label' | translate }}</label>\n                        <input type=\"number\" id=\"addressNum\" class=\"form-control\" name=\"addressNum\" ngcontrol=\"addressNum\"\n                               #addressNum=\"ngModel\" [(ngModel)]=\"beneficiaryModal.legalEntityDTO.addressNum\" required>\n                        <div [hidden]=\"addressNum.valid || addressNum.pristine\" class=\"alert alert-danger\">\n                            Address number is required\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-1\"></div>\n                <div class=\"ui-g-10\">\n                    <div class=\"form-group\">\n                        <label for=\"postalCode\">{{ 'postal-code.label' | translate }}</label>\n                        <input type=\"text\" id=\"postalCode\" class=\"form-control\" name=\"postalCode\" ngcontrol=\"postalCode\"\n                               #postalCode=\"ngModel\" [(ngModel)]=\"beneficiaryModal.legalEntityDTO.postalCode\" required>\n                        <div [hidden]=\"postalCode.valid || postalCode.pristine\" class=\"alert alert-danger\">\n                            Postal code is required\n                        </div>\n                    </div>\n                </div>\n                <div class=\"ui-g-1\"></div>\n            </div>\n            <div class=\"form-group ui-g\">\n                <div class=\"ui-g-3\"></div>\n                <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                    <button type=\"button\" class=\"btn btn-primary cancel-button\" (click)=\"closeModal()\">\n                        {{ 'cancel.button' | translate }}\n                    </button>\n                </div>\n                <div class=\"ui-g-2\" style=\"text-align: center !important\"></div>\n                <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                    <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!editLegalEntityForm.form.valid\">\n                        {{ 'confirm.button' | translate }}\n                    </button>\n                </div>\n                <div class=\"ui-g-3\"></div>\n            </div>\n        </form>\n    </p-dialog>\n</div>\n\n\n<div class=\"container-font\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"displayMayor\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"true\">\n        <form (ngSubmit)=\"updateInfo()\" #editMayorForm=\"ngForm\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <h3>{{ 'mayordetails.title' | translate }}</h3>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-3\">\n                        <label for=\"treatment\">{{ 'treatment.label' | translate }}</label>\n                        <select class=\"form-control\" name=\"treatment\" id=\"treatment\" ngcontrol=\"treatment\"\n                                #treatment=\"ngModel\" [(ngModel)]=\"beneficiaryModal.mayorDTO.treatment\" required>\n                            <option value=\"mr\">{{ 'treatment.option1' | translate }}</option>\n                            <option value=\"ms\">{{ 'treatment.option2' | translate }}</option>\n                        </select>\n                    </div>\n                    <div class=\"ui-g-1\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"name\">{{ 'name.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"text\" name=\"name\" id=\"name\" ngcontrol=\"name\"\n                               #name=\"ngModel\" [(ngModel)]=\"beneficiaryModal.mayorDTO.name\" required>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"surname\">{{ 'surname.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"text\" name=\"surname\" id=\"surname\" ngcontrol=\"surname\"\n                               #surname=\"ngModel\" [(ngModel)]=\"beneficiaryModal.mayorDTO.surname\" required>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"email\">{{ 'email.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"email\" name=\"email\" id=\"email\" ngcontrol=\"email\"\n                               #email=\"ngModel\" [(ngModel)]=\"beneficiaryModal.mayorDTO.email\" required disabled>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"button\" class=\"btn btn-primary cancel-button\" (click)=\"closeModal()\">\n                            {{ 'cancel.button' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-2\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!editMayorForm.form.valid\">\n                            {{ 'confirm.button' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n        </form>\n    </p-dialog>\n</div>\n\n\n<div class=\"container-font\" *ngIf=\"beneficiary.represented\">\n    <div class=\"ui-g-1\"></div>\n    <p-dialog [(visible)]=\"displayRepresentative\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"true\">\n        <form (ngSubmit)=\"updateInfo()\" #editRepresentativeForm=\"ngForm\">\n                <div class=\"ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <h3>{{ 'mayordetails.title' | translate }}</h3>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-3\">\n                        <label for=\"treatment\">{{ 'treatment.label' | translate }}</label>\n                        <select class=\"form-control\" name=\"treatment\" id=\"treatment\" ngcontrol=\"treatment\"\n                                #treatment=\"ngModel\" [(ngModel)]=\"beneficiaryModal.representativeDTO.treatment\" required>\n                            <option value=\"mr\">{{ 'treatment.option1' | translate }}</option>\n                            <option value=\"ms\">{{ 'treatment.option2' | translate }}</option>\n                        </select>\n                    </div>\n                    <div class=\"ui-g-1\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"name\">{{ 'name.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"text\" name=\"name\" id=\"name\" ngcontrol=\"name\"\n                               #name=\"ngModel\" [(ngModel)]=\"beneficiaryModal.representativeDTO.name\" required>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"surname\">{{ 'surname.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"text\" name=\"surname\" id=\"surname\" ngcontrol=\"surname\"\n                               #surname=\"ngModel\" [(ngModel)]=\"beneficiaryModal.representativeDTO.surname\" required>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"municipalityRole\">{{ 'role.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"text\" name=\"municipalityRole\" id=\"municipalityRole\"\n                               ngcontrol=\"municipalityRole\"\n                               #municipalityRole=\"ngModel\"\n                               [(ngModel)]=\"beneficiaryModal.representativeDTO.municipalityRole\" required>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-6\">\n                        <label for=\"email\">{{ 'email.label' | translate }}</label>\n                        <input class=\"form-control\" type=\"text\" name=\"email\" id=\"email\" ngcontrol=\"email\"\n                               #email=\"ngModel\" [(ngModel)]=\"beneficiaryModal.representativeDTO.email\" required disabled>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"button\" class=\"btn btn-primary cancel-button\" (click)=\"closeModal()\">\n                            {{ 'cancel.button' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-2\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"submit\" class=\"btn btn-primary publish-button\" [disabled]=\"!editRepresentativeForm.form.valid\">\n                            {{ 'confirm.button' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n        </form>\n    </p-dialog>\n</div>\n\n\n"

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/+profile/profile.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryProfileComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__profile_service__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/+profile/profile.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_angular_2_local_storage__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_MayorDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/MayorDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__shared_swagger_model_RepresentativeDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/RepresentativeDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/BeneficiaryDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_LegalEntityDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/LegalEntityDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__shared_swagger_model_NutsDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/NutsDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__shared_swagger_model_LauDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/LauDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__shared_swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__shared_swagger_api_LauApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/LauApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__shared_swagger_api_UserApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/UserApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__shared_models_beneficiary_details_model__ = __webpack_require__("../../../../../src/app/shared/models/beneficiary-details.model.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};















var BeneficiaryProfileComponent = (function () {
    function BeneficiaryProfileComponent(profileService, uxService, localStorage, beneficiaryApi, nutsApi, lauApi, userApi) {
        var _this = this;
        this.profileService = profileService;
        this.uxService = uxService;
        this.localStorage = localStorage;
        this.beneficiaryApi = beneficiaryApi;
        this.nutsApi = nutsApi;
        this.lauApi = lauApi;
        this.userApi = userApi;
        this.beneficiaryDetails = new __WEBPACK_IMPORTED_MODULE_14__shared_models_beneficiary_details_model__["a" /* BeneficiaryDetails */]();
        this.beneficiary = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]();
        this.beneficiary.mayorDTO = new __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_MayorDTO__["a" /* MayorDTOBase */]();
        this.beneficiary.representativeDTO = new __WEBPACK_IMPORTED_MODULE_6__shared_swagger_model_RepresentativeDTO__["a" /* RepresentativeDTOBase */]();
        this.beneficiary.legalEntityDTO = new __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_LegalEntityDTO__["a" /* LegalEntityDTOBase */]();
        this.beneficiaryModal = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]();
        this.beneficiaryModal.mayorDTO = new __WEBPACK_IMPORTED_MODULE_5__shared_swagger_model_MayorDTO__["a" /* MayorDTOBase */]();
        this.beneficiaryModal.representativeDTO = new __WEBPACK_IMPORTED_MODULE_6__shared_swagger_model_RepresentativeDTO__["a" /* RepresentativeDTOBase */]();
        this.beneficiaryModal.legalEntityDTO = new __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_LegalEntityDTO__["a" /* LegalEntityDTOBase */]();
        this.countryNuts = new __WEBPACK_IMPORTED_MODULE_9__shared_swagger_model_NutsDTO__["a" /* NutsDTOBase */]();
        this.municipalityLau = new __WEBPACK_IMPORTED_MODULE_10__shared_swagger_model_LauDTO__["a" /* LauDTOBase */]();
        this.displayPassword = false;
        this.displayLegal = false;
        this.displayMayor = false;
        this.displayRepresentative = false;
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            switch (this.user.userType) {
                // The user is a mayor
                case 2:
                    this.beneficiaryApi.getMayorById(this.user.userTypeId).subscribe(function (mayor) {
                        if (mayor != null) {
                            _this.beneficiary.represented = false;
                            _this.beneficiary.mayorDTO = mayor;
                            _this.beneficiary.representativeDTO = null;
                            _this.beneficiaryApi.getLegalEntity(_this.beneficiary.mayorDTO.legalEntityId).subscribe(function (entity) {
                                _this.beneficiary.legalEntityDTO = entity;
                                _this.nutsApi.findNutsByLevel(0).subscribe(function (nuts) {
                                    for (var i = 0; i < nuts.length; i++) {
                                        var nut = nuts[i];
                                        nut.name = nut.name.toLowerCase();
                                        nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                                        if (_this.beneficiary.legalEntityDTO.countryCode == nut.countryCode) {
                                            _this.countryNuts = nut;
                                            break;
                                        }
                                    }
                                });
                                _this.lauApi.findLauByLau2AndCountryCode(_this.beneficiary.legalEntityDTO.municipalityCode, _this.beneficiary.legalEntityDTO.countryCode).subscribe(function (lau) {
                                    _this.municipalityLau = lau;
                                    _this.copyModalData();
                                });
                            });
                        }
                        else {
                            _this.beneficiary = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]();
                        }
                    }, function (error) {
                        console.log(error);
                    });
                    break;
                // The user is a representative of a mayor
                case 3:
                    this.beneficiaryApi.getRepresentativeById(this.user.userTypeId).subscribe(function (representative) {
                        if (representative != null) {
                            _this.beneficiary.represented = true;
                            _this.beneficiary.representativeDTO = representative;
                            _this.beneficiaryApi.getMayorById(_this.beneficiary.representativeDTO.mayorId).subscribe(function (mayor) {
                                if (mayor != null) {
                                    _this.beneficiary.mayorDTO = mayor;
                                    _this.beneficiaryApi.getLegalEntity(_this.beneficiary.mayorDTO.legalEntityId).subscribe(function (entity) {
                                        _this.beneficiary.legalEntityDTO = entity;
                                        _this.nutsApi.findNutsByLevel(0).subscribe(function (nuts) {
                                            for (var i = 0; i < nuts.length; i++) {
                                                var nut = nuts[i];
                                                nut.name = nut.name.toLowerCase();
                                                nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                                                if (_this.beneficiary.legalEntityDTO.countryCode == nut.countryCode) {
                                                    _this.countryNuts = nut;
                                                    break;
                                                }
                                            }
                                        });
                                        _this.lauApi.findLauByLau2AndCountryCode(_this.beneficiary.legalEntityDTO.municipalityCode, _this.beneficiary.legalEntityDTO.countryCode).subscribe(function (lau) {
                                            _this.municipalityLau = lau;
                                            _this.copyModalData();
                                        });
                                    });
                                }
                                else {
                                    _this.beneficiary = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]();
                                }
                            });
                        }
                        else {
                            _this.beneficiary = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]();
                        }
                    }, function (error) {
                        console.log(error);
                    });
                    break;
            }
        }
    }
    BeneficiaryProfileComponent.prototype.updateInfo = function () {
        var _this = this;
        this.beneficiaryApi.update(this.user.userTypeId, this.beneficiaryModal).subscribe(function (beneficiary) {
            _this.beneficiary = beneficiary.data;
            _this.closeModal();
        }, function (error) {
            console.log(error);
        });
    };
    BeneficiaryProfileComponent.prototype.updateLegalEntity = function () {
        this.beneficiaryModal.legalEntityDTO.countryCode = this.countryNuts.countryCode;
        this.beneficiaryModal.legalEntityDTO.municipalityCode = this.municipalityLau.lau2;
        this.updateInfo();
    };
    BeneficiaryProfileComponent.prototype.changingPassword = function () {
        this.copyModalData();
        this.displayPassword = true;
    };
    BeneficiaryProfileComponent.prototype.legalEntityEdit = function () {
        this.copyModalData();
        this.displayLegal = true;
    };
    BeneficiaryProfileComponent.prototype.mayorEdit = function () {
        this.copyModalData();
        this.displayMayor = true;
    };
    BeneficiaryProfileComponent.prototype.representativeEdit = function () {
        this.copyModalData();
        this.displayRepresentative = true;
    };
    BeneficiaryProfileComponent.prototype.checkPassword = function () {
        return this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword;
    };
    BeneficiaryProfileComponent.prototype.filterNuts = function (event) {
        var _this = this;
        this.nutsApi.findNutsByLevel(0).subscribe(function (nuts) {
            _this.nutsSuggestions = _this.filterCountries(event.query, nuts);
        }, function (error) {
            _this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'Could not get nuts, ignore this when NG is working in offline mode'
            });
            console.log('WARNING: Could not get nuts', error);
        });
    };
    BeneficiaryProfileComponent.prototype.filterCountries = function (query, nuts) {
        var filteredNuts = [];
        for (var i = 0; i < nuts.length; i++) {
            var nut = nuts[i];
            nut.name = nut.name.toLowerCase();
            if (nut.name.indexOf(query.toLowerCase()) == 0) {
                nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                filteredNuts.push(nut);
            }
        }
        return filteredNuts;
    };
    BeneficiaryProfileComponent.prototype.filterLaus = function (event) {
        var _this = this;
        this.lauApi.findLauByCountryCode(this.countryNuts.countryCode).subscribe(function (laus) { return _this.lauSuggestions = _this.filterMunicipalities(event.query, laus); });
    };
    BeneficiaryProfileComponent.prototype.filterMunicipalities = function (query, laus) {
        var filteredLaus = [];
        for (var i = 0; i < laus.length; i++) {
            var lau = laus[i];
            if (lau.name1 != null) {
                if (lau.name1.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                    filteredLaus.push(lau);
                }
            }
        }
        return filteredLaus;
    };
    BeneficiaryProfileComponent.prototype.emptyModal = function () {
        this.beneficiaryDetails.currentPassword = "";
        this.beneficiaryDetails.newPassword = "";
        this.beneficiaryDetails.repeatNewPassword = "";
    };
    BeneficiaryProfileComponent.prototype.closeModal = function () {
        this.displayPassword = false;
        this.displayLegal = false;
        this.displayMayor = false;
        this.displayRepresentative = false;
        this.emptyModal();
    };
    BeneficiaryProfileComponent.prototype.copyModalData = function () {
        this.beneficiaryModal = new __WEBPACK_IMPORTED_MODULE_7__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]();
        if (this.beneficiary != null) {
            this.beneficiaryModal.mayorDTO = Object.assign({}, this.beneficiary.mayorDTO);
            this.beneficiaryModal.mayorDTO.repeatEmail = this.beneficiaryModal.mayorDTO.email;
            this.beneficiaryModal.legalEntityDTO = Object.assign({}, this.beneficiary.legalEntityDTO);
            if (this.beneficiary.representativeDTO != null) {
                this.beneficiaryModal.representativeDTO = Object.assign({}, this.beneficiary.representativeDTO);
                this.beneficiaryModal.representativeDTO.mayorRepeatEmail = this.beneficiaryModal.representativeDTO.email;
            }
            this.beneficiaryModal.represented = this.beneficiary.represented;
        }
    };
    BeneficiaryProfileComponent.prototype.changePassword = function () {
        var _this = this;
        var passwords = '{"currentPassword" : "' + this.beneficiaryDetails.currentPassword + '", "newPassword" : "' + this.beneficiaryDetails.newPassword + '"}';
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
                _this.emptyModal();
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
    return BeneficiaryProfileComponent;
}());
BeneficiaryProfileComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'beneficiary-profile-component',
        template: __webpack_require__("../../../../../src/app/+beneficiary-portal/+profile/profile.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_1__profile_service__["a" /* ProfileService */], __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */], __WEBPACK_IMPORTED_MODULE_11__shared_swagger_api_NutsApi__["a" /* NutsApi */], __WEBPACK_IMPORTED_MODULE_12__shared_swagger_api_LauApi__["a" /* LauApi */], __WEBPACK_IMPORTED_MODULE_13__shared_swagger_api_UserApi__["a" /* UserApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__profile_service__["a" /* ProfileService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__profile_service__["a" /* ProfileService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3_angular_2_local_storage__["LocalStorageService"]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_11__shared_swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_11__shared_swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_12__shared_swagger_api_LauApi__["a" /* LauApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_12__shared_swagger_api_LauApi__["a" /* LauApi */]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_13__shared_swagger_api_UserApi__["a" /* UserApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_13__shared_swagger_api_UserApi__["a" /* UserApi */]) === "function" && _g || Object])
], BeneficiaryProfileComponent);

var _a, _b, _c, _d, _e, _f, _g;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/profile.component.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/+profile/profile.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ProfileService; });
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



var ProfileService = (function () {
    function ProfileService(http, uxService) {
        this.http = http;
        this.uxService = uxService;
        this.profileUrl = '/api/forgot';
    }
    ProfileService.prototype.extractData = function (response) {
        var body = response.json();
        return body.data || {};
    };
    ProfileService.prototype.changePassword = function (body) {
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["Headers"]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["RequestOptions"]({ headers: headers });
        return this.http.put(this.profileUrl, body, options)
            .map(this.extractData)
            .catch(this.uxService.handleError);
    };
    return ProfileService;
}());
ProfileService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _b || Object])
], ProfileService);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/profile.service.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/+voucher/select-supplier/select-supplier.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <p class=\"Modalh1Confirmation\">{{ 'select.supplier' | translate }}</p>\n    <p class=\"ModalpConfirmation\">{{ 'one.supplier' | translate }}</p>\n    <div class=\"clearfix\"></div>\n    <div class=\"marginTop\">\n        <p-dataTable [value]=\"suppliers\" selectionMode=\"single\" [(selection)]=\"selectedSupplier\" dataKey=\"supplierId\"\n            [rows]=\"10\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[10,20,50,100]\" [globalFilter]=\"gb\">\n            <p-column field=\"supplierId\" header=\"{{ 'number' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column field=\"logo\" header=\"{{ 'image' | translate }}\" [sortable]=\"false\">\n                <template pTemplate=\"body\" let-supplier=\"rowData\">\n                    <img width=\"85\" height=\"45\" [src]=\"supplier.logo\">\n                </template>\n            </p-column>\n            <p-column field=\"name\" header=\"{{ 'company.name' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column field=\"createDate\" header=\"{{ 'registered.date' | translate }}\" [sortable]=\"true\">\n                <template pTemplate=\"body\" let-supplier=\"rowData\">\n                    <span>{{supplier.createDate | date: 'dd/MM/yyyy HH:mm'}}</span>\n                </template>\n            </p-column>\n            <p-column header=\"{{ 'label.details' | translate }}\">\n                <template pTemplate=\"body\" let-supplier=\"rowData\" let-rowIndex=\"rowIndex\">\n                    <button type=\"button\" class=\"btn\" style=\"background: none; padding: 0;\" (click)=\"viewSupplierDetails(rowIndex)\">\n                        <i class=\"fa fa-2x fa-eye\" style=\"font-size: 20px;\"></i> {{ 'view' | translate }}\n                    </button>\n                </template>\n            </p-column>\n        </p-dataTable>\n    </div>\n    <div class=\"form-group ui-g\">\n        <div class=\"ui-g-4\"></div>\n        <div class=\"ui-g-4\" style=\"text-align: center !important\">\n            <button type=\"button\" class=\"btn btn-primary publish-button\" (click)=\"selectSupplier()\">Select</button>\n        </div>\n        <div class=\"ui-g-4\"></div>\n    </div>\n</div>\n<!--MODAL BELOW-->\n<div class=\"font container supplier\">\n    <p-dialog [(visible)]=\"display\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"true\" [closeOnEscape]=\"false\">\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g-12\">\n                <div class=\"beneficiaryMayorModal left\">{{ 'company.details' | translate }}</div>\n            </div>\n        </div>\n        <div class=\"ui-g-12 light-grey left\">\n            <div class=\"ui-g-3\">\n                <div class=\"ui-g-12\">\n                    <p>{{ 'company.name' | translate }}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p>{{ 'legal.address' | translate }}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p>{{ 'web.site' | translate }}</p>\n                </div>\n            </div>\n            <div class=\"ui-g-7\">\n                <div class=\"ui-g-12\">\n                    <p class=\"profileData\">{{selectedSupplier.name}}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p class=\"profileData\">{{selectedSupplier.address}}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p class=\"profileData\"><a [href]=\"selectedSupplier.website\" target=\"_BLANK\">{{selectedSupplier.website}}</a></p>\n                </div>\n            </div>\n            <div class=\"ui-g-2\">\n                <img src=\"\">\n            </div>\n        </div>\n\n\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g-12\">\n                <div class=\"beneficiaryMayorModal left labelModal\">{{ 'contact.person' | translate }}</div>\n            </div>\n        </div>\n        <div class=\"ui-g-12 light-grey left\">\n            <div class=\"ui-g-3\">\n                <div class=\"ui-g-12\">\n                    <p>{{ 'contact.name' | translate }}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p>{{ 'phone.number' | translate }}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p>{{ 'email.modal' | translate }}</p>\n                </div>\n            </div>\n            <div class=\"ui-g-9\">\n                <div class=\"ui-g-12\">\n                    <p class=\"profileData\">{{selectedSupplier.contactName}} {{selectedSupplier.contactSurname}}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p class=\"profileData\">{{selectedSupplier.contactPhonePrefix}}\n                        {{selectedSupplier.contactPhoneNumber}}</p>\n                </div>\n                <div class=\"ui-g-12\">\n                    <p class=\"profileData\">{{selectedSupplier.contactEmail}}</p>\n                </div>\n            </div>\n        </div>\n\n        <div class=\"ui-g-12\">\n            <button type=\"button\" class=\"btn btn-primary publish-button\" (click)=\"selectSupplier()\">{{ 'select.supplier' | translate }}</button>\n        </div>\n\n    </p-dialog>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/+voucher/select-supplier/select-supplier.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SelectSupplierComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/SupplierDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/CallApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__ = __webpack_require__("../../../../angular-2-local-storage/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var SelectSupplierComponent = (function () {
    //@Input('municipalityId') private municipalityId;
    function SelectSupplierComponent(localStorage, supplierApi, beneficiaryApi, callApi, uxService) {
        var _this = this;
        this.localStorage = localStorage;
        this.supplierApi = supplierApi;
        this.beneficiaryApi = beneficiaryApi;
        this.callApi = callApi;
        this.uxService = uxService;
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.suppliers = [];
        this.selectedSupplier = new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_SupplierDTO__["a" /* SupplierDTOBase */]();
        this.display = false;
        this.supplierApi.allSuppliers().subscribe(function (suppliers) {
            for (var i = 0; i < suppliers.length; i++) {
                var countriesPart = suppliers[i].nutsIds.split(";");
                for (var f = 0; f < countriesPart.length; f++) {
                    var regionPart = countriesPart[f].split(',');
                    for (var g = 0; g < regionPart.length; g++) {
                        if (regionPart[g] == _this.myMunicipality.countryCode) {
                            _this.suppliers.push(suppliers[i]);
                            break;
                        }
                    }
                }
            }
        }, function (error) { return console.log(error); });
    }
    SelectSupplierComponent.prototype.openModal = function () {
        this.display = true;
    };
    SelectSupplierComponent.prototype.viewSupplierDetails = function (rowIndex) {
        this.selectedSupplier = this.suppliers[rowIndex];
        this.display = true;
    };
    SelectSupplierComponent.prototype.selectSupplier = function () {
        var _this = this;
        if (this.selectedSupplier.supplierId == null) {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'You have to select a supplier first.'
            });
        }
        else {
            if (this.user != null) {
                this.beneficiaryApi.selectSupplier(this.myMunicipality.legalEntityId, this.publicationId, this.selectedSupplier.supplierId).subscribe(function (data) {
                    _this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'You selected ' + _this.selectedSupplier.name + ' as your supplier.'
                    });
                    _this.display = false;
                }, function (error) {
                    console.log(error);
                    _this.display = false;
                });
            }
        }
    };
    return SelectSupplierComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('publicationId'),
    __metadata("design:type", Object)
], SelectSupplierComponent.prototype, "publicationId", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('myMunicipality'),
    __metadata("design:type", Object)
], SelectSupplierComponent.prototype, "myMunicipality", void 0);
SelectSupplierComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ selector: 'select-supplier-component', template: __webpack_require__("../../../../../src/app/+beneficiary-portal/+voucher/select-supplier/select-supplier.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */], __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */], __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _e || Object])
], SelectSupplierComponent);

var _a, _b, _c, _d, _e;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/select-supplier.component.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/+voucher/voucher.component.html":
/***/ (function(module, exports) {

module.exports = "<timeline-component></timeline-component>\n<div [ngSwitch]=\"voucherCompetitionState\">\n    <!-- no competition created, display warning -->\n    <div *ngSwitchCase=\"0\">\n        <div class=\"ui-g-12\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-info\">{{ 'voucher.noCompetitionPart1' | translate}}<b>{{\n                'voucher.noCompetitionPart2' | translate}}</b></ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"center\">\n            <img src=\"assets/images/notification.png\" alt=\"\">\n        </div>\n        <div class=\"ui-g-12\">\n            <div class=\"ui-g-4\"></div>\n            <div class=\"ui-g-4\">\n                <p class=\"labelModal\">{{ 'voucher.emailNotification' | translate}}</p>\n            </div>\n            <div class=\"ui-g-4\"></div>\n        </div>\n    </div>\n    <!-- no competition active, display timer -->\n    <div *ngSwitchCase=\"1\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.timeleft.title' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.timeleft.subtitle' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12\">\n            <timer-component (timerEvent)=\"checkIfAlreadyApplied()\"\n                             [expirationTimestamp]=\"currentCall.startDate\"></timer-component>\n        </div>\n\n        <hr class=\"beneficiaryHr\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8 beneficiaryMayor\">{{ 'voucher.whats.next' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.steps' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <div class=\"ui-g-3\">\n                <img src=\"assets/images/apply.png\" alt=\"\">\n                <p><span class=\"dotSteps\">1.</span>{{ 'voucher.step1' | translate}}</p>\n            </div>\n            <div class=\"ui-g-3\">\n                <img src=\"assets/images/supplier.png\" alt=\"\">\n                <p><span class=\"dotSteps\">2.</span>{{ 'voucher.step2' | translate}}</p>\n            </div>\n            <div class=\"ui-g-3\">\n                <img src=\"assets/images/check.png\" alt=\"\">\n                <p><span class=\"dotSteps\">3.</span>{{ 'voucher.step3' | translate}}</p>\n            </div>\n            <div class=\"ui-g-3\">\n                <img src=\"assets/images/voucher.png\" alt=\"\">\n                <p><span class=\"dotSteps\">4.</span>{{ 'voucher.step4' | translate}}</p>\n            </div>\n        </div>\n    </div>\n    <!-- competition Open, display apply button -->\n    <div *ngSwitchCase=\"2\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-info\">{{ 'voucher.statusmessage4' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.apply.title' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{ 'voucher.apply.subtitle' | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br><br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" (click)=\"applyForVoucher()\">{{ 'voucher.applyforvoucher' |\n                translate}}\n            </button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n    <!-- user has applied for voucher -->\n    <div *ngSwitchCase=\"3\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-success\">{{ 'voucher.statusmessage5' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.alreadyapplied' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br><br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" disabled>{{ 'voucher.applyforvoucher' | translate}}</button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n    <!-- user has been awarded and can select a supplier -->\n    <select-supplier-component *ngSwitchCase=\"4\" [publicationId]=\"currentCall.callId\"\n                               [myMunicipality]=\"myMunicipality\"></select-supplier-component>\n    <!-- a problem occurred -->\n    <div *ngSwitchCase=\"-1\">\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <ux-alert class=\"ui-g-8\" styleClass=\"alert-danger\">{{ 'voucher.statusmessage3' | translate}}</ux-alert>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <h2 class=\"ui-g-8\">{{ 'voucher.rejectedtitle' | translate}}</h2>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-2\"></span>\n            <span class=\"ui-g-8\">{{errorCause | translate}}</span>\n            <span class=\"ui-g-2\"></span>\n        </div>\n        <br><br>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <span class=\"ui-g-4\">{{ 'voucher.tryagain' | translate}}</span>\n            <span class=\"ui-g-4\"></span>\n        </div>\n        <div class=\"ui-g-12 center\">\n            <span class=\"ui-g-4\"></span>\n            <button class=\"btn btn-primary ui-g-4\" routerLink=\"/home\" routerLinkActive=\"active\">\n                {{ 'voucher.backhome' | translate}}\n            </button>\n            <span class=\"ui-g-4\"></span>\n        </div>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/+voucher/voucher.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return VoucherComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_CallDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/CallDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_LegalEntityDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/LegalEntityDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_BeneficiaryApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts");
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






var VoucherComponent = (function () {
    function VoucherComponent(localStorage, beneficiaryApi, callApi) {
        this.localStorage = localStorage;
        this.beneficiaryApi = beneficiaryApi;
        this.callApi = callApi;
        var u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new __WEBPACK_IMPORTED_MODULE_1__shared_swagger_model_CallDTO__["a" /* CallDTOBase */]();
        this.myMunicipality = new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_LegalEntityDTO__["a" /* LegalEntityDTOBase */]();
    }
    VoucherComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (this.user != null) {
            if (this.user.userType == 3) {
                this.beneficiaryApi.getRepresentativeById(this.user.userTypeId).subscribe(function (representative) {
                    _this.beneficiaryApi.getMayorById(representative.mayorId).subscribe(function (mayor) {
                        _this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(function (entity) {
                            _this.myMunicipality = entity;
                            _this.checkForCalls();
                        }, function (error) {
                            console.log(error);
                            _this.myMunicipality = null;
                            _this.voucherCompetitionState = -1;
                            _this.errorCause = "beneficiaryportal.municipalitynotfound";
                        });
                    }, function (error) {
                        console.log(error);
                        _this.myMunicipality = null;
                        _this.voucherCompetitionState = -1;
                        _this.errorCause = "beneficiaryportal.municipalitynotfound";
                    });
                }, function (error) {
                    console.log(error);
                    _this.myMunicipality = null;
                    _this.voucherCompetitionState = -1;
                    _this.errorCause = "beneficiaryportal.municipalitynotfound";
                });
            }
            else if (this.user.userType == 2) {
                this.beneficiaryApi.getMayorById(this.user.userTypeId).subscribe(function (mayor) {
                    _this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(function (entity) {
                        _this.myMunicipality = entity;
                        _this.checkForCalls();
                    }, function (error) {
                        console.log(error);
                        _this.myMunicipality = null;
                        _this.voucherCompetitionState = -1;
                        _this.errorCause = "beneficiaryportal.municipalitynotfound";
                    });
                }, function (error) {
                    console.log(error);
                    _this.myMunicipality = null;
                    _this.voucherCompetitionState = -1;
                    _this.errorCause = "beneficiaryportal.municipalitynotfound";
                });
            }
        }
    };
    VoucherComponent.prototype.checkForCalls = function () {
        var _this = this;
        this.callApi.allCalls().subscribe(function (calls) {
            _this.currentCall = calls[0];
            if (_this.currentCall != null) {
                // First, check if the call has already began
                if ((_this.currentCall.startDate - new Date().getTime()) <= 0) {
                    _this.checkIfAlreadyApplied();
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
    VoucherComponent.prototype.checkIfAlreadyApplied = function () {
        var _this = this;
        this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(this.myMunicipality.legalEntityId, this.currentCall.callId).subscribe(function (request) {
            if (request != null) {
                if (request.awarded) {
                    // Display 'Select supplier' screen.
                    _this.voucherCompetitionState = 4;
                }
                else {
                    _this.voucherCompetitionState = 3;
                }
            }
            else {
                // The user hasn't applied yet, display the "Apply for Voucher" button.
                _this.voucherCompetitionState = 2;
            }
        }, function (error) {
            console.log(error);
            _this.voucherCompetitionState = -1;
            _this.errorCause = "beneficiaryportal.couldntcheckifapplied";
        });
    };
    VoucherComponent.prototype.applyForVoucher = function () {
        var _this = this;
        this.beneficiaryApi.apply(this.myMunicipality.legalEntityId, this.currentCall.callId).subscribe(function (data) {
            _this.voucherCompetitionState = 3;
        }, function (error) {
            console.log(error);
            _this.voucherCompetitionState = -1;
            _this.errorCause = "beneficiaryportal.errorapplying";
        });
    };
    return VoucherComponent;
}());
VoucherComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+beneficiary-portal/+voucher/voucher.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */], __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__["LocalStorageService"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4_angular_2_local_storage__["LocalStorageService"]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_CallApi__["a" /* CallApi */]) === "function" && _c || Object])
], VoucherComponent);

var _a, _b, _c;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/voucher.component.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/beneficiary-portal-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryPortalRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__voucher_voucher_component__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/+voucher/voucher.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__profile_profile_component__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/+profile/profile.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




var BeneficiaryPortalRoutingModule = (function () {
    function BeneficiaryPortalRoutingModule() {
    }
    return BeneficiaryPortalRoutingModule;
}());
BeneficiaryPortalRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forChild([
                {
                    path: '',
                    component: __WEBPACK_IMPORTED_MODULE_2__voucher_voucher_component__["a" /* VoucherComponent */],
                }, {
                    path: 'profile',
                    component: __WEBPACK_IMPORTED_MODULE_3__profile_profile_component__["a" /* BeneficiaryProfileComponent */]
                }
            ])],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
    })
], BeneficiaryPortalRoutingModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/beneficiary-portal-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/beneficiary-portal.component.html":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/beneficiary-portal.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryPortalComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var BeneficiaryPortalComponent = (function () {
    function BeneficiaryPortalComponent() {
    }
    return BeneficiaryPortalComponent;
}());
BeneficiaryPortalComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+beneficiary-portal/beneficiary-portal.component.html") })
], BeneficiaryPortalComponent);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/beneficiary-portal.component.js.map

/***/ }),

/***/ "../../../../../src/app/+beneficiary-portal/beneficiary-portal.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BeneficiaryPortalModule", function() { return BeneficiaryPortalModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__beneficiary_portal_routing_module__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/beneficiary-portal-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__beneficiary_portal_component__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/beneficiary-portal.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__profile_profile_component__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/+profile/profile.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__beneficiary_portal_voucher_voucher_component__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/+voucher/voucher.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__voucher_select_supplier_select_supplier_component__ = __webpack_require__("../../../../../src/app/+beneficiary-portal/+voucher/select-supplier/select-supplier.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var BeneficiaryPortalModule = (function () {
    function BeneficiaryPortalModule() {
    }
    return BeneficiaryPortalModule;
}());
BeneficiaryPortalModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */], __WEBPACK_IMPORTED_MODULE_2__beneficiary_portal_routing_module__["a" /* BeneficiaryPortalRoutingModule */]
        ],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_5__beneficiary_portal_voucher_voucher_component__["a" /* VoucherComponent */],
            __WEBPACK_IMPORTED_MODULE_3__beneficiary_portal_component__["a" /* BeneficiaryPortalComponent */],
            __WEBPACK_IMPORTED_MODULE_4__profile_profile_component__["a" /* BeneficiaryProfileComponent */],
            __WEBPACK_IMPORTED_MODULE_6__voucher_select_supplier_select_supplier_component__["a" /* SelectSupplierComponent */]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_3__beneficiary_portal_component__["a" /* BeneficiaryPortalComponent */]]
    })
], BeneficiaryPortalModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/beneficiary-portal.module.js.map

/***/ })

});
//# sourceMappingURL=beneficiary-portal.module.chunk.js.map