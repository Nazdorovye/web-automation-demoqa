package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/alerts")
public class AlertsPage extends AlertsFrameAndWindowsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By ALERTS_TITLE = text("Alerts");
  // Page contains multiple buttons with the same name, but different functionality.
  public static By ALERT_BUTTON = css("button[id=alertButton]");
  public static By TIMER_ALERT_BUTTON = css("button[id=timerAlertButton]");
  public static By CONFIRM_ALERT_BUTTON = css("button[id=confirmButton]");
  public static By PROMPT_ALERT_BUTTON = css("button[id=promtButton]");
  public static By CONFIRM_RESULT = css("span[id=confirmResult");
  public static By PROMPT_RESULT = css("span[id=promptResult");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(ALERTS_FRAME_AND_WINDOWS).waitUntilPresent();
    logWeAreOnPage();
  } 
}
