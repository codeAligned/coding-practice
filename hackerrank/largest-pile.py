"""
https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/practice-problems/algorithm/the-largest-pile/description/

You are given some rectangular boxes kept in a sequence.
Your task to make a pile of those boxes and each box has gold filled in it.
But there are restrictions.
You have to use boxes in decreasing sequence of height like if you used
like 17 9 2 1 is a valid sequence of boxes but 17 9 1 2 is not.
Also you have to maximize the amount of the gold that pile results.
If more than one possible pile with maximum amount of gold are there then
output the one with maximum height.
You can only pick boxes in increasing order of the indexes they are kept
i.e. if you pick any box at index i then all boxes to the left of
those indexes (unused) get destroyed automatically.
But you can see all boxes together and also the quantity of gold they possess.
So you need to be strategic or else you loose some boxes.

Input
First line contains N total boxes.
Next line contains N space seprated integers H[i]
denoting height of box at index i
Next line contains N space seprated integers G[i]
denoting gold in box at index i

Output
For each input set you have to output the maximum height and maximum amount of
gold that can be retrieved from the pile that you will make following the rules

Constraints
1≤ N ≤ 1001
1≤ H[i] ≤ 10^3
1≤ G[i] ≤ 10^3

SAMPLE INPUT
4
1 2 3 4
1 2 3 4

SAMPLE OUTPUT
4 4

Explanation
Since you have to maximize the height and gold both so the best way is to
use the 4th one as it will maximize the gold and will also have maximum height.
"""


# TODO: Largest pile.

def calculateMaxHeightAndGold(n, h, g):
    if n == 0:
        return (0, 0)
    elif n == 1:
        return (h[0], g[0])

    maxheight = [None] * n
    maxgold = [None] * n

    for i in range(0, n):
        pileHeight = h[i]
        height = h[i]
        gold = g[i]

        for j in range(i-1, -1, -1):
            if h[j] >= height:
                pileHeight += h[j]
                height = h[j]
                gold += g[j]

        maxheight[i] = pileHeight
        maxgold[i] = gold

    print(maxheight)
    print(maxgold)
    maxheight.sort(reverse=True)
    maxgold.sort(reverse=True)

    i = 1
    while maxgold[0] == maxgold[i]:
        i += 1

    return (max(maxheight[0:i]), maxgold[0])


n = int(input())
h = [int(x) for x in input().strip().split(' ')]
g = [int(x) for x in input().strip().split(' ')]

maxHeight, maxGold = calculateMaxHeightAndGold(n, h, g)
print(str(maxHeight) + ' ' + str(maxGold))
