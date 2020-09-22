class Solution(object):
    def search(self, arr, tar):
        
        def boundary(arr, lo, hi):
            if lo > hi:
                return -1
            mid = lo + (hi - lo) // 2
            if mid < len(arr)-1 and arr[mid] > arr[mid+1]:
                return mid
            L, R = boundary(arr, lo, mid-1), boundary(arr, mid+1, hi)
            return max(L, R)
            
        N = len(arr)
        if N == 0:
            return -1
        last = boundary(arr, 0, N-1)
        if last < 0:
            last = N-1
        mv = (last + 1) % N
        
        lo, hi = 0, N-1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            rmid = (mid + mv) % N
            x = arr[rmid]
            if x == tar:
                return rmid
            elif x > tar:
                lo, hi = lo, mid-1
            else:
                lo, hi = mid+1, hi
        else:
            return -1
            
            
