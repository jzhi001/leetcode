#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

typedef pair<string, int> PSI;

vector<PSI> substrCnt(string& s){

    unordered_map<string, int> cnt;

    for(int i = 0; i < s.size(); i++){

        for(int j = i; j < s.size(); j++){

            string sub = s.substr(i, j - i + 1);

            cnt[sub] ++;
        }
    }

    vector<PSI> ans;

    for(auto p : cnt){
        if(p.second > 1)
            ans.push_back(p);
    }

    sort(ans.begin(), ans.end());

    return ans;
}

int main(){
    
    string s;

    while(cin >> s){

        vector<PSI> ans = substrCnt(s);

        for(PSI& p : ans){
            string u = p.first;
            int n = p.second;

            cout << u << ' ' << n << endl;
        }
    }

    return 0;
}