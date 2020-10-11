@PDiff
Feature: Compare PDP on two environments
  As a user
  I want to compare a pdp of a product on two environments

  @complete2
  Scenario Outline: Compare a product on sit2 and st1 environment
    When I search for a <product> item on two environment
    Then I should see page same for <product> on both environment

    Examples: 
      | product       |
      | boots		  |
      | leggings      |
      | sofa		  |
      | lingerie_sets |      
