import { Component, Input } from "@angular/core";
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import { UserApi } from "../../swagger/api/UserApi";
import { ResponseDTOBase } from "../../swagger/model/ResponseDTO";
import { TranslateService } from "ng2-translate";

@Component({
  selector: "success-component",
  templateUrl: "success.component.html"
})
export class SuccessComponent {
  @Input() status: string = "shared.submitregistration.success.title";
}
