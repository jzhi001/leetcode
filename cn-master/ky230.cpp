#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

string oct(int x){

    string ans;

    while(x){

        ans = (char)(x % 8 + '0') + ans;
        x /= 8;
    }

    return ans;
}

int main(){

    int n;
    while(cin >> n){

        cout << oct(n) << endl;
    }
    
    return 0;

}