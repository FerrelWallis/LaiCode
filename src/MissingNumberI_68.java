import java.util.HashMap;
import java.util.HashSet;

public class MissingNumberI_68 {
    //Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
    //
    //Assumptions
    //
    //The given array is not null, and N >= 1
    //Examples
    //
    //A = {2, 1, 4}, the missing number is 3
    //A = {1, 2, 3}, the missing number is 4
    //A = {}, the missing number is 1

    //worst solution hashmap/int[] 记录 time O(n) space O(n)
    public int missing(int[] array) {
        int N = array.length + 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return N;
    }

    //sum time O(n) space O(1)
    public int missing2(int[] array) {
        int N = array.length + 1;
        long sum = (1 + N) * N / 2;
        //1+2+3+...+n 公式 (1+n)*n/2
        for(int i : array) {
            sum -= i;
        }
        return (int)sum;
    }

    //xor 异或 O(n) space O(1)
    public int missing3(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i; //^=异或符号
        }
        for (int a : array) {
            xor ^= a;
        }
        return xor;
    }
}
