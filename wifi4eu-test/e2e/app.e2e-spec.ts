import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';
var Excel = require('exceljs');

describe('wifi-test App', () => {
  let page: AppPage;
  let buttonBeneficiary;
  let buttonSupplier;

  beforeEach(() => {
    browser.get(browser.baseUrl);
  });

  it('app test', function () {
    var workbook = new Excel.Workbook();
    workbook.xlsx.readFile('excel.xlsx').then(function () {
      var worksheet = workbook.getWorksheet(1);
      worksheet.eachRow(function (Row, rowNumber) {
        console.log("Row " + rowNumber + " = " + JSON.stringify(Row.values));
      });
    });
  });

});