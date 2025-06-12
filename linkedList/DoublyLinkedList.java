package linkedList;

public class DoublyLinkedList {
  private int length;
  private Node head;
  private Node tail;

  class Node {
    int value;
    Node prev;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public int size() {
    return this.length;
  }

  public void append(int value) {
    Node appendNode = new Node(value);

    if (length == 0) {
      head = appendNode;
      tail = appendNode;
    } else {
      tail.next = appendNode;
      appendNode.prev = tail;
      tail = appendNode;
    }
    length++;
  }

  public void append(Integer... values) {

    if (values == null) {
      throw new IllegalArgumentException("values can't be null");
    }
    if (values.length == 0) {
      throw new IllegalArgumentException("at least one value must be provided");
    }
    for (int value : values) {
      append(value);
    }
  }

  public void prepend(int value) {
    Node prependNode = new Node(value);

    if (length == 0) {
      head = prependNode;
      tail = prependNode;
    } else {
      head.prev = prependNode;
      prependNode.next = head;
      head = prependNode;
    }
    length++;
  }

  public boolean insert(int value, int index) {
    if (index < 0 || index > length) return false;

    if (index == 0) {
      prepend(value);
      return true;
    }
    if (index == length) {
      append(value);
      return true;
    }
    Node insertNode = new Node(value);
    Node temp = get(index);

    insertNode.prev = temp.prev;
    insertNode.next = temp;
    temp.prev.next = insertNode;
    temp.prev = insertNode;

    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) return null;
    if (index == 0) return popFirst();
    if (index == length - 1) return popLast();

    Node removeNode = get(index);
    if (removeNode == null) return null;

    removeNode.prev.next = removeNode.next;
    removeNode.next.prev = removeNode.prev;
    removeNode.prev = null;
    removeNode.next = null;

    length--;
    return removeNode;
  }

  public Node popFirst() {
    Node temp = head;

    if (length == 0) return null;

    head = head.next;
    temp.next.prev = null;
    temp.next = null;

    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public Node popLast() {
    Node temp = tail;

    if (length == 0) return null;

    tail = tail.prev;
    temp.prev.next = null;
    temp.prev = null;

    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) return null;
    if (length == 0) return null;

    Node temp;

    if (index <= (length / 2)) {
      temp = head;

      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    } else {
      temp = tail;

      for (int i = length - 1; i > index; i--) {
        temp = temp.prev;
      }
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp == null) return false;
    temp.value = value;
    return true;
  }

  public void printList() {
    if (length == 0) { // Add this check
      System.out.println("Empty list");
      return;
    }
    Node temp = head;

    while (temp != null) {
      String prevNode = (temp.prev != null) ? String.valueOf(temp.prev.value) : "null";
      String nextNode = (temp.next != null) ? String.valueOf(temp.next.value) : "null";
      System.out.println(prevNode + " <- " + temp.value + " -> " + nextNode);
      temp = temp.next;
    }
    System.out.println(
        "Head: "
            + (head != null ? head.value : "null")
            + " Tail: "
            + (tail != null ? tail.value : "null")
            + " Length: "
            + length);
  }
}
