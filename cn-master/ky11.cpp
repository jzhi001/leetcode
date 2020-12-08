#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>

using namespace std;

struct Node{
    char val;
    Node *left;
    Node *right;

    Node(char _val): val(_val){}
};

void inorder(Node *rt){
    if(rt == NULL) return;

    inorder(rt->left);
    printf("%c ", rt->val);
    inorder(rt->right);
}

Node *recur(string& s, int& i){

    char c = s[i ++];

    if(c == '#'){
        return NULL;
    }

    Node *u = new Node(c);

    if(i < s.size()) u->left = recur(s, i);
    if(i < s.size()) u->right = recur(s, i);

    return u;
}

int main(){
    
    string line;

    while(getline(cin, line)){
        int i = 0;
        Node *rt = recur(line, i);

        inorder(rt);
        puts("");
    }

    return 0;
}