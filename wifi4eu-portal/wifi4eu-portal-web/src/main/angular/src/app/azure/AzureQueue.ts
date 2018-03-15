export abstract class AzureQueue {

    abstract createAzureQueue(): void;
    abstract addMessageAzureQueue(messageContent: string): void;
    abstract peekMessageAzureQueue(): string;
    abstract updateMessageAzureQueue(searchMessageContent: string, updateMessageId: string, updateMessageContent: string): void;
    abstract removeMessageAzureQueue(): void;
    abstract sizeAzureQueue(): number;

}