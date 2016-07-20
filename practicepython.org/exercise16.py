#!/usr/bin/env python3

import random
import string

def chooseRandomlyFrom(randoms):
    return randoms[random.randint(0, len(randoms) - 1)]

def generateEasyPassword():
    passwordList = ['tom', 'harry', 'sally']
    return chooseRandomlyFrom(passwordList)

def generateMediumPassword():
    password = list(generateEasyPassword())

    for _ in range(5):
        randomIndex = random.randint(0, len(password) - 1)
        password[randomIndex] = password[randomIndex].upper() if ord(password[randomIndex]) >= 97 else password[randomIndex].lower()

    return ''.join(password)

def generateHardPassword(length = 8):
    pool = ['a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F', '1', '2', '3', '4', '5', '6']
    password = ''

    for _ in range(length):
        password += chooseRandomlyFrom(pool)

    return password

def generateHardPasswordShort(length = 8, chars = string.ascii_letters + string.digits + string.punctuation):
    return ''.join(random.sample(list(chars), length))

print(generateEasyPassword())
print(generateMediumPassword())
print(generateHardPassword(8))
print(generateHardPasswordShort())
