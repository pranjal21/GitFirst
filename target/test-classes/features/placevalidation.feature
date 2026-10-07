Feature: Place validation of API's
  

  Scenario: Verify a place is added successfully using ADD place API
    Given the Add Place payload
    When the user calls "AddPlaceAPI" with a POST request
    Then the API call succeeds with status code 200
    And "status" in the response body is "OK"
    And "scope" in the response body is "APP"