import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';

describe('wifi4eu test beneficiary registration', () => {
  let buttonBeneficiary;
  let buttonSupplier;

  beforeEach(() => {
    browser.get(browser.baseUrl + "/wifi4eu/#/beneficiary-registration");
  });

  it('should register a beneficiary', function () {
    var selectCountry = element(by.id('country'));
    var selectMunicipality = element(by.id('organization'));
    selectCountry.all(by.cssContainingText('option', "ESPAÑA")).click().then(() => {
      selectMunicipality.all(by.cssContainingText('option', 'Municipality')).click().then(() => {
        element(by.id('navigate-step2')).click().then(() => {
          /* STEP 2 - 1 SECTION */
          var autoCompleteMunicipality = element(by.id('municipality'));
          var inputMunicipality = autoCompleteMunicipality.element(by.css('input'));
          inputMunicipality.click();
          inputMunicipality.sendKeys("Bar").then(() => {
            var autocompleteOptions = autoCompleteMunicipality.all(by.className('ui-autocomplete-list-item'));
            autocompleteOptions.count().then(function (numberOfItems) {
              return Math.floor(Math.random() * numberOfItems) + 1;
            }).then(function (randomNumber) {
              autocompleteOptions.get(randomNumber).click();
            });
          });

          var inputAddress = element(by.id('addressStep2'));
          var inputAddressNum = element(by.id('addressNumStep2'));
          var inputPostalCode = element(by.id('postalCodeStep2'));
          var inputName = element(by.id('nameStep2'));
          var inputSurname = element(by.id('surnameStep2'));
          var inputEmail = element(by.id('emailStep2'));
          var inputConfirmEmail = element(by.id('confirm-emailStep2'));

          inputAddress.sendKeys('Street');
          inputAddressNum.sendKeys('22');
          inputPostalCode.sendKeys('08000');
          inputName.sendKeys('Tester User');
          inputSurname.sendKeys('Tester User');
          inputEmail.sendKeys('testerUser@testerUser.com');
          inputConfirmEmail.sendKeys(inputEmail.getAttribute('value'));

          element(by.id('navigate-step3')).click().then(() => {
            var inputNameStep3 = element(by.id('nameStep3'));
            var inputSurnameStep3 = element(by.id('surnameStep3'));
            var inputAddressStep3 = element(by.id('addressStep3'));
            var inputAddressNumStep3 = element(by.id('addressNumStep3'));
            var inputPostalCodeStep3 = element(by.id('postalCodeStep3'));

            inputNameStep3.sendKeys('Tester2 Name');
            inputSurnameStep3.sendKeys('Tester2 Surname');
            inputAddressStep3.sendKeys('Tester2 address');
            inputAddressNumStep3.sendKeys(22);
            inputPostalCodeStep3.sendKeys('122312');

            element(by.id('navigate-step4')).click().then(() => {
              element.all(by.xpath("//input[@type='checkbox']")).then((elements: any) => {
                for (var i = 1; i <= elements.length; i++) {
                  if (i != 3) {
                    element(by.id('check_' + (i + 1))).click();
                  }
                }
                element(by.id('submitRegistration')).click().then(() => {
                  browser.sleep(2000);
                  browser.getCurrentUrl().then(function (url) {
                    expect(url).toMatch('beneficiary-portal');
                  });
                });
              });
            });
          });
        });
      });
    });
  });

  it('withdraw registration', function () {
    browser.getCurrentUrl().then(function (url) {
      expect(url).toMatch('beneficiary-portal/profile');
      if (url.match('beneficiary-portal/profile')) {
        element.all(by.className('changePassword')).last().click().then(() => {
          browser.ignoreSynchronization = true;
          browser.waitForAngularEnabled(false);
          browser.getCurrentUrl().then(function (currentUrl) {
            browser.wait(function () {
              return browser.getCurrentUrl().then(function (newUrl) {
                return (newUrl.match('logout'));
              });
            });
          });
        });
      }
    });
  });

});