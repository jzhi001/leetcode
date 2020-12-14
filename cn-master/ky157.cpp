#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 25;

int a[N];

int main(){

    int n;

    while(cin >> n){

        int imin = -1, imax = -1;

        for(int i = 0; i < n; i++){
            cin >> a[i];
            if(imin == -1 || a[i] < a[imin]) imin = i;
            if(imax == -1 || a[i] > a[imax]) imax = i;
        }

        swap(a[imin], a[imax]);

        for(int i = 0; i < n; i++) cout << a[i] << ' ';

        cout << endl;
    }
    
    return 0;
}