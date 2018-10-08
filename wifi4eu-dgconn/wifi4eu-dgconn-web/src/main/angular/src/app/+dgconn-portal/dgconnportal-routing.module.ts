import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DgConnPortalComponent } from './dgconnportal.component';
import { DgConnPublicationComponent } from './+publication/publication.component';
import { DgConnVoucherComponent } from 'app/+dgconn-portal/+voucher/voucher.component';
import { DgConnSupplierRegistrationsComponent } from './+supplier-registrations/supplier-registrations.component';
import { DgConnBeneficiaryRegistrationsComponent } from './+beneficiary-registrations/beneficiary-registrations.component';
import { DgConnApplicantRegistrationsComponent } from './+applicant-registrations/applicant-registrations.component';
import { DgConnDiscussionComponent } from './+discussion/discussion.component';
import { DgConnSupplierRegistrationsDetailsComponent } from './+supplier-registrations/details/supplier-registrations-details.component';
import { DgConnApplicantRegistrationsDetailsComponent } from './+applicant-registrations/+details/applicant-registrations-details.component';
import { ReportingComponent } from './reporting/reporting.component';
import { BeneficiaryListComponent } from './+beneficiary-list/beneficiary-list.component';

@NgModule({
    imports: [RouterModule.forChild([
        {
            path: '',
            component: DgConnPortalComponent,
        },
        {
            path: 'publication',
            component: DgConnPublicationComponent,
        },
        {
            path: 'voucher',
            component: DgConnVoucherComponent,
        },
        {
            path: 'beneficiaries',
            component: BeneficiaryListComponent
        },
        {
            path: 'supplier-registrations',
            component: DgConnSupplierRegistrationsComponent,
        },
        {
            path: 'supplier-registrations/:id',
            component: DgConnSupplierRegistrationsDetailsComponent
        },
        {
            path: 'beneficiary-registrations',
            component: DgConnBeneficiaryRegistrationsComponent,
        },
        {
            path: 'applicant-registrations',
            component: DgConnApplicantRegistrationsComponent,
        },
        {
            path: 'applicant-registrations/:lauId/call/:callId',
            component: DgConnApplicantRegistrationsDetailsComponent,
        },
        {
            path: 'discussion',
            component: DgConnDiscussionComponent,
        },
        {
            path: 'exportImport',
            loadChildren: 'app/+dgconn-portal/+exportImport/exportImport.module#ExportImportModule',
        },
        {
            path: 'reporting',
            component: ReportingComponent
        }
    ])],
    exports: [RouterModule]
})
export class DgConnectPortalRoutingModule {
}