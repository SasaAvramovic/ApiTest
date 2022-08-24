@runAll
  Feature: test response for invalid data used for parameters

    #there is also a comment on other .feature file. Here I will try to send unexpected data
    #and since response code is always 200 I will just assert that response is empty json
    #since I already have json to pojo in place, I might convert it
    #and assert that it is empty. From this simple API one can conclude that there are no invalid requests
    #since response is always 200, but let's consider unexpected data in request as invalid...

    @invalidInput
    Scenario Outline: Check response for invalid entries
      When user sends invalid request with <invalid values>
      Then response code is <code>
      And response has <number of listings> listings
      Examples:
        | invalid values        | code | number of listings |
        | invalid city string   | 200  | 0                  |
        | blank city not null   | 200  | 0                  |
        | city spec character   | 200  | 0                  |
        | lPrice blank not null | 200  | 0                  |
        | lPrice string not num | 200  | 0                  |
        | hPrice blank not null | 200  | 0                  |
        | hPrice string not num | 200  | 0                  |
        | lPrice > hPrice       | 200  | 0                  |

      #There is a strange behavior here, but I left it as it is (failed test)
      #since sending blank string or string of space characters for "price_gte" or "lprice" in this case
      #returns valid values in response, as if 0 was sent