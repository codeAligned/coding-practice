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

'''
If brackets are to be supported in the conversion from infix to post/pre fix then,
You should push the opening braces whenever you find one.
While popping, check if a closing brace is found.
    If yes, keep popping until opening brace is found.
    At last, also pop the opening brace because the current brace is evaluated.
    DO NOT push the closing bracket again back into the stack.
'''
class Expressions:
    operands = {
        '+': 1,
        '-': 1,
        '*': 2,
        '/': 2
    }

    '''
    To convert infix to postfix, traverse from left to right.
    If value is found, keep it in separate array - postfix.
    If operator is found, check the topmost part of stack.
        If it is null, or the topmost is smaller than current, just insert this operator to the stack.
        If it is not null, and the topmost is greater than current, pop and add to "postfix" array.
        Do above until you have come across an operator in stack which is lower than current operator.
        Note: You keep popping as long as higher precedence is found on topmostOperand.

        Add the current item to the stack.
    '''
    def infixToPostfix(self, expression):
        stack = Stack()

        postfix = []
        for item in expression:
            if item in self.operands.keys():
                topmostOperand = stack.peek()

                while topmostOperand != None and self.operands[topmostOperand] >= self.operands[item]:
                    postfix.append(stack.pop())
                    topmostOperand = stack.peek()

                stack.push(item)
            else:
                postfix.append(item)

        while stack.isEmpty() == False:
            postfix.append(stack.pop())

        return ''.join(postfix)

    '''
    To convert infix to prefix, traverse from right to left.
    If value is found, keep it in separate array - prefix.
    If operator is found, check the topmost part of stack.
        If it is null, or the topmost is smaller OR EQUAL than current, just insert this operator to the stack.
        If it is not null, and the topmost is GREATER (not EQUAL) than current, pop and add to "prefix" array.
        Do above until you have come across an oeprator in stack which is lower OR EQUAL than current operator.
        Note: You keep popping as long as higher precedence is found on topmostOperand.

        Add the current item to the stack.
    '''
    def infixToPrefix(self, expression):
        stack = Stack()

        prefix = []
        for item in reversed(expression):
            if item in self.operands.keys():
                topmostOperand = stack.peek()

                while topmostOperand != None and self.operands[topmostOperand] > self.operands[item]:
                    prefix.append(stack.pop())
                    topmostOperand = stack.peek()

                stack.push(item)
            else:
                prefix.append(item)

        while stack.isEmpty() == False:
            prefix.append(stack.pop())

        return ''.join(reversed(prefix))

    '''
    To solve postfix, read from left to right.
    Push values in stack.
    If operator is found, take two values from stack (op2, then op1), and apply the operation. Then put the result back in stack.
    Last item in stack contains the final expression. Use eval to evaluate this expression.
    '''
    def solvePostfix(self, expression):
        stack = Stack()

        for item in expression:
            if item in self.operands.keys():
                op2 = stack.pop()
                op1 = stack.pop()

                stack.push('(' + str(op1) + item + str(op2) + ')')
            else:
                stack.push(item)

        return stack.pop()

    '''
    To solve prefix, read values from right to left.
    Push values in stack.
    If operator is found, take two values from stack (op1, then op2), and apply the operation. Then put the result back in stack.
    Last item in stack contains the final expression. Use eval to evaluate this expression.
    '''
    def solvePrefix(self, expression):
        stack = Stack()

        for item in reversed(expression):
            if item in self.operands.keys():
                op1 = stack.pop()
                op2 = stack.pop()

                stack.push('(' + str(op1) + item + str(op2) + ')')
            else:
                stack.push(item)

        return stack.pop()

if __name__ == '__main__':
    exp = Expressions()

    infixExpression = input()
    postfixExpression = exp.infixToPostfix(infixExpression)
    prefixExpression = exp.infixToPrefix(infixExpression)

    print('Infix to Postfix: ' + postfixExpression)
    print('Infix to Prefix: ' + prefixExpression)

    postfixToInfix = exp.solvePostfix(postfixExpression)
    print('Postfix to Infix: ' + postfixToInfix + '. Value: ' + str(eval(postfixToInfix)))

    prefixToInfix = exp.solvePrefix(prefixExpression)
    print('xPrefix to Infix: ' + prefixToInfix + '. Value: ' + str(eval(prefixToInfix)))
