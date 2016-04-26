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

        /* If left Customer type priority equal right Customer type */
        if(leftCustomer.getCustomerType() == rightCustomer.getCustomerType()){

            /* If left Customer ArrivalTime priority equal right Customer ArrivalTime */
            if(leftCustomer.getArrivalTime() == rightCustomer.getArrivalTime()){

                /* If left Customer TransactionDuration priority equal right Customer TransactionDuration */
                if(leftCustomer.getTransactionDuration() == rightCustomer.getTransactionDuration())
                    return 0;

                else/* If left Customer TransactionDuration priority than right Customer TransactionDuration return positive integer otherwise return negative*/
                    return rightCustomer.getTransactionDuration() - leftCustomer.getTransactionDuration();

            }

            else/* If left Customer Arrival Time priority than right Customer Arrival Time return positive integer otherwise return negative*/
                return rightCustomer.getArrivalTime() - leftCustomer.getCustomerType();
        }

        else /* If left Customer type priority than right Customer return positive integer otherwise return negative*/
            return rightCustomer.getCustomerType() - leftCustomer.getCustomerType();
    }
}
