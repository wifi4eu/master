webpackJsonp(["dgconnportal.module"],{

/***/ "../../../../../src/app/+dgconn-portal/+publication/publication.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"row tableTitle\">\n        <div class=\"col-md-10\">\n            <h2 class=\"h2Table\">{{ 'publication.title' | translate }}</h2>\n        </div>\n        <div class=\"col-md-2\">\n            <a (click)=\"addNewElement()\" class=\"edit editTable\"><img src=\"assets/images/add-circle-outline-material-icons-regular.png\" alt=\"\"> {{'newEvent.label' | translate }}</a>\n        </div>\n    </div>\n    <p-dataTable [value]=\"calls\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n        <p-column field=\"event\" header=\"{{ 'event.title' | translate }}\" [sortable]=\"true\">\n        </p-column>\n        <p-column field=\"startDate\" header=\"{{ 'start.date' | translate }}\" [sortable]=\"true\">\n            <template pTemplate=\"body\" let-call=\"rowData\">\n                <span>{{call.startDate | date: 'dd/MM/yyyy HH:mm'}}</span>\n            </template>\n        </p-column>\n        <p-column field=\"endDate\" header=\"{{ 'end.date' | translate }}\" [sortable]=\"true\">\n            <template pTemplate=\"body\" let-call=\"rowData\">\n                <span>{{call.endDate | date: 'dd/MM/yyyy HH:mm'}}</span>\n            </template>\n        </p-column>\n        <p-column header=\"{{ 'edit.button' | translate }}\">\n            <template pTemplate=\"body\" let-element=\"rowData\" let-rowElement=\"rowIndex\">\n                <button type=\"button\" class=\"btn\" style=\"background: none; padding: 0;\"\n                        (click)=\"displayInfo(element)\">\n                    <i class=\"fa fa-pencil\" style=\"font-size: 17px; color: #004494;\"></i> {{ 'edit.button' | translate}}\n                </button>\n            </template>\n        </p-column>\n        <p-column header=\"{{ 'delete.button' | translate }}\">\n            <template pTemplate=\"body\" let-rowElement=\"rowIndex\">\n                <button type=\"button\" class=\"btn\" style=\"background: none; padding: 0;\"\n                        (click)=\"deleteElement(rowElement)\">\n                    <i class=\"fa fa-trash-o\" style=\"font-size: 17px; color: red;\" aria-hidden=\"true\"></i>\n                    {{ 'delete.button' | translate }}\n                </button>\n            </template>\n        </p-column>\n    </p-dataTable>\n    <!--MODALS BELOW-->\n    <div class=\"container font\">\n        <div class=\"ui-g-1\"></div>\n        <p-dialog [(visible)]=\"display\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\"\n                  [draggable]=\"false\" [closable]=\"false\" [closeOnEscape]=\"false\">\n            <button type=\"button\" (click)=\"cancelPublication()\" class=\"closeButton\">X</button>\n            <p class=\"beneficiaryMayorModal\">{{'publication.call' | translate }}</p>\n            <form (ngSubmit)=\"onSubmit()\" #publicationForm=\"ngForm\">\n                <div class=\"containerTimeline center\">\n                    <div class=\"form-group ui-g\">\n                        <div class=\"ui-g-12\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"event\">{{'labelModal.timeline' | translate }}</label>\n                                <input type=\"text\" [(ngModel)]=\"event\" id=\"event\" class=\"form-control\" name=\"event\" required>\n                            </div>\n                        </div>\n                    </div>\n                    <div class=\"form-group ui-g\">\n                        <div class=\"ui-g-3\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"startDate\">{{'opening.date' | translate }}</label>\n                                <p-calendar [monthNavigator]=\"true\" [yearNavigator]=\"true\" yearRange=\"2017:2027\"\n                                            [showIcon]=\"true\" type=\"text\" dateFormat=\"dd/mm/yy\" [(ngModel)]=\"startDate\"\n                                            name=\"startDate\" onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-1\"></div>\n                        <div class=\"ui-g-2\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"startTime\">{{'start.time' | translate }}</label>\n                                <p-calendar timeFormat=\"HH:mm:ss\" [timeOnly]=\"true\" [showIcon]=\"true\" type=\"text\" [(ngModel)]=\"startTime\" name=\"startTime\"\n                                            onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-6\"></div>\n                    </div>\n                    <div class=\"form-group ui-g\">\n                        <div class=\"ui-g-3\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"endDate\">{{'closing.date' | translate }}</label>\n                                <p-calendar [monthNavigator]=\"true\" [yearNavigator]=\"true\" yearRange=\"2017:2027\"\n                                            [showIcon]=\"true\" type=\"text\" dateFormat=\"dd/mm/yy\" [(ngModel)]=\"endDate\"\n                                            name=\"endDate\" onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-1\"></div>\n                        <div class=\"ui-g-2\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"endTime\">{{'end.time' | translate }}</label>\n                                <p-calendar timeFormat=\"HH:mm:ss\" [timeOnly]=\"true\" [showIcon]=\"true\" type=\"text\" [(ngModel)]=\"endTime\" name=\"endTime\"\n                                            onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-6\"></div>\n                    </div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"button\" (click)=\"cancelPublication()\" class=\"btn btn-primary cancel-button\">\n                            {{ 'cancel.button' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-1\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"button\" (click)=\"createPublication()\" class=\"btn btn-primary publish-button\"\n                                *ngIf=\"!newElementForm\" [disabled]=\"!(publicationForm.form.valid && checkDate())\">\n                                {{ 'change.publication' | translate }}\n                        </button>\n                        <button type=\"button\" (click)=\"createPublication()\" class=\"btn btn-primary publish-button\"\n                                *ngIf=\"newElementForm\" [disabled]=\"!(publicationForm.form.valid && checkDate())\">\n                            {{ 'add.publication' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n            </form>\n        </p-dialog>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+publication/publication.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnPublicationComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__ = __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal-details.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_CallDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/CallDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/CallApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var DgConnPublicationComponent = (function () {
    function DgConnPublicationComponent(callApi) {
        var _this = this;
        this.callApi = callApi;
        this.display = false;
        this.dgConnDetails = new __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */]();
        this.callApi.allCalls().subscribe(function (calls) { return _this.calls = calls; }, function (error) { return console.log(error); });
        this.newElementForm = false;
    }
    DgConnPublicationComponent.prototype.addNewElement = function () {
        var _this = this;
        this.event = '';
        this.startDate = null;
        this.endDate = null;
        this.startTime = null;
        this.endTime = null;
        this.newElementForm = true;
        this.display = true;
        this.callApi.allCalls().subscribe(function (calls) { return _this.calls = calls; }, function (error) { return console.log(error); });
    };
    DgConnPublicationComponent.prototype.displayInfo = function (rowData) {
        var _this = this;
        this.call = rowData;
        this.event = rowData.event;
        this.startTime = new Date(rowData.startDate);
        this.endTime = new Date(rowData.endDate);
        this.startDate = new Date(rowData.startDate);
        this.endDate = new Date(rowData.endDate);
        this.newElementForm = false;
        this.display = true;
        this.callApi.allCalls().subscribe(function (calls) { return _this.calls = calls; }, function (error) { return console.log(error); });
    };
    DgConnPublicationComponent.prototype.deleteElement = function (rowData) {
        var _this = this;
        this.callApi.deleteCall(this.calls[rowData].callId).subscribe(function (data) {
            _this.callApi.allCalls().subscribe(function (calls) { return _this.calls = calls; }, function (error) { return console.log(error); });
        }, function (error) { return console.log(error); });
    };
    DgConnPublicationComponent.prototype.cancelPublication = function () {
        this.newElementForm = false;
        this.display = false;
    };
    DgConnPublicationComponent.prototype.createPublication = function () {
        var _this = this;
        var call = (this.call) ? this.call : new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_CallDTO__["a" /* CallDTOBase */]();
        var finalStartDate = this.startDate;
        var finalEndDate = this.endDate;
        call.event = this.event;
        finalStartDate.setHours(this.startTime.getHours());
        finalStartDate.setMinutes(this.startTime.getMinutes());
        call.startDate = finalStartDate.getTime();
        finalEndDate.setHours(this.endTime.getHours());
        finalEndDate.setMinutes(this.endTime.getMinutes());
        call.endDate = finalEndDate.getTime();
        this.callApi.createCall(call).subscribe(function (data) {
            _this.callApi.allCalls().subscribe(function (calls) {
                _this.calls = calls;
                _this.newElementForm = false;
                _this.display = false;
            }, function (error) {
                console.log(error);
                _this.newElementForm = false;
                _this.display = false;
            });
        }, function (error) {
            console.log(error);
            _this.newElementForm = false;
            _this.display = false;
        });
        this.call = null;
    };
    DgConnPublicationComponent.prototype.checkDate = function () {
        if (this.startDate && this.startDate) {
            var finalStartDate = this.startDate;
            var finalEndDate = this.endDate;
            finalStartDate.setHours(this.startTime.getHours());
            finalStartDate.setMinutes(this.startTime.getMinutes());
            finalEndDate.setHours(this.endTime.getHours());
            finalEndDate.setMinutes(this.endTime.getMinutes());
            return finalStartDate < finalEndDate;
        }
        return false;
    };
    return DgConnPublicationComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('dgConnDetails'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */]) === "function" && _a || Object)
], DgConnPublicationComponent.prototype, "dgConnDetails", void 0);
DgConnPublicationComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+dgconn-portal/+publication/publication.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__["a" /* CallApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__["a" /* CallApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_CallApi__["a" /* CallApi */]) === "function" && _b || Object])
], DgConnPublicationComponent);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/publication.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+timeline/timeline.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"container\">\n    <div class=\"row tableTitle\">\n        <div class=\"col-md-10\">\n            <h2 class=\"h2Table\">{{ 'timeline.label' | translate }}</h2>\n        </div>\n        <div class=\"col-md-2\">\n            <a (click)=\"addNewElement()\" class=\"edit editTable\"><img src=\"assets/images/add-circle-outline-material-icons-regular.png\" alt=\"\"> {{'newEvent.label' | translate }}</a>\n        </div>\n    </div>\n    <p-dataTable [value]=\"timelines\" [rows]=\"5\" [paginator]=\"true\" [pageLinks]=\"3\" [rowsPerPageOptions]=\"[5,10,20]\">\n        <p-column field=\"event\" header=\"{{ 'event.title' | translate }}\" [sortable]=\"true\"></p-column>\n        <p-column field=\"startDate\" header=\"{{ 'start.date' | translate }}\" [sortable]=\"true\">\n            <template pTemplate=\"body\" let-timeline=\"rowData\">\n                <span>{{timeline.startDate | date: 'dd/MM/yyyy HH:mm'}}</span>\n            </template>\n        </p-column>\n        <p-column field=\"endDate\" header=\"{{ 'end.date' | translate }}\" [sortable]=\"true\">\n            <template pTemplate=\"body\" let-timeline=\"rowData\">\n                <span>{{timeline.endDate | date: 'dd/MM/yyyy HH:mm'}}</span>\n            </template>\n        </p-column>\n        <p-column header=\"{{ 'edit.button' | translate }}\">\n            <template pTemplate=\"body\" let-timeline=\"rowData\" let-rowElement=\"rowIndex\">\n                <button type=\"button\" class=\"btn\" style=\"background: none; padding: 0;\" (click)=\"displayInfo(timeline)\">\n                    <i class=\"fa fa-pencil\" style=\"font-size: 17px; color: #004494;\"></i> {{ 'edit.button' | translate }}\n                </button>\n            </template>\n        </p-column>\n        <p-column header=\"{{ 'delete.button' | translate }}\">\n            <template pTemplate=\"body\" let-rowElement=\"rowIndex\">\n                <button type=\"button\" class=\"btn\" style=\"background: none; padding: 0;\" (click)=\"deleteElement(rowElement)\">\n                    <i class=\"fa fa-trash-o\" style=\"font-size: 17px; color: red;\" aria-hidden=\"true\"></i> {{ 'delete.button' | translate }}\n                </button>\n            </template>\n        </p-column>\n    </p-dataTable>\n    <!--MODALS BELOW-->\n    <div class=\"container font\">\n        <div class=\"ui-g-1\"></div>\n        <p-dialog [(visible)]=\"display\" [modal]=\"true\" [responsive]=\"true\" [resizable]=\"false\" [draggable]=\"false\" [closable]=\"false\" [closeOnEscape]=\"false\">\n            <button type=\"button\" (click)=\"cancelTimeline()\" class=\"closeButton\">X</button>\n            <p class=\"beneficiaryMayorModal\">{{'publication.call' | translate }}</p>\n            <form (ngSubmit)=\"onSubmit()\" #publicationForm=\"ngForm\">\n                <div class=\"containerTimeline center\">\n                    <div class=\"form-group ui-g\">\n                        <div class=\"ui-g-12\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"event\">{{'labelModal.timeline' | translate }}</label>\n                                <input type=\"text\" [(ngModel)]=\"event\" id=\"event\" class=\"form-control\" name=\"event\" required>\n                            </div>\n                        </div>\n                    </div>\n                    <div class=\"form-group ui-g\">\n                        <div class=\"ui-g-3\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"startDate\">{{'opening.date' | translate }}</label>\n                                <p-calendar [monthNavigator]=\"true\" [yearNavigator]=\"true\" yearRange=\"2017:2027\" [showIcon]=\"true\" type=\"text\"\n                                            dateFormat=\"dd/mm/yy\" [(ngModel)]=\"startDate\" name=\"startDate\" onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-1\"></div>\n                        <div class=\"ui-g-2\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"startTime\">{{'start.time' | translate }}</label>\n                                <p-calendar [monthNavigator]=\"false\" timeFormat=\"HH:mm:ss\" [timeOnly]=\"true\" [showIcon]=\"true\" type=\"text\"\n                                            [(ngModel)]=\"startTime\" name=\"startTime\" onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-6\"></div>\n                    </div>\n                    <div class=\"form-group ui-g\">\n                        <div class=\"ui-g-3\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"endDate\">{{'closing.date' | translate }}</label>\n                                <p-calendar [monthNavigator]=\"true\" [yearNavigator]=\"true\" yearRange=\"2017:2027\" [showIcon]=\"true\" type=\"text\"\n                                            dateFormat=\"dd/mm/yy\" [(ngModel)]=\"endDate\" name=\"endDate\" onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-1\"></div>\n                        <div class=\"ui-g-2\">\n                            <div class=\"form-group left\">\n                                <label class=\"labelModal\" for=\"endTime\">{{'end.time' | translate }}</label>\n                                <p-calendar timeFormat=\"HH:mm:ss\" [timeOnly]=\"true\" [showIcon]=\"true\" type=\"text\"\n                                            [(ngModel)]=\"endTime\" name=\"endTime\" onkeydown=\"return false\" required></p-calendar>\n                            </div>\n                        </div>\n                        <div class=\"ui-g-6\"></div>\n                    </div>\n                </div>\n                <div class=\"form-group ui-g\">\n                    <div class=\"ui-g-3\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"button\" (click)=\"cancelTimeline()\" class=\"btn btn-primary cancel-button\">\n                            {{'cancel.button' | translate}}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-1\"></div>\n                    <div class=\"ui-g-2\" style=\"text-align: center !important\">\n                        <button type=\"button\" (click)=\"createTimeline()\" class=\"btn btn-primary publish-button\"\n                                *ngIf=\"!newElementForm\" [disabled]=\"!(publicationForm.form.valid && checkDate())\">{{'timeline.change' | translate }}\n                        </button>\n                        <button type=\"button\" (click)=\"createTimeline()\" class=\"btn btn-primary publish-button\"\n                                *ngIf=\"newElementForm\" [disabled]=\"!(publicationForm.form.valid && checkDate())\">{{'add.timeline' | translate }}\n                        </button>\n                    </div>\n                    <div class=\"ui-g-3\"></div>\n                </div>\n            </form>\n        </p-dialog>\n    </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+timeline/timeline.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnTimelineComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__ = __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal-details.model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_TimelineDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/TimelineDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_TimelineApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/TimelineApi.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var DgConnTimelineComponent = (function () {
    function DgConnTimelineComponent(timelineApi) {
        var _this = this;
        this.timelineApi = timelineApi;
        this.display = false;
        this.dgConnDetails = new __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */]();
        this.timelineApi.allTimelines().subscribe(function (timelines) { return _this.timelines = timelines; }, function (error) { return console.log(error); });
        this.newElementForm = false;
    }
    DgConnTimelineComponent.prototype.addNewElement = function () {
        var _this = this;
        this.event = '';
        this.startDate = null;
        this.endDate = null;
        this.startTime = null;
        this.endTime = null;
        this.newElementForm = true;
        this.display = true;
        this.timelineApi.allTimelines().subscribe(function (timelines) { return _this.timelines = timelines; }, function (error) { return console.log(error); });
    };
    DgConnTimelineComponent.prototype.displayInfo = function (rowData) {
        var _this = this;
        this.timeline = rowData;
        this.event = rowData.event;
        this.startDate = new Date(rowData.startDate);
        this.endDate = new Date(rowData.endDate);
        this.startTime = new Date(rowData.startDate);
        this.endTime = new Date(rowData.endDate);
        this.newElementForm = false;
        this.display = true;
        this.timelineApi.allTimelines().subscribe(function (timelines) { return _this.timelines = timelines; }, function (error) { return console.log(error); });
    };
    DgConnTimelineComponent.prototype.deleteElement = function (rowData) {
        var _this = this;
        this.timelineApi.deleteTimeline(this.timelines[rowData]).subscribe(function (data) {
            _this.timelineApi.allTimelines().subscribe(function (timelines) { return _this.timelines = timelines; }, function (error) { return console.log(error); });
        }, function (error) { return console.log(error); });
    };
    DgConnTimelineComponent.prototype.cancelTimeline = function () {
        this.newElementForm = false;
        this.display = false;
    };
    DgConnTimelineComponent.prototype.createTimeline = function () {
        var _this = this;
        var timeline = (this.timeline) ? this.timeline : new __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_TimelineDTO__["a" /* TimelineDTOBase */]();
        var finalStartDate = this.startDate;
        var finalEndDate = this.endDate;
        timeline.event = this.event;
        finalStartDate.setHours(this.startTime.getHours());
        finalStartDate.setMinutes(this.startTime.getMinutes());
        timeline.startDate = finalStartDate.getTime();
        finalEndDate.setHours(this.endTime.getHours());
        finalEndDate.setMinutes(this.endTime.getMinutes());
        timeline.endDate = finalEndDate.getTime();
        this.timelineApi.createTimeline(timeline).subscribe(function (data) {
            _this.timelineApi.allTimelines().subscribe(function (timelines) {
                _this.timelines = timelines;
                _this.newElementForm = false;
                _this.display = false;
            }, function (error) {
                console.log(error);
                _this.newElementForm = false;
                _this.display = false;
            });
        }, function (error) {
            console.log(error);
            _this.newElementForm = false;
            _this.display = false;
        });
        this.timeline = null;
    };
    DgConnTimelineComponent.prototype.checkDate = function () {
        if (this.startDate && this.startDate) {
            var finalStartDate = this.startDate;
            var finalEndDate = this.endDate;
            finalStartDate.setHours(this.startTime.getHours());
            finalStartDate.setMinutes(this.startTime.getMinutes());
            finalEndDate.setHours(this.endTime.getHours());
            finalEndDate.setMinutes(this.endTime.getMinutes());
            return finalStartDate < finalEndDate;
        }
        return false;
    };
    return DgConnTimelineComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('dgConnDetails'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */]) === "function" && _a || Object)
], DgConnTimelineComponent.prototype, "dgConnDetails", void 0);
DgConnTimelineComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+dgconn-portal/+timeline/timeline.component.html"), providers: [__WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_TimelineApi__["a" /* TimelineApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_TimelineApi__["a" /* TimelineApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__shared_swagger_api_TimelineApi__["a" /* TimelineApi */]) === "function" && _b || Object])
], DgConnTimelineComponent);

var _a, _b;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/timeline.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+voucher/voucher.component.html":
/***/ (function(module, exports) {

module.exports = "\n<div class=\"supplier\"></div>\n<div class=\"container\">\n    <div class=\"ui-g\">\n        <div class=\"ui-g-4  voucherLabel\"><p>{{ 'totalCountries' | translate }}: <b>{{totalCountries}}</b></p></div> \n        <div class=\"ui-g-4 voucherLabel\">\n            <div class=\"ui-g-4\">{{ 'country.label' | translate }}</div>\n            <div class=\"ui-g-8\">\n                <p-autoComplete id=\"country\" class=\"form-control autoComplete\" name=\"country\" field=\"name\" placeholder=\"Espanya\"\n                    ngcontrol=\"country\" #country=\"ngModel\" [(ngModel)]=\"nutsDTO\" [suggestions]=\"nutsSuggestions\" \n                    [size]=\"30\" [minLength]=\"1\" (completeMethod)=\"filterNuts($event)\" required>\n                </p-autoComplete>\n            </div>\n        </div>\n        <div class=\"ui-g-4\">\n            <button type=\"button\" class=\"btn btn-primary voucherButtons\" (click)=\"simulateDistribution()\">\n                {{'voucher.simulate' | translate }}\n            </button>\n        </div>\n    </div>\n    <div class=\"ui-g\">\n        <div class=\"ui-g-4 voucherLabel\"><p>{{ 'voucher.totalRequest' | translate }}: <b>{{totalRequests}}</b></p></div>\n        <div class=\"ui-g-4 voucherLabel\">\n            <div class=\"ui-g-4\">{{ 'voucher.amountVoucher' | translate }}</div>\n            <div class=\"ui-g-8\">\n                <input type=\"text\" name=\"\" class=\"paddingInput\" value=\"\">\n            </div>\n        </div>\n        <div class=\"ui-g-4\">\n            <button type=\"button\"  class=\"btn btn-primary voucherButtons\">\n                {{'voucher.cancelAssignment' | translate }}\n            </button>\n        </div>\n    </div>\n    <div id=\"map\"></div>\n    <div class=\"headerTableVoucher\">\n        <p><span class=\"voucherTitle\">{{ 'voucher.dashboard' | translate }}</span> | <span class=\"voucherSubtitle\">{{ 'voucher.simulation' | translate }}</span><a class=\"downloadData\" (click)=\"mapTable.exportCSV()\"><i class=\"fa fa-download\" aria-hidden=\"true\"></i> {{'voucher.downloadData' | translate}}</a></p>\n    </div>\n    <p-dataTable #mapTable [value]=\"mapTableData\" [rows]=\"10\" [paginator]=\"true\" [rowsPerPageOptions]=\"[5,10,20]\">\n            <p-column field=\"name\" header=\"{{ 'country.label' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column field=\"municipalities\" header=\"{{ 'voucher.municipalities' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column field=\"requests\" header=\"{{ 'voucher.requests' | translate }}\" [sortable]=\"true\"></p-column>\n            <p-column field=\"awarded\" header=\"{{ 'voucher.assigned' | translate }}\" [sortable]=\"true\"></p-column>\n    </p-dataTable>\n</div>"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/+voucher/voucher.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export countryInformation */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnVoucherComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_BeneficiaryDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/BeneficiaryDTO.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_ng2_translate_ng2_translate__ = __webpack_require__("../../../../ng2-translate/ng2-translate.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__ = __webpack_require__("../../../../@ec-digit-uxatec/eui-angular2-ux-commons/index.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_DgconnApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/DgconnApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_LauApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/LauApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_NutsApi__ = __webpack_require__("../../../../../src/app/shared/swagger/api/NutsApi.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__ = __webpack_require__("../../../../../src/app/shared/swagger/model/NutsDTO.ts");
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
var DgConnVoucherComponent = (function () {
    function DgConnVoucherComponent(http, lauApi, nutsApi, dgconnApi, uxService, translate) {
        this.http = http;
        this.lauApi = lauApi;
        this.nutsApi = nutsApi;
        this.dgconnApi = dgconnApi;
        this.uxService = uxService;
        this.translate = translate;
        this.onNext = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.mapTableData = [];
        this.totalCountries = 0;
        this.totalRequests = 0;
        this.loadMapInformation();
    }
    DgConnVoucherComponent.prototype.loadMapInformation = function () {
        var _this = this;
        this.loadMap();
        this.dgconnApi.getCountriesVoucherInfo().subscribe(function (data) {
            countryInformation = JSON.parse(data.data);
            for (var property in countryInformation) {
                _this.mapTableData.push(countryInformation[property]);
                _this.totalRequests += countryInformation[property]["requests"];
            }
            _this.totalCountries = _this.mapTableData.length;
            _this.loadMap();
            _this.totalCountries = _this.mapTableData.length;
        });
    };
    DgConnVoucherComponent.prototype.loadMap = function () {
        window.onload = function () {
            var bounds = new esri.geometry.Extent({
                "xmin": -6767978.981609231,
                "ymin": 2591986.6022099443,
                "xmax": 8559731.130780501,
                "ymax": 11154688.85635359,
                "spatialReference": { "wkid": 102100 }
            });
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
                var outputString = "Municipalities: %m <br /> Requests: %r <br /> Assigned Vouchers: %a";
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
    DgConnVoucherComponent.prototype.onKeyUp = function (event) {
        // Check if key pressed is a ascii printable letter
        if (event.keyCode > 64 && event.keyCode < 91) {
            if (typeof this.nutsDTO === "string") {
                var name = this.nutsDTO;
                var nuts = this.nutsSuggestions;
                for (var i = 0; i < nuts.length; i++) {
                    var nut = nuts[i];
                    if (nut.name.toLowerCase().indexOf(name.toLowerCase()) == 0) {
                        this.nutsDTO = nut;
                    }
                }
            }
        }
    };
    DgConnVoucherComponent.prototype.filterNuts = function (event) {
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
    DgConnVoucherComponent.prototype.filterCountries = function (query, nuts) {
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
    DgConnVoucherComponent.prototype.simulateDistribution = function () {
        var _this = this;
        this.dgconnApi.distribute().subscribe(function (response) {
            _this.uxService.growl({
                severity: 'success',
                summary: 'SUCCESS',
                detail: 'Simulation of voucher distribution successful'
            });
        }, function (error) { return console.log(error); });
    };
    return DgConnVoucherComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('beneficiaryDTO'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__shared_swagger_model_BeneficiaryDTO__["a" /* BeneficiaryDTOBase */]) === "function" && _a || Object)
], DgConnVoucherComponent.prototype, "beneficiaryDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('nutsDTO'),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__["a" /* NutsDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__["a" /* NutsDTOBase */]) === "function" && _b || Object)
], DgConnVoucherComponent.prototype, "nutsDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('lausDTO'),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__["a" /* NutsDTOBase */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_8__shared_swagger_model_NutsDTO__["a" /* NutsDTOBase */]) === "function" && _c || Object)
], DgConnVoucherComponent.prototype, "lausDTO", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
    __metadata("design:type", Object)
], DgConnVoucherComponent.prototype, "onNext", void 0);
DgConnVoucherComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        template: __webpack_require__("../../../../../src/app/+dgconn-portal/+voucher/voucher.component.html"),
        providers: [__WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_LauApi__["a" /* LauApi */], __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_NutsApi__["a" /* NutsApi */], __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_DgconnApi__["a" /* DgconnApi */]]
    }),
    __metadata("design:paramtypes", [typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["Http"]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_LauApi__["a" /* LauApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__shared_swagger_api_LauApi__["a" /* LauApi */]) === "function" && _e || Object, typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_NutsApi__["a" /* NutsApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_7__shared_swagger_api_NutsApi__["a" /* NutsApi */]) === "function" && _f || Object, typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_DgconnApi__["a" /* DgconnApi */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__shared_swagger_api_DgconnApi__["a" /* DgconnApi */]) === "function" && _g || Object, typeof (_h = typeof __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__ec_digit_uxatec_eui_angular2_ux_commons__["e" /* UxService */]) === "function" && _h || Object, typeof (_j = typeof __WEBPACK_IMPORTED_MODULE_3_ng2_translate_ng2_translate__["c" /* TranslateService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3_ng2_translate_ng2_translate__["c" /* TranslateService */]) === "function" && _j || Object])
], DgConnVoucherComponent);

var _a, _b, _c, _d, _e, _f, _g, _h, _j;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/voucher.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/dgconnportal-details.model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnDetails; });
var DgConnDetails = (function () {
    function DgConnDetails() {
    }
    return DgConnDetails;
}());

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/dgconnportal-details.model.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/dgconnportal-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnectPortalRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__dgconnportal_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__timeline_timeline_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+timeline/timeline.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__publication_publication_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+publication/publication.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__voucher_voucher_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+voucher/voucher.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var DgConnectPortalRoutingModule = (function () {
    function DgConnectPortalRoutingModule() {
    }
    return DgConnectPortalRoutingModule;
}());
DgConnectPortalRoutingModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"].forChild([
                {
                    path: '',
                    component: __WEBPACK_IMPORTED_MODULE_2__dgconnportal_component__["a" /* DgConnPortalComponent */],
                }, {
                    path: 'timeline',
                    component: __WEBPACK_IMPORTED_MODULE_3__timeline_timeline_component__["a" /* DgConnTimelineComponent */]
                }, {
                    path: 'publication',
                    component: __WEBPACK_IMPORTED_MODULE_4__publication_publication_component__["a" /* DgConnPublicationComponent */]
                }, {
                    path: 'voucher',
                    component: __WEBPACK_IMPORTED_MODULE_5__voucher_voucher_component__["a" /* DgConnVoucherComponent */]
                }, {
                    path: 'statistics',
                    loadChildren: 'app/+dgconn-portal/+statistics/statistics.module#DgConnPortalStatisticsModule',
                }
            ])],
        exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["RouterModule"]]
    })
], DgConnectPortalRoutingModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/dgconnportal-routing.module.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/dgconnportal.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"clearfix\"></div>\n<div class=\"jumbotron mb-3\" style=\"background-color: transparent;\">\n    <div class=\"container center\">\n        <p class=\"center beneficiaryTitle\">{{ 'dgconnect.title' | translate }}</p>\n    </div>\n</div>\n<div class=\"container center\">\n    <div class=\"row\">\n        <div class=\"col-md-2\"></div>\n        <div class=\"col-md-2\">\n            <a href=\"#/dgconn-portal/timeline\">\n                <div class=\"center dashboardItem\">\n                    <img src=\"assets/images/timeline.png\" alt=\"\">\n                    <p class=\"fontDashboard\">{{ 'timeline.dashboard' | translate }}</p>\n                </div>\n            </a>\n        </div>\n        <div class=\"col-md-1\"></div>\n        <div class=\"col-md-2\">\n            <a href=\"#/dgconn-portal/publication\">\n                <div class=\"center dashboardItem\">\n                    <img src=\"assets/images/icono-2.png\" alt=\"\">\n                    <p class=\"fontDashboard\">{{ 'publication.dashboard' | translate }}</p>\n                </div>\n            </a>\n        </div>\n        <div class=\"col-md-1\"></div>\n        <div class=\"col-md-2\">\n            <a href=\"#/dgconn-portal/voucher\">\n                <div class=\"center dashboardItem\">\n                    <img src=\"assets/images/icono-3.png\" alt=\"\">\n                    <p class=\"fontDashboard\">{{ 'voucher.dashboard' | translate }}</p>\n                </div>\n            </a>\n        </div>\n        <div class=\"col-md-2\"></div>\n    </div>\n    <div class=\"row rowMarginBottom\">\n        <div class=\"col-md-2\"></div>\n        <div class=\"col-md-2 md4Dashboard\">\n            <a href=\"#/dgconn-portal/\">\n                <div class=\"center dashboardItem\">\n                    <img src=\"assets/images/icono-4.png\" alt=\"\">\n                    <p class=\"fontDashboard\">{{ 'reporting.dashboard' | translate }}</p>\n                </div>\n            </a>\n        </div>\n        <div class=\"col-md-1\"></div>\n        <div class=\"col-md-2 md4Dashboard\">\n            <a href=\"#/dgconn-portal/statistics\">\n                <div class=\"center dashboardItem\">\n                    <img src=\"assets/images/icono-5.png\" alt=\"\">\n                    <p class=\"fontDashboard\">{{ 'statistics.dashboard' | translate }}</p>\n                </div>\n            </a>\n        </div>\n        <div class=\"col-md-1\"></div>\n        <div class=\"col-md-2 md4Dashboard\">\n            <a href=\"#/helpdesk\">\n                <div class=\"center dashboardItem\">\n                    <img src=\"assets/images/icono-6.png\" alt=\"\">\n                    <p class=\"fontDashboard\">{{ 'helpdesk.dashboard' | translate }}</p>\n                </div>\n            </a>\n        </div>\n        <div class=\"col-md-2\"></div>\n    </div>\n\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/dgconnportal.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DgConnPortalComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__ = __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal-details.model.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var DgConnPortalComponent = (function () {
    function DgConnPortalComponent() {
        this.dgConnDetails = new __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */]();
    }
    return DgConnPortalComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])('dgConnDetails'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__dgconnportal_details_model__["a" /* DgConnDetails */]) === "function" && _a || Object)
], DgConnPortalComponent.prototype, "dgConnDetails", void 0);
DgConnPortalComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({ template: __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal.component.html") }),
    __metadata("design:paramtypes", [])
], DgConnPortalComponent);

var _a;
//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/dgconnportal.component.js.map

/***/ }),

/***/ "../../../../../src/app/+dgconn-portal/dgconnportal.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DgConnPortalModule", function() { return DgConnPortalModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__ = __webpack_require__("../../../../../src/app/shared/shared.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__dgconnportal_routing_module__ = __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__dgconnportal_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/dgconnportal.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__timeline_timeline_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+timeline/timeline.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__voucher_voucher_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+voucher/voucher.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__publication_publication_component__ = __webpack_require__("../../../../../src/app/+dgconn-portal/+publication/publication.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var DgConnPortalModule = (function () {
    function DgConnPortalModule() {
    }
    return DgConnPortalModule;
}());
DgConnPortalModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__shared_shared_module__["a" /* SharedModule */], __WEBPACK_IMPORTED_MODULE_2__dgconnportal_routing_module__["a" /* DgConnectPortalRoutingModule */]
        ],
        declarations: [
            __WEBPACK_IMPORTED_MODULE_3__dgconnportal_component__["a" /* DgConnPortalComponent */], __WEBPACK_IMPORTED_MODULE_4__timeline_timeline_component__["a" /* DgConnTimelineComponent */], __WEBPACK_IMPORTED_MODULE_6__publication_publication_component__["a" /* DgConnPublicationComponent */], __WEBPACK_IMPORTED_MODULE_5__voucher_voucher_component__["a" /* DgConnVoucherComponent */]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_3__dgconnportal_component__["a" /* DgConnPortalComponent */]]
    })
], DgConnPortalModule);

//# sourceMappingURL=/Users/rgarcita/Proyectos/wifi4EU/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/dgconnportal.module.js.map

/***/ })

});
//# sourceMappingURL=dgconnportal.module.chunk.js.map