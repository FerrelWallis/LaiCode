public class NumberOfDifferentBits_75 {
    //Determine the number of bits that are different for two given integers.
    //
    //Examples
    //
    //5(“0101”) and 8(“1000”) has 3 different bits

    public static void main(String[] args) {
        NumberOfDifferentBits_75 test = new NumberOfDifferentBits_75();
        test.diffBits(-1, 2147483647);
    }

    //异或思想，找bit不同的数量，异或相同为0，不同为1，最后计算1的数量即可
    public int diffBits(int a, int b) {
        int count = 0;
        //这里iteration rule不能取 c > 0,因为如果有负数，最高位为1，即使小于0的
        int c = a ^ b;
        while (c != 0) {
            count += (c & 1);
            c >>= 1; //这里-2^31 >>移位依然是负数，但>>>移位最高位的1就可以顺利移走
            //<< vs. >> 算术移动
            //<< :  算术左移，相当于 乘以2。
            //>> : 算术右移， 相当于 除以2.
            //1 & 2 对正数负数都使用。
            // <<< vs. >>>  逻辑移动
            //对正数来说， >>> 和 >> 没有差别
            //对负数来说， >> 高位补1， >>> 高位补0， 所得值会非常奇怪，
    }
        return count;
    }
}
