public class SmallestElementLargerthanTarget_636 {

    public static void main(String[] args) {
        SmallestElementLargerthanTarget_636 test = new SmallestElementLargerthanTarget_636();
        test.smallestElementLargerThanTarget(new int[]{4,9,12,13,15,20,21,23,25,28,31,33,34,38,40,42,45,46,48,53,54,56,57,58}, 6);
    }

    public int smallestElementLargerThanTarget(int[] array, int target) {
        // sanity check
        if(array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while(left < right) {
            System.out.println(left + " " + right);
            int mid = left + (right - left) / 2;
            if(array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        System.out.println(array[left] < target);
        if(array[left] > target) {
            return left;
        } else {
            return -1;
        }
    }
}
