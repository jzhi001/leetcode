#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

string preorder, inorder;

struct Node{
    char val;
    Node *left;
    Node *right;

    Node(char _val): val(_val){}
};

Node *build(int ps, int pe, int is, int ie){

    Node *rt = new Node(preorder[ps]);

    int irt = find(inorder.begin(), inorder.end(), rt->val) - inorder.begin();

    int lfChildren = irt - is;

    if(irt > is){
        rt->left = build(ps + 1, ps + lfChildren, is, irt - 1);
    }

    if(irt < ie){
        rt->right = build(ps + lfChildren + 1, pe, irt + 1, ie);
    }
    
    return rt;
}

string postOrder(Node *rt){

    if(rt == NULL) return "";

    string ans;

    ans += postOrder(rt->left);
    ans += postOrder(rt->right);
    ans += rt->val;

    return ans;
}

int main(){

    while(cin >> preorder >> inorder){

        Node *rt = build(0, preorder.size() - 1, 0, inorder.size() - 1);

        cout << postOrder(rt) << endl;
    }
    
    return 0;

}