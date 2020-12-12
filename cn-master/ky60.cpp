#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

const int N = 10;

int n, tot[N], act[N];

double gradePt(int g){

    if(g >= 90 & g <= 100) return 4.0;
    else if(g >= 85 && g <= 89) return 3.7;
    else if(g >= 82 && g <= 84) return 3.3;
    else if(g >= 78 && g <= 81) return 3.0;
    else if(g >= 75 && g <= 77) return 2.7;
    else if(g >= 72 && g <= 74) return 2.3;
    else if(g >= 68 && g <= 71) return 2.0;
    else if(g >= 64 && g <= 67) return 1.5;
    else if(g >= 60 && g <= 63) return 1.0;
    else return 0;
}

int main(){

    cin >> n;

    for(int i = 0; i < n; i++) cin >> tot[i];
    for(int i = 0; i < n; i++) cin >> act[i];

    double totGradePts = 0, totScore = 0;

    for(int i = 0; i < n; i++){

        // cout << gradePt(act[i]) << ' ' << tot[i] <<  endl;

        totGradePts += gradePt(act[i]) * tot[i];
        totScore += tot[i];
    }

    double ans = totGradePts / totScore;

    printf("%.2f", ans);
    
    return 0;
}