Feature: register
  @register
  Scenario: As a user,I should be able to register successfully
    so that I can use all user features

    Given I am on Registration page
    When I enter required registration details
    Then I should able to register successfully