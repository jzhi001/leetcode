class Solution {
public:

    unordered_map<int, int> p;

    int parent(int x){
        if(p[x] != x) p[x] = parent(p[x]);
        return p[x];
    }

    int removeStones(vector<vector<int>>& stones) {

        unordered_map<int, int> row, col;

        int id = 0;

        for(auto& e : stones){
            int x = e[0], y = e[1];
            int u = id ++;

            p[u] = u;

            if(row.count(x)){
                p[parent(row[x])] = u;
            }
            row[x] = u;

            if(col.count(y)){
                p[parent(col[y])] = u;
            }
            col[y] = u;
        }

        unordered_set<int> st;

        for(int i = 0; i < id; i++){
            // cout << parent(i) << endl;
            st.insert(parent(i));
        }

        return stones.size() - st.size();
    }
};