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
    public static final int TWENTY_HOUR = 1200;

    public static void main( String[] args ) throws FileNotFoundException {

        /*Make a new Priority Queue for Customer */
        MyPriorityQueue<Customer> customerPriorityQueue = new MyPriorityQueue<Customer>(new CustomerComparator());

        File inFile = new File("data1.txt"); /* Txt */
        int arrivalTimeHour; /* Customer Arrival Time Hour */
        int arrivalTimeMinute; /* Customer Arrival Time Minute */
        int transactionDurationMinute;  /* Customer Transaction Duration Hour */
        int customerType; /* Customer Type */
        int index; /* index for loops */
        Customer temp;

        Scanner sc = new Scanner(inFile);
        String line = sc.nextLine();/*Pass the first line */

        /* Until End of the file */
        while (sc.hasNextLine()) {
            /* Take the line */
            line = sc.nextLine();

            /* Find arrivalTimeHour and arrivalTimeMinute */
            arrivalTimeHour = (Integer.parseInt(String.valueOf((line.charAt(0)))) * 10) + Integer.parseInt(String.valueOf(line.charAt(1)));
            arrivalTimeMinute = (Integer.parseInt(String.valueOf(line.charAt(3))) * 10) + Integer.parseInt(String.valueOf(line.charAt(4)));

            /* Pass the spaces */
            for (index = 5; index < line.length(); ++index) {
                if (line.charAt(index) != ' ')
                    break;
            }

            /* Find transactionDurationMinute */
            transactionDurationMinute = (Integer.parseInt(String.valueOf(line.charAt(index))) * 10) + Integer.parseInt(String.valueOf(line.charAt(index + 1)));

            /* Pass the spaces */
            for (index = index + 2; index < line.length(); ++index) {
                if (line.charAt(index) != ' ')
                    break;
            }

            /* Pass the customer word and space */
            for (index = index; index < line.length(); ++index) {
                if (line.charAt(index) == ' ')
                    break;
            }

            /* Find customerType */
            customerType = Integer.parseInt(String.valueOf(line.charAt(index + 1)));

            /* Add element in The Queue */
            customerPriorityQueue.enqueue(new Customer(arrivalTimeHour * 60 + arrivalTimeMinute, transactionDurationMinute, customerType, 0));
        }
        /* Close the file */
        sc.close();

        /* Test scenario 1 */
        System.out.println("Test Scenario For data1.txt. Customers sequence: \n");

        /* Print all element*/
        while ((temp = customerPriorityQueue.dequeue()) != null)
            System.out.println(temp.toString());

        /* Print starts */
        System.out.println("\n************************************************\n");


        /*Make a new Priority Queue for Customer */
        customerPriorityQueue = new MyPriorityQueue<Customer>(new CustomerComparator());

        inFile = new File("data2.txt"); /* Txt */
        int goldenCustomerNumber = 0;
        int silverCustomerNumber = 0;
        int bronzCustomerNumber = 0;
        int checkFirstLine = 1;
        int oldArrivalTime = 0;

        sc = new Scanner(inFile);
        line = sc.nextLine();/*Pass the first line */

        /* Until End of the file */
        while (sc.hasNextLine()) {
            /* Take the line */
            line = sc.nextLine();

            /* Find arrivalTimeHour and arrivalTimeMinute */
            arrivalTimeHour = (Integer.parseInt(String.valueOf((line.charAt(0)))) * 10) + Integer.parseInt(String.valueOf(line.charAt(1)));
            arrivalTimeMinute = (Integer.parseInt(String.valueOf(line.charAt(3))) * 10) + Integer.parseInt(String.valueOf(line.charAt(4)));

            /* if first line in file */
            if(checkFirstLine == 1){

                /* Make oldArrivalTime current ArrivalTime */
                oldArrivalTime = arrivalTimeHour*60 + arrivalTimeMinute;

                /* Make 0 checkFirstLine */
                checkFirstLine = 0;
            }


            /* Pass the spaces */
            for (index = 5; index < line.length(); ++index) {
                if (line.charAt(index) != ' ')
                    break;
            }

            /* Find transactionDurationMinute */
            transactionDurationMinute = (Integer.parseInt(String.valueOf(line.charAt(index))) * 10) + Integer.parseInt(String.valueOf(line.charAt(index + 1)));

            /* Pass the spaces */
            for (index = index + 2; index < line.length(); ++index) {
                if (line.charAt(index) != ' ')
                    break;
            }

            /* Pass the customer word and space */
            for (index = index; index < line.length(); ++index) {
                if (line.charAt(index) == ' ')
                    break;
            }

            /* Find customerType */
            customerType = Integer.parseInt(String.valueOf(line.charAt(index + 1)));

            /* increase for the customer type number */
            switch (customerType){

                case 1:++goldenCustomerNumber;break;
                case 2:++silverCustomerNumber;break;
                case 3:++bronzCustomerNumber;break;
            }

            /* Add element in The Queue */
            customerPriorityQueue.enqueue(new Customer(arrivalTimeHour * 60 + arrivalTimeMinute, transactionDurationMinute, customerType, 0));

            /* Report Of Twenty Hours */
            /* Check for print */
            if( ( arrivalTimeHour*60 +arrivalTimeMinute )-(oldArrivalTime) >= TWENTY_HOUR){

                /* Make oldArrivalTime current ArrivalTime */
                oldArrivalTime = arrivalTimeHour*60+arrivalTimeMinute;

                /* Test scenario 2 */
                System.out.println("Test Scenario For data2.txt. Customers Report: \n");

                /* Print statistics */
                System.out.println("Golden Customer: " + goldenCustomerNumber);
                System.out.println("Silver Customer: " + silverCustomerNumber);
                System.out.println("Bronz Customer: " + bronzCustomerNumber);

                /* Reset */
                goldenCustomerNumber = 0;
                silverCustomerNumber = 0;
                bronzCustomerNumber = 0;

                /* Print starts */
                System.out.println("\n************************************************\n");
            }
        }
        /* Close the file */
        sc.close();

    }
}
