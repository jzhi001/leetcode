#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 110;

int cnt[N];

int main(){

    int n;

    while(cin >> n){

        if(n == 0) break;

        memset(cnt, 0, sizeof cnt);

        while(n --){
            int score;
            cin >> score;

            cnt[score] ++;
        }

        int tar;
        cin >> tar;

        cout << cnt[tar] << endl;
    }
    
    return 0;
}