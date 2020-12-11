#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

const int N = 610, M = 10010, INF = 0x3f3f3f3f;
const int S = 1, T = 2;

int n, m, ans;
int g[N][N], leader[N];
bool st[N];

void dfs(int u, int cost, int ld){

    st[u] = true;

    if(u == T){
        ans = min(ans, cost);
    }else{

        for(int t = 1; t <= n; t++){

        if(st[t] || (ld == 2 && leader[t] != ld) || cost + g[u][t] >= ans) 
            continue;

            dfs(t, cost + g[u][t], leader[t]);
        }
    }

    st[u] = false;
}

int main(){

    while(scanf("%d", &n) != EOF){

        if(n == 0) break;

        scanf("%d", &m);

        ans = INF;
        memset(g, INF, sizeof g);

        while(m --){
            int a, b, t;
            scanf("%d%d%d", &a, &b, &t);

            g[a][b] = g[b][a] = min(g[a][b], t);
        }

        for(int i = 1; i <= n; i++){
            scanf("%d", &leader[i]);
        }

        for(int i = 1; i <= n; i++){
            if(leader[i] == 2) continue;
        }

        dfs(S, 0, leader[S]);

        if(ans == INF) ans = -1;  
        printf("%d\n", ans);
    }
    
    return 0;
}