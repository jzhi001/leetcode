#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int L = 10010, M = 110;

bool st[L];

int main(){

    int len, m;
    while(cin >> len >> m){

        memset(st, false, sizeof st);

        while(m --){
            int s, e;
            cin >> s >> e;

            for(int i = s; i <= e; i++) st[i] = true;
        }

        int ans = 0;

        for(int i = 0; i <= len; i++){
            if(!st[i]) ans ++;
        }

        cout << ans << endl;
    }
    
    return 0;

}