#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

const int N = 210;

unordered_map<int, int> fav;
unordered_map<int, vector<int>> borrowers;

int main(){

    int n, m;

    while(cin >> n >> m){

        for(int i = 1; i <= n; i++){
            int book;
            cin >> book;

            fav[i] = book;
            borrowers[book].push_back(i);
        }

        for(int i = 1; i <= n; i++){
            int cnt = borrowers[fav[i]].size() - 1;

            if(cnt == 0) puts("BeiJu");
            else printf("%d\n", cnt);
        }
    }
    
    return 0;

}