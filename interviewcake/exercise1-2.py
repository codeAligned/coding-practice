#!/usr/bin/env python3

#https://www.interviewcake.com/question/python/stock-price

def getBestStockRanges(sample):
    if len(sample) < 2:
        raise IndexError('Cannot have less than 2 values!')

    minPrice = sample[0]
    maxPrice = sample[1]
    bestDifference = maxPrice - minPrice

    for x in sample[1:]:
        priceDifference = x - minPrice

        if priceDifference > bestDifference:
            maxPrice = x
            bestDifference = priceDifference

        minPrice = min(x, minPrice)

    return minPrice, maxPrice, bestDifference

sample = [10, 7, 5, 8, 11, 9]
print(getBestStockRanges(sample))

sample = [10, 7, 3, 4, 11, 9]
print(getBestStockRanges(sample))

sample = [10, 3, 7, 5, 4, 11, 9]
print(getBestStockRanges(sample))

sample = [10, 10, 10]
print(getBestStockRanges(sample))

sample = [10, 9, 8, 7, 6, 5]
print(getBestStockRanges(sample))
