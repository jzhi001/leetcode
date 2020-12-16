#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int rev(int x){

    int ans = 0;

    while(x){
        ans = ans * 10 + x % 10;
        x /= 10;
    }

    return ans;
}

int main(){

    for(int i = 0; i <= 256; i++){
        if(i * i == rev(i * i)) cout << i << endl;
    }
    
    return 0;
}