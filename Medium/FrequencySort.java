class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        int[] map = new int[62];
        
        // marking frequency - O(n)
        for(int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') map[ch - 'a'] ++;
            else if(ch >= 'A' && ch <= 'Z')map[26 + (ch - 'A')] ++;
            else map[52 + (ch - '0')] ++;
        }
        
        // adding in the PQ - O(26)
        for (int i = 0; i < 62; i ++) {
            int f = map[i];
            if(f > 0) {
                char c;
                if(i < 26) c = (char)(i + 'a');
                else if(i < 52) c = (char)((i - 26) + 'A');
                else c = (char)((i - 52) + '0');
                pq.add(new Pair(c, f));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        // extracting from PQ - O(n*log n)
        while(pq.size() > 0) {
            Pair temp = pq.remove();
            int f = temp.freq;
            char c = temp.ch;
            for(int i = 0; i < f; i ++) {
                ans.append(c); 
            }
        }
        
        return ans.toString();
        
    }
    
    class Pair { // Max-Heap
        char ch;
        int freq;
        
        Pair(char c, int f) {
            this.ch = c;
            this.freq = f;
        }
    }
}
