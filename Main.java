public class Main {
    public static void main(String[] args) {
        MyLinkedList <Integer> array = new MyLinkedList<>();
        array.add(65);
        array.add(25);
        array.add(36);
        array.add(8);
        array.add(12);
        array.sort();
        //add.add(69);
        //add.remove((Integer) 8);
        //add.remove(3);
        //add.clear();
        //add.indexOf(8);
        //add.contains(0);
        for (int i = 0; i < array.size(); i++) System.out.println(array.get(i) + " ");
    }
}
