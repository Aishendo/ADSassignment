public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    @Override
    public int compareTo(T o) {
        return 0;
    }

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }
        MyNode<T> temp1 = temp;
        temp.prev.next = newNode;
        newNode.next=temp1;
        length++;
    }

    private void delete(MyNode<T> node){
        MyNode<T> nextNode = node.next;
        MyNode<T> prevNode = node.prev;
        if(prevNode == null)
            head = nextNode;
        else if(nextNode == null)
            tail = node.prev;
        else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        length--;
    }
    @Override
    public boolean remove(T item) {
        MyNode<T> node = head;
        for (int i = 0; i < length; i++) {
            node = node.next;
            if (node.data == item) {
                delete(node);
                return true;
            }
        }
            return false;
        }

    @Override
    public T remove(int index) {
            MyNode<T> temp = head;
            for(int i=1; i<index; i++){
                temp = temp.next;
            }
            T res = temp.data;
            delete(temp);
            return res;
        }

    @Override
    public void clear() {
        head = null;
        tail = null;
        length=0;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {

        for (int i=0; i<length; i++) {
            if (get(i) == o) {
                return i;
            }
        }
            return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length-1; i >= 0; i--) {
            if (get(i) == o) return i;
        }
        return -1;
    }

    @Override
    public void sort() {
        for(int i=0; i< length; i++){
            for(int j=i+1; j< length; j++){
                if(this.get(i).compareTo(this.get(j))>0){
                    replace(i, j);
                }
            }
        }
    }
    public void replace(int i1, int i2){
        MyNode<T> temp1 = head;
        MyNode<T> temp2 = head;

        while (i1 != 0) {
            temp1 = temp1.next;
            i1--;
        }
        while (i2 != 0) {
            temp2 = temp2.next;
            i2--;
        }
        T temp=temp2.data;
        temp2.data=temp1.data;
        temp1.data=temp;
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i=0; i<length; i++)
        {
            if (get(i)==o) return  true;
        }
        return false;
    }

}
