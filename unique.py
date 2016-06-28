#!/usr/bin/env python3

import time

def unique(sample):
    seen = set()
    index = 0

    for x in sample:
        if x not in seen:
            seen.add(x)
            sample[index] = x
            index += 1

    del sample[index:]

startTime = time.time()
for _ in range(10000):
    sample = [1, 2, 3, 4, 2, 1]
    unique(sample)
endTime = time.time()
print('Time: ' + str((endTime - startTime)))

startTime = time.time()
for _ in range(10000):
    sample = [1, 2, 3, 4, 2, 1]
    set(sample)
endTime = time.time()
print('Time: ' + str((endTime - startTime)))
