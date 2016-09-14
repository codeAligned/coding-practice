"""
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key
if the key exists in the cache, otherwise return -1.

set(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently
used item before inserting a new item.
"""


from collections import OrderedDict


class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key):
        if key in self.cache:
            value = self.cache[key]
            del(self.cache[key])
            self.cache[key] = value

            return value
        else:
            return -1

    def set(self, key, value):
        if key in self.cache:
            value = self.cache[key]
            del(self.cache[key])
            self.cache[key] = value
        else:
            if len(self.cache) >= self.capacity:
                self.cache.popitem(last=False)

            self.cache[key] = value

    def printCache(self):
        for key, value in self.cache.items():
            print(str(key), end=' ')
        print()


cache = LRUCache(5)

cache.set(1, 1)
cache.printCache()

cache.set(2, 2)
cache.printCache()

cache.set(3, 3)
cache.printCache()

cache.set(1, 1)
cache.printCache()

cache.set(3, 3)
cache.printCache()

cache.set(4, 4)
cache.printCache()

cache.set(5, 5)
cache.printCache()

cache.set(6, 6)
cache.printCache()

cache.get(3)
cache.printCache()

cache.get(4)
cache.printCache()
