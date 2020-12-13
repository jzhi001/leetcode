#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 21;

int main(){

    int n;
    double k;

    while(cin >> n >> k){

        double price = 200, salary = 0;

        int ans = -1;

        for(int i = 1; i <= 21; i++){
            salary += n;

            if(salary >= price){
                ans = i;
                break;
            }

            price *= 1 + k / 100;

            // cout << price << endl;
        }

        if(ans == -1) puts("Impossible");
        else printf("%d\n", ans);
    }
    
    return 0;
}