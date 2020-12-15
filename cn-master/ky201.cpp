#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(){

    string a, b;

    while(cin >> a >> b){

        string ans;

        for(int i = 0, j = b.size() - 1; i < a.size() || j >= 0; i++, j--){

            if(i < a.size()) ans += a[i];
            if(j >= 0) ans += b[j];
        }

        cout << ans << endl;
    }

    
    return 0;

}