#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <cctype>

using namespace std;

int main()
{

    string s, ans;
    getline(cin, s);

    // cout << s << endl;

    for (char c : s)
    {
        if (!isalpha(c))
        {
            ans += c;
            continue;
        }

        if (c == 'Z')
            ans += 'A';
        else if (c == 'z')
            ans += 'a';
        else
            ans += (char)(c + 1);
    }

    cout << ans << endl;

    return 0;
}