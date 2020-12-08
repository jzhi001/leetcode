#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

const int N = 1010, M = 10010;

int n, m;

struct Student{
    int id;
    string name;
    string gender;
    int age;

    bool operator<(const Student& t) const{
        return id < t.id;
    }
} all[N];

int getId(string& s){
    return (s[0] - '0') * 10 + (s[1] - '0');
}

string search(int tar){
    int l = 0, r = n - 1;

    while(l < r){
        int mid = (l + r) >> 1;
        if(all[mid].id >= tar) r = mid;
        else l = mid + 1;
    }

    if(all[l].id != tar) return "No Answer!";
    
    Student& s = all[l];

    char ans[100];
    sprintf(ans, "%d %s %s %d", s.id, s.name.c_str(), s.gender.c_str(), s.age);

    return ans;
}

int main(){

    cin >> n;

    for(int i = 0; i < n; i++){

        Student& u = all[i];

        cin >> u.id >> u.name >> u.gender >> u.age;
    }

    sort(all, all + n);

    cin >> m;

    while(m --){
        int id;
        cin >> id;

        cout << search(id) << endl;
    }
    
    return 0;
}