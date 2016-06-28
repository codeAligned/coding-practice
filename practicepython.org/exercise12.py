#!/usr/bin/env python3

def subList(sample):
    if(type(sample) != list or len(sample) == 0):
        return []
    elif len(sample) == 1:
        return sample
    else:
        return [sample[0], sample[-1]]


list1 = [1, 2, 3, 4, 5]
print(subList(list1))
