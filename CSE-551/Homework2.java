import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Homework2 {
    
    static class Hospital{
        String name;
        // since we never look back, iterator is well enough to go
        Iterator<String> preference;
        // free positions
        int position;

        Hospital(String name, int position, List<String> preference){
            this.name = name;
            this.position = position;
            this.preference = preference.iterator();
        }
        
        public boolean isOpen(){
            return position > 0 && preference.hasNext();
        }
    }

    static class Student{
        
        String name;
        String offer;
        // hospital name => ranking
        Map<String, Integer> preference;

        Student(String name, List<String> p){
            this.name = name;
            this.preference = new HashMap<>();

            for(int i = 0; i < p.size(); i++){
                preference.put(p.get(i), i);
            }
        }

        // haven't reveive any offer
        boolean isFree(){
            return offer == null;
        }

        // prefer [h] than current offer?
        boolean prefer(String h){
            if(isFree()){
                throw new IllegalStateException("student has no offer");
            }
            return preference.get(h) < preference.get(offer);
        }

        @Override
        public String toString() {
            return String.format("%s: %s", name, preference);
        }
    }

    private static void galeShapley(Map<String, Hospital> hospitals,
                                    Map<String, Student> students){

        Queue<Hospital> queue = new LinkedList<>(hospitals.values());

        while(!queue.isEmpty()){

            Hospital h = queue.peek();
            String studentName = h.preference.next();
            Student s = students.get(studentName);

            if(s == null){
                throw new RuntimeException("no user find: " + studentName);
            }

            if(!s.isFree() && !s.prefer(h.name)){
                // s has a better offer
                continue;
            }

            if(!s.isFree()){
                // return offer of current hospital
                Hospital prev = hospitals.get(s.offer);
                prev.position ++;
                if(prev.isOpen()){
                    queue.add(prev);
                }
            }

            h.position --;
            s.offer = h.name;
            
            if(!h.isOpen()){
                queue.poll();
            }  
        }
    }
    
    // Input format:
    // first line contains 2 numbers: hospital number N and student number M.
    // for next N lines, each line contains information of a hospital:
    // <hospital-name> <preference-count> <preference-1> <preference-2> ... 
    // for next M lines, each line contains information of a student:
    // <student-name> <preference-count> <preference-1> <preference-2> ... 
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);

        int hospitalNum = scanner.nextInt();
        int studentNum = scanner.nextInt();

        Map<String, Hospital> hospitals = new HashMap<>();
        Map<String, Student> students = new HashMap<>();

        for(int i = 0; i < hospitalNum; i++){
            String name = scanner.next();
            int position = scanner.nextInt();
            List<String> preference = new ArrayList<>();

            for(int j = 0; j < position; j++){
                preference.add(scanner.next());
            }
            hospitals.put(name, new Hospital(name, position, preference));
        }
        

        for(int i = 0; i < studentNum; i++){

            String name = scanner.next();
            int preferenceCnt = scanner.nextInt();
            List<String> preference = new ArrayList<>();

            for(int j = 0; j < preferenceCnt; j++){
                preference.add(scanner.next());
            }

            students.put(name, new Student(name, preference));
        }

        // System.out.println(students);

        galeShapley(hospitals, students);

        Map<String, List<String>> hospitalOffers = new HashMap<>();
        for(Student s : students.values()){
            if(s.isFree()){
                continue;
            }
            hospitalOffers.putIfAbsent(s.offer, new ArrayList<>());
            hospitalOffers.get(s.offer).add(s.name);
        }

        for(Map.Entry<String, List<String>> e : hospitalOffers.entrySet()){
            System.out.printf("%s: %s%n", e.getKey(), String.join(", ", e.getValue()));
        }

        scanner.close();
    }
}
