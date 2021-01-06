import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }    

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {

        return size == 0;
    }

    // return the number of items on the deque
    public int size() {

        return size;
    }

    private void add(Item item, boolean fromFront) {

        if (item == null) {

            throw new IllegalArgumentException();
        }

        Node old = fromFront ? first : last;

        Node newNode = new Node();
        newNode.item = item;

        if (fromFront) {

            newNode.next = old;

            first = newNode;
            if (old == null) {

                last = first;
            } else {
                old.prev = first;
            }
        } else {

            last = newNode;
            if (old != null) {

                old.next = last;
                last.prev = old;
            } else {

                first = last;
            }
        }

        size++;
    }

    // add the item to the front
    public void addFirst(Item item) {

        add(item, true);
    }

    // add the item to the back
    public void addLast(Item item) {

        add(item, false);
    }

    private Item remove(boolean fromFront) {

        if (isEmpty()) {

            throw new NoSuchElementException();
        }

        Item item = fromFront ? first.item : last.item;

        if (fromFront) {

            first = first.next;
            if (first == null) {

                last = null;
            } else {

                first.prev = null;
            }
        } else {

            last = last.prev;

            if (last == null) {

                first = null;
            } else {

                last.next = null;
            }
        }

        size--;

        return item;
    }

    // remove and return the item from the front
    public Item removeFirst() {

        return remove(true);
    }

    // remove and return the item from the back
    public Item removeLast() {

        return remove(false);
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {

        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<String> dq = createTestCase();

        Iterator<String> strItr1 = dq.iterator();
        Iterator<String> strItr2 = dq.iterator();

        while (strItr1.hasNext()) {

            System.out.print(strItr1.next() + " ");
        }
        
        while (strItr2.hasNext()) {

            System.out.print(strItr2.next() + " ");
        }

        dq = createTestCase();

        System.out.println();
        while (!dq.isEmpty()) {
            System.out.print(dq.removeFirst() + " ");
            System.out.print(dq.removeLast() + " ");
        }
    }

    private static Deque<String> createTestCase() {

        Deque<String> dq = new Deque<String>();
        String[] str = { "C", "D", "E", "B", "A", "F" };

        boolean isFront = true;
        boolean added = false;

        for (String s : str) {

            boolean isFnt = added ? !isFront : isFront;

            if (isFnt) {

                dq.addFirst(s);
            } else {

                dq.addLast(s);
            }

            isFront = isFnt;
            added = !added;
        }

        return dq;
    }
    
    private class DequeIterator implements Iterator<Item> {
        
    	Node current = first;
        @Override
        public boolean hasNext() {

            return current != null;
        }

        @Override
        public Item next() {

            if (!hasNext()) {

                throw new NoSuchElementException();
            }
            
            Item item = current.item;
            current = current.next;
            
            return item;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException();
        }
    }

}
