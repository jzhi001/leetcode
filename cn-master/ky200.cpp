#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 110;

int n, g[N][N];

void handleInput(){
    for(int r = 0; r < n; r++){
        for(int c = 0; c < n; c++){
            cin >> g[r][c];
        }
    }
}

void output(){
    for(int r = 0; r < n; r++){
        for(int c = 0; c < n; c++){
            cout << g[r][c] << ' ';
        }
        cout << endl;
    }
}

int main(){

    while(cin >> n){
        
        handleInput();        

        for(int i = 0; i < n - 1; i++){

            int idx = -1;

            for(int r = i; r < n; r++){
                if(idx == -1 || g[r][i] > g[idx][i]){
                    idx = r;
                }
            }

            if(idx == i) continue;

            for(int c = 0; c < n; c++) swap(g[idx][c], g[i][c]);
        }

        output();
    }
    
    return 0;

}