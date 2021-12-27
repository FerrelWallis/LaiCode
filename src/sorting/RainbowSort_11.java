package sorting;

public class RainbowSort_11 {

    public int[] rainbowSort(int[] array) {
        //-1-1-10001111
        //i, j , k
        //1. [0, i): alll red ball => -1
        //2. [i, j): all green ball => 0
        //3. [j, k]: all ele waiting to be judge
        //4. (k, len - 1]: all blue ball => 1

        //1. array[j] == -1 => swap(array, i++, j++)
        //2. array[j] == 0 => j++
        //3. array[j] == 1 => swap(array, j, k--)

        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i++, j++);
            } else if (array[j] == 0) {
                j++;
            } else {
                swap(array, j, k--);
            }
        }
        return array;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
