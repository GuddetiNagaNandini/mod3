Feature: Registration form functionality

Scenario: Title verification
Given User is on webpage
When Verify the title
Then Title will be displayed

Scenario: user id is blank
Given User is on webpage
When userid entered is blank
Then Display alertbox 'User id cannot be blank'

Scenario: length of user id is less than required
Given User is on webpage
When user id is not valid
Then Display alertbox 'Userid is invalid'

Scenario: password is blank
Given User is on webpage
When password is blank
Then Display alertbox 'password cannot be blank'

Scenario: length of password is less than required
Given User is on webpage
When password is not valid
Then Display alertbox 'Password is invalid'

Scenario: name is not entered in the form
Given User is on webpage
When name is not entered
Then Display alertbox 'name should not be empty'

Scenario: numbers are entered in the name
Given User is on webpage
When numbers are entered in the name
Then Display alertbox 'numerics are not allowed'

Scenario: address is blank
Given User is on webpage
When address is not entered 
Then Display alertbox 'Address cannot be blank'

Scenario: address is not valid
Given User is on webpage
When address is invalid
Then Display alertbox 'Address should be alphanumeric'

Scenario: country is not selected
Given User is on webpage
When country is not selected 
Then Display alertbox 'country should be selected from the list'

Scenario: zip code is not valid
Given User is on webpage
When zipcade is not valid 
Then Display alertbox 'zipcode cannot have alphabets'

Scenario: email id entered is invalid
Given User is on webpage
When email id entered is invalid
Then Display alertbox 'email id is invalid'

Scenario: gender is not selected
Given User is on webpage
When gender is not selected
Then Display alertbox 'gender should be selected'

Scenario: language should be selected
Given User is on webpage
When language is selected 
Then language gets selected

Scenario: All the values are entered correctly
Given User is on webpage
When  registration form is filled completely 
Then registration is completed












 