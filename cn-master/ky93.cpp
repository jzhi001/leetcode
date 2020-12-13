#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <unordered_map>

using namespace std;

string s = "QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./1234567890-=";

unordered_map<char, int> idx;

int main(){

    for(int i = 0; i < s.size(); i++){
        idx[s[i]] = i;
    }

    string line;

    while(getline(cin, line)){

        string ans;

        for(char c : line){
            
            char t = c;
            if(t != ' ') t = s[idx[t] - 1];

            ans += t;
        }

        cout << ans << endl;
    }
    
    return 0;
}