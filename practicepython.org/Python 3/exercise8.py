#!/usr/bin/env python3

class RockPaperScissor:
    ROCK = -7
    PAPER = 2
    SCISSOR = 4

    PAPER_ROCK = 5
    SCISSOR_PAPER = 2
    ROCK_SCISSOR = 3

    def __init__(self, p1Input, p2Input):
        self._p1Input = self.ROCK if p1Input == 1 else self.PAPER if p1Input == 2 else self.SCISSOR
        self._p2Input = self.ROCK if p2Input == 1 else self.PAPER if p2Input == 2 else self.SCISSOR

    def getWinner(self):
        if self._p1Input == self._p2Input:
            return 0

        choiceSum = abs(abs(self._p1Input) - abs(self._p2Input))
        if choiceSum == 3:
            return 1 if abs(self._p1Input) > abs(self._p2Input) else -1
        else:
            return 1 if self._p1Input > self._p2Input else -1

    def getWinnerSimple(self, p1Input, p2Input):
        diff = p1Input - p2Input
        if diff == 0:
            return 0
        elif diff in [-2, 1]:
            return 1
        else:
            return -1


startGame = input('Start Game? ').lower() == 'y'
while startGame:
    p1Input = int(input('Player1 choose: 1. Rock 2. Paper 3. Scissor -> '))
    p2Input = int(input('Player1 choose: 1. Rock 2. Paper 3. Scissor -> '))

    game = RockPaperScissor(p1Input, p2Input)
    winner = game.getWinner()
    winner2 = game.getWinnerSimple(p1Input, p2Input)
    print('Winner is: ' + ('Player 1' if winner > 0 else 'Player 2' if winner < 0 else 'Draw') + '.')
    print('Winner is: ' + ('Player 1' if winner2 > 0 else 'Player 2' if winner2 < 0 else 'Draw') + '.\n')

    startGame = input('Start Game? ').lower() == 'y'
