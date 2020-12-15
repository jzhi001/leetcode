#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int sum(int x){
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
        if(x == 0) break;

        while(x > 9){
            x = sum(x);
        }

        cout << x << endl;
    }

    
    return 0;

}