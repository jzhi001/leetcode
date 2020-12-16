#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

bool valid(int x){

    for(int k = 2; k * k <= x; k++){
        if(x % (k * k) == 0) return true;
    }

    return false;
}

int main(){

    int n;

    while(cin >> n){

        if(n == 0) break;

        if(valid(n)) puts("Yes");
        else puts("No");
    }
    
    return 0;

}