#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 26;

int cnt[N];

int main(){

    string s;

    while(cin >> s){

        memset(cnt, 0, sizeof cnt);

        for(char c : s){
            if(c >= 'A' && c <= 'Z') cnt[c - 'A'] ++;
        }

        for(int i = 0; i < N; i++){
            printf("%c:%d\n", (char)('A' + i), cnt[i]);
        }
    }

    return 0;

}