"""
Given a package with a weight limit and an array arr of item weights,
how can you most efficiently find two items with sum of weights that
equals the weight limit?

Your function should return 2 such indices of item weights
or -1 if such pair doesn't exist.
"""


def findWeights(sample, limit):
    hm = {}

    for i, x in enumerate(sample):
        y = limit - x

        if x in hm:
            return (i, hm[x])
        else:
            hm[y] = i

    return -1


sample = [1, 2, 3, 4, 5, -1, 2, 3, 4, -6, -2, 11, 9]
a, b = findWeights(sample, -3)
print(str(sample[a]) + ", " + str(sample[b]))
