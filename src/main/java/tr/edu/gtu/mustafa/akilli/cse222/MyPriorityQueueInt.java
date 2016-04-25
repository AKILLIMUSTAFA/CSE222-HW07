package tr.edu.gtu.mustafa.akilli.cse222;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   MyPriorityQueueInt
 *
 * Description:
 *
 * This is Priority Queue interface
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public interface MyPriorityQueueInt<E> {

    /**
     * insert an item into the priority queue.
     * pre The ArrayList theData is in heap order.
     * post The item is in the priority queue and
     *       theData is in heap order.
     * @param item The item to be inserted
     * @throws NullPointerException if the item to be inserted is null.
     * @return if enqueue is successfully than return true, otherwise return false
     */
    boolean enqueue(E item);

    /**
     * Remove an item from the priority queue
     * pre The ArrayList theData is in heap order.
     * post Removed smallest item, theData is in heap order.
     * @return The item with the smallest priority value or null if empty.
     */
    E dequeue();

    /**
     * is Empty Queue
     *
     * @return if queue is empty then return true, otherwise return false
     */
    boolean isEmpty();

    /**
     * Size of Customer
     *
     * @return size of Customer
     */
    int size();

    /**
     * Compare two items using either a Comparator object's compare method
     * or their natural ordering using method compareTo.
     * pre If comparator is null, left and right implement Comparable<E>.
     * @param left One item
     * @param right The other item
     * @return Negative int if left less than right,
     *         0 if left equals right,
     *         positive int if left > right
     * @throws ClassCastException if items are not Comparable
     */
    int compare(E left, E right);
}
