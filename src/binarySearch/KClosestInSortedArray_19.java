package binarySearch;

public class KClosestInSortedArray_19 {
    public static void main(String[] args) {
        KClosestInSortedArray_19 test = new KClosestInSortedArray_19();
        test.kClosest(new int[]{1,3,5}, 10, 3);

    }

    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        int cloest = findCloest(array, target);
        int left = cloest - 1;
        int right = cloest;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                ans[i] = array[right++];
            } else if (right >= array.length) {
                ans[i] = array[left--];
            } else if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                ans[i] = array[left--];
            } else {
                ans[i] = array[right++];
            }
        }
        return ans;
    }

    public int findCloest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
