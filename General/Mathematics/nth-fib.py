# 0 1 1 2 3 5
def nthFibRecursive(n):
    if n == 1:
        return 0
    elif n == 2:
        return 1

    return nthFibRecursive(n-1) + nthFibRecursive(n-2)

def nthFibIterative(n):
    a = 0
    b = 1

    if n == 1:
        return a
    elif n == 2:
        return b

    for i in range(3, n + 1):
        a, b = b, a + b
    return b

for i in range(1, 6):
    print(nthFibRecursive(i), end = ' ')
    print(nthFibIterative(i))
