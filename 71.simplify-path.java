/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
class Solution {
     static class Node{
        String name;
        Node next;
        Node prev;
        
        Node(String name){
            this.name = name;
        }
    }
    
    public String simplifyPath(String path) {
        if(path == null || path.isEmpty()) return "/";
        
        Node root = new Node("/");
        Node cur = root;
        
        int N = path.length();
        int i = 1;
        while(i < N){
            int nameEnd = i;
            while(nameEnd < N && path.charAt(nameEnd) != '/') nameEnd++;
            String name = path.substring(i, nameEnd);
            
            if(name.equals(".") || name.isEmpty()){
                
            }else if(name.equals("..")){
                if(cur.prev != null) cur = cur.prev;
                cur.next = null;
            }else{
                cur.next = new Node(name);
                cur.next.prev = cur;
                cur = cur.next;
            }
            i = nameEnd + 1;
        }
        
        StringBuilder sb = new StringBuilder();
        while(root != null){
            sb.append(root.name);
            if(root.prev != null && root.next != null) sb.append("/");
            root = root.next;
        }
        return sb.toString();
        
    }
} 

