#!/usr/bin/env python3

filename = 'data/' + input('What is the name of your file? ')
filecontent = input()

with open(filename, 'w') as fileobj:
    fileobj.write(filecontent)
