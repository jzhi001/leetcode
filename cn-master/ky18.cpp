#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

typedef long long LL;

vector<int> convert(string& s){
    vector<int> ans;

    for(int i = 0; i < s.size(); i++){
        ans.push_back(s[i] - '0');
    }

    return ans;
}

int main(){

    string a, b;

    while(cin >> a >> b){
        vector<int> A = convert(a), B = convert(b);

        LL ans = 0;

        for(int& x : A){
            for(int& y : B){
                ans += x * y;
            }
        }

        cout << ans << endl;
    }
    
    return 0;

}