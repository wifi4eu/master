import {AzureQueue} from "./AzureQueue";
declare var AzureStorage: any;

export class QueueComponent {

  private encoder = new AzureStorage.Queue.QueueMessageEncoder.TextBase64QueueMessageEncoder();
  private queueName = "stressqueue";
  private queueSvc = AzureStorage.Queue.createQueueService("DefaultEndpointsProtocol=https;AccountName=w4equeuestorage;AccountKey=sWvFubVoxStR9G4qMDYdEhASMIYD9Ls2g5/KZdnD563NBeojhP9ehEm1qY0qc/5teR60kOjzIvl5zj0zDsW+1A==;EndpointSuffix=core.windows.net");

  constructor() {}

  public createAzureQueue(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      this.queueSvc.createQueueIfNotExists(this.queueName, function(error, result, response){
        if(error){  
            console.error("QueueComponent - createAzureQueue", error);
            return resolve({error: error});
        } else {
            console.log("Queue created or exists");
            return resolve({error: null});
        }
      });
    });
  }   

  private decodeMessage(message){
    return this.encoder.decode(message);
  }

  private getMessagesAzureQueue(): Promise<any>{
    return new Promise<any>((resolve, reject) => {
      this.queueSvc.getMessages(this.queueName, {numOfMessages: 15, visibilityTimeout: 1}, function(error, results, getResponse){
        if(!error){
          // Messages retrieved
          let messages = [];
          for(var index in results){
            var message = results[index];
            messages.push(message);
          }
          return resolve(messages);
        }
      });
    });
  }

  public addMessageAzureQueue(messageContent: string): Promise<any>{
    return new Promise<any>((resolve, reject) => {
      this.queueSvc.createMessage(this.queueName, this.encoder.encode(messageContent), function(error, result, response){
        if(error){
          /* console.error("QueueComponent - addMessageAzureQueue", error); */
          reject(error);  
        } else {
          /* console.log("Added ", messageContent); */
          resolve(messageContent);
            
        }
      });
    });
  }

  private peekMessageAzureQueue(): string {
    let message: string = "";
    this.queueSvc.peekMessages(this.queueName, function(error, result, response){
      if(error){
        console.error("QueueComponent - peekMessageAzureQueue", error);
      } else {
        console.log("Message text is ", result[0].messageText);
        message = result[0].messageText;
      }
    });

    return message;
  }

  private updateMessageAzureQueue(searchMessageContent: string, updateMessageId: string, updateMessageContent: string): void {
    this.queueSvc.getMessages(this.queueName, function(error, result, response){
      if(!error){
        this.queueSvc.updateMessage(this.queueName, updateMessageId, updateMessageContent, 10, {messageText: updateMessageContent},
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

  private removeMessageAzureQueue(): void {
    var that = this;
    this.queueSvc.getMessages(this.queueName, function(error, result, response){
      if(!error){
        // Message text is in messages[0].messageText
        let message = result[0];
        that.queueSvc.deleteMessage(that.queueName, message.messageId, message.popReceipt, function(error, response){
          if(error){
              console.error("QueueComponent - removeMessageAzureQueue", error);
          } else {
              console.log("Message deleted");
          }
        });
      }
    });
  }

  private sizeAzureQueue(): Promise<number> {
    return new Promise<any>((resolve, reject) => {
      let size = 0;
      this.queueSvc.getQueueMetadata(this.queueName, function(error, result, response){
        if(error){
            console.error("QueueComponent - sizeAzureQueue", error);
            reject(error);
        } else {
            size = result.approximateMessageCount;
            console.log("Queue length is ", size);
            resolve(size);
        }
      });
    });
  }

}