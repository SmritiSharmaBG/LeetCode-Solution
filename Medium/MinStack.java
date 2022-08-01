class MinStack {

    Stack<Long> s = new Stack<>();
    long min = Long.MAX_VALUE;
    
    public MinStack() {
        
    }
    
    public void push(int val_i) {
        long val = (long)val_i;
        if(s.isEmpty()) {
            s.push(val);
            min = val;
            return;
        }    
        if(val >= min) { // no need to update min
            s.push(val);
            return;
        }
        long modifiedVal = (2 * val) - min;
        min = val;
        s.push(modifiedVal);
    }
    
    public void pop() {
        long top = s.pop();
        if(top > min) { // it is not min; no need to update min
            return;
        }
        min = (2 * min) - top;
    }
    
    public int top() {
        long top = s.peek();
        if(top > min) { // it is not min
            return (int)top;
        }
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
