import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { DomSanitizer } from "@angular/platform-browser";
import { SharedService } from "../../../shared/shared.service";
import { SupplierApi } from "../../../shared/swagger/api/SupplierApi";
import { SupplierDTOBase } from "../../../shared/swagger/model/SupplierDTO";
import { ResponseDTOBase } from "../../../shared/swagger/model/ResponseDTO";

@Component({
    templateUrl: 'supplier-registrations-details.component.html', providers: [SupplierApi]
})

export class DgConnSupplierRegistrationsDetailsComponent {
    private supplier: SupplierDTOBase = null;
    private similarSuppliers: SupplierDTOBase[] = [];

    constructor(private route: ActivatedRoute, private sanitizer: DomSanitizer, private sharedService: SharedService, private supplierApi: SupplierApi) {
        this.route.params.subscribe(
            params => {
                let supplierId = params['id'];
                this.supplierApi.getSupplierById(supplierId).subscribe(
                    (supplier: SupplierDTOBase) => {
                        if (supplier != null) {
                            this.supplierApi.findSimilarSuppliers(supplierId).subscribe(
                                (suppliers: SupplierDTOBase[]) => {
                                    if (suppliers.length != 0) {
                                        this.similarSuppliers = suppliers;
                                    }
                                    this.supplier = supplier;
                                }
                            );
                        }
                    }
                );
            }
        );
    }

    private getLegalFileUrl(mainSupplier: boolean, fileNumber: number, index?: number) {
        if (mainSupplier) {
            switch (fileNumber) {
                case 1:
                    return this.sanitizer.bypassSecurityTrustUrl(this.supplier.legalFile1);
                case 2:
                    return this.sanitizer.bypassSecurityTrustUrl(this.supplier.legalFile2);
            }
        } else {
            switch (fileNumber) {
                case 1:
                    return this.sanitizer.bypassSecurityTrustUrl(this.similarSuppliers[index].legalFile1);
                case 2:
                    return this.sanitizer.bypassSecurityTrustUrl(this.similarSuppliers[index].legalFile2);
            }
        }
    }

    private requestLegalDocuments(mainSupplier: boolean, index?: number) {
        if (mainSupplier) {
            this.supplierApi.requestLegalDocuments(this.supplier.id).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.sharedService.growlTranslation('An email has been sent to the contact person to supply the legal documents for the registration.', 'dgConn.supplierDetails.requestLegalDocuments.success', 'success');
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to request the legal documents of the supplier. Please, try again later.', 'dgConn.supplierDetails.requestLegalDocuments.error', 'error');
                    }
                }
            );
        } else {
            if (index != null) {
                this.supplierApi.requestLegalDocuments(this.similarSuppliers[index].id).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            this.sharedService.growlTranslation('An email has been sent to the contact person to supply the legal documents for the registration.', 'dgConn.supplierDetails.requestLegalDocuments.success', 'success');
                        } else {
                            this.sharedService.growlTranslation('An error occurred while trying to request the legal documents of the supplier. Please, try again later.', 'dgConn.supplierDetails.requestLegalDocuments.error', 'error');
                        }
                    }
                );
            }
        }
    }

    private invalidateSupplier(mainSupplier: boolean, index?: number) {
        if (mainSupplier) {
            let modifiedSupplier = this.supplier;
            modifiedSupplier.status = 0;
            this.supplierApi.invalidateSupplier(modifiedSupplier).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        if (response.data != null) {
                            this.supplier = response.data;
                            this.sharedService.growlTranslation('You successfully invalidated the supplier.','dgConn.supplierDetails.invalidateSupplier.success', 'success');
                        }
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to invalidate the supplier. Please, try again later.','dgConn.supplierDetails.invalidateSupplier.error', 'error');
                    }
                }
            );
        } else {
            if (index != null) {
                let modifiedSupplier = this.similarSuppliers[index];
                modifiedSupplier.status = 0;
                this.supplierApi.invalidateSupplier(modifiedSupplier).subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            if (response.data != null) {
                                this.similarSuppliers[index] = response.data;
                                this.sharedService.growlTranslation('You successfully invalidated the supplier.','dgConn.supplierDetails.invalidateSupplier.success', 'success');
                            }
                        } else {
                            this.sharedService.growlTranslation('An error occurred while trying to invalidate the supplier. Please, try again later.','dgConn.supplierDetails.invalidateSupplier.error', 'error');
                        }
                    }
                );
            }
        }
    }
}