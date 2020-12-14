#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

bool isPrime(int x){

    if(x < 2) return false;

    for(int i = 2; i <= x / i; i++){

        if(x % i == 0) return false;

    }

    return true;
}

int main(){
    
    int n;

    while(cin >> n){

        vector<int> ans;

        for(int i = 2; i < n; i++){
            if(isPrime(i) && (i % 10 == 1)) 
                ans.push_back(i);
        }

        if(ans.empty()) cout << -1;
        else{
            
            for(int i = 0; i < ans.size(); i++){
                if(i) cout << ' ';
                cout << ans[i];
            }
        }
        
        cout << endl;
    }

    return 0;
}