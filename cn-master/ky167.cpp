#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

void display(vector<int>& ans){

    for(int i = ans.size() - 1; i >= 0; i--){
        cout << ans[i];
    }

    cout << endl;
}

vector<int> add(vector<int>& a, vector<int>& b){

    vector<int> ans;

    for(int i = 0, j = 0, carry = 0;
        carry > 0 || i < a.size() || j < b.size();
        i ++, j++){
        
        int t = carry;
        if(i < a.size()) t += a[i];
        if(j < b.size()) t += b[j];

        ans.push_back(t % 10);
        carry = t / 10;
    }

    return ans;
}

int main(){

    int a, n;

    while(cin >> a >> n){

        vector<int> num, ans = {0};

        for(int i = 0; i < n; i++){

            num.push_back(a);

            ans = add(ans, num);

            // display(num);
            // display(ans);
        }

        display(ans);
    }
    
    return 0;
}