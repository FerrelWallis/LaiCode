package binarySearch;

public class TwoMissingEle {
    //Two missing numbers in sorted array of [0~n-1], find missing numbers
    //index 0 1 2 3 4 5 6 7 8   9
    //value 0 2 3 4 5 7 8 9 10 11
    //array[i]
    //first ele: array[i] = i + 1 => get i
    //second ele: array[i] = i + 2 => get i + 1
    //binary search twice
    //1. int left1 right1
    //   mid 1) array[mid1] == mid1 => left = mid + 1
    //       2) array[mid1] == mid1 + 1 => right = mid
    //       3) array[mid1] == mid1 + 2 => right = mid - 1
    //index 0 1 2 3 4 5 6 7 8   9
    //value 0 2 3 4 5 7 8 9 10 11
    //       l1r2    l2r2
    //2. left2 right2
    //   1) array[mid2] == mid2 => left = mid + 1
    //   2) array[mid2] == mid2 + 1 => left = mid + 1
    //   3) array[mid2] == mid2 + 2 => right = mid

    //l1=r1 && l2=r2
    public static void main(String[] args) {
        int[] array = new int[]{0,2,3,4,5,7,8,9,10,11};
        TwoMissingEle test = new TwoMissingEle();
        int[] ans = test.missing(array);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] missing(int[] array) {
        int left1 = 0;
        int right1 = array.length - 1;
        int left2 = 0;
        int right2 = array.length - 1;
        int[] ans = new int[2];
        while (left1 < right1 || left2 < right2) {
            int mid1 = left1 + (right1 - left1) / 2;
            int mid2 = left2 + (right2 - left2) / 2;
            if (array[mid1] == mid1) {
                left1 = mid1 + 1;
            } else if (array[mid1] == mid1 + 1) {
                right1 = mid1;
                ans[0] = mid1;
            } else {
                right1 = mid1 - 1;
            }
            if (array[mid2] == mid2 || array[mid2] == mid2 + 1) {
                left2 = mid2 + 1;
            } else {
                right2 = mid2;
                ans[1] = mid2 + 1;
            }
        }
        return ans;
    }

}
