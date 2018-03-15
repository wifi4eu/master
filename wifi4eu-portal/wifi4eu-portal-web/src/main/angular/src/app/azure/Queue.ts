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
                console.error("QueueComponent - addMessageAzureQueue", error);
            } else {
                console.log("Added ", messageContent);
            }
        });
    }

    public peekMessageAzureQueue(): string {
        let message: string = "";

        this.queueSvc.peekMessages('myqueue', function(error, result, response){
            if(error){
                console.error("QueueComponent - peekMessageAzureQueue", error);
            } else {
                console.log("Message text is ", result[0].messageText);
                message = result[0].messageText;
            }
        });

        return message;
    }

    public updateMessageAzureQueue(): void {

    }

    public removeMessageAzureQueue(): void {
        this.queueSvc.getMessages('myqueue', function(error, result, response){
            if(!error){
                // Message text is in messages[0].messageText
                let message = result[0];
                this.queueSvc.deleteMessage('myqueue', message.messageId, message.popReceipt, function(error, response){
                    if(error){
                        console.error("QueueComponent - removeMessageAzureQueue", error);
                    } else {
                        console.log("Message deleted");
                    }
                });
            }
        });
    }

    public sizeAzureQueue(): number {
        return 0;
    }


}