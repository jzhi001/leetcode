import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
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

        int positions;
        
        LinkedHashSet<String> offers;


        Hospital(String name, int positions, List<String> preference){
            this.name = name;
            this.preference = preference.iterator();
            this.positions = positions;
            this.offers = new LinkedHashSet<>();
        }
        
        public boolean isOpen(){
            return positions > 0 && preference.hasNext();
        }

        public void offerTo(String student){
            positions --;
            offers.add(student);
        }

        public void cancelOffer(String student){
            positions ++;
            offers.remove(student);
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

        void acceptOffer(String hospital){
            this.offer = hospital;
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

            Hospital h = queue.poll();
            String studentName = h.preference.next();
            Student s = students.get(studentName);
            
            System.out.println("dequeue and get " + h.name + ", try giving offer to " + s.name);

            if(s == null){
                throw new RuntimeException("no user find: " + studentName);
            }

            if(!s.isFree() && !s.prefer(h.name)){
                // s has a better offer
                System.out.println(s.name + " has better offer from hospital " + h.name + ", he/she refuses to change\n");
                continue;
            }

            if(!s.isFree()){
                // return offer of current hospital
                Hospital prev = hospitals.get(s.offer);
                System.out.println(s.name + " reject current offer" + prev.name + " and accepts hospital " + h.name);

                prev.cancelOffer(s.name);

                if(prev.isOpen()){
                    queue.add(prev);
                }
            }else{
                System.out.println(s.name + " has no offer, so he/she accepts hospital " + h.name);
            }

            s.acceptOffer(h.name);
            h.offerTo(s.name);
            
            if(h.isOpen()){
                System.out.println(h.name + " has " + h.positions + " open postions, so enqueue " + h.name);
                queue.add(h);
            }
            System.out.println();
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

        Map<String, Hospital> hospitals = new LinkedHashMap<>();
        Map<String, Student> students = new LinkedHashMap<>();

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

        for(Hospital hospital : hospitals.values()){
            System.out.printf("%s: %s\n", hospital.name, hospital.offers);
        }

        scanner.close();
    }
}
