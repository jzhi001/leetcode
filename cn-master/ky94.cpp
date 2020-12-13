#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 1010;

int n, a[N];

int main(){

    while(cin >> n){

        for(int i = 0; i < n; i++){
            cin >> a[i];
        }

        sort(a, a + n);

        int j = -1;

        for(int i = 0; i < n; i++){
            if(j == -1 || a[i] != a[j]) a[++ j] = a[i];
        }

        for(int i = 0; i <= j; i++){
            cout << a[i] << ' ';
        }

        cout << endl;
    }

    return 0;
}