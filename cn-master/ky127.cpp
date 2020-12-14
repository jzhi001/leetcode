#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <unordered_map>

using namespace std;

int main(){

    string s, p;

    while(getline(cin, p)){
        
        if(p == "#") break;

        getline(cin, s);

        // cout << s << endl;

        unordered_map<char, int> cnt;

        for(char c : s) cnt[c] ++;

        for(char c : p){
            // cout << c << endl;
            printf("%c %d\n", c, cnt[c]);
        }
    }
    
    return 0;

}