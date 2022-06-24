Feature: api08
  Scenario: verify login
    Given Given Set the path params for the verifyLogin
    And Send Post request for create "password" attachment
    Then Verify Status code 200
    Then Verify Response Code 400
    Then Verify Response Message "Bad request, email or password parameter is missing in POST request"




