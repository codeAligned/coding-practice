# http://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/

def sumBitDifference(sample):
    sum = 0
    n = len(sample)

    for i in range(0, 32):
        count = 0
        for j in range(0, n):
            if sample[j] & (1 << i):
                count += 1
        print(count)
        sum += count * (n - count) * 2

    return sum

sample = [1, 3, 5]
print(sumBitDifference(sample))
