#include <cstdio>
#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<int, bool> m;

bool dp(int x){
    if(x < 2020) return false;

    if(m.count(x)) return m[x];

    m[x] = dp(x - 2020) || dp(x - 2021);

    return m[x];
}

int main(){

    int t;
    cin >> t;

    m[2020] = true;
    m[2021] = true;

    while(t --){
        int x;
        cin >> x;

        if(dp(x)) puts("YES");
        else puts("NO");
    }

    return 0;
}