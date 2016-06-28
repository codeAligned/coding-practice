#!/usr/bin/env python3

import random

def generate():
    print('going to generate')
    mylist = [x for x in range(3)]
    yield -1
    for i in mylist:
        print('looping current: ' + str(i))
        yield i

    for i in mylist:
        print('looping current 2: ' + str(i))
        yield i*i

mygen = generate()
print('this should be first')

for i in mygen:
    print('printing ' + str(i))
