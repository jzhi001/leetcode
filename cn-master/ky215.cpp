#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

const int N = 1010;

struct Student{

    string name;
    int grade;
    int age;

    bool operator<(const Student& t) const{

        if(grade != t.grade) return grade < t.grade;
        if(name != t.name) return name < t.name;
        return age < t.age;
    }

} all[N];

int main(){

    int n;

    while(cin >> n){

        for(int i = 0; i < n; i++){
            Student& s = all[i];
            cin >> s.name >> s.age >> s.grade;
        }

        sort(all, all + n);

        for(int i = 0; i < n; i++){
            Student& s = all[i];
            printf("%s %d %d\n", s.name.c_str(), s.age, s.grade);
        }
    }
    
    return 0;

}