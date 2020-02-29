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

                if (newNext.next == null) {
                    this.last = newNext;
                }
            }
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The item cannot be null");
        }
        else {
            if (this.first == null) {
                this.first = new Node() {
                };
                this.first.item = item;
                this.numberOfItems++;
            }
            else {
                if (this.last == null) {
                    this.last = new Node() {
                    };
                    this.last.item = item;
                    this.last.previous = this.first;
                    this.numberOfItems++;
                }
                else {
                    Node newPrevious = this.last;
                    this.last = new Node() {
                    };
                    newPrevious.next = this.last;
                    this.last.item = item;
                    this.last.previous = newPrevious;
                }
            }
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Node nodeToPop = this.first;
        this.first = nodeToPop.next;
        this.first.previous = null;
        return nodeToPop.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        Node nodeToPop = this.last;
        this.last = nodeToPop.previous;
        this.last.next = null;
        return nodeToPop.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            public boolean hasNext() {
                return false;
            }

            public Item next() {
                return null;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Item> deque1 = new Deque<Item>();

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        deque1.addFirst(node1.item);
        deque1.addFirst(node2.item);
        deque1.addLast(node3.item);

        int noOfItems = deque1.numberOfItems;
    }

}
