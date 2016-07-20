#!/usr/bin/env python3

import random

'''
Assuming: Guess in right place = cow, and guess in wrong place = bull.
What most solutions lack in this game is a scenario like this:
Random number: 2907
Guess: 1000
System would say 1 cows and 2 bulls.
Why? Because it will correctly guess the cow, but the other 0's will count towards the bull.

In general:
1. A number in secret already guessed as cow must not be counted as bull again.
2. A number in secret already counted as bull must not again be counted as bull.

The solution is to first count the cows, and mark those places (I replace that place with -1).
Then we can count bulls by checking if the given number exists. If yes, we remove that index.

Sample1: 2907. Guess 1000
First cows are calculated and hence the third place is counted as cow. That place is then replaced with -1. [2, 9 -1, 7]
Second, the bulls are counted. Now the 0 will never be found again.

Sample2: 2997. Guess 9999
First cows are calculated. Two cows will be found. [2, -1, -1, 7]
In bulls, nines will never be found again.

Sample3: 2907. Guess 7770
No cows will be found. [2, 9, 0, 7]
To count bulls, first 7 will be found at index 3. Bulls = 1. [2, 9, 0, -1]
7 will never be found again because it has been replaced by -1.
0 is found. So the list will change to [2, 9, -1, -1]
Finally correct number of bulls are returned.
'''

class CowsAndBulls:
    _secretNumber = None
    attempts = 0

    def __init__(self):
        self._secretNumber = list(str(random.randint(1000, 9999)))

    def guess(self, guess):
        self.attempts += 1
        cows = 0
        bulls = 0

        numbers = list(str(guess))
        secretNumberCopy = self._secretNumber[:]

        for index, number in enumerate(numbers):
            if secretNumberCopy[index] == number:
                cows += 1
                secretNumberCopy[index] = -1

        for number in numbers:
            try:
                numberIndex = secretNumberCopy.index(number)
            except ValueError:
                numberIndex = -1

            if numberIndex != -1:
                bulls += 1
                secretNumberCopy[numberIndex] = -1

        return cows, bulls

    def hasWon(self, cows):
        return cows == len(self._secretNumber)

game = CowsAndBulls()
print('Welcome to cows and bulls. You need to guess a 4 digit number. Press -1 to quit. Secret: ' + str(game._secretNumber))

keepPlaying = True
while keepPlaying == True:
    guess = int(input('What is your guess? '))
    if guess == -1:
        keepPlaying = False
        continue

    cows, bulls = game.guess(guess)

    if game.hasWon(cows):
        print('Congratulations! you won after ' + str(game.attempts) + ' guesses.')
        keepPlaying = False
        continue
    else:
        print('Wrong guess! ' + str(cows) + ' cows and ' + str(bulls) + ' bulls.')
