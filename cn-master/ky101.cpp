#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

void display(vector<int>& a){
    for(int& x : a) cout << x;
    cout << endl;
}

bool le(vector<int>& a, vector<int>& b){

    if(a.size() != b.size()) return a.size() < b.size();

    for(int i = 0; i < a.size(); i++){
        if(a[i] != b[i])
            return a[i] < b[i];
    } 

    return true;
}

vector<int> convert(string& s){

    vector<int> ans;

    for(char c : s){
        ans.push_back(c - '0');
    }

    return ans;
}

vector<int> addVector(vector<int>& a, vector<int>& b){

    vector<int> ans;

    for(int i = 0, j = 0, carry = 0;
        carry > 0 || i < a.size() || j < b.size();
        i ++, j ++){

        int t = carry;
        if(i < a.size()) t += a[i];
        if(j < b.size()) t += b[j];

        ans.push_back(t % 10);

        carry = t / 10;
    }

    return ans;
}

void add(vector<int> a, vector<int> b){

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    vector<int> ans = addVector(a, b);

    while(ans.size() > 1 && ans.back() == 0) ans.pop_back();

    reverse(ans.begin(), ans.end());

    display(ans);
}

void substract(vector<int> a, vector<int> b){

    bool neg = false;

    if(le(a, b)){
        swap(a, b);
        neg = true;
    }

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    vector<int> ans;

    int carry = 0;

    for(int i = 0; i < a.size(); i++){

        int t = carry + a[i];
        if(i < b.size()) t -= b[i];

        if(t < 0){
            t += 10;
            carry = -1;
        }else{
            carry = 0;
        }

        ans.push_back(t);
    }

    while(ans.size() > 1 && ans.back() == 0) ans.pop_back();

    reverse(ans.begin(), ans.end());

    if(carry < 0 || neg) cout << '-';

    display(ans);
}

void times(vector<int> a, vector<int> b){

    if(a.size() < b.size()) swap(a, b);

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    vector<int> ans = {0};

    for(int i = 0; i < b.size(); i++){

        vector<int> cur;

        for(int j = 0; j < i; j++) cur.push_back(0);

        for(int j = 0, carry = 0; carry > 0 || j < a.size(); j++){

            int t = carry;
            if(j < a.size()) t += a[j] * b[i];

            carry = t / 10;

            cur.push_back(t % 10);
        }

        // display(cur);

        ans = addVector(ans, cur);
    }

    // display(ans);

    while(ans.size() > 1 && ans.back() == 0) ans.pop_back();

    reverse(ans.begin(), ans.end());

    display(ans);
}

int main(){
    
    string a, b;

    while(cin >> a >> b){

        vector<int> A = convert(a), B = convert(b);

        add(A, B);
        substract(A, B);
        times(A, B);
    }

    return 0;
}