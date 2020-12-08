#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

int n, asc;

struct Student{
    int idx;
    string name;
    int grade;
    
    bool operator<(const Student& t) const{
        if(grade != t.grade){
            if(asc == 1) return grade < t.grade;
            else return grade > t.grade;
        }
        return idx < t.idx;
    }
};

int main(){
    
    while(cin >> n >> asc){
        
        vector<Student> students;
        
        for(int i = 0; i < n; i++){
            string nm; int gd;
            cin >> nm >> gd;

            students.push_back({i, nm, gd});
        }

        sort(students.begin(), students.end());

        for(Student& e : students){
            cout << e.name << ' ' << e.grade << endl;
        }
    }
    
    
    
    return 0;
}