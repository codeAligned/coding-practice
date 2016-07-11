def reverseStringRecursive(subject):
    if len(subject) == 0:
        return ''

    firstHalf = subject[0]
    lastHalf = subject[1:]

    return reverseStringRecursive(lastHalf) + firstHalf

def reverseStringIterative(subject):
    size = len(subject)
    subject = [x for x in subject]

    for i in range(int((size + 1) / 2)):
        subject[i], subject[size - i - 1] = subject[size - i - 1], subject[i]

    return ''.join(subject)

string = 'Hello'
string = reverseStringRecursive(string)
print(string)


string = 'Helloe'
string = reverseStringIterative(string)
print(string)
