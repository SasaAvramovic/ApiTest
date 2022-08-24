@runAll
  Feature: test response for invalid data used for parameters

    #Preconditions would be listed in Given, for example connect to db with valid user.
    #I actually tried to make precondition to run json-server in console, but I couldn't kill the process using "AfterClass"
    #since it started child process. It worked partially, you couldn't see the process anymore, but it was there in
    #task manager so I didn't want to implement partial solution.
    #many of inputs for test are ad hoc solutions that I would do differently given larger data set,
    #since data and information is limited I improvised with extracting data from original response,
    #for example "first city" reference is to Austin, but I wanted to avoid hard-coding it into tests

    @validInput
    Scenario Outline: Check response for valid entries
      When user sends request with <valid values>
      Then response code is <code>
      And response has <number of listings> listings
      And response contains <cities> different cities

      Examples:
        | valid values           | code | number of listings  | cities     |
        | no values              | 200  | all                 | 3          |
        | city only              | 200  | first city count    | 1          |
        | lowest price only      | 200  | all                 | 3          |
        | highest price only     | 200  | all                 | 3          |
        | city and border values | 200  | count from data     | 1          |
        | city and border +-1    | 200  | count from data +-1 | 1          |
        | same lPrice and hPrice | 200  | count from data HL  | 1          |

      #I must once again emphasize that this way of extracting test data is not
      #what I would do if db was available, on my current project we have
      #QA environment with consistent data in db and I can put most
      #of the required data in a file, or extract it from db if needed.
      #This might just look like comparing data to itself, but if you look closely
      #you will see that it is comparing ORIGINAL (db) data to RESPONSE data