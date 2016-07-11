#!/usr/bin/env python3

def calculator(num1, num2, operation):
    return operation(num1, num2)

num1 = 1
num2 = 10

add = lambda x, y: calculator(num1, num2, lambda x, y: x + y)
sub = lambda x, y: calculator(num1, num2, lambda x, y: x - y)
mul = lambda x, y: calculator(num1, num2, lambda x, y: x * y)
div = lambda x, y: calculator(num1, num2, lambda x, y: x / y)

print(add(num1, num2))
print(sub(num1, num2))
print(mul(num1, num2))
print(div(num1, num2))
