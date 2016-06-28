#!/usr/bin/env python3

def reverseSentence(sentence, delimeter = ' '):
    words = sentence.split(delimeter)
    words.reverse()
    return delimeter.join(words)

def reverseSentenceBrute(sentence, delimeter = ' '):
    words = sentence.split(delimeter)
    words = [x for x in words[::-1]]
    return delimeter.join(words)

print(reverseSentence('My name is Rash'))
print(reverseSentenceBrute('My name is Rash'))
