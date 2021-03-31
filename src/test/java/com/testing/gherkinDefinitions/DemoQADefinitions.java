package com.testing.gherkinDefinitions;

import com.testing.stepDefinitions.DemoQASteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class DemoQADefinitions {
  DemoQASteps demoQASteps = new DemoQASteps();

  @Before
  public void setUp(){
    demoQASteps.setUp();
  }

  @After
  public void tearDown(){
  }

  @When("I click {string}")
  public void i_click(String elementName){
    demoQASteps.click(elementName);
  }

  @Given("I am on the {string} page")
  public void i_am_on_the_page(String page) {
    demoQASteps.validatePage(page);
  }

  @When("I set {string} to {string}")
  public void i_set_to(String elementName, String value) {
    demoQASteps.setElementValueTo(elementName, value);
  }

  @Then("{string} should be {string}")
  public void should_be_enabled_or_disabled(String elementName, String state) {
    demoQASteps.validateElementEnabledOrDisabled(elementName, state);
  }

  @Then("I should be on {string} page")
  public void i_should_be_on_page(String page) {
    demoQASteps.validatePage(page);
  }

  @Then("I see {string} with the following data:")
  public void i_see_with_following_data(String element, DataTable data) {
    demoQASteps.validateData(element, data);
  }

  @Then("I {string} with the following data:")
  public void i_with_following_data(String action, DataTable data) {
    demoQASteps.doSomethingWithData(action, data);
  }

  @Then("{string} should contain {string}")
  public void should_contain(String elementName, String value) {
    demoQASteps.validateElementValue(elementName, value);
  }

  @When("I double click {string}")
  public void i_double_click(String elementName) {
    demoQASteps.doubleClick(elementName);
  }

  @When("I right click {string}")
  public void i_right_click(String elementName) {
    demoQASteps.rightClick(elementName);
  }

  @When("I switch to new tab")
  public void i_switch_to_new_tab() {
    demoQASteps.switchToNewTab();
  }

  @When("I switch to original tab")
  public void i_switch_to_original_tab() {
    demoQASteps.switchToOriginalTab();
  }

  @Then("Alert window should contain {string}")
  public void alert_window_should_contain(String string) {
    demoQASteps.validateAlertText(string);
  }

  @When("I wait for {string} seconds")
  public void i_wait_for_seconds(String string) {
    demoQASteps.sleep(string);
  }

  @Then("I accept alert window")
  public void i_accept_alert_window() {
    demoQASteps.acceptAlert();
  }

  @Then("I dismiss alert window")
  public void i_dismiss_alert_window() {
    demoQASteps.dismissAlert();
  }

  @When("I set Alert window value to {string}")
  public void i_set_alert_window_value_to(String string) {
    demoQASteps.setAlertValue(string);
  }

  @When("I hover over {string}")
  public void i_hover_over(String elementName) {
    demoQASteps.hoverOver(elementName);
  }

  // Custom steps - Stanislavs Vjazovcevs @ 31.03.2021

  @Then("I receive valid HTTP response on image {string}")
  public void i_receive_valid_http_response_code_on_image(String elementName) {
    demoQASteps.httpResponse(elementName, true, false);
  }

  @Then("I receive non valid HTTP response on image {string}")
  public void i_receive_non_valid_http_response_code_on_image(String elementName) {
    demoQASteps.httpResponse(elementName, false, false);
  }

  @Then("I receive valid HTTP response on link {string}")
  public void i_receive_valid_http_response_code_on_link(String elementName) {
    demoQASteps.httpResponse(elementName, true, true);
  }

  @Then("I receive non valid HTTP response on link {string}")
  public void i_receive_non_valid_http_response_code_on_link(String elementName) {
    demoQASteps.httpResponse(elementName, false, true);
  }

  @Then("I can observe image {string}") 
  public void i_can_observe_image(String elementName) {
    demoQASteps.observeImage(elementName, true);
  }

  @Then("I can not observe image {string}") 
  public void i_can_not_observe_image(String elementName) {
    demoQASteps.observeImage(elementName, false);
  }
}
