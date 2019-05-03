package xyz.bbear.common.learn.algorithms;

import java.util.Iterator;

/**
 * Bag.
 *
 * @author xiongliu wu 2019-05-03 14:42
 */
public class Bag<Item> implements Iterable<Item> {

  private int size = 0;

  private Node first;

  private class Node {
    Item item;
    Node next;

    public Node() {}

    public Node(Item item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  /**
   * add item to bag.
   *
   * @param item item
   */
  public void add(Item item) {
    // 从链表头insert
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    size++;
  }

  /**
   * is bag empty?.
   *
   * @return true or false
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * bag size.
   *
   * @return size
   */
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Bag<String> bag = new Bag<>();
    bag.add("a");
    bag.add("b");
    bag.add("c");

    for (String item : bag) {
      System.out.println(item);
    }
  }
}
