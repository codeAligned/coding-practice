#!/usr/bin/env python3

def binarySearch(value, sample, start, end):
    if start > end:
        return -1

    midIndex = int((start + end) / 2)

    if sample[midIndex] == value:
        return midIndex
    elif sample[midIndex] > value:
        return binarySearch(value, sample, start, midIndex - 1)
    else:
        return binarySearch(value, sample, midIndex + 1, end)

with open('data/primenumbers.txt', 'r') as fileobj:
    primes = fileobj.read().splitlines()

with open('data/happynumbers.txt', 'r') as fileobj:
    happy = fileobj.read().splitlines()

commons = []
happyLen = len(happy)

for i in primes:
    if binarySearch(i, happy, 0, happyLen - 1) >= 0:
        commons.append(i)

print(commons)
