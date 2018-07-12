import { IndexPage } from './app.po';

describe('Wifi4Eu Index tests', function() {
  let page: IndexPage;

  beforeEach(() => {
    page = new IndexPage();
  });

  it('should display app full name', () => {
    page.navigateTo();
    expect(page.getH1Text()).toEqual('Wifi4EU Free Wifi for Europeans');
  });

  it('beneficiary registration button should navigate to the form', () => {
    page.navigateTo();
    page.clickOnBeneficiaryRegistrationButton();
    
    expect(page.getLegalEntityComponent()).toBeTruthy();
  });
});
