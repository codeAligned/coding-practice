#!/usr/bin/env python3

#https://www.interviewcake.com/question/python/stock-price

def getMax(sample):
    max = 0
    for i, x in enumerate(sample[1:]):
        if x > sample[max]:
            max = i + 1
    return max

sample = [10, 7, 5, 8, 11, 9]
index = 0
differences = {}

while index < len(sample) - 1:
    currentStockValue = sample[index]
    bestPriceIndexFromCurrent = getMax(sample[index + 1:]) + index + 1

    priceDifference = sample[bestPriceIndexFromCurrent] - currentStockValue
    differences[index] = [bestPriceIndexFromCurrent, priceDifference]

    index += 1

bestKey = max(differences, key = lambda x: differences[x][1])
print('You could earn a maximum of ' + str(differences[bestKey][1]) + ' by buying at: ' + str(bestKey) + ' and selling at: ' + str(differences[bestKey][0]))
