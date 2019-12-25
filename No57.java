/**
 * https://www.lintcode.com/problem/insert-interval/description
 *
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> list, Interval n) {
        list.add(0, n);
        
        for(int i=0; i<list.size(); i++){
            if(i == list.size() - 1) break;
            Interval x = list.get(i), rt = list.get(i + 1);
            if(x.start > rt.end) {
                Collections.swap(list, i, i + 1);
                continue;
            }else if(x.end < rt.start){
                continue;
            }else{
                //merge rights
                int j = i + 1;
                while(j < list.size()){
                    rt = list.get(j);
                    if(x.end < rt.start) break;
                    x.start = Math.min(x.start, rt.start);
                    x.end = Math.max(x.end, rt.end);
                    list.remove(i + 1);
                }
            }
            
        }
        
        return list;
    }
}
