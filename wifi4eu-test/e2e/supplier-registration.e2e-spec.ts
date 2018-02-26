import {AppPage} from './app.po';
import {browser, by, element} from 'protractor';
import {componentRefresh} from "@angular/core/src/render3/instructions";

describe('wifi4eu test supplier registration', () => {
  let buttonBeneficiary;
  let buttonSupplier;

  beforeEach(() => {
    browser.get(browser.baseUrl + "/#/supplier-registration");
  });

  it('should register a supplier', function () {


    browser.getCurrentUrl().then(function (url) {
      expect(url).toMatch('supplier-portal/profile');
      if (url.match('supplier-portal/profile')) {
        element.all(by.className('changePassword')).last().click().then(() => {
          browser.get(browser.baseUrl + "/wifi4eu/#/supplier-registration");
        });
      }
    });
    // STEP 1
    element(by.id('name')).sendKeys('Name');
    element(by.id('address')).sendKeys('Address');
    element(by.id('vat')).sendKeys('VAT');
    element(by.id('bic')).sendKeys('BIC');
    element(by.id('accountNumber')).sendKeys('Account Number');
    element(by.id('website')).sendKeys('http://everis.com');
    var path = require('path');
    var fileToUpload = 'image.PNG';
    var absolutePath = path.resolve(__dirname, fileToUpload);
    element(by.css('input[type="file"]')).sendKeys(absolutePath);
    element.all(by.className('publish-button')).first().click().then(() => {

      // STEP 2
      var selectCountry = element(by.id('selectCountry'));
      selectCountry.click().then(() => {
        var input = selectCountry.element(by.className('ui-inputtext'));
        input.sendKeys("ESPAÑA").then(() => {
          element(by.cssContainingText('li', 'ESPAÑA')).click();
          var selectCountry = element(by.id('selectRegions'));
          selectCountry.click().then(() => {
            var input = selectCountry.element(by.className('ui-inputtext'));
            input.sendKeys("Barcelona").then(() => {
              element(by.cssContainingText('li', 'Barcelona')).click();
              element.all(by.className('publish-button')).get(1).click().then(() => {

                // STEP 3
                element(by.id('contactName')).sendKeys('Contact Name');
                element(by.id('contactSurname')).sendKeys('Contact Surname');
                element(by.id('contactPhonePrefix')).sendKeys('12');
                element(by.id('contactPhoneNumber')).sendKeys('123456789');
                element(by.id('contactEmail')).sendKeys('test@test.com');
                element(by.id('confirmEmail')).sendKeys('test@test.com');
                element.all(by.className('publish-button')).get(2).click().then(() => {
                  element.all(by.xpath("//input[@type='checkbox']")).then((elements: any) => {
                    element(by.id('check_' + (1))).click();
                    element(by.id('check_' + (2))).click();
                    element.all(by.className('publish-button')).get(3).click().then(() => {
                      element.all(by.className('publish-button')).get(4).click().then(() => {
                        element(by.className('success-failure-icon')).isPresent().then((present) => {
                          expect(present).toBeTruthy();
                        });

                      });
                    });
                  });
                });
              });
            });
          });
        });
      });
    });
  });
});
