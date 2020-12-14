#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(){

    int a, b;
    char op;

    cin >> a >> op;

    if(op == '!'){

        int ans = 1;

        for(int i = a; i > 1; i--) ans *= i;

        cout << ans << endl;
    }else{
        cin >> b;

        if(op == '+'){
            cout << a + b << endl;
        }else if(op == '-'){
            cout << a - b << endl;
        }else if(op == '*'){
            cout << a * b << endl;
        }else if(op == '/'){
            if(b == 0) cout << "error" << endl;
            else cout << a / b << endl;
        }else if(op == '%'){
            if(b == 0) cout << "error" << endl;
            else cout << a % b << endl;
        }
    }
    
    return 0;

}