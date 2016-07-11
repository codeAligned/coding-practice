# http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/

def flips(expression):
    flips = 0
    opens = 0

    expLen = len(expression)
    if expLen == 0:
        return 0
    elif expLen % 2 == 1:
        return -1

    for x in expression:
        if x == '{':
            opens += 1
        elif x == '}':
            if opens == 0:
                flips += 1
                opens += 1
            else:
                opens -= 1

    flips += int(opens/2)
    return flips


expression = input()
print(flips(expression))
