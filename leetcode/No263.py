class Solution(object):
    def isUgly(self, x):
        if x == 0:
            return False
        while x % 2 == 0:
            x /= 2
        while x % 3 == 0:
            x /= 3
        while x % 5 == 0:
            x /= 5
        return x == 1
