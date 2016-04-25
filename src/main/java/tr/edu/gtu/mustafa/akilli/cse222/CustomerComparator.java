package tr.edu.gtu.mustafa.akilli.cse222;

import java.util.Comparator;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   MyPriorityQueueInt
 *
 * Description:
 *
 * This is CustomerComparator Class for customers.
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class CustomerComparator implements Comparator<Customer> {

    /**
     * Compare two element
     *
     * @param leftCustomer the first Customer to be compared.
     * @param rightCustomer the second Customer to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is not priority than, equal to, or priority than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     */
    public int compare(Customer leftCustomer, Customer rightCustomer) throws NullPointerException{
        if(leftCustomer == null || rightCustomer == null)
            throw new NullPointerException();

        /* If left Customer type priority than right Customer return positive integer */
        if(rightCustomer.getCustomerType() < leftCustomer.getCustomerType())
            if((rightCustomer.getArrivalTime()) -
                    (leftCustomer.getArrivalTime()+leftCustomer.getTransactionDuration()) != 0)
                return  (rightCustomer.getArrivalTime()) -
                    (leftCustomer.getArrivalTime()+leftCustomer.getTransactionDuration());

            else
                return rightCustomer.getCustomerType() - leftCustomer.getCustomerType();

        /* If left Customer type priority than right Customer return positive integer */
        if(leftCustomer.getCustomerType() < rightCustomer.getCustomerType())
            if((rightCustomer.getArrivalTime()+rightCustomer.getTransactionDuration()) - (leftCustomer.getArrivalTime()) != 0)
                return  (rightCustomer.getArrivalTime()+rightCustomer.getTransactionDuration()) - (leftCustomer.getArrivalTime());

            else
                return rightCustomer.getCustomerType() - leftCustomer.getCustomerType();

        /* If left Customer type equal to right Customer*/
        else {
            if((rightCustomer.getArrivalTime()+rightCustomer.getTransactionDuration()) -
                    (leftCustomer.getArrivalTime()+leftCustomer.getTransactionDuration()) != 0)
                return (rightCustomer.getArrivalTime()+rightCustomer.getTransactionDuration()) -
                        (leftCustomer.getArrivalTime()+leftCustomer.getTransactionDuration());
            else
                return rightCustomer.getArrivalTime() - leftCustomer.getArrivalTime();
        }
    }
}
