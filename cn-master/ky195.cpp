#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

void rev(string& s, int start, int len){

    for(int i = start, j = i + len - 1; i < j; i ++, j--){
        swap(s[i], s[j]);
    }
}

string replace(string& s, int start, int len, string& tar){

    string prefix = s.substr(0, start);

    string suffix = s.substr(start + len);

    // cout << prefix << ' ' << tar << ' ' << suffix << endl;

    return prefix + tar + suffix;
}

int main(){

    string s, code;
    int n;

    while(cin >> s){
        cin >> n;

        while(n --){
            cin >> code;

            int op = code[0] - '0';
            int i = code[1] - '0';
            int len = code[2] - '0';
            
            if(op == 0){
                rev(s, i, len);
            }else{
                string tar = code.substr(3);
                s = replace(s, i, len, tar);
            }

            cout << s << endl;
        }
    }
    
    return 0;
}