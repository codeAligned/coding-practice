"""
Given an even array, divide the array in between.
Then shuffle the lower half with higher half.

E.g. A, B, C, D, E, F

A, B, C
D, E, F

A, D, B, E, C, F
"""


def shuffle(sample):
    length = len(sample)
    merged = [0] * length

    if length == 0:
        return merged

    mid = int(length / 2)
    for i in range(0, mid):
        merged[2*i] = sample[i]
        merged[(2*i) + 1] = sample[mid+i]

    return merged


sample = [1, 2, 3, 4, 5, 6]
print(shuffle(sample))
