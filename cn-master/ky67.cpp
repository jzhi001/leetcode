#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int a[11];

int main(){

    while(cin >> a[0]){
        for(int i = 1; i < 10; i++) cin >> a[i];

        sort(a, a + 10, [](int& x, int& y){

            if(x % 2 == 0 && y % 2 == 0) return x < y;
            else if(x % 2 != 0 && y % 2 != 0) return x > y;
            else return x % 2 != 0;
        });

        for(int i = 0; i < 10; i++){
            cout << a[i] << ' ';
        }

        cout << endl;
    }
    
    return 0;
}