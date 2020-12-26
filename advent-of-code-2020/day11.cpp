#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int dr[3] = {-1, 0, 1}, dc[3] = {-1, 0, 1};

vector<vector<char>> g;
int R, C;

void debug(){
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            cout << g[i][j];
        }
        cout << endl;
    }

    cout << endl;
}

bool validIndex(vector<vector<char>>& seats, int r, int c){
    return !(r < 0 || c < 0 || r >= R || c >= C);
}

bool validSeat(vector<vector<char>>& seats, int r, int c){
    return validIndex(seats, r, c) && seats[r][c] != '.';
}

int peopleNearby(vector<vector<char>>& seats, int r, int c){

    int ans = 0;

    for(int i = -1; i <= 1; i++){
        for(int j = -1; j <= 1; j++){
            if(i == 0 && j == 0) continue;

            int x = r + i, y = c + j;

            if(!validSeat(seats, x, y)) continue;

            if(seats[x][y] == '#') ans ++;
        }
    }

    return ans;
}

int peopleFirstSeen(vector<vector<char>>& seats, int r, int c){

    int ans = 0;

    for(int i = -1; i <= 1; i++){
        for(int j = -1; j <= 1; j++){
            if(i == 0 && j == 0) continue;

            for(int x = r + i, y = c + j; validIndex(seats, x, y); x += i, y += j){

                if(seats[x][y] == '.') continue;

                if(seats[x][y] == '#') ans ++;

                break;
            }
        }
    }

    return ans;
}

int model(){

    vector<vector<char>> last = g;

    int moved = 0;

    for(int r = 0; r < R; r ++){
        for(int c = 0; c < C; c++){

            if(last[r][c] == '.') continue;

            int n = peopleNearby(last, r, c);

            if(last[r][c] == 'L' && n == 0){
                g[r][c] = '#';
                moved ++;
            }else if(last[r][c] == '#' && n >= 4){
                g[r][c] = 'L';
                moved ++;
            }
        }
    }

    return moved;
}

int model2(){

    vector<vector<char>> last = g;

    int moved = 0;

    for(int r = 0; r < R; r ++){
        for(int c = 0; c < C; c++){

            if(last[r][c] == '.'){
                // cout << 0;
                continue;
            }

            int n = peopleFirstSeen(last, r, c);

            // cout << n;

            if(last[r][c] == 'L' && n == 0){
                g[r][c] = '#';
                moved ++;
            }else if(last[r][c] == '#' && n >= 5){
                g[r][c] = 'L';
                moved ++;
            }
        }
        // cout << endl;
    }
    // cout << endl;

    return moved;
}

int totalOccupied(){

    int ans = 0;

    for(int r = 0; r < R; r++){
        for(int c = 0; c < C; c++){
            if(g[r][c] == '#') ans ++;
        }
    }

    return ans;
}

int question1(){

    int moved = 0;

    do{

        moved = model();

    }while(moved > 0);

    return totalOccupied();
}

int question2(){

    int moved = 0;

    do{

        moved = model2();

        // debug();

    }while(moved > 0);

    return totalOccupied();
}

int main(){

    string line;
    while(getline(cin, line)){

        vector<char> row;

        for(char c : line) row.push_back(c);

        g.push_back(row);
    }

    R = g.size();
    C = g[0].size();

    cout << question2() << endl;
    
    return 0;
}