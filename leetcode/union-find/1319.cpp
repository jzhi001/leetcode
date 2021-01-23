const int N = 1e5 + 10;

class Solution {
public:

    int p[N];

    int parent(int x){
        if(p[x] != x) p[x] = parent(p[x]);
        return p[x];
    }

    int makeConnected(int n, vector<vector<int>>& conns) {

        int E = conns.size();
        if(E < n - 1) return -1;

        for(int i = 0; i < n; i++) p[i] = i;

        for(auto& e : conns){
            p[parent(e[0])] = parent(e[1]);
        }

        unordered_set<int> st;

        for(int i = 0; i < n; i++) st.insert(parent(i));

        return st.size() - 1;
    }
};