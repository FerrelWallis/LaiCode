public class ReOrderArray_197 {

    /** Given an array of elements, reorder it as follow:
     { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
     { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
     Try to do it in place.

     Assumptions
     The given array is not null

     Examples
     { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
     { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
     { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
     **/
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int[] array2 = new int[]{1,2,3,4,5,6,7};
        ReOrderArray_197 test = new ReOrderArray_197();
//        test.reorder(array);
        test.reorder(array2);
    }

    public int[] reorder(int[] arrays) {
        if (arrays.length == 0) {
            return new int[0];
        }
        //整体为奇数和偶数的情况要分开讨论
        if (arrays.length % 2 == 0) {
            helper(arrays, 0, arrays.length - 1);
        } else {
            helper(arrays, 0, arrays.length - 2);
        }
        return arrays;
    }

    //suppose last ele will be at last position
    //若不分类讨论整体切割奇个，在最后一层的时候会陷入死循环 3 6 7
    // 1 | 2 3 | 4 | 5 6 7?  -> 1 4 2 5 3 6 7
    // L   lm   mid  rm  R
    //size = 7, mid = 3 , size / 2 = 3 , size / 4 = 1
    //不做任何措施，奇数个直接切割chunk，chunk 2 与 4不对等
    //假设不错任何措施 1 4 | 2 3 5 6 7  drill down -> 2 3 4 6 7 size = 5 , mid & size / 2 = 2, size / 4 = 1
    // 2 | 3 | 5 | 6 7 -> 2 5 | 3 6 7 dill down -> 3 6 7 size = 3 , mid & size / 2 = 1 , size / 4 = 0 这里会出错
    // 3   |   6   |   7 -> 3 6 7 drill down的时候 left +（leftmid - left） * 2  = left 陷入死循环了，又是 3 6 7
    //L&LM   M&RM      R

    //正确做法是 （1 2 3 4 5 6） 7 对1-6做偶数的切割，7放在最后不动

    //1 2 3 4 5 6 7 8 9 10 11 -> 1 6 2 7 3 8 4 9 5 10 11


    //整体为偶数，切出chunk奇+偶
    //奇数情况
    //A B C | D E F G | 1 2 3 | 4 5 6 7
    //L     lm       mid    rm    R
    //size = 14, mid = 7, size / 2 = 7, size / 4 = 3

    //整体为偶数，切出chunk一致
    //A B C | D E F | 1 2 3 | 4 5 6
    //L     lm     mid     rm  R
    //size = 12, mid = 6, size / 2 = 6, size / 4 = 3
    //因此奇偶情况都成立

    private void helper(int[] arrays, int left, int right) {
        //base case
        if (right - left <= 1) {
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftmid = left + size / 4;
        int rightmid = mid + size / 4;
        reverse(arrays, leftmid, mid - 1);
        reverse(arrays, mid, rightmid - 1);
        reverse(arrays, leftmid, rightmid - 1);
        helper(arrays, left, left + (leftmid - left) * 2 - 1); // chunk1 + chunk3的index
        helper(arrays, left + (leftmid - left) * 2, right); // chunk2 + chunk4的index
    }

    private void reverse(int[] arrays, int left, int right) {
        while (left < right) {
            int temp = arrays[left];
            arrays[left++] = arrays[right];
            arrays[right--] = temp;
        }
    }
}
