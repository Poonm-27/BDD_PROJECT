Feature: Refer product to a friend
@referAFriend
  Scenario: As a registered user I should be able to refer a product to a friend successfully
    Given I am a registered user
    And I am logged in to the website
    When I click on add to cart button of a product on homepage
    And  I click on email a friend button on product page
    And I enter required details to send email on email a friend page
    And I click on send button
    Then I should be able to refer a product to a friend successfully






