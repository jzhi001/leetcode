#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

typedef long long LL;

int cnt(LL x){

    int ans = 0;

    for(int i = 2; i <= x / i; i++){
        if(x % i == 0){
            while(x % i == 0){
                ans ++;
                x /= i;
            }
        }
    }

    if(x > 1) ans ++;
    return ans;
}

int main(){
    
    LL n;
    while(cin >> n){
        cout << cnt(n) << endl;
    }

    return 0;
}