public class QueueArray {

    private Integer[] queue;
    private int MAX_SIZE;
    private int rear;
    private int front;


    private QueueArray(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.queue = new Integer[this.MAX_SIZE + 1];
        this.rear = -1;
        this.front = -1;
    }

    public static void main(String[] args) {
        QueueArray stackArray = new QueueArray(5);
        System.out.println("is queue empty? " + stackArray.isEmpty());
        stackArray.enqueue(6);
        stackArray.printQueue();

        stackArray.enqueue(7);
        stackArray.printQueue();

        stackArray.enqueue(8);
        stackArray.printQueue();

        stackArray.enqueue(9);
        stackArray.printQueue();

        stackArray.enqueue(10);

        stackArray.printQueue();
        System.out.println("pushed 6-10");
        System.out.println("Front of Queue: " + stackArray.peek());

        stackArray.enqueue(5);

        stackArray.printQueue();


        stackArray.dequeue();
        stackArray.printQueue();

        stackArray.dequeue();
        stackArray.printQueue();

        stackArray.dequeue();
        stackArray.printQueue();

        System.out.println("Front of Queue: " + stackArray.peek());


        stackArray.dequeue();
        stackArray.printQueue();

        stackArray.dequeue();
        stackArray.printQueue();

        stackArray.dequeue();

        System.out.println("is list empty? " + stackArray.isEmpty());

    }


    private void enqueue(int key) {
//        O(1)
        if (isFull()) {
            System.out.println("Stack Overflow, cant enqueue: " + key);
        } else {
            queue[++rear] = key;
        }
    }


    private int peek() {
//        O(1)
        return queue[front + 1];
    }

    private int dequeue() {
//        O(1)
        if (isEmpty()) {
            System.out.println("underflow error");
            return -99;
        } else {
            return queue[++front];
        }
    }

    private Boolean isFull() {
        // O(1)
        return rear == MAX_SIZE - 1;
    }

    private Boolean isEmpty() {
//        O(1)
//        empty list?
        return front + 1 < 0 || front + 1 > rear;
    }

    private int size() {
//        O(1)
//        empty list?
        return rear + 1;
    }

    private void printQueue() {
        //O(n)
        StringBuilder stackString = new StringBuilder("FRONT");
        for (int i = front + 1; i < MAX_SIZE; i++) {
            if (queue[i] != null) {
                stackString.append(" | ").append(queue[i]);
            }
        }
        stackString.append(" | BACK");
        System.out.println(stackString);
    }

}
