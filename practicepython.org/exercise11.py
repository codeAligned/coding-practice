#!/usr/bin/env python3

import math
import random

def isPrime(num):
    numSqrt = int(math.sqrt(num)) + 1

    for i in range(2, numSqrt):
        if num % i == 0:
            return False

    return True

sample = random.sample(range(100000000, 1000000000), 1000)
for num in sample:
    if not isPrime(num):
        print(str(num) + ' is not prime.')
    else:
        print(str(num) + ' is a prime')
