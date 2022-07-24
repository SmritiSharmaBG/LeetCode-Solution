class Solution {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        if(arr[start] < arr[end]) return arr[0];
        while(start <= end) {
            mid = (start + end) / 2;
            if(mid - 1 >= 0 && arr[mid] < arr[mid-1]) return arr[mid];
            if(mid + 1 <= arr.length - 1 && arr[mid] > arr[mid + 1]) return arr[mid+1];
           // if(arr[mid] < arr[(mid-1)%arr.length] && arr[mid] < arr[(mid+1)%arr.length]) return arr[mid];
            if(arr[start] <= arr[mid]) { //LHS is sorted; eliminate LHS
                start = mid + 1;
            } else end = mid - 1;
        }
        return arr[mid];
    }
}
