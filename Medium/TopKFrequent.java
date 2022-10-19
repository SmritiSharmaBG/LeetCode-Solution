class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        // 1. Add in HashMap
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String s : words) {
            if (!hm.containsKey(s)) {
                hm.put(s, 1);
            } else {
                int f = hm.get(s);
                hm.put(s, f + 1);
            }
        } // added in HashMap
        
        // 2. Add in 'k' sized Priority-Queue
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Map.Entry<String,Integer> mapElement : hm.entrySet()) {
            String key = mapElement.getKey();
            int value = mapElement.getValue();
            Element e = new Element(key, value);
            pq.add(e);  
            if(pq.size() > k) {
                  pq.remove();
            }            
        }
        
        // 3. Transfer all the elements of Priority Queue into ArrayList
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            Element e = pq.remove();
            list.add(e.str);
        }
        
        // 4. We need to reverse the List because Priority-Queue is Priority Based FIFO
        Collections.reverse(list);
        return list;        
    }
    
    class Element implements Comparable<Element> {
        String str;
        int freq;
        Element(String s, int f) {
            str = s;
            freq = f;
        }

        @Override
        public int compareTo(Element e) {
            int ans = ((Integer)this.freq).compareTo(e.freq); // Min - Heap : Ascending Order
            if (ans == 0) return e.str.compareTo(this.str); // Descending Order
            return ans;
        }
    }
}
