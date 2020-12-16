#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 1010;

string s[N], p;

int n;

bool match(string& str, string& p){

    int is = 0;

    for(int ip = 0; ip < p.size(); ip++, is++){

        if(is == str.size()) return false;

        char cp = tolower(p[ip]), cs = tolower(str[is]);

        if(cp != '['){
            if(cp != cs) return false;
        }else{
            ip++;

            bool anyMatch = false;

            while(p[ip] != ']'){
                if(tolower(p[ip]) == cs) anyMatch = true;
                ip++;
            }

            if(!anyMatch) return false;
        }
    }

    return is == str.size();
}

int main(){

    while(cin >> n){

        for(int i = 0; i < n; i++) cin >> s[i];

        cin >> p;

        for(int i = 0; i < n; i++){
            if(match(s[i], p)){
                cout << i + 1 << ' ' << s[i] << endl;
            }
        }
    }

    
    return 0;

}