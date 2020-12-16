#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

struct Node{
    int val;
    Node *left;
    Node *right;

    Node(int _val): val(_val){}
};

int insert(Node *rt, int tar){

    if(tar < rt->val){

        if(rt->left == NULL){
            rt->left = new Node(tar);
            return rt->val;
        }else{
            return insert(rt->left, tar);
        }
        
    }else{

        if(rt->right == NULL){
            rt->right = new Node(tar);
            return rt->val;
        }else{
            return insert(rt->right, tar);
        }
    }
}

int main(){

    int n, x;

    while(cin >> n){

        Node *rt = NULL;

        for(int i = 0; i < n; i++){

            cin >> x;

            if(i == 0){
                rt = new Node(x);
                cout << -1 << endl;
            }else{

                int ans = insert(rt, x);
                cout << ans << endl;
            }
        }
    }
    
    return 0;

}