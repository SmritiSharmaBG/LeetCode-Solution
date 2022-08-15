class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int maxSize;
    public KthLargest(int k, int[] nums) {
        maxSize = k;
        for(int it : nums) pq.add(it);
        while(pq.size() > k) pq.remove();
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > maxSize)
            pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
