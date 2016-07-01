#!/usr/bin/env python3

'''
To use binary search to find common items in ordered lists, would take nlogn time complexity.
Though there is no easy way to reduce this time, we could try another approach. I call this fuzzy approach.

list1 = [1, 5, 7, 8, 9, 12]
list2 = [2, 3, 7, 9, 13, 15, 19]

So we can see that the first element in l1 is 1 and l2 is 2. So we ask l1 get me best number >= 2.
l1 gets you 5. Then we ask l2, get me best number >= 5.
l2 gets you 7. We ask l1, get me best number >= 7.
l1 gets me 7. Now l1 and l2 both have 7. So we record that value.
Then we increment both from l1 and l2. So l1 = 8, l2 = 9
We asks l1, get me best number >= 9.
l1 gets 9. l2 and l1 are again same. Record this value.
Increment both l1 and l2. So l1 = 12, l2 = 13.
We asks l1, get me best number >= 13.
l1 cannot get that. So we know that l1 is exhausted. At this point there cannot be more common numbers.
Hence the answer is [7, 9]

So even though the time complexity is still nlogn, this method is more effective because it skips several iterations.
'''

import time

def binaryFuzzySearch(value, sample, start, end, bestIndex):
    if start > end:
        return bestIndex

    midIndex = int((start + end) / 2)

    if sample[midIndex] == value:
        return midIndex
    elif sample[midIndex] >= value:
        bestIndex = midIndex
        return binaryFuzzySearch(value, sample, start, midIndex - 1, bestIndex)
    else:
        return binaryFuzzySearch(value, sample, midIndex + 1, end, bestIndex)

with open('data/primenumbers.txt', 'r') as fileobj:
    primes = fileobj.read().splitlines()
primes = [int(x) for x in primes]

with open('data/happynumbers.txt', 'r') as fileobj:
    happy = fileobj.read().splitlines()
happy = [int(x) for x in happy]

startTime = time.time()

primeLen = len(primes)
happyLen = len(happy)

commons = []
primeIndex = 0
happyIndex = 0

while primeIndex < primeLen and happyIndex < happyLen:
    primeValue = primes[primeIndex]
    happyValue = happy[happyIndex]

    if primeValue == happyValue:
        commons.append(primeValue)
        primeIndex += 1
        happyIndex += 1
    elif primeValue < happyValue:
        primeBetter = binaryFuzzySearch(happyValue, primes, primeIndex, primeLen - 1, -1)
        if primeBetter == -1:
            primeIndex = primeLen
        else:
            primeIndex = primeBetter
    else:
        happyBetter = binaryFuzzySearch(primeValue, happy, happyIndex, happyLen - 1, -1)
        if happyBetter == -1:
            happyIndex = happyLen
        else:
            happyIndex = happyBetter

print(commons)
endTime = time.time()
print('Total time for intersect using fuzzy: ' + str((endTime - startTime) * 1000))
