class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next

class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if len(self.items) == 0:
            return None

        return self.items.pop()

    def peek(self):
        if len(self.items) == 0:
            return None

        return self.items[len(self.items) - 1]

    def isEmpty(self):
        return self.items == []

def parenthesisChecker(expression):
    stack = Stack()
    lookups = {
        '(': ')',
        '[': ']',
        '{': '}'
    }

    for par in expression:
        if par in lookups.keys():
            stack.push(par)
        elif par in lookups.values():
            closer = stack.peek()

            if closer is None:
                return False

            if par == lookups[closer]:
                stack.pop()

    return stack.isEmpty()

expression = input()
print(parenthesisChecker(expression))
