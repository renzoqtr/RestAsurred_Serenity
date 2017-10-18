Meta:

Narrative:
As a user of google geocode
I want to get geolocation by a address
So that I can obtain the address geolocation

Scenario: google geolocation by address
Given I have an address 'Calazans Azul'
When I request google api for geocode with address
Then I should get response status code '200'
And I should get longitude '-75.60444' and latitude '6.269785'