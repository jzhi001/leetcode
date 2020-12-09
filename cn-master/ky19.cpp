#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int len[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};

bool isLeap(int year){
    return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
}

int main(){

    int year, month, date;

    while(cin >> year >> month >> date){
       vector<int> days;
       for(int i = 0; i < 12; i++) days.push_back(len[i]);

       if(isLeap(year)) days[1] ++;

       int ans = 0;

       for(int i = 0; i < month - 1; i++){
           ans += days[i];
       }

       ans += date;

       cout << ans << endl;
    }
    
    return 0;

}