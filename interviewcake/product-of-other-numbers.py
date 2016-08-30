"""
https://www.interviewcake.com/question/python/product-of-other-numbers
"""


def getProduct(sample):
    product = 1
    for x in sample:
        product *= x
    return product


def getProductsOfAllIntsExceptAtIndex(sample, maxProduct, index):
    if sample[index] == 0:
        return -1

    return int(maxProduct / sample[index])


inputs = input()
if len(inputs) != 0:
    sample = [int(x) for x in inputs.split(' ')]
    maxProduct = getProduct(sample)

    length = len(sample)
    answer = [None] * length
    for i in range(0, length):
        answer[i] = getProductsOfAllIntsExceptAtIndex(sample, maxProduct, i)

    print(answer)
