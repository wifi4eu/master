import {AzureQueue} from "./AzureQueue";

export class QueueComponent implements AzureQueue{

    private azure = require('azure-storage');

    constructor() {

    }


    public createAzureQueue(): void {
        let queueSvc = this.azure.createQueueService();

        queueSvc.createQueueIfNotExists('myqueue', function(error, result, response){
            if(error){
                console.error("QueueComponent - createAzureQueue", error);
            } else {
                console.log("Queue created or exists");
            }
        });
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