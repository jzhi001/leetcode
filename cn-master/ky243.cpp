#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

typedef long long LL;

const int N = 25;

vector<int> fact[N];

vector<int> times(vector<int> a, int b){

    reverse(a.begin(), a.end());

    vector<int> ans;

    for(int i = 0, carry = 0; i < a.size() || carry; i++){

        int t = carry;
        if(i < a.size()) t += a[i] * b;

        ans.push_back(t % 10);
        carry = t / 10;
    }

    reverse(ans.begin(), ans.end());

    return ans;
}

int main(){

    fact[1] = {1};

    for(int i = 2; i <= 20; i++) fact[i] = times(fact[i - 1], i);

    int n;
    cin >> n;

    while(n --){
        int x;
        cin >> x;

        vector<int> ans = fact[x];

        for(int& e : ans) cout << e;
        cout << endl;
    }
    
    return 0;

}