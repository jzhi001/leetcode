#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
#include <queue>

using namespace std;

const int N = 1010;

typedef pair<int, int> PII;

int n, d, tree[N];

vector<int> bfs(){

    vector<int> ans;

    queue<PII> q;
    q.push({1, 1});

    while(q.size()){

        PII& p = q.front();
        q.pop();

        int i = p.first, lv = p.second;

        if(lv > d) break;
        else if(lv == d) ans.push_back(tree[i]);

        if(i * 2 <= n) q.push({i * 2, lv + 1});
        if(i * 2 + 1 <= n) q.push({i * 2 + 1, lv + 1});
    }

    return ans;
}

int main(){

    while(cin >> n){

        for(int i = 1; i <= n; i++) cin >> tree[i];

        cin >> d;

        vector<int> ans = bfs();

        if(ans.empty()) cout << "EMPTY";
        else {
            for(int& x : ans) cout << x << ' ';
        }
        
        cout << endl;
    }
    
    return 0;

}