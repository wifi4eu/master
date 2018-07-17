import { BeneficiaryPage } from './beneficiary.po';

describe('Wifi4Eu Beneficiary tests', function() {
	let page: BeneficiaryPage;

	beforeEach(() => {
		page = new BeneficiaryPage();
	});

	it('should display beneficiary registration form', () => {
		page.navigateTo();
		expect(page.getLegalEntityComponent).toBeTruthy();
	});

	it('step 1 should be the active one',  () => {
		page.navigateTo();
		expect(page.getActiveStep()).toEqual('0'); //TODO fix all of them are 0
	});

	it('Next step should be disabled', () => {
		page.navigateTo();
		expect(page.isNextStepEnabled()).toBeFalsy();
	});

	it('filling the form properly should allow going to next step', () => {
		page.navigateTo();
		
		//-- Checking both Next button and municipality selecion are disabled
		expect(page.isNextStepEnabled()).toBeFalsy();
		expect(page.geAutocompleteInputById('municipality').getAttribute('disabled')).toBeTruthy();

		//-- Writting "es" to the Autocomplete should populate the options
		page.writeToAutocomplete('country', 'es');
		
		//-- Still they should be disabled
		expect(page.isNextStepEnabled()).toBeFalsy();
		expect(page.geAutocompleteInputById('municipality').getAttribute('disabled')).toBeTruthy();

		page.getAutocompleteOptions('country').then(function(items) {
			//-- First option should be 'Espanya'
			expect(items[0].getText()).toBe('Espanya');

			//-- Select it
			items[0].click();
		});

		//-- Next step should be disabled
		expect(page.isNextStepEnabled()).toBeFalsy();

		//-- Municipality should be now enabled;
		expect(page.geAutocompleteInputById('municipality').getAttribute('disabled')).toBeFalsy();

		//-- Write 'Bar' to municipality
		page.writeToAutocomplete('municipality', 'bar');

		page.getAutocompleteOptions('municipality').then(function(items) {
			//-- First option should be 'Barcelona'
			expect(items[0].getText()).toBe('Barcelona');

			//-- Select it
			items[0].click();
		});

		//-- Next step should be disabled
		expect(page.isNextStepEnabled()).toBeFalsy();

		page.writeTo('address', 'Diagonal');

		//-- Next step should be disabled
		expect(page.isNextStepEnabled()).toBeFalsy();

		page.writeTo('number', '605');

		//-- Next step should be disabled
		expect(page.isNextStepEnabled()).toBeFalsy();

		page.writeTo('postalCode', '08022');

		//-- Next step should be ENABLED
		expect(page.isNextStepEnabled()).toBeTruthy();
	});
});