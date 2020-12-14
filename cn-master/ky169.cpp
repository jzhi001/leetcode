#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 10;

int a[N];

int main(){

    while(cin >> a[0]){

        for(int i = 1; i < N; i++) cin >> a[i];

        int ans = -1;

        for(int i = 0; i < N; i++){
            if(ans == -1 || a[i] > a[ans]) ans = i;
        }

        cout << "max=" << a[ans] << endl;
    }
    
    return 0;
}