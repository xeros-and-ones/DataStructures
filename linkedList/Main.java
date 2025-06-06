package linkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(2);

        list.append(10);
        list.append(7);
        list.prepend(6);
        list.insert(60, 2);
        list.insert(1, 5);
        list.remove(3);
        list.printList();
        System.out.println(list.get(0).value);

    }
}
