# Part 2 - Instructions 

### Plugged In
|Array type|Time to add elements|Time to sum elemenets|
|---|---|---|
|Array List|7.53s|0.77s|
|Vector|10.77s|3.85s|
|Ordinary Array|5.55s|0.23s|

### Battery Power
|Array type|Time to add elements|Time to sum elemenets|
|---|---|---|
|Array List|10.20s|0.9s|
|Vector|12.50s|5.08s|
|Ordinary Array|6.19s|0.28s|

From the test results, it's shown that a vector is the slowest object to add elements to and to iterate through them. The ordinary array is the fastest object to add elements to and to iterathe through them. This is the same regardless of the processing power of your computer as shown by the plugged in vs battery power tests.

If designers are programming applications that are require an extreme level of efficiency, it is better to use the simplest implmentations possible. However, if efficiency is not too much of a concern, the added functionality of array lists and vectors may be worth the increase in runtime.