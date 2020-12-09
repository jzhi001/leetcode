#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int N = 1005;

vector<int> fact[N];

void display(vector<int>& a){
    for(int& x : a) cout << x;
    cout << endl;
}

vector<int> convert(int n){
    vector<int> ans;

    while(n){
        ans.push_back(n % 10);
        n /= 10;
    }

    reverse(ans.begin(), ans.end());

    return ans;
}

vector<int> times(vector<int> a, int b){

    reverse(a.begin(), a.end());

    vector<int> ans;

    int t = 0;

    for(int i = 0; t || i < a.size(); i++){

        if(i < a.size()) t += a[i] * b;

        ans.push_back(t % 10);

        t /= 10;
    }

    while(ans.size() > 1 && ans.back() == 0) ans.pop_back();

    reverse(ans.begin(), ans.end());

    return ans;
}

vector<int> factorize(int n){
    if(fact[n].size()) return fact[n];

    vector<int> prev = factorize(n - 1);
    vector<int> ans = times(prev, n);
    fact[n] = ans;

    return ans;
}

int main(){

    fact[0] = fact[1] = {1};
    
    int n;

    while(cin >> n){
        vector<int> ans = factorize(n);
        display(ans);
    }

    return 0;
}