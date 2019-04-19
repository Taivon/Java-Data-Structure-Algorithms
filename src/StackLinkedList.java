import java.util.LinkedList;

public class StackLinkedList {

    private LinkedList<Integer> stack;

    private StackLinkedList() {
        this.stack = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        System.out.println("is list empty? " + stackLinkedList.isEmpty());
        stackLinkedList.push(6);
        stackLinkedList.printStack();

        stackLinkedList.push(7);
        stackLinkedList.printStack();

        stackLinkedList.push(8);
        stackLinkedList.printStack();

        stackLinkedList.push(9);
        stackLinkedList.printStack();

        stackLinkedList.push(10);

        stackLinkedList.printStack();
        System.out.println("pushed 6-10");
        System.out.println("Top of Stack: " + stackLinkedList.top());

        stackLinkedList.push(5);

        stackLinkedList.printStack();


        stackLinkedList.pop();
        stackLinkedList.printStack();

        stackLinkedList.pop();
        stackLinkedList.printStack();

        stackLinkedList.pop();
        stackLinkedList.printStack();

        System.out.println("Top of Stack: " + stackLinkedList.top());


        stackLinkedList.pop();
        stackLinkedList.printStack();

        stackLinkedList.pop();
        stackLinkedList.printStack();

        stackLinkedList.pop();

        System.out.println("is list empty? " + stackLinkedList.isEmpty());
        stackLinkedList.printStack();

    }


    private void push(int key) {
        stack.push(key);
//        O(1)
    }


    private Integer top() {
//        return back item
//        O(n) with no tail
//        O(1) with  tail

        return stack.peek();
    }

    private Integer pop() {
//        O(n)
        Integer element = stack.peek();
        stack.pop();
        return element;
    }

    private Boolean isEmpty() {
//        O(1)
//        empty list?
        return stack.isEmpty();
    }

    private int size() {
//        O(1)
//        empty list?
        return stack.size();
    }

    private void printStack() {

        System.out.println(stack.toString());
    }

}
