#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <stack>

using namespace std;

int main(){
    
    int n;

    while(cin >> n){

        stack<int> stk;

        while(n --){

            char op;
            cin >> op;

            if(op == 'P'){
                int x;
                cin >> x;

                stk.push(x);
            }else if(op == 'O'){
                if(stk.size()) stk.pop();
            }else{
                if(stk.size()) cout << stk.top() << endl;
                else cout << 'E' << endl;
            }
        }

        cout << endl;
    }

    return 0;
}