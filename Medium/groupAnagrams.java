class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char[] charSet = str.toCharArray();
            Arrays.sort(charSet);
            String keyString = new String(charSet);
            if (hm.containsKey(keyString)) hm.get(keyString).add(str);
            else {
                hm.put(keyString, new ArrayList<>());
                hm.get(keyString).add(str);
            }
        }
        return new ArrayList<>(hm.values());
    }
}
