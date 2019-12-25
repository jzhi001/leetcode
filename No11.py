class Solution:
    def maxArea(self, arr):
        result = 0
        a, b = 0, len(arr) - 1
        while a < b:
            curr = (b - a) * min(arr[a], arr[b])
            result = max(result, curr)
            if arr[a] < arr[b]:
                a += 1
            else:
                b -= 1
        return result
        
