#!/usr/bin/env python3

import random

class TooHighTooLow:
    def __init__(self, answer, low, high):
        self.chance = 0
        self.answer = answer
        self.low = low
        self.high = high

    def guess(self, num):
        self.chance += 1

        if num == self.answer:
            self.low = num
            self.high = num
            return 0
        elif num > self.answer:
            self.high = num
            return -1
        else:
            self.low = num
            return 1

low = 1
high = 100
game = TooHighTooLow(random.randint(low, high), low, high)

guess = int(input('What\'s your guess? '))
while guess >= 0:
    answer = game.guess(guess)

    if answer == 0:
        print('You guessed it right in ' + str(game.chance) + ' attempts.')
        break
    elif answer > 0:
        print('Incorrect guess. Too low. Range is from ' + str(game.low) + ' - ' + str(game.high) + '.')
    else:
        print('Incorrect guess. Too high. Range is from ' + str(game.low) + ' - ' + str(game.high) + '.')

    guess = int(input('What\'s your guess? '))
