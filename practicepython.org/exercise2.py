#!/usr/bin/env python3

class ArithmeticOperations:
    def isEven(self, num):
        return (num % 2 == 0)

    def isDivisibleBy(self, num, divisor):
        return (num % divisor == 0)

    def isDivideEvenly(self, num, divisor):
        if(self.isDivisibleBy(num, divisor)):
            return self.isEven(num/divisor)
        else:
            return None

numbers = [-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
ao = ArithmeticOperations()

for num in numbers:
    if(ao.isDivideEvenly(num, 4) == True):
        print(str(num) + ' is divisible by 4 evenly.')
    elif(ao.isDivideEvenly(num, 4) == False):
        print(str(num) + ' is divisible by 4 oddly.')
    elif(ao.isDivideEvenly(num, 4) == None):
        print(str(num) + ' is an ' + ('even' if ao.isEven(num) else 'odd') + ' number')
