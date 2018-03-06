import { AppPage } from './app.po';
import { browser, by, element, protractor } from 'protractor';

describe('wifi4eu test beneficiary registration', () => {
  let buttonBeneficiary;
  let buttonSupplier;

  beforeEach(() => {
    browser.get(browser.baseUrl + "/wifi4eu/#/beneficiary-registration");
  });

  it('Register a beneficiary with multiple municipalities', function () {
    var selectCountry = element(by.id('country'));
    var continueTest = expect(selectCountry.isPresent()).toBeTruthy();
    selectCountry.all(by.cssContainingText('option', "ESPAÑA")).click().then(() => {
      var selectMunicipality = element(by.id('organization'));

      var organizationOptions = selectMunicipality.all(by.tagName('option'));
      organizationOptions.count().then((number) => {
        var random = Math.floor(Math.random() * number);
        /* Avoid disabled "placeholder" and Municipality options */
        if (random == 0) random += 2;
        else if (random == 1) random += 1;
        return random;
      }).then((random) => {
        organizationOptions.get(random).click();
      });

      element(by.id('navigate-step2')).click().then(() => {
        for (var i = 0; i < 2; i++) {
          element(by.css('ux-accordion-boxes + .form-group > button')).click();
        }
        var blocks = element.all(by.tagName('custom-accordion-box'));
        blocks.count().then((count) => {
          for (var i = 0; i < count; i++) {
            var autoCompleteMunicipality = element(by.id(`municipality-${i}`));
            var inputMunicipality = autoCompleteMunicipality.element(by.css('input'));
            inputMunicipality.click();
            browser.actions()
              .sendKeys("Bar")
              .perform()
              .then(function () {
                browser.sleep(500);
                var allOptions = autoCompleteMunicipality.all(by.className('ui-autocomplete-list-item'));
                allOptions.count().then(function (numberOfItems) {
                  return Math.floor(Math.random() * numberOfItems) + 1;
                }).then(function (randomNumber) {
                  for (i = 0; i <= randomNumber; i++) {
                    browser.actions().sendKeys(protractor.Key.ARROW_DOWN).perform();
                  }
                });
                browser.sleep(500);
                browser.actions().sendKeys(protractor.Key.ENTER).perform();
              });
            element(by.id(`address-${i}`)).sendKeys("C/\ Resa");
            element(by.id(`addressNum-${i}`)).sendKeys('02023D');
            element(by.id(`postalCode-${i}`)).sendKeys("hello");
            element(by.id(`name-${i}`)).sendKeys(`Tester${i} Name`);
            element(by.id(`surname-${i}`)).sendKeys(`Tester${i} Surname`);
            element(by.id(`email-${i}`)).sendKeys(`test${i}@test.com`);
            element(by.id(`confirm-email-${i}`)).sendKeys(`test${i}@test.com`);
          }
        })
      });
    });

    element(by.id('navigate-step3')).click().then(() => {
      element(by.id('associationName')).sendKeys('Association Tester Name');
      element(by.id('nameStep3')).sendKeys("TESTER NAME");
      element(by.id('surnameStep3')).sendKeys("TESTER SURNAME");
      element(by.id('addressStep3')).sendKeys("C/\ Tester street");
      element(by.id('addressNumStep3')).sendKeys("20");
      element(by.id('postalCodeStep3')).sendKeys("2BFDG2");

      element(by.id('navigate-step4')).click().then(() => {
        element.all(by.xpath("//input[@type='checkbox']")).then((elements: any) => {
          for (var i = 2; i <= elements.length + 2; i++) {
            if (i != 4) {
              element(by.id('check_' + (i))).click();
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