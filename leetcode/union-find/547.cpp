class Solution {
public:

    vector<int> p;

    int parent(int x){
        if(p[x] != x) p[x] = parent(p[x]);
        return p[x];
    }

    int findCircleNum(vector<vector<int>>& isConnected) {

        int R = isConnected.size(), C = isConnected[0].size();
        int N = R;
        
        p = vector<int>(N);

        for(int i = 0; i < N; i++) p[i] = i;

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(!isConnected[r][c]) continue;
                int pa = parent(r), pb = parent(c);
                if(pa != pb){
                    p[pa] = pb;
                }
            }
        }

        int ans = 0;

        vector<bool> st(N, false);

        for(int i = 0; i < N; i++){
            int pi = parent(i);
            if(!st[pi]){
                st[pi] = true;
                ans ++;
            }
        }

        return ans;
    }
};