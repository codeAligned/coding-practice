"""
Given a binary tree what is the longest increasing sequence.

E.g.
       16
    12     13
  14  15
  .
  .
  .
 1
 4
 5
 6
 7
 8
The longest sequence in this case is 1, 4, 5, 6, 7, 8.
So the answer would be 6.
"""


def longestIncreasingSequence(head, current=0):
    if head is None:
        return 0

    if head.left is None:
        leftMax = 0
    elif head.data < head.left.data:
        leftMax = longestIncreasingSequence(head.left, current+1)
    else:
        leftMax = longestIncreasingSequence(head.left, 0)

    if head.right is None:
        rightMax = 0
    elif head.data < head.right.data:
        rightMax = longestIncreasingSequence(head.right, current+1)
    else:
        rightMax = longestIncreasingSequence(head.right, 0)

    return max(leftMax, rightMax, current+1)


class Node:
    data = None
    left = None
    right = None

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


n16 = Node(16)
n12 = Node(12)
n13 = Node(13)
n14 = Node(14)
n15 = Node(15)
n1 = Node(1)
n4 = Node(4)
n5 = Node(5)
n6 = Node(6)
n7 = Node(7)
n8 = Node(8)

n16.left = n12
n16.right = n13
n12.left = n14
n12.right = n15
n14.left = n1
n1.left = n4
n4.left = n5
n5.left = n6
n6.left = n7
n7.left = n8

print(longestIncreasingSequence(n16))
