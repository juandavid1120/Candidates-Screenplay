Feature: Automation testing using Screenplay pattern.
    As an automation tester
    I need to practice automation testing using Screenplay patter
    for learn about serenity BDD framework

  Scenario Outline: Fill a user registration form using mandatory fields
    Given the user is on landing page of Tools QA
    When him browse to registration form
    And him has filled it and submitted
    |firstName|<firstName>|
    |middleName|<middleName>|
    |lastName|<lastName>|
    |email|<email>|
    |contactNo|<contactNo>|
    |jobVacancy|<jobVacancy>|
    |keywords|<keywords>|
    |comment|<comment>|
    | year | <year> |
    | month | <month> |
    | day | <day> |
    | monthNumber | <monthNumber> |
    | fullDate | <fullDate> |
    And browse the page and search for the user
    Then the user will see a registration information
Examples:
    |firstName|middleName|lastName|email         |contactNo |jobVacancy       |keywords |comment      |year    |month|day|monthNumber|fullDate|
    |JuanDava     |Camiloaaa     |Pereaa  |juan@gmail.com|3046896877|Software Engineer|p122      |testerAvanzado|1995    |Oct   |30|09 |1988-09-12|

