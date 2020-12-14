#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 210;

int n, a[N];

int main(){

    while(cin >> n){

        for(int i = 0; i < n; i++){
            cin >> a[i];
        }

        int x;
        cin >> x;

        int ans = -1;

        for(int i = 0; ans == -1 && i < n; i++){
            if(x == a[i]) ans = i;
        }

        cout << ans << endl;
    }
    
    return 0;
}