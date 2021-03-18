package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/radio-button")
public class RadioButtonPage extends ElementsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  // Find the selectors for all the elements
  public static By RADIO_BUTTON_TITLE = text("Radio Button");
  public static By YES_BUTTON = css("input[id=yesRadio]");
  public static By NO_BUTTON = css("input[id=noRadio]");
  public static By IMPRESSIVE_BUTTON = css("input[id=impressiveRadio]");
  //  After user selects an option, result string is shown.
  public static By SELECTED_RESULT = css("span[class=text-success]");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(RADIO_BUTTON_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
