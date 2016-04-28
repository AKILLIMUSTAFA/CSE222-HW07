package tr.edu.gtu.mustafa.akilli.cse222;
import tr.edu.gtu.mustafa.akilli.cse222.part1.CustomerComparator;
import tr.edu.gtu.mustafa.akilli.cse222.part1.CustomerPriorityQueue;
import tr.edu.gtu.mustafa.akilli.cse222.part2.UniversityHashTable;

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

    public static void main( String[] args ) throws IOException {

        /* print screen */
        System.out.println("\nTest For Data 1 (Part 1)\n");

        /* Make a comparator */
         CustomerComparator myComparator = new CustomerComparator();
        /*Make a new Priority Queue for Customer */
        CustomerPriorityQueue customerPriorityQueue = new CustomerPriorityQueue("data1.txt",myComparator);

        /* call startTheQueue method for customerPriorityQueue*/
        customerPriorityQueue.startTheQueue();

        /* print screen */
        System.out.println("\nTest For Data 1 (Part 1)\n");

        /* call printServedCustomers method */
        customerPriorityQueue.printServedCustomers();

        /* print screen */
        System.out.println("\nTest For Data 2 (Part 1)\n");

        /*Make a new Priority Queue for Customer */
        CustomerPriorityQueue customerPriorityQueueTwo = new CustomerPriorityQueue("data2.txt",myComparator);

         /* call startTheQueue method for customerPriorityQueueTwo*/
        customerPriorityQueueTwo.startTheQueue();

        /* print screen */
        System.out.println("\nTest For Data 2 (Part 1)\n");

        /* call printServedCustomers method */
        customerPriorityQueueTwo.printServedCustomers();


        /*Random Number Generator
        Random randomGenerator = new Random();
        for (int idx = 1; idx <= 500; ++idx){
            int randomInt = randomGenerator.nextInt(10000);
            System.out.println((randomInt+5000));
        }*/

        /* UniversityHashTable */
        UniversityHashTable universityHashTable = new UniversityHashTable("data500.txt");

        /* print screen */
        System.out.println("\nTest For Data 500 (Part 2)\n");

        /* Average Collusion Number  */
        System.out.println("Average Collusion Number : " + universityHashTable.averageCollisionNumber()+ "\n");

        /* print screen equals */
        if(universityHashTable.equals(2093,8220) == true)
            System.out.println("2093,8220 belongs to the same asistant.(expected)");

        else
            System.out.println("2093,8220 not belongs to the same asistant. (unexpected)");

        /* print screen equals */
        if(universityHashTable.equals(4589,9430) == true)
            System.out.println("4589,9430 belongs to the same asistant.(expected)");

        else
            System.out.println("4589,9430 not belongs to the same asistant. (unexpected)");

        /* print screen equals */
        if(universityHashTable.equals(1453,6645) == true)
            System.out.println("1453,6645 belongs to the same asistant.(unexpected)");

        else
            System.out.println("1453,6645 not belongs to the same asistant. (expected)");

    }
}
