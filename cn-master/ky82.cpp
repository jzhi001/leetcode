#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int main(){

    int n;

    while(cin >> n){

        getchar();

        vector<string> all;

        string s;
        
        for(int i = 0; i < n; i++){
            
            getline(cin, s);

            // cout << s << endl;

            if(s == "stop") break;
            all.push_back(s);
        }

        sort(all.begin(), all.end(), [](string& a, string& b){
            return a.size() < b.size();
        });

        for(string& e : all) cout << e << endl;

    }
    
    return 0;

}