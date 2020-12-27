#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <climits>
#include <cmath>

using namespace std;

typedef long long LL;

int dptTime;
vector<int> busIds;
vector<int> seq;

void handleBusIds(string& line){

    line += ",";

    int id = 0, i = 0;

    for(char c : line){
        if(c == ','){
            if(id){
                busIds.push_back(id);
                seq.push_back(i);
            }
            id = 0;
            i ++;
        }else{
            if(c == 'x') continue;
            id = id * 10 + c - '0';
        }
    }
}

int arrTime(int id){

    double ans = (double)dptTime / id;

    return (int)ceil(ans) * id;
}

void question1(){

    int minArrTime = INT_MAX;
    int tarBusId = -1;

    for(int id : busIds){
        int cur = arrTime(id);
        
        if(tarBusId == -1 || minArrTime > cur){
            minArrTime = cur;
            tarBusId = id;
        }
    }

    int ans = (minArrTime - dptTime) * tarBusId;

    cout << ans << endl;
}

LL gcd(LL a, LL b){
    return b ? gcd(b, a % b) : a;
}

void question2(){


}

int main(){

    cin >> dptTime;

    string line;
    cin >> line;

    handleBusIds(line);

    question1();
    
    return 0;
}