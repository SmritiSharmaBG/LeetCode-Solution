class Solution {
        public String reorganizeString(String s) {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int[] map = new int[26];

            // frequency map
            for (int i = 0; i < s.length(); i ++) {
                char ch = s.charAt(i);
                map[ch - 'a'] ++;
            }

            // initialize pq
            for (int i = 0; i < 26; i ++) {
                if (map[i] > 0) {
                    char ch = (char)(i + 'a');
                    pq.add(new Pair(ch, map[i]));
                }
            }

            StringBuilder str = new StringBuilder();

            // initial condition
            Pair oldPair = pq.remove();
            str.append(oldPair.c);
            oldPair.f --;

            while (pq.size() > 0) {
                Pair newPair = pq.remove();
                str.append(newPair.c);
                newPair.f --;
                if (oldPair.f > 0) pq.add(oldPair);
                oldPair = newPair;
            }

            if(oldPair.f > 0) return "";
            return str.toString();
        }
    }

class Pair implements Comparable<Pair> {
        public char c;
        public int f;

        Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }

        @Override
        public int compareTo(Pair p) { // MAX-HEAP
            return ((Integer) p.f).compareTo(f);
        }
    }
