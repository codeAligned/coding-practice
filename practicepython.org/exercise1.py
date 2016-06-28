#!/usr/bin/env python3

import datetime

class TimeTravel:
    _currentAge = None
    _currentDatetime = None
    _currentYear = None

    def __init__(self, currentAge):
        self._currentAge = currentAge
        self._currentDatetime = datetime.datetime.now()
        self._currentYear = self._currentDatetime.year

    def whenWillIturn(self, finalAge):
        yearsLeftToCover = finalAge - self._currentAge
        yearsItWillTake = self._currentYear + yearsLeftToCover

        return yearsItWillTake

name = input('Enter your name: ')
age = int(input('Enter your age: '))
expectingYear = int(input('When will I turn: '))

timeTravel = TimeTravel(age)
whenWillIturn = timeTravel.whenWillIturn(expectingYear)

print('Your name is: ' + name + ' and your age is: ' + str(age))
print('You will turn ' + str(expectingYear) + ' at ' + str(whenWillIturn) + '\n')
