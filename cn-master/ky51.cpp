#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

typedef long long LL;

vector<int> convert(string& s){

    vector<int> ans;

    for(char c : s){
        ans.push_back(c - '0');
    }

    return ans;
}

LL compute(vector<int>& A){

    LL ans = 0, pow2 = 2;

    for(int i = A.size() - 1; i >= 0; i--){

        ans += A[i] * (pow2 - 1);

        pow2 *= 2;
    }

    return ans;
}

int main(){

    string s;

    while(cin >> s){

        if(s == "0") break;

        vector<int> A = convert(s);

        LL ans = compute(A);

        cout << ans << endl;
    }
    
    return 0;

}