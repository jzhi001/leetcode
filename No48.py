class Solution:
    def rotate(self, m):
        N = len(m)
        layer = N // 2
        for nw in range(layer):
            rt = N - 1 - nw
            n = N - (2 * nw) - 1
            for off in range(n):
                m[nw][nw+off], m[nw+off][rt], m[rt][rt-off], m[rt-off][nw] = m[rt-off][nw], m[nw][nw+off], m[nw+off][rt], m[rt][rt-off]
        
