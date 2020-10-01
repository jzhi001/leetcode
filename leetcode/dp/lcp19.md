
# [LCP 19. 秋叶收藏集](https://leetcode-cn.com/problems/UlBDOe/)



```c++
class Solution {
public:
    int minimumOperations(string leaves) {

        int n = leaves.size();

        vector<vector<int>> dp(n, vector<int>(3, -1));

        dp[0][0] = leaves[0] == 'y';

        dp[0][1] = dp[0][2] = dp[1][2] = INT_MAX;

        for(int i = 1; i < n; i++){

            int toRed = leaves[i] == 'y';
            int toYellow = leaves[i] == 'r';

            dp[i][0] = dp[i-1][0] + toRed;
            dp[i][1] = min(dp[i-1][0], dp[i-1][1]) + toYellow;

            if(i >= 2){
                dp[i][2] = min(dp[i-1][1], dp[i-1][2]) + toRed;
            }
        }

        return dp[n-1][2];
    }
};
```