#!/usr/bin/env python3

class InsertionSort:
    def getBestByBinary(self, value, sample, start, end, best):
        if start > end:
            return best

        midIndex = int((start + end) / 2)

        if sample[midIndex] == value:
            return midIndex + 1
        elif sample[midIndex] > value:
            best = midIndex
            return self.getBestByBinary(value, sample, start, midIndex - 1, best)
        else:
            return self.getBestByBinary(value, sample, midIndex + 1, end, best)

    def insert(self, value, sample):
        sampleLen = len(sample)
        best = self.getBestByBinary(value, sample, 0, sampleLen - 1, sampleLen)

        return sample[:best] + [value] + sample[best:]

tech = InsertionSort()

import random

sample = []
for i in range(1, 10):
    value = random.randint(1, 100)
    sample = tech.insert(value, sample)
    print(value, end = ' ')

print()
print(sample)
