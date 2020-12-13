#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 100010;

int n, c;

struct Student{

    string id;
    string name;
    int grade;

    bool operator<(const Student& t) const{

        if(c == 1){
            return id < t.id;
        }else if(c == 2){
            if(name != t.name) return name < t.name;
            return id < t.id;
        }else{
            if(grade != t.grade) return grade < t.grade;
            return id < t.id;
        }
    }
} all[N];

int main(){

    while(cin >> n >> c){

        if(n == 0) break;

        for(int i = 0; i < n; i++){
            Student& s = all[i];
            cin >> s.id >> s.name >> s.grade;
        }

        sort(all, all + n);

        puts("Case:");

        for(int i = 0; i < n; i++){
            Student& s = all[i];

            cout << s.id << ' ' << s.name << ' ' << s.grade << endl;
        }
    }
    
    return 0;
}