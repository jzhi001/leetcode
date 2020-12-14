#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 20;

int cnt[11];

int main(){

    int x;
    while(cin >> x){

        memset(cnt, 0, sizeof cnt);

        cnt[x] ++;

        for(int i = 1; i < 20; i++){
            cin >> x;
            cnt[x] ++;
        }

        int ans = -1;

        for(int i = 1; i <= 10; i++){
            if(ans == -1 || cnt[i] > cnt[ans]) ans = i;
        }

        cout << ans << endl;
    }
    
    return 0;
}