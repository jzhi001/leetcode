class Solution {
public:
    bool canFinish(int courseCnt, vector<vector<int>>& pre) {

        vector<int> indegree(courseCnt, 0);
        vector<vector<int>> g(courseCnt, vector<int>());

        for(vector<int> &v : pre){
            int a = v[0], b = v[1];
            indegree[b] ++;
            g[a].push_back(b);
        }

        queue<int> q;
        int seen = 0;

        for(int i = 0; i < courseCnt; i++){
            if(indegree[i] == 0) q.push(i);
        }

        while(q.size()){
            int u = q.front();
            q.pop();

            seen ++;

            for(int t : g[u]){
                indegree[t] --;
                if(indegree[t] == 0) q.push(t);
            }
        }

        return seen == courseCnt;
    }
};