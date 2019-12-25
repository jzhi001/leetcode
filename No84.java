class Solution {
    public int largestRectangleArea_bruteForce(int[] A) {
        if(A == null || A.length == 0) return 0;
        int N = A.length;

        int result = 0;

        for(int i = 0; i < N; i++){
            int h = A[i], area = h;
            for(int j = i - 1; j >= 0 && A[j] >= h; j--){
                area += h;
            }
            for(int j = i + 1; j < N && A[j] >= h; j++){
                area += h;
            }
            result = Math.max(result, area);
        }

        return result;
    }

    public int largestRectangleArea_divideAndConquer(int[] A) {
        if(A == null || A.length == 0) return 0;
        int N = A.length;

        return divideAndConquer(A, 0, N - 1);
    }

    public int divideAndConquer(int[] A, int s, int e){
        if(s < 0 || e >= A.length || s > e) return 0;

        int idx_h = s;
        for(int i = s + 1; i <= e; i++){
            if(A[i] < A[idx_h]){
                idx_h = i;
            }
        }

        int area = A[idx_h] * (e - s + 1);

        int left = divideAndConquer(A, s, idx_h - 1);
        int right = divideAndConquer(A, idx_h + 1, e);

        return Math.max(area, Math.max(left, right));
    }

    public int largestRectangleArea_deivideAndConquer_with_segmentTree(int[] A) {
        if(A == null || A.length == 0) return 0;
        SegmentTreeNode root = buildSegmentTree(A, 0, A.length - 1);
        return divideAndConquer(root, A, 0, A.length - 1);
    }

    private int divideAndConquer(SegmentTreeNode node, int[] A, int start, int end){
        if(start > end) return Integer.MIN_VALUE;
        else if(start == end) return A[start];

        int idx_h = minIdx(node, A, start, end);
        // System.out.printf("%d %d => %d\n", start, end, idx_h);
        int h = A[idx_h];
        int area = h * (end - start + 1);
        int left = divideAndConquer(node, A, start, idx_h - 1);
        int right = divideAndConquer(node, A, idx_h + 1, end);
        return Math.max(area, Math.max(left, right));
    }

    private int minIdx(SegmentTreeNode node, int[] A, int start, int end){
        if(node == null || start > node.end || end < node.start){
            return -1;
        }else if(start <= node.start && end >= node.end){
            return node.min_idx;
        }

        int lfIdx = minIdx(node.left, A, start, end);
        int rtIdx = minIdx(node.right, A, start, end);

        if(lfIdx == -1) return rtIdx;
        else if(rtIdx == -1) return lfIdx;
        return A[lfIdx] < A[rtIdx] ? lfIdx : rtIdx;
    }

    private SegmentTreeNode buildSegmentTree(int[] A, int start, int end){
        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if(start == end){
            node.min_idx = start;
            return node;
        }

        int mid = (start + end) / 2;

        node.left = buildSegmentTree(A, start, mid);
        node.right = buildSegmentTree(A, mid + 1, end);

        node.min_idx = A[node.left.min_idx] < A[node.right.min_idx] ? node.left.min_idx : node.right.min_idx;

        return node;
    }

    public static class SegmentTreeNode{
        int start;
        int end;
        int min_idx;
        SegmentTreeNode left;
        SegmentTreeNode right;

        SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

}