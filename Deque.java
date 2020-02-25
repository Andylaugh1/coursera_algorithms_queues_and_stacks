/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int numberOfItems;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.numberOfItems = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        }
        else {
            return false;
        }
    }

    // return the number of items on the deque
    public int size() {
        return this.numberOfItems;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The item cannot be null");
        }
        else {
            if (this.first == null) {
                this.first.item = item;
                this.numberOfItems++;
            }
            else {
                Node newNext = this.first;
                newNext.previous = this.first;
                this.first.item = item;
                this.first.next = newNext;
                this.numberOfItems++;
            }
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The item cannot be null");
        }
        else {
            if (this.last == null) {
            }
        }
    }

    // remove and return the item from the front
    public Item removeFirst()

    // remove and return the item from the back
    public Item removeLast()

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}
