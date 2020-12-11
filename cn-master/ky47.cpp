#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int main(){

    int a, b;

    while(cin >> a >> b){

        vector<int> A, B;

        while(a){
            A.push_back(a);
            a /= 2;
        }

        while(b){
            B.push_back(b);
            b /= 2;
        }

        reverse(A.begin(), A.end());
        reverse(B.begin(), B.end());

        a = A.size() - 1, b = B.size() - 1;

        while(A[a] != B[b]){
            if(a > b) a --;
            else b --;
        }

        cout << A[a] << endl;
    }

    return 0;

}