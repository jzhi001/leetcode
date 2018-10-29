class Solution(object):
    def divide(self, x, y):
        neg = bool(x < 0) ^ bool(y < 0)
        x, y = abs(x), abs(y)
        r, po = 0, 32
        t = y << po
        while x >= y:
            while x < t:
                po -= 1
                t >>= 1
            r += 1 << po
            x -= t
        if neg:
            r = -r
            r = max(r, -2**31)
        else:
            r = min(r, 2**31 - 1)
        return r
        
