#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>

using namespace std;

int n, m;

bool search(vector<int>& A, int tar){
    int l = 0, r = A.size() - 1;

    while(l < r){
        int mid = (l + r) >> 1;
        if(A[mid] >= tar) r = mid;
        else l = mid + 1;
    }

    return A[l] == tar;
}

int main(){

    while(cin >> n){
        vector<int> A;

        while(n --){
            int x;
            cin >> x;

            A.push_back(x);
        }

        sort(A.begin(), A.end());

        cin >> m;

        while(m --){
            int x;
            cin >> x;

            if(search(A, x)) puts("YES");
            else puts("NO");
        }
    }

    return 0;

}