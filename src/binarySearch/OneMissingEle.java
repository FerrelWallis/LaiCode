package binarySearch;

public class OneMissingEle {
    //Question 7b: One missing number in sorted array of [0~n-1].
    //find this missing number
    //0 1 2 3 5 6 7 8
    //0 1 2 3 4 5 6 7
    //find first ele that value of it is equal to index of it + 1
    //array[i] = i + 1

    //binary search
    //left = 0, right = array.length - 1
    //1. mid = index of it => left = mid + 1
    //2. mid = index of it + 1 => right = mid
    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,5,7};
        OneMissingEle test = new OneMissingEle();
        System.out.println(test.missing(array));
    }

    public int missing(int[] array) {
        int left = 0;
        int right = array.length - 1;
        //0 1 2 3 4 5 6 7
        //0 1 2 3 5 6 7 8
        //        lr
        //        lr
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
