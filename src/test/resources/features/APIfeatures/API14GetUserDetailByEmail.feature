@api
Feature: API14

  Scenario:14
#    Given Set the path params and send get request
  Given Set the path params for the UserDetailByEmail
  Given Send GET request and receive the response
  Then Verify the status code
