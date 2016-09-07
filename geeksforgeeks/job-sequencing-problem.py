"""
http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/

Given an array of jobs where every job has a deadline and associated profit
if the job is finished before the deadline.
It is also given that every job takes single unit of time,
so the minimum possible deadline for any job is 1.
How to maximize total profit if only one job can be scheduled at a time.

Examples:
Input: Four Jobs with following deadlines and profits
  JobID    Deadline      Profit
    a        4            20
    b        1            10
    c        1            40
    d        1            30
Output: Following is maximum profit sequence of jobs
        c, a


Input:  Five Jobs with following deadlines and profits
   JobID     Deadline     Profit
     a         2           100
     b         1           19
     c         2           27
     d         1           25
     e         3           15
Output: Following is maximum profit sequence of jobs
        c, a, e
"""


class Task:
    id = None
    deadline = None
    profit = None

    def __init__(self, id, deadline, profit):
        self.id = id
        self.deadline = deadline
        self.profit = profit

    def __lt__(self, other):
        if self.profit < other.profit:
            return True
        else:
            return False

    def doMaximumTasks(tasks):
        tasks.sort(reverse=True)

        time = 0
        for task in tasks:
            if task.deadline > time:
                print("Do task " + str(task.id))
                time += 1

        print("Overall time: " + str(time))


t = int(input())
tasks = [None] * t

for i in range(0, t):
    id, deadline, profit = input().split(' ')
    deadline = int(deadline)
    profit = int(profit)

    task = Task(id, deadline, profit)
    tasks[i] = task

Task.doMaximumTasks(tasks)
