#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(){

    string t, p;

    while(cin >> t >> p){

        int ans = 0;

        for(int i = 0; i <= t.size() - p.size(); i++){

            bool match = true;

            for(int j = 0; match && j < p.size(); j++){
                if(t[i + j] != p[j]) match = false;
            }

            if(match) ans ++;
        }

        cout << ans << endl;
    }
    
    return 0;

}