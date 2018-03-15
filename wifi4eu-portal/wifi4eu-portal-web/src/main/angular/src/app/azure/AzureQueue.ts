export abstract class AzureQueue {

    abstract createAzureQueue(): void;
    abstract peekMessageAzureQueue(): string;
    abstract updateMessageAzureQueue(): void;
    abstract removeMessageAzureQueue(): void;
    abstract sizeAzureQueue(): number;

}