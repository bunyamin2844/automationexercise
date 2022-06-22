@api
Feature: API 1: Get All Products List

  Scenario: Get All Products List

    Given Set the path params for the productsList
    And Send GET request and receive the response body
    Then Verify the status code is 200
    Then Verify the number of all product is 43
    And get all products whose prices are less than 1000





#    Then validate status code


