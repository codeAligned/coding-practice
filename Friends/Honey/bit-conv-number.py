"""
How many bits would you have to change
to transform one number to another number.
E.g. To transform 24 to 13 how many bits you would have to change.
"""


# LESSON: BIT - For number of bits set, count the no of times n & (n-1).
def countSetBits(n):
    count = 0

    while n > 0:
        n = n & (n - 1)
        count += 1

    return count


def countConversionFlips(a, b):
    c = a ^ b
    return countSetBits(c)


a, b = [int(x) for x in input().split(' ')]
print(countConversionFlips(a, b))
