#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(){

    string s;

    while(cin >> s){
        sort(s.begin(), s.end());

        cout << s << endl;
    }
    
    return 0;

}