#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <unordered_map>

using namespace std;

struct Person{
    int id;
    string name;
    string gender;
    int age;
};

unordered_map<int, Person> info;

int main(){

    int m;
    cin >> m;

    while(m --){

        int n;
        cin >> n;

        while(n --){
            int id, age;
            string name, gender;

            cin >> id >> name >> gender >> age;

            info[id] = {id, name, gender, age};
        }

        int tar;
        cin >> tar;

        Person p = info[tar];

        cout << p.id << ' ' << p.name << ' ' << p.gender << ' ' << p.age << endl;
    }
    
    return 0;

}