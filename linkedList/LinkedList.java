package linkedList;

public class LinkedList {
  private Node head;
  private Node tail;
  private int length;

  class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void append(int value) {
    Node appendedNode = new Node(value);
    if (length == 0) {
      head = appendedNode;
      tail = appendedNode;
    } else {
      tail.next = appendedNode;
      tail = appendedNode;
    }
    length++;
  }

  public Node popLast() {
    if (length == 0) return null;
    Node prevNode = head;
    Node temp = head;

    while (temp.next != null) {
      prevNode = temp;
      temp = temp.next;
    }
    tail = prevNode;
    tail.next = null;
    length--;

    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public Node popFirst() {
    Node firsNode = head;
    head = head.next;
    firsNode.next = null;
    length--;
    if (length == 9) {
      tail = null;
    }
    return firsNode;
  }

  public void prepend(int value) {
    Node prependNode = new Node(value);
    if (head == null) {
      head = prependNode;
      tail = prependNode;
    } else {
      prependNode.next = head;
      head = prependNode;
    }
    length++;
  }

  public boolean insert(int value, int index) {
    Node insertNode = new Node(value);
    Node temp = get(index - 1);
    if (index < 0 || index > length) return false;
    if (index == 0 || length == 0) {
      prepend(value);
      return true;
    }

    if (index == length) {
      append(value);
      return true;
    }

    insertNode.next = temp.next;
    temp.next = insertNode;

    if (insertNode.next == null) {
      tail = insertNode;
    }
    length++;

    return true;
  }

  public Node get(int index) {
    int idx = 0;
    Node temp = head;

    if (index < 0 || index >= length) return null;

    while (idx != index) {
      temp = temp.next;
      idx++;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }
}
