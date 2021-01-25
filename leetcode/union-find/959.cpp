class Solution {
public:

    vector<int> p;
    int n;

    int parent(int x){
        if(p[x] != x) p[x] = parent(p[x]);
        return p[x];
    }

    void merge(int a, int b){
        p[parent(a)] = parent(b);
    }

    // i is clockwised
    int id(int r, int c, int i){
        return (r * n + c) * 4 + i;
    }

    int regionsBySlashes(vector<string>& grid) {

        n = grid.size();

        int tot = n * n * 4;
        p = vector<int>(tot);

        for(int i = 0; i < tot; i++) p[i] = i;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){

                if(r > 0) merge(id(r, c, 0), id(r-1, c, 2));
                if (r < n - 1) merge(id(r, c, 2), id(r+1, c, 0));
                if (c > 0) merge(id(r, c, 3), id(r, c-1, 1));
                if(c < n - 1) merge(id(r, c, 1), id(r, c+1, 3));


                if(grid[r][c] == '/'){
                    merge(id(r, c, 0), id(r, c, 3));
                    merge(id(r, c, 1), id(r, c, 2));
                }else if(grid[r][c] == '\\'){
                    merge(id(r, c, 0), id(r, c, 1));
                    merge(id(r, c, 2), id(r, c, 3));
                }else{
                    merge(id(r, c, 0), id(r, c, 1));
                    merge(id(r, c, 0), id(r, c, 2));
                    merge(id(r, c, 0), id(r, c, 3));
                }
            }
        }

        unordered_set<int> st;
        for(int i = 0; i < tot; i++) st.insert(parent(i));

        return st.size();
    }
};