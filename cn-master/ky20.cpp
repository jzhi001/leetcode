#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<int> eq, gt;

int sum(int x){

    // cout << "cur: " << x << endl;

    int ans = 0;

    for(int i = 1; i <= x / i; i++){
        if(x % i != 0) continue;

        // cout << i << ' ';

        ans += i;

        if(x / i != i && x != x / i){
            ans += x / i;
            // cout << x / i << ' ';
        }
    }

    // cout << endl << "ans " << ans << endl;

    return ans;
}

int main(){
    
    for(int i = 2; i <= 60; i++){

        int t = sum(i);

        if(t == i) eq.push_back(i);
        else if(t > i) gt.push_back(i);
    }

    sort(eq.begin(), eq.end());
    sort(gt.begin(), gt.end());

    printf("E:");

    for(int i = 0; i < eq.size(); i++){
        printf(" %d", eq[i]);
    }

    printf("\nG:");

    for(int i = 0; i < gt.size(); i++){
        printf(" %d", gt[i]);
    }

    return 0;
}