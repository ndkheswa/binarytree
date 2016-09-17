/**
 * Created by ndodakheswa on 2016/09/17.
 */
public class QueueOfInts {

    private static class Node {
        int item;
        Node next;
    }

    private Node head = null;               //Points to first node in the queue.
    private Node tail = null;               //Points to last node in the queue

    //Add N to the back of the queue
    public void queue(int N) {
        Node newTail = new Node();          //A node to hold the new item
        newTail.item = N;
        if (head == null) {
            //The queue eas empty.
            // The new node becomes the only item in the queue
            head = newTail;
            tail = newTail;
        } else {
            //The new node becomes the new tail of the list
            //head is not affected
            tail.next = newTail;
            tail = newTail;
        }
    }

    //Remove from a queue
    public int dequeue() {
        if (head == null)
            throw new IllegalStateException("Cant remove from an empty queue");
        int topItem = head.item;
        head = head.next;                   //The next item now becomes the new head

        if (head == null) {
            //The item that was deleted was the head as well as the tail
            //so now there is no tail
            tail = null;
        }
        return topItem;
    }

    //Return true if the stack is empty
    public boolean isEmpty() {
        return (head == null);
    }
}
