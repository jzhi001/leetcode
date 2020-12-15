#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 1010;

int a[N];

int main(){

    int n;

    while(cin >> n){

        for(int i = 0; i < n; i++){
            cin >> a[i];
        }

        sort(a, a + n);

        int j = n - 1;
        cout << a[j] << endl;

        j --;

        if(j == -1) cout << -1 << endl;
        else{
            for(int i = 0; i <= j; i++){
                cout << a[i] << ' ';
            }
            cout << endl;
        }
    }
    
    return 0;

}