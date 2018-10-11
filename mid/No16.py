class Solution:
    def threeSumClosest(self, arr, tar):
        arr.sort()
        result = arr[0] + arr[1] + arr[-1]
        #given first num, find the other two
        for i in range(len(arr) - 2):
            a = arr[i]
            j, k = i+1, len(arr)-1
            while j < k:
                b, c = arr[j], arr[k]
                curr = a + b + c
                if curr == tar:
                    return curr
                elif curr > tar:
                    k -= 1
                elif curr < tar:
                    j += 1 
                if abs(tar - curr) < abs(tar - result):
                    result = curr
        return result
