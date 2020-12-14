#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int main(){

    string s;
    char c;

    while(cin >> s >> c){

        string ans;

        for(char e : s){
            if(c == e) continue;
            ans += e;
        }

        cout << ans << endl;
    }
    
    return 0;
}