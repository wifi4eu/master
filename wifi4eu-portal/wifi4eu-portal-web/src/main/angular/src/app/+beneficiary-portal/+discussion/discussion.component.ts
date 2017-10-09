import {Component} from "@angular/core";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
})
export class DiscussionComponent {
    private displayMessage: boolean;
    private message: string;
    private messageList: string[];

    constructor() {
        this.displayMessage = false;
        this.message = "";
        this.messageList = [];
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
    }
}