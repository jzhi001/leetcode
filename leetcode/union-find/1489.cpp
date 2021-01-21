const int S = 0, T = 1, W = 2, ID = 3;

class UnionFindSet{

public:

    vector<int> p;

    UnionFindSet(int n){
        p = vector<int>(n);
        for(int i = 0; i < n; i++) p[i] = i;
    }

    int parent(int x){
        if(x != p[x]) p[x] = parent(p[x]);
        return p[x];
    }

    void Union(int a, int b){
        p[parent(a)] = parent(b);
    }

    bool allConnected(){
        for(int i = 1; i < p.size(); i++){
            if(parent(0) != parent(i)) return false;
        }
        return true;
    }
};

class Solution {
public:

    int mstWithout(vector<vector<int>>& edges, int n, int t){

        UnionFindSet ufs(n);

        int wt = 0;

        for(int i = 0; i < edges.size(); i ++){
            if(i == t) continue;

            auto e = edges[i];
            if(ufs.parent(e[S]) != ufs.parent(e[T])){
                wt += e[W];
                ufs.Union(e[S], e[T]);
            }
        }

        if(!ufs.allConnected()) return INT_MAX;

        return wt;
    }

    int mstWith(vector<vector<int>>& edges, int n, int t){

        UnionFindSet ufs(n);

        int wt = 0;

        ufs.Union(edges[t][S], edges[t][T]);
        wt += edges[t][W];

        for(int i = 0; i < edges.size(); i ++){
            if(i == t) continue;

            auto e = edges[i];
            if(ufs.parent(e[S]) != ufs.parent(e[T])){
                wt += e[W];
                ufs.Union(e[S], e[T]);
            }
        }

        if(!ufs.allConnected()) return INT_MAX;

        return wt;
    }

    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {

        for(int i = 0; i < edges.size(); i++) edges[i].push_back(i);

        sort(edges.begin(), edges.end(), [](vector<int>& a, vector<int>& b){
            return a[W] < b[W];
        });

        int minWt = mstWithout(edges, n, -1);

        vector<vector<int>> ans(2);

        for(int i = 0; i < edges.size(); i++){

            if(mstWithout(edges, n, i) > minWt) ans[0].push_back(edges[i][ID]);
            else if(mstWith(edges, n, i) == minWt) ans[1].push_back(edges[i][ID]);
        }

        return ans;
    }
};