#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

const int N = 22;

int n, a[N];

int main(){

    while(cin >> n){

        for(int i = 1; i <= n; i++){
            cin >> a[i];
        }

        sort(a + 1, a + n + 1);

        vector<vector<int>> f(n + 1, vector<int>(41, 0));

        for(int i = 0; i <= n; i++) f[i][0] = 1;

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= 40; j++){

                f[i][j] = f[i-1][j];
                if(a[i] <= j) f[i][j] += f[i-1][j-a[i]];
            }
        }

        // for(int i = 0; i <= n; i++){
        //     for(int j = )
        // }

        cout << f[n][40] << endl;
    }
    
    return 0;
}