#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 85;

int n;
int a[N];

bool isMax(int i){
    if(i >= 1 && a[i] <= a[i - 1]) return false;
    if(i + 1 < n && a[i] <= a[i + 1]) return false;
    return true;
}


bool isMin(int i){
    if(i >= 1 && a[i] >= a[i - 1]) return false;
    if(i + 1 < n && a[i] >= a[i + 1]) return false;
    return true;
}

bool valid(int i){
    return isMax(i) || isMin(i);
}

int main(){

    while(cin >> n){

        for(int i = 0; i < n; i++) cin >> a[i];

        for(int i = 0; i < n; i++){

            if(valid(i)) cout << i << ' '; 
        }

        cout << endl;
    }
    
    return 0;
}