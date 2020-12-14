#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(){

    int tot;

    while(cin >> tot){

        int minCnt = 0, maxCnt = 0;

        if(tot > 0 && tot % 2 == 0){
            minCnt = (tot / 4) + (tot % 4) / 2;
            maxCnt = (tot / 2) + (tot % 2) / 4;   
        }

        cout << minCnt << ' ' << maxCnt << endl;
    }

    return 0;

}