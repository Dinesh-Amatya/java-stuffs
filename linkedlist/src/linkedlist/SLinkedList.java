package linkedlist;

/**
 * Created by damatya on 4/7/17.
 *
 * @email dinesh.man.amatya@gmail.com
 */

public class SLinkedList {
    private int size = 0;
    private Node head = null;
    private Node tail = null;


    public void add(int element) {
        Node newest = new Node(element, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    /**
     * Removes the last element from the linked list
     * @return
     */
    public int removeLast() {

        if (head.getNext() == null) {
            int data = head.getElement();
            head = null;
            return data;
        }

        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        int data = current.getNext().getElement();
        current.setNext(null);
        tail = current;
        size--;
        return data;

    }

    /**
     * removes the elements whose value is greater than targetValue
     * @param targetValue
     */
    public void clear(int targetValue) {

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.getElement() > targetValue) // element found
            {
                if (prev == null) // for head
                {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                size--;

            }

            prev = current;
            current = current.getNext();
        }


    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int last() {
        if (isEmpty()) return 0;
        return tail.getElement();
    }



    @Override
    public String toString() {
        Node current = head;

        String value = "[";
        while (current.getNext() != null) {
            value += current.getElement() + ",";
            current = current.getNext();
        }
        value = value.substring(0,value.length()-1)+"]";
        return value;
    }

    // node class
    public static class Node {
        private int element;
        private Node next;

        public Node(int element, Node node) {
            this.element = element;
            this.next = node;
        }

        public int getElement() {
            return element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        SLinkedList singlyLinkedList = new SLinkedList();

        singlyLinkedList.add(12);
        singlyLinkedList.add(13);
        singlyLinkedList.add(14);
        singlyLinkedList.add(14);
        singlyLinkedList.add(15);
        singlyLinkedList.add(16);


        System.out.println(singlyLinkedList.removeLast() + " removed ");
        ;
        System.out.println("last element::"+singlyLinkedList.last());

        singlyLinkedList.clear(13);

        System.out.println("list values::"+singlyLinkedList);

    }
}