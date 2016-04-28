package tr.edu.gtu.mustafa.akilli.cse222.part1JunitTest;

import junit.framework.TestCase;
import tr.edu.gtu.mustafa.akilli.cse222.part1.Customer;
import tr.edu.gtu.mustafa.akilli.cse222.part1.CustomerComparator;
import tr.edu.gtu.mustafa.akilli.cse222.part1.MyPriorityQueue;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   MyPriorityQueueTest
 *
 * Description:
 *
 * This is MyPriorityQueue Test
 *
 * @author Mustafa_Akilli
 * @since Monday 25 April 2016 by Mustafa_Akilli
 */
public class MyPriorityQueueTest extends TestCase {

    public void testEnqueue() throws Exception {
        CustomerComparator myComparator = new CustomerComparator();
        MyPriorityQueue<Customer> myPriorityQueue = new MyPriorityQueue<Customer>(myComparator);
        boolean result;

        Customer firstCustomer = new Customer(40, 8, 3, 0);
        Customer secondCustomer = new Customer(45, 2, 1, 0);
        Customer thirdCustomer = new Customer(35, 5, 2, 0);

        myPriorityQueue.enqueue(firstCustomer);
        myPriorityQueue.enqueue(secondCustomer);
        myPriorityQueue.enqueue(thirdCustomer);

        if (1 == myPriorityQueue.dequeue().getCustomerType())
            result = true;
        else
            result = false;

        assertEquals(true, result);

        if (2 == myPriorityQueue.dequeue().getCustomerType())
            result = true;
        else
            result = false;

        assertEquals(true, result);

        if (3 == myPriorityQueue.dequeue().getCustomerType())
            result = true;
        else
            result = false;

        assertEquals(true, result);
    }

    public void testDequeue() throws Exception {

        CustomerComparator myComparator = new CustomerComparator();
        MyPriorityQueue<Customer> myPriorityQueue = new MyPriorityQueue<Customer>(myComparator);
        boolean result;

        Customer firstCustomer = new Customer(20, 7, 3, 0);
        Customer secondCustomer = new Customer(26, 20, 1, 0);
        Customer thirdCustomer = new Customer(23, 6, 2, 0);
        Customer fourthCustomer = new Customer(23, 7, 2, 0);

        myPriorityQueue.enqueue(firstCustomer);
        myPriorityQueue.enqueue(secondCustomer);
        myPriorityQueue.enqueue(thirdCustomer);
        myPriorityQueue.enqueue(fourthCustomer);

        if (1 == myPriorityQueue.dequeue().getCustomerType())
            result = true;
        else
            result = false;

        assertEquals(true, result);

        if (6 == myPriorityQueue.dequeue().getTransactionDuration())
            result = true;
        else
            result = false;

        assertEquals(true, result);

        if (7 == myPriorityQueue.dequeue().getTransactionDuration())
            result = true;
        else
            result = false;

        assertEquals(true, result);

        if (3 == myPriorityQueue.dequeue().getCustomerType())
            result = true;
        else
            result = false;

        assertEquals(true, result);
    }

    public void testIsEmpty() throws Exception {
        CustomerComparator myComparator = new CustomerComparator();
        MyPriorityQueue<Customer> myPriorityQueue = new MyPriorityQueue<Customer>(myComparator);
        Customer firstCustomer = new Customer(20, 7, 3, 0);

        assertEquals(true,myPriorityQueue.isEmpty());
        myPriorityQueue.enqueue(firstCustomer);
        assertEquals(false,myPriorityQueue.isEmpty());
    }

    public void testSize() throws Exception {
        CustomerComparator myComparator = new CustomerComparator();
        MyPriorityQueue<Customer> myPriorityQueue = new MyPriorityQueue<Customer>(myComparator);
        Customer firstCustomer = new Customer(20, 7, 3, 0);

        boolean result;

        if(0 == myPriorityQueue.size())
            result = true;
        else
            result = false;

        assertEquals(true,result);

        myPriorityQueue.enqueue(firstCustomer);

        if(1 == myPriorityQueue.size())
            result = true;
        else
            result = false;

        assertEquals(true,result);
    }

    public void testCompare() throws Exception {
        CustomerComparator myComparator = new CustomerComparator();
        MyPriorityQueue<Customer> myPriorityQueue = new MyPriorityQueue<Customer>(myComparator);
        Customer firstCustomer = new Customer(20, 7, 2, 0);
        Customer secondCustomer = new Customer(20, 7, 3, 0);
        boolean result;

        if(0 == myPriorityQueue.compare(firstCustomer,firstCustomer))
            result = true;
        else
            result = false;

        assertEquals(true,result);

        if(myPriorityQueue.compare(firstCustomer,secondCustomer) > 0)
            result = true;
        else
            result = false;

        assertEquals(true,result);

        if(myPriorityQueue.compare(secondCustomer,firstCustomer) < 0)
            result = true;
        else
            result = false;

        assertEquals(true,result);
    }
}