export class TimelineElement {
    private date: string;
    private label: string;
    private subLabel: string;
    private styleClass: string;

    constructor(date?: string, label?: string, subLabel?: string, styleClass?: string) {
        this.date = date;
        this.label = label;
        this.subLabel = subLabel;
        this.styleClass = styleClass;
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
}