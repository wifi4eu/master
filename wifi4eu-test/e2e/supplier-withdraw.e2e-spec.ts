import {browser, by, element} from 'protractor';

describe('wifi4eu test supplier registration', () => {

  it('should have a title', function() {
    browser.get(browser.baseUrl + "/wifi4eu/#/supplier-portal/profile");

    browser.getCurrentUrl().then(function (url) {
      if (url.match('supplier-portal/profile')) {
        execWithdrawRegistration();
      } else {
        fillRegistration();
      }
    });
  });

  function execWithdrawRegistration() {
    browser.ignoreSynchronization = true;
    browser.waitForAngularEnabled(false);

    element.all(by.id('withdrawRegistration')).click().then(() => {
      browser.sleep(5000);
      browser.getCurrentUrl().then((url) => {
        expect(url).toEqual('https://ecas.acceptance.ec.europa.eu/cas/logout');
      });
    });
  }

  function fillRegistration() {
    browser.get(browser.baseUrl + "/wifi4eu/#/supplier-registration");

    fillRegistrationStep1();

    browser.get(browser.baseUrl + "/wifi4eu/#/supplier-portal/profile");
    execWithdrawRegistration();
  }

  function fillRegistrationStep1() {
    element(by.id('name')).sendKeys('Name');
    element(by.id('address')).sendKeys('Address');
    element(by.id('vat')).sendKeys('VAT');
    element(by.id('bic')).sendKeys('BIC');
    element(by.id('accountNumber')).sendKeys('Account Number');
    element(by.id('website')).sendKeys('http://everis.com');
    let path = require('path');
    let fileToUpload = 'image.PNG';
    let absolutePath = path.resolve(__dirname, fileToUpload);
    element(by.css('input[type="file"]')).sendKeys(absolutePath);

    fillRegistrationStep2();
  }

  function fillRegistrationStep2() {
    element.all(by.className('publish-button')).first().click().then(() => {

      // STEP 2
      let selectCountry = element(by.id('selectCountry'));
      selectCountry.click().then(() => {
        let input = selectCountry.element(by.className('ui-inputtext'));
        input.sendKeys("ESPAÑA").then(() => {
          element(by.cssContainingText('li', 'ESPAÑA')).click();
          let selectCountry = element(by.id('selectRegions'));
          selectCountry.click().then(() => {
            let input = selectCountry.element(by.className('ui-inputtext'));
            input.sendKeys("Barcelona").then(() => {
              element(by.cssContainingText('li', 'Barcelona')).click();
              fillRegistrationStep3();
            });
          });
        });
      });
    });
  }

  function fillRegistrationStep3() {
    element.all(by.className('publish-button')).get(1).click().then(() => {

      // STEP 3
      element(by.id('contactName')).sendKeys('Contact Name');
      element(by.id('contactSurname')).sendKeys('Contact Surname');
      element(by.id('contactPhonePrefix')).sendKeys('12');
      element(by.id('contactPhoneNumber')).sendKeys('123456789');
      element(by.id('contactEmail')).sendKeys('test@test.com');
      element(by.id('confirmEmail')).sendKeys('test@test.com');
      element.all(by.className('publish-button')).get(2).click().then(() => {
        element.all(by.xpath("//input[@type='checkbox']")).then(() => {
          element(by.id('check_' + (1))).click();
          element(by.id('check_' + (2))).click();
          element.all(by.className('publish-button')).get(3).click().then(() => {
            element.all(by.className('publish-button')).get(4).click().then(() => {
              element(by.className('success-failure-icon')).isPresent();
            });
          });
        });
      });
    });
  }

});
