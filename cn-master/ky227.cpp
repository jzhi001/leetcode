#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

bool valid(string& s){

    for(int i = 0, j = s.size() - 1; i < j; i ++, j --){
        if(s[i] != s[j]) return false;
    }

    return true;
}

int main(){

    string s;

    while(cin >> s){

        if(valid(s)) puts("Yes!");
        else puts("No!");
    }
    
    return 0;

}