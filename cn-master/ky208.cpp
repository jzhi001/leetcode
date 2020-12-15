#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 105;

char a[N], b[N], ans[N * 2];

int main(){

    while(~scanf("%s%s", a, b)){

        int i = 0;

        for(int j = 0; a[j] != 0; j++){
            ans[i++] = a[j];
        }

        for(int j = 0; b[j] != 0; j++){
            ans[i++] = b[j];
        }

        for(int j = 0; j < i; j++){
            cout << ans[j];
        }

        cout << endl;
    }
    
    return 0;

}