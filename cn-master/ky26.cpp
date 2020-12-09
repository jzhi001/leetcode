#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

void display(vector<int>& a){
    for(int& x : a){
        cout << x;
    }

    cout << endl;
}

vector<int> convert(string& s){
    vector<int> ans;

    for(int i = 0; i < s.size(); i++){
        ans.push_back(s[i] - '0');
    }

    return ans;
}

vector<int> multi2(vector<int>& a){

    vector<int> ans;

    int carry = 0;

    for(int i = a.size() - 1; i >= 0; i--){

        // cout << "i " << a[i] << endl;

        int t = a[i] * 2 + carry;

        // cout << t << endl;

        ans.push_back(t % 10);
        carry = t / 10;
    }

    if(carry > 0) ans.push_back(carry);

    reverse(ans.begin(), ans.end());

    return ans;
}

vector<int> div2(vector<int>& a){

    vector<int> ans;

    for(int i = 0, x = 0; i < a.size(); i++){
        int cur = x * 10 + a[i];

        int d = cur / 2;

        if(ans.size() || d != 0) ans.push_back(d);

        x = cur % 2;
    }

    if(ans.empty()) ans.push_back(0);

    return ans;
}

vector<int> add(vector<int>& a, vector<int>& b){

    vector<int> ans;

    for(int i = a.size() - 1, j = b.size() - 1, carry = 0; 
        i >= 0 || j >= 0 || carry > 0;
        i --, j--){
        
        int sum = carry;
        if(i >= 0) sum += a[i];
        if(j >= 0) sum += b[j];

        ans.push_back(sum % 10);
        carry = sum / 10;

    }

    reverse(ans.begin(), ans.end());

    return ans;
}

bool isZero(vector<int> a){
    return a.size() == 1 && a[0] == 0;
}

vector<int> reversedBinary(vector<int> a){

    vector<int> ans;

    while(!isZero(a)){
        ans.push_back(a.back() % 2);
        a = div2(a);
    }

    return ans;
}

vector<int> decimal(vector<int> a){
    vector<int> ans = {0};

    vector<int> powOf2 = {1};

    for(int i = a.size() - 1; i >= 0; i--){

        if(a[i] == 1){
            // cout << "add ";
            // display(powOf2);
            ans = add(ans, powOf2);
            // display(ans);
        }

        powOf2 = multi2(powOf2);
    }

    return ans;
}

int main(){

    string s;
    cin >> s;

    vector<int> num = convert(s);

    vector<int> b = reversedBinary(num);
    
    // display(b);

    vector<int> ans = decimal(b);

    display(ans);
    
    return 0;
}