/*
ID: jicheng3
TASK: ride
LANG: C++                 
*/
#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <fstream>

using namespace std;

const int N = 26;

int cnt[N];

int convert(string& s){
    int ans = 1;

    for(char c : s){
        ans *= c - 'A' + 1;
    }

    return ans;
}

int main(){

    ofstream fout("ride.out");
    ifstream fin("ride.in");

    string comet, group;

    fin >> comet >> group;

    // cout << convert(comet) << endl;
    // cout << convert(group) << endl;

    if(convert(comet) % 47 == convert(group) % 47) fout << "GO" << endl;
    else fout << "STAY" << endl;
    
    return 0;

}