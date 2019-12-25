class Solution:
    def strStr(self, s, tar):
        if s == tar and s == '':
            return 0
        offt = len(tar) - 1
        for i in range(len(s)):
            x = s[i]
            last = i + offt
            if last < len(s) and s[i:last+1] == tar:
                return i
        return -1
        
