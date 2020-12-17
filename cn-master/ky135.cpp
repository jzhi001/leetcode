#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

typedef long long LL;

string convert(LL x, int m){

    string ans;

    while(x){
        ans += (char)(x % m + '0');
        x /= m;
    }

    if(ans.empty()) ans += '0';

    reverse(ans.begin(), ans.end());

    return ans;
}

int main(){

    int m;
    LL a, b;

    while(cin >> m){

        if(m == 0) break;

        cin >> a >> b;

        LL c = a + b;

        cout << convert(c, m) << endl;
    }
    
    return 0;
}