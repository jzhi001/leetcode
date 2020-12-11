#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

vector<int> convert(string& s){

    vector<int> ans;

    for(char c : s){
        ans.push_back(c - '0');
    }

    return ans;
}

bool dividable(vector<int>& A, int k){

    int carry = 0;

    for(int& u : A){

        int t = carry * 10 + u;
        carry = t % k;
    }

    return carry == 0;
}

int main(){

    string s;

    while(cin >> s){

        if(s == "-1") break;

        vector<int> A = convert(s);

        bool any = false;

        for(int i = 2; i <= 9; i++){

            if(dividable(A, i)){
                if(any) cout << ' ';
                cout << i;
                any = true;
            }
        }

        if(!any) cout << "none";
        cout << endl;
    }
    
    return 0;

}