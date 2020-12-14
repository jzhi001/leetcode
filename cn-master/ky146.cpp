#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <sstream>

using namespace std;

unordered_map<string, string> func, name;

int main(){

    string nm, line;

    while(cin >> nm){

        if(nm == "@END@") break;

        nm = nm.substr(1, nm.size() - 2);

        getchar();

        getline(cin, line);

        func[nm] = line;
        name[line] = nm;
    }

    int cases;
    cin >> cases;
    getchar();

    while(cases --){
        getline(cin, line);

        // cout << line << endl;

        if(line[0] == '['){
            line = line.substr(1, line.size() - 2);
        }

        if(func.count(line)) cout << func[line] << endl;
        else if(name.count(line)) cout << name[line] << endl;
        else puts("what?");
    }
    
    return 0;
}