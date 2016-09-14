"""
Learn how to use decorators.

First create a function,
and then use it as a decorator to some other function.
"""


def memoized(func):
    memo = {}

    def memorize(x):
        if x not in memo:
            memo[x] = func(x)
        return memo[x]

    return memorize


@memoized
def factorial(n):
    if n == 0 or n == 1:
        return 1

    return n * factorial(n-1)


for i in range(0, 20):
    print(str(i) + ': ' + str(factorial(i)))
