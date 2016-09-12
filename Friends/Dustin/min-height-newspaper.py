"""
A newspaper has fixed size of columns.
Given heights of each articles, find the min height of newspaper.
Note that articles are given in chronological order.
You are not allowed to change the order.

E.g.
[2 3 1 5 6 3]
Col Len = 4

The best arrangement possible is:
2 1 6 3
3 5 0 0
=======
5 6 6 3

So the min height of newspaper is 6.
"""


def isNewspaperHeightValid(heights, columns, height):
    i = 0
    runningHeight = 0
    length = len(heights)

    while columns > 0 and i < length:
        if (runningHeight + heights[i]) > height:
            columns -= 1
            runningHeight = 0
        else:
            runningHeight += heights[i]
            i += 1

    return i == length


def findNewspaperHeight(heights, columns, minHeight=None, maxHeight=None):
    if minHeight is None or maxHeight is None:
        minHeight = max(heights)
        maxHeight = sum(heights)

    if minHeight > maxHeight:
        return sum(heights)

    mid = (maxHeight + minHeight) // 2
    isHeightPossible = isNewspaperHeightValid(heights, columns, mid)

    if isHeightPossible is True:
        lowerHeight = findNewspaperHeight(heights, columns, minHeight, mid-1)
        return min(mid, lowerHeight)
    else:
        return findNewspaperHeight(heights, columns, mid+1, maxHeight)


columns = int(input())
heights = [int(x) for x in input().split(' ')]
print(findNewspaperHeight(heights, columns))
