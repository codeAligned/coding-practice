"""
The "Array Index & Element Equality" Problem

Given an array of sorted distinct integers named arr,
write a function that returns an index i in arr
for which arr[i] = i or -1 if no such index exists.

Implement the most efficient solution possible,
prove the correctness of your solution and analyze
its runtime complexity (in terms of n - the length of arr).

Examples:
Given arr = [-8,0,2,5] the function returns 2, since arr[2] = 2
Given arr = [-1,0,3,6] the function returns -1,
since no index in arr satisfies arr[i] = i
"""


def getArrayElementEquality(sample):
    if len(sample) == 0:
        return -1

    if sample[0] == 0:
        return 0
    elif sample[0] > 0:
        return -1

    start = 0
    end = len(sample) - 1
    while start <= end:
        mid = int((start + end) / 2)

        if sample[mid] - mid == 0:
            return mid
        elif sample[mid] > 0:
            end = mid - 1
        else:
            start = mid + 1
    return -1


sample = [int(x) for x in input().split(' ')]
print(getArrayElementEquality(sample))
