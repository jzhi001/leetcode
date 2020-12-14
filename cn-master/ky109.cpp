#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

typedef long long LL;

const int N = 10010;

int n;
LL a[N];

int main(){

    while(cin >> n){

        for(int i = 0; i < n; i++) cin >> a[i];

        for(int i = n - 1; i >= 0; i--) cout << a[i] << ' ';
        cout << endl;
    }
    
    return 0;

}