package binarySearch;

public class ClosestInSortedArray_17 {

    public int closest(int[] array, int target) {
        //mid > target => closest ele [left, mid]
        //mid < target => ele [mid, right]
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        long leftdiff = ((long) array[left] - target);
        long rightdiff = ((long) array[right] - target);
        return (Math.abs(array[left] - target) < Math.abs(array[right] - target)) ? left : right;
    }
}
