#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <cmath>

using namespace std;

double ans;

void calc(int dist, string& code){

    if(code == "F"){

        ans += dist * 2;

    }else if(code == "B"){

        ans += dist * 1.5;

    }else{

        if(dist <= 500) ans += 500;
        else ans += dist;
    }
}

// First Class F Actual mileage + 100% mileage bonus
// Business Class B Actual mileage + 50% mileage Bonus
// Economy Class Y 1-500 miles 500 miles 500+ miles
int main(){

    string s, t, code;
    int dist;

    while(cin >> s){

        if(s == "0"){
            printf("%d\n", (int)round(ans));
            ans = 0;
        }else{

            cin  >> t >> dist >> code;

            calc(dist, code);
        }
    }
    
    return 0;
}