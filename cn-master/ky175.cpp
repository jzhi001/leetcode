#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 1010;

int n, m;
int p[N];

int parent(int x){
    if(p[x] != x) p[x] = parent(p[x]);

    return p[x];
}

bool valid(){

    int rt = -1;

    for(int i = 1; i <= n; i++){
        int pi = parent(i);

        if(rt == -1) rt = pi;
        else if(rt != pi) return false;
    }

    return true;
}

int main(){

    while(cin >> n >> m){

        if(n == 0 && m == 0) break;

        for(int i = 0; i < N; i++) p[i] = i;

        while(m --){
            int x, y;
            cin >> x >> y;

            int px = parent(x), py = parent(y);

            if(px != py) p[px] = py;
        }

        if(valid()) puts("YES");
        else puts("NO");
    }
    
    return 0;
}