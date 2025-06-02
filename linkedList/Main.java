package linkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList newLinkedList = new LinkedList(4);

    newLinkedList.append(10);
    newLinkedList.append(20);
    newLinkedList.prepend(1);
    newLinkedList.printList();
    System.out.println("----------------");
    newLinkedList.set(2, 99);
    newLinkedList.insert(3, 1);
    newLinkedList.printList();
    System.out.println("----------------");

    newLinkedList.reverse();
    newLinkedList.printList();

    newLinkedList.getHead();
    newLinkedList.getTail();
    newLinkedList.getLength();
  }
}
