Feature: Find workshop flow validation

  @WebDriverExerciseTests
  Scenario: To Verify the Find workshop flow
    Given I am on Home page of "WW International"
    And I assert that loaded page title matches
      | "WW (Weight Watchers): Weight Loss & Wellness Help \| WW USA" |
    And I click on "Find a Workshop" found on the right corner
    And I assert that loaded page title matches
      | "Find WW Studios & Meetings Near You \| WW USA" |
    And I search for the meetings at zip code
      | 10011 |
    And I print the title of the first result and the distance
    And I click on first search result
    And I assert that loaded page title matches with first result
    And I print TODAY’s hours of operation
    And I print the number of meeting the each person for each day
      | SUN |
      | MON |
      | TUE |
      | WED |
      | THU |
      | FRI |
      | SAT |


  #3. On the right corner of the page, click on “Find a Workshop”
  #4. Assert loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
  #5. In the search field, search for meetings for zip code: 10011
  #6. Print the title of the first result and the distance (located on the right of location title/name)
  #7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
  #8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
  #9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week