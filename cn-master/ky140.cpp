#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int n;

struct Record{

    string id;
    string in;
    string out;
};

vector<Record> all;

int main(){

    cin >> n;

    for(int i = 0; i < n; i++){

        string id, in, out;
        cin >> id >> in >> out;

        all.push_back({id, in, out});
    }

    string first, last;

    sort(all.begin(), all.end(), [](Record& a, Record& b){

        return a.in < b.in;
    });

    first = all[0].id;

    sort(all.begin(), all.end(), [](Record& a, Record& b){

        return a.out > b.out;
    });

    last = all[0].id;

    cout << first << ' ' << last << endl;
    
    return 0;

}