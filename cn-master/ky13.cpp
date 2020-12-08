#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int main(){
    
    int n;
    while(cin >> n){
        vector<int> all;

        while(n --){
            int x;
            cin >> x;
            all.push_back(x);
        }

        sort(all.begin(), all.end());

        cout << all.back() << ' ' << all.front() << endl;
    }

    return 0;
}