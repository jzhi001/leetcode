/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    vector<int> largestValues(TreeNode* root) {
        
        queue<TreeNode*> q;
        if(root) q.push(root);

        vector<int> ans;

        while(q.size()){

            int n = q.size();
            int mx = INT_MIN;
            for(int i = 0; i < n; i++){
                TreeNode *node = q.front();
                q.pop();

                mx = max(mx, node->val);

                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }

            ans.push_back(mx);
        }

        return ans;
    }
};