class Solution:
    def removeElement(self, arr, tar):
        newlen = len(arr)
        
        i = 0
        while i < newlen:
            x = arr[i]
            if x != tar:
                i += 1
                continue
            #continuous?
            hi = i
            while hi < newlen - 1 and arr[hi] == arr[hi+1]:
                hi += 1
            nrem = hi - i + 1
            newlen -= nrem
            for idx in range(i, newlen):
                arr[idx] = arr[idx + nrem]
            
        return newlen
        
