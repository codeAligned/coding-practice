class QueuePython:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.insert(0, item)

    def pop(self):
        if self.isEmpty() == True:
            return None
        return self.items.pop()

    def isEmpty(self):
        return self.items == []

    def peek(self):
        if self.isEmpty() == True:
            return None
        return self.items[len(self.items) - 1]

class Queue:
    def __init__(self):
        self.maxSize = 10
        self.items = [None] * self.maxSize
        self.front = -1
        self.rear = -1

    def push(self, item):
        nextIndex = (self.rear + 1) % self.maxSize
        if nextIndex == self.front:
            return
        elif self.isEmpty() == True:
            self.front, self.rear = 0, 0
        else:
            self.rear = nextIndex

        self.items[self.rear] = item

    def pop(self):
        if self.isEmpty() == True:
            return None
        elif self.front == self.rear:
            item = self.peek()
            self.items[self.front] = None
            self.front, self.rear = -1, -1
            return item
        else:
            item = self.peek()
            self.items[self.front] = None
            self.front = (self.front + 1) % self.maxSize
            return item

    def peek(self):
        return self.items[self.front]

    def isEmpty(self):
        return self.front == self.rear == -1

    def size(self):
        if self.isEmpty() == True:
            return 0
        elif self.front > self.rear:
            return (self.maxSize - self.front) + self.rear + 1
        else:
            return self.rear - self.front + 1

if __name__ == '__main__':
    queue = Queue()

    for i in range(11):
        queue.push(i)
        print(str(queue.items) + '. Size: ' + str(queue.size()))

    for i in range(3):
        queue.pop()
        print(str(queue.items) + '. Size: ' + str(queue.size()))

    for i in range(20, 26):
        queue.push(i)
        print(str(queue.items) + '. Size: ' + str(queue.size()))

    for i in range(12):
        queue.pop()
        print(str(queue.items) + '. Size: ' + str(queue.size()))
