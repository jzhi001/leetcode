/*
 * @lc app=leetcode id=1104 lang=java
 *
 * [1104] Path In Zigzag Labelled Binary Tree
 */
class Solution {
    public List<Integer> pathInZigZagTree(int x) {
    
        LinkedList<Integer> ret = new LinkedList<>();
        if(x == 1) return Arrays.asList(1);
        
        int level = 1;
        while(x > getEnd(level)) level++;
        
        int off = getParentOffset(x, level);
        level--;
       
        ret.addFirst(x);
        
        while(level > 0){
            int s = getStart(level), e = getEnd(level); 
            x = s + off;
            
            // System.out.printf("level: %d, off: %d, s: %d, e: %d x: %d\n", level, off, s, e, x);
            
            off = getParentOffset(x, level);
            ret.addFirst(x);
            level--;
        }
        
        ret.addFirst(1);
        return ret;
    }
    
    private int getStart(int level){
        return 1 << level;
    }
    
    private int getEnd(int level){
        return ((1 << (level + 1)) - 1);
    }
    
    private int getCount(int level){
        return 1 << level;
    }
    
    private int getParentOffset(int x, int level){
        int s = getStart(level);
        int off = (x - s) / 2;
        return getCount(level - 1) - 1 - off;
    }
}