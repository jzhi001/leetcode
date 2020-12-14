#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int main(){

    int n;

    while(cin >> n){

        for(int x = 0; x <= n / 5; x++){

            for(int y = 0; y < n / 3; y++){

                for(int z = 0; z < n * 3; z++){

                    if(x + y + z != 100) continue;
                    if(x * 5 + y * 3 + z / 3.0 > n) continue;

                    printf("x=%d,y=%d,z=%d\n", x, y, z);
                }
            }
        }
    }
    
    return 0;
}