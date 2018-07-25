export class Call {
    private callId: number;
    private startDate: Date;
    private endDate: Date;
    private startTime: string;
    private endTime: string;
    private event: string;

    constructor(callId?: number, startDate?: Date, endDate?: Date, startTime?: string, endTime?: string, event?: string) {
        this.callId = callId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.event = event;
    }

    public getCallId() {
        return this.callId;
    }

    public setCallId(value: number) {
        this.callId = value;
    }

    public getStartDate() {
        return this.startDate;
    }

    public setStartDate(value: Date) {
        this.startDate = value;
    }

    public getEndDate() {
        return this.endDate;
    }

    public setEndDate(value: Date) {
        this.endDate = value;
    }

    public getStartTime() {
        return this.startTime;
    }

    public setStartTime(value: string) {
        this.startTime = value;
    }

    public getEndTime() {
        return this.endTime;
    }

    public setEndTime(value: string) {
        this.endTime = value;
    }

    public getEvent() {
        return this.event;
    }

    public setEvent(value: string) {
        this.event = value;
    }
}