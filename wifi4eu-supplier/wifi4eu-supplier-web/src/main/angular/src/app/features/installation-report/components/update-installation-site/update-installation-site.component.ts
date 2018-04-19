import { Component, Input, ViewChild } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';

@Component({
  selector: 'update-installation-site',
  templateUrl: './update-installation-site.component.html'
})
export class UpdateInstallationSite {
  @Input('installationSite') installationSite: string;
  @ViewChild('installationSiteForm') form : NgForm;
  regexUrlPortal: string  = '[a-z0-9-:/.]*';

  private nameSiteInput: String;
  private captivePortalInput: String;
  private repeatCaptivePortalInput: String;

  constructor(private uxService: UxService) {
  }

  closeUpdateInstallationSite() {
    console.log(this.form);
    this.uxService.closeModal('updateInstallationSite');
    this.form.resetForm();
  }

  onSubmit(form){
    if(form.form.valid){
      //prove that all input is okay and send request to the server.
    }
    this.closeUpdateInstallationSite();
  }

}