export class AccessPoint {
    number: number;
    locationType: string ;
    locationName: string ;
    latitude: string;
    longitude: string ;
    deviceType: string;
    deviceBrand: string;
    deviceModel: string;
    deviceSerialNumber: string;
    macAddress: string;
    

    constructor(number, locationType, locationName, latitude, longitude,
        deviceType, deviceBrand, deviceModel, deviceSerialNumber, macAddress) {
        this.number = number;
        this.locationType = locationType;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.deviceType = deviceType;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceSerialNumber = deviceSerialNumber;
        this.macAddress = macAddress;

    }

}
