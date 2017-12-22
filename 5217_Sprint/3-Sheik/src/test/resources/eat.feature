Feature: When I am leaving from one side of the river to the other side, I would like to know if one of the objects left
         behind will eat the other object.

Scenario: I want to check if the Chicken will eat the Corn when left alone with it
    Given the Chicken and the Corn
    When they are left alone
    Then the Chicken should eat the Corn

#TODO:
#Scenario: I want to check if the Corn will eat the Fox when left alone with it
#    Given the Corn and the Fox
#    When they are left alone
#    Then the Corn should not eat the Fox
#
#Scenario: I want to check if the Chicken will eat the Corn when left alone with it
#    Given the Chicken and the Corn
#    When they are left alone
#    Then the Chicken should eat the Corn