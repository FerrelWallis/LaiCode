package binarySearch;

public class FirstOccurrence_15 {
    public static void main(String[] args) {
        FirstOccurrence_15 test = new FirstOccurrence_15();
        test.firstOccur(new int[]{3,4,5,6,6,9,16}, 6);
    }

    public int firstOccur(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else{
            return -1;
        }
    }

}
