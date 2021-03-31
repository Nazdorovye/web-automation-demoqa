package com.testing.pageObjects.pages;

import org.openqa.selenium.By;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/broken")
public class BrokenLinksImagesPage extends ElementsPage {
  public static By BROKEN_TITLE = text("Broken Links - Images");
  public static By VALID_IMAGE = css("div.row>div>div>img:nth-of-type(1)");
  public static By BROKEN_IMAGE = css("div.row>div>div>img:nth-of-type(2)");
  public static By VALID_LINK = By.xpath("//a[contains(text(), 'Click Here for Valid Link')]");
  public static By BROKEN_LINK = By.xpath("//a[contains(text(), 'Click Here for Broken Link')]");

  public void waitForPageToLoad() {
    getElement(BROKEN_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
