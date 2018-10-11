class Solution:
    def isPalindrome(self, s):
        
        def fmt(x):
            return x if x.isdecimal() else x.lower()
                
        
        s = [x for x in s if x.isalnum()]
        lo, hi = 0, len(s) - 1
        while lo < hi:
            x, y = fmt(s[lo]), fmt(s[hi])
            if x != y:
                return False
            lo += 1
            hi -= 1
        return True
        
