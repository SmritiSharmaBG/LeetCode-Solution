class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {       
        // USING EXTRA SPACE
       //extraSpace(nums1, m, nums2, n);
        
        
        // USING NO EXTRA SPACE; INSERTION SORT TECHNIQUE
        insertionSort(nums1, m, nums2, n);
        
        // GAP METHOD - not working
        //gap(nums1, m, nums2, n);
        
        
    }
    
    
    
    void gap(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        int gap = m + n; //(int)Math.ceil((m + n) / 2);
        while(gap >= 1) {
            gap = (int)Math.ceil((gap) / 2);
            int i = 0;
            int j = i + gap;
            while(j < m + n) {
                if(nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
                i ++;
                j ++;
            } // one iteration complete
        }
    }
    
    
  
  
    void insertionSort(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int j = 0;
        int i = 0;
        //for(int i = 0; i < m; i ++) {
        while(i < m) {
            if (nums1[i] > nums2[j]) {
                // first swap
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                
                // then rearrange nums2
                int swappedNum = nums2[j];
                int loop = j;
                while(loop + 1 < n && nums2[loop + 1] < swappedNum) {
                    nums2[loop] = nums2[loop + 1];
                    loop ++;
                }
                nums2[loop] = swappedNum;
            }
            
            else i ++;
        } // for loop;
        
       // int j = 0;
        for(int it = m; it < m + n; it ++) {
            nums1[it] = nums2[it - m];
        }
    }
    
    
  
    void extraSpace(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int pos = 0;
        int pos1 = 0;
        int pos2 = 0;
        while(pos < m + n) {
            if(pos1 >= m) {
                ans[pos] = nums2[pos2];
                pos2 ++;
            }
            else if(pos2 >= n) {
                ans[pos] = nums1[pos1];
                pos1 ++;
            }
            else if(nums1[pos1] < nums2[pos2]) {
                ans[pos] = nums1[pos1];
                pos1 ++;
            }
            else if(nums1[pos1] > nums2[pos2]) {
                ans[pos] = nums2[pos2];
                pos2 ++;
            }
            else {
                ans[pos] = nums1[pos1];
                pos ++;
                ans[pos] = nums2[pos2];
                pos1 ++;
                pos2 ++;
            }
            pos ++;
        }
        for(int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    } // EXTRA SPACE
} // class
