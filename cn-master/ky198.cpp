#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

typedef pair<int, int> PII;

const int N = 1010;

int n;
PII all[N];

int main(){

    while(cin >> n){

        for(int i = 0; i < n; i++){
            PII& p = all[i];
            cin >> p.first >> p.second;
        }

        sort(all, all + n);

        PII& ans = all[0];

        printf("%d %d\n", ans.first, ans.second);
    }
    
    return 0;

}