class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        String ans = "";
        int min = Integer.MAX_VALUE;
        
        // Store the t data into a HashMap
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n2; i ++) {
            char ch = t.charAt(i);
            if (!hm.containsKey(ch)) hm.put(ch, 1);
            else {
                int f = hm.get(ch);
                hm.put(ch, ++ f);
            }
        }
        
        int i = 0;
        int j = 0;
        int count = hm.size();
        
        // Start traversing the string
        while (i < n1 && j < n1) {
            
            // Keep incrementing the RHS until the basic condition is met 
            while (count != 0 && j < n1) {
                char ch = s.charAt(j);
                if (hm.containsKey(ch)) {
                    int f = hm.get(ch);
                    hm.put(ch, -- f);
                    if (f == 0) count --;
                }
                j ++;
            }
            
            // After the basic condition is met, we need to optimize it
            while (count == 0) {
                int len = j - i + 1;
                
                // Saving the candidate as ans
                if (len < min) {
                    min = len;
                    ans = s.substring(i, j);
                }
                
                char ch = s.charAt(i);
                if (!hm.containsKey(ch)) i ++;
                else {
                    int f = hm.get(ch);
                    hm.put(ch, ++ f);
                    if (f > 0) count ++;
                    i ++;
                }
            }
        }
        return ans;
    }
}
