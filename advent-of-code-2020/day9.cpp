#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

typedef long long LL;

const int N = 25;

vector<LL> all;

LL question1(){

    for(int i = 25; i < all.size(); i++){

        bool anyMatched = false;

        for(int j = i - N; !anyMatched && j < i - 1; j ++){
            for(int k = j + 1; k < i; k++){
                if(all[j] + all[k] == all[i]){
                    anyMatched = true;
                    break;
                }
            }
        }

        if(!anyMatched){
            return all[i];
        }
    }

    return -1;
}

LL question2(){

    LL tar = question1();

    for(int i = 0; i < all.size() - 1; i++){

        LL least = all[i], most = all[i];
        LL sum = all[i];
        
        for(int j = i + 1; j < all.size() && sum < tar; j++){
            sum += all[j];
            least = min(least, all[j]);
            most = max(most, all[j]);
        }

        if(tar == sum){
            return least + most;
        }
    }   

    return -1;
}

int main(){

    LL x;
    while(cin >> x){
        all.push_back(x);
    }

    cout << question2() << endl;
    
    return 0;
}