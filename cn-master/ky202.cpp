#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

typedef pair<int, int> PII;

const int N = 1010;

int n;
unordered_map<int, int> k;

int main(){

    for(int i = 0; i < 2; i++){
        cin >> n;

        while(n --){
            int a, b;
            cin >> a >> b;

            k[b] += a;
        }
    }

    vector<PII> ans;

    for(auto p : k) ans.push_back(p);

    sort(ans.begin(), ans.end());

    for(int i = ans.size() - 1; i >= 0; i--){
        PII& p = ans[i];

        if(p.second == 0) continue;

        printf("%d %d ", p.second, p.first);
    }

    return 0;

}