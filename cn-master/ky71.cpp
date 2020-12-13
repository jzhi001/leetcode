#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int main(){

    int n, age;

    while(cin >> n){

        double tot = 0;

        for(int i = 0; i < n; i++){
            cin >> age;
            tot += age;
        }

        double ans = tot / n;

        printf("%.2f\n", ans);
    }
    
    return 0;
}