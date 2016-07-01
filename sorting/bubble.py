#!/usr/bin/env python3

class BubbleSort:
    def bubbleSort(self, sample, ascending = True):
        n = len(sample)

        for _ in range(0, n):
            for i in range(0, n - 1):
                x = sample[i]
                y = sample[i + 1]

                if ascending:
                    if x > y:
                        sample[i + 1], sample[i] = sample[i], sample[i + 1]
                else:
                    if x < y:
                        sample[i + 1], sample[i] = sample[i], sample[i + 1]

            n -= 1

tech = BubbleSort()

import random
sample = random.sample(range(1, 100), 10)

print(sample)
tech.bubbleSort(sample)
print(sample)
tech.bubbleSort(sample, False)
print(sample)
