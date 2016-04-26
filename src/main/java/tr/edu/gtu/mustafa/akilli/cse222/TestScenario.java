package tr.edu.gtu.mustafa.akilli.cse222;
import java.util.Scanner;
import java.io.*;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   TestScenario
 *
 * Description:
 *
 * Test Scenario for HW07
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class TestScenario
{

    public static void main( String[] args ) throws FileNotFoundException {

        /* Make a comparator */
         CustomerComparator myComparator = new CustomerComparator();
        /*Make a new Priority Queue for Customer */
        CustomerPriorityQueue customerPriorityQueue = new CustomerPriorityQueue("data1.txt",myComparator);

        /* call startTheQueue method for customerPriorityQueue*/
        customerPriorityQueue.startTheQueue();

        /* print screen */
        System.out.println("\nTest For Data 1\n");

        /* call printServedCustomers method */
        customerPriorityQueue.printServedCustomers();

        /*Make a new Priority Queue for Customer */
        CustomerPriorityQueue customerPriorityQueueTwo = new CustomerPriorityQueue("data2.txt",myComparator);

         /* call startTheQueue method for customerPriorityQueueTwo*/
        customerPriorityQueueTwo.startTheQueue();
    }
}
