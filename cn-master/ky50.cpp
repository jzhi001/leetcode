#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

typedef long long LL;

bool has7(int x){

    if(x % 7 == 0) return true;

    while(x){
        int d = x % 10;

        if(d == 7) return true;

        x /= 10;
    }

    return false;
}

int main(){

    int n;

    while(cin >> n){

        LL ans = 0;

        for(int i = 1; i <= n; i++){

            if(!has7(i)){
                // cout << i << endl;
                ans += i * i;
            }
        }

        cout << ans << endl;
    }


    return 0;

}