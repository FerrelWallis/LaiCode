package binarySearch;

public class SmallestElementLargerthanTarget_636 {
    public static void main(String[] args) {
        SmallestElementLargerthanTarget_636 test = new SmallestElementLargerthanTarget_636();
        test.smallestElementLargerThanTarget(new int[]{4,9,12,13,15,20,21,23,25,28,31,33,34,38,40,42,45,46,48,53,54,56,57,58}, 6);
    }

    public int smallestElementLargerThanTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[left] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (array[left] > target) {
            return left;
        } else {
            return -1;
        }
    }
}
