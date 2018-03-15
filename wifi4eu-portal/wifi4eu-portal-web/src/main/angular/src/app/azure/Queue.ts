import {AzureQueue} from "./AzureQueue";

export class QueueComponent implements AzureQueue{

    private azure = require('azure-storage');
    private queueSvc = this.azure.createQueueService();

    constructor() {

    }


    public createAzureQueue(): void {
        this.queueSvc.createQueueIfNotExists('myqueue', function(error, result, response){
            if(error){
                console.error("QueueComponent - createAzureQueue", error);
            } else {
                console.log("Queue created or exists");
            }
        });
    }

    public addMessageAzureQueue(messageContent: string): void {
        this.queueSvc.createMessage('myqueue', messageContent, function(error, result, response){
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