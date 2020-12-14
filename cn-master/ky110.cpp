#include <iostream>
#include <algorithm>
#include <cstring>
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

    int k;

    while(cin >> k){

        int ans = 0;

        for(int i = 0, j = 2; i < k; j++){

            if(isPrime(j)){
                ans = j;
                i++;
            }
        }

        cout << ans << endl;
    }
    
    return 0;

}