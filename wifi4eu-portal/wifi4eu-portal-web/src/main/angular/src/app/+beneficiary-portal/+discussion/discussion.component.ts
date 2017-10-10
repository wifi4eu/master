import {Component} from "@angular/core";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
})
export class DiscussionComponent {
    private displayMessage: boolean;
    private message: string;
    private messageList: string[];
    private displayMediation: boolean;

    constructor() {
        this.displayMessage = false;
        this.message = "";
        this.messageList = [];
        this.displayMediation = false;
    }

    newMessage() {
        this.displayMessage = true;
        this.message = "";
    }

    sendMessage() {
        this.messageList.push(this.message);
        this.displayMessage = false;
    }


    closeModal() {
        this.displayMessage = false;
        this.displayMediation = false;
    }

    newMediation() {
        this.displayMediation = true;
    }
}