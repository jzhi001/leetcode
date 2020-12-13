#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 15;


int main(){

    double t;

    while(cin >> t){
        
        double tot = t;

        for(int i = 1; i < 12; i++){
            cin >> t;
            tot += t;
        }

        double ans = tot / 12;

        printf("$%.2f\n", ans);
    }
    
    return 0;
}