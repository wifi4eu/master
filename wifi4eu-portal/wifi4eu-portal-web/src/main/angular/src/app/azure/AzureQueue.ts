export abstract class AzureQueue {

    abstract createAzureQueue(): void;
    abstract addMessageAzureQueue(messageContent: string): void;
    abstract peekMessageAzureQueue(): string;
    abstract updateMessageAzureQueue(): void;
    abstract removeMessageAzureQueue(): void;
    abstract sizeAzureQueue(): number;

}