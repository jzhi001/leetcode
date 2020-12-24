#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

const int N = 1010;

int n, a[N], f[N];

int main(){

    cin >> n;

    for(int i = 0; i < n; i++) cin >> a[i];

    for(int i = 0; i < n; i++){
        
        for(int j = 0; j < i; j++){
            if(a[i] > a[j])
                f[i] = max(f[i], f[j]);
        }

        f[i] += a[i];
    }

    // for(int i = 0; i < n; i++) cout << f[i] << ' ';
    // cout << endl;

    int ans  = 0;

    for(int i = 0; i < n; i++) ans = max(ans, f[i]);

    cout << ans << endl;

    return 0;
}