#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

const int N = 1010, M = 11;

int n, m, g;

struct Student{
    string id;
    int tot;

    bool operator<(const Student& t) const{

        if(tot != t.tot) return t.tot < tot;
        return id < t.id;
    }

} all[N];

int scores[M];

int main(){

    while(cin >> n ){

        if(n == 0) break;

        cin >> m >> g;

        for(int i = 1; i <= m; i++) cin >> scores[i];

        for(int i = 0; i < n; i++){
            Student& s = all[i];
            s.tot = 0;

            cin >> s.id;

            int cnt;
            cin >> cnt;

            while(cnt --){
                int qid;
                cin >> qid;

                s.tot += scores[qid];
            }
        }

        sort(all, all + n);

        // for(int i = 0; i < n; i++){
        //     cout << all[i].id << ' ' << all[i].tot << endl;
        // }

        int j = 0;

        while(j < n && all[j].tot >= g) j++;

        cout << j << endl;

        for(int i = 0; i < j; i++){
            Student& s = all[i];
            cout << s.id << ' ' << s.tot << endl;
        }

    }
    
    return 0;

}