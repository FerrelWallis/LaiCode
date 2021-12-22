package binarySearch;

public class SearchInUnknownSizedSortedArray_20 {
    interface Dictionary {
        public Integer get(int index);
    }
    public int search(Dictionary dict, int target) {
        //1. find range which target within
        //left = 0, right = 1
        //right *= 2 => 2
        //            => 100
        //left = right + 1 = 2
        //right = 10
        //left = 10 + 1 = 11
        //right = 100

        //assume that index of target is T
        //O(log2(2 * T))
        //  r    T    r
        // 100  101   100*2 = 2 * T


        //2. binary search
        //1) mid == null => right = mid - 1;
        //2) mid == target => return mid
        //3) mid > target => right = mid - 1;
        //4) mid < target => left = mid + 1;
        //O(log2(2T))

        //O(2*log2(2T)) = O(logT)
        if (dict == null || dict.get(0) == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        while (dict.get(right) != null && dict.get(right) < target) {
            //O(log10(n))  log base 10 of n (here n represent how far it reach)
            left = right + 1;
            right *= 2;
        }
        while (left <= right) { //O(log2(10n))
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) == target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
