#!/usr/bin/env python3

class MergeSort:
    def merge(self, sample1, sample2):
        len1 = len(sample1)
        len2 = len(sample2)

        i1 = 0
        i2 = 0

        merged = []
        while i1 < len1 and i2 < len2:
            curr1 = sample1[i1]
            curr2 = sample2[i2]

            if curr1 < curr2:
                merged.append(curr1)
                i1 += 1
            else:
                merged.append(curr2)
                i2 += 1

        for x in sample1[i1:]:
            merged.append(x)

        for x in sample2[i2:]:
            merged.append(x)

        return merged

    def mergeSort(self, sample):
        sampleLen = len(sample)

        if sampleLen <= 1:
            return sample

        midIndex = int(sampleLen / 2)
        sample1 = self.mergeSort(sample[:midIndex])
        sample2 = self.mergeSort(sample[midIndex:])

        return self.merge(sample1, sample2)

tech = MergeSort()

import random
sample = random.sample(range(1, 100), 10)

print(sample)
print(tech.mergeSort(sample))
