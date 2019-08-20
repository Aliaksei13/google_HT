Feature: Google Homepage
This feature verifies the functionality on Google Homepage

Scenario: Check first website contains the word test after searching
Given I launch Chrome browser
When I open Google Homepage
Then I fill the word test in the search field
And click search button
And open first website
  And assert that website contains test word