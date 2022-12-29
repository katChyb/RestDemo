Feature:  REST_API_Training
  Scenario: Get student details
    Given As a teacher
    When I am searching for student
    Then I am getting student details

    Scenario Outline: