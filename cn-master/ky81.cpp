#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<int> ans = {0};

vector<int> convert(string& s){

    vector<int> ans;

    for(int i = s.size() - 1; i >= 0; i--){
        ans.push_back(s[i] - '0');
    }

    return ans;
}

vector<int> add(vector<int>& a, vector<int>& b){

    vector<int> ans;

    for(int i = 0, j = 0, carry = 0; 
        carry > 0 || i < a.size() || j < b.size(); 
        i++, j++){

        int t = carry;
        if(i < a.size()) t += a[i];
        if(j < b.size()) t += b[j];

        ans.push_back(t % 10);
        carry = t / 10;
    }

    return ans;    
}

int main(){

    string s;

    while(cin >> s){

        if(s == "0") break;

        vector<int> num = convert(s);

        ans = add(ans, num);
    }

    while(ans.size() > 1 && ans.back() == 0) ans.pop_back();

    reverse(ans.begin(), ans.end());

    for(int& x : ans) cout << x;
    
    return 0;
}