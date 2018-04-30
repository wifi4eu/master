import { Component, Input, ViewChild, OnChanges, SimpleChange, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { InstallationsiteApi } from '../../../../shared/swagger/api/InstallationsiteApi';
import { InstallationSiteBase } from '../../../../shared/swagger/model/InstallationSite';
import { ResponseDTOBase } from '../../../../shared/swagger';

@Component({
  selector: 'update-installation-site',
  templateUrl: './update-installation-site.component.html'
})
export class UpdateInstallationSite implements OnChanges {
  @Input('installationSite') installationSite: InstallationSiteBase = null;
  @Input('isEdit') isEdit: boolean = false;
  @Output() onSubmitted: EventEmitter<boolean> = new EventEmitter<boolean>();
  @ViewChild('installationSiteForm') form: NgForm;
  regexUrlPortal: string = '[a-z0-9-:/.]*';
  private modalTitle: string;
  private isSubmitted: boolean = false;
  private unmodifiedInstallationSite: InstallationSiteBase = new InstallationSiteBase();

  private repeatCaptivePortalInput: String;

  constructor(private uxService: UxService, private translateService: TranslateService,
    private installationSiteApi: InstallationsiteApi) {
  }

  ngOnChanges(changes: SimpleChanges) {
    let modalJsonString: string;

    if (!this.isEdit) {
      modalJsonString = 'installationReport.addSite';
    } else {
      modalJsonString = 'updateInstallationReport.editTitle';
      Object.assign(this.unmodifiedInstallationSite, this.installationSite);
    }

    this.translateService.get(modalJsonString).subscribe(
      (translation: string) => {
        this.modalTitle = translation;
      }
    );
  }

  closeUpdateInstallationSite() {
    this.uxService.closeModal('updateInstallationSite');
    this.repeatCaptivePortalInput = '';
    if (!this.isSubmitted && this.isEdit) {
      Object.assign(this.installationSite, this.unmodifiedInstallationSite);
    } else if (!this.isEdit) {
      this.form.form.reset();
    }
  }

  onSubmit(form) {
    console.log(this.installationSite);
    if (form.form.valid) {
      this.installationSiteApi.updateInstallationSite(this.installationSite).subscribe((response: ResponseDTOBase) => {
        if (response.success) {
          this.onSubmitted.emit(true);
        }
      });
      this.isSubmitted = true;
      this.closeUpdateInstallationSite();
    }

  }

}