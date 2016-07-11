# http://www.geeksforgeeks.org/largest-independent-set-problem/

class Node:
    def __init__(self, data, left = None, right = None):
        self.data = data
        self.left = left
        self.right = right

def LIS(root):
    if root == None:
        return 0

    setCountingRoot = 1
    if root.left != None:
        setCountingRoot += LIS(root.left.left) + LIS(root.left.right)
    if root.right != None:
        setCountingRoot += LIS(root.right.left) + LIS(root.right.right)

    setNotCountingRoot = LIS(root.left) + LIS(root.right)

    return max(setCountingRoot, setNotCountingRoot)

n1, n2, n3, n4, n5, n6, n7, n8 = Node(1), Node(2), Node(3), Node(4), Node(5), Node(6), Node(7), Node(8)
n1.left = n2
n1.right = n3

n2.left = n4
n2.right = n5

n3.right = n6

n5.left = n7
n5.right = n8

print(LIS(n1))
