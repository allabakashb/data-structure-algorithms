//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class RandomizedQueue<Item> implements Iterable<Item> {
//
//    private Item[] items;
//    private int[] indices;
//    private int size;
//    private int[] samples;
//    private int smSz;
//        
//    // construct an empty randomized queue
//    public RandomizedQueue() {
//        
//        resizeArray(1);
//    }
//
////    private int getRandomIndex(int sz) {
////        
////        return StdRandom.uniform(sz);
////    }
//    
//    // is the randomized queue empty?
//    public boolean isEmpty() {
//        
//        return size == 0;
//    }
//
//    // return the number of items on the randomized queue
//    public int size() {
//        
//        return size;
//    }
//
//    // add the item
//    public void enqueue(Item item) {
//        
//        if (item == null) {
//        
//            throw new IllegalArgumentException();
//        }
//        
//        if (size == items.length) {
//            
//            resizeArray(items.length * 2);
//        }
//        
//        int ind = size++;
//        items[ind] = item;
//        indices[ind] = ind;
//        samples[ind] = ind;
//        resetSamples();
//    }
//
//    // remove and return a random item
//    public Item dequeue() {
//        
//        if (isEmpty()) {
//            
//            throw new NoSuchElementException();
//        }
//        
//        int index = getRandomIndex(size);
//        Item item = items[indices[index]];
//        
//        --size;
//        
//        if (indices[index] != size) {
//            
//            items[indices[index]] = items[size];
//            items[size] = null;
//        }
//        
//        items[size] = null;
//        if (size > 0 && size == items.length/4) {
//            
//            resizeArray(items.length/2);
//        }
//        resetSamples();
//        return item;
//    }
//    
//    private void resizeArray(int length) {
//        
//        Item[] newItems = (Item[]) new Object[length];
//        indices = new int[length];
//        samples = new int[length];
//        
//        for (int i = 0; i < size; i++) {
//            
//            newItems[i] = items[i];
//            indices[i] = i;
//            samples[i] = i;
//        }
//        
//        items = newItems;
//    }
//
//    // return a random item (but do not remove it)
//    public Item sample() {
//        
//        int index = getRandomIndex(smSz);
//        Item item = items[samples[index]];
//        
//        --smSz;
//        
//        if (samples[index] != smSz) {
//            
//            samples[index] = samples[smSz];
//        }
//        
//        return item;
//    }
//
//    // return an independent iterator over items in random order
//    public Iterator<Item> iterator() {
//        
//        return new ArrayIterator();
//    }
//    
//    private void resetSamples() {
//        
//        smSz = size;
//    }
//
//    public static void main(String[] args) {
//        
//        String[] str = { "C", "D", "E", "B", "A", "F" };
//        
//        RandomizedQueue<String> rq = new RandomizedQueue<String>();
//        
//        for (String s: str) {
//            rq.enqueue(s);
//        }
//        
//        int i = 0;
//        
//        while (i < 6) {
//            System.out.print(rq.sample()+" ");
//            i++;
//        }
//        
//        System.out.println("");
//        i = 0;
//        while (i < 6) {
//            System.out.print(rq.dequeue()+" ");
//            i++;
//        }
//        
//    }
//
//
//    private class ArrayIterator implements Iterator<Item> {
//        
//        @Override
//        public boolean hasNext() {
//            
//            return !isEmpty();
//        }
//
//        @Override
//        public Item next() {
//            
//            if (isEmpty()) {
//                
//                throw new NoSuchElementException();
//            }
//            
//            return dequeue();
//        }
//        
//        @Override
//        public void remove() {
//
//            throw new UnsupportedOperationException();
//        }
//    }
//}