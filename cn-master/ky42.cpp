#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

void display(vector<int>& A){
    for(int& x : A) cout << x;
    cout << endl;
}

bool isZero(vector<int>& A){
    return A.size() == 1 && A[0] == 0;
}

vector<int> convert(string& s){

    vector<int> ans;

    for(char c : s){
        ans.push_back(c - '0');
    }

    return ans;
}

vector<int> div2(vector<int>& A){

    vector<int> ans;

    for(int i = 0, carry = 0; i < A.size(); i++){

        int t = carry * 10 + A[i];

        if(ans.size() || t / 2 != 0) ans.push_back(t / 2);

        carry = t % 2;
    }

    if(ans.empty()) ans.push_back(0);

    // reverse(ans.begin(), ans.end());

    return ans;
}

vector<int> binary(vector<int>& A){

    vector<int> ans;

    while(!isZero(A)){
        ans.push_back(A.back() % 2);

        A = div2(A);
    }

    if(ans.empty()) ans.push_back(0);

    reverse(ans.begin(), ans.end());

    return ans;
}

int main(){

    string s;

    while(cin >> s){

        vector<int> A = convert(s);

        A = binary(A);

        display(A);
    }
    
    return 0;
}