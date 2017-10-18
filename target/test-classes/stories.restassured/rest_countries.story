Meta:

Narrative:
As a user of countries rest api
I want to know information about countries
So that I can get the call codes and ubication

Scenario: Response Time
Given i have a capital city 'Bogota'
When i request the information
Then response time should be '1700' miliseconds

Scenario: Colombia Call Code
Given i have a capital city 'Bogota'
When i request the information
Then i should get response status code '200'
And i should get the call code '57'

Scenario: Colombia Currency
Given i have a capital city 'Bogota'
When i request the information
Then i should get currency data
|code|name          |symbol|
|COP |Colombian peso|$     |

