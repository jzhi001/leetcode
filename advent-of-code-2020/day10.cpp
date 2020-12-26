#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>

using namespace std;

typedef pair<int, int> PII;
typedef long long LL;

unordered_set<int> all;
unordered_map<int, PII> diff;

bool difference(int x, PII path, PII& ans){

    // cout << x << ' ' << path.first << ' ' << path.second << endl;

    if(x == 0){
        // cout << "end" << endl;
        ans.first += path.first;
        ans.second += path.second;

        return true;
    }

    for(int i = 1; i <= 3; i++){
        if(x < i || !all.count(x - i)) continue;

        PII cur = path;

        if(i == 1) cur.first ++;
        else if(i == 3) cur.second ++;

        if(difference(x - i, cur, ans)){
            return true;
        }
    }

    return false;
}

int question1(int most){

    int tar = most + 3;

    PII diff = {0, 0};

    difference(tar, {0, 0}, diff);

    cout << diff.first << ' ' << diff.second << endl;

    return diff.first * diff.second;
}

LL ways(int most){

    vector<LL> f(most + 1, 0);

    f[0] = 1;

    for(int i = 1; i <= most; i++){

        if(!all.count(i)) continue;

        for(int j = 1; j <= i && j <= 3; j++){
            f[i] += f[i - j];
        }
    }

    return f[most];
}

LL question2(int most){

    return ways(most);
}

int main(){

    int x;
    int most = 0;

    all.insert(0);

    while(cin >> x){
        most = max(most, x);
        all.insert(x);
    }

    // cout << question1(most) << endl;
    cout << question2(most) << endl;
    
    return 0;
}