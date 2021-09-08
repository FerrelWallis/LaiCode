public class quickSort_10 {
    public int[] quickSort(int[] array) {
        //corner case
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        //base case;
        if(left >= right) {
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    public int partition(int[] array, int left, int right) {
        int pivotIndex = getRandomPivot(left, right);
        int pivot = array[pivotIndex];
        //swap(array, pivotIndex, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else if (array[i] >= pivot) {
                j--;
            } else { //i的大于pivot且j小于pivot，这是ij互换，并且各自向中间移一位
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        return i;
    }

    public int getRandomPivot(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
