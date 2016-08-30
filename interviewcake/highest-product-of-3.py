"""
https://www.interviewcake.com/question/python/highest-product-of-3
"""

# TODO: Highest product of 3
def getHighestProduct(sample):
    if len(sample) < 3:
        return 0

    sample = sorted(sample, reverse=True)

    product = 1
    for i in range(0, 3):
        product *= sample[i]
    return product


inputs = input()
if len(inputs) != 0:
    sample = [int(x) for x in inputs.split(' ')]
    print(getHighestProduct(sample))
