public class ReverseBitsof32bitInteger_626 {
    //Reverse bits of a 32-bit integer.
    //Note: In different programming languages, integers might be implemented differently in terms of
    //number of bits, signed, unsigned, etc. However it should not affect your implementation on this problem.
    //In java, the type of input is long, but you just need to work on the last 32-bit and consider it as
    //an unsigned 32-bit integer.

    //Example 1:
    //Input: 1234 (0b'00000000000000000000010011010010)
    //Output: 1260388352 (0b'01001011001000000000000000000000)

    //  1000001
    public long reverseBits(long num) {
        int right = 31;
        int left = 0;
        while (left < right) {
            num = swap(num, left++, right--);
        }
        return num;
    }

    public long swap(long num, int left, int right) {
        long l = (num >> left) & 1L;
        long r = (num >> right) & 1L;
        if (l == r) {
            return num;
        }
        //说明l 与 r 相反，互换即各自取反，bit与1作异或，表示取反 0 ^ 1 = 1  1 ^ 1 = 0
        return num ^ ((1L << left) + (1L << right));
        //这里变成 long主要是要超过 integer bit limit, 这样移位了的 1 就可以被保留下来, 否则的话超过就变成了0
    }

    //方法二：merge sort方法
    public long reverseBits2(long n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }


}
