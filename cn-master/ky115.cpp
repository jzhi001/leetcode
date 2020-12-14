#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int main(){

    string s;

    while(cin >> s){

        vector<string> all;

        for(int i = s.size() - 1; i >= 0; i--){
            all.push_back(s.substr(i));
        }

        sort(all.begin(), all.end());

        for(auto e : all) cout << e << endl;
    }

    return 0;

}