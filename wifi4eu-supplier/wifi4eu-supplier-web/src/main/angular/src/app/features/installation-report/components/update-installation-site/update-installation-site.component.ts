import { Component, Input, ViewChild, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'update-installation-site',
  templateUrl: './update-installation-site.component.html'
})
export class UpdateInstallationSite implements OnChanges {
  @Input('installationSite') installationSite: string = null;
  @ViewChild('installationSiteForm') form: NgForm;
  regexUrlPortal: string = '[a-z0-9-:/.]*';
  private modalTitle: string;
  private isEdit: boolean = false;


  private numberInput= 1;
  private nameSiteInput: String;
  private captivePortalInput: String;
  private repeatCaptivePortalInput: String;

  constructor(private uxService: UxService, private translateService: TranslateService) {
  }

  ngOnChanges(changes: SimpleChanges) {
    let modalJsonString: string;

    if (this.installationSite === null) {
      this.isEdit = false;
      modalJsonString = 'installationReport.addSite';
    } else {
      this.isEdit = true;
      modalJsonString = 'updateInstallationReport.editTitle';
    }

    this.translateService.get(modalJsonString).subscribe(
      (translation: string) => {
        this.modalTitle = translation;
      }
    );
  }

  closeUpdateInstallationSite() {
    this.uxService.closeModal('updateInstallationSite');
    this.form.resetForm();
  }

  onSubmit(form) {
    if (form.form.valid) {
      //prove that all input is okay and send request to the server.

      if(!this.isEdit){
        console.log('submit adding modal (new InstallationSite)');
      } else{
        console.log('submit edit modal (update InstallationSite)');
      }
    }
    this.closeUpdateInstallationSite();
  }

}