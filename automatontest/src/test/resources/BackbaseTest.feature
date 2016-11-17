Feature: Execute Test Cases as per requirement set

  #@TestCase4
  @test
  Scenario Outline: Search for Computer which does not exist
    Given I am on test main page
    When I search for computer <which does not exist>
    And click on search button
    Then i can verify that the computer does not exist

    Examples: 
      | which does not exist |
      | "rahul"              |

  #@TestCase5 and TestCase8
  @regression
  Scenario Outline: Add a new computer
    Given I am on test main page
    When I click on Add a new computer button
    And Enter valid data values for <Computer name><Introduced date><Discontinued date><Company>
    And Click on Create this computer button
    Then I can verify <Computer name> has been added

    Examples: 
      | Computer name | Introduced date | Discontinued date | Company      |
      | "RAHUL_Test1" | "2016-11-15"    | "2016-11-25"      | "Apple Inc." |
      | "1"           | ""              | ""                | "Apple Inc." |

  #@TestCase6
  @regression
  Scenario Outline: Modify computer
    Given I am on test main page
    When I search for computer <Computer name>
    And click on search button
    And I can click on the computer <Computer name>
    Then I can update the <Computer name> to <Modified Name>
    And I can verify <Modified Name> has been updated

    Examples: 
      | Computer name | Modified Name          |
      | "RAHUL_Test1" | "RAHUL_Test1_modified" |

  #@TestCase7
  @regression
  Scenario Outline: Delete computer
    Given I am on test main page
    When I search for computer <Computer name>
    And click on search button
    Then I can click on the computer <Computer name>
    And I can delete the computer
    And I can verify <Computer name> has been deleted

    Examples: 
      | Computer name          |
      | "RAHUL_Test1_modified" |

  #@TestCase10
  @regression
  Scenario Outline: Create Duplicate Computer
    Given I am on test main page
    When I click on Add a new computer button
    And Enter valid data values for <Computer name><Introduced date><Discontinued date><Company>
    And Click on Create this computer button
    Then I can verify <Computer name> has been added

    Examples: 
      | Computer name | Introduced date | Discontinued date | Company      |
      | "Duplicate"   | "2016-11-15"    | "2016-11-25"      | "Apple Inc." |
      | "Duplicate"   | "2016-11-15"    | "2016-11-25"      | "Apple Inc." |
