#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

typedef long long LL;

const int N = 25;

LL fact[N];

int main(){

    fact[1] = 1;

    for(int i = 2; i <= 20; i ++){
        fact[i] = i * fact[i - 1];
    }

    int n;
    while(cin >> n){
        cout << fact[n] << endl;
    }
    
    return 0;
}