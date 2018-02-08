import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/home');
  }

  getParagraphText() {
    return element(by.id('nav-bar')).isPresent();
  }
}
