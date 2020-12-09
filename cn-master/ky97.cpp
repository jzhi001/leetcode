#include <iostream>
#include <string>

using namespace std;

int rev(int x){
    int ans = 0;
    
    while(x){
        int d = x % 10;
        ans = ans * 10 + d;
        x /= 10;
    }
    
    return ans;
}

int main(){
    
    int a, b;
    while(cin >> a >> b){
        
        int x = rev(a) + rev(b), y = rev(a + b);
        
        if(x == y) cout << (a + b) << endl;
        else cout << "NO" << endl;
    }
}