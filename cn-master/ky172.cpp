#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cctype>

using namespace std;

char convert(char c){

    if(!isalpha(c)) return c;
    else if(c >= 'a' && c <= 'z'){
        return 'z' - (c - 'a');
    }else{
        return 'Z' - (c - 'A');
    }
}

int main(){
    
    string s;

    while(getline(cin, s)){

        if(s == "!") break;

        string ans;

        for(char c : s){
            ans += convert(c);
        }

        cout << ans << endl;
    }

    return 0;
}