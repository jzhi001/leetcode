#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

bool isPrime(int x){

    if(x < 2) return false;

    for(int i = 2; i <= x / i; i++){
        if(x % i == 0) return false;
    }

    return true;
}

int main(){

    int n;

    while(cin >> n){

        if(isPrime(n)) puts("yes");
        else puts("no");
    }
    
    return 0;
}