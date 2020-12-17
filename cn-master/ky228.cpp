#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

typedef pair<char, vector<int>> PIV;

int main(){

    string s;

    while(cin >> s){

        unordered_map<char, vector<int>> m;

        for(int i = 0; i < s.size(); i++){

            m[s[i]].push_back(i);
        }

        vector<PIV> all;

        for(PIV p : m){

            char c = p.first;
            vector<int> idxs = p.second;

            if(idxs.size() < 2) continue;

            all.push_back(p);
        }

        sort(all.begin(), all.end(), [](PIV& a, PIV& b){

            return a.second[0] < b.second[0];
        });

        for(int i = 0; i < all.size(); i++){

            char c = all[i].first;
            vector<int> idxs = all[i].second;

            for(int j = 0; j < idxs.size(); j++){

                if(j) cout << ',';
                printf("%c:%d", c, idxs[j]);
            }

            cout << endl;
        }
    }
    
    return 0;
}