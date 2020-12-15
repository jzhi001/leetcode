#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 5;

int g[N][N], tmp[N][N];

void flip(bool clockwise, int len, int x, int y){

    memcpy(tmp, g, sizeof g);

    int lastRow = x + len - 1, lastCol = y + len - 1;

    if(clockwise){

        for(int i = 0; i < len; i++){
            g[x][y+i] = tmp[lastRow - i][y];
            g[lastRow][y+i] = tmp[lastRow - i][lastCol];
            g[x+i][y] = tmp[lastRow][y+i];
            g[x+i][lastCol] = tmp[x][y+i];
        }

    }else{
        
        for(int i = 0; i < len; i++){
            g[x][y+i] = tmp[x + i][lastCol];
            g[lastRow][y+i] = tmp[x + i][y];
            g[x+i][y] = tmp[x][lastCol - i];
            g[x+i][lastCol] = tmp[lastRow][lastCol - i];
        }
    }
}

int main(){

    while(cin >> g[0][0]){

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(r == 0 && c == 0) continue;
                cin >> g[r][c];
            }
        }

        int x, y, clockwise, cnt;
        cin >> clockwise >> cnt >> x >> y;

        flip(clockwise == 1, cnt, x - 1, y - 1);

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                cout << g[r][c] << ' ';
            }
            cout << endl;
        }
    }
    
    return 0;

}