Feature: Sim Card Activator
  Describes the behaviour of microservices involved in sim card activation

  Scenario: A functional sim card is activated successfully.
    Given a functional sim card
    When a request to activate sim card is submitted
    Then the activation is successful and is recorded in the database

  Scenario: A non-functional sim card fails to be activated.
    Given a broken sim card
    When a request to activate sim card is submitted
    Then the activation is fails and is recorded in the database