public class KClosestInSortedArray_19 {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5};
        KClosestInSortedArray_19 test = new KClosestInSortedArray_19();
        test.kClosest(a,10,3);

    }

    public int[] kClosest(int[] array, int target, int k) {
        // sanity check
        if(array == null || array.length == 0) {
            return new int[]{};
        }
        //找最小大于等于target的数
        int left = 0, right = array.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(left);
        System.out.println(right);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            //这里要注意越界问题left >=0  right < array.length
            int ldiff = (left >= 0)? Math.abs(array[left] - target) : Integer.MAX_VALUE;
            int rdiff = (right < array.length)? Math.abs(array[right] - target) : Integer.MAX_VALUE;
            if(ldiff <= rdiff) {
                ans[i] = array[left--];
            } else {
                ans[i] = array[right++];
            }
        }
        return ans;
    }
}
