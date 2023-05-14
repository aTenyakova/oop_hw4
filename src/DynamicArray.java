import java.util.*;

public class DynamicArray<T> {
    private static final int startLength = 1;
    private int length;
    private T[] data;

    public DynamicArray() {
        this.length = 0;
        this.data = (T[]) new Object[startLength];
    }

    public DynamicArray(T[] data) {
        this.length = data.length;
        this.data = data;
    }

    public int getLength() {
        return this.length;
    }

    public T[] getData() {
        return this.data;
    }

    // Печать массива
    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.getLength(); i++) {
            if (i != this.getLength() - 1)
                System.out.print(this.data[i] + ",");
            else
                System.out.print(this.data[i]);
        }
        System.out.print("]\n");
    }

    // Вставка в массив
    public void add(T element) {
        if (this.length == this.data.length) {
            addLength();
        }
        this.data[this.length++] = element;
    }

    private void addLength() {
        int newlength = this.getLength() + 1;
        T[] newData = (T[]) new Object[newlength];
        for (int i = 0; i < this.getLength(); i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public void removeIndex(int idx) {
        if (idx < 0 || idx >= this.getLength()) {
            throw new IndexOutOfBoundsException(String.format("Элемент в массиве отсутствует"));
        }
        int newLength = this.getLength() - 1;
        T[] newData = Arrays.copyOf(this.data, newLength);
        System.arraycopy(this.data, idx + 1, newData, idx, newLength - idx);
        this.data = newData;
        this.length--;
    }

    public void removeData(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                removeIndex(i);
                i--;
            }
        }
    }

    public int getMin() {
        int min = (int) this.data[0];
        for (int i = 0; i < data.length; i++) {
            if (min > (int) this.data[i]) {
                min = (int) this.data[i];
            }
        }
        return min;
    }

    public int getMax() {
        int max = (int) this.data[0];
        for (int i = 0; i < data.length; i++) {
            if (max < (int) this.data[i]) {
                max = (int) this.data[i];
            }
        }
        return max;
    }

    public int getSum(){
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += (int) this.data[i];
        }
        return result;
    }

    public int getProduct(){
        int result = 1;
        for (int i = 0; i < data.length; i++) {
            result *= (int) this.data[i];
        }
        return result;
    }

    public int findIndex(T element) {
        int count = 0;
        for (T item : data) {
            if (item.equals(element)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public boolean contains(T element) {
        for (T item : data) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void bubbleSorting() throws ExceptionIncomparableType {
        if (!(data[0] instanceof Comparable)) {
            throw new ExceptionIncomparableType(data[0].getClass().getSimpleName()); }

        for (int i = 0; i < data.length - 1; i++) {
            boolean hasSwap = false;

            for (int j = 0; j < data.length - i - 1; j++) {
                Comparable<T> current = (Comparable<T>) data[j];
                T next = data[j + 1];

                if (current.compareTo(next) > 0) {
                    swap(j, j + 1);
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                break;
            }
        }
    }

    public void sortingInserts() throws ExceptionIncomparableType {
        if (!(data[0] instanceof Comparable<?>)) {
            throw new ExceptionIncomparableType(data[0].getClass().getSimpleName());
        }
        for (int i = 1; i < getLength(); i++) {
            T key = data[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) data[j]).compareTo(key) > 0) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    public void sortingSelection() throws ExceptionIncomparableType {
        if (!(this.data[0] instanceof Comparable)) {
            throw new ExceptionIncomparableType(this.data[0].getClass().getSimpleName());
        }
        for (int i = 0; i < this.getLength(); i++) {
            int min_idx = i;

            for (int j = i+1; j < this.getLength(); j++) {
                Comparable<T> elem1 = (Comparable<T>)this.data[j];
                Comparable<T> elem2 = (Comparable<T>)this.data[min_idx];

                if (elem1.compareTo((T) elem2) < 0) {
                    min_idx = j;
                }
            }
            if (i != min_idx) {
                swap(i, min_idx);
            }
        }
    }

    private void swap(int i, int j) {
        T tmp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = tmp;
    }

}
