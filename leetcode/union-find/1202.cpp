const int N = 1e5 + 10;

class Solution {
public:

    int p[N];

    int parent(int x){
        if(p[x] != x) p[x] = parent(p[x]);
        return p[x];
    }

    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {

        for(int i = 0; i < N; i++) p[i] = i;

        for(auto& e : pairs){
            int pa = parent(e[0]), pb = parent(e[1]);
            if(pa != pb){
                p[pa] = pb;
            }
        }

        unordered_map<int, vector<char>> hash;

        for(int i = 0; i < s.size(); i++){
            int pi = parent(i);
            hash[pi].push_back(s[i]);
        }

        for(auto& p : hash){
            vector<char>& v = p.second;
            sort(v.begin(), v.end(), greater<char>());
        }

        string ans;

        for(int i = 0; i < s.size(); i++){
            int pi = parent(i);

            ans += hash[pi].back();
            hash[pi].pop_back();
        }

        return ans;
    }
};