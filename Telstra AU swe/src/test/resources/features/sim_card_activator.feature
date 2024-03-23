Feature : SIM Card Activation
  Scenario: Activate SIM Card successfully
    Given the ICCID is "1234567890" and customer email is "customer@email.com"
    When the sim card is activated
    Then the activation should be successful

  Scenario: Activate SIM Card with invalid ICCID
    Given the iccid is "invalid_iccid" and customer email is "customer@email.com"
    When the sim card is actiavted
    Then the activation should fail

  Scenario: Activate SIM Card without ICCID
    Given no iccid provided
    When the sim card activation request is sent
    Then the activation should fail