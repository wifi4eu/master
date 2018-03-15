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

    public updateMessageAzureQueue(searchMessageContent: string, updateMessageId: string, updateMessageContent: string): void {
        this.queueSvc.getMessages('myqueue', function(error, result, response){
            if(!error){
                this.queueSvc.updateMessage('myqueue', updateMessageId, updateMessageContent, 10, {messageText: updateMessageContent},
                    function(error, result, response){
                        if(error){
                            console.error("QueueComponent - updateMessageAzureQueue", error);
                        } else {
                            console.log("Updated message ", updateMessageContent, searchMessageContent);
                        }
                });
            }
        });
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
        let size = 0;
        this.queueSvc.getQueueMetadata('myqueue', function(error, result, response){
            if(error){
                console.error("QueueComponent - sizeAzureQueue", error);
            } else {
                size = result.approximateMessageCount;
                console.log("Queue length is ", size);
            }
        });

        return size;
    }


}