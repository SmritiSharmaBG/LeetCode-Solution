class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();
        char[] roman = {'I', 'V','X','L','C','D','M'};
        int[] val = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < n; i ++) {
            char ch = s.charAt(i);
            char ch2 = '*';
            if (i + 1 < n) ch2 = s.charAt(i + 1);
            
            boolean p = false;
            
            for (int j = 0; j <= 4; j += 2) {
                
                if (ch == roman[j]) {
                    if (ch2 == roman[j + 1]) {
                        p = true;
                        int sm = val[j + 1] - val[j];
                        sum += sm;
                        i ++;
                        break;
                    } else if (ch2 == roman[j + 2]) {
                        p = true;
                        int sm = val[j + 2] - val[j];
                        sum += sm;
                        i ++;
                        break;
                    }
                }
            }
            
            if(!p) {
                for(int j = 0; j <= 6; j ++) {
                    if(ch == roman[j]) {
                        sum += val[j];
                        break;
                    }
                }                
            }
        }
        return sum;
    }
}
