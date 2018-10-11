class Solution:
    def removeDuplicates(self, arr):
        if not arr:
            return 0
        newlen = 1
        i, curr = 0, arr[0]
        for x in arr:
            if x == curr:
                continue
            i, curr = i+1, x
            arr[i] = x
            newlen+=1
        return newlen
        
