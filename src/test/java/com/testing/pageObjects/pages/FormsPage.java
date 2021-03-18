package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/forms")
public class FormsPage extends HomePage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By PRACTICE_FORM_OPTION = css("div.show #item-0");

  public static By FIRST_NAME_FIELD = css("input[id=firstName]");
  public static By LAST_NAME_FIELD = css("input[id=lastName]");
  public static By EMAIL_FIELD = css("input[id=userEmail]");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(FORMS).waitUntilPresent();
    logWeAreOnPage();
  }
}
