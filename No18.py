class Solution(object):
    def fourSum(self, arr, tar):
        result, N = [], len(arr)
        if N < 4:
            return result
        arr.sort()
        
        for i in range(0, N-3):
            a = arr[i]
            if i > 0 and a == arr[i-1]:
                continue
            for j in range(i+1, N-2):
                b = arr[j]
                if j-1 > i and b == arr[j-1]:
                    continue
                L, R = j+1, N-1
                
                while L < R:
                    if L-1 != j and arr[L] == arr[L-1]: #remove dup
                        L += 1
                        continue
                    s = a + b + arr[L] + arr[R]
                    if s == tar:
                        #print(i, j, L, R)
                        result.append([a, b, arr[L], arr[R]])
                        L += 1
                    elif s > tar:
                        R -= 1
                    else:
                        L += 1
        return result
        
