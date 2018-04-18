import { Component, Input } from '@angular/core';

@Component({
    selector: 'update-installation-site',
    templateUrl: './update-installation-site.component.html'
  })
  export class UpdateInstallationSite {
    @Input('installationSite') installationSite: string;
  }