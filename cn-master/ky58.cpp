#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int N = 6;

char ch;
int n, lv;
bool tmplt[N][N];

int gridLen(int lv){
    
    if(lv == 1) return n;
    return n * gridLen(lv - 1);
}

int blockLen(int lv){

    if(lv == 1) return 1;
    return n * blockLen(lv - 1);
}

void recur(vector<vector<char>>& g, int lv, int R, int C){

    if(lv == 1){

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(!tmplt[r][c]) continue;

                g[R + r][C + c] = ch;
            }
        }

        return;
    }

    int blen = blockLen(lv);

    for(int r = 0; r < n; r ++){

        for(int c = 0; c < n; c++){

            if(!tmplt[r][c]) continue;

            int subRow = R + r * blen;
            int subCol = C + c * blen;

            // cout << subRow << ' ' << subCol << endl;

            recur(g, lv - 1, subRow, subCol);
        }
    }
}

int main(){

    while(cin >> n){

        if(n == 0) break;
        getchar();

        string original;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                
                char u = getchar();

                tmplt[r][c] = u != ' ';

                if(tmplt[r][c]) ch = u;
            }
            getchar();
        }

        cin >> lv;

        int glen = gridLen(lv);

        vector<vector<char>> ans(glen, vector<char>(glen, ' '));

        recur(ans, lv, 0, 0);

        for(vector<char>& row : ans){

            for(char& e : row){
                cout << e;
            }
            cout << endl;
        }
    }
    
    return 0;
}