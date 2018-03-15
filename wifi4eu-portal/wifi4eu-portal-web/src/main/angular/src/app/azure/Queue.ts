import {AzureQueue} from "./AzureQueue";

export class QueueComponent implements AzureQueue{

    private azure = require('azure-storage');

    constructor() {

    }


    public createAzureQueue(): void {

    }

    public peekMessageAzureQueue(): string {

        return "";
    }

    public updateMessageAzureQueue(): void {

    }

    public removeMessageAzureQueue(): void {

    }

    public sizeAzureQueue(): number {
        return 0;
    }


}