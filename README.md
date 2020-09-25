# AutomationEngineerAssignment
*Overview*

Complete the following automation test. This assignment can be done over the course of 2 days. Please make
commits as often as possible so we can see the time you spent and please do not make all your changes in one big
commit. We will evaluate the code and time spent along with how your commits are split up.
Email your solution as soon as you have completed the challenge or the time is up.


*Key Goals*

As a Customer when I search for Alexa, I want to see if the third option on the second page is
available for purchase and can be added to the cart.

> Action:

- GIVEN the user navigates towww.amazon.com
- AND Searches for ‘Alexa’
- AND navigates to the secondpage
- AND selects the third item

> Expected Result:

- THEN assert that the item would be available for purchase (the user would be able to add it to the cart)


Please use Selenium to write and run your tests. You can use any language of your choice, but we prefer that you
use Java.Avoid the usage of "canned tools" such as the Selenium IDE app extension, Katalon, QTP, etc. We expect
you to write the tests manuallyyourself.
Please place your code in a privateGithub repository and be prepared to give one of ourtesters access. Commit
each step of your process so we can follow your thought process.
The project should be able to be run on Windows or OSX with no manual dependency fetching required.
Please make good use of gradle or maven.
