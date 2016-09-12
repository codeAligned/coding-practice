"""
Given a long string that only has letters in it [a-z]
and given a set of characters "chrs", find the minimum length of substring
of that long string that contains all the characters in "chrs".
Note: "chrs" contains NO DUPLICATES.

E.g.
str = dabcdefghdbafd
chrs = adbg
Then smallest substring that contains all characters of chrs is ghdba.
So return 5.
"""

# TODO: Dustin - shortest substring container.


def getShortestLength(s, k):
    i = j = 0
    length = len(s)
    count = len(k)

    hm = {}
    for x in k:
        hm[x] = 0

    while j < length:
        if count == 0:
            i += 1
            j += 1

            left = s[i-1]
            arrived = s[j]

            if left in hm:
                hm[left] -= 1
                count += 1
            if arrived in hm:
                hm[arrived] += 1
                count -= 1
        else:
            if s[i] not in hm:
                i += 1
            elif s[j] in hm:
                hm[s[j]] += 1
                j += 1

                if hm[s[j]] == 1:
                    count -= 1
            else:
                j += 1

    return j - i


s = input()
k = input()
print(getShortestLength(s, k))
