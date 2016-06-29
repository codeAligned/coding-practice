#!/usr/bin/env python3

# TODO: Find a better way to read files and count words.

occurences = dict()
with open('lewinsky-humiliation.txt', 'r') as fileobj:
    line = fileobj.readline()

    while line:
        line = line.strip()
        words = line.split(' ')

        for word in words:
            if word not in occurences:
                occurences[word] = 0

            occurences[word] += 1

        line = fileobj.readline()

print(max(occurences, key = occurences.get))

for w in sorted(occurences, key = occurences.get, reverse = True):
    print(w + ', ' + str(occurences[w]))
