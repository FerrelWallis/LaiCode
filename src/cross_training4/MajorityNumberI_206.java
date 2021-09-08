package cross_training4;

public class MajorityNumberI_206 {
    //Given an integer array of length L, find the number that occurs more than 0.5 * L times.
    //Assumptions: The given array is not null or empty
    //It is guaranteed there exists such a majority number
    //Examples: A = {1, 2, 1, 2, 1}, return 1
    public int majority(int[] a) {
        int counter = 0;
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (counter == 0) {
                ans = a[i];
                counter = 1;
            } else {
                counter = ans == a[i] ? counter + 1 : counter - 1;
            }
        }
        return ans;
    }
}
