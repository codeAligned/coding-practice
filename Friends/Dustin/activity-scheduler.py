"""
You are given n activities with their start and finish times.
Select the max number of activities that can be performed by a single person,
assuming that a person can only work on a single activity at a time.

Example:
Consider the following 6 activities.
start[]  =  {1, 3, 0, 5, 8, 5}
finish[] =  {2, 4, 6, 7, 9, 9}

The maximum set of activities that can be executed
by a single person is {0, 1, 3, 4}
"""


class Activity:
    start = None
    end = None
    position = None

    def __init__(self, start, end, position):
        self.start = start
        self.end = end
        self.position = position

    def __lt__(self, other):
        if self.end < other.end:
            return True
        elif self.end == other.end and self.start < other.start:
            return True
        else:
            return False

    def makeActivityList(startlist, endlist):
        length = len(startlist)
        activityList = [None] * length

        for i in range(0, length):
            activity = Activity(startlist[i], endlist[i], i)
            activityList[i] = activity

        return activityList

    def sortActivityList(activityList):
        activityList.sort()

    def printActivityList(activityList):
        for activity in activityList:
            print(str(activity.start) + " " + str(activity.end))

    def scheduleActivities(activityList):
        Activity.sortActivityList(activityList)

        endTime = -1
        for x in activityList:
            if x.start > endTime:
                endTime = x.end
                print(x.position)


startlist = [int(x) for x in input().split(' ')]
endlist = [int(x) for x in input().split(' ')]
activityList = Activity.makeActivityList(startlist, endlist)
Activity.scheduleActivities(activityList)
