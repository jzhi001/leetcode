#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <climits>

using namespace std;

const int N = 10010;

int n, a[N], f[N];

int main(){

    while(cin >> n){

        if(n == 0) break;

        for(int i = 0; i < n; i++) scanf("%d", &a[i]);

        int start = 0, end = 0, ans = INT_MIN;

        // 当前状态：以第i个元素结尾的连续子序列的最大值
        // 需要记录当前状态是从哪开始的
        //  如果f[i-1] < 0，直接丢弃，从当前元素开始
        //  否则，拼接上f[i-1]
        // 最后判断最大的连续子序列是否以a[i]结尾
        for(int i = 0, s = 0; i < n; i++){

            f[i] = a[i];

            if(i > 0 && f[i - 1] < 0){
                s = i;
            }else{
                f[i] += f[i - 1];
            }

            if(ans < f[i]){
                start = s;
                end = i;
                ans = f[i];
            }
        }

        if(ans < 0){
            ans = 0;
            start = 0;
            end = n - 1;
        }

        printf("%d %d %d\n", ans, a[start], a[end]);
    }

    return 0;
}