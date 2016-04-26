package tr.edu.gtu.mustafa.akilli.cse222;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   CustomerPriorityQueue
 *
 * Description:
 *
 * This is CustomerComparator Class for customers.
 *
 * @author Mustafa_Akilli
 * @since Sunday 26 April 2016 by Mustafa_Akilli
 */
public class CustomerPriorityQueue {

    /* Priority Queue to hold the data */
    private MyPriorityQueue<Customer> priorityQueue;
    /* Data File Name */
    private String dataFileName;
    /* An optional reference to a Comparator object. */
    private Comparator<Customer> comparator = null;
    /* Served Customer List*/
    private ArrayList<Customer> servedCustomersList;
    /* Current Customer Informations */
    private int currentArrivalTimeHour;
    private int currentArrivalTimeMinute;
    private int currentTransactionDurationMinute;
    private int currentCustomerType;
    private int oldTime;
    /* For The statistics */
    private int goldenCustomerNumber;
    private int silverCustomerNumber;
    private int bronzCustomerNumber;

    private static final int TWENTY_HOUR = 1200;
    private static final int START_CUSTOMER_NUMBER = 0;

    /**
     * Two Parameter Constructor for CustomerPriorityQueue
     *
     * @param newDataFileName contains customers's information
     * @param newComparator for compare to elements
     */
    public CustomerPriorityQueue(String newDataFileName, Comparator<Customer> newComparator) {
        setDataFileName(newDataFileName);
        setComparator(newComparator);
        setPriorityQueue(getComparator());
        setServedCustomersList();
        setGoldenCustomerNumber(START_CUSTOMER_NUMBER);
        setSilverCustomerNumber(START_CUSTOMER_NUMBER);
        setBronzCustomerNumber(START_CUSTOMER_NUMBER);
    }

    /**
     * Get Priority Queue
     *
     * @return priorityQueue
     */
    private MyPriorityQueue getPriorityQueue() {
        return priorityQueue;
    }

    /**
     * Set Priority Queue
     */
    private void setPriorityQueue(Comparator<Customer> newComparator) {
        this.priorityQueue = new MyPriorityQueue(newComparator);
    }

    /**
     * Get Data File Name
     *
     * @return Data File Name
     */
    private String getDataFileName() {
        return dataFileName;
    }

    /**
     * Set Data File Name
     *
     * @param newDataFileName
     */
    private void setDataFileName(String newDataFileName) {
        this.dataFileName = newDataFileName;
    }

    /**
     * Get Comparator
     *
     * @return Comparator
     */
    private Comparator<Customer> getComparator() {
        return comparator;
    }

    /**
     * Set Comparator
     *
     * @param newComparator
     */
    private void setComparator(Comparator<Customer> newComparator) {
        this.comparator = newComparator;
    }

    /**
     * Get Served Customers List
     *
     * @return Served Customers List
     */
    private ArrayList<Customer> getServedCustomersList() {
        return servedCustomersList;
    }

    /**
     * Set Served Customers List
     */
    private void setServedCustomersList() {
        this.servedCustomersList = new ArrayList<Customer>();
    }

    /**
     * Get Old Time
     *
     * @return Old Time
     */
    private int getOldTime() {
        return oldTime;
    }

    /**
     * Set Old Time
     *
     * @param newOldTime
     */
    private void setOldTime(int newOldTime) {
        this.oldTime = newOldTime;
    }

    /**
     * Get Golden Customer Number
     *
     * @return Golden Customer Number
     */
    private int getGoldenCustomerNumber() {
        return goldenCustomerNumber;
    }

    /**
     * Set Golden Customer Number
     *
     * @param goldenCustomerNumber
     */
    private void setGoldenCustomerNumber(int goldenCustomerNumber) {
        this.goldenCustomerNumber = goldenCustomerNumber;
    }

    /**
     * Get Silver Customer Number
     *
     * @return Silver Customer Number
     */
    private int getSilverCustomerNumber() {
        return silverCustomerNumber;
    }

    /**
     * Set Silver Customer Number
     *
     * @param silverCustomerNumber
     */
    private void setSilverCustomerNumber(int silverCustomerNumber) {
        this.silverCustomerNumber = silverCustomerNumber;
    }

    /**
     * Get Bronz Customer Number
     *
     * @return
     */
    private int getBronzCustomerNumber() {
        return bronzCustomerNumber;
    }

    /**
     * Set Bronz Customer Number
     *
     * @param bronzCustomerNumber
     */
    private void setBronzCustomerNumber(int bronzCustomerNumber) {
        this.bronzCustomerNumber = bronzCustomerNumber;
    }

    /**
     * Take the data file and handle it.
     *
     * @throws FileNotFoundException
     */
    public void startTheQueue() throws FileNotFoundException {

        /*Make a new Priority Queue for Customer */
        MyPriorityQueue<Customer> customerPriorityQueue = new MyPriorityQueue<Customer>(new CustomerComparator());

        Customer tempCustomer;

        File inFile = new File(getDataFileName()); /* Txt */
        int currentTime = 0;
        boolean firstCustomer = true;

        Scanner sc = new Scanner(inFile);
        String line = sc.nextLine();/*Pass the first line */

        /* Until End of the file */
        while (sc.hasNextLine()) {

            /* Take the line */
            line = sc.nextLine();

            /* İf first time come a customer */
            if (firstCustomer) {

                /* Merge the line */
                mergeTheString(line);

                /* Start current Time */
                currentTime = (currentArrivalTimeHour * 60 + currentArrivalTimeMinute) + currentTransactionDurationMinute;

                /* Make a Customer */
                tempCustomer = new Customer((currentArrivalTimeHour * 60 + currentArrivalTimeMinute),
                        currentTransactionDurationMinute,currentCustomerType,0);
                /* Add element in the Served Customers List */
                getServedCustomersList().add(tempCustomer);
                /* Set Old Time */
                setOldTime(currentTime);
                firstCustomer = false;
            } else {

                /* Print The Report */
                printTheReport(currentTime);

                /* Merge the line */
                mergeTheString(line);

                /* İf process not continuation */
                if (currentTime < (currentArrivalTimeHour * 60 + currentArrivalTimeMinute))
                    if ((tempCustomer = customerPriorityQueue.dequeue()) != null){
                        currentTime = (tempCustomer.getArrivalTime()) + tempCustomer.getTransactionDuration();
                        getServedCustomersList().add(tempCustomer);
                    }

                /* Add element in the queue */
                customerPriorityQueue.enqueue(new Customer(currentArrivalTimeHour * 60 + currentArrivalTimeMinute,
                        currentTransactionDurationMinute, currentCustomerType, 0));
            }
        }

        /* Dequeue all rest of elements */
        while ((tempCustomer = customerPriorityQueue.dequeue()) != null){
            getServedCustomersList().add(tempCustomer);
        }

        /* Close the file */
        sc.close();
    }

    /**
     * Merge The Given String for Current Customer
     *
     * @param line will merge
     */
    private void mergeTheString(String line) {

        int index; /* index for loops */

        /* Find arrivalTimeHour and arrivalTimeMinute */
        currentArrivalTimeHour = (Integer.parseInt(String.valueOf((line.charAt(0)))) * 10) + Integer.parseInt(String.valueOf(line.charAt(1)));
        currentArrivalTimeMinute = (Integer.parseInt(String.valueOf(line.charAt(3))) * 10) + Integer.parseInt(String.valueOf(line.charAt(4)));

        /* Pass the spaces */
        for (index = 5; index < line.length(); ++index) {
            if (line.charAt(index) != ' ')
                break;
        }

        /* Find transactionDurationMinute */
        currentTransactionDurationMinute = (Integer.parseInt(String.valueOf(line.charAt(index))) * 10) + Integer.parseInt(String.valueOf(line.charAt(index + 1)));

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
        currentCustomerType = Integer.parseInt(String.valueOf(line.charAt(index + 1)));

    }

    /**
     * Print The Report
     *
     * @param currentTime
     */
    private void printTheReport(int currentTime){

        /* İf TWENTY_HOUR past */
        if(currentTime - getOldTime() >= TWENTY_HOUR ){

            System.out.println("\nTest For Data 2\n");

            /* Print The Array */
            for (int index =0; index < getServedCustomersList().size() ;++index){
                System.out.println(getServedCustomersList().get(index).toString());
                increaseCustomerNumber(getServedCustomersList().get(index).getCustomerType());
            }

            System.out.println("*****************************************************");
            System.out.println("Golden Customer Number: " + getGoldenCustomerNumber());
            System.out.println("Silver Customer Number: " + getSilverCustomerNumber());
            System.out.println("Bronz Customer Number: " + getBronzCustomerNumber());
            System.out.println("*****************************************************");

            /* Delete All Array */
            getServedCustomersList().clear();

            /* Set new Old Time */
            setOldTime(currentTime);
        }
    }

    /**
     * İncrease The Customer Number which served
     *
     */
    private void increaseCustomerNumber(int customerType){

        /* İncrease appropriate number */
        switch (customerType){
            case 1: setGoldenCustomerNumber(getGoldenCustomerNumber()+1);break;
            case 2: setSilverCustomerNumber(getSilverCustomerNumber()+1);break;
            case 3: setBronzCustomerNumber(getBronzCustomerNumber()+1);break;
        }
    }

    /**
     * Print Served Customers
     */
    public void printServedCustomers(){
        /* Print The Array */
        for (int index =0; index < getServedCustomersList().size() ;++index){
            System.out.println(getServedCustomersList().get(index).toString());
        }
    }
}
