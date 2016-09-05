"""
Given a binary tree, print its sum.
"""


def sum(head):
    if head is None:
        return 0

    leftSum = sum(head.left)
    rightSum = sum(head.right)

    return leftSum + rightSum + head.data


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

print(sum(n16))
