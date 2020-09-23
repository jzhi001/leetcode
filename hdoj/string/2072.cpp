#include<iostream>
#include <string>
#include <sstream>  
#include <unordered_set>

using namespace std;

string s;

int main(){

    while(true){
        
        getline(cin, s);

        if(s == "#") break;

        unordered_set<string> set;

        istringstream iss(s);

        string word;

        while(iss >> word){
            set.insert(word);
        }

        int ans = set.size();
        
        cout << ans << endl;
    }

    return 0;
}