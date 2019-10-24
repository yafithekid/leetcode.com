import java.util.Arrays;

public class MedianSortedArray {
    public static void main(String[] args){
        MedianSortedArray medianSortedArray = new MedianSortedArray();


    }
    public MedianSortedArray(){
        int[] a,b;
        a = new int[]{0,1,2};
        b =  new int[]{3,4,5};
        System.out.println(new Solution().findMedianSortedArrays(a,b));

        a =  new int[]{3,4,5};
        b =  new int[]{0,1,2};
        System.out.println(new Solution().findMedianSortedArrays(a,b));

        a =  new int[]{3,4,5,6};
        b =  new int[]{0,1,2};
        System.out.println(new Solution().findMedianSortedArrays(a,b));

        a =  new int[]{3,4,5};
        b =  new int[]{-1,0,1,2};
        System.out.println(new Solution().findMedianSortedArrays(a,b));

        a =  new int[]{3,4,5};
        b =  new int[]{-3,-2,-1,0,1,2};
        System.out.println(new Solution().findMedianSortedArrays(a,b));

        a =  new int[]{3,4,5};
        b =  new int[]{-2,-1,0,1,2};
        System.out.println(new Solution().findMedianSortedArrays(a,b));
    }

    class Solution {
        public double findMedianSortedArrays(int[] a, int[] b) {
            int n = a.length + b.length;

            // A < B
            if (a[a.length - 1] >= b[0]){
                int[] c = a;
                a = b;
                b = c;
            }
            if (a[a.length - 1] <= b[0]){
                if (n % 2 == 1){
                    int mid = n / 2 + 1;
                    if (a.length >= mid){
                        return a[mid - 1];
                    } else {
                        mid -= a.length;
                        return b[mid - 1];
                    }
                } else {
                    int mid = n/2;
                    //both in A
                    int l,r;
                    if (mid - 1 <= a.length - 1){
                        l = a[mid - 1];
                        if (mid <= a.length - 1){
                            r = a[mid];
                        } else {
                            r = b[0];
                        }
                    } else {
                        mid -= a.length;
                        l = b[mid-1]; r = b[mid];
                    }
                    return ((double) l + r)/2.0;
                }
            } else {
                throw new UnsupportedOperationException();
            }

        }
    }
}
