import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';

describe('wifi4eu test beneficiary registration', () => {
  let buttonBeneficiary;
  let buttonSupplier;  

  beforeEach(() => {
    browser.get(browser.baseUrl+"/#/beneficiary-registration");
  });

  it('should register a beneficiary', function() {
    /* buttonBeneficiary = element(by.css('a[href*="/#/beneficiary-landing"]'));
    buttonBeneficiary.click().then(() => {
      element(by.className('publish-button')).click().then(() => { */
          var selectCountry = element(by.id('country'));
          selectCountry.all(by.cssContainingText('option', "ESPAÑA")).click().then(() => {
            var selectMunicipality = element(by.id('organization'));
            selectMunicipality.all(by.cssContainingText('option', 'Municipality')).click().then(() => {
              var isDisplayed = element(by.className('publish-button')).isDisplayed().then((displayed) => {
                element.all(by.className('publish-button')).first().click().then(() => {

                  /* STEP 2 - 1 SECTION */
                  var autoCompleteMunicipality = element(by.id('municipality'));
                  var inputMunicipality = autoCompleteMunicipality.element(by.css('input'));
                  inputMunicipality.click();
                  inputMunicipality.sendKeys("Bar").then(() => {
                    autoCompleteMunicipality.all(by.className('ui-autocomplete-list-item')).first().click();
                  });

                  var inputAddress = element(by.id('address'));
                  inputAddress.click();
                  inputAddress.sendKeys('Street');

                  var inputAddressNum = element(by.id('addressNum'));
                  inputAddressNum.click();
                  inputAddressNum.sendKeys('22');

                  var inputPostalCode = element(by.id('postalCode'));
                  /* inputPostalCode.click(); */
                  inputPostalCode.sendKeys('08000');
                  
                  /* STEP 2 - 2 SECTION */
                  var inputName = element(by.id('name'));
                  /* inputName.click(); */
                  inputName.sendKeys('Tester User');

                  var inputSurname = element(by.id('surname'));
                  /* inputSurname.click(); */
                  inputSurname.sendKeys('Tester User');         
                  
                  var inputEmail = element(by.id('email'));
                  /* inputEmail.click(); */
                  inputEmail.sendKeys('testerUser@testerUser.com');      

                  var inputConfirmEmail = element(by.id('confirm-email'));
                  /* inputConfirmEmail.click(); */
                  inputConfirmEmail.sendKeys(inputEmail.getAttribute('value'));      

                  element.all(by.className('publish-button')).then((elements: any) => {
                    
                    elements[1].click().then(() => { 
                      var inputNameStep3 = element.all(by.id('name')).get(1);
                      var inputSurnameStep3 = element.all(by.id('surname')).get(1);
                      var inputAddressStep3 = element.all(by.id('address')).get(1);
                      var inputAddressNumStep3 = element.all(by.id('addressNum')).get(1);
                      var inputPostalCodeStep3 = element.all(by.id('postalCode')).get(1);

                      inputNameStep3.sendKeys('Tester2 Name');
                      inputSurnameStep3.sendKeys('Tester2 Surname');
                      inputAddressStep3.sendKeys('Tester2 address');
                      inputAddressNumStep3.sendKeys(22);
                      inputPostalCodeStep3.sendKeys('122312');   
                      
                      elements[2].click().then(() => {
                        element.all(by.xpath("//input[@type='checkbox']")).then((elements: any) => {
                          for(var i = 1; i <= elements.length; i++){
                            if(i != 3){
                              element(by.id('check_'+(i+1))).click();
                            }                            
                          }

                          element.all(by.className('publish-button')).then((elements: any) => {
                            elements[3].click().then((callback) => {
                              browser.getCurrentUrl().then( function( url ) {
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
            });
          });
      });/* 
    });
  }); */

});