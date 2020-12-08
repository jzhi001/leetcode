#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

typedef pair<int, int> PII;

const int N = 10010;

int nodeCnt, edgeCnt;
int indegree[N], p[N];
bool st[N];

int parent(int x){
    if(p[x] != x) p[x] = parent(p[x]);
    return p[x];
}

bool valid(){

    if(nodeCnt != edgeCnt + 1) return false;

    int root = -1;

    for(int i = 1; i < N; i++){
        if(!st[i]) continue;

        // cout << i << ' ';
        // cout << indegree[i] << ' ';
        // cout << parent(i) << endl;

        if(indegree[i] > 1) return false;

        if(root == -1) root = parent(i);
        else if(root != parent(i)) return false;
    }

    return true;
}

int main(){

    for(int i = 0; i < N; i++) p[i] = i;

    int a, b, c = 1;

    while(cin >> a >> b){
        if(a == -1 && b == -1) break;
        else if(a == 0 && b == 0){

            printf("Case %d is ", c);
            if(nodeCnt != 0 && !valid()) printf("not ");
            printf("a tree.\n");


            c ++;
            nodeCnt = 0; edgeCnt = 0;
            memset(indegree, 0, sizeof indegree);
            memset(st, false, sizeof st);
            for(int i = 0; i < N; i++) p[i] = i;
        }else{

            if(!st[a]){
                nodeCnt ++;
                st[a] = true;
            }

            if(!st[b]){
                nodeCnt ++;
                st[b] = true;
            }

            edgeCnt ++;

            indegree[b] ++;

            int pa = parent(a), pb = parent(b);

            if(pa != pb) p[pa] = pb;
        }
    }
    
    return 0;
}