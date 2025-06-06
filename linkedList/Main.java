package linkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(2);

        list.append(5,7,10,20,9);
        list.printList();
        System.out.println(list.get(0).value);

    }
}
