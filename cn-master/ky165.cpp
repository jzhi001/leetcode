#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int main(){
    
    long long out = 0;

    for(int i = 0, pow = 1; i < 30; i++, pow *= 2){

        out += pow;
    }

    cout << 300 << ' ' << out << endl;

    return 0;
}