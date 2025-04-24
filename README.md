# kotlin-lotto-precourse

IMPLEMENTATION ROADMAP:

- [ ] Ask the user to enter the purchase amount and validate the input
  * must be divisible by 1000

- [ ] Generate lotto tickets and print them
  * 6 unique numbers between 1 and 45

- [ ] Ask the user to enter the winning numbers and validate the input
  * 6 winning numbers, comma-separated

- [ ] Ask the user to enter a bonus number and validate the input
  * 1 bonus number

- [ ] Compare each ticket with the winning numbers and the bonus number

- [ ] Calculate prize for each ticket

- [ ] Print winning statistics

- [ ] Calculate and display profit rate
  * rounded to the nearest tenth (e.g. 100.0%, 51.5%, 1,000,000.0%)

- [ ] Implement unit tests for all logic
  * except for UI interactions (System.out, System.in)


### Programming Requirements

* follow the Kotlin Coding Conventions
* indentation depth must not exceed 2
* keep functions under 10 lines
* avoid using 'else', early 'return' can eliminate the need for 'else'
* use Enum classes where applicable
* separate business logic from UI logic (use dedicated classes 'InputView' and 'OutputView')
* in case of invalid data, the program must throw an 'IllegalArgumentException' and re-prompt input from that step
* handle only specific exception types 'IllegalArgumentException' or 'IllegalStateException' not generic 'Exception'
* error messages must start with [ERROR]
