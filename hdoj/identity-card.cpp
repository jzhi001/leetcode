#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

// TAG: 模拟，字符串
// http://acm.hdu.edu.cn/game/entry/problem/show.php?chapterid=1&sectionid=2&problemid=25


using namespace std;

int n;

string province(string &s){
    if(s == "33") return "Zhejiang";
    else if(s == "11") return "Beijing";
    else if(s == "71") return "Taiwan";
    else if(s == "81") return "Hong Kong";
    else if(s == "82") return "Macao";
    else if(s == "54") return "Tibet";
    else if(s == "21") return "Liaoning";
    else return "Shanghai";
}

int main(){

    cin >> n;

    string id;

    while(n -- > 0){
        
        cin >> id;

        string p = id.substr(0, 2);
        string prov = province(p);
        string year = id.substr(6, 4);
        string month = id.substr(10, 2);
        string date = id.substr(12, 2);

        cout << "He/She is from " << prov << ",and his/her birthday is on ";
        cout << month << "," << date << "," << year << " based on the table." << endl;
    }
    
    return 0;

}

