#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <cmath>

using namespace std;

const int N = 1000010;

int n, a[N], f[N];

int main(){

    while(cin >> n){

        for(int i = 1; i <= n; i++) scanf("%d", &a[i]);

        f[1] = a[1];

        for(int i = 2; i <= n; i++){
            f[i] = a[i];

            if(f[i-1] > 0) f[i] += f[i-1];
        }

        int ans = f[1];

        for(int i = 2; i <= n; i++) ans = max(ans, f[i]);

        cout << ans << endl;
    }
    
    return 0;

}