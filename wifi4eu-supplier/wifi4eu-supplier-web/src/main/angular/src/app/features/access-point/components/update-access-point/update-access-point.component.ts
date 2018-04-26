import { Component, Input, ViewChild, OnChanges, SimpleChange, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { AccessPointBase } from '../../../../shared/swagger/model/AccessPoint';
import { AccesspointsApi } from '../../../../shared/swagger/api/AccesspointsApi';
import { ResponseDTOBase } from '../../../../shared/swagger';

@Component({
  selector: 'update-access-point',
  templateUrl: './update-access-point.component.html'
})
export class UpdateAccessPoint implements OnChanges {
  @Input('accessPoint') accessPoint: AccessPointBase = new AccessPointBase();
  @Input('isEdit') isEdit: boolean = false;
  @ViewChild('accessPointForm') form: NgForm;

  @Output() onSubmitted: EventEmitter<boolean> = new EventEmitter<boolean>();

  private unmodifiedAccessPoint: AccessPointBase = new AccessPointBase();
  private modalTitle: string;

  //TODO
  private locationTypes = [{ label: 'Town Hall / Administrative building', value: 'Town Hall / Administrative building' },
  { label: 'Health Centre / Hospital', value: 'Health Centre / Hospital' },
  { label: 'Square', value: 'Square' },
  { label: 'Park', value: 'Park' },
  { label: 'Street / Pedestrian street', value: 'Street / Pedestrian street' },
  { label: 'Tramway or Bus Station / Stop', value: 'Tramway or Bus Station / Stop' },
  { label: 'Metro Station', value: 'Metro Station' },
  { label: 'Railway Station', value: 'Railway Station' },
  { label: 'Airport', value: 'Airport' },
  { label: 'Sport Hall / Stadium', value: 'Sport Hall / Stadium' },
  { label: 'School / Education or Research Centre / University', value: 'School / Education or Research Centre / University' },
  { label: 'Library', value: 'Library' },
  { label: 'Museum / Cultural Centre', value: 'Museum / Cultural Centre' },
  { label: 'Site of touristic interest / Archeological Site', value: 'Site of touristic interest / Archeological Site' },
  { label: 'Shopping Mall', value: 'Shopping Mall' },
  { label: 'Other', value: 'Other' }]

  private deviceTypes = [{ label: 'indoor', value: true }, { label: 'outdoor', value: false }]

  private regexLocation: string = '^([-+]?)([0-9]{1,2})(((.)([0-9]{6})))$';
  private regexMacAddress: string = '^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$';
  private isSubmitted: boolean = false;

  constructor(private uxService: UxService, private translateService: TranslateService,
    private accessPointApi: AccesspointsApi) {
  }

  ngOnChanges(changes: SimpleChanges) {
    let modalJsonString: string;

    if (!this.isEdit) {
      modalJsonString = 'accessPoint.add';
    } else {
      modalJsonString = 'updateAccessPoint.editTitle';
      Object.assign(this.unmodifiedAccessPoint, this.accessPoint);
    }

    this.translateService.get(modalJsonString).subscribe(
      (translation: string) => {
        this.modalTitle = translation;
      }
    );
  }

  closeUpdateAccessPoint() {
    this.uxService.closeModal('updateAccessPoint');
    if (!this.isSubmitted && this.isEdit) {
      Object.assign(this.accessPoint, this.unmodifiedAccessPoint);
    } else if (!this.isEdit) {
      this.form.form.reset();
    }
  }

  onSubmit(form) {
    if (form.form.valid) {
      this.accessPointApi.editBeneficiaryDisplayedListDTO(this.accessPoint).subscribe((response: ResponseDTOBase) => {
        if (response.success) {
          this.onSubmitted.emit(true);
        }
      });
    }

    this.isSubmitted = true;
    this.closeUpdateAccessPoint();
  }

}