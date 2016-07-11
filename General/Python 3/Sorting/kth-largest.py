import random

def getMax(sample, start, end):
    if start > end:
        return -1

    if start == end:
        return sample[start]

    midIndex = int((start + end) / 2)
    leftMax = getMax(sample, start, midIndex - 1)
    rightMax = getMax(sample, midIndex + 1, end)

    return max(sample[midIndex], leftMax, rightMax)


sample = random.sample(range(1, 100), 10)
print(sample)
print(getMax(sample, 0, len(sample) - 1))
