#!/usr/bin/env python3

class SelectionSort:
    def getMax(self, sample):
        pos = 0
        lar = sample[pos]

        for i, x in enumerate(sample):
            if x > lar:
                lar = x
                pos = i

        return pos, lar

    def getMin(self, sample):
        pos = 0
        sml = sample[pos]

        for i, x in enumerate(sample):
            if x < sml:
                sml = x
                pos = i

        return pos, sml

    def outOfPlaceSort(self, givenlist, ascending = True):
        sample = [x for x in givenlist]
        sortedList = []
        counter = 0

        while counter < len(sample):
            if ascending:
                pos, _ = self.getMin(sample)
                sortedList.append(sample[pos])
                sample[pos] = 101
            else:
                pos, _ = self.getMax(sample)
                sortedList.append(sample[pos])
                sample[pos] = -1

            counter += 1

        return sortedList

    def inPlaceSort(self, sample, ascending = True):
        counter = 0

        while counter < len(sample) - 1:
            if ascending:
                pos, _ = self.getMin(sample[counter:])
            else:
                pos, _ = self.getMax(sample[counter:])

            sample[counter], sample[pos + counter] = sample[pos + counter], sample[counter]

            counter += 1

if __name__ == '__main__':
    import random

    tech = SelectionSort()
    sample = random.sample(range(1, 100), 10)

    print(sample)
    print(tech.getMax(sample))
    print(tech.getMin(sample))
    print(tech.outOfPlaceSort(sample))
    print(tech.outOfPlaceSort(sample, False))

    print()
    tech.inPlaceSort(sample, True)
    print(sample)

    tech.inPlaceSort(sample, False)
    print(sample)
