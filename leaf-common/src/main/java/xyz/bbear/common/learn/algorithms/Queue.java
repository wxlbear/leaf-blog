package xyz.bbear.common.learn.algorithms;

import java.util.Iterator;

/**
 * Queue.
 *
 * @author xiongliu wu 2019-05-03 14:42
 */
public class Queue<Item> implements Iterable<Item> {

  private Node first;

  private Node tail;

  private int size;

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
   * enqueue item.
   *
   * @param item item
   */
  public void enqueue(Item item) {
    // 每次放入链表尾部
    Node node = new Node(item, null);
    if (tail == null) {
      tail = node;
      first = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  /**
   * dequeue item.
   *
   * @return Item
   */
  public Item dequeue() {
    if (first == null) {
      throw new RuntimeException("stack is empty");
    }
    Item item = first.item;
    first = first.next;
    size--;
    return item;
  }

  /**
   * queue empty?.
   *
   * @return true or false
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * queue size.
   *
   * @return size
   */
  public int size() {
    return size;
  }

  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public Item next() {
        return null;
      }
    };
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
    }

    while (!queue.isEmpty()) {
      System.out.println(queue.dequeue());
    }
  }
}
