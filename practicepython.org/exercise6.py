#!/usr/bin/env python3

class StringOperations:
    def isPalindrome(string):
        return string == string[::-1]

    def isPalindromeBrute(string):
        strlen = len(string)

        if strlen % 2 != 0:
            strFirstHalf = string[0:int(strlen/2)]
            strSecondHalf = string[int(strlen/2+1):]
        else:
            strFirstHalf = string[0:int(strlen/2)]
            strSecondHalf = string[int(strlen/2):]

        for i,j in zip(strFirstHalf, reversed(strSecondHalf)):
            if i != j:
                return False

        return True

print(StringOperations.isPalindrome('abcdcba'))
print(StringOperations.isPalindrome('rahul'))

print(StringOperations.isPalindromeBrute('abcdcba'))
print(StringOperations.isPalindromeBrute('rahul'))
