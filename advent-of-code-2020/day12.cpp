#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

typedef pair<char, int> PCI;
typedef pair<int, int> PII;

vector<PCI> actions;

// E, S, W, N
int dx[4] = {1, 0, -1, 0}, dy[4] = {0, -1, 0, 1};

int moveShip(){

    int x = 0, y = 0, direction = 0;

    for(PCI action : actions){
        char op = action.first;
        int arg = action.second;

        // printf("%c %d\n", op, arg);

        if(op == 'N') y += arg;
        else if(op == 'S') y -= arg;
        else if(op == 'E') x += arg;
        else if(op == 'W') x -= arg;
        else if(op == 'F'){
            x += dx[direction] * arg;
            y += dy[direction] * arg;
        }else if(op == 'R'){
            direction = (direction + arg / 90) % 4;
        }else{
            direction = (direction - arg / 90) % 4;
            if(direction < 0) direction += 4;
        }

        // printf("direction: %d, (%d, %d)\n", direction, x, y);
    }

    return abs(x) + abs(y);
}

PII rotateRight90(int x, int y){

    return {y, -x};
}

PII rotateLeft90(int x, int y){

    return {-y, x};
}

long long moveWayPoint(){

    int x = 0, y = 0;
    int wx = 10, wy = 1;

    for(PCI action : actions){
        char op = action.first;
        int arg = action.second;

        // printf("%c %d\n", op, arg);

        if(op == 'N') wy += arg;
        else if(op == 'S') wy -= arg;
        else if(op == 'E') wx += arg;
        else if(op == 'W') wx -= arg;
        else if(op == 'F'){
            x += wx * arg;
            y += wy * arg;
        }else if(op == 'R'){

            arg %= 360;

            for(int i = 0; i < arg; i += 90){

                PII p = rotateRight90(wx, wy);
                wx = p.first;
                wy = p.second;
            }

        }else{

            arg %= 360;

            for(int i = 0; i < arg; i += 90){
                PII p = rotateLeft90(wx, wy);
                wx = p.first;
                wy = p.second;
            }
        }

        // printf("wayPoint: (%d, %d), ship: (%d, %d)\n", wx, wy, x, y);
    }

    return (long long)abs(x) + abs(y);
}

void question1(){

    cout << moveShip() << endl;
}

void question2(){
    cout << moveWayPoint() << endl;
}

int main(){

    char op; int arg;

    while(cin >> op >> arg){
        // printf("%c %d\n", op, arg);
        actions.push_back({op, arg});    
    }

    // question1();
    question2();
    
    return 0;
}