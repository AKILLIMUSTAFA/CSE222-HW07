package tr.edu.gtu.mustafa.akilli.cse222;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   MyPriorityQueue
 *
 * Description:
 *
 * This is Priority Queue Class
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class MyPriorityQueue<E> implements MyPriorityQueueInt<E>{

    /** The ArrayList to hold the data. */
    private ArrayList<E> theData;
    /** An optional reference to a Comparator object. */
    private Comparator<E> comparator = null;
    /** Size Of The Data */
    private int sizeOfTheData;
    private static final int START_SIZE = 0;

    /**
     * One parameter Constructor
     *
     * @param newComparator for the compare
     */
    public MyPriorityQueue(Comparator<E> newComparator){
        setTheData();
        setComparator(newComparator);
        setSizeOfTheData(START_SIZE);
    }//end of the One parameter Constructor

    /**
     * Get The Data
     *
     * @return The Data
     */
    private ArrayList<E> getTheData() { return theData; }

    /**
     * Set The Data
     */
    private void setTheData() { this.theData = new ArrayList<E>(); }

    /**
     * Get Comparator
     *
     * @return Comparator
     */
    private Comparator<E> getComparator() { return comparator; }

    /**
     * Set Comparator
     *
     * @param newComparator for the tree
     */
    private void setComparator(Comparator<E> newComparator) {
        this.comparator = newComparator;
    }

    /**
     * Get Size Of The Data
     *
     * @return sizeOfTheData
     */
    public int getSizeOfTheData() {
        return sizeOfTheData;
    }

    /**
     * Set Size Of The Data
     *
     * @param newSizeOfTheData
     */
    public void setSizeOfTheData(int newSizeOfTheData) {
        this.sizeOfTheData = newSizeOfTheData;
    }

    /**
     * Insert an item into the priority queue.
     *
     * @param item The item to be inserted
     * @throws NullPointerException if the item to be inserted is null.
     * pre The ArrayList theData is in heap order.
     * post The item is in the priority queue and
     * theData is in heap order.
     * @return if anqueue is successfully than return true, othewise return false
     */
    public boolean enqueue(E item) {
        //if the item to be inserted is null.
        if (item == null) {
            throw new NullPointerException();
        }

        /* Make a flag */
        boolean flag = false;

        /* Add element appropriate in the array */
        for(int index = 0 ; index < size() && flag == false ;++index)
            if(compare(getTheData().get(index),item) < 0){
                getTheData().add(index,item);
                flag=true;
                setSizeOfTheData(getSizeOfTheData()+1);
            }

        /* Add element en of the array */
        if(flag == false) {
            if (getTheData().add(item) == true) {
                flag = true;
                setSizeOfTheData(getSizeOfTheData() + 1);
            } else
                return false;
        }

        /* return result */
        return true;
    }

    /**
     * Remove an item from the priority queue
     *
     * @return The item with the smallest priority value or null if empty.
     * pre The ArrayList theData is in heap order.
     * post Removed smallest item, theData is in heap order.
     */
    public E dequeue() {
        //if the array is empty.
        if (isEmpty()) {
            return null;
        }

        /* Return the remove element */
        return getTheData().remove(0);
    }

    /**
     * is Empty Queue
     *
     * @return if queue is empty then return true, otherwise return false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Size of Priority Queue
     *
     * @return size of Priority Queue
     */
    public int size() {
        return getTheData().size();
    }

    /**
     * Compare two items using either a Comparator object's compare method
     * or their natural ordering using method compareTo.
     * pre If comparator is null, left and right implement Comparable.
     * @param left One item
     * @param right The other item
     * @return Negative int if left less than right,
     *         0 if left equals right,
     *         positive int if left bigger than right
     * @throws ClassCastException if items are not Comparable
     */
    public int compare(E left, E right) {
        if (getComparator() != null) { // A Comparator is defined.
            return getComparator().compare(left, right);
        } else { // Use left's compareTo method.
            return ((Comparable<E>) left).compareTo(right);
        }
    }
}
