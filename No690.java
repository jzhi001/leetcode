//can be improved by using map (empId -> emp)
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    private HashMap<Integer, List<Integer>> emps = new HashMap<>();
    private HashMap<Integer, Integer> vals = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee each : employees){
            emps.put(each.id, each.subordinates);
            vals.put(each.id, each.importance);
        }
        return calc(id);
    }
    private int calc(int id){
        if(emps.get(id).size() == 0 )   return vals.get(id);
        int total = vals.get(id);
        for(int each: emps.get(id)){
            total += calc(each);
        }
        return total;
    }
        
}
