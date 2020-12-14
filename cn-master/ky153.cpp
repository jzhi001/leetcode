#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 11;

int m, n;

int a[N][N];

int main(){

    while(cin >> m){

        if(m == 0) break;

        cin >> n;

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                cin >> a[r][c];
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int x;
                cin >> x;

                a[r][c] += x;
            }
        }

        int ans = 0;

        for(int r = 0; r < m; r++){

            bool allZero = true;

            for(int c = 0; allZero && c < n; c++){
                allZero &= a[r][c] == 0;
            }

            if(allZero) ans ++;
        }

        for(int c = 0; c < n; c++){

            bool allZero = true;

            for(int r = 0; allZero && r < m; r++){
                allZero &= a[r][c] == 0;
            }

            if(allZero) ans ++;
        }

        cout << ans << endl;

    }
    
    return 0;
}