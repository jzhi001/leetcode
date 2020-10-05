#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

const int N = 100;

int cases, n, x, a[N];

int main(){

    scanf("%d", &cases);
    
    for(int i = 1; i <= cases; i++){
    
        scanf("%d %d", &n, &x);
        
        vector<pair<int, int>> arr(n);
        
        int t;
        
        for(int j = 0; j < n; j++){
            scanf("%d", &t);
            arr[j] = {(int)ceil((double)t / x), j};
        }
        
        sort(arr.begin(), arr.end());
        
        printf("Case #%d: ", i);
        
        for(auto e: arr){
            printf("%d ", e.second + 1);
        }
        puts("");
    }

    return 0;
}