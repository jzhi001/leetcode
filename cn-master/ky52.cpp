#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

void binary(int x){

    for(int i = 31; i >= 0; i--){
        int bit = (x >> i) & 1;
        cout << bit;
    }

    cout << endl;
}

int leftShift(int x){

    int bit = (x >> 15) & 1;
    x = (x << 1) & 0xFFFF;
    x |= bit;

    return x;

}

int main(){

    int a, b;

    while(cin >> a >> b){

        // cout << "b ";
        // binary(b);

        bool same = false;
        
        for(int i = 0; i < 16; i++){

            // cout << "a ";
            // binary(a);

            if(a == b){
                same = true;
                break;
            }

            a = leftShift(a);
        }

        if(same) puts("YES");
        else puts("NO");
    }
    
    return 0;

}