#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

int gcd(int a, int b)
{
    return b ? gcd(b, a % b) : a;
}

int main()
{

    int n;

    while (cin >> n)
    {
        int mx = -1, mn = -1;

        while (n--)
        {
            int x;
            cin >> x;

            if (mx == -1 || x > mx)
                mx = x;
            if (mn == -1 || x < mn)
                mn = x;
        }

        printf("%d %d %d\n", mn, mx, gcd(mx, mn));
    }

    return 0;
}