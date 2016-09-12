"""
Given a factorial, tell the number of zeroes present.
E.g. How many zeroes are in 10!
"""


def countFactorialZeroes(n):
    count = 0

    while n % 5 == 0 and n > 0:
        n = n // 5
        count += n

    return count


n = int(input())
print(countFactorialZeroes(n))
