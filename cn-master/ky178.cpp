#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int sumDigits(int x){
    int ans = 0;

    while(x){
        ans += x % 10;
        x /= 10;
    }

    return ans;
}

int main(){

    int x;

    while(cin >> x){

        printf("%d %d\n", sumDigits(x), sumDigits(x * x));
    }
    
    return 0;
}