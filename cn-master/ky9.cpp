#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

typedef pair<int, int> PII;

const int N = 110;

int n;

PII all[N];

int main(){

    cin >> n;

    for(int i = 0; i < n; i++){
        
        PII& p = all[i];
        cin >> p.second >> p.first;
    }

    sort(all, all + n);

    for(int i = 0; i < n; i++){
        PII& p = all[i];
        printf("%d %d\n", p.second, p.first);
    }
    
    return 0;
}