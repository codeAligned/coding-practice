"""
You have a bunch of tasks that need to be completed.
You know exactly how long each task will take to complete.
There are N people there to help you complete the tasks.
Find out how quickly all the tasks can be completed.

E.g. [3, 4, 1, 2, 6, 7, 2, 1, 5] and N=3
"""


import queue


def doTasks(tasks, n):
    tasks.sort(reverse=True)
    pq = queue.PriorityQueue(n)

    i = 0
    length = len(tasks)
    time = 0

    while pq.full() is False and pq.qsize() <= length:
        pq.put(tasks[i])
        i += 1

    while pq.empty() is False:
        taskTime = pq.get()
        time += taskTime

        # TODO: Dustin - task scheduler.
        for i in range(0, pq.qsize()):
            pq[i] -= taskTime

        if i < length:
            pq.put(tasks[i])


n = int(input())
tasks = [int(x) for x in input().split(' ')]
time = doTasks(tasks, n)
print(time, n)
