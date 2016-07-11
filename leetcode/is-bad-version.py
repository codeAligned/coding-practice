# https://leetcode.com/articles/first-bad-version/
# True = Good Ver | False = Bad Ver

def getSourceOfBadVersion(sample, best, start, end):
    if start > end:
        return best

    midIndex = int((start + end) / 2)
    if sample[midIndex] == False: # Found a bad version. Go left.
        best = midIndex
        return getSourceOfBadVersion(sample, best, start, midIndex - 1)
    else:
        return getSourceOfBadVersion(sample, best, midIndex + 1, end)


import random
randomIndex = random.randint(1, 9)
sample = [False] * 10

for i in range(0, randomIndex):
    sample[i] = True

print(sample)
print(getSourceOfBadVersion(sample, None, 0, len(sample) - 1))
