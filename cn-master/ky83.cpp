#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int dx[4] = {1, 1, 1, -1}, dy[4] = {1, -1, 1, 1};

int main(){

    int x, y;

    while(cin >> x >> y){

        int a = 0, b = 0, id = 0, i = 0;

        while(a < x || b < y){

            // cout << a << ' ' << b << endl;

            a += dx[i]; 
            b += dy[i];
            i = (i + 1) % 4;
            id ++;
        }

        // cout << a << ' ' << b << endl;

        if(a == x && b == y){
            cout << id << endl;
        }else{
            puts("No Number");
        }
    }
    
    return 0;
}