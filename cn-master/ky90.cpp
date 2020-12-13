#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cctype>

using namespace std;

char convert(char c){

    if(!isalpha(c)) return c;
    int idx = c - 'A' - 5;
    if(idx < 0) idx += 26;
    return (char)('A' + idx);
}

int main(){
    
    string s, line;

    while(getline(cin, s)){

        if(s == "ENDOFINPUT") break;

        getline(cin, line);

        string ans;

        for(char& c : line){
            ans += convert(c);
        }

        cout << ans << endl;

        getline(cin, s);
    }

    return 0;
}