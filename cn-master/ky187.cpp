#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

typedef long long LL;

vector<int> binary(LL x){

    vector<int> ans;

    while(x){

        ans.push_back(x % 2);

        x /= 2;
    }

    while(ans.size() > 1 && ans.back() == 0) ans.pop_back();

    reverse(ans.begin(), ans.end());

    return ans;   
}

int main(){

    LL x;

    while(cin >> x){

        vector<int> ans = binary(x);

        for(int& e : ans) cout << e;
        cout << endl;
    }
    
    return 0;

}