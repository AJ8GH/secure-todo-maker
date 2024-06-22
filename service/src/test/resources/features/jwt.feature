Feature: JWT

  Scenario: Request with valid token returns 200
    Given a valid jwt token
    When a GET request is made to "/todo/v1/temp"
    Then a 200 response is returned

  Scenario: Request with invalid token returns 401
    Given an invalid jwt token
    When a GET request is made to "/todo/v1/temp"
    Then a 401 response is returned

  Scenario: Request with no token returns 401
    Given no jwt token
    When a GET request is made to "/todo/v1/temp"
    Then a 401 response is returned
