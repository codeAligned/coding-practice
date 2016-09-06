"""
https://www.interviewcake.com/question/python/stock-price

Suppose we could access yesterday's stock prices as a list, where:
- The indices are the time in minutes past trade opening time,
  which was 9:30am local time.
- The values are the price in dollars of Apple stock at that time.

So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

Write an efficient function that takes stock_prices_yesterday
and returns the best profit I could have made from 1 purchase and 1 sale
of 1 Apple stock yesterday.

For example: stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
get_max_profit(stock_prices_yesterday)
# returns 6 (buying for $5 and selling for $11)

No "shorting"—you must buy before you sell.
You may not buy and sell in the same time step (at least 1 minute must pass).
"""


def maxProfit(sample):
    length = len(sample)
    if length < 2:
        return None

    bestProfit = sample[1] - sample[0]
    lowestPrice = sample[0]

    for x in sample[1:]:
        profit = x - lowestPrice
        bestProfit = max(bestProfit, profit)
        lowestPrice = min(lowestPrice, x)

    return bestProfit


sample = [10, 8, 7, 2, 5, 9, 7, 16, 4]
print(maxProfit(sample))

sample = [10, 8, 7, 2]
print(maxProfit(sample))

sample = [10, 7, 5, 8, 11, 9]
print(maxProfit(sample))

sample = [10, 7, 3, 4, 11, 9]
print(maxProfit(sample))

sample = [10, 3, 7, 5, 4, 11, 9]
print(maxProfit(sample))

sample = [10, 10, 10]
print(maxProfit(sample))

sample = [10, 9, 8, 7, 6, 5]
print(maxProfit(sample))
