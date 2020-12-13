#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

string recur(int x){

    string ans;

    for(int i = 31; i >= 0; i--){

        if(((x >> i) & 1) == 0) continue;  

        if(ans.size()) ans += '+';
        ans += '2';

        if(i == 1) continue;

        ans += '(';

        if(i == 0) ans += '0';
        else if(i == 2) ans += '2';
        else ans += recur(i);

        ans += ')';
    }

    // cout << x << ' ' << ans << endl;

    return ans;
}

int main(){

    int n;

    while(cin >> n){

        cout << recur(n) << endl;
    }
    
    return 0;
}