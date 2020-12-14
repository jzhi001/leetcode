#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int a[3];

int main(){

    while(cin >> a[0] >> a[1] >> a[2]){

        if(a[0] == 0 &&  a[1] == 0 && a[2] == 0) break;

        sort(a, a + 3);

        int ans = (a[0] + a[1]) - a[2];

        cout << ans << endl;
    }
    
    return 0;
}