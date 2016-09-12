"""
Given a list of strings, group all anagrams in it.
Note: All strings will be lowercased.

E.g.
cat, act, sg, fgrs, adfg, god, dog, tac

return [cat, act, tac], [god, dog]
"""


def hashAnagram(string):
    sample = [0] * 26

    for char in string:
        pos = ord(char) - 97
        sample[pos] += 1

    return hash(''.join(map(str, sample)))


def groupAnagrams(sample):
    cache = {}

    for string in sample:
        stringHash = hashAnagram(string)

        if stringHash in cache:
            cache[stringHash].append(string)
        else:
            cache[stringHash] = [string]

    return [value for value in cache.values() if len(value) > 1]


sample = [x for x in input().split(' ')]
anagrams = groupAnagrams(sample)

for anagram in anagrams:
    print(anagram)
