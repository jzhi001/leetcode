#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <cctype>

using namespace std;

int main(){

    int n;
    cin >> n;

    while(n --){
        string s;
        cin >> s;

        for(int i = 0; i < s.size(); i++){
            if(isdigit(s[i])) cout << i + 1 << ' ';
        }

        cout << endl;
    }

    
    return 0;

}