Feature: To verify the telecom functionality
 

Scenario: User should enter the invalid data in add tariff plan fields than Error message should come.
Given The user should be at the Add Tariff Plan page
When User should fill the Invalid data detail and click on the submit buttons
|Monthly Rental|11|
|Free Local Minutes|2e|
|Free International Minutes|34|
|Free SMS Pack|45|
|Local Per Minutes Charges|59|
|International Per Minutes Charges|65|
|SMS Per Charges|79|
Then Error message box should display
      
     
@sprint1           
Scenario: User should not fill the mandatory fields than alert message should come
    Given The user should be at the add customer page
    When User should not fill madantory detail and click on the submit button
    Then valid error message should display
    
@sprint2   
Scenario Outline: User should fill the all detail and click on submit button than customer details added and customer id is generated
Given The user should be at the add customer pagess
When Users should fill the all detail"<Firstname>","<Lastname>","<Email>","<address>","<mobileno>"
When users click on submit buttons
Then customer id is generated

Examples: 
      |Firstname|Lastname|Email|address|mobileno|
      |ashok|kumar |ashok@gmail.com |5a annastreet|1234|
      |Ram | Mohan |ram@gmail.com |5a annastreet|8967|
      |sathis|hari|rai@gmail.com |5a annastreet|5453|
      |Ganga |vaintha| ganga@yahoo.com  |5a k k street|0989|
      
      
@sprint3
 Scenario: User should fill the form and click the reset button than all details should get cleared
    Given The user should be at the add tariff plan page
    When  User should fill the all details 
    |Monthly Rental|10|
    |Free Local Minutes|20|
    |Free International Minutes|30|
    |Free SMS Pack|40|
    |Local Per Minutes Charges|50|
    |International Per Minutes Charges|60|
    |SMS Per Charges|70|
    And click on the reset button
    Then values should get cleared
  
       

    