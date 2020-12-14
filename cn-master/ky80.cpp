#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <cctype>

using namespace std;

int toDecimal(string& s){

    int ans = 0;

    for(int i = s.size() - 1, pow = 1; i >= 0; i--, pow *= 16){

        int t = 0;

        if(isdigit(s[i])) t = s[i] - '0';
        else t = s[i] - 'A' + 10;

        ans += t * pow;
    }

    return ans;
}

int main(){

    string s;

    while(cin >> s){

        if(s[0] == '0' && s[1] == 'x') s = s.substr(2);

        cout << toDecimal(s) << endl;
    }
    
    return 0;

}