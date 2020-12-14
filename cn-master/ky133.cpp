#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> convert(string& s){

    vector<int> ans;

    for(int i = s.size() - 1; i >= 0; i--){
        ans.push_back(s[i] - '0');
    }
    
    return ans;
}

bool valid(vector<int>& A, vector<int>& B, int k){

    bool same = true;

    int len = min(k, (int)max(A.size(), B.size()));

    for(int i = 0; same && i < len; i++){
        
        int x = 0, y = 0;
        if(i < A.size()) x = A[i];
        if(i < B.size()) y = B[i];

        if(x != y) same = false;
    }

    return !same;
}

vector<int> add(vector<int>& a, vector<int>& b){

    vector<int> ans;

    for(int i = 0, j = 0, carry = 0;
        i < a.size() || j < b.size() || carry > 0;
        i ++, j ++){
        
        int t = carry;
        if(i < a.size()) t += a[i];
        if(j < b.size()) t += b[j];

        ans.push_back(t % 10);
        carry = t / 10;
    }

    return ans;
}

int main(){

    string a, b;
    int k;

    while(cin >> a >> b >> k){

        if(a == "0" && b == "0") break;

        vector<int> A = convert(a), B = convert(b);

        if(!valid(A, B, k)){
            cout << -1 << endl;
        }else{
            vector<int> ans = add(A, B);

            for(int i = ans.size() - 1; i >= 0; i--)
                cout << ans[i];
            cout << endl;
        }
    }
    
    return 0;

}