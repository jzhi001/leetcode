#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int main(){

    int m;
    cin >> m;

    vector<string> all;

    while(m --){
        string s;
        cin >> s;

        all.push_back(s);

        for(int i = all.size() - 1, j = 1; i >= 0 && j <= 4; i--, j++){

            printf("%d=%s ", j, all[i].c_str());
        }

        cout << endl;
    }
    
    return 0;
}