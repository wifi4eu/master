import { browser, element, by } from 'protractor';

export class IndexPage {
	navigateTo() {
		return browser.get('/');
	}

	getH1Text() {
		return element(by.tagName('h1')).getText();
	}

	clickOnBeneficiaryRegistrationButton() {
		return element(by.className('btn btn-primary video-button center-block video-button')).click();
	}

	getLegalEntityComponent() {
		return element(by.tagName('legal-entity-component')).isPresent();
	}
}
