#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 1000010;

int n, a[N * 2];

int main(){

    int len;

    while(cin >> len){

        n += len;

        for(int i = 0; i < n; i++) scanf("%d", &a[i]);

        cin >> len;

        for(int i = 0; i < len; i++) scanf("%d", &a[i + n]);

        n += len;

        sort(a, a + n);

        int ans = a[n / 2];

        if(n % 2 == 0){
            ans = a[n / 2 - 1];
        }

        cout << ans << endl;
    }
    
    return 0;

}