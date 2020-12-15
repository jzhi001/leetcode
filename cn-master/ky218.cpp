#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 110;

int g[N][N];

int main(){

    int m, n;

    while(cin >> m >> n){

        for(int r = 0; r < m; r ++){
            for(int c = 0; c < n; c++){
                cin >> g[r][c];
            }
        }

        for(int r = 0; r < m; r ++){

            int cmax = -1, tot = 0;

            for(int c = 0; c < n; c++){
                
                tot += g[r][c];
                if(cmax == -1 || g[r][c] > g[r][cmax]) cmax = c;
            }

            g[r][cmax] = tot;
        }

        for(int r = 0; r < m; r ++){
            for(int c = 0; c < n; c++){
                cout << g[r][c] << ' ';
            }
            cout << endl;
        }

    }

    
    return 0;

}