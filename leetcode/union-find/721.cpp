class Solution {
public:

    unordered_map<string, string> name, p;

    string parent(string x){
        if(p[x] != x) p[x] = parent(p[x]);
        return p[x];
    }

    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {

        for(auto& v : accounts){

            string acc = v[0];
            string email;

            for(int i = 1; i < v.size(); i++){
                string u = v[i];

                // cout << u << endl;

                if(!p.count(u)) p[u] = u;
                if(!name.count(u)) name[u] = acc;

                if(email.empty()){
                    email = u;
                    continue;
                }
                
                string pu = parent(u), pe = parent(email);

                if(pu != pe) p[pu] = pe;

                // cout << u << ' ' << parent(u) << endl;
            }
        }

        unordered_map<string, vector<string>> hash;
        unordered_set<string> st;

        for(auto& v : accounts){
            for(int i = 1; i < v.size(); i++){
                string email = v[i];
                if(st.count(email)) continue;
                st.insert(email);
                hash[parent(email)].push_back(email);
            }
        }

        vector<vector<string>> ans;

        for(auto& p : hash){
            vector<string> cur;
            cur.push_back(name[p.first]);
            for(auto& e : p.second){
                cur.push_back(e);
            }
            sort(cur.begin(), cur.end());
            ans.push_back(cur);
        }

        return ans;
    }
};