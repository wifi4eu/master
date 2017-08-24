webpackJsonp(["statistics.module"],{

/***/ "../../../../../src/app/+dgconn-portal/+statistics/first-report/first-report.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"cleafix\"></div>\n\n<div class=\"container\">\n    <div class=\"marginTopStats\"></div>\n\n    <div class=\"center\" style=\"display: block; width: 60%;\">\n        <canvas *ngIf=\"dataReady\" baseChart\n                [data]=\"doughnutChartData\"\n                [labels]=\"doughnutChartLabels\"\n                [chartType]=\"doughnutChartType\"\n                (chartHover)=\"chartHovered($event)\"\n                (chartClick)=\"chartClicked($event)\"></canvas>\n    </div>\n\n    <!--TABLE BELOW-->\n    <div class=\"marginTopStats\"></div>\n    <div class=\"row tableTitle\">\n        <div class=\"col-md-10\">\n            <h2 class=\"h2Table\">{{ 'report1.title' | translate }}</h2>\n        </div>\n        <div class=\"col-md-2\">\n            <a (click)=\"dt.exportCSV()\" class=\"edit editTable\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i>\n                {{'stats.downloadData'\n                |\n                translate }}</a>\n        </div>\n    </div>\n    <p-dataTable #dt [value]=\"tableData\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n        <p-column field=\"label\" header=\"{{ 'memberState' | translate }}  Labels\" [sortable]=\"true\">\n        </p-column>\n        <p-column field=\"value\" header=\"{{ 'applications' | translate }}  Data\" [sortable]=\"true\">\n        </p-column>\n    </p-dataTable>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/first-report/first-report.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnFirstReportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DgConnFirstReportComponent = (function () {
    function DgConnFirstReportComponent(beneficiaryApi) {
        this.beneficiaryApi = beneficiaryApi;
        // Doughnut
        this.doughnutChartLabels = [];
        this.doughnutChartData = [];
        this.doughnutChartType = 'doughnut';
        this.dataReady = false;
        this.getLegalEntities();
    }
    // events
    DgConnFirstReportComponent.prototype.chartClicked = function (e) {
        console.log(e);
    };
    DgConnFirstReportComponent.prototype.chartHovered = function (e) {
        console.log(e);
    };
    DgConnFirstReportComponent.prototype.getLegalEntities = function () {
        var _this = this;
        this.beneficiaryApi.getLegalEntities().subscribe(function (data) {
            _this.legalEntities = data;
            var countriesCountArray = [];
            _this.legalEntities.forEach(function (legalEntity) {
                if (countriesCountArray[legalEntity.countryCode]) {
                    countriesCountArray[legalEntity.countryCode] += 1;
                }
                else {
                    countriesCountArray[legalEntity.countryCode] = 1;
                }
            });
            _this.tableData = [];
            for (var countryInfo in countriesCountArray) {
                _this.doughnutChartLabels.push(countryInfo);
                _this.doughnutChartData.push(countriesCountArray[countryInfo]);
                var item = {
                    label: countryInfo,
                    value: countriesCountArray[countryInfo]
                };
                _this.tableData.push(item);
            }
            _this.dataReady = true;
        }, function (error) {
            (function (error) { return console.log(error); });
        });
    };
    return DgConnFirstReportComponent;
}());
DgConnFirstReportComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/first-report/first-report.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]) === "function" && _a || Object])
], DgConnFirstReportComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/first-report.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/fourth-report/fourth-report.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"cleafix\"></div>\n\n<div class=\"container\">\n    <div class=\"marginTopStats\"></div>\n\n    <div class=\"center\" style=\"display: block; width: 60%;\">\n        <canvas *ngIf=\"dataReady\" baseChart\n                [data]=\"doughnutChartData\"\n                [labels]=\"doughnutChartLabels\"\n                [chartType]=\"doughnutChartType\"\n                (chartHover)=\"chartHovered($event)\"\n                (chartClick)=\"chartClicked($event)\"></canvas>\n    </div>\n\n    <!--TABLE BELOW-->\n    <div class=\"marginTopStats\"></div>\n    <div class=\"row tableTitle\">\n        <div class=\"col-md-10\">\n            <h2 class=\"h2Table\">{{ 'report1.title' | translate }}</h2>\n        </div>\n        <div class=\"col-md-2\">\n            <a (click)=\"dt.exportCSV()\" class=\"edit editTable\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i>\n                {{'stats.downloadData'\n                |\n                translate }}</a>\n        </div>\n    </div>\n    <p-dataTable #dt [value]=\"tableData\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n        <p-column field=\"label\" header=\"{{ 'memberState' | translate }}  Labels\" [sortable]=\"true\">\n        </p-column>\n        <p-column field=\"value\" header=\"{{ 'applications' | translate }}  Data\" [sortable]=\"true\">\n        </p-column>\n    </p-dataTable>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/fourth-report/fourth-report.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnFourthReportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/BeneficiaryApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
/**
 * Created by lviverof on 14/06/2017.
 */


var DgConnFourthReportComponent = (function () {
    function DgConnFourthReportComponent(beneficiaryApi) {
        this.beneficiaryApi = beneficiaryApi;
        // Doughnut
        this.doughnutChartLabels = [];
        this.doughnutChartData = [];
        this.doughnutChartType = 'doughnut';
        this.getLegalEntities();
    }
    // events
    DgConnFourthReportComponent.prototype.chartClicked = function (e) {
        console.log(e);
    };
    DgConnFourthReportComponent.prototype.chartHovered = function (e) {
        console.log(e);
    };
    DgConnFourthReportComponent.prototype.getLegalEntities = function () {
        var _this = this;
        this.beneficiaryApi.getAwardedMunicipalities().subscribe(function (data) {
            _this.legalEntities = data;
            var countriesCountArray = [];
            _this.legalEntities.forEach(function (legalEntity) {
                if (countriesCountArray[legalEntity.countryCode]) {
                    countriesCountArray[legalEntity.countryCode] += 1;
                }
                else {
                    countriesCountArray[legalEntity.countryCode] = 1;
                }
            });
            _this.tableData = [];
            for (var countryInfo in countriesCountArray) {
                _this.doughnutChartLabels.push(countryInfo);
                _this.doughnutChartData.push(countriesCountArray[countryInfo]);
                var item = {
                    label: countryInfo,
                    value: countriesCountArray[countryInfo]
                };
                _this.tableData.push(item);
            }
            _this.dataReady = true;
        }, function (error) {
            (function (error) { return console.log(error); });
        });
    };
    return DgConnFourthReportComponent;
}());
DgConnFourthReportComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/fourth-report/fourth-report.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_BeneficiaryApi__["a" /* BeneficiaryApi */]) === "function" && _a || Object])
], DgConnFourthReportComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/fourth-report.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/second-report/second-report.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"cleafix\"></div>\n\n<div class=\"container\">\n    <div class=\"marginTopStats\"></div>\n\n    <div style=\"display: block\">\n        <canvas *ngIf=\"dataReady\" baseChart\n                [datasets]=\"lineChartData\"\n                [labels]=\"lineChartLabels\"\n                [options]=\"lineChartOptions\"\n                [chartType]=\"lineChartType\"\n                (chartHover)=\"chartHovered($event)\"\n                (chartClick)=\"chartClicked($event)\"></canvas>\n\n    </div>\n\n    <!--TABLE BELOW-->\n    <div class=\"marginTopStats\"></div>\n    <div class=\"row tableTitle\">\n        <div class=\"col-md-10\">\n            <h2 class=\"h2Table\">{{ 'report3.title' | translate }}</h2>\n        </div>\n        <div class=\"col-md-2\">\n            <a (click)=\"dt.exportCSV()\" class=\"edit editTable\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i>\n                {{'stats.downloadData'\n                |\n                translate }}</a>\n        </div>\n    </div>\n    <p-dataTable #dt [value]=\"tableData\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n        <p-column field=\"label\" header=\"{{ 'memberState' | translate }}\" [sortable]=\"true\">\n        </p-column>\n        <p-column field=\"pending\" header=\"{{ 'charts.totalIssues' | translate }}\" [sortable]=\"true\">\n        </p-column>\n        <p-column field=\"value\" header=\"{{ 'charts.totalPending' | translate }}\" [sortable]=\"true\">\n        </p-column>\n    </p-dataTable>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/second-report/second-report.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnSecondReportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_HelpdeskApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/HelpdeskApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DgConnSecondReportComponent = (function () {
    function DgConnSecondReportComponent(helpdeskApi) {
        this.helpdeskApi = helpdeskApi;
        this.dataReady = false;
        this.totalIssues = [];
        this.pendingIssueArray = [];
        this.lineChartData = [];
        this.lineChartLabels = [];
        this.lineChartType = 'line';
        this.lineChartLabels = [];
        this.totalIssues = [];
        this.pendingIssueArray = [];
        this.getHelpdesk();
        this.tableData = [];
    }
    // events
    DgConnSecondReportComponent.prototype.chartClicked = function (e) {
        console.log(e);
    };
    DgConnSecondReportComponent.prototype.chartHovered = function (e) {
        console.log(e);
    };
    DgConnSecondReportComponent.prototype.getHelpdesk = function () {
        var _this = this;
        this.helpdeskApi.allHelpdeskIssues().subscribe(function (data) {
            _this.helpdeskIssues = data;
            var countriesCountArray = [];
            var pendingCountArray = [];
            _this.helpdeskIssues.forEach(function (helpdesk) {
                if (countriesCountArray[helpdesk.memberState]) {
                    countriesCountArray[helpdesk.memberState] += 1;
                    if (helpdesk.status == "Pending") {
                        pendingCountArray[helpdesk.memberState] += 1;
                    }
                }
                else {
                    countriesCountArray[helpdesk.memberState] = 1;
                    pendingCountArray[helpdesk.memberState] = 0;
                    if (helpdesk.status == "Pending") {
                        pendingCountArray[helpdesk.memberState] = 1;
                    }
                }
            });
            for (var countryInfo in countriesCountArray) {
                _this.lineChartLabels.push(countryInfo);
                _this.totalIssues.push(countriesCountArray[countryInfo]);
                _this.pendingIssueArray.push(pendingCountArray[countryInfo]);
                var total = { data: _this.totalIssues, label: 'Total Issues' };
                var pending = { data: _this.pendingIssueArray, label: 'Pending Issues' };
                _this.lineChartData = [total, pending];
                var item = {
                    label: countryInfo,
                    pending: pendingCountArray[countryInfo],
                    value: countriesCountArray[countryInfo]
                };
                _this.tableData.push(item);
            }
            _this.dataReady = true;
        }, function (error) {
            (function (error) { return console.log(error); });
        });
    };
    return DgConnSecondReportComponent;
}());
DgConnSecondReportComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/second-report/second-report.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_HelpdeskApi__["a" /* HelpdeskApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_HelpdeskApi__["a" /* HelpdeskApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_HelpdeskApi__["a" /* HelpdeskApi */]) === "function" && _a || Object])
], DgConnSecondReportComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/second-report.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/statistics-details.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return StatisticsDetails; });
var StatisticsDetails = (function () {
    function StatisticsDetails() {
    }
    return StatisticsDetails;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/statistics-details.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/statistics-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return StatisticsPortalRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__first_report_first_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/first-report/first-report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__statistics_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/statistics.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__second_report_second_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/second-report/second-report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__third_report_third_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/third-report/third-report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__fourth_report_fourth_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/fourth-report/fourth-report.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var StatisticsPortalRoutingModule = (function () {
    function StatisticsPortalRoutingModule() {
    }
    return StatisticsPortalRoutingModule;
}());
StatisticsPortalRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forChild([
                {
                    path: '',
                    component: __WEBPACK_IMPORTED_MODULE_3__statistics_component__["a" /* DgConnStatisticsComponent */],
                }, {
                    path: 'first-report',
                    component: __WEBPACK_IMPORTED_MODULE_2__first_report_first_report_component__["a" /* DgConnFirstReportComponent */]
                }, {
                    path: 'second-report',
                    component: __WEBPACK_IMPORTED_MODULE_4__second_report_second_report_component__["a" /* DgConnSecondReportComponent */]
                }, {
                    path: 'third-report',
                    component: __WEBPACK_IMPORTED_MODULE_5__third_report_third_report_component__["a" /* DgConnThirdReportComponent */]
                }, {
                    path: 'fourth-report',
                    component: __WEBPACK_IMPORTED_MODULE_6__fourth_report_fourth_report_component__["a" /* DgConnFourthReportComponent */]
                }
            ])],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
    })
], StatisticsPortalRoutingModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/statistics-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/statistics.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n\n<div class=\"container\">\n    <div class=\"form-group ui-g marginTopStats center\">\n        <div class=\"ui-g-4\">\n            <div class=\"statisticItem\">\n                <a href=\"#/dgconn-portal/statistics/first-report\">\n                    <img class=\"maxWidth\" src=\"assets/images/noImage.PNG\" alt=\"\">\n                    <p class=\"center fontDashboard paddingStatss\">{{ 'report1.title' | translate }}</p>\n                </a>\n            </div>\n        </div>\n        <div class=\"ui-g-4\">\n            <div class=\"statisticItem\">\n                <a href=\"#/dgconn-portal/statistics/second-report\">\n                    <img class=\"maxWidth\" src=\"assets/images/noImage.PNG\" alt=\"\">\n                    <p class=\"center fontDashboard paddingStats\">{{ 'report3.title' | translate }}</p>\n                </a>\n            </div>\n        </div>\n        <div class=\"ui-g-4\">\n            <div class=\"statisticItem\">\n                <a href=\"#/dgconn-portal/statistics/third-report\">\n                    <img class=\"maxWidth\" src=\"assets/images/noImage.PNG\" alt=\"\">\n                    <p class=\"center fontDashboard paddingStats\">{{ 'report2.title' | translate }}</p>\n                </a>\n            </div>\n        </div>\n    </div>\n    <div class=\"form-group ui-g marginTopStats center\">\n        <div class=\"ui-g-4\">\n            <div class=\"statisticItem\">\n                <a href=\"#/dgconn-portal/statistics/fourth-report\">\n                    <img class=\"maxWidth\" src=\"assets/images/noImage.PNG\" alt=\"\">\n                    <p class=\"center fontDashboard paddingStats\">{{ 'report4.title' | translate }}</p>\n                </a>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"marginTopStats\"></div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/statistics.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnStatisticsComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__statistics_details_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/statistics-details.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DgConnStatisticsComponent = (function () {
    function DgConnStatisticsComponent() {
        this.statisticsDetails = new __WEBPACK_IMPORTED_MODULE_1__statistics_details_component__["a" /* StatisticsDetails */]();
    }
    return DgConnStatisticsComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('statisticsDetails'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__statistics_details_component__["a" /* StatisticsDetails */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__statistics_details_component__["a" /* StatisticsDetails */]) === "function" && _a || Object)
], DgConnStatisticsComponent.prototype, "statisticsDetails", void 0);
DgConnStatisticsComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/statistics.component.html") }),
    __metadata("design:paramtypes", [])
], DgConnStatisticsComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/statistics.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/statistics.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DgConnPortalStatisticsModule", function() { return DgConnPortalStatisticsModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__first_report_first_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/first-report/first-report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__statistics_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/statistics.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__statistics_routing_module__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/statistics-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_ng2_charts__ = __webpack_require__("../../../../ng2-charts/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_ng2_charts___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_ng2_charts__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__second_report_second_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/second-report/second-report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__third_report_third_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/third-report/third-report.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__fourth_report_fourth_report_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/fourth-report/fourth-report.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var DgConnPortalStatisticsModule = (function () {
    function DgConnPortalStatisticsModule() {
    }
    return DgConnPortalStatisticsModule;
}());
DgConnPortalStatisticsModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */], __WEBPACK_IMPORTED_MODULE_4__statistics_routing_module__["a" /* StatisticsPortalRoutingModule */], __WEBPACK_IMPORTED_MODULE_5_ng2_charts__["ChartsModule"]
        ],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_2__first_report_first_report_component__["a" /* DgConnFirstReportComponent */], __WEBPACK_IMPORTED_MODULE_3__statistics_component__["a" /* DgConnStatisticsComponent */], __WEBPACK_IMPORTED_MODULE_6__second_report_second_report_component__["a" /* DgConnSecondReportComponent */], __WEBPACK_IMPORTED_MODULE_7__third_report_third_report_component__["a" /* DgConnThirdReportComponent */], __WEBPACK_IMPORTED_MODULE_8__fourth_report_fourth_report_component__["a" /* DgConnFourthReportComponent */]
        ]
    })
], DgConnPortalStatisticsModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/statistics.module.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/third-report/third-report.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"cleafix\"></div>\n\n<div class=\"container\">\n    <div class=\"marginTopStats\"></div>\n\n    <div style=\"display: block\">\n        <canvas *ngIf=\"dataReady\" baseChart\n                [data]=\"doughnutChartData\"\n                [labels]=\"doughnutChartLabels\"\n                [chartType]=\"doughnutChartType\"\n                (chartHover)=\"chartHovered($event)\"\n                (chartClick)=\"chartClicked($event)\"></canvas>\n    </div>\n\n\n    <!--TABLE BELOW-->\n    <div class=\"marginTopStats\"></div>\n    <div class=\"row tableTitle\">\n        <div class=\"col-md-10\">\n            <h2 class=\"h2Table\">{{ 'report2.title' | translate }}</h2>\n        </div>\n        <div class=\"col-md-2\">\n            <a (click)=\"dt.exportCSV()\" class=\"edit editTable\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i>\n                {{'stats.downloadData'\n                |\n                translate }}</a>\n        </div>\n    </div>\n    <p-dataTable #dt [value]=\"tableData\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n        <p-column field=\"label\" header=\"{{ 'memberState' | translate }}\" [sortable]=\"true\">\n        </p-column>\n        <p-column field=\"value\" header=\"{{ 'applications' | translate }}\" [sortable]=\"true\">\n        </p-column>\n    </p-dataTable>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+statistics/third-report/third-report.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnThirdReportComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_SupplierApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/SupplierApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DgConnThirdReportComponent = (function () {
    function DgConnThirdReportComponent(supplierApi) {
        this.supplierApi = supplierApi;
        // Doughnut
        this.doughnutChartLabels = [];
        this.doughnutChartData = [];
        this.doughnutChartType = 'doughnut';
        this.dataReady = false;
        this.getAllSuppliers();
        this.tableData = [];
    }
    // events
    DgConnThirdReportComponent.prototype.chartClicked = function (e) {
        console.log(e);
    };
    DgConnThirdReportComponent.prototype.chartHovered = function (e) {
        console.log(e);
    };
    DgConnThirdReportComponent.prototype.getAllSuppliers = function () {
        var _this = this;
        this.supplierApi.allSuppliers().subscribe(function (data) {
            var countriesCountArray = [];
            _this.suppliers = data;
            _this.suppliers.forEach(function (supplier) {
                var nutsIds = supplier.nutsIds;
                if (nutsIds && nutsIds.length > 0 && nutsIds.includes(";")) {
                    var r = nutsIds.split(';');
                    var labels = r[0].split(',');
                    for (var i = 0; i < labels.length; i++) {
                        if (countriesCountArray[labels[i]]) {
                            countriesCountArray[labels[i]] += 1;
                        }
                        else {
                            countriesCountArray[labels[i]] = 1;
                        }
                    }
                }
            });
            for (var countryInfo in countriesCountArray) {
                _this.doughnutChartLabels.push(countryInfo);
                _this.doughnutChartData.push(countriesCountArray[countryInfo]);
                var item = {
                    label: countryInfo,
                    value: countriesCountArray[countryInfo]
                };
                _this.tableData.push(item);
            }
            _this.dataReady = true;
        }, function (error) {
            (function (error) { return console.log(error); });
        });
    };
    return DgConnThirdReportComponent;
}());
DgConnThirdReportComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+dgconn-portal/+statistics/third-report/third-report.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]] }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_SupplierApi__["a" /* SupplierApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__shared_swagger_api_SupplierApi__["a" /* SupplierApi */]) === "function" && _a || Object])
], DgConnThirdReportComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-financial/wifi4eu-financial-web/src/main/angular/src/third-report.component.js.map

/***/ })

});
//# sourceMappingURL=statistics.module.chunk.js.map