import { Component, Input, ViewChild, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { AccessPoint } from '../../../../core/models/access-point.model';

@Component({
  selector: 'update-access-point',
  templateUrl: './update-access-point.component.html'
})
export class UpdateAccessPoint implements OnChanges {
  @Input('accessPoint') accessPoint: AccessPoint = new AccessPoint(0, '', '', '', '', '', '', '', '', '');
  @Input('isEdit') isEdit: boolean = false;
  @ViewChild('accessPointForm') form: NgForm;
  private modalTitle: string;

  private locationTypes =  [	{label:'Town Hall / Administrative building', value :'Town Hall / Administrative building'},
  {label:'Health Centre / Hospital', value :'Health Centre / Hospital'},
  {label:'Square', value :'Square'},
  {label:'Park', value :'Park'},
  {label:'Street / Pedestrian street', value :'Street / Pedestrian street'},
  {label:'Tramway or Bus Station / Stop', value :'Tramway or Bus Station / Stop'},
  {label:'Metro Station', value :'Metro Station'},
  {label:'Railway Station', value :'Railway Station'},
  {label:'Airport', value :'Airport'},
  {label:'Sport Hall / Stadium', value :'Sport Hall / Stadium'},
  {label:'School / Education or Research Centre / University', value :'School / Education or Research Centre / University'},
  {label:'Library', value :'Library'},
  {label:'Museum / Cultural Centre', value :'Museum / Cultural Centre'},
  {label:'Site of touristic interest / Archeological Site', value :'Site of touristic interest / Archeological Site'},
  {label:'Shopping Mall', value :'Shopping Mall'},
  {label:'Other', value :'Other'}]

  private deviceTypes = [{label:'indoor', value: '1'}, {label:'outdoor', value: '0'}]

  private regexLocation : string = '^([-+]?)([0-9]{1,2})(((.)([0-9]{6})))$';
  private regexMacAddress : string = '^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$';

  constructor(private uxService: UxService, private translateService: TranslateService) {
  }

  ngOnChanges(changes: SimpleChanges) {
    let modalJsonString: string;

    if (!this.isEdit) {
      modalJsonString = 'accessPoint.add';
      this.accessPoint = new AccessPoint(0, '', '', '', '', '', '', '', '', '');
    } else {
      modalJsonString = 'updateAccessPoint.editTitle';
    }

    this.translateService.get(modalJsonString).subscribe(
      (translation: string) => {
        this.modalTitle = translation;
      }
    );
  }

  closeUpdateAccessPoint() {
    this.uxService.closeModal('updateAccessPoint');
    this.form.resetForm();
  }

  onSubmit(form) {
    if (form.form.valid) {
      //prove that all input is okay and send request to the server.

      if (!this.isEdit) {
        alert('submit adding modal (new updateAccessPoint)');
      } else {
        alert('submit edit modal (update updateAccessPoint)');
      }
    }
    this.closeUpdateAccessPoint();
  }

}