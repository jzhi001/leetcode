class Solution {
public:
    int rob(vector<int>& nums) {

        int n = nums.size();

        if(n == 0) return 0;

        vector<int> f(n + 1, 0);
        f[1] = nums[0];

        for(int i = 2; i <= n; i++){
            f[i] = max(f[i - 1], nums[i-1] + f[i - 2]);     
        }

        // for(int i = 1; i <= n; i++) cout << f[i] << ' ';
        // cout << endl;

        return f[n];
    }
};