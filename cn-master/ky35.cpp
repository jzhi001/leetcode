#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 610;

int a[N];

int gcd(int a, int b){
    return b ? gcd(b, a % b) : a;
}

int main(){

    int n;

    while(cin >> n){

        if(n == 0) break;

        for(int i = 0; i < n; i++) cin >> a[i];

        int ans = 0;

        for(int i = 0; i < n - 1; i ++){
            for(int j = i + 1; j < n; j++){
                int x = a[i], y = a[j];

                int t = gcd(x, y);

                // cout << x << ' '  << y << ' ' << t << endl;

                if(t > 1) continue;

                ans ++;
            }
        }

        cout << ans << endl;
    }

    return 0;

}