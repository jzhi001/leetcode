#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <unordered_set>

using namespace std;

typedef pair<string, int> Instruction;

vector<Instruction> program;

bool runOnce(int& accumulator){

    unordered_set<int> st;

    int pc = 0;

    while(!st.count(pc) && pc < program.size()){

        st.insert(pc);

        Instruction ins = program[pc];

        string op = ins.first;
        int arg = ins.second;

        if(op == "acc"){
            accumulator += arg;
        }else if(op == "jmp"){
            pc += arg;
        }

        if(op != "jmp") pc ++;
    }

    return pc == program.size();
}

void question1(){

    int ans = 0;
    runOnce(ans);

    cout << ans << endl;
}

int question2(){

    for(Instruction& ins : program){

        string& op = ins.first;

        if(op == "acc") continue;

        int accumulator = 0;

        string orig = op;

        if(op == "jmp") op = "nop";
        else op = "jmp";

        if(runOnce(accumulator)){
            return accumulator;
        }

        op = orig;
    }

    return -1;
}

int main(){

    string op;
    int arg;

    while(cin >> op >> arg){

        program.push_back({op, arg});
    }

    cout << question2() << endl;
    

    return 0;
}