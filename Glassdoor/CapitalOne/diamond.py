"""
Print a diamond of n lines.

E.g. n = 3
  *
 ***
*****
 ***
  *
"""

n = 10
stars = 2*n+1

for i in range(-n, n+1):
    for _ in range(0, abs(i)):
        print(' ', end='')

    for _ in range(0, stars - abs(2*i)):
        print('*', end='')

    print()
