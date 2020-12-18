#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 25;

int f[N];

int main(){

    f[0] = f[1] = 1;

    for(int i = 2; i <= N; i++){
        f[i] = f[i-1] + f[i-2];
    }

    // for(int i = 1; i <= N; i++) cout << f[i] << ' ';
    // cout << endl;
    
    int n;

    while(cin >> n){
        cout << f[n] << endl;
    }

    return 0;
}