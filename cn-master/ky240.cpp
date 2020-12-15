#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

double f(int x){

    if(x >= 0 && x < 2) return 2.5 - x;
    else if(x >= 2 && x < 4) return 2 - 1.5 * (x - 3) * (x - 3);
    else if(x >= 4 && x < 6) return x / 2.0 - 1.5;
    else return -1;
}

int main(){

    int m;
    cin >> m;

    while(m --){
        int x;
        cin >> x;

        double ans = f(x);

        printf("y=%.1f\n", ans);
    }
    
    return 0;

}