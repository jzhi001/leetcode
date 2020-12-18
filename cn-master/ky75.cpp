#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cmath>

using namespace std;

const int T = 1010, M = 110;

int t, m;
int cost[M], value[M], f[T];

int main(){

    while(cin >> t >> m){

        memset(f, 0, sizeof f);

        for(int i = 1; i <= m; i++){
            cin >> cost[i] >> value[i];
        }

        for(int i = 1; i <= m; i++){
            for(int j = t; j >= cost[i]; j--){
                f[j] = max(f[j], f[j - cost[i]] + value[i]);
            }
        }

        cout << f[t] << endl;
    }
    
    return 0;
}