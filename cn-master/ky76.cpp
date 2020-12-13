#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cctype>
#include <vector>

using namespace std;

typedef pair<char, int> PCI;

bool cmp(PCI& a, PCI& b){

    if(tolower(a.first) != tolower(b.first)) 
        return tolower(a.first) < tolower(b.first);
    return a.second < b.second;
}

int main(){

    string line;

    while(getline(cin, line)){

        vector<bool> isLetter(line.size(), false);
        vector<PCI> letters;

        for(int i = 0; i < line.size(); i++){

            if(!isalpha(line[i])) continue;

            isLetter[i] = true;
            letters.push_back({line[i], i});
        }

        sort(letters.begin(), letters.end(), cmp);

        string ans;

        for(int i = 0, j = 0; i < line.size(); i++){
            
            if(isLetter[i]) ans += letters[j ++].first;
            else ans += line[i];
        }

        cout << ans << endl;
    }
    
    return 0;
}