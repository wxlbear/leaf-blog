package xyz.bbear.common.learn.algorithms;

/**
 * LinkNode.
 *
 * @author xiongliu wu 2019-05-03 15:45
 */
public class LinkNode<T> {
  private Node cursorHead;
  private Node head;
  private Node tail;
  private int size;

  private class Node {
    T t;
    Node next;
    Node previous;

    public Node() {}

    public Node(T t) {
      this.t = t;
    }

    public Node(T t, Node next, Node previous) {
      this.t = t;
      this.next = next;
      this.previous = previous;
    }
  }

  public LinkNode() {
    cursorHead = new Node();
  }

  public void addFromHead(T t) {
    Node old = head;
    head = new Node(t);
    head.next = old;
    if (old != null) {
      old.previous = head;
    }
    cursorHead.next = head;
    head.previous = cursorHead;
    size++;
  }

  public T remove(int index) {
    rangeCheck(index);
    int count = 0;

    Node p = cursorHead;
    while (count <= index) {
      p = p.next;
      count++;
    }

    T t = p.t;
    p.previous.next = p.next;
    p = null;
    size--;
    return t;
  }

  public T get(int index) {
    rangeCheck(index);
    int count = 0;

    Node p = cursorHead;
    while (p != null && count <= index) {
      p = p.next;
      count++;
    }
    if (p != null) {
      return p.t;
    } else {
      return null;
    }
  }

  private void rangeCheck(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
  }

  public void traverseFromHead() {
    Node node = cursorHead.next;
    while (node != null) {
      System.out.print(node.t + " -> ");
      node = node.next;
    }
    System.out.print("null");
  }

  public static void main(String[] args) {
    LinkNode<Integer> linkNode = new LinkNode<>();
    for (int i = 0; i < 10; i++) {
      linkNode.addFromHead(i);
    }
    linkNode.remove(0);
    linkNode.traverseFromHead();
    System.out.println(linkNode.get(3));
  }
}
