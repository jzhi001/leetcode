#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 110;

typedef pair<int, string> PIS;

PIS a[N];

int main(){

    int n;

    while(cin >> n){

        for(int i = 0; i < n; i++){
            int weight;
            string color;

            cin >> weight >> color;

            a[i] = {weight, color};
        }

        sort(a, a + n, [](PIS& a, PIS& b){
            return a.first > b.first;
        });

        for(int i = 0; i < n; i++){
            cout << a[i].second << endl;
        }
    }
    
    return 0;
}