import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSortedArray {
    public static void main(String[] args){
        new MergeSortedArray();
    }

    public MergeSortedArray(){
        int arr[] = new int[]{1,2,3,0,0,0};
        new Solution().merge(arr,3,new int[]{2,5,6},3);
        System.out.println(Arrays.toString(arr));
    }

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = 0, j = 0;
            List<Integer> result = new LinkedList<>();
            while (i < m || j < n){
                boolean addNums1 = false;

                if (j == n){
                    addNums1 = true;
                } else if (i == m){
                    addNums1 = false;
                } else if (nums1[i] < nums2[j]){
                    addNums1 = true;
                }
                if (addNums1){
                    result.add(nums1[i]); i++;
                } else {
                    result.add(nums2[j]); j++;
                }
            }
            for(i = 0; i < m + n; i++){
                nums1[i] = result.get(i);
            }
        }
    }
}
