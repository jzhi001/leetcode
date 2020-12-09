#include <iostream>
#include <cstring>

using namespace std;

int f[35];

int fib(int n){
    
    if(f[n] != -1) return f[n];
    
    f[n] = fib(n - 1) + fib(n - 2);
    
    return f[n];
}

int main(){
    
    memset(f, -1, sizeof f);
    
    f[0] = 0;
    f[1] = 1;
    
    int n;
    
    while(cin >> n){
        cout << fib(n) << endl;
    }
    
    return 0;
}