#!/usr/bin/env python3

# Naturally this method will work only on lists without duplicates.
# A duplicate list cannot create unique indexes in the dict.
sample = [5, 4, 3, 2, 1]
sampleDict = dict((item, index) for index, item in enumerate(sample))
sampleSet = set(sampleDict)

reconstructedList = [None] * len(sampleSet)
for i in sampleSet:
    reconstructedList[sampleDict[i]] = i

print(sampleSet)
print(reconstructedList)
