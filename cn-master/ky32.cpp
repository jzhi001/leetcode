#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

struct Log{
    string info;
    string dateTime;
    double duration;

    Log(string _info): info(_info){
        istringstream iss(info);

        string id, dt, tm;
        iss >> id >> dt >> tm >> duration;

        dateTime = dt + tm;
    }

    bool operator<(const Log& t) const {

        if(duration != t.duration) return duration < t.duration;
        return dateTime < t.dateTime;
    }
};

vector<Log> all;

int main(){

    string line;

    while(getline(cin, line)){

        if(line == "\n") break;

        Log log(line);
        all.push_back(log);
    }

    sort(all.begin(), all.end());

    for(Log& log : all){
        cout << log.info << endl;
    }
    
    return 0;
}