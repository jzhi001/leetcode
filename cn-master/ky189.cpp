#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(){

    
    int n;

    while(cin >> n){

        int odd = 0, even = 0;
        int x;

        while(n --){
            cin >> x;
            if(x % 2 == 0) even ++;
            else odd ++;
        }

        if(even > odd) puts("NO");
        else puts("YES");
    }

    return 0;

}