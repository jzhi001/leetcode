typedef long long LL;

class Solution {
public:
    int numWays(vector<string>& words, string target) {

        const int MOD = 1e9 + 7;
        int tarLen = target.size(), wordLen = words[0].size();

        vector<vector<int>> cnt(wordLen + 1, vector<int>(26, 0));

        for(string& w : words){
            for(int i = 0; i < w.size(); i++){
                cnt[i + 1][w[i] - 'a'] ++;
            }
        }

        vector<vector<int>> f(tarLen + 1, vector<int>(wordLen + 1, 0));

        for(int i = 0; i <= wordLen; i++){
            f[0][i] = 1;
        }

        for(int i = 1; i <= tarLen; i++){
            for(int j = 1; j <= wordLen; j++){
                int c = target[i-1] - 'a';
                f[i][j] = ((LL)f[i][j-1] + (LL)cnt[j][c] * f[i-1][j-1] ) % MOD;
            }
        }

        return f[tarLen][wordLen];
    }
};