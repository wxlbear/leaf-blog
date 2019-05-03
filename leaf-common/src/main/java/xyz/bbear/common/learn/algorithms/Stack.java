package xyz.bbear.common.learn.algorithms;

import java.util.Iterator;

/**
 * Stack.
 *
 * @author xiongliu wu 2019-05-03 14:42
 */
public class Stack<Item> implements Iterable<Item> {

  private Node first;
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
   * push item.
   *
   * @param item item
   */
  public void push(Item item) {
    // 从链表头insert
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    size++;
  }

  /**
   * pop Item.
   *
   * @return Item
   */
  public Item pop() {
    if (first == null) {
      throw new RuntimeException("stack is empty");
    }
    // 删除链表头部的过程
    Item item = first.item;
    first = first.next;
    size--;
    return item;
  }

  /**
   * stack empty?.
   *
   * @return true of false
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * stack size.
   *
   * @return size
   */
  public int size() {
    return size;
  }

  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
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
    };
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < 10; i++) {
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}
