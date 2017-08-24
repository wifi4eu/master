webpackJsonp(["common"],{

/***/ "../../../../../src/app/shared/models/beneficiary-details.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryDetails; });
var BeneficiaryDetails = (function () {
    function BeneficiaryDetails() {
        this.representativeSelected = false;
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
        this.emailRepresentative = '';
    }
    return BeneficiaryDetails;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/beneficiary-details.model.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export IBeneficiaryApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return BeneficiaryApi; });
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






var IBeneficiaryApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('IBeneficiaryApi');
var BeneficiaryApi = (function () {
    function BeneficiaryApi(http, basePath, configuration) {
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
     * Apply for voucher
     *
     * @param c
     * @param beneficiaryId
     * @param body
     */
    BeneficiaryApi.prototype.apply = function (beneficiaryId, body, c) {
        // noinspection TypeScriptValidateTypes
        return this.applyWithHttpInfo(beneficiaryId, body)
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
     * create Beneficiary
     *
     * @param c
     * @param body
     */
    BeneficiaryApi.prototype.create = function (body, c) {
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
     * find by BeneficiaryId and PublicationId
     *
     * @param c
     * @param beneficiaryId
     * @param publicationId
     */
    BeneficiaryApi.prototype.findByBeneficiaryIdAndPublicationId = function (beneficiaryId, publicationId, c) {
        // noinspection TypeScriptValidateTypes
        return this.findByBeneficiaryIdAndPublicationIdWithHttpInfo(beneficiaryId, publicationId)
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
     * Get awarded legal entities
     *
     * @param c
     */
    BeneficiaryApi.prototype.getAwardedMunicipalities = function (c) {
        return this.getAwardedMunicipalitiesWithHttpInfo()
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
     * Get legal entities
     *
     * @param c
     */
    BeneficiaryApi.prototype.getLegalEntities = function (c) {
        return this.getLegalEntitiesWithHttpInfo()
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
     * get legal Entity information
     *
     * @param c
     * @param legalEntityId
     */
    BeneficiaryApi.prototype.getLegalEntity = function (legalEntityId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getLegalEntityWithHttpInfo(legalEntityId)
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
     * get mayor by id
     *
     * @param c
     * @param mayorId
     */
    BeneficiaryApi.prototype.getMayorById = function (mayorId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getMayorByIdWithHttpInfo(mayorId)
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
     * get representative by id
     *
     * @param c
     * @param representativeId
     */
    BeneficiaryApi.prototype.getRepresentativeById = function (representativeId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getRepresentativeByIdWithHttpInfo(representativeId)
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
     * Select supplier
     *
     * @param c
     * @param beneficiaryId
     * @param publicationId
     * @param body
     */
    BeneficiaryApi.prototype.selectSupplier = function (beneficiaryId, publicationId, body, c) {
        // noinspection TypeScriptValidateTypes
        return this.selectSupplierWithHttpInfo(beneficiaryId, publicationId, body)
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
     * Update beneficiary information
     *
     * @param c
     * @param beneficiaryId
     * @param body
     */
    BeneficiaryApi.prototype.update = function (beneficiaryId, body, c) {
        // noinspection TypeScriptValidateTypes
        return this.updateWithHttpInfo(beneficiaryId, body)
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
     * Apply for voucher
     *
     * @param beneficiaryId
     * @param body
     */
    BeneficiaryApi.prototype.applyWithHttpInfo = function (beneficiaryId, body) {
        var path = this.basePath + ("/beneficiary/" + beneficiaryId + "/apply");
        //        .replace('{' + 'beneficiaryId' + '}', String(beneficiaryId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'beneficiaryId' is not null or undefined
        if (beneficiaryId === null || beneficiaryId === undefined) {
            throw new Error('Required parameter beneficiaryId was null or undefined when calling apply.');
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
     * create Beneficiary
     *
     * @param body
     */
    BeneficiaryApi.prototype.createWithHttpInfo = function (body) {
        var path = this.basePath + "/beneficiary";
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
     * find by BeneficiaryId and PublicationId
     *
     * @param beneficiaryId
     * @param publicationId
     */
    BeneficiaryApi.prototype.findByBeneficiaryIdAndPublicationIdWithHttpInfo = function (beneficiaryId, publicationId) {
        var path = this.basePath + ("/beneficiary/" + beneficiaryId + "/checkApplied/" + publicationId);
        //        .replace('{' + 'beneficiaryId' + '}', String(beneficiaryId)) 
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'publicationId' + '}', String(publicationId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'beneficiaryId' is not null or undefined
        if (beneficiaryId === null || beneficiaryId === undefined) {
            throw new Error('Required parameter beneficiaryId was null or undefined when calling findByBeneficiaryIdAndPublicationId.');
        }
        // verify required parameter 'publicationId' is not null or undefined
        if (publicationId === null || publicationId === undefined) {
            throw new Error('Required parameter publicationId was null or undefined when calling findByBeneficiaryIdAndPublicationId.');
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
     * Get awarded legal entities
     *
     */
    BeneficiaryApi.prototype.getAwardedMunicipalitiesWithHttpInfo = function () {
        var path = this.basePath + "/beneficiary/awarded";
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
     * Get legal entities
     *
     */
    BeneficiaryApi.prototype.getLegalEntitiesWithHttpInfo = function () {
        var path = this.basePath + "/beneficiary";
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
     * get legal Entity information
     *
     * @param legalEntityId
     */
    BeneficiaryApi.prototype.getLegalEntityWithHttpInfo = function (legalEntityId) {
        var path = this.basePath + ("/beneficiary/" + legalEntityId);
        //        .replace('{' + 'legalEntityId' + '}', String(legalEntityId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'legalEntityId' is not null or undefined
        if (legalEntityId === null || legalEntityId === undefined) {
            throw new Error('Required parameter legalEntityId was null or undefined when calling getLegalEntity.');
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
     * get mayor by id
     *
     * @param mayorId
     */
    BeneficiaryApi.prototype.getMayorByIdWithHttpInfo = function (mayorId) {
        var path = this.basePath + ("/beneficiary/mayor/" + mayorId);
        //        .replace('{' + 'mayorId' + '}', String(mayorId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'mayorId' is not null or undefined
        if (mayorId === null || mayorId === undefined) {
            throw new Error('Required parameter mayorId was null or undefined when calling getMayorById.');
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
     * get representative by id
     *
     * @param representativeId
     */
    BeneficiaryApi.prototype.getRepresentativeByIdWithHttpInfo = function (representativeId) {
        var path = this.basePath + ("/beneficiary/representative/" + representativeId);
        //        .replace('{' + 'representativeId' + '}', String(representativeId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'representativeId' is not null or undefined
        if (representativeId === null || representativeId === undefined) {
            throw new Error('Required parameter representativeId was null or undefined when calling getRepresentativeById.');
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
     * Select supplier
     *
     * @param beneficiaryId
     * @param publicationId
     * @param body
     */
    BeneficiaryApi.prototype.selectSupplierWithHttpInfo = function (beneficiaryId, publicationId, body) {
        var path = this.basePath + ("/beneficiary/" + beneficiaryId + "/publication/" + publicationId + "/supplier");
        //        .replace('{' + 'beneficiaryId' + '}', String(beneficiaryId)) 
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'publicationId' + '}', String(publicationId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'beneficiaryId' is not null or undefined
        if (beneficiaryId === null || beneficiaryId === undefined) {
            throw new Error('Required parameter beneficiaryId was null or undefined when calling selectSupplier.');
        }
        // verify required parameter 'publicationId' is not null or undefined
        if (publicationId === null || publicationId === undefined) {
            throw new Error('Required parameter publicationId was null or undefined when calling selectSupplier.');
        }
        headers.set('Content-Type', 'application/json');
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Put,
            headers: headers,
            body: body == null ? '' : Object(__WEBPACK_IMPORTED_MODULE_0_class_transformer__["classToPlain"])(body),
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    /**
     * Update beneficiary information
     *
     * @param beneficiaryId
     * @param body
     */
    BeneficiaryApi.prototype.updateWithHttpInfo = function (beneficiaryId, body) {
        var path = this.basePath + ("/beneficiary/" + beneficiaryId);
        //        .replace('{' + 'beneficiaryId' + '}', String(beneficiaryId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'beneficiaryId' is not null or undefined
        if (beneficiaryId === null || beneficiaryId === undefined) {
            throw new Error('Required parameter beneficiaryId was null or undefined when calling update.');
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
    return BeneficiaryApi;
}());
BeneficiaryApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], BeneficiaryApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/BeneficiaryApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/LauApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export ILauApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LauApi; });
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






var ILauApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('ILauApi');
var LauApi = (function () {
    function LauApi(http, basePath, configuration) {
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
     * create LAU
     *
     * @param c
     * @param body
     */
    LauApi.prototype.create = function (body, c) {
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
     * get Lau by Country Code i.e: ES
     *
     * @param c
     * @param countryCode
     */
    LauApi.prototype.findLauByCountryCode = function (countryCode, c) {
        return this.findLauByCountryCodeWithHttpInfo(countryCode)
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
     * get Lau by LAU2 and Country Code i.e: 08019
     *
     * @param c
     * @param lau2
     * @param countryCode
     */
    LauApi.prototype.findLauByLau2AndCountryCode = function (lau2, countryCode, c) {
        // noinspection TypeScriptValidateTypes
        return this.findLauByLau2AndCountryCodeWithHttpInfo(lau2, countryCode)
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
     * get Lau by NUTS3 i.e: ES513
     *
     * @param c
     * @param nuts3
     */
    LauApi.prototype.findLauByNuts3 = function (nuts3, c) {
        return this.findLauByNuts3WithHttpInfo(nuts3)
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
     * create LAU
     *
     * @param body
     */
    LauApi.prototype.createWithHttpInfo = function (body) {
        var path = this.basePath + "/lau";
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
     * get Lau by Country Code i.e: ES
     *
     * @param countryCode
     */
    LauApi.prototype.findLauByCountryCodeWithHttpInfo = function (countryCode) {
        var path = this.basePath + ("/lau/" + countryCode);
        //        .replace('{' + 'countryCode' + '}', String(countryCode));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling findLauByCountryCode.');
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
     * get Lau by LAU2 and Country Code i.e: 08019
     *
     * @param lau2
     * @param countryCode
     */
    LauApi.prototype.findLauByLau2AndCountryCodeWithHttpInfo = function (lau2, countryCode) {
        var path = this.basePath + ("/lau/lau2/" + lau2 + "/countryCode/" + countryCode);
        //        .replace('{' + 'lau2' + '}', String(lau2)) 
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)//        .replace('{' + 'countryCode' + '}', String(countryCode));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'lau2' is not null or undefined
        if (lau2 === null || lau2 === undefined) {
            throw new Error('Required parameter lau2 was null or undefined when calling findLauByLau2AndCountryCode.');
        }
        // verify required parameter 'countryCode' is not null or undefined
        if (countryCode === null || countryCode === undefined) {
            throw new Error('Required parameter countryCode was null or undefined when calling findLauByLau2AndCountryCode.');
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
     * get Lau by NUTS3 i.e: ES513
     *
     * @param nuts3
     */
    LauApi.prototype.findLauByNuts3WithHttpInfo = function (nuts3) {
        var path = this.basePath + ("/lau/nuts3/" + nuts3);
        //        .replace('{' + 'nuts3' + '}', String(nuts3));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'nuts3' is not null or undefined
        if (nuts3 === null || nuts3 === undefined) {
            throw new Error('Required parameter nuts3 was null or undefined when calling findLauByNuts3.');
        }
        var requestOptions = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestOptions"]({
            method: __WEBPACK_IMPORTED_MODULE_2__angular_http__["RequestMethod"].Get,
            headers: headers,
            search: queryParameters,
            responseType: __WEBPACK_IMPORTED_MODULE_2__angular_http__["ResponseContentType"].Json
        });
        return this.http.request(path, requestOptions);
    };
    return LauApi;
}());
LauApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], LauApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/LauApi.js.map

/***/ }),

/***/ "../../../../../src/app/shared/swagger/api/SupplierApi.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export ISupplierApi */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SupplierApi; });
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






var ISupplierApi = new __WEBPACK_IMPORTED_MODULE_1__angular_core__["OpaqueToken"]('ISupplierApi');
var SupplierApi = (function () {
    function SupplierApi(http, basePath, configuration) {
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
     * Get all the suppliers
     *
     * @param c
     */
    SupplierApi.prototype.allSuppliers = function (c) {
        return this.allSuppliersWithHttpInfo()
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
     * create access point
     *
     * @param c
     * @param body
     */
    SupplierApi.prototype.createAccessPoint = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createAccessPointWithHttpInfo(body)
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
     * create supplier
     *
     * @param c
     * @param body
     */
    SupplierApi.prototype.createSupplier = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.createSupplierWithHttpInfo(body)
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
     * Get installation by installationId
     *
     * @param c
     * @param installationId
     */
    SupplierApi.prototype.getInstallationById = function (installationId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getInstallationByIdWithHttpInfo(installationId)
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
     * Get legal entity by installation id
     *
     * @param c
     * @param installationId
     */
    SupplierApi.prototype.getLegalEntityByInstallationId = function (installationId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getLegalEntityByInstallationIdWithHttpInfo(installationId)
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
     * Get selected by supplierId
     *
     * @param c
     * @param supplierId
     */
    SupplierApi.prototype.getSelectedMeBySupplierId = function (supplierId, c) {
        return this.getSelectedMeBySupplierIdWithHttpInfo(supplierId)
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
     * Get supplier by supplierId
     *
     * @param c
     * @param supplierId
     */
    SupplierApi.prototype.getSupplierById = function (supplierId, c) {
        // noinspection TypeScriptValidateTypes
        return this.getSupplierByIdWithHttpInfo(supplierId)
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
     * save supplier
     *
     * @param c
     * @param body
     */
    SupplierApi.prototype.saveSupplier = function (body, c) {
        // noinspection TypeScriptValidateTypes
        return this.saveSupplierWithHttpInfo(body)
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
     * Get all the suppliers
     *
     */
    SupplierApi.prototype.allSuppliersWithHttpInfo = function () {
        var path = this.basePath + "/supplier";
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
     * create access point
     *
     * @param body
     */
    SupplierApi.prototype.createAccessPointWithHttpInfo = function (body) {
        var path = this.basePath + "/supplier/accessPoint";
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
     * create supplier
     *
     * @param body
     */
    SupplierApi.prototype.createSupplierWithHttpInfo = function (body) {
        var path = this.basePath + "/supplier";
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
     * Get installation by installationId
     *
     * @param installationId
     */
    SupplierApi.prototype.getInstallationByIdWithHttpInfo = function (installationId) {
        var path = this.basePath + ("/supplier/" + installationId + "/installation");
        //        .replace('{' + 'installationId' + '}', String(installationId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'installationId' is not null or undefined
        if (installationId === null || installationId === undefined) {
            throw new Error('Required parameter installationId was null or undefined when calling getInstallationById.');
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
     * Get legal entity by installation id
     *
     * @param installationId
     */
    SupplierApi.prototype.getLegalEntityByInstallationIdWithHttpInfo = function (installationId) {
        var path = this.basePath + ("/supplier/legalEntityByInstallation/" + installationId);
        //        .replace('{' + 'installationId' + '}', String(installationId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'installationId' is not null or undefined
        if (installationId === null || installationId === undefined) {
            throw new Error('Required parameter installationId was null or undefined when calling getLegalEntityByInstallationId.');
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
     * Get selected by supplierId
     *
     * @param supplierId
     */
    SupplierApi.prototype.getSelectedMeBySupplierIdWithHttpInfo = function (supplierId) {
        var path = this.basePath + ("/supplier/selectedBy/" + supplierId);
        //        .replace('{' + 'supplierId' + '}', String(supplierId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'supplierId' is not null or undefined
        if (supplierId === null || supplierId === undefined) {
            throw new Error('Required parameter supplierId was null or undefined when calling getSelectedMeBySupplierId.');
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
     * Get supplier by supplierId
     *
     * @param supplierId
     */
    SupplierApi.prototype.getSupplierByIdWithHttpInfo = function (supplierId) {
        var path = this.basePath + ("/supplier/" + supplierId);
        //        .replace('{' + 'supplierId' + '}', String(supplierId));  
        // not needed as long as the Angular2Typescript language generates the path as TypeScript template string 
        // (https://basarat.gitbooks.io/typescript/content/docs/template-strings.html)
        var queryParameters = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["URLSearchParams"]();
        var headers = new __WEBPACK_IMPORTED_MODULE_2__angular_http__["Headers"](this.defaultHeaders.toJSON()); // https://github.com/angular/angular/issues/6845
        // verify required parameter 'supplierId' is not null or undefined
        if (supplierId === null || supplierId === undefined) {
            throw new Error('Required parameter supplierId was null or undefined when calling getSupplierById.');
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
     * save supplier
     *
     * @param body
     */
    SupplierApi.prototype.saveSupplierWithHttpInfo = function (body) {
        var path = this.basePath + "/supplier/save";
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
    return SupplierApi;
}());
SupplierApi = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Injectable"])(),
    __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()), __param(1, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Inject"])(__WEBPACK_IMPORTED_MODULE_4__variables__["a" /* BASE_PATH */])),
    __param(2, Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["Optional"])()),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["Http"]) === "function" && _a || Object, String, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__configuration__["a" /* Configuration */]) === "function" && _b || Object])
], SupplierApi);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/SupplierApi.js.map

/***/ })

});
//# sourceMappingURL=common.chunk.js.map