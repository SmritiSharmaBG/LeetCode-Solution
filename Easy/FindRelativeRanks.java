class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Ele> pq = new PriorityQueue<>((a, b) -> b.score - a.score);
        for (int i = 0; i < score.length; i ++) {
            pq.add(new Ele(score[i], i));
        }
        
        String[] ans = new String[score.length];
        int rank = 1;
        while(!pq.isEmpty()) {
            Ele e = pq.remove();
            int p = e.arrPos;
            if(rank == 1) ans[p] = "Gold Medal";
            else if(rank == 2) ans[p] = "Silver Medal";
            else if(rank == 3) ans[p] = "Bronze Medal";
            else ans[p] = ""+rank;
            rank ++;
        }
        return ans;        
    }
    
    class Ele {
        int score;
        int arrPos;
        Ele(int s, int pos) {
            this.score = s;
            this.arrPos = pos;
        }
    }
}
