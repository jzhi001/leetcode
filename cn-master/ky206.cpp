#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

bool valid(int x){
    return x >= 0 && x <= 255;
}

int main(){

    int a, b, c, d;

    while(~scanf("%d.%d.%d.%d", &a, &b, &c, &d)){

        bool ans = valid(a) && valid(b) && valid(c) && valid(d);

        if(ans) puts("Yes!");
        else puts("No!");
    }

    return 0;

}