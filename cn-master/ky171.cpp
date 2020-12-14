#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int a[2][3], b[3][2], ans[2][2];

void multi(int arow, int bcol, int& ans){

    for(int i = 0; i < 3; i++){

        // cout << a[arow][i] << ' ' << b[i][bcol] << endl;
        ans += a[arow][i] * b[i][bcol];
    }
}

int main(){

    for(int r = 0; r < 2; r++){
        for(int c = 0; c < 3; c++){
            cin >> a[r][c];
        }
    }

    for(int r = 0; r < 3; r++){
        for(int c = 0; c < 2; c++){
            cin >> b[r][c];
        }
    }

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            multi(i, j, ans[i][j]);
        }
    }

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            cout << ans[i][j] << ' ';
        }
        cout << endl;
    }
    
    return 0;
}