//答案思路：如果[0,n]是一个段，那这段的最大值一定是n
//遍历，如果[0,i]的最大值就是i，那么结果加1
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int len = arr.length;
        int count = 0;

        int[] pos = new int[len];
        for(int i=0; i<len; i++){
            int val = arr[i];
            pos[val] = i;
            arr[i] = -1; //use arr for recording blocks
        }
        int block = 0;
        for(int i= 0; i < len; i++){
            int where = pos[i];
            if( i != where){
                block(arr, where, i, block++);
            }
        }
        block = -1; //reset for counting number of blocks
        for(int i=0; i<len; i++){
            int dis = arr[i];
            if(dis == -1){
                count++;
                continue;
            }
            if(block != dis){
                count++;
                block = dis;
            }
        }
        return count;
    }
    
    private void block(int[] arr, int from, int to, int num){
        if(from > to){
            int temp = from;
            from = to;
            to = temp;
        }
        for(int i=from; i<=to; i++){
            //if there's already a block
            if(arr[i] != -1){
                int change = arr[i];
                //merge the old one
                for(int j = 0; j < arr.length; j++){
                    if(arr[j] == change)    arr[j] = num;
                }
            }
            arr[i] = num;
        }
    }
}