#!/usr/bin/env python3

import math

def getDivisors(num):
    numSqrt = int(math.sqrt(num)) + 1

    for i in range(1, numSqrt):
        if num % i == 0:
            yield i
            
            if i*i != num:
                yield int(num / i)

for i in getDivisors(100):
    print(i)
