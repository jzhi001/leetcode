#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

typedef long long LL;

const int MOD = 10000;

vector<LL> a;

int a0, a1, p, q, k;

int main(){

    cin >> a0 >> a1 >> p >> q >> k;

    a.push_back(a0);
    a.push_back(a1);

    for(int i = 2; i <= k; i++){

        LL x = (p * a[i - 1]) % MOD;
        x += (q * a[i - 2]) % MOD;
        x %= MOD;

        a.push_back(x);
    }

    cout << a[k];
    
    return 0;
}