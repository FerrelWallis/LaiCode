package cross_training4;

public class KthSmallestInTwoSortedArrays_202 {
    //Given two sorted arrays of integers, find the Kth smallest number.
    //Assumptions: The two given arrays are not null and at least one of them is not empty
    //K >= 1, K <= total lengths of the two sorted arrays

    //Examples
    //A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
    //A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.

    //1. 谁小移谁
    //time O（k）
    public int kth(int[] a, int[] b, int k) {
        int pa = 0;
        int pb = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (a[pa] <= b[pb]) {
                ans = a[pa++];
            } else {
                ans = b[pb++];
            }
        }
        return ans;
    }


    //2. binary search
    //在a[]中（0~min(k, a.length)）进行二分查找，a[mid]（已有mid个必定小于mid的数了）
    //case 1: 满足b中正好有k - 1 - mid个小于mid的(即b[k - mid - 2] < a[mid] && b[k - mid - 1] > a[mid])
    //case 2: b[k - mid - 2] > a[mid] 往mid右边找
    //case 3: b[k - mid - 1] < a[mid] 往mid左找
    //case 4: a[]中0~min(k, a.length)之间没有找到想要的值，说明k在b中，对b作同样的事
    public int kth2(int[] a, int[] b, int k) {
        int[] ans = new int[1];
        if (!binarySearch(a, b, k, ans)) {
            binarySearch(b, a, k, ans);
        }
        return ans[0];
    }

    private boolean binarySearch(int[] a, int[] b, int k, int[] ans) {
        int left = 0;
        int right = Math.min(k, a.length);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (b[k - mid - 2] > a[mid]) {
                left = mid + 1;
            } else if (b[k - mid - 1] < a[mid]) {
                right = mid - 1;
            } else {
                ans[0] = a[mid];
                return true;
            }
        }
        return false;
    }

    //3. binary search a b 中看k/2 - 1这个元素谁小，小的那一方前k/ 2 - 1个元素可以直接排除 k = k - (k / 2 - 1)
    //再继续，直到k = 1时，小的那个就是ans
    public int kth3(int[] a, int[] b, int k) {
        return helper(a, b, 0, 0, k);
    }

    private int helper(int[] a, int[] b, int pa, int pb, int k) {
        //base case
        if (pa >= a.length) { //a被删完
            return b[pb + k - 1];
        } else if (pb >= b.length) {
            return a[pa + k - 1];
        } else if (k == 1) {
            return Math.min(a[pa], b[pb]);
        }
        int amid = pa + k / 2 - 1;
        int bmid = pb + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval <= bval) {
            return helper(a, b, amid + 1, pb, k - k / 2);
        } else {
            return helper(a, b, pa, bmid + 1, k - k / 2);
        }
    }


}
