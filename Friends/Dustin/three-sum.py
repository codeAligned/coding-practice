"""
Given an array, and a target number,
choose 3 elements of array that sum up to this number.
"""


def getTwoSum(sample, sum):
    i = 0
    j = len(sample) - 1

    while i < j:
        x = sample[i]
        y = sum - sample[i]

        if sample[j] > y:
            j -= 1
        elif sample[j] < y:
            i -= 1
        else:
            return (sample[i], sample[j])

    return None


def getThreeSum(sample, sum):
    sample.sort()

    for x in sample:
        twosum = sum - x
        twosumAns = getTwoSum(sample, twosum)

        if twosumAns is not None:
            return (x, twosumAns[0], twosumAns[1])

    return None


sum = int(input())
sample = [int(x) for x in input().split(' ')]
print(getThreeSum(sample, sum))
