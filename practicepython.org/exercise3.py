#!/usr/bin/env python3

import random

class ListShortener:
    def shortenByNum(self, list, num):
        return [x for x in list if x <= num]

ls = ListShortener()
sampleList = random.sample(range(0, 100), 10)

print(sampleList)
print(ls.shortenByNum(sampleList, 50))
