#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

typedef pair<string, string> PSS;

vector<PSS> cases;

vector<int> convert(string& s){
    vector<int> ans;

    for(int i = s.size() - 1; i >= 0; i--){
        ans.push_back(s[i] - '0');
    }

    return ans;
}

int carryCnt(vector<int>& a, vector<int>& b){

    int ans = 0;

    for(int i = 0, j = 0, carry = 0;
        carry > 0 || i < a.size() || j < b.size();
        i ++, j ++){

        if(carry > 0) ans ++;

        int t = carry;
        if(i < a.size()) t += a[i];
        if(j < b.size()) t += b[j];

        carry = t / 10;
    }

    return ans;
}

int main(){

    string a, b;

    while(cin >> a >> b){
        cases.push_back({a, b});
    }

    if(cases.size() > 1) cases.pop_back();

    for(PSS& p : cases){

        vector<int> A = convert(p.first), B = convert(p.second);

        int ans = carryCnt(A, B);

        if(ans == 0) cout << "NO";
        else cout << ans;

        cout << " carry operation";

        if(ans > 1) cout << 's';

        cout << '.' << endl;
    }
    
    return 0;
}