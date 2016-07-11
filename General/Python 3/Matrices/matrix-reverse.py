#!/usr/bin/env python3

def matrixRev(matrix):
    reversedMatrix = []

    for row in matrix:
        row.reverse()
        reversedMatrix.append(row)

    return reversedMatrix

def printMatrix(matrix):
    for i in matrix:
        for j in i:
            print(j, end = ' ')
        print('')


sample = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
printMatrix(sample)
print('----------')
printMatrix(matrixRev(sample))
