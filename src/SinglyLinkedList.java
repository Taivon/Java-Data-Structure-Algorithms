public class SinglyLinkedList {

    private Node head;
    private Node tail;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("is list empty? " + singlyLinkedList.isEmpty());
        singlyLinkedList.pushBack(6);
        singlyLinkedList.pushBack(7);
        singlyLinkedList.pushBack(8);
        singlyLinkedList.pushBack(9);
        singlyLinkedList.pushBack(10);
        System.out.println("pushed back 6-10");
        System.out.println("Head of list: " + singlyLinkedList.topFront());
        System.out.println("Tail of list: " + singlyLinkedList.topBack());
        singlyLinkedList.printList();

        singlyLinkedList.pushFront(5);
        singlyLinkedList.pushFront(4);
        singlyLinkedList.pushFront(3);
        singlyLinkedList.pushFront(2);
        singlyLinkedList.pushFront(1);
        System.out.println("pushed to front 5 down to 1");
        singlyLinkedList.printList();

        singlyLinkedList.addBefore(singlyLinkedList.head.next, 100);
        System.out.println("added 100 before 2");
        singlyLinkedList.printList();

        singlyLinkedList.addAfter(singlyLinkedList.head.next.next.next.next.next.next.next.next, 33);
        System.out.println("added 33 after 8");
        singlyLinkedList.printList();

        singlyLinkedList.erase(33);
        System.out.println("deleted 33");
        singlyLinkedList.printList();

        singlyLinkedList.erase(100);
        System.out.println("deleted 100");
        singlyLinkedList.printList();

        singlyLinkedList.erase(1);
        System.out.println("deleted first element");
        singlyLinkedList.printList();

        singlyLinkedList.erase(10);
        System.out.println("deleted last element");
        singlyLinkedList.printList();

        System.err.println("is 99 in list? " + singlyLinkedList.findKey(99));
        System.out.println("is list empty? " + singlyLinkedList.isEmpty());

    }

    private void pushFront(int key) {
//        add to front
//        O(1)
        Node node = new Node(key);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private int topFront() {
        //        O(1)
        return head.key;
    }

    private void popFront() throws Exception {
//        remove front item
//        O(1)
        if (this.head == null) {
            throw new Exception("empty list");
        }
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
    }

    private void pushBack(int key) {
//        add to back
//        O(n) with no tail
//        O(1) with tail

//        no tail
//        if (this.head == null) {
//            this.head = new Node(key);
//        }
//        else {
//            Node last = this.head;
//            while (last.next != null) {
//                last = last.next;
//            }
//            last.next = new Node(key);
//        }

        // with tail
        Node node = new Node(key);
        if (tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private int topBack() {
//        return back item
//        O(n) with no tail
//        O(1) with  tail
        return tail.key;
    }

    private void popBack() throws Exception {
//        remove back item
//        O(n) with no tail
//        O(n) with tail
        if (head == null) {
            throw new Exception("empty list");
        }
        if (head == tail) {
            tail = null;
            head = null;
        } else {
            Node newLast = head;
            while (newLast.next.next != null) {
                newLast = newLast.next;
            }
            newLast.next = null;
            tail = newLast;
        }
    }

    private Boolean findKey(int key) {
//        O(n)
//        is key in list

        Node curr = head;
        if (curr.key == key) {
            return true;
        }
        while (curr.next != null) {
            curr = curr.next;
            if (curr.key == key) {
                return true;
            }
        }
        return false;
    }

    private void erase(int key) {
//        O(n)
//        remove key from list
        if (head.key == key) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next.key != key) {
            curr = curr.next;
        }
        if (curr.next == tail) {
            curr.next = null;
            tail = curr;
            return;
        }
        curr.next = curr.next.next;
    }

    private Boolean isEmpty() {
//        O(1)
//        empty list?
        return head == null && tail == null;
    }

    private void addBefore(Node node, int key) {
//        O(n)
//        adds key before node
        Node newNode = new Node(key);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        if (head == tail) {
            newNode.next = head;
            head = newNode;
        } else {
            Node beforeNode = head;
            while (beforeNode.next != node) {
                beforeNode = beforeNode.next;
            }
            beforeNode.next = newNode;
            newNode.next = node;
        }

    }

    private void addAfter(Node node, int key) {
//        O(1)
//        adds key after node
        Node newNode = new Node(key);
        newNode.next = node.next;
        node.next = newNode;
        if (tail == node) {
            tail = newNode;
        }
    }

    private void printList() {
        Node curr = head;
        StringBuilder list = new StringBuilder(String.valueOf(curr.key));

        while (curr != tail) {
            curr = curr.next;
            list.append(" -> ").append(curr.key);
        }
        System.out.println(list);
    }

    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }
}
