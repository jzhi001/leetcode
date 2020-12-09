#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

vector<int> convert(string s){

    vector<int> ans;

    for(int i = 0; i < s.size(); i++){
        ans.push_back(s[i] - '0');
    }

    return ans;
}

bool isZero(vector<int> num){
    return num.size() == 1 && num[0] == 0;
}

vector<int> div2(vector<int> num){

    vector<int> ans;

    int x = 0;

    for(int i = 0; i < num.size(); i++){
        int cur = x * 10 + num[i];

        ans.push_back(cur / 2);
        x = cur % 2;
    }

    while(ans.size() > 1 && ans.front() == 0) ans.erase(ans.begin());

    return ans;
}

vector<int> binary(vector<int> num){

    vector<int> ans;

    while(!isZero(num)){
        ans.push_back(num.back() % 2);
        num = div2(num);
    }

    if(ans.empty()) ans.push_back(0);

    reverse(ans.begin(), ans.end());

    return ans;
}

void display(vector<int> A){
    for(auto x : A) cout << x;
    cout << endl;
}

int main(){

    string s;

    while(cin >> s){

        vector<int> A = convert(s);

        // display(A);

        vector<int> ans = binary(A);

        for(int& e : ans) cout << e;

        cout << endl;
    }

    return 0;

}