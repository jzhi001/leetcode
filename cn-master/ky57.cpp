#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

bool isFirstLetter(string& s, int i){
    
    if(i == 0) return true;

    char c = s[i - 1];

    return c == '\t' || c == '\n' || c == ' ';
}

string capitalize(string& s){

    string ans;

    for(int i = 0, j = 0; i < s.size(); i++){

        if(isFirstLetter(s, i)){
            ans += toupper(s[i]);
        }else{
            ans += s[i];
        }
    }

    return ans;
}

int main(){

    string line;

    while(getline(cin, line)){
        string ans = capitalize(line);
        cout << ans << endl;
    }
    
    return 0;
}