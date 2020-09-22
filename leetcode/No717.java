class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null) return false;
        if(bits.length == 1)    return true;
        
        int i =0;
        for(; i<bits.length; i++){
            if(bits[i] == 1){
                if(i==bits.length-2)
                    return false;
                i++;
            }
        }
        return true;
    }
}