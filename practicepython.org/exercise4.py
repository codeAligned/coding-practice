#!/usr/bin/env python3

import math
import random

class ArithmeticOperations:
    def findDivisors(self, num):
        #numSqrt = int(math.sqrt(num))
        numSqrt = int(abs(num) / 2)
        numSqrt = 1 if numSqrt < 1 else numSqrt
        return [i for i in range(1, numSqrt + 1) if num % i == 0]


ao = ArithmeticOperations()
randoms = random.sample(range(-100, 100), 10)

for random in randoms:
    print('For ' + str(random) + ' ' + str(ao.findDivisors(random)))
