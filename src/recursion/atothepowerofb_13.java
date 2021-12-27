package recursion;

public class atothepowerofb_13 {

    public long power(int a, int b) {
        //if b % 2 == 0 then a ^b = a ^ (b / 2) * a ^(b / 2)
        //if b % 2 == 1 then a ^b = a ^ (b / 2) * a ^(b / 2) * a
        //corner case: b = 0 => return 1
        //             a = 0 => return 0
        //base case of rec: b == 1 => return a
        //time: O(logb) space O(logb)
        if (b == 0) {
            return 1;
        } else if (a == 0) {
            return 0;
        } else if (b == 1) {
            return a;
        }
        long half = power(a, b / 2);
        return (b % 2 == 0) ? half * half : half * half * a;
    }

}
