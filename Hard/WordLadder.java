class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int n = beginWord.length();
            HashMap<String, Boolean> hm = new HashMap<>();
            for(String it : wordList) hm.put(it, false);

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(beginWord, 1));

            while (!queue.isEmpty()) {
                Pair p = queue.remove();
                List<String> possibleWords = getTransformedWords(p.str, n, hm);
                for (String it : possibleWords) {
                    if (it.equalsIgnoreCase(endWord)) return p.step + 1;
                    queue.add(new Pair(it, p.step + 1));
                }
            }
            return 0;
        }

        private List<String> getTransformedWords(String str, int n, HashMap<String, Boolean> hm) {
            List<String> possibleWords = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder transString = new StringBuilder(str);
                for (int j = 0; j < 26; j++) {
                    int repAscii = j + 'a';
                    transString.setCharAt(i, (char) repAscii);
                    String string = transString.toString();
                    if (hm.containsKey(string) && !string.equalsIgnoreCase(str) && !hm.get(string)) {
                        hm.put(string, true);
                        possibleWords.add(string);
                    }
                }
            }
            return possibleWords;
        }
    }

class Pair {
        String str;
        int step;

        Pair(String s, int st) {
            str = s;
            step = st;
        }
    }
