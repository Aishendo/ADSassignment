import static java.lang.System.arraycopy;

public class MyArrayList<T extends Comparable <T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 5;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    public void add(T item) {
        if (length == capacity)
            increaseCapacity();
        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
       if (length == capacity) increaseCapacity();
        for (int i = index; i < length; i++) {
            arr[i+1] = arr[i];
        }arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        for (int i = indexOf(item); i < length; i++) {
            arr[i] = arr[i+1];
        }
        for (int i = 0; i < length; i++) {
            if(arr[i] == item){
                arr[i] = null;
                length--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        T hpas = (T)arr[index];
        arraycopy(arr, index + 1, arr, index - 1, length - 1 - index);
        arr[length - 1] = null;
        length--;
        return hpas;

        /*for (int i = index; i < length; i++) {
            arr[i] = arr[i+1];
        }
        arr[index] = null;
        for (int i = index; i < length -1 ; i++) {
            arr[i]=arr[i+1];
        } length--;
        return null;*/
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[capacity];
        length = 0;
    }

    private void increaseCapacity() {
        capacity = (int)(1.5 * capacity);
        Object[] arr2 = new Object[capacity];

        for (int i = 0; i < length; i++)
            arr2[i] = arr[i];
        arr = arr2;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length ; i++) {
            if (arr[i] == o) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length-1; i >= 0; i--) {
            if (arr[i] == o) return i;
        }
        return -1;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                T one = this.get(i);
                T two = this.get(j);
                if (one.compareTo(two) > 0) {
                    arr[i] = two;
                    arr[j] = one;
                }
            }
        }
    }
    public void sortD() {
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                T one = this.get(i);
                T two = this.get(j);
                if (one.compareTo(two) < 0) {
                    arr[i] = two;
                    arr[j] = one;
                }
            }
        }
    }

    public int size() { return length; }

    @Override
    public boolean contains(Object o) {
        for (int i = length-1; i >= 0 ; i--) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
