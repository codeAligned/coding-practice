#!/usr/bin/env python3

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

with open('data/happynumbers.txt', 'r') as fileobj:
    happy = fileobj.read().splitlines()

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
