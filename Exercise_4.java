//TC - O(nlogn)
//SC - o(n)
class MergeSort
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
       //Your code here
        int i = 0, j = 0;
        int left[] = new int[m-l+1];
        int right[] = new int[r-m];
        for(i = 0; i < left.length; ++i) {
            left[i] = arr[l + i];
        }
        for(i = 0; i < right.length; ++i) {
            right[i] = arr[m + 1 + i];
        }
        i = 0;
        int k = l, length1 = left.length, length2 = right.length;
        while(k < arr.length && i < length1 && j < length2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while( k < arr.length && i < length1){
            arr[k++] = left[i++];
        }
        while(k < arr.length && j < length2){
            arr[k++] = right[j++];
        }
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        //Call mergeSort from here
        if(arr.length < 2) return;
        if(l < r) {
            int mid = l + (r - l) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7};
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 