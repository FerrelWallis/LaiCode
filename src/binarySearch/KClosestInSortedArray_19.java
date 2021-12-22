package binarySearch;

public class KClosestInSortedArray_19 {
    public int[] kClosest(int[] array, int target, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (left >= 0 && (right >= array.length || Math.abs(array[left] - target) <= Math.abs(array[right] - target))) {
                ans[i] = array[left];
                left--;
            } else {
                ans[i] = array[right];
                right++;
            }
        }
        return ans;
    }



}
