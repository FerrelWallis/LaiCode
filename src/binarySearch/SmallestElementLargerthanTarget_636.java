package binarySearch;

public class SmallestElementLargerthanTarget_636 {

    public int smallestElementLargerThanTarget(int[] array, int target) {
        //binary search
        //left right
        //mid
        //1. mid <= target => left = mid + 1;
        //2. mid > target => right = mid;
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        //target : 5
        //2 3
        //  lr
        //2 5
        //  lr
        //5 5
        //  lr
        //5 7
        //  lr
        //7 8
        //lr
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] > target ? left : -1;
    }
}
