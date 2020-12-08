#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 10;

string s;
vector<char> path;
bool st[N];

void dfs(int u){
    if(u == s.size()){
        for(char& e : path) cout << e;
        cout << endl;
        return;
    }
    
    for(int i = 0; i < s.size(); i++){
        if(st[i]) continue;
        
        st[i] = true;
        path.push_back(s[i]);
        
        dfs(u + 1);
        
        st[i] = false;
        path.pop_back();
    }
}

int main(){
    
    cin >> s;

    sort(s.begin(), s.end());
    
    dfs(0);
    
    return 0;
}