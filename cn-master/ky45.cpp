#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

typedef long long LL;

int main(){

    string s;
    while(cin >> s){

        LL ans = 0;

        for(LL i = s.size() - 1, p = 2; i >= 0; i--){

            int d = s[i] - '0';

            ans += d * (p - 1);

            p <<= 1;
        }

        cout << ans << endl;
    }
    
    return 0;

}