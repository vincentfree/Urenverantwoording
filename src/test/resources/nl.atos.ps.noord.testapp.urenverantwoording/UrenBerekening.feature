Feature: Uren berekening

  bij   9   8   8   8   8 0 0  verwacht ik 0 uren overwerk
  bij   12  8   8   8   8 0 0  verwacht ik geen lunchvergoeding
  bij   0   0   0   0   0 7 7  verwacht ik 30 euro lunch
  bij   8   8   8   8   8 1 0  verwacht ik 1 uur overgewerkt, geen vergoeding voor overwerk uren en 15 euro lunch geld

  Scenario: verify valid login
    Given I am on the adactin site
    When I log in with my credentials
    Then I am logged in