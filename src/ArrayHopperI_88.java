public class ArrayHopperI_88 {
    //Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine if you are able to reach the last index.
    //
    //Assumptions
    //
    //The given array is not null and has length of at least 1.
    //Examples
    //
    //{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
    //
    //{2, 1, 1, 0, 2}, we are not able to reach the end of array

    public boolean canJump(int[] array) {
        boolean[] valid = new boolean[array.length];
        valid[array.length - 1] = true;
        for (int i = valid.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                valid[i] = true;
            } else {
                for (int j = array[i]; j > 0; j--) {
                   if (valid[i + j]) {
                       valid[i] = true;
                       break;
                   }
                }
            }
        }
        return valid[0];
    }

    //贪心算法 记录当前可以跳的最远距离和下一个最远距离，当i > 当前最远距离，就将下一个最远距离提上来使用
    public boolean canJump2(int[] array) {
        int cur = 0;
        int nxt = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > cur) {
                if (nxt == cur) {
                    return false;
                }
                cur = nxt;
            }
            nxt = Math.max(nxt, i + array[i]);
        }
        return true;
    }


}
