#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cctype>

using namespace std;

typedef long long LL;

int a, b;

LL toDecimal(string& s, int radix){
    
    LL ans = 0;

    for(char c : s){
        c = tolower(c);

        int d;
        if(isdigit(c)) d = c - '0';
        else d = c - 'a' + 10;

        ans = ans * radix + d;
    }

    return ans;
}

string toTarRadix(LL x, int radix){

    string ans;

    while(x){

        int d = x % radix;

        if(d < 10) ans += (char)(d + '0');
        else ans += (char)(d - 10 + 'A');

        x /= radix;
    }

    reverse(ans.begin(), ans.end());

    return ans;
}

int main(){

    string num;

    cin >> a >> num >> b;

    LL d = toDecimal(num, a);

    cout << toTarRadix(d, b);
    
    return 0;
}