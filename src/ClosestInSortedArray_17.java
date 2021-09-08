public class ClosestInSortedArray_17 {

    public int closest(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
