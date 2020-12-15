#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

bool valid(int x){

    int tar = x * 9;
    int cur = 0;

    while(x){
        cur = cur * 10 + x % 10;
        x /= 10;
    }

    return cur == tar;
}

int main(){

    for(int i = 1000; i < 10000; i++){
        if(valid(i)) cout << i << endl;
    }
    
    return 0;

}