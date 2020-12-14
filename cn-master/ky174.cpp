#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int N = 1010;

int n, k;

vector<int> shuffle(vector<int>& a, int idx){

    vector<int> ans;

    for(int i = idx; i < n; i++) ans.push_back(a[i]);

    for(int i = 0; i < idx; i++) ans.push_back(a[i]);

    int len = n / 2;
    if(n % 2 == 1) len = (n - 1) / 2;

    reverse(ans.begin(), ans.begin() + len);

    return ans;
}

int main(){

    while(cin >> n >> k){

        if(n == 0 && k == 0) break;

        vector<int> a(n);

        for(int i = 1; i <= n; i++) a[i-1] = i;

        while(k --){
            int idx;
            cin >> idx;

            a = shuffle(a, idx);
        }

        for(int i = 0; i < n; i++){
            if(i) cout << ' ';
            cout << a[i];
        }
        cout << endl;
    }
    
    return 0;
}