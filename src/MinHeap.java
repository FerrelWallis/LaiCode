import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinHeap <E> {
    private int[] array;
    private int size;
    private Comparator<E> comparator;
    public MinHeap(int[] array, Comparator<E> comparator) {
        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException("input array can not be null");
        }
        this.array = array;
        size = array.length;
        heapify();
        this.comparator = comparator;
    }

    private void heapify() { //[0, size/2 - 1]
        for(int i = size / 2 - 1; i <= 0; i--) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {
        if (cap <= 1) {
            throw new IllegalArgumentException("input array can not be <= 1");
        }
        array = new int[cap];
        size = 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if(array[parentIndex] > array[index]) {
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int candidate = leftChild; //left一定存在但right不一定存在
            if (rightChild <= size - 1 && array[rightChild] < array[leftChild]) {
                candidate = rightChild;
            }
            if (array[index] > array[candidate]) {
                swap(index, candidate);
            } else {
                break;
            }
            index = candidate;
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if(isFull()) { // 自动扩容1.5倍
            array = Arrays.copyOf(array, (int) 1.5 * array.length); //扩容是length不是size
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    public int update(int index, int ele) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("index doesn't exist");
        }
        int result = array[index];
        array[index] = ele;
        int parentIndex = (index - 1) / 2;
        if (array[index] < result) {
            percolateUp(index);
        } else  {
            percolateDown(index);
        }
        return result;
    }



}
