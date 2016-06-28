#!/usr/bin/env python3

def generateFibonnaci(elements):
    a, b = 0, 1
    for _ in range(elements):
        a, b = b, a + b
        yield a

total = int(input('How many Fibonnaci sequences do you need? '))

sequence = generateFibonnaci(total)
for i in sequence:
    print(i, end = ' ')
