"""
Given k sorted lists, with n elements each.
I want a list with all the elements in the k sorted lists in one list.
"""

import queue


def merge(sample1, sample2):
    len1 = len(sample1)
    len2 = len(sample2)

    sample = [None] * (len1 + len2)
    i = j = k = 0

    while i < len1 and j < len2:
        if sample1[i] <= sample2[j]:
            sample[k] = sample1[i]
            i += 1
        else:
            sample[k] = sample2[j]
            j += 1

        k += 1

    for m in range(i, len1):
        sample[k] = sample1[m]
        k += 1

    for m in range(j, len2):
        sample[k] = sample2[m]
        k += 1

    return sample


def mergeKLists(samples):
    total = len(samples)
    if total == 0:
        return None
    elif total == 1:
        return samples[0]

    jobs = queue.Queue()

    for i in range(0, total):
        jobs.put(samples[i])

    while jobs.qsize() != 1:
        sample1 = jobs.get()
        sample2 = jobs.get()

        sample = merge(sample1, sample2)
        jobs.put(sample)

    return jobs.get()


n = int(input())
samples = []

for _ in range(0, n):
    sample = [int(x) for x in input().split(' ')]
    samples.append(sample)

print(mergeKLists(samples))
