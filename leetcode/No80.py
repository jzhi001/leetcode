class Solution:
    def removeDuplicates(self, arr):
        print(arr)
        newlen = len(arr)
        lo = 0
        while lo < newlen:
            hi, x = lo, arr[lo]
            while hi < newlen - 1 and arr[hi + 1] == x:
                hi += 1
            if hi - lo > 1:
                nmv = hi - lo - 1
                newlen -= nmv
                for i in range(lo+2, len(arr) - nmv):
                    arr[i] = arr[i+nmv]
                lo += 2
            else:
                lo = hi + 1
            
        print(arr)
        return newlen
        
