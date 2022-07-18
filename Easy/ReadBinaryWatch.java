class Solution {
    class Time {
        public boolean isValid;
        public String time;
        Time(boolean isValid, String time) {
            this.isValid = isValid;
            this.time = time;
        }
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        boolean[] dig = new boolean[10];
        rec(0, dig, turnedOn, ans);
        return ans;
    }
    
    void rec(int i, boolean[] dig, int turnedOn, List<String> ans) {
        if(i == 10 || turnedOn == 0) {
            Time t = new Time(false, "");
            if(turnedOn == 0 && isValid(dig, t)) {
                ans.add(t.time);
            }
            return;
        }
        rec(i+1, dig, turnedOn, ans);
        dig[i] = true;
        rec(i+1, dig, turnedOn - 1, ans);
        dig[i] = false;
    }
    
    boolean isValid(boolean[] dig, Time t) {
        int hr = 0;
        if(dig[0]) hr = hr + 8;
        if(dig[1]) hr = hr + 4;
        if(dig[2]) hr = hr + 2;
        if(dig[3]) hr = hr + 1;
        if(hr > 11) return false;
        int min = 0;
        if(dig[4]) min = min + 32;
        if(dig[5]) min = min + 16;
        if(dig[6]) min = min + 8;
        if(dig[7]) min = min + 4;
        if(dig[8]) min = min + 2;
        if(dig[9]) min = min + 1;
        if(min > 59) return false;
        t.isValid = true;
        if(min < 10) t.time = hr + ":0" + min;
        else t.time = hr + ":" + min;
        return true;
    }
}
