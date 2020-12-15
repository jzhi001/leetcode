#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<int> cnt(string& line){

    istringstream iss(line);
    string s;

    vector<int> ans;

    while(iss >> s){

        int len = s.size();
        if(s.back() == '.') len--;
        ans.push_back(len);
    }

    return ans;
}

int main(){

    string line;

    while(getline(cin, line)){

        vector<int> ans = cnt(line);

        for(int& x : ans){
            cout << x << ' ';
        }
        cout << endl;
    }
    
    return 0;

}