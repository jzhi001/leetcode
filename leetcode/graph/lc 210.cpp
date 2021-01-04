class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& pre) {

        vector<int> ans;

        vector<int> indegree(numCourses, 0);
        vector<vector<int>> g(numCourses, vector<int>());

        for(vector<int>& e : pre){
            int a = e[0], b = e[1];
            g[a].push_back(b);
            indegree[b] ++;
        }

        queue<int> q;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.push(i);
        }

        while(q.size()){
            int u = q.front();
            q.pop();

            ans.push_back(u);

            for(int t : g[u]){
                indegree[t] --;
                if(indegree[t] == 0){
                    q.push(t);
                }
            }
        }

        reverse(ans.begin(), ans.end());
        if(numCourses != ans.size()) ans.clear();
        return ans;
    }
};