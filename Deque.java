import java.util.Iterator;

public class Deque<T> implements Iterable<T> {

    private Node first, last;
    private int numberOfItems;

    private class Node {
        T item;
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
    public void addFirst(T item) {
        if (item == null) {
            throw new IllegalArgumentException("The item cannot be null");
        }
        else {
            if (this.first == null) {
                Node newNode = new Node();
                this.first = newNode;
                this.first.item = item;
                this.numberOfItems++;
            }
            else {
                if (this.first.next == null) {
                    this.last = this.first;
                }
                Node newNode = new Node();
                newNode.item = item;
                newNode.next = this.first;
                this.first.previous = newNode;
                this.first = newNode;
                this.numberOfItems++;
            }
        }
    }

    // add the item to the back
    public void addLast(T item) {
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
                    this.first.next = this.last;
                    this.numberOfItems++;
                }
                else {
                    Node newNode = new Node();
                    newNode.item = item;
                    newNode.previous = this.last;
                    this.last.next = newNode;
                    this.last = newNode;
                    this.numberOfItems++;
                }
            }
        }
    }

    // remove and return the item from the front
    public T removeFirst() {
        Node nodeToPop = this.first;
        this.first = nodeToPop.next;
        this.first.previous = null;
        this.numberOfItems--;
        return nodeToPop.item;
    }

    // remove and return the item from the back
    public T removeLast() {
        Node nodeToPop = this.last;
        this.last = nodeToPop.previous;
        this.last.next = null;
        this.numberOfItems--;
        return nodeToPop.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return false;
            }

            public T next() {
                return null;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque1 = new Deque<String>();

        deque1.addFirst("my");
        deque1.addLast("name");
        deque1.addLast("is");
        deque1.addFirst("Andy");

        int noOfItems = deque1.numberOfItems;
        boolean empty = deque1.isEmpty();
        deque1.removeFirst();
        deque1.removeLast();

        Iterator<String> iterator1 = deque1.iterator();
        iterator1.hasNext();
        System.out.println(deque1.first.item);
    }

}
