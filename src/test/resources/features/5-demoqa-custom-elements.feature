Feature: DemoQA - Custom Elements
  Background:
    Given I am on the "Home" page
    And   I click "Elements"
    Then  I am on the "Elements" page

  @run
  Scenario: Broken Links - Images
    When I click "Broken Links option"
    Then I receive valid HTTP response on image "Valid Image"
    Then I receive valid HTTP response on image "Broken Image"
    Then I can observe image "Valid Image"
    Then I can not observe image "Broken Image"
    Then I receive valid HTTP response on link "Valid Link"
    Then I receive non valid HTTP response on link "Broken Link"
