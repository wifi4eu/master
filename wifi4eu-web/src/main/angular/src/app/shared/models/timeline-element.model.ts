export class TimelineElement {
    private date: string;
    private label: string;
    private subLabel: string;
    private styleClass: string;
    private event: string;
    private startTime: string;
    private startDate: string;
    private endDate: string;
    private endTime: string;
    private edit: string;


    constructor(date?: string, label?: string, subLabel?: string, styleClass?: string, event?: string, startTime?: string, startDate?: string, endDate?: string, endTime?: string, edit?: string) {
        this.date = date;
        this.label = label;
        this.subLabel = subLabel;
        this.styleClass = styleClass;
        this.event = event;
        this.startTime = startTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.endTime = endTime;
        this.edit = edit;
    }

    createTimelineForDgconn(event: string, startTime: string, startDate: string, endDate: string, endTime: string, edit: string) {
        this.event = event;
        this.startTime = startTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.endTime = endTime;
        this.edit = edit;
    }

    getDate(): string {
        return this.date;
    }

    setDate(value: string) {
        this.date = value;
    }

    getLabel(): string {
        return this.label;
    }

    setLabel(value: string) {
        this.label = value;
    }

    getSubLabel(): string {
        return this.subLabel;
    }

    setSubLabel(value: string) {
        this.subLabel = value;
    }

    getStyleClass(): string {
        return this.styleClass;
    }

    setStyleClass(value: string) {
        this.styleClass = value;
    }

    getEvent(): string {
        return this.event;
    }

    setEvent(value: string) {
        this.event = value;
    }

    getStartTime(): string {
        return this.startTime;
    }

    setStartTime(value: string) {
        this.startTime = value;
    }

    getStartDate(): string {
        return this.startDate;
    }

    setStartDate(value: string) {
        this.startDate = value;
    }

    getEndDate(): string {
        return this.endDate;
    }

    setEndDate(value: string) {
        this.endDate = value;
    }

    getEndTime(): string {
        return this.endTime;
    }

    setEndTime(value: string) {
        this.endTime = value;
    }

    getEdit(): string {
        return this.edit;
    }

    setEdit(value: string) {
        this.edit = value;
    }
}