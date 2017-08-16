import { TestAngular4Page } from './app.po';

describe('test-angular4 App', () => {
  let page: TestAngular4Page;

  beforeEach(() => {
    page = new TestAngular4Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
