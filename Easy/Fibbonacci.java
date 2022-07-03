class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        return rec(0, 1, n);
    }
    int rec(int f, int s, int n) {
        n--;
        int sum = f + s;
        if(n == 1) return sum;
        return rec(s, sum, n);
    }
}
