# Greedy Gift Givers

## 2020-12-06

```c++
/*
ID: jicheng3
TASK: gift1
LANG: C++
*/
#include <iostream>
#include <fstream>
#include <cstring>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int n;

unordered_map<string, int> money;
vector<string> names;

int main(){

    ofstream fout("gift1.out");
    ifstream fin("gift1.in");

    fin >> n;

    for(int i = 0; i < n; i++){
        string id;
        fin >> id;

        names.push_back(id);
        money[id] = 0;
    }

    string id;
    while(fin >> id){
        int tot, cnt;
        fin >> tot >> cnt;

        if(cnt == 0){
            continue;
        }

        money[id] += (tot % cnt) - tot;
        int gift = tot / cnt;

        while(cnt --){
            string tar;
            fin >> tar;
            money[tar] += gift;
        }
    }

    for(string& nm : names){
        fout << nm << ' ' << money[nm] << endl;
    }
    
    return 0;
}
```
