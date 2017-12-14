export class CustomLayoutLink {
    id: string;
    label: string;
    subLabel: string;
    url: string;
    externalUrl: boolean = false;
    disabled: boolean = false;
    children: CustomLayoutLink[];
    iconClass: string;
    active: boolean = false;
    metadata: any;
    visible: boolean = true;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }

    get hasChildren(): boolean {
        return this.children != null;
    }
}