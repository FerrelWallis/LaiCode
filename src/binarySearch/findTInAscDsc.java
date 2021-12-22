package binarySearch;

public class findTInAscDsc {
    //2 3 6 8 12 15 19 || 17 13 9 7 4 2 1 find target=9
    //1. find peek
    //2. break into two array
    //3. do binary search in [0, peek] and [peek + 1, size - 1]

    //peek
    //left right mid
    //1. mid == target => return mid
    //2. mid > mid - 1 => left = mid
    //3. mid < mid - 1 => right = mid - 1
    //2 3 6 8 12 15 19 || 17 13 9 7 4 2 1
    //              l      r
    //           l  r
    //while loop stop when left >= right - 1

    //[0, left] [right, size - 1]
    public int find(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > array[mid - 1]) {
                left = mid;
            } else  {
                right = mid - 1;
            }
        }
        int l = 0;
        int r = left;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = right;
        r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
