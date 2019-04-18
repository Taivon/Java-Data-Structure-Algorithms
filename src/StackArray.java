public class StackArray {

    private Integer[] stack;
    private int STACK_SIZE;
    private int top;


    private StackArray(int STACK_SIZE) {
        this.STACK_SIZE = STACK_SIZE;
        this.stack = new Integer[this.STACK_SIZE];
        this.top = -1;
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(5);
        System.out.println("is list empty? " + stackArray.isEmpty());
        stackArray.push(6);
        stackArray.printStack();

        stackArray.push(7);
        stackArray.printStack();

        stackArray.push(8);
        stackArray.printStack();

        stackArray.push(9);
        stackArray.printStack();

        stackArray.push(10);

        stackArray.printStack();
        System.out.println("pushed 6-10");
        System.out.println("Top of Stack: " + stackArray.top());

        stackArray.push(5);

        stackArray.printStack();


        stackArray.pop();
        stackArray.printStack();

        stackArray.pop();
        stackArray.printStack();

        stackArray.pop();
        stackArray.printStack();

        System.out.println("Top of Stack: " + stackArray.top());


        stackArray.pop();
        stackArray.printStack();

        stackArray.pop();
        stackArray.printStack();

        stackArray.pop();

        System.out.println("is list empty? " + stackArray.isEmpty());

    }


    private void push(int key) {
//        O(1)
        if (top + 1 >= STACK_SIZE) {
            System.out.println("Stack Overflow, cant push: " + key);
        } else {
            stack[++top] = key;
        }
    }


    private int top() {
//        return back item
//        O(n) with no tail
//        O(1) with  tail
        return stack[top];
    }

    private int pop() {
//        O(n)
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int currTop = top--;
            int x = stack[currTop];
            stack[currTop] = null;
            return x;
        }
    }

    private Boolean isEmpty() {
//        O(1)
//        empty list?
        return top < 0;
    }

    private int size() {
//        O(1)
//        empty list?
        return top + 1;
    }

    private void printStack() {
        StringBuilder stackString = new StringBuilder("BOTTOM");
        for (int i = 0; i < STACK_SIZE; i++) {
            if (stack[i] != null) {
                stackString.append(" | ").append(stack[i]);
            }
        }
        stackString.append(" | TOP");
        System.out.println(stackString);
    }

}
