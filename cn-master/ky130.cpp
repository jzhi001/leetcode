#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <sstream>

using namespace std;

int toNum(string& s){
    if(s == "one") return 1;
    else if(s == "two") return 2;
    else if(s == "three") return 3;
    else if(s == "four") return 4;
    else if(s == "five") return 5;
    else if(s == "six") return 6;
    else if(s == "seven") return 7;
    else if(s == "eight") return 8;
    else if(s == "nine") return 9;
    else return 0;
}

int main(){

    string line;

    while(getline(cin, line)){

        int a = 0, b = 0;

        string s; int *cur = &a;
        istringstream iss(line);

        while(iss >> s){

            if(s == "=") continue;
            else if(s == "+") cur = &b;
            else{
                *cur = *cur * 10 + toNum(s);
            }
        }

        if(a == 0 && b == 0) break;

        cout << a + b << endl;
    }
    
    return 0;

}