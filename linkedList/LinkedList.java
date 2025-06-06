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

  public LinkedList(int val) {
    Node newNode = new Node(val);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void append(int val) {
    Node appendNode = new Node(val);

    if (length == 0) {
      head = appendNode;
    } else {
      tail.next = appendNode;
    }
    tail = appendNode;
    length++;
  }

  public void prepend(int val) {
    Node prependNode = new Node(val);

    if (length == 0) {
      tail = prependNode;
    } else {
      prependNode.next = head;
    }
    head = prependNode;
    length++;
  }

  public boolean insert(int index, int value) {
    Node temp = get(index - 1);
    Node insertNode = new Node(value);

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

    if (insertNode.next == null) tail = insertNode;

    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index > length) return null;
    if (index == 0) return popFirst();
    if (index == length - 1) return popLast();

    Node temp = get(index);
    Node prev = get(index - 1);
    prev.next = temp.next;
    temp.next = null;

    length--;
    return temp;
  }

  public Node popLast() {
    Node prev = get(length - 2);
    Node temp = tail;

    if (length == 0) return null;

    tail = prev;
    tail.next = null;
    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public Node popFirst() {
    Node temp = head;

    if (length == 0) return null;

    head = head.next;
    temp.next = null;

    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;

    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public Node get(int index) {
    Node temp = head;
    int idx = 0;

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
    System.out.println("Head: " + head.value + " Tail: " + tail.value + " Length: " + length);
  }
}
