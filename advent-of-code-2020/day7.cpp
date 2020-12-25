#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <unordered_set>

using namespace std;

typedef pair<string, int> PSI;

const string TAR = "shiny gold";

unordered_set<string> colors;
unordered_map<string, vector<PSI>> children;

void handle(string line){

    istringstream iss(line);
    string cur, bagName;

    while(cur != "bags"){

        if(bagName.size()) bagName += ' ';
        bagName += cur;

        iss >> cur;
    }

    colors.insert(bagName);

    // contian
    iss >> cur;
    
    for(;;){

        string cnt;
        string childName;

        iss >> cnt;
        if(cnt == "no") break;

        int n = stoi(cnt);

        string s;
        for(int i = 0; i < 2; i++){
            iss >> s;
            if(childName.size()) childName += ' ';
            childName += s;
        }

        children[bagName].push_back({childName, n});
        colors.insert(childName);
        
        iss >> s;
        if(s.back() == '.') break;
    }
}

// question 1
int shinyGoldBagsWithin(string name){

    int ans = 0;

    for(PSI& p : children[name]){

        string child = p.first;
        int n = p.second;

        if(child == TAR) ans += n;
        else ans += n * shinyGoldBagsWithin(child);
    }

    return ans;
}

int bagsWithin(string name){
    int ans = 0;

    for(PSI& p : children[name]){

        string child = p.first;
        int n = p.second;

        ans += n + n * bagsWithin(child);
    }

    return ans;
}

void question1(){

    int ans = 0;
    
    for(string s : colors){
        if(s == TAR) continue;

        int cnt = shinyGoldBagsWithin(s);

        if(cnt > 0) ans ++;
    }

    cout << ans << endl;
}

void question2(){

    cout << bagsWithin(TAR) << endl;
}

int main(){

    string line;

    while(getline(cin, line)){
        handle(line);
    }

    question2();

    return 0;
}