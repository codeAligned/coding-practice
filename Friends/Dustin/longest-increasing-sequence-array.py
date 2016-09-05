"""
Given an array what is the longest increasing sequence.

E.g. [9, 1, 2, 3, 4, 0, 1, 2, 3, 4]
The longest sequence in this case is 0, 1, 2, 3, 4.
So the answer would be 5.
"""


def longestIncreasingSequence(sample):
    length = len(sample)
    if(length == 0):
        return 0

    longest = 1
    current = 1

    for i in range(1, length):
        if sample[i] > sample[i-1]:
            current += 1
            longest = max(longest, current)
        else:
            current = 1

    return longest


sample = [9, 1, 2, 3, 4, 0, 1, 2, 3, 4]
print(longestIncreasingSequence(sample))
