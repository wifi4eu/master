import { Component, Input, ViewChild, OnChanges, SimpleChange, SimpleChanges, Output, EventEmitter, OnInit, DoCheck } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { InstallationsiteApi } from '../../../../shared/swagger/api/InstallationsiteApi';
import { InstallationSiteBase } from '../../../../shared/swagger/model/InstallationSite';
import { ResponseDTOBase } from '../../../../shared/swagger';
import { ErrorHandlingService } from '../../../../core/services/error.service';

@Component({
  selector: 'update-installation-site',
  templateUrl: './update-installation-site.component.html'
})
export class UpdateInstallationSite implements OnChanges, DoCheck {
  @Input('installationSite') installationSite: InstallationSiteBase = null;
  @Input('isEdit') isEdit: boolean = false;
  @Output() onSubmitted: EventEmitter<boolean> = new EventEmitter<boolean>();
  @ViewChild('installationSiteForm') form: NgForm;
  regexUrlPortal: string = '^[^- ]([a-z0-9-:/.]+\\.)[a-z0-9-:/]*[^-]$';
  private modalTitle: string;
  private updateButtonTitle: string;
  private isSubmitted: boolean = false;
  private modifiedInstallationSite: InstallationSiteBase = new InstallationSiteBase();

  private repeatCaptivePortalInput: String;

  constructor(private uxService: UxService, private translateService: TranslateService,
    private installationSiteApi: InstallationsiteApi, private errorHandlingService: ErrorHandlingService) {
  }

  ngDoCheck() {
    if (this.installationSite.municipality != this.modifiedInstallationSite.municipality) {
      Object.assign(this.modifiedInstallationSite, this.installationSite);
    }
  }

  ngOnChanges(changes: SimpleChanges) {
    let modalJsonString: string;
    let buttonJsonString: string;
    this.isSubmitted = false;
    if (!this.isEdit) {
      modalJsonString = 'installationReport.addSite';
      buttonJsonString = 'shared.add';
    } else {
      modalJsonString = 'updateInstallationReport.editTitle';
      buttonJsonString = 'shared.edit';
    }

    this.translateService.get(modalJsonString).subscribe(
      (translation: string) => {
        this.modalTitle = translation;
      }
    );

    this.translateService.get(buttonJsonString).subscribe(
      (translation: string) => {
        this.updateButtonTitle = translation;
      }
    );
  }

  closeUpdateInstallationSite() {
    this.uxService.closeModal('updateInstallationSite');
    this.repeatCaptivePortalInput = '';
    if (!this.isSubmitted && this.isEdit) {
      Object.assign(this.modifiedInstallationSite, this.installationSite);
    } else if (!this.isEdit) {
      this.form.form.reset();
    }
  }

  onSubmit(form) {
    if (form.form.valid) {
      this.installationSiteApi.updateInstallationSite(this.modifiedInstallationSite).subscribe((response: ResponseDTOBase) => {
        if (response.success) {
          this.onSubmitted.emit(true);
          Object.assign(this.installationSite, this.modifiedInstallationSite);
        } else {
          return this.errorHandlingService.handleError(response.error);
        }
      }, error => {
        console.log(error);
        return this.errorHandlingService.handleError(error);
      });
      this.isSubmitted = true;
      this.closeUpdateInstallationSite();
    }

  }

}