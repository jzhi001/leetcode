#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <unordered_map>
#include <unordered_set>

using namespace std;

unordered_map<int, int> p;

int parent(int x){
    if(p[x] != x) p[x] = parent(p[x]);
    return p[x];
}

int main(){

    int a, b;

    while(cin >> a >> b){

        if(!p.count(a)) p[a] = a;
        if(!p.count(b)) p[b] = b;

        int pa = parent(a), pb = parent(b);

        if(pa != pb) p[pa] = pb;
    }

    unordered_set<int> st;

    for(auto e : p){
        int u = e.first;
        int pu = parent(u);

        st.insert(pu);
    }

    cout << st.size() << endl;

    return 0;

}