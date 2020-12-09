#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 10010;

int a[N];

int main(){

    int n;

    while(cin >> n){
        if(n == 0) break;

        for(int i = 0; i < n; i++) cin >> a[i];

        sort(a, a + n);

        int ans = a[n / 2];

        if(n % 2 == 0){
            ans = (ans + a[n / 2 - 1]) / 2;
        }

        cout << ans << endl;
    }

    
    return 0;

}