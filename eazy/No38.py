class Solution(object):
    def countAndSay(self, n):
        if n == 1:
            return '1'
        result = '1'
        for i in range(n-1):
            newr = []
            N, idx = len(result), 0
            while idx < N:
                pt = idx
                while pt < N-1 and result[pt] == result[pt+1]: #dup
                    pt+=1
                delta = pt - idx + 1
                newr.append(str(delta))
                newr.append(result[idx])
                idx = pt + 1
            result = ''.join(newr)
        return result
        
