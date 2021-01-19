
struct Edge{
    int a, b, w;

    bool operator<(const Edge& t) const{
        return w < t.w; 
    }
};

class Solution {
public:

    vector<Edge> edges;
    vector<int> p;

    int parent(int x){
        if(x != p[x]) p[x] = parent(p[x]);
        return p[x];
    }

    int dist(vector<int>& a, vector<int>& b){
        return abs(a[0] - b[0]) + abs(a[1] - b[1]);
    }

    int minCostConnectPoints(vector<vector<int>>& points) {

        for(int i = 0; i < points.size(); i++){
            for(int j = i + 1; j < points.size(); j++){
                edges.push_back({i, j, dist(points[i], points[j])});
            }
        }

        sort(edges.begin(), edges.end());

        p = vector<int>(points.size());

        for(int i = 0; i < p.size(); i++) p[i] = i;

        int ans = 0;

        for(Edge e : edges){
            int pa = parent(e.a), pb = parent(e.b);

            if(pa != pb){
                p[pa] = pb;
                ans += e.w;
            }
        }

        return ans;
    }
};