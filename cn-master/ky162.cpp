#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

bool valid(int x){

    int ans = 0;

    for(int i = 1; i <= x / i; i++){

        if(x % i != 0) continue;

        ans += i;

        int t = x / i;
        if(t != i && t != x) ans += t;
    }

    return ans == x;
}

int main(){

    int n;

    while(cin >> n){

        bool any = false;

        for(int i = 2; i <= n; i++){
            if(!valid(i)) continue;
            if(any) cout << ' ';
            cout << i;
            any = true;
        }

        cout << endl;
    }
    
    return 0;
}