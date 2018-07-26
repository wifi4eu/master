import { Component, Input, ViewChild, OnChanges, SimpleChange, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { PatternValidator, NgForm } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { AccessPointBase } from '../../../../shared/swagger/model/AccessPoint';
import { AccesspointsApi } from '../../../../shared/swagger/api/AccesspointsApi';
import { ResponseDTOBase } from '../../../../shared/swagger';
import { ErrorHandlingService } from '../../../../core/services/error.service';

@Component({
  selector: 'update-access-point',
  templateUrl: './update-access-point.component.html'
})
export class UpdateAccessPoint implements OnChanges {
  @Input('accessPoint') accessPoint: AccessPointBase = new AccessPointBase();
  @Input('isEdit') isEdit: boolean = false;
  @ViewChild('accessPointForm') form: NgForm;

  @Output() onSubmitted: EventEmitter<boolean> = new EventEmitter<boolean>();

  private modifiedAccessPoint: AccessPointBase = new AccessPointBase();
  private modalTitle: string;
  private updateButtonTitle: string;

  //TODO
  private locationTypes = [{ label: 'updateAccessPoint.locationTypes.town', value: 'Town Hall / Administrative building' },
  { label: 'updateAccessPoint.locationTypes.health', value: 'Health Centre / Hospital' },
  { label: 'updateAccessPoint.locationTypes.square', value: 'Square' },
  { label: 'updateAccessPoint.locationTypes.park', value: 'Park' },
  { label: 'updateAccessPoint.locationTypes.street', value: 'Street / Pedestrian street' },
  { label: 'updateAccessPoint.locationTypes.tramBusStation', value: 'Tramway or Bus Station / Stop' },
  { label: 'updateAccessPoint.locationTypes.metroStation', value: 'Metro Station' },
  { label: 'updateAccessPoint.locationTypes.railwayStation', value: 'Railway Station' },
  { label: 'updateAccessPoint.locationTypes.airport', value: 'Airport' },
  { label: 'updateAccessPoint.locationTypes.stadium', value: 'Sport Hall / Stadium' },
  { label: 'updateAccessPoint.locationTypes.school', value: 'School / Education or Research Centre / University' },
  { label: 'updateAccessPoint.locationTypes.library', value: 'Library' },
  { label: 'updateAccessPoint.locationTypes.museum', value: 'Museum / Cultural Centre' },
  { label: 'updateAccessPoint.locationTypes.tourism', value: 'Site of touristic interest / Archeological Site' },
  { label: 'updateAccessPoint.locationTypes.shopping', value: 'Shopping Mall' },
  { label: 'updateAccessPoint.locationTypes.other', value: 'Other' }]

  private deviceTypes = [{ label: 'accessPoint.indoor', value: true }, { label: 'accessPoint.outdoor', value: false }]

  private regexLocation: string = '^([-+]?)([0-9]{1,2})\\.([0-9]{5,6})$';
  private regexMacAddress: string = '^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$';
  private isSubmitted: boolean = false;

  constructor(private uxService: UxService, private translateService: TranslateService,
    private accessPointApi: AccesspointsApi, private errorHandlingService: ErrorHandlingService) {
      this.translateLabelsFromSelects();
  }

  ngOnChanges(changes: SimpleChanges) {
    let modalJsonString: string;
    let buttonJsonString: string;

    Object.assign(this.modifiedAccessPoint, this.accessPoint);

    if (!this.isEdit) {
      modalJsonString = 'accessPoint.add';
      buttonJsonString = 'shared.add';
    } else {
      modalJsonString = 'updateAccessPoint.editTitle';
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

  closeUpdateAccessPoint() {
    this.uxService.closeModal('updateAccessPoint');
    if (!this.isSubmitted && this.isEdit) {
      Object.assign(this.modifiedAccessPoint, this.accessPoint);
    } else if (!this.isEdit) {
      this.form.form.reset();
    }
  }

  onSubmit(form) {
    if (form.form.valid) {
      this.accessPointApi.addOrUpdateAccessPoint(this.modifiedAccessPoint).subscribe((response: ResponseDTOBase) => {
        if (response.success) {
          this.onSubmitted.emit(true);
          Object.assign(this.accessPoint, this.modifiedAccessPoint);
        } else {
          return this.errorHandlingService.handleError(response.error);
        }
      }, error => {
        console.log(error);
        return this.errorHandlingService.handleError(error);
      });
    }

    this.isSubmitted = true;
    this.closeUpdateAccessPoint();
  }

  translateLabelsFromSelects(){
    for (let i = 0; i < this.locationTypes.length; i++) {
      let label = this.locationTypes[i].label;
      this.translateService.get(label).subscribe(
        (translation: string) => {
            this.locationTypes[i].label= translation;
        });
    }
    
    for (let i = 0; i < this.deviceTypes.length; i++) {
      let label = this.deviceTypes[i].label;
      this.translateService.get(label).subscribe(
        (translation: string) => {
            this.deviceTypes[i].label= translation;
        });
    }


  }

}