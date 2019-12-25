class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if(arr == null || arr.length < 3) return result;
        Arrays.sort(arr);
        
        //first num a
        for(int i=0; i<arr.length-2; i++){
            int a = arr[i];
            if(a > 0) break;
            else if(i > 0 && a == arr[i-1]) continue;
            //second num b
            for(int j=i+1; j<arr.length-1; j++){
                int b = arr[j];
                if(j-1 > i && b == arr[j-1]) continue;
                int k = Arrays.binarySearch(arr, j + 1, arr.length, 0 - a - b);
                if(k == -1 || k <= j) continue;
                result.add(Arrays.asList(a, b, arr[k]));
            }
        }
        return result;
    }
}
