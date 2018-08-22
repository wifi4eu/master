import { browser, element, by } from 'protractor';

export class BeneficiaryPage {
	navigateTo() {
		return browser.get('/#/registration');
	}

	getLegalEntityComponent() {
		return element(by.tagName('legal-entity-component')).isPresent();
	}

	getActiveStep() {
		return element(by.className('progress-indicator')).element(by.className('active')).getAttribute('tabindex');
	}

	isInputFieldPresent(inputId) {
		return element(by.id(inputId)).isPresent();
	}

	isNextStepEnabled() {
		return element(by.className('publish-button')).isEnabled();
	}

	writeTo(inputId, inputText) {
		let input = element(by.id(inputId));
		input.sendKeys(inputText);
	}

	writeToAutocomplete(inputId, inputText) {
		let input = element(by.id(inputId)).element(by.tagName('input'));
		input.sendKeys(inputText);
	}

	getAutocompleteOptions(autocompleteId) {
		return element(by.id(autocompleteId)).all(by.className('ui-autocomplete-list-item')).all(by.tagName('span'));
	}
	
	geAutocompleteInputById(name) {
		return element(by.id(name)).element(by.tagName('input'));
	}

	getInputById(name) {
		return element(by.id(name));
	}
}