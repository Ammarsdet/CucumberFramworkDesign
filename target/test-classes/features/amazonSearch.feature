Feature:
Amazon search with multiple items

  @amazonSearchTests
  Scenario Outline: search multiple items on amazon
    Given I am on the amazon homepage
    When I enter the search term "<items>"
    And click on search button
    Then I should see the search item "<items>" on the search result page
    And the page title should conatin the searched "<items>"

    Examples: 
      | items        |
      | coffee mug   |   
      | soccer ball  | 
      | space heater |
      | protein shaker|
      | lithium batteries aa|       
      
         
