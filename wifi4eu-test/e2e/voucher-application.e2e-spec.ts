import {browser, by, element} from 'protractor';

describe('wifi4eu test voucher application', () => {

  beforeEach(() => {
    browser.get(browser.baseUrl + "/#/beneficiary-portal/voucher");
  });

  it('should apply for voucher', function () {
    element(by.css('a[href="#/beneficiary-portal/voucher"]')).click().then(() => {
      browser.sleep(5000);

      element.all(by.id('voucherButton')).click().then(() => {
        browser.sleep(10000);
        element.all(by.className('fa-check')).isPresent().then((present) => {
          expect(present).toBeTruthy();
        });
      });
    });
  });
});
