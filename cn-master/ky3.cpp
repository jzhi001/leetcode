#include <iostream>

using namespace std;

typedef long long LL;

int cnt(LL x){
    int ans = 0;
    
    for(LL i = 1; i <= x / i; i++){
        if(x % i == 0){
            ans ++;
            if(i != x / i) ans ++;
        }
    }
    
    return ans;
}

int main(){
    
    int n;
    cin >> n;
    
    while(n --){
        int x;
        cin >> x;
        
        cout << cnt(x) << endl;
    }
    
    return 0;
}