#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

const int N = 1010, M = 100010, INF = 0x3f3f3f3f;

int n, m, S, T;

int g[N][N], w[N][N];

int dist[N], cost[N];
bool st[N];

void dijkstra(int& minDist, int& minCost){
    memset(st, false, sizeof st);
    memset(dist, INF, sizeof dist);
    memset(cost, INF, sizeof cost);
    dist[S] = 0;
    cost[S] = 0;

    priority_queue<PII, vector<PII>, greater<PII>> heap;
    heap.push({0, S});

    while(heap.size()){
        PII p = heap.top();
        heap.pop();

        int u = p.second;

        if(st[u]) continue;
        st[u] = true;

        for(int t = 1; t <= 1000; t++){

            int curDist = dist[u] + g[u][t];
            int curCost = cost[u] + w[u][t];

            if(dist[t] > curDist){

                dist[t] = curDist;
                cost[t] = curCost;
                heap.push({dist[t], t});

            }else if(dist[t] == curDist && cost[t] > curCost){

                cost[t] = curCost;
                heap.push({dist[t], t});
            }
        }
    }

    minDist = dist[T];
    minCost = cost[T];
}

void init(){
    memset(g, INF, sizeof g);
    memset(w, INF, sizeof w);
}

// 邻接矩阵会爆内存
int main(){

    while(scanf("%d%d", &n, &m) != EOF){

        if(n == 0 && m == 0) break;

        init();

        while(m --){
            int a, b, d, p;
            scanf("%d%d%d%d", &a, &b, &d, &p);

            if(d < g[a][b]){
                g[a][b] = g[b][a] = d;
                w[a][b] = w[b][a] = p;
            }else if(d == g[a][b] && p < w[a][b]){
                w[a][b] = w[b][a] = p;
            }
        }

        scanf("%d%d", &S, &T);

        int minDist, minCost;

        dijkstra(minDist, minCost);

        printf("%d %d", minDist, minCost);
    }
    
    return 0;
}