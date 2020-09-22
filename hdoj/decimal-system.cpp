#include <iostream>
#include <algorithm>
#include <vector>
#include <string>


// TAG: 字符串，模拟
// http://acm.hdu.edu.cn/game/entry/problem/show.php?chapterid=1&sectionid=2&problemid=18

using namespace std;

int n, idx;
string s;

int parse(int radix){

    int ans = 0;

    for(int w = 0; idx >= 0 && s[idx] != '('; idx--, w++){

        int x = 1;

        for(int j = 0; j < w; j++) x *= radix;

        ans += x * (s[idx] - '0');
    }

    return ans;
}

int main(){

    while(cin >> n){

        int ans = 0;

        for(int i = 0; i < n; i++){
            cin >> s;

            idx = s.length() - 2;

            int radix = parse(10);

            idx--;

            int x = parse(radix);

            // cout << "debug " << radix << ' ' << x << endl;

            ans += x;
        }

        cout << ans << endl;
    }
    
    return 0;

}

