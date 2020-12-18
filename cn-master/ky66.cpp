#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cmath>

using namespace std;

const int C = 1010, N = 110;

int c, n;
int price[N], rate[N], f[C];

int main(){

    while(cin >> c >> n){

        memset(f, 0, sizeof f);

        for(int i = 1; i <= n; i++){
            cin >> price[i] >> rate[i];
        }

        for(int i = 1; i <= n; i++){
            for(int j = c; j >= price[i]; j--){
                f[j] = max(f[j], f[j - price[i]] + rate[i]);
            }
        }

        cout << f[c] << endl;   
    }
    
    return 0;
}