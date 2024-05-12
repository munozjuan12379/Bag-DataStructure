// This program brings in the previously created Node class and uses it to
// create a complete data structure known as the Bag class with multiple methods for completing multiple tasks
// such ass adding nodes, removing nodes (one, all, or the last), searching, printing, etc.
class Node{
    private int data;
    private Node next;
    public Node() {
        data = 0;
        next = null;
    }
    public Node(int d, Node n) {
        data = d;
        next = n;
    }
    public void setData(int d) {
        data = d;
    }
    public void setNext(Node n) {
        next = n;
    }
    public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
}
class Bag{
    private Node first;
    public Bag(){
        first = null;
    }
    public void add(int x) {
        if (first == null){
            first = new Node(x, null);
        }
        else{
            Node t = new Node(x, null);
            t.setNext(first);
            first = t;
        }
    }
    public boolean search (int x){
        boolean found = false;
        Node t = first;
        while (t != null && found == false){
            if (t.getData() == x) {
                found = true;
            }
            t = t.getNext();
        }
        return found;
    }

    public boolean remove (int x){
        if (first == null)
            return false;
        boolean found = false;
        if (first.getData() == x){
            found = true;
            first = first.getNext();
        }
        else{
            Node t = first;
            while (t.getNext() != null && t.getNext().getData() != x){
                t = t.getNext();
            }
            if (t.getNext() == null)
                found = false;
            else {
                found = true;
                t.setNext(t.getNext().getNext());
            }
        }
        return found;
    }
    public void removeAll(){
        first = null;
    }
    public void print(){
        Node t = first;
        while(t != null){
            System.out.println(t.getData());
            t = t.getNext();
        }
    }
    public boolean removeLast(){
        if (first == null)
            return false;
        boolean found = false;
        if (first.getNext() == null){
            found = true;
            first = null;
        }
        else{
            Node t = first;
            while (t.getNext().getNext() != null){
                t = t.getNext();
            }
            found = true;
            t.setNext(null);
        }
        return found;
    }
    public int count(int x){
        int ctr = 0;
        if (first == null)
            return ctr;
        else{
            Node t = first;
            if(t.getData() == x)
                ctr++;
            while(t.getNext() != null){
                t = t.getNext();
                if (t.getData() == x)
                    ctr++;
            }
            return ctr;
        }
    }
    public int size(){
        int ctr = 0;
        if (first == null)
            return ctr;
        else{
            Node t = first;
            while(t.getNext() != null) {
                t = t.getNext();
                ctr++;
            }
            ctr++;
        }
        return ctr;
    }
}
public class Main {
    public static void main(String[] args) {
        // instantiates b as type bag
        Bag b = new Bag();
        // testing the add method by adding three nodes
        /*
        b.add(6);
        b.add(4);
        b.add(1);
        // the next line should print the entire bag
        b.print();
        */
        // testing the search method first with an empty bag, should return false
        //System.out.println(b.search(3));
        // search method on single element bag should return true if it is the correct integer and false
        // if it is looking for an integer not in the bag
         /*
        b.add(1);
        b.print();
        System.out.println(b.search(1));
        System.out.println(b.search(2));
         */
        // search method on multi element bag
         /*
        b.add(1);
        b.add(3);
        b.add(5);
        b.print();
        // next two lines should return true and then false
        System.out.println(b.search(5));
        System.out.println(b.search(7));
         */
        // testing the remove method on an empty bag
        // next line should return false
        //System.out.println(b.remove(5));
        // testing remove method on single element bag
        /*
        b.add(3);
        // next two lines should return false then true and then false
        System.out.println(b.remove(3));
        System.out.println(b.remove(5));
        */
        // testing remove method on multi element bag
        /*
        b.add(3);
        b.add(5);
        b.add(7);
        b.print();
        // next lines should remove 5, return true, and then afterwards
        // the next line will print the bag with elements 7 and 3 leftover
        System.out.println(b.remove(5));
        b.print();
        */
        // testing removeAll method with empty bag
        // b.removeAll();
        // testing removeAll method with single element bag
        /*
        b.add(5);
        b.removeAll();
        // next line should print nothing since the bag will be empty
        b.print();
        */
        // testing removeAll method with multi element bag
        // print should not show anything again
        /*
        b.add(5);
        b.add(7);
        b.add(9);
        b.removeAll();
        b.print();
        */
        // print method has been tested multiple times already but here is a quick test
        /*
        b.add(8);
        b.add(9);
        b.print();
        */
        // testing removeLast method with an empty bag should return false
        // System.out.println(b.removeLast());
        // testing removeLast method with a single element bag should return true
        /*
        b.add(9);
        System.out.println(b.removeLast());
        // next line should print an empty bag
        b.print();
         */
        // testing removeLast on a multi element bag
        /*
        b.add(9);
        b.add(10);
        b.add(6);
        // this next line should return true and only get rid of the 9,
        // the line after has a print method that will show a 6 and 10
        System.out.println(b.removeLast());
        b.print();
         */
        // testing size method with an empty bag should return value of 0
        // System.out.println(b.size());
        // testing size method with a single element bag should return a value of 1
        /*
        b.add(8);
        System.out.println(b.size());
        */
        // testing size method with a multi element bag should return the proper value
        // in this case it should return 3
        /*
        b.add(5);
        b.add(3);
        b.add(7);
        System.out.println(b.size());
        */
        // testing count method with an empty bag should always return 0
        /*
        System.out.println(b.count(0));
        System.out.println(b.count(5));
        */
        // testing count method with a single element bag should return 1
        // if the value is in the bag and otherwise return 0
        /*
        b.add(7);
        // next two lines should print 1 and then 0 because 7 is here and 3 is not
        System.out.println(b.count(7));
        System.out.println(b.count(3));
        */
        // testing count method with a multi element bag with
        /*
        b.add(8);
        b.add(8);
        b.add(5);
        b.add(17);
        // next line will print bag contents
        b.print();
        // next line should print 1 because 17 is in the bag
        System.out.println(b.count(17));
        // next line should print 2 because there are two 8's in the bag
        System.out.println(b.count(8));
        // next line should print 0 since 7 is not in the bag
        System.out.println(b.count(7));
        */
    }
}
