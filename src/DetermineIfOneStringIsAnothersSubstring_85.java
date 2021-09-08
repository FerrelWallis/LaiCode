import java.util.Arrays;

public class DetermineIfOneStringIsAnothersSubstring_85 {
    //Determine if a small string is a substring of another large string.
    //
    //Return the index of the first occurrence of the small string in the large string.
    //
    //Return -1 if the small string is not a substring of the large string.
    //
    //Assumptions
    //
    //Both large and small are not null
    //If small is empty string, return 0
    //Examples
    //
    //“ab” is a substring of “bcabc”, return 2
    //“bcd” is not a substring of “bcabc”, return -1
    //"" is substring of "abc", return 0

    //Rabin-Karp
    public int strstr(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        int largePrime = 101;
        int prime = 26;
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, prime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
        }
        int hash = large.charAt(0) % largePrime;
        for (int i = 1; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), prime, largePrime);
        }
        if (hash == targetHash && checkEquals(large, small, 0)) {
            return 0;
        }
        for (int i = 1; i <= large.length() - small.length(); i++) {
            //small长度为k 当当k非常大的时候，seed=prime^k-1会integer overflow
            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largePrime);
            if (hash == targetHash && checkEquals(large, small, i)) {
                return i;
            }
        }
        return  -1;
    }

    private int nonNegative(int minus, int largePrime) {
        if (minus < 0) {
            minus += largePrime;
        }
        return minus;
    }

    private boolean checkEquals(String large, String small, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(start + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }
}
